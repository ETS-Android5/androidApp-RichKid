package com.example.savings_kids;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Lesson1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urok1);

        ImageView btn_nextUrok = findViewById(R.id.Photo4);
        View.OnClickListener btn = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.Photo4:
                        Intent i = new Intent(Lesson1.this, Lesson2.class);
                        startActivity(i);
                        finish();
                        break;
                }
            }
        };
        btn_nextUrok.setOnClickListener(btn);

    }
    //Системная кнопка "Назад" начало
    @Override
    public void onBackPressed (){
        //Обрабатываем нажатие кнопки "Назад" начало
        try{
            Intent intent = new Intent (Lesson1.this, MainActivity.class);
            startActivity(intent);
            finish();
        }catch (Exception e){
            //здесь кода не будет
        }
        //Обрабатываем нажатие кнопки "Назад" конец


    }
    //Системная кнопка "Назад" конец
}