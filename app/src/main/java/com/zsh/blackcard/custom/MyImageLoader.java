package com.zsh.blackcard.custom;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;


/**
 * Name: MyImageLoader
 * Author: Shing
 * Date: 2018/1/10 下午2:40
 * Description: ..
 */

public class MyImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load(path).into(imageView);
    }
}
