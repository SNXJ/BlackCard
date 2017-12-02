package com.zsh.blackcard;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.zsh.blackcard.untils.MPermissionUtils;
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
    private boolean isExit;
    private long exitTime = 0;
//    public LocationClient mLocationClient = null;
//    private MyLocationListener myListener = new MyLocationListener();

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

//        mLocationClient = new LocationClient(getApplicationContext());
//        //声明LocationClient类
//        mLocationClient.registerLocationListener(myListener);
//        //注册监听函数
//        LocationClientOption option = new LocationClientOption();
//        option.setIsNeedAddress(true);
//        mLocationClient.setLocOption(option);

    }

    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            //此处的BDLocation为定位结果信息类，通过它的各种get方法可获取定位相关的全部结果
            //以下只列举部分获取地址相关的结果信息
            //更多结果信息获取说明，请参照类参考中BDLocation类中的说明

            String addr = location.getAddrStr();    //获取详细地址信息
            String country = location.getCountry();    //获取国家
            String province = location.getProvince();    //获取省份
            String city = location.getCity();    //获取城市
            String district = location.getDistrict();    //获取区县
            String street = location.getStreet();    //获取街道信息
        }
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

    //权限
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        MPermissionUtils.onRequestPermissionsResult(requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            hideInputSoft();
        }
        return super.onTouchEvent(event);
    }


}
