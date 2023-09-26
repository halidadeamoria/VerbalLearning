package com.example.articulationlearning.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.articulationlearning.AboutUsActivity;
import com.example.articulationlearning.ActivityDwiHuruf;
import com.example.articulationlearning.ActivityKonsonan;
import com.example.articulationlearning.ActivityVocal;
import com.example.articulationlearning.R;
import com.example.articulationlearning.databinding.RvItemMenuCategoryBinding;
import com.example.articulationlearning.util.BaseAppCompatActivity;

import java.util.ArrayList;

public class KategoriMenuAdapter extends RecyclerView.Adapter<KategoriMenuAdapter.ItemHolder> {
    ArrayList<Integer> items = new ArrayList<>();
    private BaseAppCompatActivity activity;

    public KategoriMenuAdapter(BaseAppCompatActivity activity) {
        this.activity = activity;
    }

    public void addItems(ArrayList<Integer> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public KategoriMenuAdapter.ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new KategoriMenuAdapter.ItemHolder(RvItemMenuCategoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull KategoriMenuAdapter.ItemHolder holder, int positionAdapter) {
        int position= holder.getLayoutPosition();
        if (position == 0) {
            holder.binding.konsonanTxt.setText("Huruf Vokal");
            holder.binding.konsonanTxtDesc.setText("5 Huruf");
            holder.binding.ivIcon.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_aio));
            holder.binding.llParent.setBackground(ContextCompat.getDrawable(activity, R.drawable.background_green));
        } else if (position == 1) {
            holder.binding.konsonanTxt.setText("Huruf Konsonan");
            holder.binding.konsonanTxtDesc.setText("21 Huruf");
            holder.binding.ivIcon.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_xyz));
            holder.binding.llParent.setBackground(ContextCompat.getDrawable(activity, R.drawable.background_red));
        } else if (position == 2) {
            holder.binding.konsonanTxt.setText("Dwihuruf\n(Dwigfra)");
            holder.binding.konsonanTxtDesc.setText("9 Huruf ganda");
            holder.binding.ivIcon.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_ae));
            holder.binding.llParent.setBackground(ContextCompat.getDrawable(activity, R.drawable.background_yellow));
        }
//        else {
//            holder.binding.konsonanTxt.setText("Latihan Pernafasan");
//            holder.binding.ivIcon.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_vector));
//            holder.binding.llParent.setBackground(ContextCompat.getDrawable(activity, R.drawable.bg_blue));
//        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == 0) {
                    activity.goToPage(ActivityVocal.class);
                } else if (position == 1) {
                    activity.goToPage(ActivityKonsonan.class);
                } else if (position == 2) {
                    activity.goToPage(ActivityDwiHuruf.class);
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putInt("type",3);
                    activity.goToPage(AboutUsActivity.class, bundle);
                }
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
