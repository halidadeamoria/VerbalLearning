package com.example.articulationlearning;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.articulationlearning.adapter.TebakKataViewPagerAdapter;
import com.example.articulationlearning.databinding.ActivityQuestionQuizBinding;
import com.example.articulationlearning.util.BaseAppCompatActivity;

public class ActivityTebakKata extends BaseAppCompatActivity {
    private ActivityQuestionQuizBinding binding;
    private TebakKataViewPagerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuestionQuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        adapter = new TebakKataViewPagerAdapter(getSupportFragmentManager());
        binding.vp.setAdapter(adapter);
    }

    public void nexScreen() {
        int position = binding.vp.getCurrentItem() + 1;
        if (position == adapter.getCount()) {
            Toast.makeText(ActivityTebakKata.this, "Game Selesai", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            binding.vp.setCurrentItem(position);
        }
    }
}
