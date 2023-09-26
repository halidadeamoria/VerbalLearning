package com.example.articulationlearning;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.MediaController;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.articulationlearning.adapter.DetailBerbicaraItemAdapter;
import com.example.articulationlearning.adapter.KonsonanAdapter;
import com.example.articulationlearning.databinding.ActivityBerbicaraDetailBinding;
import com.example.articulationlearning.model.BerbicaraModel;
import com.example.articulationlearning.util.BaseAppCompatActivity;
import com.example.articulationlearning.util.onSelectedVideo;

import java.util.ArrayList;

public class BerbicaraDetailActivity extends BaseAppCompatActivity implements onSelectedVideo {
    private ActivityBerbicaraDetailBinding binding;
    private DetailBerbicaraItemAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBerbicaraDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Daftar Kata");
        binding.toolbar.setNavigationOnClickListener(view -> onBackPressed());
        binding.toolbar.setTitleTextColor(Color.WHITE);
        binding.toolbar.setSubtitleTextColor(Color.WHITE);
        Drawable drawable = binding.toolbar.getNavigationIcon();
        drawable.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_ATOP);
        binding.toolbar.setBackgroundColor(Color.parseColor("#00A176"));
        adapter = new DetailBerbicaraItemAdapter(this, this);
        binding.rvData.setLayoutManager(new LinearLayoutManager(this));
        binding.rvData.setAdapter(adapter);
        binding.tvBencanaC.setOnClickListener(view -> adapter.addItems(generateItem(Integer.parseInt(view.getTag().toString()))));
        binding.tvBencanaJ.setOnClickListener(view -> adapter.addItems(generateItem(Integer.parseInt(view.getTag().toString()))));
        binding.tvBencanaNY.setOnClickListener(view -> adapter.addItems(generateItem(Integer.parseInt(view.getTag().toString()))));
        binding.tvBencanaK.setOnClickListener(view -> adapter.addItems(generateItem(Integer.parseInt(view.getTag().toString()))));
        binding.tvBencanaG.setOnClickListener(view -> adapter.addItems(generateItem(Integer.parseInt(view.getTag().toString()))));
        binding.tvBencanaNG.setOnClickListener(view -> adapter.addItems(generateItem(Integer.parseInt(view.getTag().toString()))));
        binding.tvBencanaH.setOnClickListener(view -> adapter.addItems(generateItem(Integer.parseInt(view.getTag().toString()))));

        binding.tvReproduksiC.setOnClickListener(view -> adapter.addItems(generateItem(Integer.parseInt(view.getTag().toString()))));
        binding.tvReproduksiJ.setOnClickListener(view -> adapter.addItems(generateItem(Integer.parseInt(view.getTag().toString()))));
        binding.tvReproduksiNY.setOnClickListener(view -> adapter.addItems(generateItem(Integer.parseInt(view.getTag().toString()))));
        binding.tvReproduksiK.setOnClickListener(view -> adapter.addItems(generateItem(Integer.parseInt(view.getTag().toString()))));
        binding.tvReproduksiG.setOnClickListener(view -> adapter.addItems(generateItem(Integer.parseInt(view.getTag().toString()))));
        binding.tvReproduksiNG.setOnClickListener(view -> adapter.addItems(generateItem(Integer.parseInt(view.getTag().toString()))));
        binding.tvReproduksiH.setOnClickListener(view -> adapter.addItems(generateItem(Integer.parseInt(view.getTag().toString()))));

        adapter.addItems(generateItem(1));

    }
    private void setTitleContent(int type){
        if(type>0&& type<=7){
            binding.tvTitle.setText("Kesiapsiagaan Bencana");
        }else {
            binding.tvTitle.setText("Kesehatan Reproduksi");
        }
        if(type==1 || type==8){
            binding.tvTitleDesc.setText("Kata dengan huruf 'C'");
        }else if(type==2 || type==9){
            binding.tvTitleDesc.setText("Kata dengan huruf 'J'");
        }else if(type==3 || type==10){
            binding.tvTitleDesc.setText("Kata dengan huruf 'Nya'");
        }else if(type==4 || type==11){
            binding.tvTitleDesc.setText("Kata dengan huruf 'K'");
        }else if(type==5 || type==12){
            binding.tvTitleDesc.setText("Kata dengan huruf 'G'");
        }else if(type==6 || type==13){
            binding.tvTitleDesc.setText("Kata dengan huruf 'Ng'");
        }else if(type==7 || type==14){
            binding.tvTitleDesc.setText("Kata dengan huruf 'H'");
        }
    }
    private ArrayList<BerbicaraModel> generateItem(int type){
        binding.drawerLayout.close();
        setTitleContent(type);
        ArrayList<BerbicaraModel> items = new ArrayList<>();
        for(int i=0;i<5;i++){
            BerbicaraModel model= new BerbicaraModel(type, i);
            items.add(model);
        }
        return items;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_berbicara, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_menu) {
            binding.drawerLayout.open();
        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    public void playVideo(int videoId) {
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(binding.videoView);
        binding.videoView.setMediaController(mediaController);
        binding.videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" +
                videoId));
        binding.videoView.start();
    }
}
