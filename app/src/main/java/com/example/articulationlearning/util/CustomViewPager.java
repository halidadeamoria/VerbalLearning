package com.example.articulationlearning.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;

public class CustomViewPager extends ViewPager {
    /**
     * Is swipe enabled
     */
    private boolean enabled;

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.enabled = false; // By default swiping is disabled
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.enabled ? super.onTouchEvent(event) : false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return this.enabled ? super.onInterceptTouchEvent(event) : false;
    }

    @Override
    public boolean executeKeyEvent(KeyEvent event) {
        return this.enabled ? super.executeKeyEvent(event) : false;
    }

    public void setSwipeEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
