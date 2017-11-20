package com.zsh.blackcard.api;

import android.content.Context;

import com.zsh.blackcard.model.LoginModel;
import com.zsh.blackcard.untils.RetrofitUtils;

import java.util.Map;

import rx.Observable;

/**
 * @Author snxj .
 * @Date 2017/11/6
 * @Describe *
 */
public class NetApi {
    private static RetrofitService retrofitService;
    private static NetApi instance;

    public static NetApi getInstance(Context context) {
        retrofitService = RetrofitUtils.getInstance(context).getService();
        if (instance == null) {
            instance = new NetApi();
        }
        return instance;
    }

    /**
     * @param map
     * @return
     */
    public static Observable<LoginModel> getSearchBook(final Map<String, String> map) {
        return retrofitService.getSearchBook(map);
    }
    /**
     * @param map
     * @return
     */
    public static Observable<LoginModel> getBook(final Map<String, String> map) {
        return retrofitService.getHomePage(map);
    }


}
