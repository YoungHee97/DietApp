package com.example.dietapp.Board;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dietapp.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.BoardViewHolder> {

    private List<Board> boards;
    private Context context;

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

    public BoardAdapter(Context context, List<Board> boards){
        this.context = context;
        this.boards = boards;
    }

    @NonNull
    @Override
    public BoardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.board_list,parent,false);

        return new BoardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BoardViewHolder holder, int position) {
        Board board = boards.get(position);
        holder.user.setText(board.getUser());
        holder.b_title.setText(board.getTitle());
        holder.b_content.setText(board.getContent());
    }

    @Override
    public int getItemCount() {
        return boards.size();
    }

}
