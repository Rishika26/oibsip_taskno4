package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import com.example.quizapp.Question;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class GkquizActivity extends AppCompatActivity {

    private TextView txtquestion, txtoption1, txtoption2, txtoption3, txtoption4;
    private Question[] questions;
    private int score;
    private int currentquesindex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gkquiz);

        txtquestion = findViewById(R.id.txtquestion);
        txtoption1 = findViewById(R.id.txtoption1);
        txtoption2 = findViewById(R.id.txtoption2);
        txtoption3 = findViewById(R.id.txtoption3);
        txtoption4 = findViewById(R.id.txtoption4);

        questions = new Question[]{
                new Question("What country has the highest life expectancy?",new String[]{"Denmark","Japan","Hong Kong","United States"},2),
                new Question("How many elements are in the periodic table? ",new String[]{"118","132","111","120"},0),
                new Question("What country drinks the most coffee per capita?",new String[]{"Italy","Finland","France","China"},1),
                new Question("Which planet in the Milky Way is the hottest?",new String[]{"Saturn","Mars","Jupiter","Venus"},3),
                new Question("What city is known as \"The Eternal City\"? ",new String[]{"London","Rome","Chicago","Paris"},1),
                new Question("What company was initially known as \"Blue Ribbon Sports\"?",new String[]{"Nike","Adidas","Monte Carlo","Allen Solly"},0),
                new Question("Which planet has the most moons?",new String[]{"Mars","Earth","Saturn","Venus"},2),
                new Question("In what country would you find Mount Kilimanjaro?",new String[]{"Toronto","Tanzania","Beijing","Shanghai"},1),
                new Question("How many bones do we have in an ear?",new String[]{"5","4","3","2"},2),
                new Question("In what country is the Chernobyl nuclear plant located?",new String[]{"Italy","Denmark","Hong Kong","Ukraine"},3)
        };

        currentquesindex = 0;
        score = 0;
        showQuestion();

        txtoption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(0);
            }
        });

        txtoption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(1);
            }
        });

        txtoption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(2);
            }
        });

        txtoption4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(3);
            }
        });

    }
    private void showQuestion(){
        Question currentques = questions[currentquesindex];
        txtquestion.setText(currentques.getQuestion());
        String[] options = currentques.getOptions();
        txtoption1.setText(options[0]);
        txtoption2.setText(options[1]);
        txtoption3.setText(options[2]);
        txtoption4.setText(options[3]);
    }

    private void checkAnswer(int selectedOptionIndex){
        Question currentques = questions[currentquesindex];
        if(selectedOptionIndex == currentques.getCorrect()){
            score++;
        }
        currentquesindex++;
        if(currentquesindex<questions.length){
            showQuestion();
        }
        else {
            Toast.makeText(this, "Quiz completed!! Score : "+score, Toast.LENGTH_LONG).show();
        }
    }
}