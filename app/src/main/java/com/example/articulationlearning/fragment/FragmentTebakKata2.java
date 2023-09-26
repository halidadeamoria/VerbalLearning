package com.example.articulationlearning.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.articulationlearning.ActivityTebakKata;
import com.example.articulationlearning.R;
import com.example.articulationlearning.RightAnswerActivity;
import com.example.articulationlearning.adapter.TebakKataAnswerAdapter;
import com.example.articulationlearning.adapter.TebakKataOptionAdapter;
import com.example.articulationlearning.databinding.FragmentTebakKata1Binding;
import com.example.articulationlearning.databinding.FragmentTebakKata2Binding;
import com.example.articulationlearning.model.TebakKataModel;
import com.example.articulationlearning.util.BaseAppCompatActivity;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;

public class FragmentTebakKata2 extends Fragment {
    private FragmentTebakKata2Binding binding;
    private TebakKataAnswerAdapter adapterAnswer;
    private TebakKataOptionAdapter adapterOption;
    private TebakKataModel tebakKataModel;
    private boolean isUnfinished=false;
    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    ((ActivityTebakKata) getActivity()).nexScreen();
                } else {
                    getActivity().finish();
                }
            });
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTebakKata2Binding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle= getArguments();
        int type = bundle.getInt("type", 0);
        binding.title.setText("Soal "+(type+1));
        tebakKataModel= new TebakKataModel(type);
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(requireContext());
        layoutManager.setFlexDirection(FlexDirection.ROW);
        binding.rvDataAnswer.setLayoutManager(layoutManager);

        FlexboxLayoutManager layoutManagerOption = new FlexboxLayoutManager(requireContext());
        layoutManager.setFlexDirection(FlexDirection.ROW);
        binding.rvDataOption.setLayoutManager(layoutManagerOption);

        adapterAnswer = new TebakKataAnswerAdapter((BaseAppCompatActivity) requireActivity(),true,
                itemOptionModel -> adapterOption.unselectedItem(itemOptionModel));
        binding.rvDataAnswer.setAdapter(adapterAnswer);

        adapterOption = new TebakKataOptionAdapter((BaseAppCompatActivity) requireActivity(),
                itemOptionModel -> {
                    adapterAnswer.addItems(itemOptionModel);
                    checking(false);
                });
        binding.rvDataOption.setAdapter(adapterOption);
        adapterOption.addItems(tebakKataModel.getMultipleChoice());
        binding.tvRetry.setOnClickListener(view1 -> {
            if(!isUnfinished) {
                adapterAnswer.clearItems();
                adapterOption.unselectOption();
            }
            binding.clFailed.setVisibility(View.GONE);
        });
        binding.tvContinue.setOnClickListener(view12 -> {
            binding.clSuccess.setVisibility(View.GONE);
            Intent intent = new Intent(getContext(), RightAnswerActivity.class);
            someActivityResultLauncher.launch(intent);
        });
        binding.ivNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checking(true);
            }
        });
        if(tebakKataModel.getIsImageQuestion()){
            binding.ivImage.setImageDrawable(ContextCompat.getDrawable(getContext(), tebakKataModel.getImage()));
        }
    }
    private void checking(boolean isButtonNextClicked) {
        if (!isButtonNextClicked) {
            if (adapterAnswer.getItemCount() == adapterOption.getItemCount()) {
                if (adapterAnswer.getAnswer().toLowerCase().equals(tebakKataModel.getCorrectAnswer().toLowerCase())) {
                    binding.tvSuccess.setText("Jawaban benar\n \"" + tebakKataModel.getCorrectAnswer() + "\"");
                    binding.clSuccess.setVisibility(View.VISIBLE);
                    binding.clFailed.setVisibility(View.GONE);
                } else {
                    isUnfinished= false;
                    binding.tvTitleFailed.setText("Jawaban Salah");
                    binding.ivFailedImage.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_wrong_answer));
                    binding.clSuccess.setVisibility(View.GONE);
                    binding.clFailed.setVisibility(View.VISIBLE);
                }
            }
        } else {
            isUnfinished= true;
            binding.tvTitleFailed.setText("Jawaban belum terisi");
            binding.ivFailedImage.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_turn_back));
            binding.clSuccess.setVisibility(View.GONE);
            binding.clFailed.setVisibility(View.VISIBLE);
        }
    }
}
