package com.zsh.blackcard.music;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Name: MusicLibraryActivity
 * Author: SNXJ
 * Date: 2017-12-07
 * Description:描述：
 */
public class MusicLibraryActivity extends BaseActivity {
    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.music_main_tab)
    TabLayout musicMainTab;
    @BindView(R.id.music_mian_viewpage)
    ViewPager musicMianViewpage;
    private List<Fragment> fragments = new ArrayList<>();
    private String[] title = {"推荐", "精选", "最热", "最新"};

    @Override
    protected void initUI() {
        setContentView(R.layout.music_library_activity);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        fragments.add(MusicRecommendFragment.newInstance(1));
        fragments.add(MusicReOtherFragment.newInstance(1));//精选
        fragments.add(MusicReOtherFragment.newInstance(25));//热歌
        fragments.add(MusicReOtherFragment.newInstance(1));//新歌
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), fragments);
        musicMianViewpage.setOffscreenPageLimit(6);

        musicMianViewpage.setAdapter(adapter);
        musicMainTab.setupWithViewPager(musicMianViewpage);

    }

    @OnClick(R.id.title_back)
    public void onClick() {
        finish();
    }

    public class FragmentAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragmentList;

        public FragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            this.fragmentList = fragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }

}
