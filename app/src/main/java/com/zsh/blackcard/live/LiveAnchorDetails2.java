package com.zsh.blackcard.live;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RelativeLayout;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.PublicFragmentAdapter;
import com.zsh.blackcard.fragment.live.LiveAnchorDetailWeiBoFragment;
import com.zsh.blackcard.utils.TabLayoutUntil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Name: LiveAnchorDetails
 * Author: SNXJ
 * Date: 2017-11-10
 * Description: 主播详情
 */
public class LiveAnchorDetails2 extends BaseActivity {
    @BindView(R.id.id_stickynavlayout_topview)
    RelativeLayout idStickynavlayoutTopview;

    @BindView(R.id.id_stickynavlayout_indicator)
    TabLayout tab;
    @BindView(R.id.id_stickynavlayout_viewpager)
    ViewPager mViewPager;
    private String[] mTitles = new String[]{"黑微博", "小视频", "资料"};
    private List<Fragment> fragments = new ArrayList<>();
    private FragmentPagerAdapter mAdapter;

    @Override
    protected void initUI() {
        setContentView(R.layout.live_anchor2_details);
        ButterKnife.bind(this);
        mViewPager = (ViewPager) findViewById(R.id.id_stickynavlayout_viewpager);
        initDatas();
    }

    private void initDatas() {
        for (int i = 0; i < mTitles.length; i++) {
            fragments.add(LiveAnchorDetailWeiBoFragment.newInstance(mTitles[i]));
        }
        PublicFragmentAdapter adapter = new PublicFragmentAdapter(getSupportFragmentManager(), fragments, mTitles);
        mViewPager.setOffscreenPageLimit(4);
        mViewPager.setAdapter(adapter);
        tab.setupWithViewPager(mViewPager);
        TabLayoutUntil.setTabIndicator(tab, 30, 30);
    }


}
