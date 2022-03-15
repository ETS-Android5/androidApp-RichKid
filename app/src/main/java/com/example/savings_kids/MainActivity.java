package com.example.savings_kids;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    TextView language_dialog,slovar1;
    boolean lang_selected;
    Context context;
    Resources resources;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Кнопка перехода на тесты

        ImageButton one1 = findViewById(R.id.one1);
        ImageButton two2 = findViewById(R.id.two2);
        ImageButton three3 = findViewById(R.id.three3);
        ImageButton four4 = findViewById(R.id.four4);

        ImageButton back = findViewById(R.id.back);


        View.OnClickListener btn = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.one1:
                        Intent inte = new Intent(MainActivity.this, Urok1.class);
                        startActivity(inte);
                        finish();
                        break;
                    case R.id.two2:
                        Intent inten = new Intent(MainActivity.this, Urok2.class);
                        startActivity(inten);
                        finish();
                        break;
                    case R.id.three3:
                        Intent intent = new Intent(MainActivity.this, Urok3.class);
                        startActivity(intent);
                        finish();
                        break;
                    case R.id.four4:
                        Intent intent1 = new Intent(MainActivity.this, Urok4.class);
                        startActivity(intent1);
                        finish();
                        break;
                    case R.id.back:
                        Intent in = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(in);
                        finish();
                        break;
                    /*case R.id.tests:
                        Intent t = new Intent(MainActivity.this, Test.class);
                        startActivity(t);
                        finish();
                        break;*/
                }
            }
        };
        one1.setOnClickListener(btn);
        two2.setOnClickListener(btn);
        three3.setOnClickListener(btn);
        four4.setOnClickListener(btn);
        //barTests.setOnClickListener(btn);
        back.setOnClickListener(btn);
        }






}