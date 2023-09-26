package com.example.articulationlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.example.articulationlearning.util.SessionManager;

public class SplashScreen2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen2);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(SessionManager.getIsLogin(SplashScreen2.this)){
                    Intent intent = new Intent(SplashScreen2.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                }
                Intent intent = new Intent(SplashScreen2.this,Onboarding1.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }
}