package com.example.dietapp.FastFood.MacDonald;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.dietapp.R;

import java.util.ArrayList;
import java.util.List;

public class Macdonald_list extends AppCompatActivity {
    private RecyclerView m_recyclerView;
    private List<Macdonald> macdonaldList = new ArrayList<>();
    private MacdonaldAdapter macdonaldAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.macdonald_);
        m_recyclerView = findViewById(R.id.m_recyclerView);
        macdonaldAdapter = new MacdonaldAdapter(macdonaldList);
        m_recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        m_recyclerView.setAdapter(macdonaldAdapter);
        prepareMc();

    }

    private void prepareMc(){
        Macdonald macdonald = new Macdonald(R.drawable.bigmack,"빅맥R 세트","902kcal","계단 오르기: 2시간 15분\n 자전거: 3시간\n 조깅: 1시간 30분");
        macdonaldList.add(macdonald);

        macdonald = new Macdonald(R.drawable.b1955,"1955R 세트","850kcal","계단 오르기: 2시간 7분\n 자전거: 2시간 48분\n 조깅: 1시간 15분");
        macdonaldList.add(macdonald);

        macdonald = new Macdonald(R.drawable.shanghai,"맥스파이시R 상하이 세트","833kcal","계단 오르기: 2시간 5분\n 자전거: 2시간 42분\n 조깅: 1시간 12분");
        macdonaldList.add(macdonald);

        macdonald = new Macdonald(R.drawable.quarter,"쿼터파운더R 세트","885kcal","계단 오르기: 2시간 12분\n 자전거: 2시간 56분\n 조깅: 1시간 26분");
        macdonaldList.add(macdonald);
    }
}