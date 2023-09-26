package com.example.articulationlearning.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.articulationlearning.AboutUsActivity;
import com.example.articulationlearning.ActivityKonsonan;
import com.example.articulationlearning.ActivityVocal;
import com.example.articulationlearning.PrawicaraItemActivity;
import com.example.articulationlearning.R;
import com.example.articulationlearning.databinding.RvItemMenuHomeBinding;
import com.example.articulationlearning.util.BaseAppCompatActivity;

import java.util.ArrayList;

public class PrawicaraAdapter extends RecyclerView.Adapter<PrawicaraAdapter.ItemHolder> {
    ArrayList<String> items = new ArrayList<>();
    private BaseAppCompatActivity activity;

    public PrawicaraAdapter(BaseAppCompatActivity activity) {
        this.activity = activity;
    }

    public void addItems(ArrayList<String> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PrawicaraAdapter.ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PrawicaraAdapter.ItemHolder(RvItemMenuHomeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PrawicaraAdapter.ItemHolder holder, int position) {
        holder.binding.konsonanTxt.setText(items.get(holder.getLayoutPosition()));
        holder.binding.llParent.setBackground(ContextCompat.getDrawable(activity, R.drawable.bg_red));
        holder.binding.ivIcon.setVisibility(View.GONE);

        holder.itemView.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putInt("type", holder.getLayoutPosition());
            activity.goToPage(PrawicaraItemActivity.class, bundle);

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