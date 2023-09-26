package com.example.articulationlearning;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.articulationlearning.databinding.ActivityStartFunQuizyBinding;
import com.example.articulationlearning.util.BaseAppCompatActivity;

public class StartFunQuizyActivity extends BaseAppCompatActivity {
    private ActivityStartFunQuizyBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityStartFunQuizyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle bundle = getIntent().getExtras();
        int type = bundle.getInt("type");
        binding.tvStart.setOnClickListener(view -> {
            if(type == 0){
                goToPage(ActivityQuizQuestion.class);
            }else{
                goToPage(ActivityTebakKata.class);
            }
        });
    }
}
