package com.example.savings_kids;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
public class Fragment extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        //FIELDS
        Button btnNextTest = (Button) findViewById(R.id.btnNextTest);
        TextView tvScore = findViewById(R.id.finalText);
        ImageButton back = findViewById(R.id.back);
        TextView dependResult = findViewById(R.id.dependText);

        View.OnClickListener btn = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.back:
                        Intent inte = new Intent(Fragment.this, Lesson1.class);
                        startActivity(inte);
                        finish();
                        break;
                    case R.id.btnNextTest:
                        Intent inteq = new Intent(Fragment.this, Test.class);
                        startActivity(inteq);
                        finish();
                        break;
                }
            }
        };
        back.setOnClickListener(btn);
        btnNextTest.setOnClickListener(btn);
        //STATIC FINAL SCORE
        try {
            tvScore.setText("Number od correct answers: " + Level1_test.finalScore);
        } catch (Exception e) {
        }

        //END STATIC FINAL SCORE
        //Result depend on finalScore for Level1
        switch (Level1_test.finalScore){
            case 1:
                dependResult.setText("We advise you to re-read Lesson number 1 again. In the future, it will be easier for you to understand how money works.");
                break;
            case 2:
                dependResult.setText("It is better to re-read Lesson number 1 again. In the future, it will be easier for you to understand how money works.");
                break;
            case 3:
                dependResult.setText("You are well-versed on the topic of Lesson number 1. Keep it up!");
                break;
            case 4:
                dependResult.setText("Well done! Brilliant result!");
                break;
            case 5:
                dependResult.setText("Well done! Brilliant result!");
                break;
        }
        //END Result depend on finalScore for Level1
        //Result depend on finalScore for Level2
        switch (Level3_test.finalScore){
            case 1:
                dependResult.setText("We advise you to re-read Lesson number 2 again. In the future, it will be easier for you to understand how money works.");
                break;
            case 2:
                dependResult.setText("It is better to re-read Lesson number 2 again. In the future, it will be easier for you to understand how money works.");
                break;
            case 3:
                dependResult.setText("You are well-versed on the topic of Lesson number 2. Keep it up!");
                break;
            case 4:
                dependResult.setText("Well done! Brilliant result!");
                break;
            case 5:
                dependResult.setText("Well done! Brilliant result!");
                break;
        }
        //END Result depend on finalScore for Level2
        //Result depend on finalScore for Level3
        switch (Level3_test.finalScore){
            case 1:
                dependResult.setText("We advise you to re-read Lesson number 3 again. In the future, it will be easier for you to understand how money works.");
                break;
            case 2:
                dependResult.setText("It is better to re-read Lesson number 3 again. In the future, it will be easier for you to understand how money works.");
                break;
            case 3:
                dependResult.setText("You are well-versed on the topic of Lesson number 3. Keep it up!");
                break;
            case 4:
                dependResult.setText("Well done! Brilliant result!");
                break;
        }
        //END Result depend on finalScore for Level3

    }

    //METHOD onBACKPRESSED
    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(Fragment.this, Test.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
        }
    }
    //END METHOD onBACKPRESSED
}