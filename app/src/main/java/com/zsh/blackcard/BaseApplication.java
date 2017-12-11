package com.zsh.blackcard;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.multidex.MultiDex;
import android.util.Log;
import android.widget.Toast;

import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.crashreport.CrashReport;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.live.zego.ZegoApiManager;
import com.zsh.blackcard.music.untils.AppCache;
import com.zsh.blackcard.untils.PackageUtils;
import com.zsh.blackcard.untils.SharedPreferencesUtils;

/**
 * @Author snxj .
 * @Date 2017/11/6
 * @Describe *
 */
public class BaseApplication extends Application implements Thread.UncaughtExceptionHandler {
    public static final String TAG = BaseApplication.class.getSimpleName();
    Thread.UncaughtExceptionHandler mDefaultHandler;
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
        int versionCode = PackageUtils.getVersionVode();
        if (versionCode != getVersionCode()) {
            setFristStart(true);
        }
        ZegoApiManager.getInstance().initSDK();
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(this);
        Bugly.init(getApplicationContext(), BUGLY_ID, true);//是否开启debug模式，true表示打开debug模式，false表示关闭调试模式
        Beta.autoInit = true;//自动初始化
        strategy.setAppChannel(DataManager.APP_CHANNEL);
        AppCache.init(this);
    }


    public static String getHonouruserId() {
        return HONOURUSER_ID;
    }

    public static void setHonouruserId(String honouruserId) {
        HONOURUSER_ID = honouruserId;
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

    /**
     * 当UncaughtException发生时会转入该函数来处理
     */
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        if (!handleException(ex) && mDefaultHandler != null) {
            //如果用户没有处理则让系统默认的异常处理器来处理
            mDefaultHandler.uncaughtException(thread, ex);
        } else {
            try {
                // 暂停3秒
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Log.e(TAG, "error : ", e);
            }
            // 退出程序
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
    }

    /**
     * 自定义错误处理,收集错误信息 发送错误报告等操作均在此完成.
     *
     * @param ex
     * @return true:如果处理了该异常信息;否则返回false.
     */
    private boolean handleException(Throwable ex) {
        if (ex == null) {
            return false;
        }
        // 使用Toast来显示异常信息
        new Thread() {
            @Override
            public void run() {
                Looper.prepare();
                Toast.makeText(context, "程序出现异常，即将退出～", Toast.LENGTH_SHORT).show();
                Looper.loop();
            }
        }.start();

        return true;
    }

}
