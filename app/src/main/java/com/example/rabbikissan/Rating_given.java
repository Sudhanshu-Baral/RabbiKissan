package com.example.rabbikissan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Rating_given extends AppCompatActivity {

    private Button btn_rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_rating_given);
        btn_rating=(Button)findViewById(R.id.button);
        btn_rating.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (getApplicationContext(),Rating.class));
            }
        });
    }
}