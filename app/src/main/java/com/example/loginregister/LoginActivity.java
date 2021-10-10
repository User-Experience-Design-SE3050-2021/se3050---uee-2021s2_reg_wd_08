package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class LoginActivity extends AppCompatActivity {

    TabLayout tab;
    ViewPager viewPager;
    float v = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tab = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewpager);

        tab.addTab(tab.newTab().setText("Login"));
        tab.addTab(tab.newTab().setText("Signup"));
        tab.setTabGravity(TabLayout.GRAVITY_FILL);

        final LoginAdapter adapter = new LoginAdapter(getSupportFragmentManager(),this,tab.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));

        tab.setTranslationY(300);
        tab.setAlpha(v);

        tab.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(100).start();


    }
}