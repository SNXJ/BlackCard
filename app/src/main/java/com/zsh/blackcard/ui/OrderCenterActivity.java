package com.zsh.blackcard.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.zhouwei.library.CustomPopWindow;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.ZgOrderCenterAdapter;
import com.zsh.blackcard.fragment.OrderNoZgFragment;
import com.zsh.blackcard.fragment.OrderZgFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kkkkk on 2017/11/11.
 */

public class OrderCenterActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.zg_my_order_relative)
    RelativeLayout zg_my_order_relative;
    @BindView(R.id.zg_my_order_title_tv)
    TextView zg_my_order_title_tv;
    @BindView(R.id.zgmyback)
    ImageView zgmyback;
    //订单筛选弹窗适配器
    private ZgOrderCenterAdapter zgOrderCenterAdapter;
    private List<String> list = new ArrayList<>();
    private View viewPop;
    private CustomPopWindow customPopWindow;
    private FragmentManager fragmentManager;
    private Fragment orderZgFragment, orderNoZgFragment;
    private String searchTitle;

    public String getSearchTitle() {
        return searchTitle;
    }

    public void setSearchTitle(String searchTitle) {
        this.searchTitle = searchTitle;
    }

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_zg_my);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        //初始化订单筛选弹窗
        initRecyclerData();
        //添加尊购默认碎片
        initDefaultPage();
    }

    private void initDefaultPage() {
        orderZgFragment = new OrderZgFragment();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.zg_container, orderZgFragment);
        fragmentTransaction.commit();
    }

    /**
     * 初始化弹窗数据
     */
    private void initRecyclerData() {
        list.add("尊购");
        list.add("火车票");
        list.add("机票");
        list.add("酒店");
        list.add("KTV");
        list.add("美食");
        list.add("酒吧");
        list.add("电影票");

        zgOrderCenterAdapter = new ZgOrderCenterAdapter(R.layout.zg_my_order_recycler_popwindow_item, list);
        viewPop = LayoutInflater.from(this).inflate(R.layout.zg_my_order_popwindow, null);
        RecyclerView recyclerView = (RecyclerView) viewPop.findViewById(R.id.zg_my_order_popWindow_recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(zgOrderCenterAdapter);
        zgOrderCenterAdapter.setOnItemClickListener(this);
    }

    @OnClick({R.id.zgmyback, R.id.zg_my_order_title_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            //显示弹窗
            case R.id.zg_my_order_title_tv:
                showPopWindow(viewPop);
                break;
            //返回
            case R.id.zgmyback:
                finish();
                break;

        }
    }

    /**
     * 显示PopWindow
     *
     * @param viewPop
     */
    private void showPopWindow(View viewPop) {
        customPopWindow = new CustomPopWindow.PopupWindowBuilder(this)
                .setView(viewPop)
                .enableBackgroundDark(true)
                .setBgDarkAlpha(1f)
                .size(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
                .setOutsideTouchable(false)
                .setFocusable(false)
                .create()
                .showAsDropDown(zg_my_order_relative, 0, 0);
        zg_my_order_title_tv.setClickable(false);
        zgmyback.setClickable(false);
    }

    //订单筛选点击事件
    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        zg_my_order_title_tv.setText(list.get(position));
        zgOrderCenterAdapter.initSelect(position);
        zgOrderCenterAdapter.notifyDataSetChanged();
        zg_my_order_title_tv.setClickable(true);
        zgmyback.setClickable(true);
        customPopWindow.dissmiss();
        setSearchTitle(list.get(position));
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (position) {
            case 0:
                fragmentTransaction.replace(R.id.zg_container, orderZgFragment);
                break;
            default:
                if (orderNoZgFragment == null) {
                    orderNoZgFragment = new OrderNoZgFragment();
                    fragmentTransaction.replace(R.id.zg_container, orderNoZgFragment);
                } else {
                    if (orderZgFragment.isAdded()) {
                        fragmentTransaction.replace(R.id.zg_container, orderNoZgFragment);
                    }
                }
                break;
        }
        fragmentTransaction.commit();
    }
}
