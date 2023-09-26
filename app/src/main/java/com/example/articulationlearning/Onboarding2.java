package com.example.articulationlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.example.articulationlearning.database.CustomerDatabaseHelper;
import com.example.articulationlearning.database.QueryResponse;
import com.example.articulationlearning.databinding.ActivityOnboarding2Binding;
import com.example.articulationlearning.model.CustomerModel;
import com.example.articulationlearning.util.BaseAppCompatActivity;
import com.example.articulationlearning.util.SessionManager;

public class Onboarding2 extends BaseAppCompatActivity {
    private ActivityOnboarding2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnboarding2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding.inputNama.setOnEditorActionListener((textView, actionId, keyEvent) -> {
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                if (binding.inputNama.getText().toString().isEmpty()) {
                    return false;
                }
                CustomerDatabaseHelper helper = new CustomerDatabaseHelper();
                helper.loginCustomer(
                        binding.inputNama.getText().toString(),
                        String.valueOf(System.currentTimeMillis()), new QueryResponse<CustomerModel>() {
                    @Override
                    public void onSuccess(CustomerModel data, int idData) {
                        showToast(data.getName());
                        SessionManager.setCustData(Onboarding2.this, data.getName(),data.getCustNumber(), idData);
                        Intent intent = new Intent(Onboarding2.this, Onboarding3.class);
                        startActivity(intent);
                        hideKeyboard();
                    }

                    @Override
                    public void onFailure(String message) {
                        showToast(message);
                    }
                });
                return true;
            }
            return false;
        });
    }
}