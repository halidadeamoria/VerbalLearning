package com.example.articulationlearning.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.articulationlearning.adapter.VocalAdapter;
import com.example.articulationlearning.databinding.FragmentDwiHurufBinding;
import com.example.articulationlearning.model.LearningModel;
import com.example.articulationlearning.util.BaseAppCompatActivity;

import java.util.ArrayList;

public class FirstDwiHurufFragment  extends Fragment {
    private FragmentDwiHurufBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDwiHurufBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle= getArguments();
        int type = bundle.getInt("type", 0);
        Log.d("type ","--> "+type);
        VocalAdapter adapter = new VocalAdapter((BaseAppCompatActivity) requireActivity(), type);
        binding.rvData.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvData.setAdapter(adapter);
        adapter.addItems(generateItem());
    }

    private ArrayList<LearningModel> generateItem() {
        ArrayList<LearningModel> items = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            LearningModel vm = new LearningModel();
            vm.setAscii(i);
            items.add(vm);
        }
        return items;
    }
}