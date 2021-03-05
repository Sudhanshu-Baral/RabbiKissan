package com.example.rabbikissan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CropsRate extends AppCompatActivity {
    Button btn_Rice,btn_wheat,btn_veg,btn_fruit,btn_flower,btn_Dal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_crops_rate);
        btn_Rice=(Button)findViewById (R.id.buttonRice);
        btn_wheat=(Button)findViewById (R.id.buttonWheat);
        btn_veg=(Button)findViewById (R.id.buttonVeg);
        btn_fruit=(Button)findViewById (R.id.buttonF);
        btn_flower=(Button)findViewById (R.id.buttonFlower);
        btn_Dal=(Button)findViewById (R.id.buttonDal);
        btn_Rice.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CropsRate.this,RiceActivity.class);
                startActivity(intent);
                Toast.makeText (CropsRate.this, "Rice Clicked", Toast.LENGTH_SHORT).show ();
            }
        });
        btn_wheat.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Toast.makeText (CropsRate.this, "Wheat Clicked", Toast.LENGTH_SHORT).show ();
            }
        });
        btn_veg.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Toast.makeText (CropsRate.this, "Vegitable Clicked", Toast.LENGTH_SHORT).show ();
            }
        });
        btn_fruit.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Toast.makeText (CropsRate.this, "Fruit Clicked", Toast.LENGTH_SHORT).show ();
            }
        });
        btn_flower.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Toast.makeText (CropsRate.this, "Flower Clicked", Toast.LENGTH_SHORT).show ();
            }
        });
        btn_Dal.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Toast.makeText (CropsRate.this, "Dal Clicked", Toast.LENGTH_SHORT).show ();
            }
        });

    }
}