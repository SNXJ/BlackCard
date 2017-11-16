package com.zsh.blackcard.ui;

import android.content.Intent;
import android.view.View;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

/**
 * Name: MsgCenterActivity
 * Author: SNXJ
 * Date: 2017-11-15
 * Description:消息中心(回复/点赞)
 */
public class MsgCenterActivity extends BaseActivity {
    @Override
    protected void initUI() {
        setContentView(R.layout.msg_center_activity);

        findViewById(R.id.rl_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MsgCenterActivity.this,MsgCenterDetailsActivity.class));
            }
        });
    }
}
