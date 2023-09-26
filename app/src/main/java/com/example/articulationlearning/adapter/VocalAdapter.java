package com.example.articulationlearning.adapter;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.articulationlearning.DetailLearningActivity;
import com.example.articulationlearning.databinding.RvItemVocalBinding;
import com.example.articulationlearning.model.LearningModel;
import com.example.articulationlearning.util.BaseAppCompatActivity;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class VocalAdapter  extends RecyclerView.Adapter<VocalAdapter.ItemHolder> {
    ArrayList<LearningModel> items = new ArrayList<>();
    private BaseAppCompatActivity activity;
    private int type;

    public VocalAdapter(BaseAppCompatActivity activity, int type) {
        this.activity = activity;
        this.type= type;
    }

    public void addItems(ArrayList<LearningModel> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VocalAdapter.ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VocalAdapter.ItemHolder(RvItemVocalBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VocalAdapter.ItemHolder holder, int position) {
        holder.binding.tvText1.setText(activity.getString(items.get(position).getTitle(type)));
        holder.binding.tvText2.setText(activity.getString(items.get(position).getSubtitle(type)));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("konsonan", items.get(holder.getLayoutPosition()));
                bundle.putInt("type",type);
                activity.goToPage(DetailLearningActivity.class, bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        private RvItemVocalBinding binding;

        public ItemHolder(RvItemVocalBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

    }
}

