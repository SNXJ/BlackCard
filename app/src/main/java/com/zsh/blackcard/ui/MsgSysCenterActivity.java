package com.zsh.blackcard.ui;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Name: MsgCenterActivity
 * Author: SNXJ
 * Date: 2017-11-15
 * Description:消息中心
 */
public class MsgSysCenterActivity extends BaseActivity {

    @Override
    protected void initUI() {
        setContentView(R.layout.msg_sys_center_activity);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.rl_sys_msg, R.id.title_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.rl_sys_msg:
                startActivity(new Intent(MsgSysCenterActivity.this, MsgSysDetailsActivity.class));
                break;
        }
    }
}
