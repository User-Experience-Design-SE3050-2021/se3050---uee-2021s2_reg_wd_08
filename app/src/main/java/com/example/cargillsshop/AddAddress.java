package com.example.cargillsshop;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class AddAddress extends AppCompatActivity {

    private Button AddAddress;
    private EditText InputName, InputMobile, InputAddress, InputLandmark, InputCity, SaveAs;
    private DatabaseReference AddressRef;
    private String saveCurrentDate, saveCurrentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
        getSupportActionBar().hide();

        AddressRef = FirebaseDatabase.getInstance().getReference().child("Address");
        AddAddress = (Button) findViewById(R.id.button2);
        InputName = (EditText) findViewById(R.id.editTextTextPersonName);
        InputMobile = (EditText) findViewById(R.id.editTextPhone);
        InputAddress = (EditText) findViewById(R.id.editTextTextAddress);
        InputLandmark = (EditText) findViewById(R.id.editTextLandmark);
        InputCity = (EditText) findViewById(R.id.editTextCity);
//        SaveAs = (EditText) findViewById(R.id.register_mail_input);

        AddAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddAddress();
            }
        });

    }

    private void AddAddress()
    {
        String name = InputName.getText().toString();
        String mobile = InputMobile.getText().toString();
        String address = InputAddress.getText().toString();
        String landmark = InputLandmark.getText().toString();
        String city = InputCity.getText().toString();
        String saveas ="Home";

        Calendar calendar = Calendar.getInstance();

        @SuppressLint("SimpleDateFormat") SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
        saveCurrentDate = currentDate.format(calendar.getTime());

        @SuppressLint("SimpleDateFormat") SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime = currentTime.format(calendar.getTime());

        String productRandomKey = saveCurrentDate + saveCurrentTime;


        if (TextUtils.isEmpty(name))
        {
            Toast.makeText(this, "Please write your name...", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(mobile))
        {
            Toast.makeText(this, "Please write your phone number...", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(address))
        {
            Toast.makeText(this, "Please write your address...", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(landmark))
        {
            Toast.makeText(this, "Please write your landmark...", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(city))
        {
            Toast.makeText(this, "Please write your city...", Toast.LENGTH_SHORT).show();
        }
        else
        {

            SaveInDatabase(productRandomKey,name, mobile, address,landmark,city,saveas);
        }
    }

    private void SaveInDatabase(final String id, final String name, final String mobile, final String address,final String landmark,final String city, final String saveas)
    {
        HashMap<String, Object> addressMap = new HashMap<>();
        addressMap.put("aid", id);
        addressMap.put("name", name);
        addressMap.put("mobile", mobile);
        addressMap.put("address", address);
        addressMap.put("landmark", landmark);
        addressMap.put("city", city);
        addressMap.put("saveas", saveas);

        AddressRef.child(id).updateChildren(addressMap)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task)
                    {
                        if (task.isSuccessful())
                        {
//                            Intent intent = new Intent(AdminAddKidsProductActivity.this, AdminKidsClothing.class);
//                            startActivity(intent);

                            // loadingBar.dismiss();
                            Toast.makeText(AddAddress.this, "Address is added successfully..", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            //  loadingBar.dismiss();
                            String message = task.getException().toString();
                            Toast.makeText(AddAddress.this, "Error: " + message, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}