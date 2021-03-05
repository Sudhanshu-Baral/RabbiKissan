package com.example.rabbikissan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class Rating extends AppCompatActivity {

    TextView txtrating;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_rating);
        txtrating=(TextView)findViewById (R.id.rate);
        ratingBar=(RatingBar)findViewById (R.id.rating);
        ratingBar.setOnRatingBarChangeListener (new RatingBar.OnRatingBarChangeListener () {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                txtrating.setText ("Rating :" + rating);
            }
        });
    }
}