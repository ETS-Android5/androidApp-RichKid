package com.example.savings_kids;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

//FIELDS
public class  Level2_test extends AppCompatActivity {
    public int count =0;
    public static int finalScore;
    Array array = new Array();
    private TextView textQuestion, tvQuestionNo, tvScore;
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
        setContentView(R.layout.universal_test);


        //TEXT
        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText((R.string.level2));



        //INIT OF ELEMENTS
        questionList = new ArrayList<>();
        textQuestion = findViewById( (R.id.textQuestion));  //+
        tvScore = findViewById(R.id.textScore);  //+
        radioGroup = findViewById( (R.id.radioGroup));  //+
        rb1 = findViewById( (R.id.rb1));  //+
        rb2 = findViewById( (R.id.rb2));  //+
        rb3 = findViewById( (R.id.rb3));  //+
        btnNext = findViewById(R.id.btnNext);   //+
        tvQuestionNo = findViewById(R.id.tvQuestionNo);  //+
        dfRbColor = rb1.getTextColors();
        addQuestion();
        totalQuestions = questionList.size();
        showNextQuestion();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answered == false){
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked()){
                        checkAnswer();
                    }else{
                        Toast.makeText(Level2_test.this, "Choose an option", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    showNextQuestion();
                }
            }
        });


        //BUTTON BACK
        ImageButton btn_back = (ImageButton) findViewById(R.id.back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent (Level2_test.this, Test.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                }
            }
        });

    }

    //METHOD CHECKANSWER
    private void checkAnswer() {
        answered = true;
        RadioButton rbSelected = findViewById(radioGroup.getCheckedRadioButtonId());
        int answerNo = radioGroup.indexOfChild (rbSelected) + 1;
        if (answerNo == currentQuestion.getCorrectAnsNo()){
            if (count < 7) {
                count = count + 1;
            }
            score++;
            tvScore.setText ("Number od correct answers: "+ score);
        }
        finalScore = score;

        //TEKST NIEPRAWIDLOWEJ ODP GRAY
        rb1.setTextColor(Color.GRAY);
        rb2.setTextColor(Color.GRAY);
        rb3.setTextColor(Color.GRAY);

        //PRZY PRAWIDLOWEJ ODPOWIEDZI TEKST PRAWIDLOWEJ ODP BLACK
        switch (currentQuestion.getCorrectAnsNo()){
            case 1:
                rb1.setTextColor(getColor(R.color.green));
                rb2.setTextColor(getColor(R.color.red));
                rb3.setTextColor(getColor(R.color.red));
                break;
            case 2:
                rb2.setTextColor(getColor(R.color.green));
                rb1.setTextColor(getColor(R.color.red));
                rb3.setTextColor(getColor(R.color.red));
                break;
            case 3:
                rb3.setTextColor(getColor(R.color.green));
                rb1.setTextColor(getColor(R.color.red));
                rb2.setTextColor(getColor(R.color.red));
                break;
        }

        //BUTTON NEXT/ FINISH
        if(qCounter < totalQuestions){
            btnNext.setText("Next question→");
        }else {
            btnNext.setText("Finish");




            //BUTTTON NEXT
            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try{
                        Intent intent = new Intent (Level2_test.this, Fragment.class);
                        startActivity(intent);
                        finish();
                    }catch (Exception e){
                    }
                }
            });
        }
    }


    //METHOD SHOW NEXT QUESTION
    private void showNextQuestion() {

        radioGroup.clearCheck();
        rb1.setTextColor(dfRbColor);
        rb2.setTextColor(dfRbColor);
        rb3.setTextColor(dfRbColor);

        if (qCounter < totalQuestions) {
            currentQuestion = questionList.get(qCounter);
            textQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());

            qCounter++;
            btnNext.setText("Check the answer");
            tvQuestionNo.setText("Question: " + qCounter+"/"+ totalQuestions);
            //tvQuestionNo.setText ("Question: " + qCounter+"/"+totalQuestions);
            answered = false;

        }else{
            finish();
        }
    }

    //METHOD ADDQUESTION
    private  void addQuestion(){
        questionList.add (new QuestionModel( "Why have taxes been created?", "To make lower paying jobs ", "To ensure national security, create new schools and roads", "To create an opponent to banks", 2));
        questionList.add (new QuestionModel( "In which document you can find out what taxes you need to pay?", "Tax Code", "Tax Book", "Tax Arrangement", 1));
        questionList.add (new QuestionModel( "Where does income tax come from?", "Non of the answers is correct", "Paid from bying grosseries", "Paid from basic income", 3));
        questionList.add (new QuestionModel( "What progressive tax is stands for?", "Percentage of tax does not depend on the size of the income", "Percentage of tax income is 30%", "More money you make, more tax percentage you'll pay", 3));
        questionList.add (new QuestionModel( "What linear tax is stands for?", "Percentage of tax does not depend on the size of the income", "Percentage of tax income is 30%", "More money you make, more tax percentage you'll pay", 1));
    }

    //BUTTON BACK SYSTEM
    @Override
    public void onBackPressed (){
        try{
            Intent intent = new Intent (Level2_test.this, Test.class);
            startActivity(intent);
            finish();
        }catch (Exception e){
        }
    }
}