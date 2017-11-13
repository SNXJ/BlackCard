package com.zsh.blackcard.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.ExChangeAdapter;
import com.zsh.blackcard.view.SpacesItemDecoration;

/**
 * Created by kkkkk on 2017/11/13.
 */

public class ExChangeActivity extends BaseActivity implements View.OnClickListener {

    private ImageView back_img;
    private RecyclerView my_power_exchange_recycler;
    private RecyclerView.LayoutManager layoutManager;
    private ExChangeAdapter adapter;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_my_exchange);
        initView();
        initOnClick();
        initDate();
    }

    private void initDate() {
        adapter = new ExChangeAdapter(this);
        layoutManager = new LinearLayoutManager(this);
        my_power_exchange_recycler.setLayoutManager(layoutManager);
        my_power_exchange_recycler.setAdapter(adapter);
        my_power_exchange_recycler.addItemDecoration(new SpacesItemDecoration(this,SpacesItemDecoration.VERTICAL_LIST));

    }

    private void initOnClick() {
        back_img.setOnClickListener(this);
    }

    private void initView() {
        my_power_exchange_recycler = (RecyclerView) findViewById(R.id.my_power_exchange_recycler);
        back_img = (ImageView) findViewById(R.id.blackwb_back);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
