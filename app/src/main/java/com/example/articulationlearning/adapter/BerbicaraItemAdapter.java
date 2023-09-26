package com.example.articulationlearning.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.articulationlearning.ActivityKonsonan;
import com.example.articulationlearning.BerbicaraDetailActivity;
import com.example.articulationlearning.PrawicaraItemActivity;
import com.example.articulationlearning.R;
import com.example.articulationlearning.databinding.RvItemMenuCategoryBinding;
import com.example.articulationlearning.util.BaseAppCompatActivity;

import java.util.ArrayList;

public class BerbicaraItemAdapter extends RecyclerView.Adapter<BerbicaraItemAdapter.ItemHolder> {
    ArrayList<String> items = new ArrayList<>();
    private BaseAppCompatActivity activity;

    public BerbicaraItemAdapter(BaseAppCompatActivity activity) {
        this.activity = activity;
    }

    public void addItems(ArrayList<String> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BerbicaraItemAdapter.ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BerbicaraItemAdapter.ItemHolder(RvItemMenuCategoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BerbicaraItemAdapter.ItemHolder holder, int position) {
        if (position == 0) {
            holder.binding.konsonanTxt.setText("Daftar Kata");
            holder.binding.konsonanTxtDesc.setText("2 Kategori");
            holder.binding.ivIcon.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_daftar));
            holder.binding.llParent.setBackground(ContextCompat.getDrawable(activity, R.drawable.background_green));
        } else if (position == 1) {
            holder.binding.konsonanTxt.setText("Daftar Kalimat");
            holder.binding.konsonanTxtDesc.setText("30 kalimat ejaan");
            holder.binding.ivIcon.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_xyz));
            holder.binding.llParent.setBackground(ContextCompat.getDrawable(activity, R.drawable.background_red));
        }
        holder.itemView.setOnClickListener(view -> {
            if(holder.getLayoutPosition()==0){
                activity.goToPage(BerbicaraDetailActivity.class);
            }else{
                activity.goToPage(ActivityKonsonan.class);
            }


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
