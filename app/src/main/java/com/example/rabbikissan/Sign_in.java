package com.example.rabbikissan;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import dalvik.system.DexFile;

public class Sign_in extends AppCompatActivity {

    private EditText txtEmail, txtPassword;
    private Button btn_login;
   // private Uri ImageUri;
   // private ImageView img;
    //Bitmap bitmap;
    private static final int GallleryPick=1;
    private FirebaseAuth firebaseAuth;
    private static final String TAG = "Sign_in";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().setTitle(" Login Form");
     //   img=(ImageView)findViewById(R.id.img);
        txtEmail = (EditText) findViewById(R.id.email);
        txtPassword = (EditText) findViewById(R.id.Password);
        btn_login = findViewById(R.id.login_button);
        firebaseAuth=FirebaseAuth.getInstance();



       /**img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenGallery();
            }
        });  **/


        
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtEmail.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();
               /** if (ImageUri == null) {
                    Toast.makeText(Sign_in.this,"Profile Pic given",Toast.LENGTH_SHORT).show();
                }**/


                if (TextUtils.isEmpty(email)) {
                    Toast.makeText( Sign_in.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Sign_in.this, "Please Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(Sign_in.this, "password too short", Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(Sign_in.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    startActivity(new Intent(getApplicationContext(),NavigationMora.class));

                                }else {

                                    Toast.makeText(Sign_in.this,"Login Failed" +
                                            "",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });






            }
        });
        

    }

  /**  private void OpenGallery() {

        Intent galleryIntent=new Intent();
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent,GallleryPick);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode,data);

        if (requestCode==GallleryPick && resultCode==RESULT_OK && data!=null){
            ImageUri =data.getData();
            img.setImageURI(ImageUri);
        }


    }**/

    public void btn_signupForm (View view){
            startActivity(new Intent(getApplicationContext(), SignUp_Form.class));
        }
    }
