package com.example.dietapp.Board;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dietapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class BoardMain extends AppCompatActivity {
   private RecyclerView recyclerView;
   private BoardAdapter adapter;
   private List<Board> boards = new ArrayList<>();
   private RecyclerView.LayoutManager layoutManager;
   private FirebaseDatabase database;
   private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.board_main);

       recyclerView = findViewById(R.id.b_recyclerview);
       recyclerView.setHasFixedSize(true);
       adapter = new BoardAdapter(this, boards);
       layoutManager = new LinearLayoutManager(getApplicationContext());
       recyclerView.setLayoutManager(layoutManager);


       database = FirebaseDatabase.getInstance();
       reference = database.getReference("board");
       reference.addListenerForSingleValueEvent(new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
             boards.clear();
             for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                Board Board = snapshot.getValue(Board.class);
                boards.add(Board);
             }
             adapter.notifyDataSetChanged();
          }

          @Override
          public void onCancelled(@NonNull DatabaseError error) {
            Log.e("BoardMain",String.valueOf(error.toException()));
          }
       });
    }
}



