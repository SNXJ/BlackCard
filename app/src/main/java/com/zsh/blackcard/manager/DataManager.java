package com.zsh.blackcard.manager;

import android.content.Context;

import com.zsh.blackcard.model.UserModel;
import com.zsh.blackcard.service.RetrofitService;
import com.zsh.blackcard.untils.RetrofitUtils;

import rx.Observable;

/**
 * Created by kkkkk on 2017/11/20.
 * 所有的网络请求都写在此处，调用
 */

public class DataManager {
    private RetrofitService retrofitService;

    public DataManager(Context context) {
        this.retrofitService = RetrofitUtils.getInstance(context).getService();
    }

    //例如。getSearchBook是在RetrofitService接口中声明的接口类型，参数类型。
    //1.先在RetrofitService中声明接口方法。
    //2.在本类写出该方法。在外部调用
    public Observable<UserModel> getSearchBook(String a, String b) {
        return retrofitService.getSearchBook(a, b);
    }
}
