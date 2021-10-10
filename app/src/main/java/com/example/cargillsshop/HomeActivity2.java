package com.example.cargillsshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity2 extends AppCompatActivity {


    EditText search;
    ImageView veg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        getSupportActionBar().hide();
        ImageSlider imageSlider=findViewById(R.id.slide);
        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel("https://www.grandhypermarkets.com/uae/image/cache/catalog/slider/banner-825x482.jpg"," "));
        slideModels.add(new SlideModel("https://www.pandcfresh.com/wp-content/uploads/sites/264/2019/10/slide-ad-1-1.jpg"," "));
        slideModels.add(new SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQTUU6fQCgVR1UN4K0nsEec3M1wKyL8_WvqyneznZZ9hl3Ieyz6cmKCq23kMe9t1494TRg&usqp=CAU"," "));
        slideModels.add(new SlideModel("https://cdn.shopify.com/s/files/1/0508/7995/5128/files/lambu_banners-03.png?v=1608921099"," "));
        imageSlider.setImageList(slideModels,true);

        veg=findViewById(R.id.vegcategory);
        veg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(HomeActivity2.this, CategoryActivity2.class);
                startActivity(myintent);
            }
        });

        search=findViewById(R.id.Search_box);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(HomeActivity2.this, SearchProductActivity.class);
                startActivity(myintent);
            }
        });
    }
}
