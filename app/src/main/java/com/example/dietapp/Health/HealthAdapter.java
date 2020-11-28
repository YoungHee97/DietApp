package com.example.dietapp.Health;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dietapp.R;

import java.util.List;

public class HealthAdapter extends RecyclerView.Adapter<HealthAdapter.MyViewHolder> {
    private List<Health> healthList;

    public HealthAdapter(List<Health> healthList){
        this.healthList = healthList;
    }

    @NonNull
    @Override
    public HealthAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.heath_item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HealthAdapter.MyViewHolder holder, int position) {
        Health health = healthList.get(position);
        holder.h_title.setText(health.getH_title());
        holder.h_picture.setImageResource(health.getH_picture());
        holder.h_ex.setText(health.getH_ex());
        holder.hno.setText(Integer.toString(health.getHno()));
    }

    @Override
    public int getItemCount() {
        return healthList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView h_title, h_ex, hno;
        public ImageView h_picture;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            h_picture = itemView.findViewById(R.id.h_picture);
            h_title = itemView.findViewById(R.id.h_title);
            h_ex = itemView.findViewById(R.id.h_ex);
            hno = itemView.findViewById(R.id.hno);
        }

    }
}
