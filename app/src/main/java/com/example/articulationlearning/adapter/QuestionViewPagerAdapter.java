package com.example.articulationlearning.adapter;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.articulationlearning.fragment.FragmentQuizQuestion;
import com.example.articulationlearning.model.QuestionModel;

public class QuestionViewPagerAdapter extends FragmentPagerAdapter {

    public QuestionViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "";
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        Bundle bundle = new Bundle();
        fragment = new FragmentQuizQuestion();
        bundle.putInt("type" , position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return 20;
    }
}

