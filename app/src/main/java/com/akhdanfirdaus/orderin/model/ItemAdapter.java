package com.akhdanfirdaus.orderin.model;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.akhdanfirdaus.orderin.DetailActivity;
import com.akhdanfirdaus.orderin.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ItemAdapter  extends RecyclerView.Adapter<ItemAdapter.ListViewHolder>{
    final private ArrayList<Item> listItem;

    public ItemAdapter(ArrayList<Item> listItem) {
        this.listItem = listItem;
    }

    @NonNull
    @Override
    public ItemAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ListViewHolder holder, int position) {
        Item item = listItem.get(position);
        holder.name.setText(item.getName());
        holder.price.setText("Rp. " + item.getPrice());

        InputStream ims = getClass().getResourceAsStream("/drawable/" + item.getPhoto());
        Drawable image = Drawable.createFromStream(ims, null);
        holder.photo.setBackground(image);
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView photo;
        public TextView name, price;
        public ListViewHolder(View itemView) {
            super(itemView);
            photo = itemView.findViewById(R.id.item_photo);
            name = itemView.findViewById(R.id.item_name);
            price = itemView.findViewById(R.id.item_price);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int selected = listItem.get(getLayoutPosition()).id;
            Intent intent = new Intent(view.getContext(), DetailActivity.class);
            intent.putExtra("id", selected);
            view.getContext().startActivity(intent);
        }
    }
}
