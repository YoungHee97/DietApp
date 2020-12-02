package com.example.dietapp.FastFood.BurgerKing;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dietapp.R;

import java.util.List;

public class KingAdapter extends RecyclerView.Adapter<KingAdapter.MyViewHolder>{
    private List<King> kingList;

    public KingAdapter(List<King> kingList){
        this.kingList = kingList;
    }

    @NonNull
    @Override
    public KingAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.king_item,parent,false);
        return new KingAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull KingAdapter.MyViewHolder holder, int position) {
        King king = kingList.get(position);
        holder.k_name.setText(king.getK_name());
        holder.k_calorie.setText(king.getK_calorie());
        holder.k_burger.setImageResource(king.getK_burger());
        holder.k_ex.setText(king.getK_ex());
    }

    @Override
    public int getItemCount() {
        return kingList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView k_burger;
        public TextView k_name, k_calorie, k_ex;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            k_burger = itemView.findViewById(R.id.d_donut);
            k_name = itemView.findViewById(R.id.d_name);
            k_calorie = itemView.findViewById(R.id.d_calorie);
            k_ex = itemView.findViewById(R.id.d_ex);
        }
    }
}
