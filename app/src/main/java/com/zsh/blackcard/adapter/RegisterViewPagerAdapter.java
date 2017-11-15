package com.zsh.blackcard.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zsh.blackcard.R;
import com.zsh.blackcard.ui.RegisterActivity;

/**
 * Created by kkkkk on 2017/11/14.
 */

public class RegisterViewPagerAdapter extends PagerAdapter {

    private Context context;
    private int[] images;

    public RegisterViewPagerAdapter(RegisterActivity registerActivity, int[] images) {
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
        imageView.setImageDrawable(context.getResources().getDrawable(R.mipmap.signup_image_1));
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
