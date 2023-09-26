package com.example.articulationlearning;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.articulationlearning.adapter.HomeMenuAdapter;
import com.example.articulationlearning.adapter.KonsonanAdapter;
import com.example.articulationlearning.adapter.PrawicaraAdapter;
import com.example.articulationlearning.databinding.ActivityKonsonanBinding;
import com.example.articulationlearning.databinding.ActivityPraWicaraBinding;
import com.example.articulationlearning.model.LearningModel;
import com.example.articulationlearning.util.BaseAppCompatActivity;

import java.util.ArrayList;

public class ActivityPraWicara  extends BaseAppCompatActivity {
    private ActivityPraWicaraBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPraWicaraBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Latihan Pra-Wicara");
        binding.toolbar.setNavigationOnClickListener(view -> onBackPressed());
        PrawicaraAdapter adapter = new PrawicaraAdapter((BaseAppCompatActivity) this);
        binding.rvItem.setLayoutManager(new GridLayoutManager(this, 1));
//        binding.rvItem.setLayoutManager(new LinearLayoutManager(this));
        binding.rvItem.setAdapter(adapter);
        ArrayList<String> items = new ArrayList<>();
        items.add("Pernafasan");
        items.add("Pelemasan Organ Bicara");
        items.add("Pembentukan Suara");
        adapter.addItems(items);
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

