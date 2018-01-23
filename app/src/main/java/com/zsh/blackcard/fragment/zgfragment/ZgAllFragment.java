package com.zsh.blackcard.fragment.zgfragment;

import android.Manifest;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.listener.ZGSlidingListener;
import com.zsh.blackcard.ui.home.HomeScannerActivity;
import com.zsh.blackcard.ui.zgactivity.ZgSearchActivity;
import com.zsh.blackcard.utils.ActivityUtils;
import com.zsh.blackcard.utils.MPermissionUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by ZCY on 2018/1/11.
 */

public class ZgAllFragment extends BaseFragment {

    @BindView(R.id.zg_all_tab_layout)
    TabLayout zg_all_tab_layout;
    Unbinder unbinder;

    public void setZgSlidingListener(ZGSlidingListener zgSlidingListener) {
        this.zgSlidingListener = zgSlidingListener;
    }

    private ZGSlidingListener zgSlidingListener;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    private Fragment zgFragment, zgFashionFrg, zgSpecialFrg, zgFlagFrg, zgVipFrg, frg_replace;

    @Override
    public void initDate(Bundle savedInstanceState) {
        //给tabLayout添加监听
        zg_all_tab_layout.addOnTabSelectedListener(new TabLayoutSelected());

        fragmentManager = getChildFragmentManager();

        if (zgFragment == null) {
            zgFragment = new ZgFragment();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.zg_all_container, zgFragment);
            fragmentTransaction.commit();
            frg_replace = zgFragment;
        }
    }

    //封装隐藏和显示布局方法
    private void replaceFragment(Fragment fragment) {
        FragmentTransaction
                fragmentTransaction = fragmentManager.beginTransaction();
        if (fragment.isAdded()) {
            fragmentTransaction.hide(frg_replace).show(fragment).commit();
        } else {
            fragmentTransaction.hide(frg_replace).add(R.id.zg_all_container, fragment).commit();
        }
        frg_replace = fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    //TabLayout的点击事件
    private class TabLayoutSelected implements TabLayout.OnTabSelectedListener {

        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            switch (tab.getPosition()) {
                case 0:
                    replaceFragment(zgFragment);
                    break;
                case 1:
                    if (zgFashionFrg == null) {
                        zgFashionFrg = new ZgFashionFragment();
                    }
                    replaceFragment(zgFashionFrg);
                    break;
                case 2:
                    if (zgSpecialFrg == null) {
                        zgSpecialFrg = new ZgSpecialFragment();
                    }
                    replaceFragment(zgSpecialFrg);
                    break;
                case 3:
                    if (zgFlagFrg == null) {
                        zgFlagFrg = new ZgFlagshipFragment();
                    }
                    replaceFragment(zgFlagFrg);
                    break;
                case 4:
                    if (zgVipFrg == null) {
                        zgVipFrg = new ZgVipFragment();
                    }
                    replaceFragment(zgVipFrg);
                    break;
            }
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    }

    @Override
    public View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.zg_all_fragment, null);
        ButterKnife.bind(this, view);
        return view;
    }

    //普通按钮点击事件
    @OnClick({R.id.zg_myleftimg, R.id.zg_title_search_linear, R.id.im_scanner})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.zg_myleftimg:
                zgSlidingListener.onMeauClick();
                break;
            case R.id.zg_title_search_linear:
                ActivityUtils.startActivity(getActivity(), ZgSearchActivity.class);
                break;
            case R.id.im_scanner:
                requestCAMERA();
                break;
        }
    }


    private void requestCAMERA() {
        String[] PERMISSIONS_STORAGE = {
                Manifest.permission.CAMERA
        };
        MPermissionUtils.requestPermissionsResult(this, 1, PERMISSIONS_STORAGE
                , new MPermissionUtils.OnPermissionListener() {
                    @Override
                    public void onPermissionGranted() {
                        ActivityUtils.startActivity(getActivity(), HomeScannerActivity.class);
                    }

                    @Override
                    public void onPermissionDenied() {
                        MPermissionUtils.showTipsDialog(getActivity());
                    }
                });

    }
}
