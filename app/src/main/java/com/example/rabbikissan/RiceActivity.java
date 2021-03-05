package com.example.rabbikissan;

import android.os.Bundle;



import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;

public class RiceActivity extends AppCompatActivity {
    private RecyclerView courseRV;
    RiceRate mRiceRate;

    // Arraylist for storing data
    private ArrayList<RiceRate> riceRateArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_rice);
        courseRV = findViewById(R.id.idRVCourse);
        riceRateArrayList= new ArrayList<> ();
       mRiceRate= new RiceRate ("29/12/2020","Paddy","Grade-A","Rs :- 1900/Q",R.drawable.grade_a,R.drawable.ic_baseline_moving_24);
       riceRateArrayList.add (mRiceRate);

        mRiceRate=  new RiceRate ("28/12/2020","Paddy","Common","Rs :- 1800/Q",R.drawable.common_paddy,R.drawable.ic_baseline_moving_24);
        riceRateArrayList.add (mRiceRate);
        mRiceRate= new RiceRate ("23/12/2020","Rice","Basmati","Rs :- 5000/Q",R.drawable.basmati_rice,R.drawable.ic_baseline_moving_24);
        riceRateArrayList.add (mRiceRate);
        mRiceRate= new RiceRate ("22/12/2020","Rice","Sunned Rice","Rs :- 3200/Q",R.drawable.sunned_rice,R.drawable.ic_baseline_moving_24);
        riceRateArrayList.add (mRiceRate);
        mRiceRate= new RiceRate ("22/12/2020","Rice","Parboiled Rice","Rs :- 2600/Q",R.drawable.parboiled_rice,R.drawable.ic_baseline_moving_24);
        riceRateArrayList.add (mRiceRate);
        mRiceRate= new RiceRate ("21/12/2020","Rice","Common Rice","Rs :- 2200/Q",R.drawable.common_rice,R.drawable.ic_baseline_moving_24);
        riceRateArrayList.add (mRiceRate);
        RiceAdapter riceAdapter= new RiceAdapter (this,riceRateArrayList);
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager (this, 1);
        //mRecyclerView.setLayoutManager (gridLayoutManager);
        courseRV.setLayoutManager(gridLayoutManager);
        courseRV.setAdapter(riceAdapter);

//

//        FloatingActionButton fab = (FloatingActionButton) findViewById (R.id.fab);
//        fab.setOnClickListener (new View.OnClickListener () {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make (view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction ("Action", null).show ();
//            }
//        });
    }
}