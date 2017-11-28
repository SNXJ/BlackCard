package com.zsh.blackcard.ui;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

import butterknife.ButterKnife;


public class GolfDetailActivity extends BaseActivity {

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_golf_detail);
        ButterKnife.bind(this);
    }
}
