package com.zsh.blackcard.live;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.PublicFragmentAdapter;
import com.zsh.blackcard.live.fragment.LivingNoFragment;
import com.zsh.blackcard.live.fragment.LivingRoomFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Name: LivingRoomActivity
 * Author: Shing
 * Date: 2018/1/9 下午3:38
 * Description: ..
 */

public class LivingRoomActivity extends BaseActivity {
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    List<Fragment> fragmentList= new ArrayList<>();

    @Override
    protected void initUI() {
        setContentView(R.layout.living_room_activity);
        ButterKnife.bind(this);
        initViewPager();

    }

    private void initViewPager() {
        fragmentList.add(new LivingNoFragment());
        fragmentList.add(new LivingRoomFragment());

        viewPager.setAdapter( new PublicFragmentAdapter(getSupportFragmentManager(),fragmentList,null));
        viewPager.setCurrentItem(1);
        viewPager.setOffscreenPageLimit(2);


    }


}
