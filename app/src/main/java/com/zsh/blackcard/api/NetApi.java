package com.zsh.blackcard.api;

import android.content.Context;

import com.zsh.blackcard.model.LoginModel;
import com.zsh.blackcard.model.RegisterModel;
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
        if (instance == null) {
            instance = new NetApi();
        }
        retrofitService = RetrofitUtils.getInstance(context).getService();
        return instance;
    }

    /**
     * @param map
     * @return
     */
    public Observable<RegisterModel> getSearchBook(final Map<String, String> map) {
        return retrofitService.getSearchBook(map);
    }

    /**
     * @param map
     * @return
     */
    public Observable<RegisterModel> getBook(final Map<String, String> map) {
        return retrofitService.getHomePage(map);
    }

    /**
     * 卡号密码登录
     * @param mad5 混淆码
     * @param cardNo 卡号
     * @param passWord 密码
     * @return
     */
    public Observable<LoginModel> postLoginCard(String md5, String cardNo, String passWord){
        return retrofitService.postLoginCard(md5, cardNo, passWord);
    }
}
