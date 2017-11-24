package com.zsh.blackcard.ui.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.HomeTitleNewsDetailModel;
import com.zsh.blackcard.untils.UIUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kkkkk on 2017/11/22.
 */

public class HomeTopNewsDetailActivity extends BaseActivity {

    @BindView(R.id.home_top_news_detail_title_tv)
    TextView home_top_news_detail_title_tv;
    @BindView(R.id.home_top_news_detail_content_tv)
    TextView home_top_news_detail_content_tv;
    @BindView(R.id.home_top_news_detail_img)
    ImageView home_top_news_detail_img;
    @BindView(R.id.home_top_news_detail_small_title_one_tv)
    TextView home_top_news_detail_small_title_one_tv;
    @BindView(R.id.home_top_news_detail_small_content_one_tv)
    TextView home_top_news_detail_small_content_one_tv;
    @BindView(R.id.home_top_news_detail_small_one_img)
    ImageView home_top_news_detail_small_one_img;
    @BindView(R.id.home_top_news_detail_small_title_two_tv)
    TextView home_top_news_detail_small_title_two_tv;
    @BindView(R.id.home_top_news_detail_small_content_two_tv)
    TextView home_top_news_detail_small_content_two_tv;
    @BindView(R.id.home_top_news_detail_small_two_img)
    ImageView home_top_news_detail_small_two_img;
    @BindView(R.id.home_top_news_detail_small_title_three_tv)
    TextView home_top_news_detail_small_title_three_tv;
    @BindView(R.id.home_top_news_detail_small_content_three_tv)
    TextView home_top_news_detail_small_content_three_tv;
    @BindView(R.id.home_top_news_detail_small_three_img)
    ImageView home_top_news_detail_small_three_img;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_home_top_news_detail);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        String data = getIntent().getStringExtra("data");
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postHomeTitleNewsDetail(DataManager.getMd5Str("NEWSDET"), data), new ResultListener<HomeTitleNewsDetailModel>() {
            @Override
            public void responseSuccess(HomeTitleNewsDetailModel obj) {
                home_top_news_detail_title_tv.setText(obj.getPd().getNEWSTITLE());
                home_top_news_detail_content_tv.setText(obj.getPd().getNEWSCONTENT());
                Glide.with(HomeTopNewsDetailActivity.this).load(obj.getPd().getNEWSIMG()).into(home_top_news_detail_img);

                home_top_news_detail_small_title_one_tv.setText(obj.getPd().getTITLEPIECEONE());
                home_top_news_detail_small_content_one_tv.setText(obj.getPd().getCONTENTPIECEONE());
                Glide.with(HomeTopNewsDetailActivity.this).load(obj.getPd().getIMGPIECEONE()).into(home_top_news_detail_small_one_img);

                home_top_news_detail_small_title_two_tv.setText(obj.getPd().getTITLEPIECETWO());
                home_top_news_detail_small_content_two_tv.setText(obj.getPd().getCONTENTPIECETWO());
                Glide.with(HomeTopNewsDetailActivity.this).load(obj.getPd().getIMGPIECETWO()).into(home_top_news_detail_small_two_img);

                home_top_news_detail_small_title_three_tv.setText(obj.getPd().getTITLEPIECETHREE());
                home_top_news_detail_small_content_three_tv.setText(obj.getPd().getCONTENTPIECETHREE());
                Glide.with(HomeTopNewsDetailActivity.this).load(obj.getPd().getIMGPIECETHREE()).into(home_top_news_detail_small_three_img);

            }

            @Override
            public void onCompleted() {

            }
        });
    }

    @OnClick(R.id.title_back)
    public void onClick(View view){
        switch (view.getId()){
            case R.id.title_back:
                finish();
                break;
        }
    }
}