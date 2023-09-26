package com.example.articulationlearning.adapter;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.articulationlearning.AboutUsActivity;
import com.example.articulationlearning.ActivityBerbicara;
import com.example.articulationlearning.ActivityDwiHuruf;
import com.example.articulationlearning.ActivityKonsonan;
import com.example.articulationlearning.ActivityPraWicara;
import com.example.articulationlearning.ActivityVocal;
import com.example.articulationlearning.PembelajaranActivity;
import com.example.articulationlearning.R;
import com.example.articulationlearning.databinding.RvItemMenuHomeBinding;
import com.example.articulationlearning.util.BaseAppCompatActivity;

import java.util.ArrayList;

public class HomeMenuAdapter extends RecyclerView.Adapter<HomeMenuAdapter.ItemHolder> {
    ArrayList<Integer> items = new ArrayList<>();
    private BaseAppCompatActivity activity;

    public HomeMenuAdapter(BaseAppCompatActivity activity) {
        this.activity = activity;
    }

    public void addItems(ArrayList<Integer> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HomeMenuAdapter.ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeMenuAdapter.ItemHolder(RvItemMenuHomeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeMenuAdapter.ItemHolder holder, int position) {
        if (position == 0) {
            holder.binding.konsonanTxt.setText("Latihan Pra-Wicara");
            holder.binding.ivIcon.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_latprawicara));
            holder.binding.llParent.setBackground(ContextCompat.getDrawable(activity, R.drawable.bg_red));
        } else if (position == 1) {
            holder.binding.konsonanTxt.setText("Latihan Berbicara");
            holder.binding.ivIcon.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_latberbicara));
            holder.binding.llParent.setBackground(ContextCompat.getDrawable(activity, R.drawable.bg_blue));
        } else {
            holder.binding.konsonanTxt.setText("Pembelajaran");
            holder.binding.ivIcon.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_pembelajaran));
            holder.binding.llParent.setBackground(ContextCompat.getDrawable(activity, R.drawable.bg_yellow));
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == 0) {
                    activity.goToPage(ActivityPraWicara.class);
                } else if (position == 1) {
                    activity.goToPage(ActivityBerbicara.class);
                }else if (position == 2) {
                    activity.goToPage(PembelajaranActivity.class);
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putInt("type",3 );
                    activity.goToPage(AboutUsActivity.class, bundle);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        private RvItemMenuHomeBinding binding;

        public ItemHolder(RvItemMenuHomeBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

    }
}
