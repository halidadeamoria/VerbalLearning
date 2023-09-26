package com.example.articulationlearning;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.articulationlearning.adapter.BerbicaraItemAdapter;
import com.example.articulationlearning.adapter.KategoriMenuAdapter;
import com.example.articulationlearning.databinding.ActivityBerbicaraBinding;
import com.example.articulationlearning.util.BaseAppCompatActivity;

import java.util.ArrayList;

public class ActivityBerbicara extends BaseAppCompatActivity {
    private ActivityBerbicaraBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityBerbicaraBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Berbicara");
        binding.toolbar.setNavigationOnClickListener(view -> onBackPressed());
        BerbicaraItemAdapter adapter = new BerbicaraItemAdapter(this);
        binding.rvItem.setLayoutManager(new LinearLayoutManager(this));
        binding.rvItem.setAdapter(adapter);
        ArrayList<String> items = new ArrayList<>();
        items.add("");
        items.add("");
        adapter.addItems(items);
    }
}
