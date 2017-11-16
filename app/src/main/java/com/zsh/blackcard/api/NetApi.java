package com.zsh.blackcard.api;

import android.content.Context;

import com.zsh.blackcard.volley.NetUntil;
import com.zsh.blackcard.volley.ResponseListener;

import java.util.Map;
/**
 * @Author snxj .
 * @Date 2017/11/6
 * @Describe *
 */
public class NetApi {
    /**
     * 测试
     */
//	public static final String SERVER_URL = "https://";
    /**
     * 发版
     */
    public static final String SERVER_URL = "https://";

    /**
     * HTTP POST
     *
     * @param <T>
     * @param mContext
     * @param url
     * @param paramsMap
     * @param clz              MODEL
     * @param responseListener
     */
    public static <T> void doPost(Context mContext, String url,
                                  Map<String, String> paramsMap, final Class<T> clz,
                                  final ResponseListener<T> responseListener) {
        NetUntil.newInstance(mContext).doPostHttp(SERVER_URL + url, paramsMap, clz, responseListener);
    }

    /**
     * HTTP GET
     *
     * @param <T>
     * @param mContext
     * @param url
     * @param paramsMap
     * @param clz              MODEL
     * @param responseListener
     */
    @SuppressWarnings("unused")
    private static <T> void doGet(Context mContext, String url,
                                  Map<String, String> paramsMap, final Class<T> clz,
                                  final ResponseListener<T> responseListener) {
        NetUntil.newInstance(mContext).doGetHttp(SERVER_URL + url, paramsMap,
                clz, responseListener);
    }

}
