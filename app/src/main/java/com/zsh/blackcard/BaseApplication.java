package com.zsh.blackcard;

import android.app.Application;
import android.os.Handler;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.Volley;
import com.zsh.blackcard.untils.PackageUtils;
import com.zsh.blackcard.untils.SharedPreferencesUtils;
import com.zsh.blackcard.volley.SSLCertificateValidation;
import com.zsh.blackcard.volley.SelfSSLSocketFactory;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;

/**
 * @Author snxj .
 * @Date 2017/11/6
 * @Describe *
 */
public class BaseApplication extends Application {

    public static final String TOPBUYBILL = "topBuyBill";
    public static final String TOPSELLBILL = "topSellBill";
    public static final String QIANGDAN = "ID_APP_NOTIFICATION_ACTIVITY_QIANGDAN";
    public static final String BILL_NEW = "ID_APP_NOTIFICATION_BILL_NEW";
    public static final String BILL_LIST = "ID_APP_NOTIFICATION_BILL_LIST";
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

    /**
     * 创建http请求队列
     */
    private RequestQueue mRequestQueueWithHttp;
    /**
     * 创建自定义证书的Https请求队列
     */
    private RequestQueue mRequestQueueWithSelfCertifiedSsl;
    /**
     * 创建默认证书的Https请求队列
     */
    private RequestQueue mRequestQueueWithDefaultSsl;


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

    /**
     * 获取http请求队列
     *
     * @return
     */
    public RequestQueue getRequestQueueWithHttp() {
        if (mRequestQueueWithHttp == null) {
            // 创建普通的request
            mRequestQueueWithHttp = Volley
                    .newRequestQueue(getApplicationContext());
        }
        return mRequestQueueWithHttp;
    }

    /**
     * 获取默认证书https请求队列
     *
     * @return
     */
    public RequestQueue getRequestQueueWithDefaultSsl() {
        if (mRequestQueueWithDefaultSsl == null) {
            Network network = new BasicNetwork(new HurlStack());
            Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024);
            mRequestQueueWithDefaultSsl = new RequestQueue(cache, network);
            mRequestQueueWithDefaultSsl.start();
            SSLCertificateValidation.trustAllCertificate();
        }
        return mRequestQueueWithDefaultSsl;
    }

    /**
     * 获取自定义证书请求队列
     *
     * @return
     */
    public RequestQueue getRequestQueueWithSelfCertifiedSsl() {

        if (mRequestQueueWithSelfCertifiedSsl == null) {
            SSLSocketFactory sslSocketFactory = SelfSSLSocketFactory
                    .getSSLSocketFactory(getApplicationContext());
            Network network = new BasicNetwork(new HurlStack(null,
                    sslSocketFactory));
            Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024);
            mRequestQueueWithSelfCertifiedSsl = new RequestQueue(cache, network);
            mRequestQueueWithSelfCertifiedSsl.start();

            HttpsURLConnection
                    .setDefaultHostnameVerifier(new HostnameVerifier() {
                        @Override
                        public boolean verify(String hostname,
                                              SSLSession session) {
                            // 当URL的主机名和服务器的标识主机名不匹配默认返回true
                            return true;
                        }
                    });
        }
        return mRequestQueueWithSelfCertifiedSsl;
    }


}
