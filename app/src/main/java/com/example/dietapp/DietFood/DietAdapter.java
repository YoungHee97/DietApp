package com.example.dietapp.DietFood;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dietapp.R;

import java.util.List;

public class DietAdapter extends RecyclerView.Adapter<DietAdapter.MyViewHolder> {
    private List<Diet> dietList;

    public DietAdapter(List<Diet> dietList){
        this.dietList = dietList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.diet_item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Diet diet = dietList.get(position);
        holder.name.setText(diet.getName());
        holder.tour_picture.setImageResource(diet.getDfood_picture());
        holder.explanation.setText(diet.getExplanation());
        holder.tno.setText(Integer.toString(diet.getTno()));
    }

    @Override
    public int getItemCount() {
        return dietList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name, explanation, tno;
        public ImageView tour_picture;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tour_picture = itemView.findViewById(R.id.dfood_picture);
            name = itemView.findViewById(R.id.h_title);
            explanation = itemView.findViewById(R.id.h_ex);
            tno = itemView.findViewById(R.id.hno);
        }

    }

}
