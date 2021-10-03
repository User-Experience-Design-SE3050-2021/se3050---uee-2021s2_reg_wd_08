package com.example.cargillsshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class CategoryActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category2);
    }



    public void changeFragment(View view)
    {
        Fragment fragment;

        if(view==findViewById(R.id.vegid))
        {
            fragment=new VegFragment();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.fragdefault,fragment);
            ft.commit();

        }
        if(view==findViewById(R.id.fruitid))
        {
            fragment=new fragment_fruit();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.fragdefault,fragment);
            ft.commit();

        }
        if(view==findViewById(R.id.fishes))
        {
            fragment=new fragment_fish();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.fragdefault,fragment);
            ft.commit();

        }
        if(view==findViewById(R.id.meat))
        {
            fragment=new fragment_meat();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.fragdefault,fragment);
            ft.commit();

        }
    }


}

