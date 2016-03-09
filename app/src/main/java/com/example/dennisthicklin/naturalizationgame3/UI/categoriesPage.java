package com.example.dennisthicklin.naturalizationgame3.UI;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dennisthicklin.naturalizationgame3.R;
import com.example.dennisthicklin.naturalizationgame3.amgov_activity;
import com.example.dennisthicklin.naturalizationgame3.history_activity;


public class categoriesPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);
         final MediaPlayer tap_effect = MediaPlayer.create(this, R.raw.click);
         Button switchWV = (Button) findViewById(R.id.writev);
         final Button categoriesToMain =(Button) findViewById(R.id.homeAmButton);
         Button gButton = (Button) findViewById(R.id.govbutton);
         Button rv_button = (Button) findViewById(R.id.readVButton);
         Button amHist_button = (Button) findViewById(R.id.AmHistButton);
         Button homeAmButton = (Button) findViewById(R.id.homeAmButton);

        Toast.makeText(getApplicationContext(),"Categories Page",Toast.LENGTH_LONG).show();

        homeAmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(categoriesPage.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.pushin, R.anim.pushout);
                tap_effect.start();
            }
        });

        switchWV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent wvIntent = new Intent(categoriesPage.this, writingvocab_activity.class);
                startActivity(wvIntent);
                overridePendingTransition(R.anim.pushin, R.anim.pushout);
                tap_effect.start();

            }
        });

        amHist_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(categoriesPage.this, history_activity.class);
                startActivity(intent);
                tap_effect.start();
                overridePendingTransition(R.anim.pushin, R.anim.pushout);
            }
        });

        rv_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRV = new Intent(categoriesPage.this, readvocab_activity.class);
                startActivity(intentRV);
                overridePendingTransition(R.anim.pushin, R.anim.pushout);
                tap_effect.start();
            }
        });

        gButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(categoriesPage.this, amgov_activity.class);
                startActivity(intent);
                tap_effect.start();
                overridePendingTransition(R.anim.pushin, R.anim.pushout);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity2, menu);
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
