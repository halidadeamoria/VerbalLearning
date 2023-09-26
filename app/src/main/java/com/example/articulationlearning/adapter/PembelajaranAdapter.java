package com.example.articulationlearning.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.articulationlearning.PrawicaraItemActivity;
import com.example.articulationlearning.R;
import com.example.articulationlearning.StartFunQuizyActivity;
import com.example.articulationlearning.databinding.RvItemMenuCategoryBinding;
import com.example.articulationlearning.databinding.RvItemMenuHomeBinding;
import com.example.articulationlearning.util.BaseAppCompatActivity;

import java.util.ArrayList;

public class PembelajaranAdapter extends RecyclerView.Adapter<PembelajaranAdapter.ItemHolder> {
    ArrayList<String> items = new ArrayList<>();
    private BaseAppCompatActivity activity;

    public PembelajaranAdapter(BaseAppCompatActivity activity) {
        this.activity = activity;
    }

    public void addItems(ArrayList<String> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PembelajaranAdapter.ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PembelajaranAdapter.ItemHolder(RvItemMenuCategoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PembelajaranAdapter.ItemHolder holder, int positionAdapter) {
        int position = holder.getLayoutPosition();
        if (position == 0) {
            holder.binding.konsonanTxt.setText("Pilihan Ganda");
            holder.binding.konsonanTxtDesc.setText("20 Soal");
            holder.binding.ivIcon.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_aio));
            holder.binding.llParent.setBackground(ContextCompat.getDrawable(activity, R.drawable.background_green));
        } else if (position == 1) {
            holder.binding.konsonanTxt.setText("Tebak Kata");
            holder.binding.konsonanTxtDesc.setText("20 Soal");
            holder.binding.ivIcon.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_xyz));
            holder.binding.llParent.setBackground(ContextCompat.getDrawable(activity, R.drawable.background_red));
        } else if (position == 2) {
            holder.binding.konsonanTxt.setText("Dwihuruf\n(Dwigfra)");
            holder.binding.konsonanTxtDesc.setText("9 Huruf ganda");
            holder.binding.ivIcon.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_ae));
            holder.binding.llParent.setBackground(ContextCompat.getDrawable(activity, R.drawable.background_yellow));
        }
        holder.itemView.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putInt("type", position);
            activity.goToPage(StartFunQuizyActivity.class, bundle);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        private RvItemMenuCategoryBinding binding;

        public ItemHolder(RvItemMenuCategoryBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

    }
}
