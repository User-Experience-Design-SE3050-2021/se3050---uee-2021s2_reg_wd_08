package com.example.loginregister;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.PropertyResourceBundle;
import java.util.UUID;

public class UserProfileActivity extends AppCompatActivity {

    private ImageView imageView;
    public Uri imageUri;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseUser user;
    DatabaseReference reference;
    FirebaseDatabase rootNode;
    private FirebaseStorage storage;
    private StorageReference storageReference;

    TextView name,phone,email,nic;
    String na,mob,n,mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        imageView = findViewById(R.id.propic);
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        name = findViewById(R.id.proname);
        phone = findViewById(R.id.promob);
        email = findViewById(R.id.proemail);
        nic = findViewById(R.id.pronic);

        user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        getData(uid);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePictures();
            }
        });

    }

    private void choosePictures(){
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(i,1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode == RESULT_OK && data!=null && data.getData()!=null){
            imageUri = data.getData();
            imageView.setImageURI(imageUri);
            uploadPicture();
        }
    }

    private void uploadPicture() {
        ProgressDialog pd = new ProgressDialog(this);
        pd.setTitle("Image Uploading.....");
        pd.show();

        user = FirebaseAuth.getInstance().getCurrentUser();
        final String key = user.getUid();
        StorageReference mountainsRef = storageReference.child("image/"+key);

        mountainsRef.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                pd.dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                pd.dismiss();
                Toast.makeText(getApplicationContext(), "Upload failed", Toast.LENGTH_LONG).show();

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                double progress = (100.00 * snapshot.getBytesTransferred() / snapshot.getTotalByteCount());
                pd.setMessage("Precent: " + (int) progress + "%");
            }
        });

    }

    public void getData (String uid){

        Query getData = rootNode.getInstance().getReference("Users").orderByChild("uid").equalTo(uid);

        getData.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){

                    na = snapshot.child(uid).child("fname").getValue(String.class)+" "+snapshot.child(uid).child("lname").getValue(String.class);

                    mob = snapshot.child(uid).child("mobile").getValue(String.class);

                    n = snapshot.child(uid).child("nic").getValue(String.class);

                    mail = snapshot.child(uid).child("ename").getValue(String.class);

                    name.setText(na);
                    phone.setText(mob);
                    email.setText(mail);
                    nic.setText(n);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}