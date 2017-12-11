package com.zsh.blackcard.ui.zgactivity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.CompoundButton;

import com.bumptech.glide.Glide;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.fragment.ZgFindFragment;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.ZgFindTitleModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import cn.jzvd.JZUserActionStandard;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Name: DiscoverActivity
 * Author: SNXJ
 * Date: 2017-11-12
 * Description:描述：
 */
public class DiscoverActivity extends BaseActivity implements TabLayout.OnTabSelectedListener {

    @BindView(R.id.my_order_other_tabLayout)
    TabLayout my_order_other_tabLayout;

    private List<String> titleList = new ArrayList<>();
    private List<Fragment> fragmentList;
    private Fragment fragmentReplace;
    private FragmentManager fragmentManager;
    private boolean isOk = false;

    @Override
    protected void initUI() {
        setContentView(R.layout.discover_activity);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        fragmentManager = getSupportFragmentManager();
        //初始化title请求
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postZgFindTiele(DataManager.getMd5Str("CAIDAN")), new ResultListener<ZgFindTitleModel>() {
            @Override
            public void responseSuccess(ZgFindTitleModel obj) {
                if (obj.getResult().equals("01")) {
                    fragmentList = new ArrayList<>(obj.getPd().size());
                    for (int i = 0; i < obj.getPd().size(); i++) {
                        my_order_other_tabLayout.addTab(my_order_other_tabLayout.newTab().setText(obj.getPd().get(i).getNAME()));
                        //相对应的列表id集合
                        titleList.add(obj.getPd().get(i).getCAIDAN_ID());
                        fragmentList.add(fragmentReplace);
                    }
                    ZgFindFragment zgFindFragment = new ZgFindFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("id", obj.getPd().get(0).getCAIDAN_ID());
                    zgFindFragment.setArguments(bundle);
                    fragmentList.add(0,zgFindFragment);
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.discover_container, fragmentList.get(0));
                    fragmentTransaction.commit();
                    fragmentReplace = zgFindFragment;
                    my_order_other_tabLayout.addOnTabSelectedListener(DiscoverActivity.this);
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
//        JZVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onBackPressed() {
//        if (JZVideoPlayer.backPress()) {
//            return;
//        }
//        super.onBackPressed();
    }

    @OnClick(R.id.title_back)
    public void onClick() {
        finish();
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        if (fragmentList.get(tab.getPosition()) == null) {
            ZgFindFragment zgFindFragment = new ZgFindFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", titleList.get(tab.getPosition()));
            zgFindFragment.setArguments(bundle);
            fragmentList.add(tab.getPosition(), zgFindFragment);
            replace(fragmentList.get(tab.getPosition()));
        } else {
            replace(fragmentList.get(tab.getPosition()));
        }
    }

    private void replace(Fragment fragment) {
        FragmentTransaction
                fragmentTransaction = fragmentManager.beginTransaction();
        if (fragment.isAdded()) {
            fragmentTransaction.hide(fragmentReplace).show(fragment).commit();
        } else {
            fragmentTransaction.hide(fragmentReplace).add(R.id.discover_container, fragment).commit();
        }
        fragmentReplace = fragment;
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
