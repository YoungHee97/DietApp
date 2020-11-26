package com.example.dietapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.dietapp.DietFood.Diet_list;
import com.example.dietapp.FastFood.FastfoodList;

public class MainList extends AppCompatActivity {
    ImageView image, image2, image3, image4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_list);

        image = (ImageView) findViewById(R.id.fastfoodButton);
        image2 = (ImageView) findViewById(R.id.healthButton);
        image3 = (ImageView) findViewById(R.id.dietfoodButton);
        image4 = (ImageView) findViewById(R.id.serviceButton);

        final Intent intent = new Intent(this, FastfoodList.class);
        //final Intent intent2 = new Intent(this,);
        final Intent intent3 = new Intent(this, Diet_list.class);

        image.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        image3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(intent3);
            }
        });

    }
}