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
import com.zsh.blackcard.adapter.FoodDetailListAdapter;
import com.zsh.blackcard.adapter.FoodDetailMoreListAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.custom.HomeTypeConstant;
import com.zsh.blackcard.custom.PublicDialog;
import com.zsh.blackcard.listener.OrderDiaListenter;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.FoodDetailModel;
import com.zsh.blackcard.model.FoodDetailsListModel;
import com.zsh.blackcard.model.FoodDetailsMoreListModel;
import com.zsh.blackcard.model.OrderDialogModel;
import com.zsh.blackcard.model.OrderResultModel;
import com.zsh.blackcard.ui.OrderPayActivity;
import com.zsh.blackcard.untils.ActivityUtils;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class HomeFoodDetailActivity extends BaseActivity {

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
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.more_recyclerView)
    RecyclerView moreRecyclerView;
    private FoodDetailModel.PdBean foodData;
    private String id;
    private String score;
    private FoodDetailListAdapter adapter;
    private FoodDetailMoreListAdapter moreAdapter;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_home_food_detail);
        id = getIntent().getStringExtra("data");
        ButterKnife.bind(this);
        initData();
        initRV();
        initMoreRV();
    }

    private void initData() {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postFoodDetail(DataManager.getMd5Str("SFOODSYN"), id), new ResultListener<FoodDetailModel>() {
            @Override
            public void responseSuccess(FoodDetailModel obj) {
                foodData = obj.getPd();
                setData(foodData);
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void initRV() {//TODO
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postFoodDetailList(DataManager.getMd5Str("HOTELDETAIL"), id), new ResultListener<FoodDetailsListModel>() {
            @Override
            public void responseSuccess(FoodDetailsListModel obj) {

                List<FoodDetailsListModel.PdBean> dataList = obj.getPd();
                setRVData(dataList);
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void setRVData(final List<FoodDetailsListModel.PdBean> dataList) {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);

        adapter = new FoodDetailListAdapter(this, dataList);
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //  orderDialog(dataList.get(position));
            }
        });
    }

    private void initMoreRV() {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postFoodDetailMoreList(DataManager.getMd5Str("SORTFOODRAND"), BaseApplication.HONOURUSER_ID), new ResultListener<FoodDetailsMoreListModel>() {
            @Override
            public void responseSuccess(FoodDetailsMoreListModel obj) {

                List<FoodDetailsMoreListModel.PdBean> dataList = obj.getPd();
                setMoreRVData(dataList);
            }
            @Override
            public void onCompleted() {

            }
        });
    }

    private void setMoreRVData(final List<FoodDetailsMoreListModel.PdBean> dataList) {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);

        moreAdapter = new FoodDetailMoreListAdapter(this, dataList);
        moreRecyclerView.setAdapter(moreAdapter);
        moreRecyclerView.setNestedScrollingEnabled(false);

    }

    OrderDialogModel orderData = new OrderDialogModel();

    public void orderDialog(final FoodDetailsListModel.PdBean item) {
        orderData.setDj_top_name(foodData.getSHOPNAMES());
        orderData.setDj_score(String.valueOf(foodData.getSHOPEVALUATE()));
        orderData.setDj_fit(foodData.getSHOPSERVFITNESS());
        orderData.setDj_wifi(foodData.getSHOPSERVWIFI());
        orderData.setDj_swim(foodData.getSHOPSERVSWIN());
        orderData.setDj_pay(foodData.getSHOPSERVPAY());
        orderData.setDj_park(foodData.getSHOPSERVPARK());
        orderData.setDj_food(foodData.getSHOPSERVFOOD());
        orderData.setDj_item_img(item.getHOTELDETIMGS());
//        orderData.setDj_check_in(dataIn);
//        orderData.setDj_check_out(dataOut);
//        orderData.setDj_check_count(tvTotle.getText().toString());
//        orderData.setDj_item_date(dataIn + "入住," + dataOut + "离开，" + tvTotle.getText());
        orderData.setDj_item_des(item.getHOTELDETBEDTYPE());
        orderData.setDj_item_name(item.getHOTELDETNAME());
        orderData.setDj_item_money(item.getHOTELDETPRICE() + "");
        PublicDialog.orderDialog(HomeFoodDetailActivity.this, HomeTypeConstant.ORDER_TYPE_NUM, orderData, listenter);

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
        // map.put("ORDERDAYS", days + "");//天数
        map.put("HOTELDETAIL_ID", orderData.getDj_item_name());//类型

        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postHotelOrder(map), new ResultListener<OrderResultModel>() {
            @Override
            public void responseSuccess(OrderResultModel obj) {
                orderData.setDj_return_id(obj.getORDERNUMBER());
                ActivityUtils.startActivityForSerializable(HomeFoodDetailActivity.this, OrderPayActivity.class, orderData);
            }

            @Override
            public void onCompleted() {

            }
        });

    }

    //初始化banner轮播区
    private void initBanner() {
        topBanner.setImages(foodData.getSHOPDETAILSIMGS());
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

    private void setData(FoodDetailModel.PdBean foodData) {
        score = String.valueOf(foodData.getSHOPEVALUATE());
        hotelName.setText(foodData.getSHOPNAMES());
        tvScore.setText(String.valueOf(foodData.getSHOPEVALUATE()));
        tvTel.setText(foodData.getSHOPPHONE());
        tvAddress.setText(foodData.getSHOPADDRESS());
        btScore.setText(String.valueOf(foodData.getSHOPEVALUATE()));
        tvComment.setText(foodData.getSHOPEVACOUNT() + "条评论");
        initBanner();
        showOrHint(foodData.getSHOPSERVFOOD(), llFood);
        showOrHint(foodData.getSHOPSERVFITNESS(), llFit);
        showOrHint(foodData.getSHOPSERVPARK(), llPark);
        showOrHint(foodData.getSHOPSERVPAY(), llPay);
        showOrHint(foodData.getSHOPSERVSWIN(), llSwim);
        showOrHint(foodData.getSHOPSERVWIFI(), llWifi);

    }

    private void showOrHint(int i, LinearLayout ll) {
        if (i == 1) {
            ll.setVisibility(View.VISIBLE);
        } else {
            ll.setVisibility(View.GONE);
        }
    }

    // ActivityUtils.startActivityForSerializable(HomeFoodDetailActivity.this, OrderPayActivity.class, orderData);
    @OnClick({R.id.im_back, R.id.rl_comment})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.im_back:
                finish();
                break;


            case R.id.rl_comment:
                //  ActivityUtils.startActivity(HomeFoodDetailActivity.this, CommentActivity.class);
                ActivityUtils.startActivityForData(HomeFoodDetailActivity.this, CommentActivity.class, id, String.valueOf(score), HomeTypeConstant.MORE_TYPE_FOOD);

                break;
        }
    }
}
