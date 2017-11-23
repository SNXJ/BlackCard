package com.zsh.blackcard.ui.home;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.HotelDetailModel;
import com.zsh.blackcard.untils.ActivityUtils;

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
    private HotelDetailModel.PdBean hotelData;
    private String id;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_home_food_detail);
        id = getIntent().getStringExtra("data");
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postFoodDetail(DataManager.getMd5Str("HOTELSYN"), id), new ResultListener<HotelDetailModel>() {
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

    //初始化banner轮播区
    private void initBanner() {
        topBanner.setImages(hotelData.getHOTELDETAILSIMGS());
        topBanner.setImageLoader(new HomeFoodDetailActivity.MyImageLoader());
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

    private void setData(HotelDetailModel.PdBean hotelData) {
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
                ActivityUtils.startActivity(HomeFoodDetailActivity.this, CommentActivity.class);

                break;
        }
    }
}
