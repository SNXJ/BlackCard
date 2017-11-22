package com.zsh.blackcard.ui;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.ZgCommodityAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.ZgShopAreaModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 手表专区页面
 */
public class CommodityActivity extends BaseActivity {

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
        String data = getIntent().getStringExtra("data");
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postShopArea(DataManager.getMd5Str("SHIPPRE"), data), new ResultListener<ZgShopAreaModel>() {
            @Override
            public void responseSuccess(ZgShopAreaModel obj) {
                adapter = new ZgCommodityAdapter(R.layout.zg_commodity_recycler_item,obj.getPd());
                zg_commodity_recycler.setLayoutManager(new GridLayoutManager(CommodityActivity.this,2));
                zg_commodity_recycler.setAdapter(adapter);
            }

            @Override
            public void onCompleted() {

            }
        });


    }

    @OnClick(R.id.blackwb_back)
    public void backClick() {
        finish();
    }
}
