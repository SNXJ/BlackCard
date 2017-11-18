package com.zsh.blackcard.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.CollectionAdapter;
import com.zsh.blackcard.view.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kkkkk on 2017/11/18.
 */

public class CollectionActivity extends BaseActivity {

    private List<String> list = new ArrayList<>();

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
        for (int i = 0; i < 10; i++) {
            list.add("2");
        }


        adapter = new CollectionAdapter(R.layout.my_order_collection_item,list);
        collection_recycler.setLayoutManager(new LinearLayoutManager(this));
        collection_recycler.addItemDecoration(new SpacesItemDecoration(this,SpacesItemDecoration.VERTICAL_LIST));
        collection_recycler.setAdapter(adapter);
    }

    @OnClick(R.id.zgmyback)
    public void onClick(){
        finish();
    }
}
