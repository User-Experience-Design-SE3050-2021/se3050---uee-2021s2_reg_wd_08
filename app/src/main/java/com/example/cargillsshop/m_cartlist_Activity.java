package com.example.cargillsshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class m_cartlist_Activity extends AppCompatActivity {
    Button btn_plus1, btn_minus1, btn_check, btn_plus2, btn_minus2;
    TextView txt_count1, txt_count2, text_total_count, txt_amont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcartlist);

        getSupportActionBar().hide();

        txt_count1 = findViewById(R.id.text_count1);
        txt_count2 = findViewById(R.id.text_count2);
        btn_plus1 = findViewById(R.id.btn_plus1);
        btn_plus2 = findViewById(R.id.btn_plus2);
        btn_minus1 = findViewById(R.id.btn_minus1);
        btn_minus2 = findViewById(R.id.btn_minus2);
        txt_amont = findViewById(R.id.text_amount);
        btn_check = findViewById(R.id.btn_cartlist);
        text_total_count = findViewById(R.id.text_tcount);

        btn_plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count1 = Integer.parseInt(txt_count1.getText().toString());
                int r = countUp(count1);
                txt_count1.setText(Integer.toString(r));

                text_total_count.setText(Integer.toString(r + 8));
                float total = (65 * r) + 2680;
                String amount = Float.toString(total);
                txt_amont.setText("RS" + " " + amount + "0");


            }
        });


        btn_minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count1 = Integer.parseInt(txt_count1.getText().toString());
                int r = countDown(count1);
                txt_count1.setText(Integer.toString(r));
                text_total_count.setText(Integer.toString(r + 8));

                float total = (65 * r) + 2680;
                String amount = Float.toString(total);
                txt_amont.setText("RS" + " " + amount + "0");
            }
        });


        btn_plus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count2 = Integer.parseInt(txt_count2.getText().toString());
                int r = countUp(count2);
                txt_count2.setText(Integer.toString(r));

                text_total_count.setText(Integer.toString(r + 6));
                float total = (795 * r) + 360;
                String amount = Float.toString(total);
                txt_amont.setText("RS" + " " + amount + "0");


            }
        });


        btn_minus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count2 = Integer.parseInt(txt_count2.getText().toString());
                int r = countDown(count2);
                txt_count2.setText(Integer.toString(r));

                text_total_count.setText(Integer.toString(r + 6));
                float total = (795 * r) + 360;
                String amount = Float.toString(total);
                txt_amont.setText("RS" + " " + amount + "0");
            }
        });



        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toatal = txt_amont.getText().toString();

                Intent intent = new Intent(m_cartlist_Activity.this, mpayment_form.class);
                intent.putExtra("Total", toatal);
                startActivity(intent);
            }
        });

    }



    private int countUp(int count){
        return count + 1;
    }

    private int countDown(int count){
        int s = count - 1;
         if(s==0){
             return 1;
         }
         else {
             return s;
         }
    }
}