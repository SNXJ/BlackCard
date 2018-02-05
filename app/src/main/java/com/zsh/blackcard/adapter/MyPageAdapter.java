package com.zsh.blackcard.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.zsh.blackcard.utils.LogUtils;

import java.util.List;


/**
 * Name: MyPageAdapter
 * Author: Shing
 * Date: 2018/2/3 下午4:35
 * Description: ..
 */

public class MyPageAdapter extends PagerAdapter {
    List<View> recycleViews;

    public MyPageAdapter(List<View> views) {
        recycleViews = views;
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public int getCount() {
        return recycleViews.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position,
                            Object object) {

        container.removeView(recycleViews.get(position));

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        container.addView(recycleViews.get(position));
        return recycleViews.get(position);
    }
}
