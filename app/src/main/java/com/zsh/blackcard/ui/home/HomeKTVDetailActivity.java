package com.zsh.blackcard.ui.home;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.SimpleClickListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.BaseApplication;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.KTVDetailsiTAbAdapter;
import com.zsh.blackcard.adapter.KTVDetailsitemAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.custom.HomeTypeConstant;
import com.zsh.blackcard.custom.PublicDialog;
import com.zsh.blackcard.listener.OrderDiaListenter;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.FetureDateModel;
import com.zsh.blackcard.model.HomeKTVDetailItemModel;
import com.zsh.blackcard.model.HomeKTVDetailModel;
import com.zsh.blackcard.model.OrderResultModel;
import com.zsh.blackcard.model.OrderDialogModel;
import com.zsh.blackcard.ui.OrderPayActivity;
import com.zsh.blackcard.untils.ActivityUtils;
import com.zsh.blackcard.untils.MyCalendar;
import com.zsh.blackcard.untils.UIUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Name: HomeKTVDetailActivity
 * Author: SNXJ
 * Date: 2017-11-15
 * Description:描述：
 */
public class HomeKTVDetailActivity extends BaseActivity {
    @BindView(R.id.top_banner)
    Banner topBanner;
    @BindView(R.id.im_back)
    ImageView imBack;
    @BindView(R.id.hotel_name)
    TextView hotelName;
    @BindView(R.id.tv_describe)
    TextView tvDescribe;
    @BindView(R.id.tv_score)
    TextView tvScore;
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
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_tel)
    TextView tvTel;
    @BindView(R.id.bt_score)
    Button btScore;
    @BindView(R.id.tv_comment)
    TextView tvComment;
    @BindView(R.id.im_food_next)
    ImageView imFoodNext;
    @BindView(R.id.rl_comment)
    RelativeLayout rlComment;
    @BindView(R.id.tab_recyclerView)
    RecyclerView tabRecyclerView;
    //    @BindView(R.id.btn_recyclerView)
//    RecyclerView btnRecyclerView;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private String id;
    private String score;

    final List<HomeKTVDetailItemModel.PdBean> dataList = new ArrayList<>();
    List<FetureDateModel> tabList = new ArrayList<>();
    private KTVDetailsitemAdapter adapter;
    private KTVDetailsiTAbAdapter tabAdapter;
    private HomeKTVDetailModel.PdBean ktvData;

    @Override
    protected void initUI() {
        setContentView(R.layout.home_ktv_activity);
        ButterKnife.bind(this);
        id = getIntent().getStringExtra("data");
        initData();
        initTabRV();
        initRV();
    }

    private void initData() {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postKTVDetail(DataManager.getMd5Str("KTVSYN"), id), new ResultListener<HomeKTVDetailModel>() {
            @Override
            public void responseSuccess(HomeKTVDetailModel obj) {
                ktvData = obj.getPd();
                setData(ktvData);
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void initTabRV() {
        tabList = MyCalendar.getFetureDate_week(7);
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        tabRecyclerView.setLayoutManager(llm);
        tabAdapter = new KTVDetailsiTAbAdapter(this, tabList);
        tabRecyclerView.setAdapter(tabAdapter);
        tabRecyclerView.setNestedScrollingEnabled(false);
        tabRecyclerView.addOnItemTouchListener(tabListener);

    }

    SimpleClickListener tabListener = new SimpleClickListener() {
        @Override
        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            tabAdapter.setSelectPos(position);
            tabAdapter.notifyDataSetChanged();
        }

        @Override
        public void onItemLongClick(BaseQuickAdapter adapter, View view, int position) {

        }

        @Override
        public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

        }

        @Override
        public void onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {

        }
    };

    private void initRV() {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postHTKDetailList(DataManager.getMd5Str("KTVDETAIL"), id), new ResultListener<HomeKTVDetailItemModel>() {
            @Override
            public void responseSuccess(HomeKTVDetailItemModel obj) {

                List<HomeKTVDetailItemModel.PdBean> dataList = obj.getPd();
                setRVData(dataList);
            }

            @Override
            public void onCompleted() {

            }
        });

    }

    private void setData(HomeKTVDetailModel.PdBean ktvData) {
        score = String.valueOf(ktvData.getKTVEVALUATE());
        hotelName.setText(ktvData.getKTVNAMES());
        tvScore.setText(String.valueOf(ktvData.getKTVEVALUATE()));
        tvTel.setText(ktvData.getKTVPHONE());
        tvAddress.setText(ktvData.getKTVADDRESS());
        btScore.setText(String.valueOf(ktvData.getKTVEVALUATE()));
        tvComment.setText(ktvData.getKTVEVACOUNT() + "条评论");
        initBanner();
        showOrHint(ktvData.getSHOPSERVFOOD(), llFood);
        showOrHint(ktvData.getSHOPSERVFITNESS(), llFit);
        showOrHint(ktvData.getSHOPSERVPARK(), llPark);
        showOrHint(ktvData.getSHOPSERVPAY(), llPay);
        showOrHint(ktvData.getSHOPSERVSWIN(), llSwim);
        showOrHint(ktvData.getSHOPSERVWIFI(), llWifi);

    }

    private void setRVData(final List<HomeKTVDetailItemModel.PdBean> dataList) {

        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);

        adapter = new KTVDetailsitemAdapter(this, dataList);
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                orderDialog(dataList.get(position));

            }
        });
    }

    OrderDialogModel orderData = new OrderDialogModel();

    public void orderDialog(final HomeKTVDetailItemModel.PdBean item) {
        orderData.setDj_top_name(ktvData.getKTVNAMES());
        orderData.setDj_score(String.valueOf(ktvData.getKTVEVALUATE()));
        orderData.setDj_fit(ktvData.getSHOPSERVFITNESS());
        orderData.setDj_wifi(ktvData.getSHOPSERVWIFI());
        orderData.setDj_swim(ktvData.getSHOPSERVSWIN());
        orderData.setDj_pay(ktvData.getSHOPSERVPAY());
        orderData.setDj_park(ktvData.getSHOPSERVPARK());
        orderData.setDj_food(ktvData.getSHOPSERVFOOD());
//        orderData.setDj_item_img(item.getKTVDETIMGS());
//        orderData.setDj_check_in(dataIn);
//        orderData.setDj_check_out(dataOut);
//        orderData.setDj_check_count(tvTotle.getText().toString());
        orderData.setDj_item_date(item.getKTVDETTYPE());
        //  orderData.setDj_item_des(item.getKTVDETTYPE());
        orderData.setDj_item_name(item.getKTVDETTITLE());
        orderData.setDj_item_money(item.getKTVDETPRICE() + "");
        orderData.setDj_item_id(item.getKTVDETAIL_ID());
        PublicDialog.orderDialog(HomeKTVDetailActivity.this, HomeTypeConstant.ORDER_TYPE_ROOM, orderData, listenter);

    }

    OrderDiaListenter listenter = new OrderDiaListenter() {
        @Override
        public void OrderDiaListenter(OrderDialogModel orderData) {
            postOrder(orderData);
        }
    };

    private void postOrder(final OrderDialogModel orderData) {
        Map<String, String> map = new TreeMap<>();
        map.put("FKEY", DataManager.getMd5Str("SHIPKTVORDER"));
        map.put("HONOURUSER_ID", BaseApplication.HONOURUSER_ID);
        map.put("ORDERUNAME", orderData.getDj_order_name());
        map.put("ORDERPHONE", orderData.getDj_order_phone());
        map.put("ORDERREMARK", orderData.getDj_order_other());
        map.put("ORDERMONEY", orderData.getDj_item_money());
        map.put("ORDERROOMNUM", orderData.getDj_order_num());

        map.put("ORDERROOMBEGIN", orderData.getDj_check_in());//入住
        map.put("ORDERROOMEND", orderData.getDj_check_out());//离开
        map.put("KTVDETAIL_ID", orderData.getDj_item_id());//类型

        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postKTVOrder(map), new ResultListener<OrderResultModel>() {
            @Override
            public void responseSuccess(OrderResultModel obj) {
                if ("01".equals(obj.getResult())) {
                    orderData.setDj_return_id(obj.getORDERNUMBER());
                    ActivityUtils.startActivityForSerializable(HomeKTVDetailActivity.this, OrderPayActivity.class, orderData);
                } else {
                    UIUtils.showToast("失败");
                }
            }

            @Override
            public void onCompleted() {

            }
        });

    }

    //初始化banner轮播区
    private void initBanner() {
        topBanner.setImages(ktvData.getKTVDETAILSIMGS());
        topBanner.setImageLoader(new MyImageLoader());
        topBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        topBanner.isAutoPlay(false);
        topBanner.setIndicatorGravity(BannerConfig.RIGHT);
        topBanner.start();
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


    @OnClick({R.id.im_back, R.id.rl_comment})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.im_back:
                finish();
                break;
            case R.id.rl_comment:
                ActivityUtils.startActivityForData(HomeKTVDetailActivity.this, CommentActivity.class, id, String.valueOf(score), HomeTypeConstant.MORE_TYPE_KTV);

                break;
        }
    }
}
