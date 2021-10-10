package com.example.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterTabFragment extends Fragment {

    EditText mobile,email,password,fname,lname,nic;
    Button register;
    float v =0;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    private FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.register_fragment,container,false);

        email= root.findViewById(R.id.email);
        password= root.findViewById(R.id.password);
        mobile= root.findViewById(R.id.mobile);
        fname= root.findViewById(R.id.fname);
        lname= root.findViewById(R.id.lname);
        nic= root.findViewById(R.id.nic);
        register= root.findViewById(R.id.register);

        email.setTranslationX(800);
        password.setTranslationX(800);
        mobile.setTranslationX(800);
        fname.setTranslationX(800);
        lname.setTranslationX(800);
        nic.setTranslationX(800);
        register.setTranslationX(800);

        email.setAlpha(v);
        password.setAlpha(v);
        mobile.setAlpha(v);
        fname.setAlpha(v);
        lname.setAlpha(v);
        nic.setAlpha(v);
        register.setAlpha(v);

        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        password.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        mobile.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        lname.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        fname.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        nic.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        register.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();

//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                rootNode = FirebaseDatabase.getInstance();
//                reference = rootNode.getReference("Users");
//
//                final String mail = email.getText().toString();
//                final String pwd = password.getText().toString();
//                final String phone = mobile.getText().toString();
//                final String fn = fname.getText().toString();
//                final String ln = lname.getText().toString();
//                final String no = nic.getText().toString();
//
//
//
//                mAuth.createUserWithEmailAndPassword(mail,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if(task.isSuccessful()){
//
//                            RegisterHelper helper = new RegisterHelper(phone,mail,pwd,fn,ln,no);
//
//                            reference.child(mail).setValue(helper);
//
//                            Toast.makeText(getActivity(),"Registered Unsuccessful",Toast.LENGTH_LONG).show();
//                            startActivity(new Intent(getActivity(),LoginTabFragment.class));
//                        }
//                        else{
//                            Toast.makeText(getActivity(),"Registered Unsuccessful",Toast.LENGTH_LONG).show();
//                        }
//                    }
//                });
//
//            }
//        });



        return root;
    }

}
