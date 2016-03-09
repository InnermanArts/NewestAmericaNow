package com.example.dennisthicklin.naturalizationgame3.UI;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageView;

import com.example.dennisthicklin.naturalizationgame3.R;


public class MainActivity extends Activity {
MediaPlayer button_effect;
MediaPlayer button_effect2;
MediaPlayer button_effect3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //turn title off
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //set to full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);


        final ImageView logo  = (ImageView) findViewById(R.id.imageView);
        final Animation turn = AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotate);
        final Button iFadeIn = (Button) findViewById( R.id.button);
        final Animation fadeIn = AnimationUtils.loadAnimation(getBaseContext(), R.anim.activityanimation1);
        final Button practiceFI = (Button) findViewById(R.id.button2);
        final Animation practiceIn = AnimationUtils.loadAnimation(getBaseContext(), R.anim.activityanimation1);
        final Button settingsFadeIn = (Button) findViewById(R.id.button3);
        final Animation sFI = AnimationUtils.loadAnimation(getBaseContext(), R.anim.activityanimation1);
        final Animation newanim = AnimationUtils.loadAnimation(getBaseContext(), R.anim.animnew);
        settingsFadeIn.startAnimation(sFI);
        practiceFI.startAnimation(practiceIn);
        iFadeIn.startAnimation(fadeIn);
        logo.startAnimation(turn);

        //Set button sound effect

          button_effect = MediaPlayer.create(this, R.raw.click);

        Button switchButton = (Button) findViewById(R.id.button);

        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, categoriesPage.class);
                startActivity(intent);

                overridePendingTransition(R.anim.entran, R.anim.exit);
                button_effect.start();
            }
        });

        button_effect2 = MediaPlayer.create(this, R.raw.click);

        Button switchPractice = (Button) findViewById(R.id.button2);

        switchPractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPractice = new Intent(MainActivity.this, practice_activity.class);
                startActivity(intentPractice);

                overridePendingTransition(R.anim.activityanimation1, R.animator.animation2);
                button_effect2.start();

            }
        });
        button_effect3 = MediaPlayer.create(this, R.raw.click);

        Button switchSettings = (Button) findViewById(R.id.button3);
        switchSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSettings = new Intent(MainActivity.this, settings_activity.class);
                startActivity(intentSettings);

                overridePendingTransition(R.anim.activityanimation1, R.animator.animation2);
                button_effect3.start();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
