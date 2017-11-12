package com.zsh.blackcard.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.MyHuoDongAdapter;
import com.zsh.blackcard.view.SpacesItemDecoration;
import com.zsh.blackcard.view.SpacesItemLastDecoration;

/**
 * Created by kkkkk on 2017/11/11.
 */

public class HuoDongActivity extends BaseActivity implements View.OnClickListener {

    private ImageView back_img;
    private RecyclerView my_huodong_recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MyHuoDongAdapter adapter;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_huodong);
        initView();
        initOnClick();
        initDate();
    }

    private void initDate() {
        adapter = new MyHuoDongAdapter(this);
        layoutManager = new LinearLayoutManager(this);
        my_huodong_recyclerView.setLayoutManager(layoutManager);
        my_huodong_recyclerView.setAdapter(adapter);
        my_huodong_recyclerView.addItemDecoration(new SpacesItemLastDecoration(this,SpacesItemLastDecoration.VERTICAL_LIST));

    }

    private void initOnClick() {
        back_img.setOnClickListener(this);
    }

    private void initView() {
        back_img = (ImageView) findViewById(R.id.blackwb_back);
        my_huodong_recyclerView = (RecyclerView) findViewById(R.id.my_huodong_recyclerView);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
