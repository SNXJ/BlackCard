package com.zsh.blackcard.api;

import com.zsh.blackcard.model.LoginModel;
import com.zsh.blackcard.model.RegisterModel;

import java.util.Map;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by kkkkk on 2017/11/20.
 */

public interface RetrofitService {

    //卡号密码登录接口  post请求必须添加以下这行代码。否则会报错。
    @FormUrlEncoded
    @POST("appuserin/userlogincard?")
    Observable<LoginModel> postLoginCard(@Field("FKEY") String md5,
                                         @Field("CARDNO") String cardNo,
                                         @Field("PASSWORD") String passWord);

    //注册接口
    @GET("appuserin/userregister?")
    Observable<RegisterModel> getSearchBook(@QueryMap Map<String, String> map);

    //首页接口
    @POST("apphomein/getrecommendlist?")
    Observable<RegisterModel> getHomePage(@QueryMap Map<String, String> map);

}
