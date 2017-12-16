package com.zsh.blackcard.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zsh.blackcard.R;
import com.zsh.blackcard.ui.RegisterActivity;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/14.
 */

public class RegisterViewPagerAdapter extends PagerAdapter {

    private Context context;
    private List<String> images;

    public RegisterViewPagerAdapter(RegisterActivity registerActivity, List<String> images) {
        this.context = registerActivity;
        this.images = images;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.cover_item, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.image_cover);
        Glide.with(context).load(images.get(position)).into(imageView);
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    //解决ViewPager无法刷新的问题
//    @Override
//    public int getItemPosition(Object object) {
//        return POSITION_NONE;
//    }
}
