package com.example.rabbikissan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.text.format.DateFormat;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

//import a.text.format.DateFormat;

public class Chat extends AppCompatActivity implements View.OnClickListener {
    List<ChatData> chatData;
   // FloatingActionButton fab;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Farmer u;
    MessageAdapter messageAdapter;
    
    RecyclerView rvMessage;
    EditText etMessage;
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_chat);

//        fab=(FloatingActionButton)findViewById (R.id.fab);
//        displayChat();
        init ();
    }
    
    
    private void init(){
        firebaseAuth =FirebaseAuth.getInstance ();
        firebaseDatabase=FirebaseDatabase.getInstance ();
        u = new Farmer ();
        rvMessage= (RecyclerView)findViewById (R.id.iv_msg);
        etMessage=(EditText)findViewById (R.id.text_msg);
        imageButton=(ImageButton)findViewById (R.id.sent_btn);
        imageButton.setOnClickListener (this);
        chatData= new ArrayList<> ();
    }

    @Override
    public void onClick(View v) {


        if (!TextUtils.isEmpty (etMessage.getText().toString())){
            ChatData chatData1= new ChatData (etMessage.getText().toString(),u.getFullName ());
            etMessage.setText (" ");
            databaseReference.push ().setValue (chatData1);
        }
        else {

            Toast.makeText (getApplicationContext (),"You can't send blank message",Toast.LENGTH_SHORT).show ();
        }
        
    }
    protected void onStart(){
        super.onStart();
         final FirebaseUser currentUser =firebaseAuth.getCurrentUser ();
        u.setUid (currentUser.getUid ());
        u.setEmail (currentUser.getEmail ());
        firebaseDatabase.getReference ("Farmer").child (currentUser.getUid ()).addListenerForSingleValueEvent (new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                u = snapshot.getValue(Farmer.class);
                u.setUid (currentUser.getUid ());
                AllMethods.name=u.getFullName ();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        
        databaseReference = firebaseDatabase.getReference ("chatData");
        databaseReference.addChildEventListener (new ChildEventListener () {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                ChatData chatData1=snapshot.getValue (ChatData.class);
                chatData1.setKey (snapshot.getKey ());
                chatData.add (chatData1);
                displayMessages(chatData);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                ChatData chatData1= snapshot.getValue (ChatData.class);
                chatData1.setKey (snapshot.getKey ());
                List<ChatData> newChatdata= new ArrayList<ChatData>();
                for (ChatData ch: chatData){

                    if (ch.getKey().equals (chatData1.getKey ())){
                        newChatdata.add(chatData1);
                    }
                    else{
                        newChatdata.add (ch);
                    }

                }

                chatData= newChatdata;
                displayMessages (chatData);

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                ChatData chatData1= snapshot.getValue (ChatData.class);
                chatData1.setKey (snapshot.getKey ());
                List<ChatData> newChatdata= new ArrayList<ChatData>();
                for (ChatData ch: chatData) {
                     if (!ch.getKey ().equals (chatData1.getKey ())){
                         newChatdata.add(ch);
                     }
                }
                chatData= newChatdata;
                displayMessages (chatData);


            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        
    }

    protected void onResume(){
        super.onResume ();
        chatData= new ArrayList<> ();

    }

    private void displayMessages(List<ChatData> chatData) {

        rvMessage.setLayoutManager (new LinearLayoutManager (Chat.this));
        messageAdapter= new MessageAdapter (Chat.this,chatData,databaseReference);
        rvMessage.setAdapter (messageAdapter);
    }


}