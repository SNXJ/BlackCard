package com.zsh.blackcard.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.CollectionAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.CollectionModel;
import com.zsh.blackcard.model.ResultModel;
import com.zsh.blackcard.utils.UIUtils;
import com.zsh.blackcard.view.SpacesItemDecoration;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kkkkk on 2017/11/18.
 * 炫购收藏页面
 */

public class CollectionActivity extends BaseActivity implements BaseQuickAdapter.OnItemChildClickListener {

    private CollectionAdapter collectionAdapter;

    @BindView(R.id.collection_recycler)
    RecyclerView collection_recycler;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_collection);
        ButterKnife.bind(this);
        initDate();
    }

    private void initDate() {
        DataManager.getInstance(this).RequestHttp(NetApi.postCollection(DataManager.getMd5Str("SHIPCOL"), "d6a3779de8204dfd9359403f54f7d27c"), new ResultListener<CollectionModel>() {
            @Override
            public void responseSuccess(CollectionModel obj) {
                collectionAdapter = new CollectionAdapter(R.layout.my_order_collection_item, obj.getPd());
                collection_recycler.setLayoutManager(new LinearLayoutManager(CollectionActivity.this));
                collection_recycler.addItemDecoration(new SpacesItemDecoration(CollectionActivity.this, SpacesItemDecoration.VERTICAL_LIST));
                collection_recycler.setAdapter(collectionAdapter);
                collectionAdapter.setOnItemChildClickListener(CollectionActivity.this);
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    @OnClick(R.id.zgmyback)
    public void onClick() {
        finish();
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (view.getId()) {
            //从选购收藏删除商品
            case R.id.shopping_car_item_right_delete:
                //从选购收藏删除商品
//                initDelCollection(((CollectionModel.PdBean)adapter.getData().get(position)).getPRODUCT_ID());
                break;
            //找相似
            case R.id.collection_find_tv:
                break;
        }
    }

    private void initDelCollection(String product_id) {
        DataManager.getInstance(this).RequestHttp(NetApi.postDelCollection(DataManager.getMd5Str("SHIPCOLDEL"), ""), new ResultListener<ResultModel>() {
            @Override
            public void responseSuccess(ResultModel obj) {
                if (obj.getResult().equals("01")) {
                    UIUtils.showToast("删除成功");
                } else {
                    UIUtils.showToast("删除失败");
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }
}
