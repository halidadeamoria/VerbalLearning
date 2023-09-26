package com.example.articulationlearning.adapter;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.articulationlearning.fragment.FirstDwiHurufFragment;

public class DwiHurufViewPagerAdapter extends FragmentPagerAdapter {

    public DwiHurufViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "DIFTONG";
        }else{
            return "DIGRAF";
        }
    }
    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        Bundle bundle = new Bundle();
        if(position==0){
            fragment = new FirstDwiHurufFragment();
            bundle.putInt("type" , 3);
        }else{
            fragment = new FirstDwiHurufFragment();
            bundle.putInt("type" , 4);
        }
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
