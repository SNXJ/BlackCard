package com.zsh.blackcard.ui;

import android.view.View;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Name: MsgCenterActivity
 * Author: SNXJ
 * Date: 2017-11-15
 * Description:消息中心,回复/评论
 */
public class MsgCenterDetailsActivity extends BaseActivity {
    @Override
    protected void initUI() {
        setContentView(R.layout.msg_center_details_activity);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.title_back})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.title_back:
                finish();
                break;
        }
    }
}
