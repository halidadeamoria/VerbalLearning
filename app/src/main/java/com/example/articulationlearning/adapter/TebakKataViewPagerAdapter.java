package com.example.articulationlearning.adapter;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.articulationlearning.fragment.FragmentQuizQuestion;
import com.example.articulationlearning.fragment.FragmentTebakKata1;
import com.example.articulationlearning.fragment.FragmentTebakKata2;
import com.example.articulationlearning.model.TebakKataModel;

public class TebakKataViewPagerAdapter extends FragmentPagerAdapter {

    public TebakKataViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "";
    }

    @Override
    public Fragment getItem(int position) {
        TebakKataModel tebakKataModel= new TebakKataModel(position);
        Fragment fragment;
        Bundle bundle = new Bundle();
        if(tebakKataModel.getIsImageQuestion()){
            fragment = new FragmentTebakKata2();
        }else{
            fragment = new FragmentTebakKata1();
        }
        bundle.putInt("type" , position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}