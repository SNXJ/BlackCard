package com.zsh.blackcard.untils;

import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

/**
 * @author SXJ
 * @date 2016-7-29 上午11:36:44
 * @description 注释
 */
public class AnimationUtil {
    private static final String TAG = AnimationUtil.class.getSimpleName();

    /**
     * 从控件所在位置移动到控件的底部
     *
     * @return
     */
    public static TranslateAnimation moveToViewBottom() {
        TranslateAnimation mHiddenAction = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 1.0f);
        mHiddenAction.setDuration(500);
        mHiddenAction.setFillAfter(true);
        return mHiddenAction;
    }

    /**
     * 从控件的底部移动到控件所在位置
     *
     * @return
     */
    public static TranslateAnimation moveToViewLocation() {
        TranslateAnimation mHiddenAction = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.0f);
        mHiddenAction.setDuration(500);
        mHiddenAction.setFillAfter(true);
        return mHiddenAction;
    }

    public static ScaleAnimation fangda() {
        ScaleAnimation mScaleAnimation = new ScaleAnimation(0.5f, 1.5f, 0.5f, 1.5f,
                Animation.INFINITE, 0.5f, Animation.INFINITE, 0.5f);
        mScaleAnimation.setDuration(500);
        mScaleAnimation.setFillAfter(true);
        mScaleAnimation.start();
        return mScaleAnimation;
    }

    public static ScaleAnimation suoxiao() {
        ScaleAnimation mScaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f,
                0.5f,
                Animation.INFINITE, 1.0f, Animation.INFINITE, 1.0f);
        mScaleAnimation.setDuration(500);
        mScaleAnimation.setFillAfter(true);
        mScaleAnimation.start();
        return mScaleAnimation;
    }
}
