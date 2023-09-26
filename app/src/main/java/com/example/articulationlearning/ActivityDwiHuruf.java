package com.example.articulationlearning;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import com.example.articulationlearning.adapter.DwiHurufViewPagerAdapter;
import com.example.articulationlearning.adapter.ViewPagerAdapter;
import com.example.articulationlearning.databinding.ActivityDwiHurufBinding;
import com.example.articulationlearning.util.BaseAppCompatActivity;

public class ActivityDwiHuruf extends BaseAppCompatActivity {
    private ActivityDwiHurufBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDwiHurufBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Dwihuruf");
        binding.toolbar.setNavigationOnClickListener(view -> onBackPressed());
        DwiHurufViewPagerAdapter adapter = new DwiHurufViewPagerAdapter(getSupportFragmentManager());
        binding.vp.setAdapter(adapter);
        binding.tbLayout.setupWithViewPager(binding.vp);
    }
}
