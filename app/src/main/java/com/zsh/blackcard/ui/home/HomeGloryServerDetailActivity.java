package com.zsh.blackcard.ui.home;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.HomeCarDetailModel;
import com.zsh.blackcard.model.HomeCopterDetailModel;
import com.zsh.blackcard.model.HomeHorseDetailModel;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kkkkk on 2017/11/30.
 */

public class HomeGloryServerDetailActivity extends BaseActivity {

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
        String data = getIntent().getStringExtra("data");
        String title = getIntent().getStringExtra("title");
        initHorse(data, title);
    }

    private void initHorse(final String data, final String title) {
        DataManager.getInstance(this).RequestHttp(NetApi.postHomeGloryHorseDetail(DataManager.getMd5Str("SERVERDETAIL"), title), new ResultListener<Object>() {
            @Override
            public void responseSuccess(Object obj) {
                Gson gson = new Gson();
                switch (data) {
                    case "383990553504645120":
                        //加载马术类型
                        HomeHorseDetailModel homeHorseDetailModel = gson.fromJson(gson.toJson(obj), HomeHorseDetailModel.class);
                        Glide.with(HomeGloryServerDetailActivity.this).load(homeHorseDetailModel.getPd().get(0).getHORSEDETIMGS().get(0)).into(home_public_detail_one_img);
                        Glide.with(HomeGloryServerDetailActivity.this).load(homeHorseDetailModel.getPd().get(0).getHORSEDETIMGS().get(1)).into(home_public_detail_two_img);
                        Glide.with(HomeGloryServerDetailActivity.this).load(homeHorseDetailModel.getPd().get(0).getHORSEDETIMGS().get(2)).into(home_public_detail_three_img);
                        home_public_detail_introduce_tv.setText(homeHorseDetailModel.getPd().get(0).getHORSEDETINTRO());
                        home_public_detail_title_tv.setText(homeHorseDetailModel.getPd().get(0).getPUPINTROTITLE());
                        home_public_detail_title_content_tv.setText(homeHorseDetailModel.getPd().get(0).getPUPINTROCONTENT());
                        home_public_detail_care_tv.setText(homeHorseDetailModel.getPd().get(0).getPDOWNINTROTITLE());
                        home_public_detail_care_content_tv.setText(homeHorseDetailModel.getPd().get(0).getPDOWNINTROCONTENT());
                        break;
                    case "383995103208800256":
                        //加载飞机类型
                        HomeCopterDetailModel homeCopterDetailModel = gson.fromJson(gson.toJson(obj), HomeCopterDetailModel.class);
                        Glide.with(HomeGloryServerDetailActivity.this).load(homeCopterDetailModel.getPd().get(0).getPLANEDETIMGS().get(0)).into(home_public_detail_one_img);
                        Glide.with(HomeGloryServerDetailActivity.this).load(homeCopterDetailModel.getPd().get(0).getPLANEDETIMGS().get(1)).into(home_public_detail_two_img);
                        Glide.with(HomeGloryServerDetailActivity.this).load(homeCopterDetailModel.getPd().get(0).getPLANEDETIMGS().get(2)).into(home_public_detail_three_img);
                        home_public_detail_introduce_tv.setText(homeCopterDetailModel.getPd().get(0).getPLANEDETINTRO());
                        home_public_detail_title_tv.setText(homeCopterDetailModel.getPd().get(0).getPUPINTROTITLE());
                        home_public_detail_title_content_tv.setText(homeCopterDetailModel.getPd().get(0).getPUPINTROCONTENT());
                        home_public_detail_care_tv.setText(homeCopterDetailModel.getPd().get(0).getPDOWNINTROTITLE());
                        home_public_detail_care_content_tv.setText(homeCopterDetailModel.getPd().get(0).getPDOWNINTROCONTENT());
                        break;
                    case "383994744717443072":
                        //加载豪车类型
                        HomeCarDetailModel homeCarDetailModel = gson.fromJson(gson.toJson(obj), HomeCarDetailModel.class);
                        Glide.with(HomeGloryServerDetailActivity.this).load(homeCarDetailModel.getPd().get(0).getLUXCARDETIMGS().get(0)).into(home_public_detail_one_img);
                        Glide.with(HomeGloryServerDetailActivity.this).load(homeCarDetailModel.getPd().get(0).getLUXCARDETIMGS().get(1)).into(home_public_detail_two_img);
                        Glide.with(HomeGloryServerDetailActivity.this).load(homeCarDetailModel.getPd().get(0).getLUXCARDETIMGS().get(2)).into(home_public_detail_three_img);
                        home_public_detail_introduce_tv.setText(homeCarDetailModel.getPd().get(0).getLUXCARDETINTRO());
                        home_public_detail_title_tv.setText(homeCarDetailModel.getPd().get(0).getPUPINTROTITLE());
                        home_public_detail_title_content_tv.setText(homeCarDetailModel.getPd().get(0).getPUPINTROCONTENT());
                        home_public_detail_care_tv.setText(homeCarDetailModel.getPd().get(0).getPDOWNINTROTITLE());
                        home_public_detail_care_content_tv.setText(homeCarDetailModel.getPd().get(0).getPDOWNINTROCONTENT());
                        break;
                }

            }

            @Override
            public void onCompleted() {

            }
        });
    }
}
