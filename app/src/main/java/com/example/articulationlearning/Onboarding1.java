package com.example.articulationlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;

import com.example.articulationlearning.databinding.ActivityOnboarding1Binding;
import com.example.articulationlearning.databinding.ActivityOnboarding2Binding;

public class Onboarding1 extends AppCompatActivity {
    private ActivityOnboarding1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnboarding1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding.btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Onboarding1.this,Onboarding2.class);
                startActivity(intent);
                finish();

            }
        });
    }
}