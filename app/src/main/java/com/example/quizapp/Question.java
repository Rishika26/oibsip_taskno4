package com.example.quizapp;

public class Question {
    private String question;
    private String[] options;
    private int correct;

    public Question(String question, String[] options, int correct){
        this.question=question;
        this.options=options;
        this.correct=correct;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrect() {
        return correct;
    }
}
