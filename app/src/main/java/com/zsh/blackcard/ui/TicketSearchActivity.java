package com.zsh.blackcard.ui;

import android.content.Intent;
import android.view.View;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

/**
 * Name: TicketSearchActivity
 * Author: SNXJ
 * Date: 2017-11-16
 * Description:票务搜索结果
 */
public class TicketSearchActivity extends BaseActivity {
    @Override
    protected void initUI() {
        setContentView(R.layout.ticket_search_activity);
        findViewById(R.id.ll_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TicketSearchActivity.this, TicketSeatActivity.class));
            }
        });
    }
}
