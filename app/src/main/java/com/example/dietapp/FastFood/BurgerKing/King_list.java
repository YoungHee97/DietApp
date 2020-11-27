package com.example.dietapp.FastFood.BurgerKing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.dietapp.R;

import java.util.ArrayList;
import java.util.List;

public class King_list extends AppCompatActivity {

    private RecyclerView k_recyclerView;
    private List<King> kingList = new ArrayList<>();
    private KingAdapter kingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.king);
        k_recyclerView = findViewById(R.id.k_recyclerView);
        kingAdapter = new KingAdapter(kingList);
        k_recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        k_recyclerView.setAdapter(kingAdapter);
        prepareK();
    }

    private void prepareK(){
        King king = new King(R.drawable.k_cheese,"콰드로치즈와퍼","769kcal","계단 오르기: 1시간 54분\n 자전거: 2시간 30분\n 조깅: 1시간 12분");
        kingList.add(king);

        king = new King(R.drawable.k_g,"기네스와퍼","778kcal","계단 오르기: 1시간 56분\n 자전거: 2시간 35분\n 조깅: 1시간 29분");
        kingList.add(king);

        king = new King(R.drawable.k_m,"몬스터와퍼","1055kcal","계단 오르기: 2시간 36분\n 자전거: 3시간 30분\n 조깅: 1시간 45분");
        kingList.add(king);

        king = new King(R.drawable.k_w,"와퍼버거","619kcal","계단 오르기: 1시간 30분\n 자전거: 2시간 2분\n 조깅: 1시간");
        kingList.add(king);
    }
}