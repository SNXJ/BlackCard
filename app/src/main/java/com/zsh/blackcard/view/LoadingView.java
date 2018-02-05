package com.zsh.blackcard.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;

/**
 * Name: LondingView
 * Author: SNXJ
 * Date: 2017-12-12
 * Description:描述：
 */
public class LoadingView extends LinearLayout {

    public LoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);

        // 添加5条竖状矩形（波形）
        for (int i = 0; i < 5; i++) {
            final View v = new View(context);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(dip2px(7), dip2px(20));
            params.leftMargin = dip2px(2f);
            v.setBackgroundColor(Color.parseColor("#cccccc"));
            v.setLayoutParams(params);
            addView(v);

            // 纵向旋转
            ObjectAnimator oaRotation = ObjectAnimator.ofFloat(v, "rotationX", 0f, 360f);
            oaRotation.setRepeatCount(ObjectAnimator.INFINITE);
            oaRotation.setRepeatMode(ObjectAnimator.RESTART);
            oaRotation.setInterpolator(new LinearInterpolator()); // 避免循环一次就停顿一下的问题
            oaRotation.setStartDelay(100 * i);
            // 纵向伸缩
            ObjectAnimator oaScale = ObjectAnimator.ofFloat(v, "scaleY", 1.5f, 1.5f, 1.5f);
            oaScale.setRepeatCount(ObjectAnimator.INFINITE);
            oaScale.setRepeatMode(ObjectAnimator.RESTART);
            oaScale.setStartDelay(100 * i);
            // 组合动画
            AnimatorSet animSet = new AnimatorSet();
            animSet.play(oaRotation).with(oaScale);
            animSet.setDuration(2500);
            animSet.start();
        }
    }

    public int dip2px(float dpValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}