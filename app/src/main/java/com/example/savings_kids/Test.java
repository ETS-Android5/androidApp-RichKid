package com.example.savings_kids;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);



        ImageButton test1 = findViewById(R.id.Test1);
        ImageButton test2 = findViewById(R.id.Test2);
        ImageButton test3 = findViewById(R.id.Test3);
        ImageButton test4 = findViewById(R.id.Test4);
        ImageButton back = findViewById(R.id.back);
        View.OnClickListener btn = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.Test1:
                        Intent i = new Intent(Test.this, Level1_test.class);
                        startActivity(i);
                        finish();
                        break;
                    case R.id.Test2:
                        Intent in = new Intent(Test.this, Level2_test.class);
                        startActivity(in);
                        finish();
                        break;
                    case R.id.Test3:
                        Intent inte = new Intent(Test.this, Level3_test.class);
                        startActivity(inte);
                        finish();
                        break;
                    case R.id.Test4:
                        Intent inten = new Intent(Test.this, Level4_test.class);
                        startActivity(inten);
                        finish();
                        break;
                    case R.id.back:
                        Intent intentt = new Intent(Test.this, MainActivity.class);
                        startActivity(intentt);
                        finish();
                        break;
                }
            }
        };
        test1.setOnClickListener(btn);
        test2.setOnClickListener(btn);
        test3.setOnClickListener(btn);
        test4.setOnClickListener(btn);
        back.setOnClickListener(btn);

    }

    @Override
    public void onBackPressed (){

        try{
            Intent intent = new Intent (Test.this, MainActivity.class);
            startActivity(intent);
            finish();
        }catch (Exception e){
        }
    }
}
