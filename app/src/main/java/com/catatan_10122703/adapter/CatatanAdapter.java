package com.catatan_10122703.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.catatan_10122703.R;
import com.catatan_10122703.model.Catatan;
import com.catatan_10122703.view.activity.AddCatatanActivity;

import java.util.List;

public class CatatanAdapter extends RecyclerView.Adapter<CatatanAdapter.ViewHolder> {//10122703 - Mochammad Rizqi Maulana - IF1

    private List<Catatan> catatans;

    public CatatanAdapter(List<Catatan> catatans) {
        this.catatans = catatans;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_catatan, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(catatans.get(position).getTitle());
        holder.category.setText(catatans.get(position).getCategory());
        holder.desc.setText(catatans.get(position).getDesc());
        holder.date.setText(catatans.get(position).getDate());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), AddCatatanActivity.class);
            intent.putExtra("Catatan", catatans.get(position));
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return catatans.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView category;
        TextView desc;
        TextView date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_catatan);
            category = itemView.findViewById(R.id.category_catatan);
            desc = itemView.findViewById(R.id.desc_catatan);
            date = itemView.findViewById(R.id.date_catatan);
        }
    }
}


