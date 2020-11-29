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
import com.google.firebase.database.ChildEventListener;
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
      RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
      recyclerView.setLayoutManager(manager);
      recyclerView.setAdapter(adapter);

      //layoutManager = new LinearLayoutManager(getApplicationContext());
     // recyclerView.setLayoutManager(layoutManager);

      database = FirebaseDatabase.getInstance();
      reference = database.getReference("board");
      reference.child("board").addChildEventListener(new ChildEventListener() {
         @Override
         public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            Board board = snapshot.getValue(Board.class);
            boards.add(board);
         }

         @Override
         public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

         }

         @Override
         public void onChildRemoved(@NonNull DataSnapshot snapshot) {

         }

         @Override
         public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

         }

         @Override
         public void onCancelled(@NonNull DatabaseError error) {

         }
      });

   }
}