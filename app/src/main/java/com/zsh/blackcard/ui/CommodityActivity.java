package com.zsh.blackcard.ui;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.ZgCommodityAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.ZgShopAreaModel;
import com.zsh.blackcard.utils.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 手表专区页面
 */
public class CommodityActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener{

    @BindView(R.id.zg_commodity_recycler)
    RecyclerView zg_commodity_recycler;

    @BindView(R.id.commodity_title_tv)
    TextView commodity_title_tv;

    private ZgCommodityAdapter adapter;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_commodity);
        ButterKnife.bind(this);
        initDate();
    }

    private void initDate() {
        String data = getIntent().getStringExtra("data");
        String title = getIntent().getStringExtra("title");
        commodity_title_tv.setText(title);
        DataManager.getInstance(this).RequestHttp(NetApi.postShopArea(DataManager.getMd5Str("SHIPPRE"), data), new ResultListener<ZgShopAreaModel>() {
            @Override
            public void responseSuccess(ZgShopAreaModel obj) {
                adapter = new ZgCommodityAdapter(R.layout.zg_commodity_recycler_item,obj.getPd());
                zg_commodity_recycler.setLayoutManager(new GridLayoutManager(CommodityActivity.this,2));
                zg_commodity_recycler.setAdapter(adapter);
                adapter.setOnItemClickListener(CommodityActivity.this);
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

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        //跳转至商品详情页面
        ActivityUtils.startActivityForData(this,CommodityDetailBannerActivity.class,((ZgShopAreaModel.PdBean)adapter.getData().get(position)).getPRODUCT_ID());
    }
}
