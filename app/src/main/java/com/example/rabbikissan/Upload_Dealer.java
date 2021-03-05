package com.example.rabbikissan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.net.URI;
import java.text.DateFormat;
import java.util.Calendar;

public class Upload_Dealer extends AppCompatActivity {


    ImageView dealerImage;
    Uri uri;
    EditText txt_Name,txt_Area,txt_phone,txt_id;
    String imageUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_upload__dealer);

        dealerImage=(ImageView)findViewById (R.id.iv_dealerImage);
        txt_Name=(EditText)findViewById (R.id.txt_dealer_Name);
        txt_Area=(EditText)findViewById (R.id.txt_area);
        txt_phone=(EditText)findViewById (R.id.txt_phone);
        txt_id=(EditText)findViewById (R.id.txt_id);
    }

    public void btnSelectImage(View view) {
        Intent photoPicker =new Intent(Intent.ACTION_PICK);
        photoPicker.setType ("image/*");
        startActivityForResult (photoPicker,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult (requestCode, resultCode, data);

        if(resultCode==RESULT_OK){
            uri = data.getData();
            dealerImage.setImageURI (uri);
        }
        else Toast.makeText (this,"You haven't pick any image",Toast.LENGTH_SHORT).show ();
    }
    public void upload(){



        StorageReference storageReference= FirebaseStorage.getInstance ()
                .getReference ().child ("DealerImage").child (uri.getLastPathSegment ());

        final ProgressDialog progressDialog= new ProgressDialog (this);
        progressDialog.setMessage ("Uploading.....");
        progressDialog.show ();;


        storageReference.putFile (uri).addOnSuccessListener (new OnSuccessListener<UploadTask.TaskSnapshot> () {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri> uriTask=taskSnapshot.getStorage ().getDownloadUrl ();
                while (!uriTask.isComplete ());
                Uri urlImage=uriTask.getResult ();
                imageUrl =urlImage.toString ();
                uploadDealer ();
                progressDialog.dismiss ();

                //Toast.makeText (Upload_Dealer.this,"",Toast.LENGTH_SHORT).show ();
            }
        }).addOnFailureListener (new OnFailureListener () {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss ();
                
            }
        });
    }


    public void btnUpload(View view) {

        upload();
    }

    public void uploadDealer(){

//       final ProgressDialog progressDialog= new ProgressDialog (this);
//        progressDialog.setMessage ("Uploading.....");
//        progressDialog.show ();;
//

        Dealer_Data dealerData= new Dealer_Data (
                txt_Name.getText ().toString (),
                txt_Area.getText ().toString (),
                imageUrl,
                txt_phone.getText ().toString (),
                txt_id.getText ().toString ()

        );

        String myCurrentDateTime = DateFormat.getDateTimeInstance ()
                .format (Calendar.getInstance ().getTime ());

        FirebaseDatabase.getInstance ().getReference ("Dealer_Data")
                .child (myCurrentDateTime).setValue (dealerData).addOnCompleteListener (new OnCompleteListener<Void> () {
            @Override
            public void onComplete(@NonNull Task<Void> task) {


              if (task.isSuccessful ()) {
                  Toast.makeText (Upload_Dealer.this,"Upload Successful",Toast.LENGTH_SHORT).show ();
                 // progressDialog.dismiss ();
                  finish ();
              }


            }
        }).addOnFailureListener (new OnFailureListener () {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText (Upload_Dealer.this,e.getMessage ().toString (),Toast.LENGTH_SHORT).show ();
               // progressDialog.dismiss ();
            }
        });
    }

}