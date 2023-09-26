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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThirdFragment extends Fragment {
    private FragmentSecondBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DetailKonsonanItemAdapter adapter = new DetailKonsonanItemAdapter(getContext());
        binding.rvData.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvData.setAdapter(adapter);
        binding.tvText.setText("Kalimat");
        Bundle bundle= getArguments();
        LearningModel konsonalModel = bundle.getParcelable("konsonan");
        int type = bundle.getInt("type", 0);
        List<String> data = Arrays.asList(getResources().getStringArray(konsonalModel.getSentences(type)));
        adapter.addItems(data, konsonalModel.getSentencesVoice(type));
    }
    private ArrayList<Integer> generateItem(){
        ArrayList<Integer> items = new ArrayList<>();
        for(int i=0;i<26;i++){
            items.add(97+i);
        }
        return items;
    }
}
