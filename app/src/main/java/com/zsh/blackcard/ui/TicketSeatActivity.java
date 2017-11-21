package com.zsh.blackcard.ui;

import android.view.View;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.custom.PublicDialog;

/**
 * Name: TicketSearchActivity
 * Author: SNXJ
 * Date: 2017-11-16
 * Description:席位（票务）
 */
public class TicketSeatActivity extends BaseActivity {
    @Override
    protected void initUI() {
        setContentView(R.layout.ticket_seat_activity);
        findViewById(R.id.rl_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PublicDialog.ticketInfoPop(TicketSeatActivity.this);
            }
        });
    }
}
