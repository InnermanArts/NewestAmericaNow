package com.example.dennisthicklin.naturalizationgame3.UI;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dennisthicklin.naturalizationgame3.R;

import java.util.Locale;

public class writingvocab_activity extends Activity {
    String[] words = new String[]{"second", "red", "four", "the", "Here", "In", "Most", "Largest", "First", "Fifty", "Dollar Bill", "Blue", "We", "To", "On", "Of", "During", "And", "Want", "One Hundred", "One", "People", "Vote", "Pay", "Meets", "Live", "Is", "Has", "Elect", "Come",
            "Can", "ThanksGiving", "Columbus", "Labor Day", "Independence Day", "Flag Day", "Patriotism", "Memorial Day", "President's Day", "January", "Februray", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December", "New York City", "United States",
            "Mexico", "Delaware", "White", "North", "Canada", "California", "Alaska", "White House", "State", "Senator", "Right", "President", "Freedom of Speech", "Free", "Flag", "Father of our Country", "Congress", "Civil War", "Citizens", "Capital", "American Indian", "Washington", "Lincoln", "Adams",
            "South"};



  TextToSpeech ttsObject; // Create a variable for text to speech
    int result; // Create an int and name it result
    int randomNumber; // Create an int and name it randomNumber(This variable will help you get a random word from the string).
    TextView wordLabel; // Create a textView and give it the id of the object on the activity.
    String text;
    Button switchWVChange;
    Button readButton;
    Button checkButton;// Create a string variable and name it text this will contribute to the process of getting the text to be spooken.
    Button homeButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writingvocab_activity);
        Toast.makeText(getApplicationContext(),"Welcome to Writing Vocabulary",Toast.LENGTH_LONG).show();


        ttsObject = new TextToSpeech(writingvocab_activity.this, new TextToSpeech.OnInitListener() {
            @Override // Implement override methods (onInit int status)
            public void onInit(int status) {


                if(status == TextToSpeech.SUCCESS){

                   result=  ttsObject.setLanguage(Locale.US);

                }else{
                    Toast.makeText(getApplicationContext(), "Text to Speech Not Supported on your Device", Toast.LENGTH_SHORT).show();
                }

            }
        });
        final MediaPlayer second = MediaPlayer.create(this, R.raw.second);
        final MediaPlayer wv_effect = MediaPlayer.create(this, R.raw.blop);

         switchWVChange = (Button) findViewById(R.id.changeWVText);
         readButton = (Button) findViewById(R.id.bspeak);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomNumber = (int) (Math.random() * words.length);
                Toast.makeText(getApplicationContext(),"New Word! Press Play!", Toast.LENGTH_LONG).show();
                wv_effect.start();


            }
        };
        switchWVChange.setOnClickListener(listener);

        final MediaPlayer check_sound = MediaPlayer.create(this, R.raw.click);
        final MediaPlayer right_sound = MediaPlayer.create(this, R.raw.right);
        final MediaPlayer wrong_sound = MediaPlayer.create(this, R.raw.wrong);
         checkButton = (Button) findViewById(R.id.checkButton);
        final EditText userInput = (EditText) findViewById(R.id.userInput);
        checkButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(userInput.getText().toString().equalsIgnoreCase(words[randomNumber]) ){
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    right_sound.start();

            }else if(!userInput.getText().toString().equalsIgnoreCase(words[randomNumber])){
                    Toast.makeText(getApplicationContext(),"Incorrect: " + words[randomNumber] , Toast.LENGTH_SHORT).show();
                    wrong_sound.start();
                }
                else{
                    Toast.makeText(getApplicationContext(), "The field is empty.", Toast.LENGTH_SHORT).show();
                }

            }


        });
        homeButton = (Button) findViewById(R.id.homeAmButton);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(writingvocab_activity.this, categoriesPage.class);
            startActivity(intent);
            }
        });

    }


//In order to generate the class below, you must give the object in the activity an onClick attribute. Give the attribute an apt name.
    public void readTheText(View view) {

        //This class allows the Text to be spoken by the device in English

            if(result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA){
                Toast.makeText(getApplicationContext(), "Text to Speech Not Supported on your Device", Toast.LENGTH_SHORT).show();

            }else{
                text = words[randomNumber].toString();

                ttsObject.speak(text, TextToSpeech.QUEUE_FLUSH, null);

            }

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(ttsObject != null){
            ttsObject.stop();
            ttsObject.shutdown();
        }
    }
}


