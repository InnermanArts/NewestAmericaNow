package com.example.dennisthicklin.naturalizationgame3.Methods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dennisthicklin on 1/19/16.
 */
public class multipleChoiceClass {
    static String[] correctAnswers = {
            "Constitution",
            "We the People",
            "Nine",
            "The President",
            "Fought for women's rights",
            "Provide schooling and education",
            "Star-Spangled Banner",
            "Freedom of speech and freedom of worship",
            "The President",
            "Franklin Roosevelt",
            "Democrats and Republicans",
            "The Constitution was written",
            "The Bill of Rights",
            "California",
            "To make treaties"
    };


    static String[] questions = {"What is the supreme law of the land?",
            "What are the first three words of the Preamble?",
            "How many justices are on the Supreme Court?",
            "Who is in charge of the Executive Branch?",
            "What did Susan B. Anthony do?",
            "What is one power state governments possess?",
            "What is the name of the national anthem?",
            "What are two rights given to United States citizens?",
            "Who vetoes bills?",
            "Who was President during the Great Depression and World War II?",
            "What are the two major political parties in the United States?",
            "What happened at the Constitutional Convention?",
            "What do we call the first ten amendments to the Constitution?",
            "Name one state that borders Mexico","What is one power of the federal government?"

    };

    Map<Integer, Question> questiondb = new HashMap<Integer, Question>();

    ArrayList<Integer> questionnum = new ArrayList<>();



    public void addQuestion(Question q)
    {
        questiondb.put(questionnum.size(), q);
        questionnum.add(questionnum.size());
    }

    public void randomize() {
        Collections.shuffle(questionnum);
    }


}
