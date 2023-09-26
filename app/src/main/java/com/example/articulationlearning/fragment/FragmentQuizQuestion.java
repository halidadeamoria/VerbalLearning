package com.example.articulationlearning.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.articulationlearning.ActivityQuizQuestion;
import com.example.articulationlearning.RightAnswerActivity;
import com.example.articulationlearning.adapter.AnswerQuestionItemAdapter;
import com.example.articulationlearning.adapter.QuestionViewPagerAdapter;
import com.example.articulationlearning.databinding.FragmentQuestionQuizBinding;
import com.example.articulationlearning.model.QuestionModel;
import com.example.articulationlearning.util.BaseAppCompatActivity;

import java.util.ArrayList;

public class FragmentQuizQuestion extends Fragment {
    private FragmentQuestionQuizBinding binding;
    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    ( (ActivityQuizQuestion) getActivity()).nexScreen();
                }else{
                    getActivity().finish();
                }
            });
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentQuestionQuizBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle= getArguments();
        int type = bundle.getInt("type", 0);
        QuestionModel questionModel= new QuestionModel(type);
        AnswerQuestionItemAdapter adapter = new AnswerQuestionItemAdapter((BaseAppCompatActivity) getActivity(), position -> {
            if(questionModel.getIndexAnswer()== position){
                binding.clSuccess.setVisibility(View.VISIBLE);
                binding.clFailed.setVisibility(View.GONE);
            }else{
                binding.clSuccess.setVisibility(View.GONE);
                binding.clFailed.setVisibility(View.VISIBLE);
            }
        });
        binding.tvContinue.setOnClickListener(view12 -> {
            binding.clSuccess.setVisibility(View.GONE);
            Intent intent = new Intent(getContext(), RightAnswerActivity.class);
            someActivityResultLauncher.launch(intent);
        });
        binding.tvRetry.setOnClickListener(view1 -> binding.clFailed.setVisibility(View.GONE));
        binding.rvData.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        binding.rvData.setAdapter(adapter);
        binding.title.setText("Soal "+(type+1));
        adapter.addItems(questionModel.getMultipleChoice());
        binding.ivImage.setImageDrawable(ContextCompat.getDrawable(getContext(), questionModel.getImage()));
    }
}
