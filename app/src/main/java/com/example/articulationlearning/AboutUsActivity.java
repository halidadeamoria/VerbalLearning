package com.example.articulationlearning;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.MediaController;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.articulationlearning.databinding.ActivityAboutUsBinding;
import com.example.articulationlearning.util.BaseAppCompatActivity;

public class AboutUsActivity extends BaseAppCompatActivity {
    private ActivityAboutUsBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAboutUsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Toolbar");
        binding.toolbar.setNavigationOnClickListener(view -> onBackPressed());
        Bundle bundle = getIntent().getExtras();
        int type = bundle.getInt("type", 1);
        String content="";
        Drawable drawable = binding.toolbar.getNavigationIcon();
        if (type == 1) {
            binding.toolbar.setTitle("Privacy Policy");
            content ="Cendana: Privacy Policy\n" +
                    "Last updated: May 05, 2023\n" +
                    "\n" +
                    "Cendana menghargai privasi Anda. Kami tidak mengumpulkan informasi pribadi apa pun saat Anda mengunduh Aplikasi (Aplikasi) kami. Cendana merupakan Aplikasi yang dapat membantu  meningkatkan dan melatih pengucapan serta artikulasi  sesuai dengan  standar pengucapan dalam Bahasa Indonesia.\n" +
                    "\n" +
                    "Jika Anda memiliki pertanyaan atau masalah tambahan terkait dengan kebijakan privasi kami, jangan ragu untuk menghubungi kami. Kami akan segera menghubungi Anda kembali.\n";
            binding.toolbar.setBackgroundColor(Color.parseColor("#FFFFFF"));
            binding.tvText.setGravity(Gravity.CENTER);
            binding.toolbar.setTitleTextColor(Color.BLACK);
            binding.toolbar.setSubtitleTextColor(Color.BLACK);
            drawable.setColorFilter(ContextCompat.getColor(this, R.color.black), PorterDuff.Mode.SRC_ATOP);
            binding.sv.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        } else if (type == 2) {
            binding.toolbar.setTitle("Cara Penggunaan");
            content ="1. Buka aplikasi dan pilih menu yang Anda inginkan untuk melatih pengucapan Anda\n\n" +
                    "2. Pilih salah satu huruf lalu mainkan dan pelajari bagaimana suaranya dengan memutar rekaman video pada halaman. Anda juga dapat menggeser tab pada bagian tips bacaan.\n\n" +
                    "3. Terdapat 26 Huruf pada Alfabet Indonesia dan 40 pengucapan yang sesuai dengan standar Bahasa Indonesia, seperti konsonan, vokal, dand Dwihuruf\n\n" +
                    "4. Untuk informasi seputar kebijakan privasi dan syarat penggunaan aplikasi, Anda dapat melihat pada menu kiri atas pada halaman beranda.\n\n";
            binding.tvText.setText(content);
            binding.toolbar.setTitleTextColor(Color.WHITE);
            binding.toolbar.setSubtitleTextColor(Color.WHITE);
            drawable.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_ATOP);
            binding.toolbar.setBackgroundColor(Color.parseColor("#00A176"));
            binding.sv.setBackgroundColor(ContextCompat.getColor(this, R.color.primary));
        }else if (type == 3) {
            hideView(binding.llBottomView);
            showView(binding.tvRedirectVideo);
            binding.toolbar.setTitle("Latihan Pernafasan");
            binding.tvRedirectVideo.setOnClickListener(view -> {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=K3H6OkPCz_I"));
                startActivity(intent);
            });
            content ="Berikut adalah empat jenis pernafasan yang telah Anda sebutkan:\n" +
                    "1. Pernafasan Bahu (Clavicular Breathing)\n" +
                    "2. Pernafasan Dada (Thoracic Breathing)\n" +
                    "3. Pernafasan Perut (Diaphragmatic Breathing)\n" +
                    "4. Pernafasan Sisi (Lateral Breathing)\n" +
                    "5. Pernafasan Campuran : Dada dan Perut\n" +
                    "\n" +
                    "Alat-alat yang digunakan untuk melatih pernafasan:\n" +
                    "1. Llilin\n" +
                    "2. Kapas\n" +
                    "3. Tisu\n" +
                    "4. Kertas\n" +
                    "5. Balo\n" +
                    "6. Sedotan Plastik\n" +
                    "7. Peluit\n" +
                    "8. Terompet\n" +
                    "9. Harmonika\n";
            binding.tvText.setText(content);
            binding.toolbar.setTitleTextColor(Color.WHITE);
            binding.toolbar.setSubtitleTextColor(Color.WHITE);
            drawable.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_ATOP);
            binding.toolbar.setBackgroundColor(Color.parseColor("#00A176"));
            binding.sv.setBackgroundColor(ContextCompat.getColor(this, R.color.primary));
        }
        else{
            binding.toolbar.setTitle("");
            hideView(binding.sv);
            drawable.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_ATOP);
            binding.toolbar.setBackgroundColor(Color.parseColor("#00A176"));
            binding.sv.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            binding.sv.setBackgroundColor(ContextCompat.getColor(this, R.color.primary));
        }
        binding.tvText.setText(content);
    }
}

