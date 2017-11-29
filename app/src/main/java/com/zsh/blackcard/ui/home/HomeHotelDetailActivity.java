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
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.BaseApplication;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.HotelDetailsitemAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.custom.HomeTypeConstant;
import com.zsh.blackcard.custom.PublicDialog;
import com.zsh.blackcard.listener.DateListener;
import com.zsh.blackcard.listener.OrderDiaListenter;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.HotelDetailModel;
import com.zsh.blackcard.model.OrderResultModel;
import com.zsh.blackcard.model.HoteldetailsItemModel;
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


public class HomeHotelDetailActivity extends BaseActivity {

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
    @BindView(R.id.im_food_next)
    ImageView imFoodNext;
    @BindView(R.id.im_back)
    ImageView imBack;
    @BindView(R.id.rl_comment)
    RelativeLayout rlComment;
    @BindView(R.id.tv_check_in)
    TextView tvCheckIn;
    @BindView(R.id.tv_check_out)
    TextView tvCheckOut;
    @BindView(R.id.tv_totle)
    TextView tvTotle;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.top_banner)
    Banner topBanner;
    private String id;
    private Double score;

    final List<HoteldetailsItemModel> dataList = new ArrayList<>();
    private HotelDetailsitemAdapter adapter;
    private HotelDetailModel.PdBean hotelData;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_home_hotel_detail);
        ButterKnife.bind(this);
        id = getIntent().getStringExtra("data");
        initData();
        initRV();
    }

    private void initRV() {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postHotelDetailList(DataManager.getMd5Str("HOTELDETAIL"), id), new ResultListener<HoteldetailsItemModel>() {
            @Override
            public void responseSuccess(HoteldetailsItemModel obj) {

                List<HoteldetailsItemModel.PdBean> dataList = obj.getPd();
                setRVData(dataList);
            }

            @Override
            public void onCompleted() {

            }
        });

    }

    private void setRVData(final List<HoteldetailsItemModel.PdBean> dataList) {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);

        adapter = new HotelDetailsitemAdapter(this, dataList);
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

    public void orderDialog(final HoteldetailsItemModel.PdBean item) {
        orderData.setDj_top_name(hotelData.getHOTELNAMES());
        orderData.setDj_score(String.valueOf(hotelData.getHOTELEVALUATE()));
        orderData.setDj_fit(hotelData.getSHOPSERVFITNESS());
        orderData.setDj_wifi(hotelData.getSHOPSERVWIFI());
        orderData.setDj_swim(hotelData.getSHOPSERVSWIN());
        orderData.setDj_pay(hotelData.getSHOPSERVPAY());
        orderData.setDj_park(hotelData.getSHOPSERVPARK());
        orderData.setDj_food(hotelData.getSHOPSERVFOOD());
        orderData.setDj_item_img(item.getHOTELDETIMGS());
        orderData.setDj_check_in(dataIn);
        orderData.setDj_check_out(dataOut);
        orderData.setDj_check_count(tvTotle.getText().toString());
        orderData.setDj_item_date(dataIn + "入住," + dataOut + "离开，" + tvTotle.getText());
        orderData.setDj_item_des(item.getHOTELDETBEDTYPE());
        orderData.setDj_item_name(item.getHOTELDETNAME());
        orderData.setDj_item_money(item.getHOTELDETPRICE() + "");
        PublicDialog.orderDialog(HomeHotelDetailActivity.this, orderData, listenter);

    }

    OrderDiaListenter listenter = new OrderDiaListenter() {
        @Override
        public void OrderDiaListenter(OrderDialogModel orderData) {
            postOrder(orderData);
        }
    };

    private void postOrder(final OrderDialogModel orderData) {
        Map<String, String> map = new TreeMap<>();
        map.put("FKEY", DataManager.getMd5Str("SHIPHOTELORDER"));
        map.put("HONOURUSER_ID", BaseApplication.HONOURUSER_ID);
        map.put("ORDERUNAME", orderData.getDj_order_name());
        map.put("ORDERPHONE", orderData.getDj_order_phone());
        map.put("ORDERREMARK", orderData.getDj_order_other());
        map.put("ORDERMONEY", orderData.getDj_item_money());
        map.put("ORDERROOMNUM", orderData.getDj_order_num());
        map.put("ORDERCHECKDATE", orderData.getDj_check_in());//入住
        map.put("ORDERLEAVEDATE", orderData.getDj_check_out());//离开
        map.put("ORDERDAYS", days + "");//天数
        map.put("HOTELDETAIL_ID", orderData.getDj_item_name());//类型

        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postHotelOrder(map), new ResultListener<OrderResultModel>() {
            @Override
            public void responseSuccess(OrderResultModel obj) {
                orderData.setDj_return_id(obj.getORDERNUMBER());
                ActivityUtils.startActivityForSerializable(HomeHotelDetailActivity.this, OrderPayActivity.class, orderData);
            }

            @Override
            public void onCompleted() {

            }
        });

    }

    private void setData(HotelDetailModel.PdBean hotelData) {
        score = hotelData.getHOTELEVALUATE();
        hotelName.setText(hotelData.getHOTELNAMES());
        tvScore.setText(String.valueOf(hotelData.getHOTELEVALUATE()));
        tvTel.setText(hotelData.getHOTELPHONE());
        tvAddress.setText(hotelData.getHOTELADDRESS());
        btScore.setText(String.valueOf(hotelData.getHOTELEVALUATE()));
        tvComment.setText(hotelData.getHOTELEVACOUNT() + "条评论");
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
        topBanner.setImages(hotelData.getHOTELDETAILSIMGS());
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

    private void initData() {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postHotelDetail(DataManager.getMd5Str("HOTELSYN"), id), new ResultListener<HotelDetailModel>() {
            @Override
            public void responseSuccess(HotelDetailModel obj) {
                hotelData = obj.getPd();
                setData(hotelData);
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private String dataIn = null;
    private String dataOut = null;
    private int days;

    @OnClick({R.id.rl_comment, R.id.ll_check_out, R.id.ll_check_in, R.id.im_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_comment:
                ActivityUtils.startActivityForData(HomeHotelDetailActivity.this, CommentActivity.class, id, String.valueOf(score), HomeTypeConstant.HOME_TYPE_HOTEL);
                break;
            case R.id.ll_check_in:
                PublicDialog.dateDialog(HomeHotelDetailActivity.this, "请选择日期", new DateListener() {
                    @Override
                    public void dateListener(String data) {
                        dataIn = data;
                        setDate(data, tvCheckIn);
                    }
                });
                break;
            case R.id.ll_check_out:
                PublicDialog.dateDialog(HomeHotelDetailActivity.this, "请选择日期", new DateListener() {
                    @Override
                    public void dateListener(String data) {
                        dataOut = data;
                        setDate(data, tvCheckOut);
                    }
                });
                break;
            case R.id.im_back:
                finish();
                break;
        }
    }

    private void setDate(String data, TextView tv) {
        try {
            days = MyCalendar.getDateSpace(dataIn, dataOut);
            if (days < 0) {
                UIUtils.showToast("日期选择有误请重新选择");
                return;
            } else {
                tvTotle.setText("共" + days + "天");
            }
        } catch (Exception e) {

        }
        tv.setText(data.substring(5));
    }
}

