package com.zsh.blackcard.ui;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

import butterknife.ButterKnife;

/**
 * 直播设置
 */
public class SbSetActivity extends BaseActivity {
    @Override
    protected void initUI() {
        setContentView(R.layout.activity_sb_set);
        ButterKnife.bind(this);
    }
}
