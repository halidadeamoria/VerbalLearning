package com.example.articulationlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;

import com.example.articulationlearning.databinding.ActivityOnboarding3Binding;
import com.example.articulationlearning.util.BaseAppCompatActivity;
import com.example.articulationlearning.util.SessionManager;

public class Onboarding3 extends BaseAppCompatActivity {
    private ActivityOnboarding3Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityOnboarding3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding.btnMasuk.setOnClickListener(view -> {
            Intent intent = new Intent(Onboarding3.this,MainActivity.class);
            startActivity(intent);
            finish();
        });
        binding.textTitleboarding.setText("Halo, "+ SessionManager.getName(this));
    }
}