package com.example.cargillsshop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class mpayment_form extends AppCompatActivity {
    Button pay_btn, done_btn;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpayment_form);

        getSupportActionBar().hide();

        pay_btn = findViewById(R.id.payment_button);
        done_btn = findViewById(R.id.btn_Done);
        dialog= new Dialog(this);

        pay_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWinDialog();
            }
        });



    }



    private void openWinDialog(){
    dialog.setContentView(R.layout.m_dialoguebox_success);
    dialog.getWindow().setBackgroundDrawable(new ColorDrawable((Color.TRANSPARENT)));

        Button btnDone = dialog.findViewById(R.id.btn_Done);
        dialog.show();

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

}