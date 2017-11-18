package com.zsh.blackcard.ui.live;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RelativeLayout;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.custom.ViewPagerIndicator;
import com.zsh.blackcard.fragment.live.LiveAnchorDetailWeiBoFragment;

import butterknife.BindView;

/**
 * Name: LiveAnchorDetails
 * Author: SNXJ
 * Date: 2017-11-10
 * Description: 主播详情
 */
public class LiveAnchorDetails2 extends BaseActivity {
    @BindView(R.id.id_stickynavlayout_topview)
    RelativeLayout idStickynavlayoutTopview;

    ViewPagerIndicator mIndicator;
    ViewPager mViewPager;
    private String[] mTitles = new String[]{"黑微博", "小视频", "资料"};
    private LiveAnchorDetailWeiBoFragment[] mFragments = new LiveAnchorDetailWeiBoFragment[mTitles.length];

    private FragmentPagerAdapter mAdapter;

    @Override
    protected void initUI() {
        setContentView(R.layout.live_anchor2_details);
        mIndicator = (ViewPagerIndicator) findViewById(R.id.id_stickynavlayout_indicator);
        mViewPager = (ViewPager) findViewById(R.id.id_stickynavlayout_viewpager);

        initDatas();
        initEvents();

    }

    private void initEvents() {
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
                mIndicator.scroll(position, positionOffset);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initDatas() {
        mIndicator.setTitles(mTitles);

        for (int i = 0; i < mTitles.length; i++) {
            mFragments[i] = LiveAnchorDetailWeiBoFragment.newInstance(mTitles[i]);
        }
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return mTitles.length;
            }

            @Override
            public Fragment getItem(int position) {
                return mFragments[position];
            }

        };

        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(0);
    }


}
