package com.example.cargillsshop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

public class ProductActivity extends AppCompatActivity {

    private ElegantNumberButton numberButton;
    private Button add_to_cart;

    private ImageView arrow,heart;
    Dialog dialog,dialog1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        getSupportActionBar().hide();

        dialog=new Dialog(ProductActivity.this);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations=R.style.DialogAnimation;


        dialog1=new Dialog(ProductActivity.this);
        dialog1.setContentView(R.layout.custome_wishlist_dialogbox);
        dialog1.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background));
        dialog1.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog1.setCancelable(false);
        dialog1.getWindow().getAttributes().windowAnimations=R.style.DialogAnimation;


        Button okey=dialog.findViewById(R.id.btn_okay);

        okey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProductActivity.this,"Okay",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        Button okey1=dialog1.findViewById(R.id.btn_okay1);

        okey1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProductActivity.this,"Okay",Toast.LENGTH_SHORT).show();
                dialog1.dismiss();
            }
        });


        add_to_cart=findViewById(R.id.add_to_cart_btn);
        add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
        arrow=findViewById(R.id.arrow);
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(ProductActivity.this, CategoryActivity2.class);
                startActivity(myintent);
            }
        });
        heart=findViewById(R.id.heart1);
        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.show();
            }
        });


    }



}