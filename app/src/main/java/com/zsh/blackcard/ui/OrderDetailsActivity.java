package com.zsh.blackcard.ui;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

import butterknife.ButterKnife;

/**
 * 订单详情
 */
public class OrderDetailsActivity extends BaseActivity {


    @Override
    protected void initUI() {
        setContentView(R.layout.activity_order_details);
        ButterKnife.bind(this);
    }
}
