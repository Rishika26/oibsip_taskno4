package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MovieActitvity extends AppCompatActivity {
    private TextView txtquestion, txtoption1, txtoption2, txtoption3, txtoption4;
    private Question[] questions;
    private int score;
    private int currentquesindex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_actitvity);

        txtquestion = findViewById(R.id.txtquestion);
        txtoption1 = findViewById(R.id.txtoption1);
        txtoption2 = findViewById(R.id.txtoption2);
        txtoption3 = findViewById(R.id.txtoption3);
        txtoption4 = findViewById(R.id.txtoption4);

        questions = new Question[]{
                new Question("Who plays the female lead in the movie 'Fashion'?",new String[]{"Priyanka Chopra","Kangana Ranaut","Alia Bhatt","Kareena Kapoor"},0),
                new Question("Who was the director of film Gully Boy?",new String[]{"Zoya Akhtar","Rajkumar Hirani","Rohit Shetty","Karan Johar"},0),
                new Question("Before he became the Bollywood superstar, Akshay Kumar, or Rajiv Hari Om Bhatia, worked in a travel agency in Kolkata, as a ______ in Dhaka.",new String[]{"Waiter","Chef","Barber","Plumber"},1),
                new Question("The first silent Hindi Film?",new String[]{"Kaagaz Ke Phool","Shree 420","Raja Harishchandra","Guddi"},2),
                new Question("The main center of production of Hindi movies is ______?",new String[]{"Bangalore","Mumbai","Delhi","Kolkata"},1),
                new Question("Which was India’s First Sound movie?",new String[]{"Waqt","Pyaasa","Alam Ara","Padosan"},2),
                new Question("Who was the first Indian Director to shoot at NASA?",new String[]{"Bimal Roy","Hrishikesh Mukherjee","Raj Kapoor","Ashutosh Gowariker"},3),
                new Question("What was the name of Amir Khan's Daughter in the movie 'Dangal'?",new String[]{"Ganga","Gauri","Siya","Geeta"},3),
                new Question("Who is considered the ‘Father of Indian Cinema’?",new String[]{"Dadasaheb Phalke","Guru Dutt","Hrishikesh Mukherjee","Raj Kapoor"},0),
                new Question("Who is the most awarded playback singer in Bollywood?",new String[]{"Lata Mangeshkar","Asha Bhosle","Mohammed Rafi","Kishore Kumar"},1)
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