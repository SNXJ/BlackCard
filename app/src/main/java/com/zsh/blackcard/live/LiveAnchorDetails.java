package com.zsh.blackcard.live;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.fragment.live.LiveAnchorMoreFragment;
import com.zsh.blackcard.fragment.live.LiveAnchorWeiboFragment;
import com.zsh.blackcard.fragment.live.LiveAnchorVideoFragment;

/**
 * Name: LiveAnchorDetails
 * Author: SNXJ
 * Date: 2017-11-10
 * Description: 主播详情
 */
public class LiveAnchorDetails extends BaseActivity implements View.OnClickListener {

    private RadioButton live_detail_weibo;
    private RadioButton live_detail_video;
    private RadioButton live_detail_data;
    private android.support.v4.view.ViewPager live_detail_vp;

    // End Of Content View Elements

    private void bindViews() {

        live_detail_weibo = (RadioButton) findViewById(R.id.live_detail_weibo);
        live_detail_video = (RadioButton) findViewById(R.id.live_detail_video);
        live_detail_data = (RadioButton) findViewById(R.id.live_detail_data);
        live_detail_vp = (android.support.v4.view.ViewPager) findViewById(R.id.live_detail_vp);
        live_detail_data.setOnClickListener(this);
        live_detail_video.setOnClickListener(this);
        live_detail_weibo.setOnClickListener(this);
        live_detail_vp.setOnPageChangeListener(pgListener);
    }

    ViewPager.OnPageChangeListener pgListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    live_detail_weibo.setChecked(true);
                    live_detail_video.setChecked(false);
                    live_detail_data.setChecked(false);
                    break;
                case 1:
                    live_detail_weibo.setChecked(false);
                    live_detail_video.setChecked(true);
                    live_detail_data.setChecked(false);
                    break;
                case 2:
                    live_detail_weibo.setChecked(false);
                    live_detail_video.setChecked(false);
                    live_detail_data.setChecked(true);
                    break;
                default:
                    break;

            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private void addAdapter() {
        live_detail_vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                switch (position) {
                    case 0:
                        fragment = new LiveAnchorVideoFragment();
                        break;
                    case 1:
                        fragment = new LiveAnchorWeiboFragment();
                        break;
                    case 2:
                        fragment = new LiveAnchorMoreFragment();
                        break;
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return 3;
            }
        });

    }

    @Override
    protected void initUI() {
        setContentView(R.layout.live_anchor_details);
        bindViews();
        addAdapter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.live_detail_weibo:
                live_detail_vp.setCurrentItem(0, true);
                break;
            case R.id.live_detail_video:
                live_detail_vp.setCurrentItem(1, true);
                break;
            case R.id.live_detail_data:
                live_detail_vp.setCurrentItem(2, true);
                break;
        }
    }
}
