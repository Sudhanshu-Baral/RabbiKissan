package com.example.rabbikissan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    TextView area,dealerName,phone,id;
    ImageView dealerImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_detail);

        dealerName=(TextView)findViewById (R.id.txt_dealer_Name);
        area=(TextView)findViewById (R.id.txt_area);
        phone=(TextView)findViewById (R.id.txt_phone);
        id=(TextView)findViewById (R.id.txt_id);
        dealerImage=(ImageView)findViewById (R.id.iv_dealerImage);
        Bundle mBundle=getIntent ().getExtras ();
        if (mBundle!=null){
            dealerName.setText (mBundle.getString ("Name"));
            area.setText (mBundle.getString ("Area"));
            phone.setText (mBundle.getString ("Phone Number"));
            id.setText (mBundle.getString ("Id"));
            //dealerImage.setImageResource (mBundle.getInt ("Image"));
            Glide.with (this)
                    .load (mBundle.getString ("Image"))
                    .into (dealerImage);
        }
    }
}