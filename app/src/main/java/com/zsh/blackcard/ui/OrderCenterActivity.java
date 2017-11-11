package com.zsh.blackcard.ui;

import android.view.View;
import android.widget.ImageView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

/**
 * Created by kkkkk on 2017/11/11.
 */

public class OrderCenterActivity extends BaseActivity implements View.OnClickListener {

    private ImageView zgmyback;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_zg_my);
        initView();
        initOnClick();
    }

    private void initOnClick() {
        zgmyback.setOnClickListener(this);
    }

    private void initView() {
        zgmyback = (ImageView) findViewById(R.id.zgmyback);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
