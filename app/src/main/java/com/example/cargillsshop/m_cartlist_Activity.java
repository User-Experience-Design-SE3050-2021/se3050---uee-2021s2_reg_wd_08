package com.example.cargillsshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class m_cartlist_Activity extends AppCompatActivity {
    Button btn_plus1, btn_minus1,btn_check;
    TextView txt_count1, text_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcartlist);

        getSupportActionBar().hide();




    }
}