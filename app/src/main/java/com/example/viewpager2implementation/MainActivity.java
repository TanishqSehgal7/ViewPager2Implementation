package com.example.viewpager2implementation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Fragment> fragList = new ArrayList<>();
    ViewPager2 viewPager;
    Button next;
    Button previous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpager2);

        fragList.add(new Frag1());
        fragList.add(new Frag2());
        fragList.add(new Frag3());
        fragList.add(new Frag4());


        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, fragList);
        viewPager.setPageTransformer(new DepthPageTransformer());
        viewPager.setAdapter(viewPagerAdapter);

        next=findViewById(R.id.button2);
        previous = findViewById(R.id.button);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewPager.getCurrentItem()!=fragList.size()) {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                }
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
            }
        });

        viewPager.setUserInputEnabled(false);
        viewPager.setPageTransformer(new ZoomOutTransformation());
    }

}