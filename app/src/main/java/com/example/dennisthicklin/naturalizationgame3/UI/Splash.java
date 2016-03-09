package com.example.dennisthicklin.naturalizationgame3.UI;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.content.Intent;
import android.widget.TextView;

import com.example.dennisthicklin.naturalizationgame3.R;
import com.example.dennisthicklin.naturalizationgame3.UI.MainActivity;

/**
 * Created by dennisthicklin on 6/19/15.
 */
public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        final TextView title = (TextView) findViewById(R.id.titleView);
        final TextView subtitle = (TextView) findViewById(R.id.subtitleView);
        final Animation t = AnimationUtils.loadAnimation(getBaseContext(), R.anim.newanimation);
        final Animation s = AnimationUtils.loadAnimation(getBaseContext(), R.anim.newanimation);
        final ImageView iv = (ImageView) findViewById(R.id.imageView2);
        final Animation an = AnimationUtils.loadAnimation(getBaseContext(), R.anim.rotate2);
        final Animation an2 = AnimationUtils.loadAnimation(getBaseContext(), R.anim.newanimation);
        title.startAnimation(t);
        subtitle.startAnimation(s);
        iv.startAnimation(an);
        an.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                iv.startAnimation(an2);
                finish();
                Intent x = new Intent(getBaseContext(), MainActivity.class);
                startActivity(x);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
