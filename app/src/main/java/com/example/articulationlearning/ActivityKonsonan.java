package com.example.articulationlearning;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.articulationlearning.adapter.KonsonanAdapter;
import com.example.articulationlearning.databinding.ActivityKonsonanBinding;
import com.example.articulationlearning.model.LearningModel;
import com.example.articulationlearning.util.BaseAppCompatActivity;

import java.util.ArrayList;

public class ActivityKonsonan extends BaseAppCompatActivity {
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
        getSupportActionBar().setTitle("Konsonan");
        binding.toolbar.setNavigationOnClickListener(view -> onBackPressed());
        KonsonanAdapter adapter = new KonsonanAdapter(this);
        binding.rvItem.setLayoutManager(new GridLayoutManager(this, 4));
//        binding.rvItem.setLayoutManager(new LinearLayoutManager(this));
        binding.rvItem.setAdapter(adapter);
        adapter.addItems(generateItem());
        binding.toolbar.setTitleTextColor(Color.WHITE);
        binding.toolbar.setSubtitleTextColor(Color.WHITE);
        Drawable drawable = binding.toolbar.getNavigationIcon();
        drawable.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_ATOP);
        binding.toolbar.setBackgroundColor(Color.parseColor("#00A176"));
    }

    private ArrayList<LearningModel> generateItem(){
        ArrayList<LearningModel> items = new ArrayList<>();
        for(int i=0;i<26;i++){
            if(i!=0 &&i!=4 &&i!=8 &&i!=14 &&i!=20 ) {
                LearningModel baseModel = new LearningModel();
                baseModel.setAscii(i);
                items.add(baseModel);
            }
        }
        return items;
    }
}
