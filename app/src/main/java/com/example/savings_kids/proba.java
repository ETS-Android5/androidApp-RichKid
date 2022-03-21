package com.example.savings_kids;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class proba extends AppCompatActivity {

    //init variables
    private RadioButton rb1N, rb2N, rb3N;
    public Button btnNextN;
    private RadioButton radioButtonN;
    public int counterN;
    public RadioGroup radioGroupN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.proba_layout);

        //init elements
        rb1N = findViewById( (R.id.rb1N));
        rb2N = findViewById( (R.id.rb2N));
        rb3N = findViewById( (R.id.rb3N));
        btnNextN = findViewById(R.id.btnNextN);


    }
    private void checkAnswer(){
        RadioButton rbSelected = findViewById(radioGroupN.getCheckedRadioButtonId());

    }
}