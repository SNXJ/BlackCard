package com.zsh.blackcard.live.zego;

import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;

import com.zsh.blackcard.BaseActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import butterknife.ButterKnife;

/**
 * Name: AbsBaseActivity
 * Author: SNXJ
 * Date: 2017-12-04
 * Description:描述：
 */
public abstract class AbsBaseActivity extends BaseActivity {
    @Override
    protected void initUI() {
        setContentView(getContentViewLayout());
        hideInputSoft();
        // 初始化butternife
        ButterKnife.bind(this);
        initExtraData(savedInstanceState);
        initBaseVariables();
        initVariables(savedInstanceState);
        initViews(savedInstanceState);
        doBusiness(savedInstanceState);
    }

    protected Resources mResources;

    protected Handler mHandler;

    protected ProgressDialog mProgressDialog;
    protected LinkedList<String> mListLog = new LinkedList<>();

    /**
     * 获取内容页面的布局.
     *
     * @return 返回内容页面的布局
     */
    protected abstract int getContentViewLayout();

    /**
     * 初始化从外部传递过来的数据.
     */
    protected abstract void initExtraData(Bundle savedInstanceState);

    /**
     * 初始化子类中的变量.
     */
    protected abstract void initVariables(Bundle savedInstanceState);

    /**
     * 初始化子类中的控件.
     */
    protected abstract void initViews(Bundle savedInstanceState);

    /**
     * 加载数据.
     */
    /**
     * 加载数据.
     */
    protected abstract void doBusiness(Bundle savedInstanceState);


    /**
     * 初始化基类中的变量.
     */
    private void initBaseVariables() {
        mResources = getResources();
        mHandler = new Handler();
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
    }

    static private SimpleDateFormat sDataFormat = new SimpleDateFormat("[hh:mm:ss.SSS]");

    protected void recordLog(String msg) {
        String now = sDataFormat.format(new Date());
        mListLog.addFirst(String.format("%s %s", now, msg));
//        PreferenceUtil.getInstance().setObjectToString(
//                LogListActivity.KEY_LIST_LOG, mListLog);
    }

    protected void recordLog(String msgFormat, Object... args) {
        String message = String.format(msgFormat, args);
        recordLog(message);
    }
}
