package com.example.rabbikissan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import static java.lang.Thread.sleep;

public class Front_Open extends AppCompatActivity {


    ImageView splashImage;
    ImageView splashImage2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_front__open);


        splashImage=(ImageView)findViewById (R.id.imageView);
        splashImage2=(ImageView)findViewById (R.id.imageView9);
        Animation myAnim= AnimationUtils.loadAnimation (this,R.anim.my_animation);
        splashImage.startAnimation (myAnim);
        splashImage2.startAnimation (myAnim);


        Thread myThread = new Thread (new Runnable () {
            @Override
            public void run() {
                try {
                    sleep(5000);

                    Intent i = new Intent (Front_Open.this, Sign_in.class);
                    startActivity (i);
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
        });

        myThread.start ();
    }
}
