package com.qgestures;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CarouselAdapter extends RecyclerView.Adapter<CarouselAdapter.ViewHolder> {

    private List<Integer> items = new ArrayList<>();

    public CarouselAdapter() {
        items.add(R.drawable.apple);
        items.add(R.drawable.asparagus);
        items.add(R.drawable.banana);
        items.add(R.drawable.broccoli);
        items.add(R.drawable.carrot);
        items.add(R.drawable.cinnamon);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carousel_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.icon.setImageResource(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        final ImageView icon;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
        }

    }
}
