
package com.example.rabbikissan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class BookedDealer extends AppCompatActivity {

    RecyclerView recentRecycler,topPlaceRecycler;
    RecentAdapter recentAdapter;
    TopPlaceAdapter topPlaceAdapter;
    EditText txt_Search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_booked_dealer);
        List<RecentData> recentDataList=new ArrayList<> ();
        txt_Search=(EditText)findViewById (R.id.editTextTextPersonName5);

        recentDataList.add(new RecentData ("Arup","Jajpur Road, Jajpur,Odisha","1905106006" ,R.drawable.arup));
        recentDataList.add(new RecentData ("Sudhanshu","Belapada,Dhenkanal,Odisha","1905106026" ,R.drawable.muna));

        recentDataList.add(new RecentData ("Sudhamaya","Paradip,JagatsinghPur","1905106025",R.drawable.sudha));
        recentDataList.add(new RecentData ("Purnendu","Baliapal,Baleswar,Odisha","1905106019",R.drawable.purna1));
        recentDataList.add(new RecentData ("Lalit","BBSR,Khordha,Odisha","1905106012",R.drawable.lalit));
        recentDataList.add(new RecentData ("Vijay","Cuttack,Odisha","1905106007",R.drawable.vijaya));
        setRecentRecycler (recentDataList);
        List<TopPlace> topPlaces= new ArrayList<> ();
        topPlaces.add (new TopPlace ("Jagannath","Kendrapada,Odisha","765432156",R.drawable.jaga));
        topPlaces.add (new TopPlace ("Pabitra","Dhenkanal,Odisha","765432189",R.drawable.bapa));
        setTopPlaceRecycler (topPlaces);

    }
    private void setRecentRecycler(List<RecentData> recentDataList){
        recentRecycler=findViewById (R.id.recents_row);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager (this,RecyclerView.HORIZONTAL,false);
        recentRecycler.setLayoutManager (layoutManager);
        recentAdapter=new RecentAdapter (this,recentDataList);
        recentRecycler.setAdapter (recentAdapter);
    }
    private void setTopPlaceRecycler(List<TopPlace> topPlaces){
        topPlaceRecycler=findViewById (R.id.top_dealer);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager (this,RecyclerView.VERTICAL,false);
        topPlaceRecycler.setLayoutManager (layoutManager);
        topPlaceAdapter=new TopPlaceAdapter (this,topPlaces);
        topPlaceRecycler.setAdapter (topPlaceAdapter);
    }




}