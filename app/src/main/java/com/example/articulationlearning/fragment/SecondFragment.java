package com.example.articulationlearning.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.articulationlearning.adapter.DetailKonsonanItemAdapter;
import com.example.articulationlearning.databinding.FragmentSecondBinding;
import com.example.articulationlearning.model.LearningModel;
import com.example.articulationlearning.util.onSelectedVideo;

import java.util.Arrays;
import java.util.List;

public class SecondFragment extends Fragment {
    private FragmentSecondBinding binding;
    private onSelectedVideo onSelectedVideo= null;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    public void callbackVideo(onSelectedVideo onSelectedVideo){
        this.onSelectedVideo= onSelectedVideo;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DetailKonsonanItemAdapter adapter = new DetailKonsonanItemAdapter(getContext(), onSelectedVideo);
        binding.rvData.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvData.setAdapter(adapter);
        binding.tvText.setText("Kata");
        Bundle bundle= getArguments();
        LearningModel konsonalModel = bundle.getParcelable("konsonan");
        int type = bundle.getInt("type", 0);
        List<String> data = Arrays.asList(getResources().getStringArray(konsonalModel.getWords(type)));
        adapter.addItems(data, konsonalModel.getWordVoice(type));
    }
}
