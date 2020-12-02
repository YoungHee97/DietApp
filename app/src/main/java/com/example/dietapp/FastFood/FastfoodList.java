package com.example.dietapp.FastFood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.dietapp.FastFood.BurgerKing.King_list;
import com.example.dietapp.FastFood.MacDonald.Macdonald_list;
import com.example.dietapp.R;

public class FastfoodList extends AppCompatActivity {
    ImageView image, image2, image3, image4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fastfood_list);

        image = (ImageView) findViewById(R.id.mcdonald);
        image2 = (ImageView) findViewById(R.id.burgerking);

        final Intent intent = new Intent(this, Macdonald_list.class);
        final Intent intent2 = new Intent(this, King_list.class);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent2);
            }
        });
    }
}