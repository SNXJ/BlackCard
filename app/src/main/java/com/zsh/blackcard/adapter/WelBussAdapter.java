package com.zsh.blackcard.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZCY on 2018/1/22.
 * 商家入驻欢迎引导页适配器
 */

public class WelBussAdapter extends PagerAdapter {

    private List<View> viewList = new ArrayList();

    public WelBussAdapter(List<View> list) {
        this.viewList = list;
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));// 删除页卡
    }

    // 这个方法用来实例化页卡
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewList.get(position));// 添加页卡
        return viewList.get(position);
    }

    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
