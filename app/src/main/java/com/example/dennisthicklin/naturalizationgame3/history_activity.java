package com.example.dennisthicklin.naturalizationgame3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.dennisthicklin.naturalizationgame3.UI.categoriesPage;


public class history_activity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_activity);
        Button homeHistButton = (Button) findViewById(R.id.homeHistButton);
        RadioGroup answers = (RadioGroup) findViewById(R.id.answers);
        RadioButton a1, a2, a3, a4;
        a1 = (RadioButton) findViewById(R.id.a1);
        a2  = (RadioButton) findViewById(R.id.a3);
        a3 = (RadioButton) findViewById(R.id.a3);
        a4 = (RadioButton) findViewById(R.id.a4);

        String[] questions = {
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
        };

        homeHistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(history_activity.this, categoriesPage.class);
                startActivity(intent);
            }
        });

        Toast.makeText(getApplicationContext(),"Welcome to History", Toast.LENGTH_LONG).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_history_activity, menu);
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
