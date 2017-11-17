package com.zsh.blackcard.ui;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.ZgCommodityAdapter;
import com.zsh.blackcard.untils.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class CommodityActivity extends BaseActivity implements ZgCommodityAdapter.ZgCommodityOnItemClick {

    @BindView(R.id.zg_commodity_recycler)
    RecyclerView zg_commodity_recycler;

    private ZgCommodityAdapter adapter;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_commodity);
        ButterKnife.bind(this);
        initDate();
    }

    private void initDate() {
        adapter = new ZgCommodityAdapter(this);
        zg_commodity_recycler.setLayoutManager(new GridLayoutManager(this,2));
        zg_commodity_recycler.setAdapter(adapter);
        adapter.setZgCommodityOnItemClick(this);
    }

    @OnClick(R.id.blackwb_back)
    public void backClick(){
        finish();
    }

    //商品详情点击事件
    @Override
    public void commodityOnItemClick(int position) {
        ActivityUtils.startActivity(this,CommodityDetailBannerActivity.class);
    }
}
