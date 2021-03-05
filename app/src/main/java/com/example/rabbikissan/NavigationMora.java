package com.example.rabbikissan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;


public class NavigationMora extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView mRecyclerView;
    List<HomeData> mySchemeList;
    HomeData mHomeData;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_navigation_mora);
        drawerLayout = findViewById (R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle (this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener (actionBarDrawerToggle);
        actionBarDrawerToggle.syncState ();
//        Paper.init(this);

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar ().setDisplayHomeAsUpEnabled (true);
        mRecyclerView = (RecyclerView) findViewById (R.id.recycleView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager (NavigationMora.this, 1);
        mRecyclerView.setLayoutManager (gridLayoutManager);
        mySchemeList = new ArrayList<> ();
        mHomeData = new HomeData ("PMKMDY", "It is voluntary and contributory for farmers in the entry age group of 18 to 40 years and a monthly pension of Rs. 3000/- will be provided to them on attaining the age of 60 years.", R.drawable.kmng);
        mySchemeList.add (mHomeData);
        mHomeData = new HomeData ("PMKSY", " Achieve convergence of investments in irrigation at the field level, expand cultivable area under assured irrigation, improve on-farm water use efficiency to reduce wastage of water, enhance the adoption of precision-irrigation and other water saving technologies (More crop per drop)", R.drawable.pmkso);
        mySchemeList.add (mHomeData);
        mHomeData = new HomeData ("PKVY", "Promote organic farming among rural youth/ farmers/ consumers/ traders Disseminate latest technologies in organic farming , ", R.drawable.pkvy);
        mySchemeList.add (mHomeData);
        mHomeData = new HomeData ("KALIA", "The aim of the scheme is to accelerate agricultural prosperity and reduce poverty in the State payments to encourage cultivation and associated activities.", R.drawable.kalia);
        mySchemeList.add (mHomeData);
        mHomeData = new HomeData ("GBY", "The objective of rural godown scheme is to provide the farming community with facilities for scientific,storage so that wastage and produce deterioration are avoided and also to enable it to meet its credit requirement without being compelled to sell the produce at a time when the prices are low.", R.drawable.gby);

        mySchemeList.add (mHomeData);

        MyAddapter myAddapter = new MyAddapter (NavigationMora.this, mySchemeList);
        mRecyclerView.setAdapter (myAddapter);
        NavigationView navigationView=(NavigationView)findViewById (R.id.nav_view);
        navigationView.setNavigationItemSelectedListener (this);

    }
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        getMenuInflater().inflate(R.menu.navigation_draw, menu);
//        return true;
//    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (actionBarDrawerToggle.onOptionsItemSelected (item)) {
            return true;
        }
        return super.onOptionsItemSelected (item);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        return true;
    }
    @SuppressWarnings("StatementWithEmptyBody")
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId ();

        if (id == R.id.nav_home) {
            // Handle the camera action
        }
        if (id == R.id.nav_seller) {

            Intent intent = new Intent (NavigationMora.this, Dealer.class);
            startActivity (intent);
            Toast.makeText (this,"My Seller",Toast.LENGTH_SHORT).show ();

        }
        if (id == R.id.nav_book) {
            Intent intent = new Intent (NavigationMora.this, BookedDealer.class);
            startActivity (intent);
            Toast.makeText (this,"My Book",Toast.LENGTH_SHORT).show ();


        }
        if (id == R.id.nav_crop) {

            Intent intent = new Intent (NavigationMora.this, CropsRate.class);
            startActivity (intent);
            Toast.makeText (this,"Crop Rate",Toast.LENGTH_SHORT).show ();


        }
        if (id == R.id.nav_chat) {

            Intent intent = new Intent (NavigationMora.this, Chat.class);
            startActivity (intent);
            Toast.makeText (this, "Chat", Toast.LENGTH_SHORT).show ();


        }
        if (id == R.id.nav_rating) {

            Intent intent = new Intent (NavigationMora.this, Rating_given.class);
            startActivity (intent);
            Toast.makeText (this,"Rating",Toast.LENGTH_SHORT).show ();


        }
//        else if (id == R.id.nav_crop) {
//
//            Intent intent = new Intent (NavigationMora.this, CropsRate.class);
//            startActivity (intent);
//
//        }


        else if (id == R.id.nav_log_out){

//            Paper.book().destroy();
            Intent intent = new Intent(NavigationMora.this,Sign_in.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
//            finish();
            Toast.makeText(this, "Logged Out Successfully", Toast.LENGTH_SHORT).show();
        }

        else if (id == R.id.nav_login_another) {

            Intent intent = new Intent(NavigationMora.this,SignUp_Form.class);
            startActivity(intent);

        }
        DrawerLayout drawer = findViewById(R.id.my_drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
}
