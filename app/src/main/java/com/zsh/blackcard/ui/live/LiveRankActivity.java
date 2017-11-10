package com.zsh.blackcard.ui.live;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.fragment.live.LiveRankAnchorFragment;
import com.zsh.blackcard.fragment.live.LiveRankUserFragment;

/**
 * Name: LiveRankActivity
 * Author: SNXJ
 * Date: 2017-11-10
 * Description:  等級（用户等级 和 主播等级）
 */
public class LiveRankActivity extends BaseActivity implements View.OnClickListener {
    // Content View Elements

    private ImageView title_back;
    private TextView title_tv;
    private RadioButton rb_live_user;
    private RadioButton rb_live_zhubo;
    private android.support.v4.view.ViewPager rank_vp;

    // End Of Content View Elements

    private void bindViews() {
        title_back = (ImageView) findViewById(R.id.title_back);
        title_tv = (TextView) findViewById(R.id.title_tv);
        rb_live_user = (RadioButton) findViewById(R.id.rb_live_user);
        rb_live_zhubo = (RadioButton) findViewById(R.id.rb_live_zhubo);
        rank_vp = (android.support.v4.view.ViewPager) findViewById(R.id.rank_vp);
        title_back.setOnClickListener(this);
        rb_live_user.setOnClickListener(this);
        rb_live_zhubo.setOnClickListener(this);
        rank_vp.setOnPageChangeListener(pgListener);
    }

    ViewPager.OnPageChangeListener pgListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    rb_live_user.setChecked(true);
                    rb_live_zhubo.setChecked(false);
                    break;
                case 1:
                    rb_live_user.setChecked(false);
                    rb_live_zhubo.setChecked(true);
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
        rank_vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                switch (position) {
                    case 0:
                        fragment = new LiveRankUserFragment();
                        break;
                    case 1:
                        fragment = new LiveRankAnchorFragment();
                        break;
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return 2;
            }
        });

    }

    @Override
    protected void initUI() {
        setContentView(R.layout.live_rank_activity);
        bindViews();
        addAdapter();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.rb_live_zhubo:
                rank_vp.setCurrentItem(1, true);
                break;
            case R.id.rb_live_user:
                rank_vp.setCurrentItem(0, true);
                break;
            default:
                break;
        }
    }
}

