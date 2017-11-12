package com.zsh.blackcard.ui;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.VipCenterAdapter;

/**
 * Created by kkkkk on 2017/11/10.
 */

public class VipCenterActivity extends BaseActivity implements View.OnClickListener {

    private RecyclerView vip_center_recycler;
    private RecyclerView.LayoutManager layoutManager;
    private VipCenterAdapter vipCenterAdapter;
    private ImageView back_img;

    @Override
    protected void initUI() {
        setContentView(R.layout.my_vip_center);
        cvFindId();
        initOnClick();
        initDate();
    }

    private void initOnClick() {
        back_img.setOnClickListener(this);
    }

    private void initDate() {
        vipCenterAdapter = new VipCenterAdapter(this);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        vip_center_recycler.setLayoutManager(layoutManager);
        vip_center_recycler.setAdapter(vipCenterAdapter);
    }

    private void cvFindId() {
        vip_center_recycler = (RecyclerView) findViewById(R.id.my_vip_center_recycler);
        back_img = (ImageView) findViewById(R.id.blackwb_back);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
