package com.example.rabbikissan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Amount_data extends AppCompatActivity {


    private EditText txt_fullName,txt_email,txt_phone,txt_crop_name,txt_crop_quality,txt_crop_amount;
    private Button btn_booked;

    ProgressBar progressBar;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_amount_data);
        txt_fullName=(EditText)findViewById(R.id.fullNam);
        txt_email=(EditText)findViewById(R.id.emailj);
        txt_phone=(EditText)findViewById(R.id.phoneNumberr);
        txt_crop_name=(EditText)findViewById(R.id.CropName);
        txt_crop_quality=(EditText)findViewById(R.id.CropQuality);
        txt_crop_amount=(EditText)findViewById (R.id.cropAmount);
        btn_booked=(Button)findViewById(R.id.detboked);
//        radioGenderMale=(RadioButton)findViewById(R.id.radio_male);
//        radioGenderFemale=(RadioButton)findViewById(R.id.radio_female);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        databaseReference=FirebaseDatabase.getInstance ().getReference ();
//        btn_booked.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG, "onClick: ");
//            }
//        });


        btn_booked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String fullName = txt_fullName.getText ().toString ();
                String email = txt_email.getText ().toString ().trim ();
                String phoneNumber = txt_phone.getText ().toString ().trim ();
                String cropName = txt_crop_name.getText ().toString ().trim ();
                String cropQuality = txt_crop_quality.getText ().toString ().trim ();
                String cropAmount = txt_crop_amount.getText ().toString ().trim ();


                if (TextUtils.isEmpty (email)) {
                    Toast.makeText (Amount_data.this, "Please Enter Email", Toast.LENGTH_SHORT).show ();
                    return;
                }
                if (TextUtils.isEmpty (fullName)) {
                    Toast.makeText (Amount_data.this, "Please Enter password", Toast.LENGTH_SHORT).show ();
                    return;
                }
                if (TextUtils.isEmpty (phoneNumber)) {
                    Toast.makeText (Amount_data.this, "Please Enter Fullname", Toast.LENGTH_SHORT).show ();
                    return;
                }
                if (TextUtils.isEmpty (cropName)) {
                    Toast.makeText (Amount_data.this, "Please Enter Confirm Password", Toast.LENGTH_SHORT).show ();
                    return;
                }
                if (TextUtils.isEmpty (cropQuality)) {
                    Toast.makeText (Amount_data.this, "Please Enter phone Number", Toast.LENGTH_SHORT).show ();
                    return;
                }

                //progressBar.setVisibility(View.VISIBLE);
//                if (password.equals((confirmPassword))) {
//
//                    firebaseAuth.createUserWithEmailAndPassword(email, password)
//                            .addOnCompleteListener(SignUp_Form.this, new OnCompleteListener<AuthResult> () {
//                                @Override
//                                public void onComplete(@NonNull Task<AuthResult> task) {
//
//                                    if (task.isSuccessful()) {
//                                        Farmer information = new Farmer(fullName, email, gender, phoneNumber);
//
//                                        FirebaseDatabase.getInstance().getReference("Farmer")
//                                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
//                                                .setValue(information).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                            @Override
//                                            public void onComplete(@NonNull Task<Void> task) {
//
//                                                startActivity((new Intent (getApplicationContext(), Sign_in.class)));
//                                                Toast.makeText(SignUp_Form.this, "Register Successful", Toast.LENGTH_SHORT).show();
//
//                                            }
//                                        });
//
//
//                                    } else {
//
//                                        Toast.makeText(SignUp_Form.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
//
//                                    }
//                                }
//
//                            });
//
//                }
                Amount amount_data=new Amount (fullName,email,phoneNumber, cropName, cropQuality,cropAmount);
                FirebaseDatabase.getInstance().getReference("Amount")
                                               .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                               .setValue (amount_data).addOnCompleteListener (new OnCompleteListener<Void> () {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        startActivity(new Intent(getApplicationContext(),Confirm_booked.class));
                        Toast.makeText (Amount_data.this, "Data saved", Toast.LENGTH_SHORT).show ();

                    }
                });
            }

        });




        }
    }