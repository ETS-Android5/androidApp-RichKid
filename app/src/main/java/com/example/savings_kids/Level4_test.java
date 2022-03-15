package com.example.savings_kids;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Level4_test extends AppCompatActivity {

    public int count = 0;
    public int btn1; //numLeft // переменная для картинки первой кнопки + текст
    public int btn2;
    public int btn3;
    public int vopros; //вместо numleft
    Array array = new Array();
    private TextView tvQuestion, tvQuestionNo, tvScore; //+tvScore, tvTimer
    private RadioGroup radioGroup;
    private RadioButton rb1, rb2, rb3;
    private Button btnNext;

    int totalQuestions;
    int qCounter = 0;

    int score;

    ColorStateList dfRbColor;
    boolean answered;

    private QuestionModel currentQuestion;

    private List<QuestionModel> questionList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);


        //ЧТО ОТОБРАЖАТЬСЯ БУДЕТ В УРОВНЕ
        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText((R.string.level1));


        //ТУТ ОГРОМНАЯ ВСТАВКА НАЧАЛО//
        questionList = new ArrayList<>();
        tvQuestion = findViewById((R.id.textQuestion));
        tvScore = findViewById(R.id.textScore);
        radioGroup = findViewById((R.id.radioGroup));
        rb1 = findViewById((R.id.rb1));
        rb2 = findViewById((R.id.rb2));
        rb3 = findViewById((R.id.rb3));
        btnNext = findViewById(R.id.btnNext);
        tvQuestionNo = findViewById(R.id.tvQuestionNo);
        dfRbColor = rb1.getTextColors();

        addQuestion();
        totalQuestions = questionList.size();
        showNextQuestion();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answered == false) {
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(Level4_test.this, "Выберите опцию", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
        //ТУТ ОГРОМНАЯ ВСТАВКА КОНЕЦ//


        //кнопка назад начало
        Button btn_back = (Button) findViewById(R.id.button_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Обрабатываем нажатие кнопки "Назад" начало
                try {
                    Intent intent = new Intent(Level4_test.this, Test.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    //здесь кода не будет
                }
                //Обрабатываем нажатие кнопки "Назад" конец
            }
        });
        //кнопка назад конец
    }


    private void checkAnswer() {
        answered = true;
        RadioButton rbSelected = findViewById(radioGroup.getCheckedRadioButtonId());
        int answerNo = radioGroup.indexOfChild(rbSelected) + 1;
        if (answerNo == currentQuestion.getCorrectAnsNo()) {
            if (count < 7) {
                count = count + 1;
            }
            score++;
            tvScore.setText("Правильных ответов: " + score);
        }


        rb1.setTextColor(Color.TRANSPARENT);
        rb2.setTextColor(Color.TRANSPARENT);
        rb3.setTextColor(Color.TRANSPARENT);
        switch (currentQuestion.getCorrectAnsNo()) {
            case 1:
                rb1.setTextColor(Color.BLACK);
                break;
            case 2:
                rb2.setTextColor(Color.BLACK);
                break;
            case 3:
                rb3.setTextColor(Color.BLACK);
                break;
        }
        if (qCounter < totalQuestions) {
            btnNext.setText("Следующий вопрос");
        } else {
            btnNext.setText("Finish");
            //
            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Обрабатываем нажатие кнопки "Назад" начало
                    try {
                        Intent intent = new Intent(Level4_test.this, Fragment.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {
                        //здесь кода не будет
                    }
                    //Обрабатываем нажатие кнопки "Назад" конец
                }
            });
            //
        }
    }

    //ТУТ ОГРОМНАЯ ВСТАВКА НАЧАЛО2//
    private void showNextQuestion() {

        radioGroup.clearCheck();
        rb1.setTextColor(dfRbColor);
        rb2.setTextColor(dfRbColor);
        rb3.setTextColor(dfRbColor);

        if (qCounter < totalQuestions) {
            currentQuestion = questionList.get(qCounter);
            tvQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());

            qCounter++;
            btnNext.setText("Проверить ответ");
            tvQuestionNo.setText("Вопрос: " + qCounter + "/" + totalQuestions);
            //tvQuestionNo.setText ("Question: " + qCounter+"/"+totalQuestions);
            answered = false;

        } else {
            finish();
        }
    }

    private void addQuestion() {
        questionList.add(new QuestionModel("Согласно Роберту Кийосаки одним из важнейших уроков в его жизни было как раз таки научиться понимать различия между Активом и Пассивом. Даже если сейчас для вас это звучит заумно, вообще-то все довольно просто: Активы это какие-либо ресурсы, приносящие прибыль в ваш карман, пассивы – наоборот съедающие.", "A", "B", "C", 1));
        questionList.add(new QuestionModel("B is correct", "A", "B", "C", 3));
        questionList.add(new QuestionModel("C is correct", "A", "B", "C", 3));
        questionList.add(new QuestionModel("A is correct", "A", "B", "C", 2));
        questionList.add(new QuestionModel("B is correct", "A", "B", "C", 1));
        questionList.add(new QuestionModel("A is correct", "A", "B", "C", 3));
        questionList.add(new QuestionModel("B is correct", "A", "B", "C", 2));
    }
    //ТУТ ОГРОМНАЯ ВСТАВКА Конец2//

    //Системная кнопка "Назад" начало
    @Override
    public void onBackPressed() {
        //Обрабатываем нажатие кнопки "Назад" начало
        try {
            Intent intent = new Intent(Level4_test.this, Test.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            //здесь кода не будет
        }
        //Обрабатываем нажатие кнопки "Назад" конец


    }
//Системная кнопка "Назад" конец
}