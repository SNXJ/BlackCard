package com.zsh.blackcard.ui;

import android.support.v4.view.ViewPager;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.RegisterViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.crosswall.lib.coverflow.CoverFlow;
import me.crosswall.lib.coverflow.core.PagerContainer;

/**
 * Created by kkkkk on 2017/11/14.
 */

public class RegisterActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

//    @BindView(R.id.register_viewPager)
//    ViewPager register_viewPager;

    @BindView(R.id.pager_container)
    PagerContainer pager_container;

    private RegisterViewPagerAdapter adapter;
    private ViewPager viewPager;
    private int[] images = new int[]{R.mipmap.signup_image_1, R.mipmap.signup_image_1, R.mipmap.signup_image_1, R.mipmap.signup_image_1, R.mipmap.signup_image_1};

    private int currentPosition;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        initDate();
    }

    private void initDate() {
        viewPager = pager_container.getViewPager();
        adapter = new RegisterViewPagerAdapter(this, images);
        viewPager.setAdapter(adapter);
        viewPager.setClipChildren(false);
        viewPager.setOffscreenPageLimit(5);

        new CoverFlow.Builder()
                .with(viewPager)
                .scale(0.3f)
                .pagerMargin(-40f)
                .spaceSize(0f)
                .rotationY(0f)
                .build();

        viewPager.addOnPageChangeListener(this);
        viewPager.setCurrentItem(1, false);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        currentPosition = position;

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if(state != ViewPager.SCROLL_STATE_IDLE){
            return;
        }

        //根据动画是否停止，优化滑动视觉效果。
        if (currentPosition < 1) {
            currentPosition = 3;
            viewPager.setCurrentItem(currentPosition, false);
        } else if (currentPosition > 3) {
            viewPager.setCurrentItem(1, false);
        }
    }
}
