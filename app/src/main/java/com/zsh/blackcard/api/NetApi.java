package com.zsh.blackcard.api;

import android.content.Context;

import com.zsh.blackcard.model.EatDrinkDetailModel;
import com.zsh.blackcard.model.EatDrinkModel;
import com.zsh.blackcard.model.HjRecyclerModel;
import com.zsh.blackcard.model.HomeFoodModel;
import com.zsh.blackcard.model.HomeHotelModel;
import com.zsh.blackcard.model.HomeTitleNewsDetailModel;
import com.zsh.blackcard.model.HomeTitleNewsModel;
import com.zsh.blackcard.model.HomeTopModel;
import com.zsh.blackcard.model.HotelDetailModel;
import com.zsh.blackcard.model.LoginModel;
import com.zsh.blackcard.model.TrainModel;
import com.zsh.blackcard.model.ZgShopAreaModel;

import java.util.Map;

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

    /**
     * Home页面头条图片请求
     *
     * @param md5
     * @return
     */
    public Observable<HomeTopModel> postHomePage(String md5) {
        return retrofitService.postHomePage(md5);
    }

    /**
     * 尊购页面，所有专区的列表点击事件的子页面
     * @param md5
     * @param id
     * @return
     */
    public Observable<ZgShopAreaModel> postShopArea(String md5, String id) {
        return retrofitService.postShopArea(md5, id);
    }

    /**
     * 首页头条新闻标题
     * @param md5
     * @return
     */
    public Observable<HomeTitleNewsModel> postHomeTitleNews(String md5){
        return retrofitService.postHomeTitleNews(md5);
    }

    /**
     * 首页头条新闻点击详情
     * @param md5
     * @param id
     * @return
     */
    public Observable<HomeTitleNewsDetailModel> postHomeTitleNewsDetail(String md5,String id){
        return retrofitService.postHomeTitleNewsDetail(md5,id);
    }

    /**
     * 汇聚页面列表
     * @param md5
     * @return
     */
    public Observable<HjRecyclerModel> postHjRecycler(String md5){
        return retrofitService.postHjRecycler(md5);
    }

    public Observable<HomeFoodModel> postHomeFoodList(String md5) {
        return retrofitService.postHomeFoodList(md5);
    }

    public Observable<HomeHotelModel> postHomeHotelList(String md5) {
        return retrofitService.postHomeHotelList(md5);
    }

    public Observable<HotelDetailModel> postHotelDetail(String md5, String id) {
        return retrofitService.postHotelDetail(md5, id);
    }

    public Observable<TrainModel> postTrain(Map<String, String> map) {
        return retrofitService.postTrain(map);
    }

    /**
     * 汇聚页面指定聚会列表
     * @param md5
     * @param id
     * @return
     */
    public Observable<EatDrinkModel> postHjRecyclerItem(String md5,String id){
        return retrofitService.postHjRecyclerItem(md5,id);
    }

    /**
     * 汇聚页面指定聚会列表点击查看详情
     * @param md5
     * @param id
     * @return
     */
    public Observable<EatDrinkDetailModel> postHjRecyclerItemDetail(String md5,String id){
        return retrofitService.postHjRecyclerItemDetail(md5,id);
    }
}
