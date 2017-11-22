package com.zsh.blackcard.ui.home;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.HotelDetailModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class HomeHotelActivityDetail extends BaseActivity {

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
    @BindView(R.id.rl_comment)
    RelativeLayout rlComment;
    @BindView(R.id.tv_check_in)
    TextView tvCheckIn;
    @BindView(R.id.tv_check_out)
    TextView tvCheckOut;
    @BindView(R.id.tv_totle)
    TextView tvTotle;
    private String id;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_home_hotel_detail);
        ButterKnife.bind(this);
        id = getIntent().getStringExtra("data");
        initData();
    }

    private void setData(HotelDetailModel.PdBean hotelData) {
        hotelName.setText(hotelData.getHOTELNAMES());
        tvScore.setText(String.valueOf(hotelData.getHOTELEVALUATE()));
        tvTel.setText(hotelData.getHOTELPHONE());
        tvAddress.setText(hotelData.getHOTELADDRESS());
        btScore.setText(String.valueOf(hotelData.getHOTELEVALUATE()));
        tvComment.setText(hotelData.getHOTELEVACOUNT() + "条评论");

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

    private void initData() {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postHotelDetail(DataManager.getMd5Str("HOTELSYN"), id), new ResultListener<HotelDetailModel>() {
            @Override
            public void responseSuccess(HotelDetailModel obj) {
                HotelDetailModel.PdBean hotelData = obj.getPd();
                setData(hotelData);
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    @OnClick({R.id.rl_comment, R.id.tv_check_in, R.id.tv_check_out})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_comment:
                break;
            case R.id.tv_check_in:
                break;
            case R.id.tv_check_out:
                break;
        }
    }
}
