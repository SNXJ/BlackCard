package com.zsh.blackcard.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Name: PublicFragmentAdapter
 * Author: SNXJ
 * Date: 2017-12-19
 * Description: 公共的FragmentPagerAdapter：
 */
public class PublicFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    private String[] mTitles;

    public PublicFragmentAdapter(FragmentManager fm, List<Fragment> fragmentList, String[] mTitles) {
        super(fm);
        this.fragmentList = fragmentList;
        this.mTitles = mTitles;
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

        return null==mTitles?(super.getPageTitle(position)):mTitles[position];
    }
}

