package com.zsh.blackcard.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

/**
 * Created by ZCY on 2018/1/11.
 * 快速调用Banner工具类方法
 */

public class BannerUtils {

    /**
     * 此方法为没有banner文字描述类型，如需要请，自行封装
     *
     * @param banner    轮播控件
     * @param listImg   轮播图片集合
     * @param position  轮播时间
     */
    public static void bannerNoImg(Banner banner, List<String> listImg, int position) {
        banner.setImages(listImg);
        banner.setImageLoader(new MyImageLoader());
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.isAutoPlay(true);
        banner.setDelayTime(position);
        banner.start();
    }

    //banner加载图片类
    private static class MyImageLoader extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }
}
