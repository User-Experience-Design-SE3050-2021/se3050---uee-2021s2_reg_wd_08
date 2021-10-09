package com.example.cargillsshop;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class m_Data_Access_Class {
    private DatabaseReference databaseReference;

    public m_Data_Access_Class(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(m_CreditCard_Class.class.getSimpleName());
    }


    public Task<Void> add(m_CreditCard_Class card){
        return databaseReference.push().setValue(card);
    }
}
