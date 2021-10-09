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
    private ImageView arrow;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);


        dialog=new Dialog(ProductActivity.this);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations=R.style.DialogAnimation;


        Button okey=dialog.findViewById(R.id.btn_okay);
        Button cancel=dialog.findViewById(R.id.btn_cancel);
        okey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProductActivity.this,"Okay",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

  cancel.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          Toast.makeText(ProductActivity.this,"cancel",Toast.LENGTH_SHORT).show();
          dialog.dismiss();
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
    }



}