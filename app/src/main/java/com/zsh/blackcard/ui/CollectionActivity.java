package com.zsh.blackcard.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.CollectionAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.CollectionModel;
import com.zsh.blackcard.view.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kkkkk on 2017/11/18.
 * 炫购收藏页面
 */

public class CollectionActivity extends BaseActivity {

    private CollectionAdapter adapter;

    @BindView(R.id.collection_recycler)
    RecyclerView collection_recycler;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_collection);
        ButterKnife.bind(this);
        initDate();
    }

    private void initDate() {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postCollection(DataManager.getMd5Str("SHIPCOL"), "d6a3779de8204dfd9359403f54f7d27c"), new ResultListener<CollectionModel>() {
            @Override
            public void responseSuccess(CollectionModel obj) {
                adapter = new CollectionAdapter(R.layout.my_order_collection_item,obj.getPd());
                collection_recycler.setLayoutManager(new LinearLayoutManager(CollectionActivity.this));
                collection_recycler.addItemDecoration(new SpacesItemDecoration(CollectionActivity.this,SpacesItemDecoration.VERTICAL_LIST));
                collection_recycler.setAdapter(adapter);
            }

            @Override
            public void onCompleted() {

            }
        });



    }

    @OnClick(R.id.zgmyback)
    public void onClick(){
        finish();
    }
}
