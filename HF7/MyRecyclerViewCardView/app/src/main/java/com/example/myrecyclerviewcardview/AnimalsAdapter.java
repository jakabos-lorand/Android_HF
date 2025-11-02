package com.example.myrecyclerviewcardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnimalsAdapter extends RecyclerView.Adapter<AnimalsAdapter.VH> {
    private Context context;
    private List<Animals> animals;

    public AnimalsAdapter(Context context, List<Animals> animals) {
        this.context = context;
        this.animals = animals;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.list_item, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Animals animal = animals.get(position);
        holder.image.setImageResource(animal.getImage());
        holder.name.setText(animal.getName());
        holder.description.setText(animal.getDescription());

        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(context, animal.getName(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView name;
        private  TextView description;

        public VH(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
        }
    }
}
