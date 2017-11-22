package com.zsh.blackcard.api;

import android.content.Context;

import com.zsh.blackcard.model.HomeTopModel;
import com.zsh.blackcard.model.LoginModel;

import rx.Observable;

/**
 * @Author snxj .
 * @Date 2017/11/6
 * @Describe *
 */
public class NetApi {
    private static RetrofitService retrofitService;
    private static NetApi netApi;

    public static NetApi getInstance(Context context) {
        retrofitService = RetrofitUtils.getInstance(context).getService();
        if (netApi == null) {
            netApi = new NetApi();
        }
        return netApi;
    }

    /**
     * 卡号密码登录
     *
     * @param cardNo   卡号
     * @param passWord 密码
     * @return
     */
    public Observable<LoginModel> postLoginCard(String md5, String cardNo, String passWord) {
        return retrofitService.postLoginCard(md5, cardNo, passWord);
    }

    public Observable<HomeTopModel> postHomePage(String md5){
        return retrofitService.postHomePage(md5);
    }
}
