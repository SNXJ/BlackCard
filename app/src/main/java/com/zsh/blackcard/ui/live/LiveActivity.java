package com.zsh.blackcard.ui.live;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.untils.LogUtils;

/**
 * Name: LiveActivity
 * Author: SNXJ
 * Date: 2017-11-08
 * Description: 直播LiveActivity：
 */
public class LiveActivity extends BaseActivity {
    @Override
    protected void initUI() {
        LogUtils.i("++++++++++Live", "onCreate");
        setContentView(R.layout.activity_live_main);
    }
}
