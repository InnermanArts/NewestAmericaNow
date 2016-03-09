package com.example.dennisthicklin.naturalizationgame3.UI;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dennisthicklin.naturalizationgame3.R;

import java.util.Locale;


public class readvocab_activity extends ActionBarActivity implements TextToSpeech.OnInitListener {
View main = null;



    String words[] = {
            "delegate",
            "platform",
            "majority",
            "candidate",
            "liberty",
            "social contract",
            "republic",
            "legislator",
            "judge",
            "democrat",
            "republican",
            "government",
            "branch",
            "proclamation",
            "ammendment",
            "article",
            "natural rights",
            "civil rights"
            , "democracy",
            "Constitution",
            "Washington",
            "Lincoln",
            "Jefferson",
            "The Preamble",
            "The Bill of Rights",
            "civil liberties",
            "free speech",
            "petition",
            "Senate",
            "House of Representatives",
            "president",
            "United States",
            "Executive Branch",
            "Legislative Branch",
            "Judicial Branch"};

    int randomWord;
    int result;
    String text;
    TextView userSpeech;
    TextToSpeech ttsObject;
    private Locale[] languages = {Locale.US};
    private Locale currentLang = Locale.US;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readvocab_activity);
        final TextView rWordView = (TextView) findViewById(R.id.rWordView);
        Button recordButton = (Button) findViewById(R.id.recordButton);
        Button readButton = (Button) findViewById(R.id.readButton);
        Button changeText = (Button) findViewById(R.id.changeButton);
        final MediaPlayer checkEffect = MediaPlayer.create(this, R.raw.click);
        final MediaPlayer changeEffect = MediaPlayer.create(this, R.raw.blop);
        ImageButton homeRButton = (ImageButton) findViewById(R.id.homeRButton);
        rWordView.setText("Tap the Arrow Below");

        Toast.makeText(getApplicationContext(), "Welcome to Reading Vocabulary", Toast.LENGTH_LONG ).show();


        homeRButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeRIntent = new Intent(readvocab_activity.this, categoriesPage.class);
                startActivity(homeRIntent);
            }
        });
        ttsObject = new TextToSpeech(readvocab_activity.this, new TextToSpeech.OnInitListener() {
            @Override // Implement override methods (onInit int status)
            public void onInit(int status) {



                if (status == TextToSpeech.SUCCESS) {

                    result = ttsObject.setLanguage(Locale.US);

                } else {
                    Toast.makeText(getApplicationContext(), "Text to Speech Not Supported on your Device", Toast.LENGTH_SHORT).show();
                }

            }
        });

        recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AcquireSpeechInput();
            }
        });
        changeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               randomWord = (int) (Math.random() * words.length);
               rWordView.setText(words[randomWord]);
                Log.v("Next Word", Integer.toString(randomWord));

                changeEffect.start();

            }
        });

       
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_readvocab_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(ttsObject != null){
            ttsObject.stop();
            ttsObject.shutdown();
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void readTheText(View view) {


        ttsObject.setLanguage(currentLang);

        if (result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA) {
            Toast.makeText(getApplicationContext(), "Text to Speech Not Supported on your Device", Toast.LENGTH_SHORT).show();

        } else {
            text = words[randomWord].toString();

            ttsObject.speak(text, TextToSpeech.QUEUE_FLUSH, null);

        }

    }


    //Go to the xml and create a onClick attribute then create a class for it

    public void AcquireSpeechInput() {
        // Create an intent in order to convert speech to text
        // This unique intent recognizes speech and causes a pop up to appear thus signaling the user to speak.
        Intent speechIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        speechIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM); // Tells the Intent how to recognize the speech.
        speechIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault()); // Recognize speech and expect the user to use English
        speechIntent.putExtra(RecognizerIntent.EXTRA_PROMPT, getString(R.string.acquire_speech_input)); // This string will appear when the button is clicked on thus prompting the user to say the word

        try{
            startActivityForResult(speechIntent, 100);
        }catch (ActivityNotFoundException e){
            Toast.makeText(this, getString(R.string.speech_text_not_supported), Toast.LENGTH_LONG).show();
        }

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if((requestCode == 100) && (data != null) && (resultCode == RESULT_OK)){
            userSpeech = (TextView) findViewById(R.id.userSpeech);
            String[] spoken = data.getStringArrayExtra(RecognizerIntent.EXTRA_RESULTS);

        }

    }

    @Override
    public void onInit(int status) {

    }
}
