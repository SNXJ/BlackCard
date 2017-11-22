package com.zsh.blackcard.ui.home;

import android.view.View;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.HomeTitleNewsDetailModel;
import com.zsh.blackcard.untils.UIUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kkkkk on 2017/11/22.
 */

public class HomeTopNewsActivity extends BaseActivity {
    @Override
    protected void initUI() {
        setContentView(R.layout.activity_home_top_news);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        String data = getIntent().getStringExtra("data");
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postHomeTitleNewsDetail(DataManager.getMd5Str("NEWSDET"), data), new ResultListener<HomeTitleNewsDetailModel>() {
            @Override
            public void responseSuccess(HomeTitleNewsDetailModel obj) {
                UIUtils.showToast("请求成功");
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
