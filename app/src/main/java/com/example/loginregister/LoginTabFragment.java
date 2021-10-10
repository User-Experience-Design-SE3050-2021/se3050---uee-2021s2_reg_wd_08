package com.example.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginTabFragment extends Fragment {

    EditText email,password;
    TextView forgotpwd;
    Button login;
    float v =1;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_frgment,container,false);

        mAuth = FirebaseAuth.getInstance();


        email= root.findViewById(R.id.email);
        password= root.findViewById(R.id.password);
        forgotpwd= root.findViewById(R.id.forgot);
        login= root.findViewById(R.id.button);

        email.setTranslationX(800);
        password.setTranslationX(800);
        forgotpwd.setTranslationX(800);
        login.setTranslationX(800);

        email.setAlpha(v);
        password.setAlpha(v);
        forgotpwd.setAlpha(v);
        login.setAlpha(v);

        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        password.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        forgotpwd.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        login.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();

//        mAuthListener = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//
//                FirebaseUser mFirebaseUser = mAuth.getCurrentUser();
//
//                if(mFirebaseUser != null){
//                    Toast.makeText(getActivity(),"You are logged in",Toast.LENGTH_LONG).show();
////                    Intent i = new Intent(getActivity(),PaymentActivity.class);
////                    startActivity(i);
//                }
//                else{
//                    Toast.makeText(getActivity(),"Please Login",Toast.LENGTH_LONG).show();
//
//                }
//            }
//        };


//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                rootNode = FirebaseDatabase.getInstance();
//                reference = rootNode.getReference("Users");
//
//                String mail = email.getText().toString();
//                String pwd = password.getText().toString();
//
//                if(mail.isEmpty()){
//                    email.setError("Please enter the email id");
//                    email.requestFocus();
//                }
//                else if(pwd.isEmpty()){
//                    password.setError("Please enter the password ");
//                    password.requestFocus();
//                }else if(!(mail.isEmpty() && pwd.isEmpty())) {
//
//                    mAuth.signInWithEmailAndPassword(mail,pwd).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if(!task.isSuccessful()){
//                                Toast.makeText(getActivity(), "Login Error, Please Login again", Toast.LENGTH_LONG).show();
//                            } else{
////                                Intent i = new Intent(getActivity(),.class);
////                                startActivity(i);
//                                Toast.makeText(getActivity(), "Login success", Toast.LENGTH_LONG).show();
//
//                            }
//                        }
//
//                    });
//
//                } else {
//                    Toast.makeText(getActivity(), "Error occurred", Toast.LENGTH_LONG).show();
//
//                }
//            }
//        });


        return root;
    }
}
