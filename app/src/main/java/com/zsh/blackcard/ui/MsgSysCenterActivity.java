package com.zsh.blackcard.ui;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

/**
 * Name: MsgCenterActivity
 * Author: SNXJ
 * Date: 2017-11-15
 * Description:消息中心
 */
public class MsgSysCenterActivity extends BaseActivity {
    RelativeLayout rl_sys_msg;

    @Override
    protected void initUI() {
        setContentView(R.layout.msg_sys_center_activity);

        findViewById(R.id.rl_sys_msg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MsgSysCenterActivity.this, MsgSysDetailsActivity.class));
            }
        });

    }
}
