package com.zsh.blackcard.api;

import android.content.Context;

import com.zsh.blackcard.BaseApplication;
import com.zsh.blackcard.custom.HomeTypeConstant;
import com.zsh.blackcard.model.AddressManageModel;
import com.zsh.blackcard.model.BarDetailModel;
import com.zsh.blackcard.model.BarDetailsMoreListModel;
import com.zsh.blackcard.model.BardetailsItemModel;
import com.zsh.blackcard.model.CategoryLeftModel;
import com.zsh.blackcard.model.CategoryRightModel;
import com.zsh.blackcard.model.CollectionModel;
import com.zsh.blackcard.model.CommentAddModel;
import com.zsh.blackcard.model.CommentModel;
import com.zsh.blackcard.model.EatDrinkDetailModel;
import com.zsh.blackcard.model.EatDrinkRecyclerModel;
import com.zsh.blackcard.model.FoodDetailModel;
import com.zsh.blackcard.model.FoodDetailsMoreListModel;
import com.zsh.blackcard.model.HjRecyclerModel;
import com.zsh.blackcard.model.HjReleaseModel;
import com.zsh.blackcard.model.HomeBarModel;
import com.zsh.blackcard.model.HomeCarDetailModel;
import com.zsh.blackcard.model.HomeCarRecyclerModel;
import com.zsh.blackcard.model.HomeCopterDetailModel;
import com.zsh.blackcard.model.HomeFoodDetailPackageModel;
import com.zsh.blackcard.model.HomeFoodModel;
import com.zsh.blackcard.model.HomeGloryMagazineModel;
import com.zsh.blackcard.model.HomeGloryMusicModel;
import com.zsh.blackcard.model.HomeGloryServerModel;
import com.zsh.blackcard.model.HomeGolfDetailModel;
import com.zsh.blackcard.model.HomeGolfRecyclerModel;
import com.zsh.blackcard.model.HomeHorseDetailModel;
import com.zsh.blackcard.model.HomeHorseRecyclerModel;
import com.zsh.blackcard.model.HomeHotelModel;
import com.zsh.blackcard.model.HomeKTVDetailItemModel;
import com.zsh.blackcard.model.HomeKTVDetailModel;
import com.zsh.blackcard.model.HomeKTVModel;
import com.zsh.blackcard.model.HomePlayModel;
import com.zsh.blackcard.model.HomePrivilegeModel;
import com.zsh.blackcard.model.HomeTitleNewsDetailModel;
import com.zsh.blackcard.model.HomeTitleNewsModel;
import com.zsh.blackcard.model.HomeTopModel;
import com.zsh.blackcard.model.HomeYachtDetailModel;
import com.zsh.blackcard.model.HomeYachtRecyclerModel;
import com.zsh.blackcard.model.HotelDetailModel;
import com.zsh.blackcard.model.HotelDetailsMoreListModel;
import com.zsh.blackcard.model.HoteldetailsItemModel;
import com.zsh.blackcard.model.KTVDetailsMoreListModel;
import com.zsh.blackcard.model.LiveInfoListModel;
import com.zsh.blackcard.model.LoginModel;
import com.zsh.blackcard.model.MyOrderModel;
import com.zsh.blackcard.model.OrderCenterBarRecyclerModel;
import com.zsh.blackcard.model.OrderCenterFoodRecyclerModel;
import com.zsh.blackcard.model.OrderCenterHotelRecyclerModel;
import com.zsh.blackcard.model.OrderCenterKTVRecyclerModel;
import com.zsh.blackcard.model.OrderResultModel;
import com.zsh.blackcard.model.ResultModel;
import com.zsh.blackcard.model.ShoppingCarModel;
import com.zsh.blackcard.model.TrainModel;
import com.zsh.blackcard.model.WelcomeModel;
import com.zsh.blackcard.model.ZgBannerModel;
import com.zsh.blackcard.model.ZgFindModel;
import com.zsh.blackcard.model.ZgFindTitleModel;
import com.zsh.blackcard.model.ZgPersonalTailorDetailModel;
import com.zsh.blackcard.model.ZgPersonalTailorModel;
import com.zsh.blackcard.model.ZgSearchModel;
import com.zsh.blackcard.model.ZgShopAreaModel;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
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
        return retrofitService.postHomeFoodList(md5, BaseApplication.HONOURUSER_ID);
    }

    /**
     * 酒店列表
     *
     * @param md5
     * @param
     * @return
     */
    public Observable<HomeHotelModel> postHomeHotelList(String md5) {
        return retrofitService.postHomeHotelList(md5, BaseApplication.HONOURUSER_ID);
    }

    /**
     * 酒店列表
     *
     * @param md5
     * @param
     * @return
     */
    public Observable<HomeBarModel> postHomeBarList(String md5) {
        return retrofitService.postHomeBarlList(md5, BaseApplication.HONOURUSER_ID);
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
     * 酒吧详情
     *
     * @param md5
     * @param id
     * @return
     */
    public Observable<BarDetailModel> postBarDetail(String md5, String id) {
        return retrofitService.postBarDetail(md5, id);
    }

    /**
     * 酒吧详情
     *
     * @param md5
     * @param id
     * @return
     */
    public Observable<BardetailsItemModel> postBarDetailList(String md5, String id) {
        return retrofitService.postBarDetailList(md5, id);
    }

    /**
     * 酒店评价列表
     *
     * @param id
     * @return
     */
    public Observable<CommentModel> postCommentList(String id, String type) {

        switch (type) {
            case HomeTypeConstant.MORE_TYPE_HOTEL:
                return retrofitService.postHotelCommentList(DataManager.getMd5Str("HOTELEVA"), id);
            case HomeTypeConstant.MORE_TYPE_FOOD:
                return retrofitService.postFoodCommentList(DataManager.getMd5Str("FOODEVA"), id);
            case HomeTypeConstant.MORE_TYPE_KTV:
                return retrofitService.postKTVCommentList(DataManager.getMd5Str("KTVEVA"), id);
            case HomeTypeConstant.MORE_TYPE_BAR:
                return retrofitService.postBarCommentList(DataManager.getMd5Str("BAREVA"), id);
            default:
                break;
        }
        return null;
    }

    /**
     * 添加评价
     *
     * @return
     */
    public Observable<CommentAddModel> postAddComment(Map<String, String> map, String type) {
        switch (type) {
            case HomeTypeConstant.MORE_TYPE_HOTEL:
                return retrofitService.addHotelComment(map);
            case HomeTypeConstant.MORE_TYPE_FOOD:
                return retrofitService.addFoodComment(map);
            case HomeTypeConstant.MORE_TYPE_KTV:
                return retrofitService.addKTVComment(map);
            case HomeTypeConstant.MORE_TYPE_BAR:
                return retrofitService.addBarComment(map);
        }
        return null;
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
     * 美食详情列表
     *
     * @param md5
     * @param id
     * @return
     */
    public Observable<HomeFoodDetailPackageModel> postFoodDetailList(String md5, String id) {
        return retrofitService.postFoodDetailList(md5, id);
    }

    /**
     * 美食详情更多列表
     *
     * @param md5
     * @param id
     * @return
     */
    public Observable<FoodDetailsMoreListModel> postFoodDetailMoreList(String md5, String id) {
        return retrofitService.postFoodDetailMoreList(md5, id);
    }

    /**
     * 酒店详情更多列表
     *
     * @param md5
     * @param id
     * @return
     */
    public Observable<HotelDetailsMoreListModel> postHotelDetailMoreList(String md5, String id) {
        return retrofitService.postHotelDetailMoreList(md5, id);
    }

    /**
     * KTV详情更多列表
     *
     * @param md5
     * @param id
     * @return
     */
    public Observable<KTVDetailsMoreListModel> postKTVDetailMoreList(String md5, String id) {
        return retrofitService.postKTVDetailMoreList(md5, id);
    }

    /**
     * 酒吧详情更多列表
     *
     * @param md5
     * @param id
     * @return
     */
    public Observable<BarDetailsMoreListModel> postBarDetailMoreList(String md5, String id) {
        return retrofitService.postBarDetailMoreList(md5, id);
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
     * Hotel订单
     *
     * @param map
     * @return
     */
    public Observable<OrderResultModel> postHotelOrder(Map<String, String> map) {
        return retrofitService.hotelOrder(map);
    }

    /**
     * ktv订单
     *
     * @param map
     * @return
     */
    public Observable<OrderResultModel> postKTVOrder(Map<String, String> map) {
        return retrofitService.KTVOrder(map);
    }

    /**
     * ktv订单
     *
     * @param map
     * @return
     */
    public Observable<OrderResultModel> postBarOrder(Map<String, String> map) {
        return retrofitService.BarOrder(map);
    }

    /**
     * 汇聚列表指定聚会页面
     *
     * @param md5
     * @param HONOURUSER_ID
     * @param CONVERGE_ID
     * @param STATUS
     * @return
     */
    public Observable<EatDrinkRecyclerModel> postEatDrinkRecycler(String md5, String HONOURUSER_ID, String CONVERGE_ID, String STATUS) {
        return retrofitService.postEatDrinkRecycler(md5, HONOURUSER_ID, CONVERGE_ID, STATUS);
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
     * 首页所有特权列表(仅马术，游艇，飞机，高尔夫，豪车)
     *
     * @param md5
     * @return
     */
    public Observable<HomePrivilegeModel> privilegePart(String md5, String id) {
        return retrofitService.privilegePart(md5, id);
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
     *
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
    public Observable<ResultModel> delAddress(String md5, String id) {
        return retrofitService.delAddress(md5, id);
    }

    /**
     * 添加地址管理
     *
     * @return
     */
    public Observable<ResultModel> addressAdd(Map<String, String> map) {
        return retrofitService.addressAdd(map);
    }

    /**
     * 编辑地址管理
     *
     * @return
     */
    public Observable<ResultModel> addressEdit(Map<String, String> map) {
        return retrofitService.addressEdit(map);
    }

    /**
     * 上传单张图片
     *
     * @param md5
     * @param userId
     * @param imgPath
     * @return
     */
    public Observable<ResultModel> upHeadIMG(String md5, String userId, String imgPath) {
        return retrofitService.uploadHead(md5, userId, DataManager.getMultiPart(DataManager.getMultBuilder(DataManager.initMultBuilder(), imgPath, "showfile")));
    }

    /**
     * 上传多张图片
     *
     * @param md5
     * @param userId
     * @param imgPathList
     * @return
     */
    public Observable<ResultModel> upLoadListIMG(String md5, String userId, List<String> imgPathList) {
        MultipartBody.Builder builder;
        builder = DataManager.initMultBuilder();
        for (int i = 0; i < imgPathList.size(); i++) {
            builder = DataManager.getMultBuilder(builder, imgPathList.get(i), "showfile");//showfile  有可能不一样
        }
        return retrofitService.uploadListIMG(md5, userId, DataManager.getMultiPartList(builder));
    }


    //   public Observable<ResultModel> upLoadListIMG(String md5, String userId, List<String> pathList) {
//        MultipartBody.Builder builder = new MultipartBody.Builder()
//                .setType(MultipartBody.FORM);//表单类型
//        //多张图片
//        for (int i = 0; i < pathList.size(); i++) {
//            File file = new File(pathList.get(i));//filePath 图片地址
//            RequestBody imageBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//            builder.addFormDataPart("showfile", file.getName(), imageBody);//"showfile 后台接收图片流的参数名（每张应该不同）
//        }
//        List<MultipartBody.Part> parts = builder.build().parts();
    //       return retrofitService.uploadListIMG(md5, userId, parts);
    //  }

    /**
     * 全部订单查询接口
     *
     * @param md5
     * @param id
     * @return
     */
    public Observable<MyOrderModel> postMyAllOrder(String md5, String id) {
        return retrofitService.postMyAllOrder(md5, id);
    }

    /**
     * 指定订单查询接口，如：查询待付款，待收货等。
     *
     * @param md5
     * @param id
     * @param state
     * @return
     */
    public Observable<MyOrderModel> postMyAppointOrder(String md5, String id, String state) {
        return retrofitService.postMyAppointOrder(md5, id, state);
    }

    /**
     * 商品分类左边列表
     *
     * @param md5
     * @return
     */
    public Observable<CategoryLeftModel> postCategoryLeft(String md5) {
        return retrofitService.postCategoryLeft(md5);
    }

    /**
     * 商品分类右边列表
     *
     * @param md5
     * @param id
     * @return
     */
    public Observable<CategoryRightModel> postCategoryRight(String md5, String id) {
        return retrofitService.postCategoryRight(md5, id);
    }

    /**
     * 获取欢迎引导页的轮播图片
     *
     * @param md5
     * @return
     */
    public Observable<WelcomeModel> postWelcome(String md5) {
        return retrofitService.postWelcome(md5);
    }

    /**
     * 购物车列表
     *
     * @param md5
     * @param id
     * @return
     */
    public Observable<ShoppingCarModel> postShoppingCar(String md5, String id) {
        return retrofitService.postShoppingCar(md5, id);
    }

    /**
     * 购物车删除商品
     *
     * @param md5
     * @param PRODUCT_ID
     * @param HONOURUSER_ID
     * @return
     */
    public Observable<ResultModel> postShoppingCarDelete(String md5, String PRODUCT_ID, String HONOURUSER_ID) {
        return retrofitService.postShoppingCarDelete(md5, PRODUCT_ID, HONOURUSER_ID);
    }

    /**
     * 获取尊购页面轮播图
     *
     * @param md5
     * @return
     */
    public Observable<ZgBannerModel> postZgBanner(String md5) {
        return retrofitService.postZgBanner(md5);
    }

    /**
     * 尊购模糊查询接口
     *
     * @param md5
     * @param HONOURUSER_ID
     * @param KEYWORDS
     * @return
     */
    public Observable<ZgSearchModel> postZgSearch(String md5, String HONOURUSER_ID, String KEYWORDS) {
        return retrofitService.postZgSearch(md5, HONOURUSER_ID, KEYWORDS);
    }

    /**
     * 首页汇聚玩趴图片接口
     *
     * @param md5
     * @return
     */
    public Observable<HomePlayModel> postHomePlay(String md5) {
        return retrofitService.postHomePlay(md5);
    }

    /**
     * 首页荣耀服务列表
     *
     * @param md5
     * @return
     */
    public Observable<HomeGloryServerModel> postHomeGloryServer(String md5) {
        return retrofitService.postHomeGloryServer(md5);
    }

    /**
     * 首页荣耀服务列表
     *
     * @param md5
     * @return
     */
    public Observable<HomeGloryMusicModel> postHomeGloryMusic(String md5) {
        return retrofitService.postHomeGloryMusic(md5);
    }

    /**
     * 首页KTV列表
     *
     * @param md5
     * @param user_id
     * @return
     */
    public Observable<HomeKTVModel> postHomeKTVRecycler(String md5, String user_id) {
        return retrofitService.postHomeKTVRecycler(md5, user_id);
    }

    /**
     * 首页高尔夫汇列表
     *
     * @param md5
     * @param user_id
     * @return
     */
    public Observable<HomeGolfRecyclerModel> postHomeGolfRecycler(String md5, String user_id) {
        return retrofitService.postHomeGolfRecycler(md5, user_id);
    }

    /**
     * 首页马术列表接口
     *
     * @param md5
     * @param user_id
     * @return
     */
    public Observable<HomeHorseRecyclerModel> postHomeHorseRecycler(String md5, String user_id) {
        return retrofitService.postHomeHorseRecycler(md5, user_id);
    }

    /**
     * 首页豪车列表接口
     *
     * @param md5
     * @param user_id
     * @return
     */
    public Observable<HomeCarRecyclerModel> postHomeCarRecycler(String md5, String user_id) {
        return retrofitService.postHomeCarRecycler(md5, user_id);
    }

    /**
     * 首页游艇列表接口
     *
     * @param md5
     * @param user_id
     * @return
     */
    public Observable<HomeYachtRecyclerModel> postHomeYachtRecycler(String md5, String user_id) {
        return retrofitService.postHomeYachtRecycler(md5, user_id);
    }

    /**
     * 高尔夫汇详情
     *
     * @param md5
     * @param golf_id
     * @return
     */
    public Observable<HomeGolfDetailModel> postHomeGolfDetail(String md5, String golf_id) {
        return retrofitService.postHomeGolfDetail(md5, golf_id);
    }

    /**
     * 马术详情
     *
     * @param md5
     * @param horse_id
     * @return
     */
    public Observable<HomeHorseDetailModel> postHomeHorseDetail(String md5, String horse_id) {
        return retrofitService.postHomeHorseDetail(md5, horse_id);
    }

    /**
     * 豪车详情接口
     *
     * @param md5
     * @param car_id
     * @return
     */
    public Observable<HomeCarDetailModel> postHomeCarDetail(String md5, String car_id) {
        return retrofitService.postHomeCarDetail(md5, car_id);
    }

    /**
     * 游艇详情接口
     *
     * @param md5
     * @param yacht_id
     * @return
     */
    public Observable<HomeYachtDetailModel> postHomeYachtDetail(String md5, String yacht_id) {
        return retrofitService.postHomeYachtDetail(md5, yacht_id);
    }

    /**
     * 飞机详情接口
     *
     * @param md5
     * @return
     */
    public Observable<HomeCopterDetailModel> postHomeCopterDetail(String md5) {
        return retrofitService.postHomeCopterDetail(md5);
    }

    /**
     * 首页荣耀服务列表详情点击
     *
     * @param md5
     * @param server_id
     * @return
     */
    public Observable<Object> postHomeGloryHorseDetail(String md5, String server_id) {
        return retrofitService.postHomeGloryHorseDetail(md5, server_id);
    }

    /**
     * 我的订单 点击确认收货，修改订单为待评价
     *
     * @param md5
     * @param ORDERNUMBER
     * @param HONOURUSER_ID
     * @param ORDERSTATUS
     * @return
     */
    public Observable<ResultModel> postMyOrderOk(String md5, String ORDERNUMBER, String HONOURUSER_ID, String ORDERSTATUS) {
        return retrofitService.postMyOrderOk(md5, ORDERNUMBER, HONOURUSER_ID, ORDERSTATUS);
    }

    /**
     * 订单中心酒吧全部订单查询
     *
     * @param md5
     * @param HONOURUSER_ID
     * @return
     */
    public Observable<OrderCenterBarRecyclerModel> postOrderCenterBarRecycler(String md5, String HONOURUSER_ID, String ORDERSTATUS) {
        return retrofitService.postOrderCenterBarRecycler(md5, HONOURUSER_ID, ORDERSTATUS);
    }

    /**
     * 订单中心KTV全部订单查询
     *
     * @param md5
     * @param HONOURUSER_ID
     * @param ORDERSTATUS
     * @return
     */
    public Observable<OrderCenterKTVRecyclerModel> postOrderCenterKTVRecycler(String md5, String HONOURUSER_ID, String ORDERSTATUS) {
        return retrofitService.postOrderCenterKTVRecycler(md5, HONOURUSER_ID, ORDERSTATUS);
    }

    /**
     * 订单中心酒店全部订单查询
     *
     * @param md5
     * @param HONOURUSER_ID
     * @param ORDERSTATUS
     * @return
     */
    public Observable<OrderCenterHotelRecyclerModel> postOrderCenterHotelRecycler(String md5, String HONOURUSER_ID, String ORDERSTATUS) {
        return retrofitService.postOrderCenterHotelRecycler(md5, HONOURUSER_ID, ORDERSTATUS);
    }

    /**
     * 订单中心美食全部订单查询
     *
     * @param md5
     * @param HONOURUSER_ID
     * @param ORDERSTATUS
     * @return
     */
    public Observable<OrderCenterFoodRecyclerModel> postOrderCenterFoodRecycler(String md5, String HONOURUSER_ID, String ORDERSTATUS) {
        return retrofitService.postOrderCenterFoodRecycler(md5, HONOURUSER_ID, ORDERSTATUS);
    }

    /**
     * 尊购订单状态修改
     *
     * @param md5
     * @param HONOURUSER_ID
     * @param ORDERNUMBER
     * @param ORDERSTATUS
     * @return
     */
    public Observable<ResultModel> postZgChange(String md5, String HONOURUSER_ID, String ORDERNUMBER, String ORDERSTATUS) {
        return retrofitService.postZgChange(md5, HONOURUSER_ID, ORDERNUMBER, ORDERSTATUS);
    }

    /**
     * 美食筛选
     */
    public Observable<HomeFoodModel> filterFoodList(Map<String, String> map) {
        return retrofitService.filterFoodList(map);
    }

    /**
     * 酒店筛选
     *
     * @param map
     * @return
     */
    public Observable<HomeHotelModel> filterHotelList(Map<String, String> map) {
        return retrofitService.filterHotelList(map);
    }

    /**
     * KTV筛选
     *
     * @param map
     * @return
     */

    public Observable<HomeKTVModel> filterKTVList(Map<String, String> map) {
        return retrofitService.filterKTVList(map);
    }

    /**
     * 酒吧筛选
     *
     * @param map
     * @return
     */
    public Observable<HomeBarModel> filterBarList(Map<String, String> map) {
        return retrofitService.filterBarList(map);
    }

    public Observable<LiveInfoListModel> pullLive(String appid) {
        return retrofitService.pullLive(appid);
    }

    /**
     * 首页荣耀杂志列表
     *
     * @param md5
     * @return
     */
    public Observable<HomeGloryMagazineModel> postHomeGloryMagazine(String md5) {
        return retrofitService.postHomeGloryMagazine(md5);
    }

    /**
     * 尊购发现菜单选项
     *
     * @param md5
     * @return
     */
    public Observable<ZgFindTitleModel> postZgFindTiele(String md5) {
        return retrofitService.postZgFindTiele(md5);
    }

    /**
     * 尊购发现页面条目对应列表
     *
     * @param md5
     * @param id
     * @return
     */
    public Observable<ZgFindModel> postZgFind(String md5, String id) {
        return retrofitService.postZgFind(md5, id);
    }
}
