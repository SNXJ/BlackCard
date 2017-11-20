package com.zsh.blackcard.service;

import com.zsh.blackcard.model.LoginModel;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by kkkkk on 2017/11/20.
 */

public interface RetrofitService {
    //"REGISTER20171120,fh,"
    @GET("appuserin/userregister?")
    Observable<LoginModel> getSearchBook(@QueryMap Map<String, String> map);
}
