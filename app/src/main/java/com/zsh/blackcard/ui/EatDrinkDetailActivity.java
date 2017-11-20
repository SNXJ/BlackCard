package com.zsh.blackcard.ui;

import android.view.View;
import android.widget.ImageView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

/**
 * Created by kkkkk on 2017/11/13.
 */

public class EatDrinkDetailActivity extends BaseActivity implements View.OnClickListener {

    private ImageView back_img;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_eat_drink_detail);
        initView();
        initOnClick();
        initDate();
    }

    private void initDate() {

    }

    private void initOnClick() {
        back_img.setOnClickListener(this);
    }

    private void initView() {
        back_img = (ImageView) findViewById(R.id.blackwb_back);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.blackwb_back:
                finish();
                break;
        }
    }
}
