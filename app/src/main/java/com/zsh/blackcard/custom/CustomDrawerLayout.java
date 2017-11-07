package com.zsh.blackcard.custom;


import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;

/**
 * Name: CustomDrawerLayout
 * Author: SNXJ
 * Date: 2017-11-06
 * Description:为了避免onMeasure测量时候出现异常
 * 需要重写onMeasure自定义
 */
public class CustomDrawerLayout extends DrawerLayout {
  //  ;

    public CustomDrawerLayout(Context context) {
        super(context);
    }

    public CustomDrawerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomDrawerLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        widthMeasureSpec = MeasureSpec.makeMeasureSpec(
                MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.EXACTLY);
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(
                MeasureSpec.getSize(heightMeasureSpec), MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
