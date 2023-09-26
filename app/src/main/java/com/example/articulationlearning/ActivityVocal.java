package com.example.articulationlearning;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.articulationlearning.adapter.VocalAdapter;
import com.example.articulationlearning.databinding.ActivityKonsonanBinding;
import com.example.articulationlearning.model.LearningModel;
import com.example.articulationlearning.util.BaseAppCompatActivity;

import java.util.ArrayList;

public class ActivityVocal extends BaseAppCompatActivity {
    private ActivityKonsonanBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityKonsonanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Vokal");
        binding.toolbar.setNavigationOnClickListener(view -> onBackPressed());
        VocalAdapter adapter = new VocalAdapter(this, 2);
        binding.rvItem.setLayoutManager(new LinearLayoutManager(this));
        binding.rvItem.setAdapter(adapter);
        adapter.addItems(generateItem());
    }
    private ArrayList<LearningModel> generateItem(){
        ArrayList<LearningModel> items = new ArrayList<>();
        for(int i=0;i<5;i++){
            LearningModel vm= new LearningModel();
            vm.setAscii(i);
            items.add(vm);
        }
        return items;
    }
}
