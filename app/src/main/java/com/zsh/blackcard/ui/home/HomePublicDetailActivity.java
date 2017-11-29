package com.zsh.blackcard.ui.home;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.custom.HomeTypeConstant;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.HomeCarDetailModel;
import com.zsh.blackcard.model.HomeCopterDetailModel;
import com.zsh.blackcard.model.HomeGolfDetailModel;
import com.zsh.blackcard.model.HomeHorseDetailModel;
import com.zsh.blackcard.model.HomeYachtDetailModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomePublicDetailActivity extends BaseActivity {

    @BindView(R.id.home_public_detail_one_img)
    ImageView home_public_detail_one_img;
    @BindView(R.id.home_public_detail_two_img)
    ImageView home_public_detail_two_img;
    @BindView(R.id.home_public_detail_three_img)
    ImageView home_public_detail_three_img;
    @BindView(R.id.home_public_detail_introduce_tv)
    TextView home_public_detail_introduce_tv;
    @BindView(R.id.home_public_detail_title_tv)
    TextView home_public_detail_title_tv;
    @BindView(R.id.home_public_detail_title_content_tv)
    TextView home_public_detail_title_content_tv;
    @BindView(R.id.home_public_detail_care_tv)
    TextView home_public_detail_care_tv;
    @BindView(R.id.home_public_detail_care_content_tv)
    TextView home_public_detail_care_content_tv;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_home_public_detail);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        //获取上级页面传递的点击事件
        String data = getIntent().getStringExtra("data");
        String title = getIntent().getStringExtra("title");

        if (data.equals(HomeTypeConstant.MORE_TYPE_GOLF)) {
            //加载高尔夫详情
            initDataGolf(title);
        } else if (data.equals(HomeTypeConstant.MORE_TYPE_HORSE)) {
            //加载马术详情
            initDataHorse(title);
        } else if (data.equals(HomeTypeConstant.MORE_TYPE_CAR)) {
            //加载豪车
            initDataCar(title);
        } else if (data.equals(HomeTypeConstant.MORE_TYPE_YACHT)) {
            //加载游艇
            initDataYacht(title);
        } else if (data.equals(HomeTypeConstant.MORE_TYPE_COPTER)) {
            //加载飞机
            initCopter();
        }
    }

    private void initCopter() {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postHomeCopterDetail(DataManager.getMd5Str("HORSEDETAIL")), new ResultListener<HomeCopterDetailModel>() {
            @Override
            public void responseSuccess(HomeCopterDetailModel obj) {
                Glide.with(HomePublicDetailActivity.this).load(obj.getPd().get(0).getPLANEDETIMGS().get(0)).into(home_public_detail_one_img);
                Glide.with(HomePublicDetailActivity.this).load(obj.getPd().get(0).getPLANEDETIMGS().get(1)).into(home_public_detail_two_img);
                Glide.with(HomePublicDetailActivity.this).load(obj.getPd().get(0).getPLANEDETIMGS().get(2)).into(home_public_detail_three_img);
                home_public_detail_introduce_tv.setText(obj.getPd().get(0).getPLANEDETINTRO());
                home_public_detail_title_tv.setText(obj.getPd().get(0).getPUPINTROTITLE());
                home_public_detail_title_content_tv.setText(obj.getPd().get(0).getPUPINTROCONTENT());
                home_public_detail_care_tv.setText(obj.getPd().get(0).getPDOWNINTROTITLE());
                home_public_detail_care_content_tv.setText(obj.getPd().get(0).getPDOWNINTROCONTENT());
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void initDataYacht(String title) {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postHomeYachtDetail(DataManager.getMd5Str("YACHTDETAIL"), title), new ResultListener<HomeYachtDetailModel>() {
            @Override
            public void responseSuccess(HomeYachtDetailModel obj) {
                Glide.with(HomePublicDetailActivity.this).load(obj.getPd().get(0).getYACHTDETIMGS().get(0)).into(home_public_detail_one_img);
                Glide.with(HomePublicDetailActivity.this).load(obj.getPd().get(0).getYACHTDETIMGS().get(1)).into(home_public_detail_two_img);
                Glide.with(HomePublicDetailActivity.this).load(obj.getPd().get(0).getYACHTDETIMGS().get(2)).into(home_public_detail_three_img);
                home_public_detail_introduce_tv.setText(obj.getPd().get(0).getYACHTDETINTRO());
                home_public_detail_title_tv.setText(obj.getPd().get(0).getPUPINTROTITLE());
                home_public_detail_title_content_tv.setText(obj.getPd().get(0).getPUPINTROCONTENT());
                home_public_detail_care_tv.setText(obj.getPd().get(0).getPDOWNINTROTITLE());
                home_public_detail_care_content_tv.setText(obj.getPd().get(0).getPDOWNINTROCONTENT());
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void initDataCar(String title) {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postHomeCarDetail(DataManager.getMd5Str("HORSEDETAIL"), title), new ResultListener<HomeCarDetailModel>() {
            @Override
            public void responseSuccess(HomeCarDetailModel obj) {
                Glide.with(HomePublicDetailActivity.this).load(obj.getPd().get(0).getLUXCARDETIMGS().get(0)).into(home_public_detail_one_img);
                Glide.with(HomePublicDetailActivity.this).load(obj.getPd().get(0).getLUXCARDETIMGS().get(1)).into(home_public_detail_two_img);
                Glide.with(HomePublicDetailActivity.this).load(obj.getPd().get(0).getLUXCARDETIMGS().get(2)).into(home_public_detail_three_img);
                home_public_detail_introduce_tv.setText(obj.getPd().get(0).getLUXCARDETINTRO());
                home_public_detail_title_tv.setText(obj.getPd().get(0).getPUPINTROTITLE());
                home_public_detail_title_content_tv.setText(obj.getPd().get(0).getPUPINTROCONTENT());
                home_public_detail_care_tv.setText(obj.getPd().get(0).getPDOWNINTROTITLE());
                home_public_detail_care_content_tv.setText(obj.getPd().get(0).getPDOWNINTROCONTENT());
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void initDataHorse(String title) {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postHomeHorseDetail(DataManager.getMd5Str("HORSEDETAIL"), title), new ResultListener<HomeHorseDetailModel>() {
            @Override
            public void responseSuccess(HomeHorseDetailModel obj) {
                Glide.with(HomePublicDetailActivity.this).load(obj.getPd().get(0).getHORSEDETIMGS().get(0)).into(home_public_detail_one_img);
                Glide.with(HomePublicDetailActivity.this).load(obj.getPd().get(0).getHORSEDETIMGS().get(1)).into(home_public_detail_two_img);
                Glide.with(HomePublicDetailActivity.this).load(obj.getPd().get(0).getHORSEDETIMGS().get(2)).into(home_public_detail_three_img);
                home_public_detail_introduce_tv.setText(obj.getPd().get(0).getHORSEDETINTRO());
                home_public_detail_title_tv.setText(obj.getPd().get(0).getPUPINTROTITLE());
                home_public_detail_title_content_tv.setText(obj.getPd().get(0).getPUPINTROCONTENT());
                home_public_detail_care_tv.setText(obj.getPd().get(0).getPDOWNINTROTITLE());
                home_public_detail_care_content_tv.setText(obj.getPd().get(0).getPDOWNINTROCONTENT());
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void initDataGolf(String title) {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postHomeGolfDetail(DataManager.getMd5Str("GOLFDETAIL"), title), new ResultListener<HomeGolfDetailModel>() {
            @Override
            public void responseSuccess(HomeGolfDetailModel obj) {
                Glide.with(HomePublicDetailActivity.this).load(obj.getPd().get(0).getGOLFDETIMGS().get(0)).into(home_public_detail_one_img);
                Glide.with(HomePublicDetailActivity.this).load(obj.getPd().get(0).getGOLFDETIMGS().get(1)).into(home_public_detail_two_img);
                Glide.with(HomePublicDetailActivity.this).load(obj.getPd().get(0).getGOLFDETIMGS().get(2)).into(home_public_detail_three_img);
                home_public_detail_introduce_tv.setText(obj.getPd().get(0).getGOLFDETINTRO());
                home_public_detail_title_tv.setText(obj.getPd().get(0).getPUPINTROTITLE());
                home_public_detail_title_content_tv.setText(obj.getPd().get(0).getPUPINTROCONTENT());
                home_public_detail_care_tv.setText(obj.getPd().get(0).getPDOWNINTROTITLE());
                home_public_detail_care_content_tv.setText(obj.getPd().get(0).getPDOWNINTROCONTENT());
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    @OnClick(R.id.title_back)
    public void onClick() {
        finish();
    }
}
