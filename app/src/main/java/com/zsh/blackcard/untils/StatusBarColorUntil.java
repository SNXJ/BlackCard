package com.zsh.blackcard.untils;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

/**
 * Name: StatusBarColorUntil
 * Author: SNXJ
 * Date: 2017-11-07
 * Description:状态栏工具类
 */
public class StatusBarColorUntil {
    public static void setStatusBarColor(Activity activity) {
        //设置 paddingTop
       // ViewGroup rootView = (ViewGroup)activity.getWindow().getDecorView().findViewById(android.R.id.content);
        //  rootView.setPadding(0, getStatusBarHeight(), 0, 0);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //5.0 以上直接设置状态栏颜色
            LogUtils.i("______5.0_________", "SDK+" + Build.VERSION.SDK_INT);
            activity.getWindow().setStatusBarColor(Color.BLACK);
        } else {
            LogUtils.i("_______________", "SDK+" + Build.VERSION.SDK_INT);
            //根布局添加占位状态栏
            ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();
            View statusBarView = new View(activity);
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    getStatusBarHeight(activity));
            statusBarView.setBackgroundColor(Color.BLACK);
            decorView.addView(statusBarView, lp);
        }
    }

    /**
     * 利用反射获取状态栏高度
     *
     * @return
     */
    public static int getStatusBarHeight(Activity activity) {
        int result = 0;
        //获取状态栏高度的资源id
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = activity.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
