package com.zsh.blackcard.ui;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

import butterknife.ButterKnife;

/**
 * 确认订单
 */
public class ConfirmOrderActivity extends BaseActivity {

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_confirm_order);
        ButterKnife.bind(this);
    }
}
