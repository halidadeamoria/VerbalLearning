package com.example.articulationlearning.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.articulationlearning.ActivityKonsonan;
import com.example.articulationlearning.BerbicaraDetailActivity;
import com.example.articulationlearning.R;
import com.example.articulationlearning.databinding.RvItemAnswerBinding;
import com.example.articulationlearning.databinding.RvItemMenuCategoryBinding;
import com.example.articulationlearning.util.BaseAppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class AnswerQuestionItemAdapter extends RecyclerView.Adapter<AnswerQuestionItemAdapter.ItemHolder> {
    ArrayList<String> items = new ArrayList<>();
    private BaseAppCompatActivity activity;
    private OnCLickAnswer onCLickAnswer;
    public AnswerQuestionItemAdapter(BaseAppCompatActivity activity, OnCLickAnswer onCLickAnswer) {
        this.activity = activity;
        this.onCLickAnswer = onCLickAnswer;
    }

    public void addItems(List<String> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AnswerQuestionItemAdapter.ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AnswerQuestionItemAdapter.ItemHolder(RvItemAnswerBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AnswerQuestionItemAdapter.ItemHolder holder, int position) {
       holder.binding.tvText.setText(items.get(position));
        holder.itemView.setOnClickListener(view -> {
            onCLickAnswer.clickedAnswer(holder.getLayoutPosition());
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        private RvItemAnswerBinding binding;

        public ItemHolder(RvItemAnswerBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

    }
    public interface OnCLickAnswer{
        void clickedAnswer(int position);
    }
}
