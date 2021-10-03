package com.example.cargillsshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

public class ProductActivity extends AppCompatActivity {

    private ElegantNumberButton numberButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
    }
}