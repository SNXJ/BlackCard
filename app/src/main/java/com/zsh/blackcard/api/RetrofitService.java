package com.zsh.blackcard.api;

import com.zsh.blackcard.model.LoginModel;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by kkkkk on 2017/11/20.
 */

public interface RetrofitService {

    @GET("appuserin/userregister?")
    Observable<LoginModel> getSearchBook(@QueryMap Map<String, String> map);

    @POST("apphomein/getrecommendlist?")
    Observable<LoginModel> getHomePage(@QueryMap Map<String, String> map);

}
