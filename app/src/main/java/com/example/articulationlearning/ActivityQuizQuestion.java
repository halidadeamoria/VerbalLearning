package com.example.articulationlearning;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.articulationlearning.adapter.AnswerQuestionItemAdapter;
import com.example.articulationlearning.adapter.DwiHurufViewPagerAdapter;
import com.example.articulationlearning.adapter.PembelajaranAdapter;
import com.example.articulationlearning.adapter.QuestionViewPagerAdapter;
import com.example.articulationlearning.databinding.ActivityQuestionQuizBinding;
import com.example.articulationlearning.databinding.FragmentTebakKata1Binding;
import com.example.articulationlearning.util.BaseAppCompatActivity;

import java.util.ArrayList;

public class ActivityQuizQuestion extends BaseAppCompatActivity {
    private ActivityQuestionQuizBinding binding;
    private QuestionViewPagerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuestionQuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        adapter = new QuestionViewPagerAdapter(getSupportFragmentManager());
        binding.vp.setAdapter(adapter);
    }

    public void nexScreen() {
        int position = binding.vp.getCurrentItem() + 1;
        if (position == adapter.getCount()) {
            Toast.makeText(ActivityQuizQuestion.this, "Game Selesai", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            binding.vp.setCurrentItem(position);
        }
    }
}
