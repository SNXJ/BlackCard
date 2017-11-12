package com.zsh.blackcard.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.MyCusCenterAdapter;
import com.zsh.blackcard.view.SpacesItemDecoration;

/**
 * Created by kkkkk on 2017/11/10.
 */

public class CusCenterActivity extends BaseActivity implements View.OnClickListener {

    private RecyclerView my_cus_center_recycler;
    private MyCusCenterAdapter myCusCenterAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ImageView back_img;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_cus_center);
        initFindId();
        initOnClick();
        initDate();
    }

    private void initDate() {
        myCusCenterAdapter = new MyCusCenterAdapter(this);
        layoutManager = new LinearLayoutManager(this);
        my_cus_center_recycler.setLayoutManager(layoutManager);
        my_cus_center_recycler.setAdapter(myCusCenterAdapter);
        my_cus_center_recycler.addItemDecoration(new SpacesItemDecoration(this,SpacesItemDecoration.VERTICAL_LIST));
    }

    private void initOnClick() {
        back_img.setOnClickListener(this);
    }

    private void initFindId() {
        my_cus_center_recycler = (RecyclerView) findViewById(R.id.my_cus_center_recycler);
        back_img = (ImageView) findViewById(R.id.blackwb_back);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
