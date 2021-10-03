package com.example.cargillsshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        ImageSlider imageSlider=findViewById(R.id.slide);
        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS4iEqiKRaT-l577YZJCvCPf_LIfe_nucEQplRc2UbzG2hgfZJ5HOPLKQrRCZEcP5aPu_w&usqp=CAU"," "));
        slideModels.add(new SlideModel("https://www.pandcfresh.com/wp-content/uploads/sites/264/2019/10/slide-ad-1-1.jpg"," "));
        slideModels.add(new SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwXl6SjC4YgAJpW1Z1WYI-WfxRCrLkwt8bcoJ-BeJKsCBrecbfQ-Ib6RSUyP4r2odzKws&usqp=CAU"," "));
        slideModels.add(new SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTS9t24cD6xvI4nh2pJ_tI3RZPJEV5itqDSjw&usqp=CAU"," "));
        imageSlider.setImageList(slideModels,true);

    }
}
