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

public class TebakKataAnswerAdapter extends RecyclerView.Adapter<TebakKataAnswerAdapter.ItemHolder> {
    ArrayList<ItemOptionModel> items = new ArrayList<>();
    private BaseAppCompatActivity activity;
    private TebakKataAnswerAdapter.OnClickAnswer onClickAnswer;
    private boolean isImageQuestion;

    public TebakKataAnswerAdapter(BaseAppCompatActivity activity, boolean isImageQuestion, TebakKataAnswerAdapter.OnClickAnswer onClickAnswer) {
        this.activity = activity;
        this.isImageQuestion = isImageQuestion;
        this.onClickAnswer = onClickAnswer;
    }

    public void addItems(ArrayList<ItemOptionModel> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public void clearItems() {
        this.items.clear();
        notifyDataSetChanged();
    }

    public void addItems(ItemOptionModel item) {
        this.items.add(item);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TebakKataAnswerAdapter.ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TebakKataAnswerAdapter.ItemHolder(RvItemTebakKataBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TebakKataAnswerAdapter.ItemHolder holder, int position) {
        ItemOptionModel itemOptionModel = items.get(position);
        holder.binding.tvText.setText(items.get(position).getText());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClickAnswer != null) {
                    items.remove(holder.getLayoutPosition());
                    notifyItemRemoved(holder.getLayoutPosition());
                    onClickAnswer.onClicked(itemOptionModel);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public String getAnswer() {
        int i = 0;
        StringBuilder text = new StringBuilder();
        for (ItemOptionModel optionModel : items) {
            if (isImageQuestion) {
                text.append(optionModel.getText());
            } else {
                if (i == items.size() - 1) {
                    text.append(optionModel.getText());
                } else {
                    text.append(optionModel.getText()).append(" ");
                }
            }
            i++;
        }
        return text.toString();
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