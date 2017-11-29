package com.zsh.blackcard.ui.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.HomeGolfDetailModel;

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

        if(data.equals("k")){
            initDataGolf(title);
        }
    }

    @OnClick(R.id.title_back)
    public void onClick(){
        finish();
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
}
