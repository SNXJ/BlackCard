package com.zsh.blackcard;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.zsh.blackcard.untils.MyActivityManager;
import com.zsh.blackcard.untils.StatusBarColorUntil;

import butterknife.ButterKnife;

/**
 * @Author snxj .
 * @Date 2017/11/6
 * @Describe *
 */
public abstract class BaseActivity extends AppCompatActivity {
    private static Activity mForegroundActivity = null;
    public BaseApplication baseApplication;
    //  public User user;
    public Bundle savedInstanceState;
    private boolean okAppBarLayout;

    public static Activity getForegroundActivity() {
        return mForegroundActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.savedInstanceState = savedInstanceState;
        //设置Activity默认背景为null
        getWindow().setBackgroundDrawable(null);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        MyActivityManager.getInstance().pushOneActivity(this);
        // PushAgent.getInstance(this).onAppStart();
        baseApplication = (BaseApplication) getApplication();
        //   user = SharedPreferencesUtils.getUser(this);
        //底部返回虚拟键盘一直不显示
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE;
        window.setAttributes(params);
        StatusBarColorUntil.setStatusBarColor(this);
        initUI();
        ButterKnife.bind(this);

    }

    /**
     * 初始化UI
     */
    protected abstract void initUI();


    @Override
    protected void onResume() {
        super.onResume();
        this.mForegroundActivity = this;
        // MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        this.mForegroundActivity = null;
        // MobclickAgent.onPause(this);
        super.onPause();
    }

    /**
     * 隐藏键盘
     */
    protected void hideInputSoft() {
        if (getCurrentFocus() != null
                && getCurrentFocus().getWindowToken() != null) {
            InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            manager.hideSoftInputFromWindow(this.getCurrentFocus()
                    .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            hideInputSoft();
        }
        return super.onTouchEvent(event);
    }
}
