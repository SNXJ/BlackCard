package com.zsh.blackcard.view;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by kkkkk on 2017/11/14.
 */

public class ZoomOutPageTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View view, float position) {
        float scaleFactor = Math.max(0.5f, 1 - Math.abs(position));
        if (position <= 0) {
            view.setTranslationX(position);
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);
        } else if (position <= 1) {
            view.setTranslationX(position);
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);
        }
    }
}
