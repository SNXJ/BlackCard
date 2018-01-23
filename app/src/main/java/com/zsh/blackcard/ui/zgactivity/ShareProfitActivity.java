package com.zsh.blackcard.ui.zgactivity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.ShareProfitAdapter;
import com.zsh.blackcard.custom.PublicDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Name: ShareProfitActivity
 * Author: Shing
 * Date: 2018/1/10 上午10:27
 * Description: 分享赚钱
 */

public class ShareProfitActivity extends BaseActivity {
    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.bt_share)
    Button btShare;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void initUI() {
        setContentView(R.layout.share_profit_activity);
        ButterKnife.bind(this);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");


        recyclerView.setAdapter(new ShareProfitAdapter(list));

    }


    @OnClick({R.id.title_back, R.id.bt_share})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.bt_share:
                PublicDialog.shareDialog(this);
                break;
        }
    }
}
