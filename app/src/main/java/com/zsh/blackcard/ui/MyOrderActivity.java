package com.zsh.blackcard.ui;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.MyOrderCenterAdapter;
import com.zsh.blackcard.model.MyOrderModel;
import com.zsh.blackcard.view.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kkkkk on 2017/11/18.
 */

public class MyOrderActivity extends BaseActivity implements TabLayout.OnTabSelectedListener {

    @BindView(R.id.order_center_recycler)
    RecyclerView order_center_recycler;

    @BindView(R.id.my_order_tabLayout)
    TabLayout my_order_tabLayout;

    private MyOrderCenterAdapter adapter;

    private List<MyOrderModel> list = new ArrayList<>();

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_my_order);
        ButterKnife.bind(this);
        initOnClick();
        initDate();
    }

    @OnClick(R.id.zgmyback)
    public void onClick() {
        finish();
    }

    private void initDate() {
        Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        if (null == data) {
        } else if ("2".equals(data)) {
            my_order_tabLayout.getTabAt(1).select();
        } else if ("3".equals(data)) {
            my_order_tabLayout.getTabAt(2).select();
        } else if ("4".equals(data)) {
            my_order_tabLayout.getTabAt(3).select();
        } else if ("5".equals(data)) {
            my_order_tabLayout.getTabAt(4).select();
        }

    }

    private void initOnClick() {
        my_order_tabLayout.addOnTabSelectedListener(this);
    }

    //点击tab
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        if (list != null) {
            list.clear();
        }

        if (tab.getText().toString().equals("全部")) {
            //to do
        } else if (tab.getText().toString().equals("待付款")) {
            //to do
            for (int i = 0; i < 10; i++) {
                MyOrderModel myOrderModel = new MyOrderModel(2);
                list.add(myOrderModel);
            }
        } else if (tab.getText().toString().equals("待收货")) {
            for (int i = 0; i < 10; i++) {
                MyOrderModel myOrderModel = new MyOrderModel(3);
                list.add(myOrderModel);
            }
        } else if (tab.getText().toString().equals("待评价")) {
            for (int i = 0; i < 10; i++) {
                MyOrderModel myOrderModel = new MyOrderModel(4);
                list.add(myOrderModel);
            }
        } else if (tab.getText().toString().equals("退款售后")) {
            for (int i = 0; i < 10; i++) {
                MyOrderModel myOrderModel = new MyOrderModel(5);
                list.add(myOrderModel);
            }
        }

        if (adapter == null) {
            adapter = new MyOrderCenterAdapter(list);
            order_center_recycler.setLayoutManager(new LinearLayoutManager(this));
            order_center_recycler.addItemDecoration(new SpacesItemDecoration(this, SpacesItemDecoration.VERTICAL_LIST));
            order_center_recycler.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
            order_center_recycler.scrollToPosition(0);
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
