package com.example.articulationlearning.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.articulationlearning.databinding.FragmentFirstBinding;
import com.example.articulationlearning.model.LearningModel;

public class FirstFragment extends Fragment {
    private FragmentFirstBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle= getArguments();
        LearningModel konsonalModel = bundle.getParcelable("konsonan");
        int type = bundle.getInt("type", 0);
        binding.tvData.setText(konsonalModel.getDesc(type));
    }
}
