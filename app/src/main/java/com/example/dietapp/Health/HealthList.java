package com.example.dietapp.Health;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.dietapp.R;

import java.util.ArrayList;
import java.util.List;

public class HealthList extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Health> healthList = new ArrayList<>();
    private HealthAdapter hAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.heath_list);
        recyclerView = findViewById(R.id.h_recyclerview);
        hAdapter = new HealthAdapter(healthList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(hAdapter);
        prepareHealthData();
        final GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                String link;
                int h_picture;
                View child = rv.findChildViewUnder(e.getX(), e.getY());
                if(child != null && gestureDetector.onTouchEvent(e)){
                    TextView tv = recyclerView.getChildViewHolder(child).itemView.findViewById(R.id.hno);
                    h_picture = Integer.parseInt(tv.getText().toString());
                    link = healthList.get(h_picture).getLink();
                    Uri uri = Uri.parse(link);
                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);

                    startActivity(intent);
                }

                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
    }

    private void prepareHealthData(){
        Health health = new Health(R.drawable.h_1,"풀업","등 운동",1
        ,"https://www.youtube.com/watch?v=9lsqux_WcBo");
        healthList.add(health);

        health = new Health(R.drawable.h_2,"벤치프레스","가슴 운동",2
                ,"https://www.youtube.com/watch?v=0DsXTSHo3lU");
        healthList.add(health);

        health = new Health(R.drawable.h_3,"스쿼트","허벅지 운동",3
                ,"https://www.youtube.com/watch?v=QyAH8O5X6g0");
        healthList.add(health);

        health = new Health(R.drawable.h_4,"랫 풀 다운","등 운동",4
                ,"https://www.youtube.com/watch?v=2K2WCGstHOY");
        healthList.add(health);

        health = new Health(R.drawable.h_5,"사이드 레터럴 레이사이드","어깨 운동",5
                ,"https://www.youtube.com/watch?v=iNgwwI3WBTo");
        healthList.add(health);

        health = new Health(R.drawable.h_6,"플랭크 크런치","복근 운동",6
                ,"https://www.youtube.com/watch?v=60EtUkk9bx4");
        healthList.add(health);
    }
}