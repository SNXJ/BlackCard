package com.zsh.blackcard.ui.zgactivity.zgmyindentfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.fragment.ZgFragment;
import com.zsh.blackcard.fragment.zgfragment.ZgAllFragment;
import com.zsh.blackcard.listener.ZGSlidingListener;
import com.zsh.blackcard.ui.CollectionActivity;
import com.zsh.blackcard.ui.ShoppingCarActivity;
import com.zsh.blackcard.ui.zgactivity.DiscoverActivity;
import com.zsh.blackcard.ui.zgactivity.GoodsCategoryActivity;
import com.zsh.blackcard.ui.zgactivity.PersonalActivity;
import com.zsh.blackcard.ui.zgactivity.ShareProfitActivity;
import com.zsh.blackcard.utils.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by admin on 2017/10/29.
 */

public class SlidingFragment extends BaseFragment {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.left_drawer)
    ListView left_drawer;

    private List<String> list;

    @Override
    public void initDate(Bundle savedInstanceState) {
        //添加默认主界面
        FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        ZgAllFragment zgAllFragment = new ZgAllFragment();
        zgAllFragment.setZgSlidingListener(zglistener);
        fragmentTransaction.replace(R.id.drawerLayout_frame, zgAllFragment);
        fragmentTransaction.commit();

        //填充侧滑列表数据
        list = new ArrayList<>();
        list.add("商品分类");
        list.add("发现");
        list.add("购物车");
        list.add("炫购");
        list.add("私人定制");
        list.add("分享赚钱");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.sliding_left_lv_item, list);
        left_drawer.setAdapter(adapter);

        left_drawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //TODO
                leftItemClick(position);

            }
        });
        drawerLayout.closeDrawer(Gravity.LEFT);//侧滑打开  不设置则不会默认打开
    }

    @Override
    public View initView(LayoutInflater inflater) {
        view = View.inflate(getActivity(), R.layout.slidingfragment, null);
        ButterKnife.bind(this, view);
        showDrawerLayout();
        return view;
    }

    ZGSlidingListener zglistener = new ZGSlidingListener() {
        @Override
        public void onMeauClick() {
            showDrawerLayout();
        }
    };

    private void showDrawerLayout() {
        if (!drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            drawerLayout.openDrawer(Gravity.LEFT);
        } else {
            drawerLayout.closeDrawer(Gravity.LEFT);
        }
    }

    private void leftItemClick(int position) {
        switch (position) {
            case 0://商品分类
                startActivity(new Intent(getActivity(), GoodsCategoryActivity.class));
                break;
            case 1://发现
                startActivity(new Intent(getActivity(), DiscoverActivity.class));
                break;
            case 2://购物车
                startActivity(new Intent(getActivity(), ShoppingCarActivity.class));
                break;
            case 3://炫购
                ActivityUtils.startActivity(getActivity(), CollectionActivity.class);
                break;
            case 4://私人定制
                startActivity(new Intent(getActivity(), PersonalActivity.class));
                break;
            case 5://分享赚钱
                startActivity(new Intent(getActivity(), ShareProfitActivity.class));
                break;

        }

    }
}
