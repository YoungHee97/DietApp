package com.example.dietapp.FastFood.MacDonald;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dietapp.R;

import java.util.List;

public class MacdonaldAdapter extends RecyclerView.Adapter<MacdonaldAdapter.MyViewHolder> {
    private List<Macdonald> macdonaldList;

    public MacdonaldAdapter(List<Macdonald> macdonaldList){
        this.macdonaldList = macdonaldList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.macdonald_item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Macdonald macdonald = macdonaldList.get(position);
        holder.m_name.setText(macdonald.getM_name());
        holder.m_calorie.setText(macdonald.getM_calorie());
        holder.m_burger.setImageResource(macdonald.getM_burger());
        holder.m_ex.setText(macdonald.getM_ex());
    }

    @Override
    public int getItemCount() {
        return macdonaldList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView m_burger;
        public TextView m_name, m_calorie, m_ex;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            m_burger = itemView.findViewById(R.id.m_burger);
            m_name = itemView.findViewById(R.id.m_name);
            m_calorie = itemView.findViewById(R.id.m_calorie);
            m_ex = itemView.findViewById(R.id.m_ex);
        }
    }
}
