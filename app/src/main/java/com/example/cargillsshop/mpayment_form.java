package com.example.cargillsshop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class mpayment_form extends AppCompatActivity {
    Button pay_btn, done_btn;
    Dialog dialog;
    EditText edit_person,edit_numb, edit_month, edit_yr, edit_cvc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpayment_form);

        getSupportActionBar().hide();

        pay_btn = findViewById(R.id.payment_button);
        done_btn = findViewById(R.id.btn_Done);

        edit_person=findViewById(R.id.edit_person);
        edit_numb=findViewById(R.id.edit_cardnumb);
        edit_month=findViewById(R.id.edit_month);
        edit_yr=findViewById(R.id.edit_year);
        edit_cvc=findViewById(R.id.edit_cvc);

        dialog= new Dialog(this);

        pay_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edit_person.getText().toString();
                String numb = edit_numb.getText().toString();
                String month = edit_month.getText().toString();
                String year = edit_yr.getText().toString();
                String cvc = edit_cvc.getText().toString();

                boolean check = validatePaymentDetails(name,numb,month,year,cvc);

                if(check==true){
                    openWinDialog(name,numb,month,year,cvc);
                }
                else{
//                    Toast.makeText(mpayment_form.this, "Fill the form with valid inputs", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }


    private Boolean validatePaymentDetails(String name, String numb, String month, String year, String cvc) {


        if (name.length() == 0) {
            edit_person.requestFocus();
            edit_person.setError("This Field Cannot be Empty");
            return false;
        }
        if (numb.length() < 16 || numb.length() == 0) {
            edit_numb.requestFocus();
            edit_numb.setError("Card number requires 16 digits");
            return false;
        }
        if (year.length() < 2 || year.length() == 0) {
            edit_yr.requestFocus();
            edit_yr.setError("Input the valid Year");
            return false;
        }
        if (month.length() < 2 || month.length() == 0) {
            edit_month.requestFocus();
            edit_month.setError("Input the valid Month");
            return false;

        } if (cvc.length() < 3 || cvc.length() == 0) {
            edit_cvc.requestFocus();
            edit_cvc.setError("Input the valid CVC code");
            return false;
        }

        else{
            return true;
        }
    }




    private void openWinDialog(String name,String numb, String yr, String month, String cvc){
    dialog.setContentView(R.layout.activity_mdialoguebox_success);
    dialog.getWindow().setBackgroundDrawable(new ColorDrawable((Color.TRANSPARENT)));

        Button btn_no = dialog.findViewById(R.id.btn_no);
        Button btn_yes = dialog.findViewById(R.id.btn_yes);
        dialog.show();

        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

}