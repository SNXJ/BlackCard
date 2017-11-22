package com.zsh.blackcard.api;

import com.zsh.blackcard.model.HjRecyclerModel;
import com.zsh.blackcard.model.HomeTitleNewsDetailModel;
import com.zsh.blackcard.model.HomeTitleNewsModel;
import com.zsh.blackcard.model.HomeFoodModel;
import com.zsh.blackcard.model.HomeHotelModel;
import com.zsh.blackcard.model.HomeTopModel;
import com.zsh.blackcard.model.HotelDetailModel;
import com.zsh.blackcard.model.LoginModel;
import com.zsh.blackcard.model.RegisterModel;
import com.zsh.blackcard.model.ZgShopAreaModel;
import com.zsh.blackcard.model.TrainModel;

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

    //首页接口
    @FormUrlEncoded
    @POST("apphomein/getrecommendlist?")
    Observable<HomeTopModel> postHomePage(@Field("FKEY") String md5);

    //注册接口
    @GET("appuserin/userregister?")
    Observable<RegisterModel> getSearchBook(@QueryMap Map<String, String> map);

    //商品专区列表页面。
    @FormUrlEncoded
    @POST("appshipin/shipprefecture?")
    Observable<ZgShopAreaModel> postShopArea(@Field("FKEY") String md5,
                                             @Field("BRAND_ID") String id);

    //首页头条滚动文字
    @FormUrlEncoded
    @POST("apphomein/getnewslist?")
    Observable<HomeTitleNewsModel> postHomeTitleNews(@Field("FKEY") String md5);

    //首页头条滚动文字点击详情
    @FormUrlEncoded
    @POST("apphomein/getnewsdet?")
    Observable<HomeTitleNewsDetailModel> postHomeTitleNewsDetail(@Field("FKEY") String md5,
                                                                 @Field("NEWS_ID") String id);

    //汇聚页面列表
    @FormUrlEncoded
    @POST("appconvergein/convergelist?")
    Observable<HjRecyclerModel> postHjRecycler(@Field("FKEY")String md5);
    //首页美食
    @FormUrlEncoded
    @POST("appsfoodin/sfood?")
    Observable<HomeFoodModel> postHomeFoodList(@Field("FKEY") String md5);

    //首页酒店
    @FormUrlEncoded
    @POST("appshotelin/shotel.do?")
    Observable<HomeHotelModel> postHomeHotelList(@Field("FKEY") String md5);

    //酒店详情
    @FormUrlEncoded
    @POST("appshotelin/hotelsyn?")
    Observable<HotelDetailModel> postHotelDetail(@Field("FKEY") String md5, @Field("SORTHOTEL_ID") String id);

    //火车票
    @FormUrlEncoded
    @POST("apppersonalin/trainselect?")
    Observable<TrainModel> postTrain(@QueryMap Map<String, String> map);
}
