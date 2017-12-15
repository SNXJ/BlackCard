package com.zsh.blackcard.music.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Name: MusicSingerFragment
 * Author: SNXJ
 * Date: 2017-12-13
 * Description:描述：
 */
public class MusicLibraryFragment extends BaseFragment {

    @BindView(R.id.music_main_tab)
    TabLayout musicMainTab;
    @BindView(R.id.music_mian_viewpage)
    ViewPager musicMianViewpage;
    private List<Fragment> fragments = new ArrayList<>();
    private String[] title = {"推荐", "精选", "最热", "最新"};

    @Override
    public View initView(LayoutInflater inflater) {
        View view = View.inflate(getActivity(), R.layout.music_library2_activity, null);
        ButterKnife.bind(getActivity());
        return view;
    }

    @Override
    public void initDate(Bundle savedInstanceState) {
        fragments.add(MusicRecommendFragment.newInstance(1));
        fragments.add(MusicReOtherFragment.newInstance(1));//精选
        fragments.add(MusicReOtherFragment.newInstance(25));//热歌
        fragments.add(MusicReOtherFragment.newInstance(1));//新歌
        MusicLibraryFragment.FragmentAdapter adapter = new MusicLibraryFragment.FragmentAdapter(getActivity().getSupportFragmentManager(), fragments);
        musicMianViewpage.setOffscreenPageLimit(4);
        musicMianViewpage.setAdapter(adapter);
        musicMainTab.setupWithViewPager(musicMianViewpage);
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
