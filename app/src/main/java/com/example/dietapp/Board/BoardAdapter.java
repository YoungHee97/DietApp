package com.example.dietapp.Board;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dietapp.R;

import java.util.ArrayList;
import java.util.List;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.BoardViewHolder> {

    private ArrayList<Board> arrayList;
    private Context context;

    public BoardAdapter(ArrayList<Board> arrayList, Context context){
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public BoardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BoardViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class BoardViewHolder extends RecyclerView.ViewHolder {
        public ImageView p_user;
        public TextView user, b_title, b_content;

        public BoardViewHolder(@NonNull View itemView) {
            super(itemView);
            this.p_user = itemView.findViewById(R.id.postAuthorPhoto);
            this.user = itemView.findViewById(R.id.user);
            this.b_title = itemView.findViewById(R.id.b_title);
            this.b_content = itemView.findViewById(R.id.b_content);
        }
    }

}
