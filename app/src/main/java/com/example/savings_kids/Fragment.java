package com.example.savings_kids;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Fragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fragment); Button btnNextTest  = (Button) findViewById(R.id.btnNextTest);
        btnNextTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Обрабатываем нажатие кнопки "Назад" начало
                try{
                    Intent intent = new Intent (Fragment.this, Test.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    //здесь кода не будет
                }
                //Обрабатываем нажатие кнопки "Назад" конец
            }
        });
    }

    //Системная кнопка "Назад" начало
    @Override
    public void onBackPressed (){
        //Обрабатываем нажатие кнопки "Назад" начало
        try{
            Intent intent = new Intent (Fragment.this, Test.class);
            startActivity(intent);
            finish();
        }catch (Exception e){
            //здесь кода не будет
        }
        //Обрабатываем нажатие кнопки "Назад" конец


    }
    //Системная кнопка "Назад" конец
}