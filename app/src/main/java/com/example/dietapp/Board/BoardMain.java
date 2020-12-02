package com.example.dietapp.Board;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dietapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardMain extends AppCompatActivity {
   private RecyclerView recyclerView;
   private BoardAdapter adapter;
   private List<Board> boards = new ArrayList<>();
   private RecyclerView.LayoutManager layoutManager;
   private FirebaseDatabase database;
   private DatabaseReference reference;
   private static final String REQUIRED = "Required";

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.board_main);

      recyclerView = findViewById(R.id.b_recyclerview);
      recyclerView.setHasFixedSize(true);

      layoutManager = new LinearLayoutManager(getApplicationContext());
      recyclerView.setLayoutManager(layoutManager);

      database = FirebaseDatabase.getInstance();
      reference = database.getReference("board");
      reference.addListenerForSingleValueEvent(new ValueEventListener() {
         @Override
         public void onDataChange(@NonNull DataSnapshot snapshot) {
            boards.clear();
            for(DataSnapshot snapshot1 : snapshot.getChildren()){
               Board board = snapshot1.getValue(Board.class);
               boards.add(board);
            }
            adapter.notifyDataSetChanged();
         }

         @Override
         public void onCancelled(@NonNull DatabaseError error) {
            Log.e("BoardMainn",String.valueOf(error.toException()));
         }
      });

      adapter = new BoardAdapter(getApplicationContext(),boards);
      recyclerView.setAdapter(adapter);

      recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerView, new RecyclerTouchListener.ClickListener() {
         @Override
         public void onClick(View view, int position) {

         }

         @Override
         public void onLongClick(View view, int position) {

         }
      }));

      FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabNewPost);
      fab.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            showBoard(false,null,-1);
         }
      });
   }

   private void showBoard(final boolean shouldUpdate, final Board board, final int position) {
      LayoutInflater layoutInflaterAndroid = LayoutInflater.from(getApplicationContext());
      View view = layoutInflaterAndroid.inflate(R.layout.board_new, null);

      AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(BoardMain.this);
      alertDialogBuilderUserInput.setView(view);

      final EditText inputUser = view.findViewById(R.id.n_user);
      final EditText inputTitle = view.findViewById(R.id.n_title);
      final EditText inputContent = view.findViewById(R.id.n_content);
      TextView dialogTitle = view.findViewById(R.id.n_board);

      if (shouldUpdate && board != null) {
         inputUser.setText(board.getUser());
      }
      alertDialogBuilderUserInput
              .setCancelable(false)
              .setPositiveButton(shouldUpdate ? "update" : "save", new DialogInterface.OnClickListener() {
                 public void onClick(DialogInterface dialogBox, int id) {

                 }
              })
              .setNegativeButton("cancel",
                      new DialogInterface.OnClickListener() {
                         public void onClick(DialogInterface dialogBox, int id) {
                            dialogBox.cancel();
                         }
                      });

      final AlertDialog alertDialog = alertDialogBuilderUserInput.create();
      alertDialog.show();

      alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            // Show toast message when no text is entered
            if (TextUtils.isEmpty(inputUser.getText().toString())) {
               Toast.makeText(BoardMain.this, "Enter memo!", Toast.LENGTH_SHORT).show();
               return;
            } else {
               alertDialog.dismiss();
            }
            if(shouldUpdate && board != null){
               //updateMemo(inputTie.getText().toString(),inputContents.getText().toString(),position);
            }else{
               createBoard(inputUser.getText().toString(),inputTitle.getText().toString(),inputContent.getText().toString());
            }
         }
      });

   }

   private void createBoard(String user, String title, String content){
      reference = database.getReference("board");
      reference.addListenerForSingleValueEvent(new ValueEventListener() {
         @Override
         public void onDataChange(@NonNull DataSnapshot snapshot) {
            Board board = snapshot.getValue(Board.class);
            writeBoard(user,title,content);
            finish();
         }

         @Override
         public void onCancelled(@NonNull DatabaseError error) {

         }
      });
   }

   private void writeBoard(String user, String title, String content){
      Board board = new Board(user,title,content);
      Map<String, Object> boardValue = board.toMap();

      Map<String, Object> childupdates = new HashMap<>();
      childupdates.put("/board/",boardValue);
      reference.updateChildren(childupdates);

      //reference.updateChildren(boardValue);
   }

}