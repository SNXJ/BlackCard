package com.zsh.blackcard.ui;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.MyOrderCenterOtherBarAdapter;
import com.zsh.blackcard.adapter.MyOrderCenterOtherFoodAdapter;
import com.zsh.blackcard.adapter.MyOrderCenterOtherHotelAdapter;
import com.zsh.blackcard.adapter.MyOrderCenterOtherKTVAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.OrderCenterBarRecyclerModel;
import com.zsh.blackcard.model.OrderCenterFoodRecyclerModel;
import com.zsh.blackcard.model.OrderCenterHotelRecyclerModel;
import com.zsh.blackcard.model.OrderCenterKTVRecyclerModel;
import com.zsh.blackcard.model.ResultModel;
import com.zsh.blackcard.view.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kkkkk on 2017/11/18.
 * 订单中心 除尊购以外的所有公用界面
 */

public class MyOrderOtherActivity extends BaseActivity implements TabLayout.OnTabSelectedListener {

    @BindView(R.id.order_center_other_recycler)
    RecyclerView order_center_recycler;

    @BindView(R.id.my_order_other_tabLayout)
    TabLayout my_order_tabLayout;

    //酒吧订单适配器
    private MyOrderCenterOtherBarAdapter myOrderCenterOtherBarAdapter;
    //KTV订单适配器
    private MyOrderCenterOtherKTVAdapter myOrderCenterOtherKTVAdapter;
    //酒店订单适配器
    private MyOrderCenterOtherHotelAdapter myOrderCenterOtherHotelAdapter;
    //美食订单适配器
    private MyOrderCenterOtherFoodAdapter myOrderCenterOtherFoodAdapter;

    //酒吧订单集合
    private List<OrderCenterBarRecyclerModel.PdBean> pdBarList;
    //KTV订单集合
    private List<OrderCenterKTVRecyclerModel.PdBean> pdKTVList;
    //酒店订单集合
    private List<OrderCenterHotelRecyclerModel.PdBean> pdHotelList;
    //美食订单集合
    private List<OrderCenterFoodRecyclerModel.PdBean> pdFoodList;

    private String title;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_my_order_other);
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
        title = intent.getStringExtra("title");
        switch (title) {
            case "酒吧":
                pdBarList = new ArrayList<>();
                if ("".equals(data)) {
                    postBarAllOrder();
                } else if ("0040001".equals(data)) {
                    //选择待付款
                    my_order_tabLayout.getTabAt(1).select();
                } else if ("0040002".equals(data)) {
                    //待使用
                    my_order_tabLayout.getTabAt(2).select();
                } else if ("0040003".equals(data)) {
                    //待评价
                    my_order_tabLayout.getTabAt(3).select();
                }
                break;
            case "KTV":
                pdKTVList = new ArrayList<>();
                if ("".equals(data)) {
                    postKTVAllOrder();
                } else if ("0040001".equals(data)) {
                    //选择待付款
                    my_order_tabLayout.getTabAt(1).select();
                } else if ("0040002".equals(data)) {
                    //待使用
                    my_order_tabLayout.getTabAt(2).select();
                } else if ("0040003".equals(data)) {
                    //待评价
                    my_order_tabLayout.getTabAt(3).select();
                }
                break;
            case "酒店":
                pdHotelList = new ArrayList<>();
                if ("".equals(data)) {
                    postHotelAllOrder();
                } else if ("0040001".equals(data)) {
                    //选择待付款
                    my_order_tabLayout.getTabAt(1).select();
                } else if ("0040002".equals(data)) {
                    //待使用
                    my_order_tabLayout.getTabAt(2).select();
                } else if ("0040003".equals(data)) {
                    //待评价
                    my_order_tabLayout.getTabAt(3).select();
                }
                break;
            case "美食":
                pdFoodList = new ArrayList<>();
                if ("".equals(data)) {
                    postFoodAllOrder();
                } else if ("0040001".equals(data)) {
                    //选择待付款
                    my_order_tabLayout.getTabAt(1).select();
                } else if ("0040002".equals(data)) {
                    //待使用
                    my_order_tabLayout.getTabAt(2).select();
                } else if ("0040003".equals(data)) {
                    //待评价
                    my_order_tabLayout.getTabAt(3).select();
                }
                break;
        }
    }

    //美食全部订单查询
    private void postFoodAllOrder() {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postOrderCenterFoodRecycler(DataManager.getMd5Str("ALLFOODORDER"), "d6a3779de8204dfd9359403f54f7d27c", ""), new ResultListener<OrderCenterFoodRecyclerModel>() {
            @Override
            public void responseSuccess(OrderCenterFoodRecyclerModel obj) {
                //如果有数据则遍历，给不同的数据添加不同的布局。如果没有数据，则清空数据集合
                if (obj.getResult().equals("01")) {
                    if (pdFoodList != null) {
                        pdFoodList.clear();
                    }
                    pdFoodList.addAll(obj.getPd());
                    //遍历得到的所有订单结果，为订单赋值不同的itemType
                    for (int i = 0; i < obj.getPd().size(); i++) {
                        if (obj.getPd().get(i).getORDERSTATUS().equals("0040001")) {
                            pdFoodList.get(i).setItemType(2);
                        } else if (obj.getPd().get(i).getORDERSTATUS().equals("0040002")) {
                            pdFoodList.get(i).setItemType(3);
                        } else if (obj.getPd().get(i).getORDERSTATUS().equals("0040003")) {
                            pdFoodList.get(i).setItemType(4);
                        }
                    }
                } else {
                    pdFoodList.clear();
                }
                loadFoodRecycler();
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    //美食指定订单查询
    private void postFoodAllOrder(String state) {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postOrderCenterFoodRecycler(DataManager.getMd5Str("ALLFOODORDER"), "d6a3779de8204dfd9359403f54f7d27c", state), new ResultListener<OrderCenterFoodRecyclerModel>() {
            @Override
            public void responseSuccess(OrderCenterFoodRecyclerModel obj) {
                //如果有数据则遍历，给不同的数据添加不同的布局。如果没有数据，则清空数据集合
                if (obj.getResult().equals("01")) {
                    if (pdFoodList != null) {
                        pdFoodList.clear();
                    }
                    pdFoodList.addAll(obj.getPd());
                    //遍历得到的所有订单结果，为订单赋值不同的itemType
                    for (int i = 0; i < obj.getPd().size(); i++) {
                        if (obj.getPd().get(i).getORDERSTATUS().equals("0040001")) {
                            pdFoodList.get(i).setItemType(2);
                        } else if (obj.getPd().get(i).getORDERSTATUS().equals("0040002")) {
                            pdFoodList.get(i).setItemType(3);
                        } else if (obj.getPd().get(i).getORDERSTATUS().equals("0040003")) {
                            pdFoodList.get(i).setItemType(4);
                        }
                    }
                } else {
                    pdFoodList.clear();
                }
                loadFoodRecycler();
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    //加载美食列表
    private void loadFoodRecycler() {
        if (myOrderCenterOtherFoodAdapter != null) {
            myOrderCenterOtherFoodAdapter.notifyDataSetChanged();
            order_center_recycler.scrollToPosition(0);
        } else {
            myOrderCenterOtherFoodAdapter = new MyOrderCenterOtherFoodAdapter(pdFoodList);
            order_center_recycler.setLayoutManager(new LinearLayoutManager(MyOrderOtherActivity.this));
            order_center_recycler.addItemDecoration(new SpacesItemDecoration(MyOrderOtherActivity.this, SpacesItemDecoration.VERTICAL_LIST));
            order_center_recycler.setAdapter(myOrderCenterOtherFoodAdapter);
        }
    }

    //查询酒店全部订单
    private void postHotelAllOrder() {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postOrderCenterHotelRecycler(DataManager.getMd5Str("ALLHOTELORDER"), "d6a3779de8204dfd9359403f54f7d27c", ""), new ResultListener<OrderCenterHotelRecyclerModel>() {
            @Override
            public void responseSuccess(OrderCenterHotelRecyclerModel obj) {
                //如果有数据则遍历，给不同的数据添加不同的布局。如果没有数据，则清空数据集合
                if (obj.getResult().equals("01")) {
                    if (pdHotelList != null) {
                        pdHotelList.clear();
                    }
                    pdHotelList.addAll(obj.getPd());
                    //遍历得到的所有订单结果，为订单赋值不同的itemType
                    for (int i = 0; i < obj.getPd().size(); i++) {
                        if (obj.getPd().get(i).getORDERSTATUS().equals("0040001")) {
                            pdHotelList.get(i).setItemType(2);
                        } else if (obj.getPd().get(i).getORDERSTATUS().equals("0040002")) {
                            pdHotelList.get(i).setItemType(3);
                        } else if (obj.getPd().get(i).getORDERSTATUS().equals("0040003")) {
                            pdHotelList.get(i).setItemType(4);
                        }
                    }
                } else {
                    pdHotelList.clear();
                }
                loadHotelRecycler();
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    //查询酒店指定条件订单
    private void postHotelAllOrder(String state) {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postOrderCenterHotelRecycler(DataManager.getMd5Str("ALLHOTELORDER"), "d6a3779de8204dfd9359403f54f7d27c", state), new ResultListener<OrderCenterHotelRecyclerModel>() {
            @Override
            public void responseSuccess(OrderCenterHotelRecyclerModel obj) {
                //如果有数据则遍历，给不同的数据添加不同的布局。如果没有数据，则清空数据集合
                if (obj.getResult().equals("01")) {
                    if (pdHotelList != null) {
                        pdHotelList.clear();
                    }
                    pdHotelList.addAll(obj.getPd());
                    //遍历得到的所有订单结果，为订单赋值不同的itemType
                    for (int i = 0; i < obj.getPd().size(); i++) {
                        if (obj.getPd().get(i).getORDERSTATUS().equals("0040001")) {
                            pdHotelList.get(i).setItemType(2);
                        } else if (obj.getPd().get(i).getORDERSTATUS().equals("0040002")) {
                            pdHotelList.get(i).setItemType(3);
                        } else if (obj.getPd().get(i).getORDERSTATUS().equals("0040003")) {
                            pdHotelList.get(i).setItemType(4);
                        }
                    }
                } else {
                    pdHotelList.clear();
                }
                loadHotelRecycler();
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void loadHotelRecycler() {
        if (myOrderCenterOtherHotelAdapter != null) {
            myOrderCenterOtherHotelAdapter.notifyDataSetChanged();
            order_center_recycler.scrollToPosition(0);
        } else {
            myOrderCenterOtherHotelAdapter = new MyOrderCenterOtherHotelAdapter(pdHotelList);
            order_center_recycler.setLayoutManager(new LinearLayoutManager(MyOrderOtherActivity.this));
            order_center_recycler.addItemDecoration(new SpacesItemDecoration(MyOrderOtherActivity.this, SpacesItemDecoration.VERTICAL_LIST));
            order_center_recycler.setAdapter(myOrderCenterOtherHotelAdapter);
        }
    }

    //加载KTV的接口
    private void postKTVAllOrder() {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postOrderCenterKTVRecycler(DataManager.getMd5Str("ALLKTVORDER"), "d6a3779de8204dfd9359403f54f7d27c", ""), new ResultListener<OrderCenterKTVRecyclerModel>() {
            @Override
            public void responseSuccess(OrderCenterKTVRecyclerModel obj) {
                //如果有数据则遍历，给不同的数据添加不同的布局。如果没有数据，则清空数据集合
                if (obj.getResult().equals("01")) {
                    if (pdKTVList != null) {
                        pdKTVList.clear();
                    }
                    pdKTVList.addAll(obj.getPd());
                    //遍历得到的所有订单结果，为订单赋值不同的itemType
                    for (int i = 0; i < obj.getPd().size(); i++) {
                        if (obj.getPd().get(i).getORDERSTATUS().equals("0040001")) {
                            pdKTVList.get(i).setItemType(2);
                        } else if (obj.getPd().get(i).getORDERSTATUS().equals("0040002")) {
                            pdKTVList.get(i).setItemType(3);
                        } else if (obj.getPd().get(i).getORDERSTATUS().equals("0040003")) {
                            pdKTVList.get(i).setItemType(4);
                        }
                    }
                } else {
                    pdKTVList.clear();
                }
                loadKTVRecycler();
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    //KTV指定条件查询
    private void postKTVAllOrder(String state) {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postOrderCenterKTVRecycler(DataManager.getMd5Str("ALLKTVORDER"), "d6a3779de8204dfd9359403f54f7d27c", state), new ResultListener<OrderCenterKTVRecyclerModel>() {
            @Override
            public void responseSuccess(OrderCenterKTVRecyclerModel obj) {
                //如果有数据则遍历，给不同的数据添加不同的布局。如果没有数据，则清空数据集合
                if (obj.getResult().equals("01")) {
                    if (pdKTVList != null) {
                        pdKTVList.clear();
                    }
                    pdKTVList.addAll(obj.getPd());
                    //遍历得到的所有订单结果，为订单赋值不同的itemType
                    for (int i = 0; i < obj.getPd().size(); i++) {
                        if (obj.getPd().get(i).getORDERSTATUS().equals("0040001")) {
                            pdKTVList.get(i).setItemType(2);
                        } else if (obj.getPd().get(i).getORDERSTATUS().equals("0040002")) {
                            pdKTVList.get(i).setItemType(3);
                        } else if (obj.getPd().get(i).getORDERSTATUS().equals("0040003")) {
                            pdKTVList.get(i).setItemType(4);
                        }
                    }
                } else {
                    pdKTVList.clear();
                }
                loadKTVRecycler();
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    //加载KTV订单列表
    private void loadKTVRecycler() {
        if (myOrderCenterOtherKTVAdapter != null) {
            myOrderCenterOtherKTVAdapter.notifyDataSetChanged();
            order_center_recycler.scrollToPosition(0);
        } else {
            myOrderCenterOtherKTVAdapter = new MyOrderCenterOtherKTVAdapter(pdKTVList);
            order_center_recycler.setLayoutManager(new LinearLayoutManager(MyOrderOtherActivity.this));
            order_center_recycler.addItemDecoration(new SpacesItemDecoration(MyOrderOtherActivity.this, SpacesItemDecoration.VERTICAL_LIST));
            order_center_recycler.setAdapter(myOrderCenterOtherKTVAdapter);
        }
    }

    private void initOnClick() {
        my_order_tabLayout.addOnTabSelectedListener(this);
    }

    //点击tab
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        switch (title) {
            case "酒吧":
                if (tab.getText().toString().equals("全部")) {
                    postBarAllOrder();
                } else if (tab.getText().toString().equals("待付款")) {
                    postBarAllOrder("0040001");
                } else if (tab.getText().toString().equals("待使用")) {
                    postBarAllOrder("0040002");
                } else if (tab.getText().toString().equals("待评价")) {
                    postBarAllOrder("0040003");
                }
                break;
            case "KTV":
                if (tab.getText().toString().equals("全部")) {
                    postKTVAllOrder();
                } else if (tab.getText().toString().equals("待付款")) {
                    postKTVAllOrder("0040001");
                } else if (tab.getText().toString().equals("待使用")) {
                    postKTVAllOrder("0040002");
                } else if (tab.getText().toString().equals("待评价")) {
                    postKTVAllOrder("0040003");
                }
                break;
            case "酒店":
                if (tab.getText().toString().equals("全部")) {
                    postHotelAllOrder();
                } else if (tab.getText().toString().equals("待付款")) {
                    postHotelAllOrder("0040001");
                } else if (tab.getText().toString().equals("待使用")) {
                    postHotelAllOrder("0040002");
                } else if (tab.getText().toString().equals("待评价")) {
                    postHotelAllOrder("0040003");
                }
                break;
            case "美食":
                if (tab.getText().toString().equals("全部")) {
                    postFoodAllOrder();
                } else if (tab.getText().toString().equals("待付款")) {
                    postFoodAllOrder("0040001");
                } else if (tab.getText().toString().equals("待使用")) {
                    postFoodAllOrder("0040002");
                } else if (tab.getText().toString().equals("待评价")) {
                    postFoodAllOrder("0040003");
                }
                break;
        }

    }

    /**
     * 查询酒吧全部订单方法
     */
    private void postBarAllOrder() {
        //当为全部时，不同调用select，默认自动加载全部订单
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postOrderCenterBarRecycler(DataManager.getMd5Str("ALLBARORDER"), "d6a3779de8204dfd9359403f54f7d27c", ""), new ResultListener<OrderCenterBarRecyclerModel>() {
            @Override
            public void responseSuccess(OrderCenterBarRecyclerModel obj) {
                //如果有数据则遍历，给不同的数据添加不同的布局。如果没有数据，则清空数据集合
                if (obj.getResult().equals("01")) {
                    if (pdBarList != null) {
                        pdBarList.clear();
                    }
                    pdBarList.addAll(obj.getPd());
                    //遍历得到的所有订单结果，为订单赋值不同的itemType
                    for (int i = 0; i < obj.getPd().size(); i++) {
                        if (obj.getPd().get(i).getORDERSTATUS().equals("0040001")) {
                            pdBarList.get(i).setItemType(2);
                        } else if (obj.getPd().get(i).getORDERSTATUS().equals("0040002")) {
                            pdBarList.get(i).setItemType(3);
                        } else if (obj.getPd().get(i).getORDERSTATUS().equals("0040003")) {
                            pdBarList.get(i).setItemType(4);
                        }
                    }
                } else {
                    pdBarList.clear();
                }


                loadBarRecycler();
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    /**
     * 加载酒吧订单列表或刷新列表
     */
    private void loadBarRecycler() {
        if (myOrderCenterOtherBarAdapter != null) {
            myOrderCenterOtherBarAdapter.notifyDataSetChanged();
            order_center_recycler.scrollToPosition(0);
        } else {
            myOrderCenterOtherBarAdapter = new MyOrderCenterOtherBarAdapter(pdBarList);
            order_center_recycler.setLayoutManager(new LinearLayoutManager(MyOrderOtherActivity.this));
            order_center_recycler.addItemDecoration(new SpacesItemDecoration(MyOrderOtherActivity.this, SpacesItemDecoration.VERTICAL_LIST));
            order_center_recycler.setAdapter(myOrderCenterOtherBarAdapter);
        }
    }

    /**
     * 指定查询订单方法
     *
     * @param state
     */
    private void postBarAllOrder(String state) {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postOrderCenterBarRecycler(DataManager.getMd5Str("ALLBARORDER"), "d6a3779de8204dfd9359403f54f7d27c", state), new ResultListener<OrderCenterBarRecyclerModel>() {
            @Override
            public void responseSuccess(OrderCenterBarRecyclerModel obj) {
                //如果有数据则遍历，给不同的数据添加不同的布局。如果没有数据，则清空数据集合
                if (obj.getResult().equals("01")) {
                    if (pdBarList != null) {
                        pdBarList.clear();
                    }
                    pdBarList.addAll(obj.getPd());
                    //遍历得到的所有订单结果，为订单赋值不同的itemType
                    for (int i = 0; i < obj.getPd().size(); i++) {
                        if (obj.getPd().get(i).getORDERSTATUS().equals("0040001")) {
                            pdBarList.get(i).setItemType(2);
                        } else if (obj.getPd().get(i).getORDERSTATUS().equals("0040002")) {
                            pdBarList.get(i).setItemType(3);
                        } else if (obj.getPd().get(i).getORDERSTATUS().equals("0040003")) {
                            pdBarList.get(i).setItemType(4);
                        }
                    }
                } else {
                    pdBarList.clear();
                }
                loadBarRecycler();
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

    private void initOk(final int selectedTabPosition, int position, String order_id) {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postMyOrderOk(DataManager.getMd5Str("SHIPORDERUPD"), order_id, "d6a3779de8204dfd9359403f54f7d27c", "0040003"), new ResultListener<ResultModel>() {
            @Override
            public void responseSuccess(ResultModel obj) {
                if (selectedTabPosition == 0) {
                    postBarAllOrder();
                } else {
                    postBarAllOrder("0040002");
                }
//                UIUtils.showToast("收货成功");
            }

            @Override
            public void onCompleted() {

            }
        });
    }
}
