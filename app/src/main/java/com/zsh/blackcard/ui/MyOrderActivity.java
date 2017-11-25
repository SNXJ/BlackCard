package com.zsh.blackcard.ui;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.MyOrderCenterAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
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

    private List<MyOrderModel.PdBean> pdBeanList = new ArrayList<>();

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
        if ("1".equals(data)) {
            postMyAppointOrder();
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

        if (tab.getText().toString().equals("全部")) {
            postMyAppointOrder();
        } else if (tab.getText().toString().equals("待付款")) {
            postMyAppointOrder("0040001");
        } else if (tab.getText().toString().equals("待收货")) {
            postMyAppointOrder("0040002");
        } else if (tab.getText().toString().equals("待评价")) {
            postMyAppointOrder("0040003");
        } else if (tab.getText().toString().equals("退款售后")) {
            postMyAppointOrder("0040004");
        }


    }

    /**
     * 查询全部订单方法
     */
    private void postMyAppointOrder() {
        //当为全部时，不同调用select，默认自动加载全部订单
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postMyAllOrder(DataManager.getMd5Str("ALLORDER"), "d6a3779de8204dfd9359403f54f7d27c"), new ResultListener<MyOrderModel>() {
            @Override
            public void responseSuccess(MyOrderModel obj) {
                //如果有数据则遍历，给不同的数据添加不同的布局。如果没有数据，则清空数据集合
                if (obj.getResult().equals("01")) {
                    if (pdBeanList != null) {
                        pdBeanList.clear();
                    }
                    pdBeanList.addAll(obj.getPd());
                    //遍历得到的所有订单结果，为订单赋值不同的itemType
                    for (int i = 0; i < obj.getPd().size(); i++) {
                        if (obj.getPd().get(i).getORDERSTATUS().equals("待付款")) {
                            pdBeanList.get(i).setItemType(2);
                        } else if (obj.getPd().get(i).getORDERSTATUS().equals("待收货")) {
                            pdBeanList.get(i).setItemType(3);
                        } else if (obj.getPd().get(i).getORDERSTATUS().equals("待评价")) {
                            pdBeanList.get(i).setItemType(4);
                        } else if (obj.getPd().get(i).getORDERSTATUS().equals("已完成")) {
                            pdBeanList.get(i).setItemType(5);
                        }
                    }
                } else {
                    pdBeanList.clear();
                }


                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                    order_center_recycler.scrollToPosition(0);
                } else {
                    adapter = new MyOrderCenterAdapter(pdBeanList);
                    order_center_recycler.setLayoutManager(new LinearLayoutManager(MyOrderActivity.this));
                    order_center_recycler.addItemDecoration(new SpacesItemDecoration(MyOrderActivity.this, SpacesItemDecoration.VERTICAL_LIST));
                    order_center_recycler.setAdapter(adapter);
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    /**
     * 指定查询订单方法
     *
     * @param state
     */
    private void postMyAppointOrder(String state) {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postMyAppointOrder(DataManager.getMd5Str("CONORDER"), "d6a3779de8204dfd9359403f54f7d27c", state), new ResultListener<MyOrderModel>() {
            @Override
            public void responseSuccess(MyOrderModel obj) {
                //如果有数据则遍历，给不同的数据添加不同的布局。如果没有数据，则清空数据集合
                if (obj.getResult().equals("01")) {
                    if (pdBeanList != null) {
                        pdBeanList.clear();
                    }
                    pdBeanList.addAll(obj.getPd());
                    //遍历得到的所有订单结果，为订单赋值不同的itemType
                    for (int i = 0; i < obj.getPd().size(); i++) {
                        if (obj.getPd().get(i).getORDERSTATUS().equals("0040001")) {
                            pdBeanList.get(i).setItemType(2);
                        } else if (obj.getPd().get(i).getORDERSTATUS().equals("0040002")) {
                            pdBeanList.get(i).setItemType(3);
                        } else if (obj.getPd().get(i).getORDERSTATUS().equals("0040003")) {
                            pdBeanList.get(i).setItemType(4);
                        } else if (obj.getPd().get(i).getORDERSTATUS().equals("0040004")) {
                            pdBeanList.get(i).setItemType(5);
                        }
                    }
                } else {
                    pdBeanList.clear();
                }


                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                    order_center_recycler.scrollToPosition(0);
                } else {
                    adapter = new MyOrderCenterAdapter(pdBeanList);
                    order_center_recycler.setLayoutManager(new LinearLayoutManager(MyOrderActivity.this));
                    order_center_recycler.addItemDecoration(new SpacesItemDecoration(MyOrderActivity.this, SpacesItemDecoration.VERTICAL_LIST));
                    order_center_recycler.setAdapter(adapter);
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
