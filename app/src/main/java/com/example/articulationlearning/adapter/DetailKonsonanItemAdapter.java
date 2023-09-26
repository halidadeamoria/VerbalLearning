package com.example.articulationlearning.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.articulationlearning.databinding.RvItemDataVoiceBinding;
import com.example.articulationlearning.util.onSelectedVideo;

import java.util.ArrayList;
import java.util.List;

public class DetailKonsonanItemAdapter extends RecyclerView.Adapter<DetailKonsonanItemAdapter.ItemHolder> {
    ArrayList<String> items = new ArrayList<>();
    ArrayList<Integer> videoId = new ArrayList<>();
    private Context activity;
    private MediaPlayer mediaPlayer;
    private onSelectedVideo onSelectedVideo;

    public DetailKonsonanItemAdapter(Context activity) {
        this.activity = activity;
    }
    public DetailKonsonanItemAdapter(Context activity, onSelectedVideo onSelectedVideo) {
        this.onSelectedVideo= onSelectedVideo;
        this.activity = activity;
    }

    public void addItems(List<String> items, List<Integer> videoId) {
        this.items.clear();
        this.items.addAll(items);

        this.videoId.clear();
        this.videoId.addAll(videoId);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DetailKonsonanItemAdapter.ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DetailKonsonanItemAdapter.ItemHolder(RvItemDataVoiceBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DetailKonsonanItemAdapter.ItemHolder holder, int position) {
        holder.binding.tvText.setText(items.get(holder.getLayoutPosition()));
        holder.binding.ivPlay.setOnClickListener(view -> {
            if(!videoId.isEmpty()) {
                onSelectedVideo.playVideo(videoId.get(holder.getLayoutPosition()));
            }else{
                Toast.makeText(activity, "no voice data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        private RvItemDataVoiceBinding binding;

        public ItemHolder(RvItemDataVoiceBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

    }
}
