package com.example.articulationlearning;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.articulationlearning.adapter.PembelajaranAdapter;
import com.example.articulationlearning.adapter.PrawicaraAdapter;
import com.example.articulationlearning.databinding.ActivityPembelajaranBinding;
import com.example.articulationlearning.databinding.ActivityPraWicaraBinding;
import com.example.articulationlearning.util.BaseAppCompatActivity;

import java.util.ArrayList;

public class PembelajaranActivity extends BaseAppCompatActivity {
    private ActivityPembelajaranBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPembelajaranBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Pembelajaran");
        binding.toolbar.setNavigationOnClickListener(view -> onBackPressed());
        PembelajaranAdapter adapter = new PembelajaranAdapter((BaseAppCompatActivity) this);
        binding.rvItem.setLayoutManager(new GridLayoutManager(this, 1));
//        binding.rvItem.setLayoutManager(new LinearLayoutManager(this));
        binding.rvItem.setAdapter(adapter);
        ArrayList<String> items = new ArrayList<>();
        items.add("Pernafasan");
        items.add("Pelemasan Organ Bicara");
        adapter.addItems(items);
        binding.toolbar.setTitleTextColor(Color.WHITE);
        binding.toolbar.setSubtitleTextColor(Color.WHITE);
        Drawable drawable = binding.toolbar.getNavigationIcon();
        drawable.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_ATOP);
        binding.toolbar.setBackgroundColor(Color.parseColor("#00A176"));
    }
}
