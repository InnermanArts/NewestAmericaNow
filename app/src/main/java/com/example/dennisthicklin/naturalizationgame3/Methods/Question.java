package com.example.dennisthicklin.naturalizationgame3.Methods;

/**
 * Created by dennisthicklin on 1/25/16.
 */
public class Question {
    public String question;
    public String[] answer;
    public int right;
    public QType type;
    public Question(String q, QType type, int right, String ... a )
    {
        this.question = q;
        this.answer = a;
        this.right = right;
        this.type = type;
    }
}
