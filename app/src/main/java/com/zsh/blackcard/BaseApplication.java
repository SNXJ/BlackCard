package com.zsh.blackcard;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.support.multidex.MultiDex;

import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
import com.zsh.blackcard.untils.PackageUtils;
import com.zsh.blackcard.untils.SharedPreferencesUtils;

/**
 * @Author snxj .
 * @Date 2017/11/6
 * @Describe *
 */
public class BaseApplication extends Application {
    public static String HONOURUSER_ID = "d6a3779de8204dfd9359403f54f7d27c";//temp
    private String BUGLY_ID = "815c4ef8fb";
    /* 获取主线程的上下文对象 */
    private static BaseApplication context;
    /* 获取主线程ID */
    private static int mMainThreadId;
    /* 获取到主线程的Handler */
    private static Handler mainThreadHandler;
    private static BaseApplication instance;
    private static final String FRISTSTART = "friststart";// 第一次启动
    private static final String VERSIONCODE = "versionCode";// versionCode
    private static final String LOGIN = "loginTag";// 登陆
    private static final String EXIT = "exit";// 退出
    private static final String HSAPAYPWD = "haspsypwd";// 支付密码


    public static BaseApplication getInstance() {
        return instance;
    }

    /* 对外暴露上下文对象 */
    public static BaseApplication getApplication() {
        return context;
    }

    /* 对外暴露主线程的ID */
    public static int getMainThreadId() {
        return mMainThreadId;
    }

    /* 对外暴露主线程的handler */
    public static Handler getMainThreadHandler() {
        return mainThreadHandler;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onCreate() {
        super.onCreate();
        this.context = this;
        instance = this;
        // mInstance = this ;
        int versionCode = PackageUtils.getVersionVode();

        if (versionCode != getVersionCode()) {
            setFristStart(true);
        }
        //  CrashReport.initCrashReport(getApplicationContext(), BUGLY_ID, true);//测试True 发布false
        Bugly.init(getApplicationContext(), BUGLY_ID, false);//是否开启debug模式，true表示打开debug模式，false表示关闭调试模式
        Beta.autoInit = true;//自动初始化

    }

    public boolean isFristStart() {
        return SharedPreferencesUtils
                .getBooleanData(context, FRISTSTART, false);
    }

    /**
     * 设置第一次启动
     *
     * @param fristStart
     */
    public void setFristStart(boolean fristStart) {
        SharedPreferencesUtils.putBooleanData(context, FRISTSTART, fristStart);
    }

    /**
     * 版本号
     */
    public int getVersionCode() {
        return SharedPreferencesUtils.getIntData(context, VERSIONCODE, -1);
    }

    public void setVersionCode(int versionCode) {
        SharedPreferencesUtils.putIntData(context, VERSIONCODE, versionCode);
    }

    /**
     * 保存登陆
     *
     * @param loginTag
     */
    public void setLoginTag(boolean loginTag) {
        SharedPreferencesUtils.putBooleanData(context, LOGIN, loginTag);
    }

    public boolean isLogin() {
        return SharedPreferencesUtils.getBooleanData(context, LOGIN, false);
    }

    /**
     * 是否退出登录
     *
     * @param exitTag
     */
    public void setExitTag(boolean exitTag) {
        SharedPreferencesUtils.putBooleanData(context, EXIT, exitTag);
    }

    public boolean isExit() {
        return SharedPreferencesUtils.getBooleanData(context, EXIT, false);
    }


    public void clearUser() {
        String[] data = {"user", "phone", "password", LOGIN};
        SharedPreferencesUtils.clearObjectData(data);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // you must install multiDex whatever tinker is installed!
        MultiDex.install(base);
        // 安装tinker
        Beta.installTinker();
    }

}
