package com.zsh.blackcard.ui.home;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;
import com.zsh.blackcard.adapter.BarDetailMoreListAdapter;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.BaseApplication;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.BarDetailsitemAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.custom.HomeTypeConstant;
import com.zsh.blackcard.custom.PublicDialog;
import com.zsh.blackcard.listener.OrderDiaListenter;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.BarDetailModel;
import com.zsh.blackcard.model.BarDetailsMoreListModel;
import com.zsh.blackcard.model.BardetailsItemModel;
import com.zsh.blackcard.model.HoteldetailsItemModel;
import com.zsh.blackcard.model.OrderDialogModel;
import com.zsh.blackcard.model.OrderResultModel;
import com.zsh.blackcard.ui.OrderPayActivity;
import com.zsh.blackcard.utils.ActivityUtils;
import com.zsh.blackcard.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class HomeBarDetailActivity extends BaseActivity {

    @BindView(R.id.hotel_name)
    TextView hotelName;
    @BindView(R.id.tv_describe)
    TextView tvDescribe;
    @BindView(R.id.tv_score)
    TextView tvScore;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.ll_wifi)
    LinearLayout llWifi;
    @BindView(R.id.ll_pay)
    LinearLayout llPay;
    @BindView(R.id.ll_swim)
    LinearLayout llSwim;
    @BindView(R.id.ll_fit)
    LinearLayout llFit;
    @BindView(R.id.ll_food)
    LinearLayout llFood;
    @BindView(R.id.ll_park)
    LinearLayout llPark;
    @BindView(R.id.tv_tel)
    TextView tvTel;
    @BindView(R.id.bt_score)
    Button btScore;
    @BindView(R.id.tv_comment)
    TextView tvComment;

    @BindView(R.id.im_back)
    ImageView imBack;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.top_banner)
    Banner topBanner;
    @BindView(R.id.tv_search_more)
    TextView tvSearchMore;
    @BindView(R.id.more_recyclerView)
    RecyclerView moreRecyclerView;
    private String id;
    private Double score;

    final List<HoteldetailsItemModel> dataList = new ArrayList<>();
    private BarDetailsitemAdapter adapter;
    private BarDetailMoreListAdapter moreAdapter;
    private BarDetailModel.PdBean barData;


    @Override
    protected void initUI() {
        setContentView(R.layout.activity_home_bar_detail);
        ButterKnife.bind(this);
        id = getIntent().getStringExtra("data");
        initData();
        initRV();
        initMoreRV();
    }

    private void initRV() {
        DataManager.getInstance(this).RequestHttp(NetApi.postBarDetailList(DataManager.getMd5Str("BARDETAIL"), id), new ResultListener<BardetailsItemModel>() {
            @Override
            public void responseSuccess(BardetailsItemModel obj) {
                List<BardetailsItemModel.PdBean> dataList = obj.getPd();
                setRVData(dataList);
            }

            @Override
            public void onCompleted() {

            }
        });

    }

    private void setRVData(final List<BardetailsItemModel.PdBean> dataList) {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);

        adapter = new BarDetailsitemAdapter(this, dataList);
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                orderDialog(dataList.get(position));

            }
        });
    }

    private void initMoreRV() {
        DataManager.getInstance(this).RequestHttp(NetApi.postBarDetailMoreList(DataManager.getMd5Str("SORTBARRAND"), BaseApplication.HONOURUSER_ID), new ResultListener<BarDetailsMoreListModel>() {
            @Override
            public void responseSuccess(BarDetailsMoreListModel obj) {
                List<BarDetailsMoreListModel.PdBean> dataList = obj.getPd();
                setMoreRVData(dataList);
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void setMoreRVData(final List<BarDetailsMoreListModel.PdBean> dataList) {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        moreRecyclerView.setLayoutManager(llm);
        if (null == moreAdapter) {
            moreAdapter = new BarDetailMoreListAdapter(this, dataList);
            moreRecyclerView.setAdapter(moreAdapter);
        } else {
            moreAdapter.notifyDataSetChanged();
        }
        moreRecyclerView.setNestedScrollingEnabled(false);
        moreAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ActivityUtils.startActivityForData(HomeBarDetailActivity.this, HomeBarDetailActivity.class, dataList.get(position).getSORTBAR_ID());
            }
        });
    }

    OrderDialogModel orderData = new OrderDialogModel();

    public void orderDialog(final BardetailsItemModel.PdBean item) {
        orderData.setDj_top_name(barData.getBARNAMES());
        orderData.setDj_score(String.valueOf(barData.getBAREVALUATE()));
        orderData.setDj_fit(barData.getSHOPSERVFITNESS());
        orderData.setDj_wifi(barData.getSHOPSERVWIFI());
        orderData.setDj_swim(barData.getSHOPSERVSWIN());
        orderData.setDj_pay(barData.getSHOPSERVPAY());
        orderData.setDj_park(barData.getSHOPSERVPARK());
        orderData.setDj_food(barData.getSHOPSERVFOOD());
//        orderData.setDj_item_img(item.getKTVDETIMGS());
//        orderData.setDj_check_in(dataIn);
//        orderData.setDj_check_out(dataOut);
//        orderData.setDj_check_count(tvTotle.getText().toString());
        orderData.setDj_item_date(item.getBARDETTITLE());
        //  orderData.setDj_item_des(item.getKTVDETTYPE());
        orderData.setDj_item_name(item.getBARDETTITLE());
        orderData.setDj_item_money(item.getBARDETPRICE() + "");
        orderData.setDj_item_id(item.getBARDETAIL_ID());
        PublicDialog.orderDialog(HomeBarDetailActivity.this, HomeTypeConstant.ORDER_TYPE_NUM, orderData, listenter);

    }

    OrderDiaListenter listenter = new OrderDiaListenter() {
        @Override
        public void OrderDiaListenter(OrderDialogModel orderData) {
            postOrder(orderData);
        }
    };

    private void postOrder(final OrderDialogModel orderData) {
        Map<String, String> map = new TreeMap<>();
        map.put("FKEY", DataManager.getMd5Str("ADDBARORDER"));
        map.put("HONOURUSER_ID", BaseApplication.HONOURUSER_ID);
        map.put("ORDERUNAME", orderData.getDj_order_name());
        map.put("ORDERPHONE", orderData.getDj_order_phone());
        map.put("ORDERREMARK", orderData.getDj_order_other());
        map.put("ORDERMONEY", orderData.getDj_item_money());
        map.put("ORDERROOMNUM", orderData.getDj_order_num());

        map.put("ORDERROOMBEGIN", orderData.getDj_check_in());//入住
        map.put("ORDERROOMEND", orderData.getDj_check_out());//离开
        map.put("BARDETAIL_ID", orderData.getDj_item_id());//id

        DataManager.getInstance(this).RequestHttp(NetApi.postBarOrder(map), new ResultListener<OrderResultModel>() {
            @Override
            public void responseSuccess(OrderResultModel obj) {
                if ("01".equals(obj.getResult())) {
                    orderData.setDj_return_id(obj.getORDERNUMBER());
                    ActivityUtils.startActivityForSerializable(HomeBarDetailActivity.this, OrderPayActivity.class, orderData);
                } else {
                    UIUtils.showToast("失败");
                }
            }

            @Override
            public void onCompleted() {

            }
        });

    }

    private void setData(BarDetailModel.PdBean hotelData) {
        score = hotelData.getBAREVALUATE();
        hotelName.setText(hotelData.getBARNAMES());
        tvScore.setText(String.valueOf(hotelData.getBAREVALUATE()));
        tvTel.setText(hotelData.getBARPHONE());
        tvAddress.setText(hotelData.getBARADDRESS());
        btScore.setText(String.valueOf(hotelData.getBAREVALUATE()));
        tvComment.setText(hotelData.getBAREVACOUNT() + "条评论");
        initBanner();
        showOrHint(hotelData.getSHOPSERVFOOD(), llFood);
        showOrHint(hotelData.getSHOPSERVFITNESS(), llFit);
        showOrHint(hotelData.getSHOPSERVPARK(), llPark);
        showOrHint(hotelData.getSHOPSERVPAY(), llPay);
        showOrHint(hotelData.getSHOPSERVSWIN(), llSwim);
        showOrHint(hotelData.getSHOPSERVWIFI(), llWifi);

    }

    //初始化banner轮播区
    private void initBanner() {
        topBanner.setImages(barData.getBARDETAILSIMGS());
        topBanner.setImageLoader(new MyImageLoader());
        topBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        topBanner.isAutoPlay(false);
        topBanner.setIndicatorGravity(BannerConfig.RIGHT);
        topBanner.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv_search_more)
    public void onClick() {
    }

    //banner加载图片类
    private class MyImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }

    private void showOrHint(int i, LinearLayout ll) {
        if (i == 1) {
            ll.setVisibility(View.VISIBLE);
        } else {
            ll.setVisibility(View.GONE);
        }
    }

    private void initData() {
        DataManager.getInstance(this).RequestHttp(NetApi.postBarDetail(DataManager.getMd5Str("BARSYN"), id), new ResultListener<BarDetailModel>() {
            @Override
            public void responseSuccess(BarDetailModel obj) {
                barData = obj.getPd();
                setData(barData);
            }

            @Override
            public void onCompleted() {

            }
        });
    }


    @OnClick({R.id.rl_comment, R.id.im_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_comment:
                ActivityUtils.startActivityForData(HomeBarDetailActivity.this, CommentActivity.class, id, String.valueOf(score), HomeTypeConstant.MORE_TYPE_BAR);
                break;
            case R.id.im_back:
                finish();
                break;
        }
    }
}
