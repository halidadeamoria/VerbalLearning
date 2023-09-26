package com.example.articulationlearning;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.articulationlearning.adapter.ViewPagerAdapter;
import com.example.articulationlearning.databinding.ActivityDetailKonsonanBinding;
import com.example.articulationlearning.model.LearningModel;
import com.example.articulationlearning.util.BaseAppCompatActivity;
import com.example.articulationlearning.util.onSelectedVideo;

public class DetailLearningActivity extends BaseAppCompatActivity {
    private ActivityDetailKonsonanBinding binding;
    private int dotscount;
    private ImageView[] dots;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailKonsonanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        Bundle bundle = getIntent().getExtras();
        LearningModel baseModel = bundle.getParcelable("konsonan");
        int type = bundle.getInt("type");
        int a = baseModel.getAscii();
        char b = (char) a;
        String strAsciiTab = Character.toString(b);
        if(type==1){
            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(binding.videoView);
            binding.videoView.setMediaController(mediaController);
            binding.videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" +
                    baseModel.getIdVideo(type)));
            binding.videoView.start();
            getSupportActionBar().setTitle(strAsciiTab);
        }else if (type==2) {
            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(binding.videoView);
            binding.videoView.setMediaController(mediaController);
            binding.videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" +
                    baseModel.getIdVideo(type)));
            binding.videoView.start();
            getSupportActionBar().setTitle(getString(baseModel.getTitle(type)));
        }else{
            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(binding.videoView);
            binding.videoView.setMediaController(mediaController);
            binding.videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" +
                    baseModel.getIdVideo(type)));
            binding.videoView.start();
            getSupportActionBar().setTitle(getString(baseModel.getTitle(type)));

        }
        binding.videoView.setOnClickListener(view -> {
            if(binding.videoView.isPlaying()){
                binding.videoView.stopPlayback();
            }else{
                binding.videoView.resume();
            }
        });
        binding.toolbar.setNavigationOnClickListener(view -> onBackPressed());
        binding.toolbar.setTitleTextColor(Color.WHITE);
        binding.toolbar.setSubtitleTextColor(Color.WHITE);
        Drawable drawable = binding.toolbar.getNavigationIcon();
        drawable.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_ATOP);
        binding.toolbar.setBackgroundColor(Color.parseColor("#00A176"));

        binding.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                binding.videoView.start();
                mediaPlayer.setLooping(true);
            }
        });
        PagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), baseModel, type, new onSelectedVideo() {
            @Override
            public void playVideo(int videoId) {
                binding.videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" +
                        videoId));
                binding.videoView.start();
            }
        });
        binding.vp.setAdapter(adapter);

        dotscount = adapter.getCount();
        dots = new ImageView[dotscount];

        for (int i = 0; i < dotscount; i++) {

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            binding.dotsIndicator.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        binding.vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
