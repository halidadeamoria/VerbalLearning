package com.example.articulationlearning.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BaseAppCompatActivity extends AppCompatActivity {
    public void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    public void hideKeyboard(){
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void goToPage(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }


    public void goToPageAndClearPrevious(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    public void goToPageAndClearPrevious(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void goToPage(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void hideView(View view){
        view.setVisibility(View.GONE);
    }
    public void showView(View view){
        view.setVisibility(View.VISIBLE);
    }
}
