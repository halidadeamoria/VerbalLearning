package com.example.articulationlearning.adapter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.articulationlearning.fragment.FirstFragment;
import com.example.articulationlearning.fragment.SecondFragment;
import com.example.articulationlearning.fragment.ThirdFragment;
import com.example.articulationlearning.model.LearningModel;
import com.example.articulationlearning.util.onSelectedVideo;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private LearningModel baseModel;
    private int type;
    private onSelectedVideo onSelectedVideo;
    public ViewPagerAdapter(FragmentManager fm, LearningModel baseModel, int type, onSelectedVideo onSelectedVideo) {
        super(fm);
        this.baseModel = baseModel;
        this.type=type;
        this.onSelectedVideo=onSelectedVideo;
    }



    @Override
    public Fragment getItem(int position) {
        SecondFragment secondFragment = new SecondFragment();
        secondFragment.callbackVideo(onSelectedVideo);
        Fragment fragment = new FirstFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("konsonan", baseModel);
        bundle.putInt("type" , type);
        switch (position) {
            case 0:
                fragment = new FirstFragment();
                break;
            case 1:
                fragment = secondFragment;
                break;

        }
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
