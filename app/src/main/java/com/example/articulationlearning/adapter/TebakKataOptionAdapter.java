package com.example.articulationlearning.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.articulationlearning.databinding.RvItemTebakKataBinding;
import com.example.articulationlearning.model.ItemOptionModel;
import com.example.articulationlearning.util.BaseAppCompatActivity;

import java.util.ArrayList;

public class TebakKataOptionAdapter extends RecyclerView.Adapter<TebakKataOptionAdapter.ItemHolder> {
    ArrayList<ItemOptionModel> items = new ArrayList<>();
    private BaseAppCompatActivity activity;
    private OnClickAnswer onClickAnswer;


    public TebakKataOptionAdapter(BaseAppCompatActivity activity,  OnClickAnswer onClickAnswer) {
        this.activity = activity;
        this.onClickAnswer = onClickAnswer;
    }

    public void addItems(ArrayList<ItemOptionModel> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public void unselectedItem(ItemOptionModel item) {
        int i = 0;
        for (ItemOptionModel optionModel : items) {
            if (optionModel.getId() == item.getId()) {
                optionModel.setSelected(false);
                notifyItemChanged(i);
                return;
            }
            i++;
        }
    }

    public void unselectOption() {
        int i = 0;
        for (ItemOptionModel optionModel : items) {
            optionModel.setSelected(false);
            notifyItemChanged(i);
            i++;
        }
    }

    @NonNull
    @Override
    public TebakKataOptionAdapter.ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TebakKataOptionAdapter.ItemHolder(RvItemTebakKataBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TebakKataOptionAdapter.ItemHolder holder, int position) {
        ItemOptionModel itemOptionModel = items.get(position);
        if (onClickAnswer != null) {
            if (itemOptionModel.isSelected()) {
                holder.itemView.setVisibility(View.INVISIBLE);
            } else {
                holder.itemView.setVisibility(View.VISIBLE);
            }
        }
        holder.binding.tvText.setText(items.get(position).getText());
        holder.itemView.setOnClickListener(view -> {
            if (onClickAnswer != null) {
                if (!itemOptionModel.isSelected()) {
                    onClickAnswer.onClicked(itemOptionModel);
                    itemOptionModel.setSelected(true);
                    notifyItemChanged(holder.getLayoutPosition());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        private RvItemTebakKataBinding binding;

        public ItemHolder(RvItemTebakKataBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

    }

    public interface OnClickAnswer {
        void onClicked(ItemOptionModel itemOptionModel);
    }
}
