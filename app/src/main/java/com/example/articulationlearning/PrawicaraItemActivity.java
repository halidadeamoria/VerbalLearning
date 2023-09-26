package com.example.articulationlearning;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.webkit.WebChromeClient;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.articulationlearning.adapter.PrawicaraAdapter;
import com.example.articulationlearning.databinding.ActivityPraWicaraBinding;
import com.example.articulationlearning.databinding.ActivityPrawicaraItemBinding;
import com.example.articulationlearning.util.BaseAppCompatActivity;

import java.util.ArrayList;

public class PrawicaraItemActivity extends BaseAppCompatActivity {
    private ActivityPrawicaraItemBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrawicaraItemBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Latihan Pra-Wicara");
        binding.toolbar.setNavigationOnClickListener(view -> onBackPressed());
        binding.toolbar.setBackgroundColor(Color.parseColor("#FFFFFF"));
        binding.toolbar.setTitleTextColor(Color.BLACK);
        binding.toolbar.setSubtitleTextColor(Color.BLACK);
        Drawable drawable = binding.toolbar.getNavigationIcon();
        drawable.setColorFilter(ContextCompat.getColor(this, R.color.black), PorterDuff.Mode.SRC_ATOP);
        String video;
        Bundle bundle = getIntent().getExtras();
        int type = bundle.getInt("type", 1);
        if (type == 0) {
            video = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/K3H6OkPCz_I?si=3_3-WV091H7rRl2V\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
            getSupportActionBar().setTitle("Latihan Pernafasan");
            setUpPernafasan();
        } else if (type == 1) {
            video = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/kCZp0r1dtRs?si=S19-WISoVQiXKN_l\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
            getSupportActionBar().setTitle("Latihan Pelemasan Organ");
            setUpPelemasanOrgan();
        } else {
            video = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/nVssuE_THOE?si=KMC3mkjShkGS-nlU\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
            getSupportActionBar().setTitle("Latihan Pembentukan Suara");
            setUpPembentukanSuara();
        }
        binding.webview.loadData(video, "text/html", "utf-8");
        binding.webview.getSettings().setJavaScriptEnabled(true);
        binding.webview.setWebChromeClient(new WebChromeClient());
    }

    private void setUpPernafasan() {
        binding.tvTitle.setText("Latihan Pernafasan");
        binding.tvSubTitle.setText("Sumber Video : Youtube @bpmtpsidoarjo");
        String content = "<h4>Tujuan Pembelajaran</h4><br>" +
                "Melalui video pendamping mampu melatih pernafasan sesuai dengan petunjuk<br>" +
                "<br>" +
                "<h4>Macam-macam Pernafasan</h4><br>" +
                "- Pernafasan bahu<br>" +
                "- Pernafasan dada<br>" +
                "- Pernafasan perut<br>" +
                "- Pernafasan sisi<br>" +
                "<br>" +
                "<h4>Alat-alat</h4><br>" +
                "- Lilin<br>" +
                "- Kapas<br>" +
                "- Tisu<br>" +
                "- Kertas<br>" +
                "- Balon<br>" +
                "- Sedotan Plastik<br>" +
                "- Peluit<br>" +
                "- Terompet<br>" +
                "- Harmonika<br>";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            binding.tvContent.setText(Html.fromHtml(content, Html.FROM_HTML_MODE_COMPACT));
        } else {
            binding.tvContent.setText(Html.fromHtml(content));
        }
//        binding.tvContent.setText(content);
    }

    private void setUpPelemasanOrgan() {
        binding.tvTitle.setText("Latihan Pelemasan Organ");
        binding.tvSubTitle.setText("Sumber Video : Youtube @bpmtpsidoarjo   ");
        String content = "<h4>Tujuan Program :</h4><br>" +
                "Melalui video, pendamping mampu melatih pelemasan organ bicara bibir, rahang dan lidah sesuai petunjuk\n";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            binding.tvContent.setText(Html.fromHtml(content, Html.FROM_HTML_MODE_COMPACT));
        } else {
            binding.tvContent.setText(Html.fromHtml(content));
        }
    }

    private void setUpPembentukanSuara() {
        binding.tvTitle.setText("Latihan Pembentukan Suara");
        binding.tvSubTitle.setText("Sumber Video : Youtube @bpmtpsidoarjo   ");
        String content = "<h4>Tujuan Pembelajaran</h4><br>" +
                "<br>" +
                "- Melalui Video pendampingmampu melatih dengan cara menirukan ucapan pada anak sesuai dengan petunjuk<br>" +
                "- Melalui video pendamping mampu mempraktikkan merasakan getaran pada anak sesuai dengan petunjuk<br>" +
                "- Melalui Video pendamping mampu melatih meraban<br>" +
                "<br>" +
                "<br>" +
                "Proses pembentukan suara terjadi ketika pita suara bergetar karena udara di dalam paru paru keluar sehingga bervibrasi dan menghasilkan berbagai macam gelombang suara yang kemudian melewati lorong fairing menuju ke rongga-rongga hidung dan mulut yang didalamnya terdapat alat artikulasi seperti lidah bibir dan gigi yang bertindak sebagai modulator.<br>" +
                "<br>" +
                "<br>" +
                "<br>";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            binding.tvContent.setText(Html.fromHtml(content, Html.FROM_HTML_MODE_COMPACT));
        } else {
            binding.tvContent.setText(Html.fromHtml(content));
        }
    }
}
