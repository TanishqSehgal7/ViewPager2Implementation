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

import com.example.viewpager2implementation.databinding.ActivityMainBinding;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Fragment> fragList = new ArrayList<>();
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        

        fragList.add(new Frag1());
        fragList.add(new Frag2());
        fragList.add(new Frag3());
        fragList.add(new Frag4());


        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, fragList);
        binding.viewpager2.setPageTransformer(new DepthPageTransformer());
        binding.viewpager2.setAdapter(viewPagerAdapter);


        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.viewpager2.getCurrentItem()!=fragList.size()) {
                    binding.viewpager2.setCurrentItem(binding.viewpager2.getCurrentItem() + 1);
                }
            }
        });

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.viewpager2.setCurrentItem(binding.viewpager2.getCurrentItem() - 1);
            }
        });

        binding.viewpager2.setUserInputEnabled(false);
        binding.viewpager2.setPageTransformer(new ZoomOutTransformation());
        binding.viewpager2.setAdapter(viewPagerAdapter);
        binding.dotsIndicator.setViewPager2(binding.viewpager2);
    
 
    }

}
