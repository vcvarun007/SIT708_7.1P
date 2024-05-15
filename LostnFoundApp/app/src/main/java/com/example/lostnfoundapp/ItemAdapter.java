package com.example.lostnfoundapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private List<String[]> itemList;
    private Context appContext;
    public ItemAdapter(Context context, List<String[]> items) {
        this.appContext = context;
        this.itemList = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_layout, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        String[] data = itemList.get(position);
        holder.itemTextView.setText(data[6].toUpperCase() + ": " + data[1]);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public TextView itemTextView;
        public ItemViewHolder(View itemView) {
            super(itemView);
            itemTextView = itemView.findViewById(R.id.item_desc);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ViewItem.class);
                    intent.putExtra("itemData", dataList.get(getAdapterPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
