package com.zsh.blackcard.custom;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.zsh.blackcard.R;
import com.zsh.blackcard.listener.ItemClickListener;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Name: RadialViewLayout
 * Author: SNXJ
 * Date: 2017-11-18
 * Description: 弹出动画
 */
public class RadialViewLayout extends FrameLayout {

    private final static long DURATION_SHORT = 400;
    @BindView(R.id.ll_black_weibo)
    View llBlackWeibo;
    @BindView(R.id.ll_live_video)
    View llLiveVideo;
    @BindView(R.id.ll_open_live)
    View llOpenLive;
    @BindView(R.id.ll_black_main)
    View llBlackMain;
    private WeakReference<Context> weakContext;

    private boolean isOpen = false;
    private Toast toast;


    public RadialViewLayout(final Context context) {
        this(context, null);
    }

    public RadialViewLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RadialViewLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        weakContext = new WeakReference<Context>(context);
        LayoutInflater.from(context).inflate(R.layout.pop_live_main, this);

        if (isInEditMode()) {
            //
        } else {
            ButterKnife.bind(this);
        }
    }

    private ItemClickListener lister;

    public void setOnListener(ItemClickListener lister) {
        this.lister = lister;

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode()) {
            //
        } else {

        }
    }

    private void onListener(final int pos) {

        if (null != lister) {
            lister.itemClick(pos);
        }
    }

    @OnClick(R.id.ll_black_main)
    public void onMainButtonClicked(final View btn) {
//        int resId;
//        if (isOpen) {
//            hide(llBlackWeibo);
//            hide(llOpenLive);
//            hide(llLiveVideo);
//            isOpen = false;
//            // resId ="关闭";
//            resId = 0;
//        } else {
//            show(llBlackWeibo, 2, 300);
//            show(llOpenLive, 3, 300);
//            show(llLiveVideo, 4, 300);
//            isOpen = true;
//            resId = 1;
//        }
        //      onListener(resId);
        showOpenOrHide();
        btn.playSoundEffect(SoundEffectConstants.CLICK);
    }

    private int showOpenOrHide() {
        int resId;
        if (isOpen) {
            hide(llBlackWeibo);
            hide(llOpenLive);
            hide(llLiveVideo);
            isOpen = false;
            // resId ="关闭";
            resId = 0;
        } else {
            show(llBlackWeibo, 2, 300);
            show(llOpenLive, 3, 300);
            show(llLiveVideo, 4, 300);
            isOpen = true;
            resId = 1;
        }
        onListener(resId);
        return resId;
    }

    @OnClick({R.id.ll_black_weibo, R.id.ll_open_live, R.id.ll_live_video})
    public void onButtonClicked(final View btn) {
        int resId = 3;
        switch (btn.getId()) {
            case R.id.ll_black_weibo:
                //"黑微博";
                resId = 2;
                break;
            case R.id.ll_open_live:
                // "开启直播";
                resId = 3;
                break;
            case R.id.ll_live_video:
                resId = 4;
                break;

        }
        onListener(resId);
        btn.playSoundEffect(SoundEffectConstants.CLICK);
    }

    private final void hide(final View child) {
        child.animate()
                .setDuration(DURATION_SHORT)
                .alpha(0.5f)
                .scaleX(0.8f)
                .scaleY(0.8f)
                .translationX(0)
                .translationY(0).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                child.setVisibility(GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        })
                .start();
        llBlackMain.animate().rotation(45f).setInterpolator(new AccelerateDecelerateInterpolator()).start();

    }

    private final void show(final View child, final int position, final int radius) {

        float angleDeg = 180.f;
        int dist = radius;
        switch (position) {
            case 1:
                angleDeg += 0.f;
                break;
            case 2:
                angleDeg += 45.f;
                break;
            case 3:
                angleDeg += 90.f;
                break;
            case 4:
                angleDeg += 135.f;
                break;
            case 5:
                angleDeg += 180.f;
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                break;
        }

        final float angleRad = (float) (angleDeg * Math.PI / 180.f);

        final Float x = dist * (float) Math.cos(angleRad);
        final Float y = dist * (float) Math.sin(angleRad);
        child.animate()
                .setDuration(DURATION_SHORT)
                .alpha(1.0f)
                .scaleX(1.0f)
                .scaleY(1.0f)
                .translationX(x)
                .translationY(y).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                child.setVisibility(VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        })
                .start();
        llBlackMain.animate().rotation(-45f).setInterpolator(new AccelerateDecelerateInterpolator()).start();
    }
}
