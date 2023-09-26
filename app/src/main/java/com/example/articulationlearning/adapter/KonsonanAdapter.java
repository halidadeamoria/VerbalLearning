package com.example.articulationlearning.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.articulationlearning.DetailLearningActivity;
import com.example.articulationlearning.databinding.RvItemKonsonanBinding;
import com.example.articulationlearning.model.LearningModel;
import com.example.articulationlearning.util.BaseAppCompatActivity;

import java.util.ArrayList;

public class KonsonanAdapter extends RecyclerView.Adapter<KonsonanAdapter.ItemHolder> {
    ArrayList<LearningModel> items = new ArrayList<>();
    private BaseAppCompatActivity activity;

    public KonsonanAdapter(BaseAppCompatActivity activity) {
        this.activity = activity;
    }

    public void addItems(ArrayList<LearningModel> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new KonsonanAdapter.ItemHolder(RvItemKonsonanBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        int a = items.get(position).getAscii();
        char b = (char) a;
        String strAsciiTab = Character.toString(b);
        holder.binding.tvText.setText(strAsciiTab);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("konsonan", items.get(holder.getLayoutPosition()));
                bundle.putInt("type",1);
                activity.goToPage(DetailLearningActivity.class, bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        private RvItemKonsonanBinding binding;

        public ItemHolder(RvItemKonsonanBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

    }
}
