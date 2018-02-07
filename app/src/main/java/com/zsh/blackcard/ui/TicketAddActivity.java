package com.zsh.blackcard.ui;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

import butterknife.ButterKnife;

/**
 * Name: TicketAddActivity
 * Author: SNXJ
 * Date: 2017-11-16
 * Description:添加新乘客
 */
public class TicketAddActivity extends BaseActivity {
    @Override
    protected void initUI() {
        setContentView(R.layout.ticket_add_activity);
        ButterKnife.bind(this);
    }
}
