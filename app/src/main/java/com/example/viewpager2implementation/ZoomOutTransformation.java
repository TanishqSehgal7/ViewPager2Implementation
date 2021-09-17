package com.example.viewpager2implementation;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

public class ZoomOutTransformation implements ViewPager2.PageTransformer {

    private static final float MIN_SCALE = 0.85f;
    private static final float MIN_ALPHA = 0.50f;


    @Override
    public void transformPage(@NonNull View page, float position) {
        int width = page.getHeight();
        int height = page.getHeight();

        if(position<-1) {
            page.setAlpha(0f);
        } else if (position<=1) {
            float scaleFactor = Math.max(MIN_SCALE, Math.abs(position));
            float verticalMargin = height*(1-scaleFactor)/2;
            float horizontalMargin = height*(1-scaleFactor) /2;

            if (position<0) {
                page.setTranslationX(horizontalMargin-verticalMargin/2);
            } else {
                page.setTranslationX(-horizontalMargin+verticalMargin/2);
            }
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);

            page.setAlpha(MIN_ALPHA + (scaleFactor-MIN_SCALE)/(1-MIN_SCALE)*(1-MIN_ALPHA));

        } else {
            page.setAlpha(0f);
        }
    }
}
