package com.zsh.blackcard.ui;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kkkkk on 2017/11/23.
 * 发布页面填写详细要求，上传图片界面。
 */

public class EatDrinkSetDetailActivity extends BaseActivity{
    @Override
    protected void initUI() {
        setContentView(R.layout.activity_eat_drink_set_detail);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.blackwb_back)
    public void onClick(){
        finish();
    }
}
