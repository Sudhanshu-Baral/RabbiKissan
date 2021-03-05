package com.example.rabbikissan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Dealer extends AppCompatActivity {


    RecyclerView nRecyclerView;
    List<Dealer_Data> nyDealerList;
    Dealer_Data mdealerData;
    private DatabaseReference databaseReference;
    private ValueEventListener eventListener;
    MyAddapter1 myAddapter1;
    ProgressDialog progressDialog;
    EditText txt_Search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_dealer);
        getSupportActionBar().setTitle(" Dealers");

        nRecyclerView=(RecyclerView)findViewById(R.id.recycleView1);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(Dealer.this,1);
        nRecyclerView.setLayoutManager(gridLayoutManager);
        txt_Search=(EditText)findViewById (R.id.txt_Searchtext);

        progressDialog=new ProgressDialog (this);
        progressDialog.setMessage ("Loading Profile....");
        nyDealerList=new ArrayList<> ();

        MyAddapter1 myAddapter1= new MyAddapter1(Dealer.this,nyDealerList);
        nRecyclerView.setAdapter(myAddapter1);
        databaseReference= FirebaseDatabase.getInstance ().getReference ("Dealer_Data");
        progressDialog.show ();
        eventListener= databaseReference.addValueEventListener (new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                nyDealerList.clear ();
                for (DataSnapshot itemSnapshot: snapshot.getChildren ()){
                    Dealer_Data dealerData=itemSnapshot.getValue (Dealer_Data.class);

                    nyDealerList.add(dealerData);
                }
                myAddapter1.notifyDataSetChanged ();
                progressDialog.dismiss ();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                progressDialog.dismiss ();

            }
        });


         txt_Search.addTextChangedListener (new TextWatcher () {
             @Override
             public void beforeTextChanged(CharSequence s, int start, int count, int after) {

             }
             @Override
             public void onTextChanged(CharSequence s, int start, int before, int count) {

             }
             @Override
             public void afterTextChanged(Editable s) {


                 filter(s.toString ());
             }
         });

    }

    private void filter(String text) {

        ArrayList<Dealer_Data> filterList= new ArrayList<> ();

        for(Dealer_Data item:nyDealerList){

            if (item.getDealerArea ().toLowerCase ().contains (text.toLowerCase())){
                filterList.add (item);
            }
        }
        myAddapter1.filteredList(filterList);
    }

    public void btnSelectImage(View view) {
        startActivity (new Intent (this,Upload_Dealer.class));
    }
}