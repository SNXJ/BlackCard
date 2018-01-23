package com.zsh.blackcard.aliLive;

import android.view.WindowManager;

import com.zsh.blackcard.BaseActivity;


/**
 * Name: BaseAliLiveActivity
 * Author: Shing
 * Date: 2018/1/15 上午11:57
 * Description: 阿里云直播base
 */

public abstract class BaseAliLiveActivity extends BaseActivity {


    protected abstract void initView();

    protected abstract void initData();

    @Override
    protected void initUI() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);//屏幕常亮
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initView();
        initData();
    }
}
