package com.example.articulationlearning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.articulationlearning.databinding.ActivityRightAnswerBinding;
import com.example.articulationlearning.util.BaseAppCompatActivity;

public class RightAnswerActivity extends BaseAppCompatActivity {
    private ActivityRightAnswerBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRightAnswerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.tvStart.setOnClickListener(view ->{
            setResult(RESULT_OK);
            finish();
        });
        binding.tvEndQuiz.setOnClickListener(view ->{
            setResult(RESULT_CANCELED);
            finish();
        });
    }
}
