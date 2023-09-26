package com.example.articulationlearning.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.articulationlearning.ActivityKonsonan;
import com.example.articulationlearning.BerbicaraDetailActivity;
import com.example.articulationlearning.R;
import com.example.articulationlearning.databinding.RvItemDataBerbicaraBinding;
import com.example.articulationlearning.databinding.RvItemMenuCategoryBinding;
import com.example.articulationlearning.model.BerbicaraModel;
import com.example.articulationlearning.util.BaseAppCompatActivity;
import com.example.articulationlearning.util.onSelectedVideo;

import java.util.ArrayList;

public class DetailBerbicaraItemAdapter extends RecyclerView.Adapter<DetailBerbicaraItemAdapter.ItemHolder> {
    ArrayList<BerbicaraModel> items = new ArrayList<>();
    private BaseAppCompatActivity activity;
    private onSelectedVideo onSelectVideo;

    public DetailBerbicaraItemAdapter(BaseAppCompatActivity activity, onSelectedVideo onSelectVideo) {
        this.activity = activity;
        this.onSelectVideo= onSelectVideo;
    }

    public void addItems(ArrayList<BerbicaraModel> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DetailBerbicaraItemAdapter.ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DetailBerbicaraItemAdapter.ItemHolder(RvItemDataBerbicaraBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DetailBerbicaraItemAdapter.ItemHolder holder, int position) {
            holder.binding.tvText.setText(items.get(position).getText());

        holder.itemView.setOnClickListener(view -> {
            this.onSelectVideo.playVideo(items.get(position).getVideoId());


        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        private RvItemDataBerbicaraBinding binding;

        public ItemHolder(RvItemDataBerbicaraBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

    }
}
