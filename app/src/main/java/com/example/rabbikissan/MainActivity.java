package com.example.rabbikissan;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkConnection ();

    }
    public void checkConnection(){
        ConnectivityManager manager=(ConnectivityManager)getApplicationContext ().getSystemService (Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork=manager.getActiveNetworkInfo ();


        if (null!= activeNetwork){
            if (activeNetwork.getType ()==ConnectivityManager.TYPE_WIFI){
                Toast.makeText (this, "Wifi Enabled", Toast.LENGTH_SHORT).show ();
            }
            if (activeNetwork.getType ()==ConnectivityManager.TYPE_MOBILE) {
                    Toast.makeText (this, "Mobile Network Enabled", Toast.LENGTH_SHORT).show ();
            }

        }
        else {
            Toast.makeText (this, "No Internet Connection", Toast.LENGTH_SHORT).show ();
        }
    }
}