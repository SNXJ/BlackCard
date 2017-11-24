package com.zsh.blackcard.api;

import android.content.Context;

import com.zsh.blackcard.model.CollectionModel;
import com.zsh.blackcard.model.AddressDelModel;
import com.zsh.blackcard.model.AddressEditModel;
import com.zsh.blackcard.model.AddressManageModel;
import com.zsh.blackcard.model.CommentAddModel;
import com.zsh.blackcard.model.CommentModel;
import com.zsh.blackcard.model.EatDrinkDetailModel;
import com.zsh.blackcard.model.EatDrinkModel;
import com.zsh.blackcard.model.FoodDetailModel;
import com.zsh.blackcard.model.HjRecyclerModel;
import com.zsh.blackcard.model.HjReleaseModel;
import com.zsh.blackcard.model.HomeFoodModel;
import com.zsh.blackcard.model.HomeHotelModel;
import com.zsh.blackcard.model.HomePrivilegeModel;
import com.zsh.blackcard.model.HomeKTVDetailItemModel;
import com.zsh.blackcard.model.HomeKTVDetailModel;
import com.zsh.blackcard.model.HomeTitleNewsDetailModel;
import com.zsh.blackcard.model.HomeTitleNewsModel;
import com.zsh.blackcard.model.HomeTopModel;
import com.zsh.blackcard.model.HotelDetailModel;
import com.zsh.blackcard.model.HoteldetailsItemModel;
import com.zsh.blackcard.model.LoginModel;
import com.zsh.blackcard.model.TrainModel;
import com.zsh.blackcard.model.ZgPersonalTailorDetailModel;
import com.zsh.blackcard.model.ZgPersonalTailorModel;
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
     *
     * @param md5
     * @param id
     * @return
     */
    public Observable<ZgShopAreaModel> postShopArea(String md5, String id) {
        return retrofitService.postShopArea(md5, id);
    }

    /**
     * 首页头条新闻标题
     *
     * @param md5
     * @return
     */
    public Observable<HomeTitleNewsModel> postHomeTitleNews(String md5) {
        return retrofitService.postHomeTitleNews(md5);
    }

    /**
     * 首页头条新闻点击详情
     *
     * @param md5
     * @param id
     * @return
     */
    public Observable<HomeTitleNewsDetailModel> postHomeTitleNewsDetail(String md5, String id) {
        return retrofitService.postHomeTitleNewsDetail(md5, id);
    }

    /**
     * 汇聚页面列表
     *
     * @param md5
     * @return
     */
    public Observable<HjRecyclerModel> postHjRecycler(String md5) {
        return retrofitService.postHjRecycler(md5);
    }

    /**
     * 美食列表
     *
     * @param md5
     * @return
     */
    public Observable<HomeFoodModel> postHomeFoodList(String md5) {
        return retrofitService.postHomeFoodList(md5);
    }

    /**
     * 酒店列表
     *
     * @param md5
     * @param
     * @return
     */
    public Observable<HomeHotelModel> postHomeHotelList(String md5) {
        return retrofitService.postHomeHotelList(md5);
    }

    /**
     * 美食详情
     *
     * @param md5
     * @param id
     * @return
     */
    public Observable<FoodDetailModel> postFoodDetail(String md5, String id) {
        return retrofitService.postFoodDetail(md5, id);
    }

    /**
     * 酒店详情
     *
     * @param md5
     * @param id
     * @return
     */
    public Observable<HotelDetailModel> postHotelDetail(String md5, String id) {
        return retrofitService.postHotelDetail(md5, id);
    }

    /**
     * 酒店评价列表
     *
     * @param md5
     * @param id
     * @return
     */
    public Observable<CommentModel> postCommentList(String md5, String id) {
        return retrofitService.postCommentList(md5, id);
    }

    /**
     * 酒店评价列表
     *
     * @return
     */
    public Observable<CommentAddModel> postAddComment(Map<String, String> map) {
        return retrofitService.addComment(map);
    }

    /**
     * 详情
     *
     * @param md5
     * @param id
     * @return
     */
    public Observable<HomeKTVDetailModel> postKTVDetail(String md5, String id) {
        return retrofitService.postKTVDetail(md5, id);
    }

    /**
     * 详情列表
     *
     * @param md5
     * @param id
     * @return
     */
    public Observable<HomeKTVDetailItemModel> postHTKDetailList(String md5, String id) {
        return retrofitService.postKTVDetailList(md5, id);
    }


    /**
     * 酒店详情列表
     *
     * @param md5
     * @param id
     * @return
     */
    public Observable<HoteldetailsItemModel> postHotelDetailList(String md5, String id) {
        return retrofitService.postHotelDetailList(md5, id);
    }

    /**
     * 火车票
     *
     * @param map
     * @return
     */
    public Observable<TrainModel> postTrain(Map<String, String> map) {
        return retrofitService.postTrain(map);
    }

    /**
     * 汇聚页面指定聚会列表
     *
     * @param md5
     * @param id
     * @return
     */
    public Observable<EatDrinkModel> postHjRecyclerItem(String md5, String id) {
        return retrofitService.postHjRecyclerItem(md5, id);
    }

    /**
     * 汇聚页面指定聚会列表点击查看详情
     *
     * @param md5
     * @param id
     * @return
     */
    public Observable<EatDrinkDetailModel> postHjRecyclerItemDetail(String md5, String id) {
        return retrofitService.postHjRecyclerItemDetail(md5, id);
    }

    /**
     * 汇聚活动发布
     *
     * @param map
     * @return
     */
    public Observable<HjReleaseModel> postHjRelease(Map<String, String> map) {
        return retrofitService.postHjRelease(map);
    }

    /**
     * 首页所有特权列表
     *
     * @param md5
     * @return
     */
    public Observable<HomePrivilegeModel> postHomePrivilege(String md5) {
        return retrofitService.postHomePrivilege(md5);
    }

    /**
     * 尊购侧滑界面私人定制列表
     *
     * @param md5
     * @return
     */
    public Observable<ZgPersonalTailorModel> postZgPersonalTailorModel(String md5) {
        return retrofitService.postZgPersonalTailorModel(md5);
    }

    /**
     * 尊购侧滑界面私人定制列表中的item详情页面
     *
     * @param md5
     * @param id
     * @return
     */
    public Observable<ZgPersonalTailorDetailModel> postZgPersonalTailorDetail(String md5, String id) {
        return retrofitService.postZgPersonalTailorDetail(md5, id);
    }

    /**
     * 炫购收藏列表
     * @param md5
     * @param id
     * @return
     */
    public Observable<CollectionModel> postCollection(String md5, String id) {
        return retrofitService.postCollection(md5, id);
    }

    /**
     * 地址管理
     *
     * @param md5
     * @param id
     * @return
     */
    public Observable<AddressManageModel> postAddressManage(String md5, String id) {
        return retrofitService.postAddressManage(md5, id);
    }

    /**
     * 删除地址管理
     *
     * @param md5
     * @param id
     * @return
     */
    public Observable<AddressDelModel> delAddress(String md5, String id) {
        return retrofitService.delAddress(md5, id);
    }

    /**
     * 添加地址管理
     *
     * @return
     */
    public Observable<AddressDelModel> addressAdd(Map<String, String> map) {
        return retrofitService.addressAdd(map);
    }

    /**
     * 编辑地址管理
     *
     * @return
     */
    public Observable<AddressDelModel> addressEdit(Map<String, String> map) {
        return retrofitService.addressEdit(map);
    }
}
