package com.example.articulationlearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

import com.example.articulationlearning.databinding.ActivityMainBinding;
import com.example.articulationlearning.fragment.AkunFragment;
import com.example.articulationlearning.fragment.BerandaFragment;
import com.example.articulationlearning.fragment.InformasiFragment;
import com.example.articulationlearning.util.BaseAppCompatActivity;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends BaseAppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //jumlah tab yang akan dipilih, kita punya 3 tab. nilai default disini adalah 1
    private int selectedTab = 1;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                MainActivity.this, drawer, binding.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        binding.navView.setNavigationItemSelectedListener(this);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        binding.berandaLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //fungsi untuk mengecek apakah beranda telah terpilih atau belum
                if (selectedTab != 1) {
                    //atur Beranda Fragment sesuai default
                    getSupportActionBar().setHomeButtonEnabled(false);
                    getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                    getSupportActionBar().setDisplayShowTitleEnabled(false);
                    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                            MainActivity.this, drawer, binding.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
                    drawer.setDrawerListener(toggle);
                    toggle.syncState();

                    getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.fragmentContainer, BerandaFragment.class, null).commit();

                    binding.informasiTxt.setVisibility(View.GONE);
                    binding.akunTxt.setVisibility(View.GONE);
                    binding.informasiLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this, android.R.color.transparent));
                    binding.akunLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this, android.R.color.transparent));

                    //pilih beranda tab
                    binding.berandaTxt.setVisibility(View.VISIBLE);
                    binding.berandaLayout.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.round_back_bottomnav));

                    //buat animasi untuk beranda layout
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    binding.berandaLayout.startAnimation(scaleAnimation);

                    //atur tab pertama sebagai tab yang terpilih
                    selectedTab = 1;
                }
            }
        });

        binding.informasiLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //fungsi untuk mengecek apakah beranda telah terpilih atau belum
                if (selectedTab != 2) {
                    getSupportActionBar().setHomeButtonEnabled(true);
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                    getSupportActionBar().setDisplayShowTitleEnabled(true);
                    getSupportActionBar().setTitle("Pengucapan");
                    //atur Informasi Fragment sesuai default
                    getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.fragmentContainer, InformasiFragment.class, null).commit();

                    binding.berandaTxt.setVisibility(View.GONE);
                    binding.akunTxt.setVisibility(View.GONE);

                    binding.berandaLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this, android.R.color.transparent));
                    binding.akunLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this, android.R.color.transparent));

                    //pilih informasi tab
                    binding.informasiTxt.setVisibility(View.VISIBLE);
                    binding.informasiIcon.setImageResource(R.drawable.information);

                    binding.informasiLayout.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.round_back_bottomnav));

                    //buat animasi untuk informasi layout
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    binding.informasiLayout.startAnimation(scaleAnimation);

                    //atur tab pertama sebagai tab yang terpilih
                    selectedTab = 2;
                }
            }
        });

        binding.akunLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //fungsi untuk mengecek apakah beranda telah terpilih atau belum
                if (selectedTab != 3) {
                    getSupportActionBar().setHomeButtonEnabled(true);
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                    getSupportActionBar().setDisplayShowTitleEnabled(true);
                    getSupportActionBar().setTitle("Akun");
                    //atur Akun Fragment sesuai default
                    getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.fragmentContainer, AkunFragment.class, null).commit();

                    binding.berandaTxt.setVisibility(View.GONE);
                    binding.informasiTxt.setVisibility(View.GONE);

                    binding.berandaLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this, android.R.color.transparent));
                    binding.informasiLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this, android.R.color.transparent));

                    //pilih akun tab
                    binding.akunTxt.setVisibility(View.VISIBLE);
                    binding.akunLayout.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.round_back_bottomnav));

                    //buat animasi untuk akun layout
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    binding.akunLayout.startAnimation(scaleAnimation);

                    //atur tab pertama sebagai tab yang terpilih
                    selectedTab = 3;
                }
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        int type = 1;
        if (id == R.id.nav_about_us) {
            type = 1;
        } else if (id == R.id.nav_how_to_use) {
            type = 2;
        } else if (id == R.id.nav_privacy_term) {
            type = 4;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("type",type );
        goToPage(AboutUsActivity.class, bundle);
        binding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}