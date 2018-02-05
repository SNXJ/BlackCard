package com.zsh.blackcard.api;

import com.luck.picture.lib.entity.LocalMedia;
import com.zsh.blackcard.BaseApplication;
import com.zsh.blackcard.custom.HomeTypeConstant;
import com.zsh.blackcard.model.*;

import java.io.File;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import rx.Observable;

/**
 * @Author snxj .
 * @Date 2017/11/6
 * @Describe *
 */
public class NetApi extends DataManager {
    /**
     * 卡号密码登录
     *
     * @param cardNo   卡号
     * @param passWord 密码
     * @return
     */
    public static Observable<LoginModel> postLoginCard(String md5, String cardNo, String passWord) {
        return retrofitService.postLoginCard(md5, cardNo, passWord);
    }

    /**
     * Home页面头条图片请求
     *
     * @param md5
     * @return
     */
    public static Observable<HomeTopModel> postHomePage(String md5) {
        return retrofitService.postHomePage(md5);
    }

    /**
     * 尊购页面，所有专区的列表点击事件的子页面
     *
     * @param md5
     * @param id
     * @return
     */
    public static Observable<ZgShopAreaModel> postShopArea(String md5, String id) {
        return retrofitService.postShopArea(md5, id);
    }

    /**
     * 首页头条新闻标题
     *
     * @param md5
     * @return
     */
    public static Observable<HomeTitleNewsModel> postHomeTitleNews(String md5) {
        return retrofitService.postHomeTitleNews(md5);
    }

    /**
     * 首页头条新闻点击详情
     *
     * @param md5
     * @param id
     * @return
     */
    public static Observable<HomeTitleNewsDetailModel> postHomeTitleNewsDetail(String md5, String id) {
        return retrofitService.postHomeTitleNewsDetail(md5, id);
    }

    /**
     * 汇聚页面列表
     *
     * @param md5
     * @return
     */
    public static Observable<HjRecyclerModel> postHjRecycler(String md5) {
        return retrofitService.postHjRecycler(md5);
    }

    /**
     * 美食列表
     *
     * @param md5
     * @return
     */
    public static Observable<HomeFoodModel> postHomeFoodList(String md5) {
        return retrofitService.postHomeFoodList(md5, BaseApplication.HONOURUSER_ID);
    }

    /**
     * 酒店列表
     *
     * @param md5
     * @param
     * @return
     */
    public static Observable<HomeHotelModel> postHomeHotelList(String md5) {
        return retrofitService.postHomeHotelList(md5, BaseApplication.HONOURUSER_ID);
    }

    /**
     * 酒店列表
     *
     * @param md5
     * @param
     * @return
     */
    public static Observable<HomeBarModel> postHomeBarList(String md5) {
        return retrofitService.postHomeBarlList(md5, BaseApplication.HONOURUSER_ID);
    }

    /**
     * 美食详情
     *
     * @param md5
     * @param id
     * @return
     */
    public static Observable<FoodDetailModel> postFoodDetail(String md5, String id) {
        return retrofitService.postFoodDetail(md5, id);
    }

    /**
     * 酒店详情
     *
     * @param md5
     * @param id
     * @return
     */
    public static Observable<HotelDetailModel> postHotelDetail(String md5, String id) {
        return retrofitService.postHotelDetail(md5, id);
    }

    /**
     * 酒吧详情
     *
     * @param md5
     * @param id
     * @return
     */
    public static Observable<BarDetailModel> postBarDetail(String md5, String id) {
        return retrofitService.postBarDetail(md5, id);
    }

    /**
     * 酒吧详情
     *
     * @param md5
     * @param id
     * @return
     */
    public static Observable<BardetailsItemModel> postBarDetailList(String md5, String id) {
        return retrofitService.postBarDetailList(md5, id);
    }

    /**
     * 酒店评价列表
     *
     * @param id
     * @return
     */
    public static Observable<CommentModel> postCommentList(String id, String type) {

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
    public static Observable<CommentAddModel> postAddComment(Map<String, String> map, String type) {
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
    public static Observable<HomeKTVDetailModel> postKTVDetail(String md5, String id) {
        return retrofitService.postKTVDetail(md5, id);
    }

    /**
     * 详情列表
     *
     * @param md5
     * @param id
     * @return
     */
    public static Observable<HomeKTVDetailItemModel> postHTKDetailList(String md5, String id) {
        return retrofitService.postKTVDetailList(md5, id);
    }


    /**
     * 酒店详情列表
     *
     * @param md5
     * @param id
     * @return
     */
    public static Observable<HoteldetailsItemModel> postHotelDetailList(String md5, String id) {
        return retrofitService.postHotelDetailList(md5, id);
    }

    /**
     * 美食详情列表
     *
     * @param md5
     * @param id
     * @return
     */
    public static Observable<HomeFoodDetailPackageModel> postFoodDetailList(String md5, String id) {
        return retrofitService.postFoodDetailList(md5, id);
    }

    /**
     * 美食详情更多列表
     *
     * @param md5
     * @param id
     * @return
     */
    public static Observable<FoodDetailsMoreListModel> postFoodDetailMoreList(String md5, String id) {
        return retrofitService.postFoodDetailMoreList(md5, id);
    }

    /**
     * 酒店详情更多列表
     *
     * @param md5
     * @param id
     * @return
     */
    public static Observable<HotelDetailsMoreListModel> postHotelDetailMoreList(String md5, String id) {
        return retrofitService.postHotelDetailMoreList(md5, id);
    }

    /**
     * KTV详情更多列表
     *
     * @param md5
     * @param id
     * @return
     */
    public static Observable<KTVDetailsMoreListModel> postKTVDetailMoreList(String md5, String id) {
        return retrofitService.postKTVDetailMoreList(md5, id);
    }

    /**
     * 酒吧详情更多列表
     *
     * @param md5
     * @param id
     * @return
     */
    public static Observable<BarDetailsMoreListModel> postBarDetailMoreList(String md5, String id) {
        return retrofitService.postBarDetailMoreList(md5, id);
    }

    /**
     * 火车票
     *
     * @param map
     * @return
     */
    public static Observable<TrainModel> postTrain(Map<String, String> map) {
        return retrofitService.postTrain(map);
    }

    /**
     * Hotel订单
     *
     * @param map
     * @return
     */
    public static Observable<OrderResultModel> postHotelOrder(Map<String, String> map) {
        return retrofitService.hotelOrder(map);
    }

    /**
     * ktv订单
     *
     * @param map
     * @return
     */
    public static Observable<OrderResultModel> postKTVOrder(Map<String, String> map) {
        return retrofitService.KTVOrder(map);
    }

    /**
     * ktv订单
     *
     * @param map
     * @return
     */
    public static Observable<OrderResultModel> postBarOrder(Map<String, String> map) {
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
    public static Observable<EatDrinkRecyclerModel> postEatDrinkRecycler(String md5, String HONOURUSER_ID, String CONVERGE_ID, String STATUS, String CONVERGESORT_ID) {
        return retrofitService.postEatDrinkRecycler(md5, HONOURUSER_ID, CONVERGE_ID, STATUS, CONVERGESORT_ID);
    }

    /**
     * 汇聚页面指定聚会列表点击查看详情
     *
     * @param md5
     * @param id
     * @return
     */
    public static Observable<EatDrinkDetailModel> postHjRecyclerItemDetail(String md5, String id) {
        return retrofitService.postHjRecyclerItemDetail(md5, id);
    }

    /**
     * 汇聚活动发布
     *
     * @param map
     * @return
     */
    public static Observable<HjReleaseModel> postHjRelease(Map<String, String> map, List<MultipartBody.Part> listPath, List<LocalMedia> localMedia) {
        if (localMedia.size() != 0) {
            for (int i = 0; i < localMedia.size(); i++) {
                File file = new File(localMedia.get(i).getPath());
                RequestBody imageBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                MultipartBody.Part part = MultipartBody.Part.createFormData("fileList", file.getName(), imageBody);
                listPath.add(part);
            }
        } else {
            RequestBody imageBody = RequestBody.create(MediaType.parse("multipart/form-data"), "");
            MultipartBody.Part part = MultipartBody.Part.createFormData("fileList", "", imageBody);
            listPath.add(part);
        }
        return retrofitService.postHjRelease(map, listPath);
    }

    /**
     * 首页所有特权列表
     *
     * @param md5
     * @return
     */
    public static Observable<HomePrivilegeModel> postHomePrivilege(String md5) {
        return retrofitService.postHomePrivilege(md5);
    }

    /**
     * 首页所有特权列表(仅马术，游艇，飞机，高尔夫，豪车)
     *
     * @param md5
     * @return
     */
    public static Observable<HomePrivilegeModel> privilegePart(String md5, String id) {
        return retrofitService.privilegePart(md5, id);
    }

    /**
     * 尊购侧滑界面私人定制列表
     *
     * @param md5
     * @return
     */
    public static Observable<ZgPersonalTailorModel> postZgPersonalTailorModel(String md5) {
        return retrofitService.postZgPersonalTailorModel(md5);
    }

    /**
     * 尊购侧滑界面私人定制列表中的item详情页面
     *
     * @param md5
     * @param id
     * @return
     */
    public static Observable<ZgPersonalTailorDatailModel> postZgPersonalTailorDetail(String md5, String id) {
        return retrofitService.postZgPersonalTailorDetail(md5, id);
    }

    /**
     * 炫购收藏列表
     *
     * @param md5
     * @param id
     * @return
     */
    public static Observable<CollectionModel> postCollection(String md5, String id) {
        return retrofitService.postCollection(md5, id);
    }

    /**
     * 地址管理
     *
     * @param md5
     * @param id
     * @return
     */
    public static Observable<AddressManageModel> postAddressManage(String md5, String id) {
        return retrofitService.postAddressManage(md5, id);
    }

    /**
     * 删除地址管理
     *
     * @param md5
     * @param id
     * @return
     */
    public static Observable<ResultModel> delAddress(String md5, String id) {
        return retrofitService.delAddress(md5, id);
    }

    /**
     * 添加地址管理
     *
     * @return
     */
    public static Observable<ResultModel> addressAdd(Map<String, String> map) {
        return retrofitService.addressAdd(map);
    }

    /**
     * 编辑地址管理
     *
     * @return
     */
    public static Observable<ResultModel> addressEdit(Map<String, String> map) {
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
    public static Observable<ResultModel> upHeadIMG(String md5, String userId, String imgPath) {
        return retrofitService.uploadHead(md5, userId, DataManager.getMultiPart(DataManager.getMultBuilder(DataManager.initMultBuilder(), imgPath, "showfile")));
    }

//    public static Observable<ResultModel> postSendWeiBo(String md5, String HONOURUSER_ID, String CONTENT, String imgPath) {
//        return retrofitService.postSendWeiBo(md5, HONOURUSER_ID, CONTENT, DataManager.getMultiPart(DataManager.getMultBuilder(DataManager.initMultBuilder(),imgPath,"SHOWIMAGES")));
//    }

    /**
     * 上传黑微博内容和图片
     *
     * @param md5
     * @param HONOURUSER_ID
     * @param CONTENT
     * @param listPath
     * @return
     */
    public static Observable<ResultModel> postSendWeiBos(String md5, String HONOURUSER_ID, String CONTENT, String TOPIC_ID, String TITLE, List<MultipartBody.Part> listPath, List<LocalMedia> localMedia, String type) {
        //如果有图片上传，则加载body，如果没有上传图片则加载空body
        if (localMedia.size() != 0) {
            for (int i = 0; i < localMedia.size(); i++) {
                File file = new File(localMedia.get(i).getPath());
                RequestBody imageBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                MultipartBody.Part part = MultipartBody.Part.createFormData("fileList", file.getName(), imageBody);
                listPath.add(part);
            }
        } else {
            RequestBody imageBody = RequestBody.create(MediaType.parse("multipart/form-data"), "");
            MultipartBody.Part part = MultipartBody.Part.createFormData("fileList", "", imageBody);
            listPath.add(part);
        }
        return retrofitService.postSendWeiBo(md5, HONOURUSER_ID, CONTENT, TOPIC_ID, TITLE, listPath, type);
    }

    /**
     * 上传多张图片
     *
     * @param md5
     * @param userId
     * @param imgPathList
     * @return
     */
    public static Observable<ResultModel> upLoadListIMG(String md5, String userId, List<String> imgPathList) {
        MultipartBody.Builder builder;
        builder = DataManager.initMultBuilder();
        for (int i = 0; i < imgPathList.size(); i++) {
            builder = DataManager.getMultBuilder(builder, imgPathList.get(i), "showfile");//showfile  有可能不一样
        }
        return retrofitService.uploadListIMG(md5, userId, DataManager.getMultiPartList(builder));
    }


//       public static Observable<ResultModel> upLoadListIMG2(String md5, String userId, List<String> pathList) {
//        MultipartBody.Builder builder = new MultipartBody.Builder()
//                .setType(MultipartBody.FORM);//表单类型
//        //多张图片
//        for (int i = 0; i < pathList.size(); i++) {
//            File file = new File(pathList.get(i));//filePath 图片地址
//            RequestBody imageBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//
//            builder.addFormDataPart("showfile", file.getName(), imageBody);//"showfile 后台接收图片流的参数名（每张应该不同）
//        }
//        List<MultipartBody.Part> parts = builder.build().parts();
//           return retrofitService.uploadListIMG(md5, userId, parts);
//      }

    /**
     * 全部订单查询接口
     *
     * @param md5
     * @param id
     * @return
     */
    public static Observable<MyOrderModel> postMyAllOrder(String md5, String id) {
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
    public static Observable<MyOrderModel> postMyAppointOrder(String md5, String id, String state) {
        return retrofitService.postMyAppointOrder(md5, id, state);
    }

    /**
     * 商品分类左边列表
     *
     * @param md5
     * @return
     */
    public static Observable<CategoryLeftModel> postCategoryLeft(String md5) {
        return retrofitService.postCategoryLeft(md5);
    }

    /**
     * 获取欢迎引导页的轮播图片
     *
     * @param md5
     * @return
     */
    public static Observable<WelcomeModel> postWelcome(String md5) {
        return retrofitService.postWelcome(md5);
    }

    /**
     * 购物车列表
     *
     * @param md5
     * @param id
     * @return
     */
    public static Observable<ShoppingCarModel> postShoppingCar(String md5, String id) {
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
    public static Observable<ResultModel> postShoppingCarDelete(String md5, String PRODUCT_ID, String HONOURUSER_ID) {
        return retrofitService.postShoppingCarDelete(md5, PRODUCT_ID, HONOURUSER_ID);
    }

    /**
     * 添加商品到购物车
     *
     * @param md5
     * @param PRODUCT_ID
     * @param HONOURUSER_ID
     * @param QUANTITY
     * @return
     */
    public static Observable<ResultModel> postShoppingCarAdd(String md5, String PRODUCT_ID, String HONOURUSER_ID, String QUANTITY) {
        return retrofitService.postShoppingCarAdd(md5, PRODUCT_ID, HONOURUSER_ID, QUANTITY);
    }

    /**
     * 获取尊购页面轮播图
     *
     * @param md5
     * @return
     */
    public static Observable<ZgBannerModel> postZgBanner(String md5) {
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
    public static Observable<ZgSearchModel> postZgSearch(String md5, String HONOURUSER_ID, String KEYWORDS) {
        return retrofitService.postZgSearch(md5, HONOURUSER_ID, KEYWORDS);
    }

    /**
     * 首页汇聚玩趴图片接口
     *
     * @param md5
     * @return
     */
    public static Observable<HomePlayModel> postHomePlay(String md5) {
        return retrofitService.postHomePlay(md5);
    }

    /**
     * 首页荣耀服务列表
     *
     * @param md5
     * @return
     */
    public static Observable<HomeGloryServerModel> postHomeGloryServer(String md5) {
        return retrofitService.postHomeGloryServer(md5);
    }

    /**
     * 首页荣耀音乐列表
     *
     * @param md5
     * @return
     */
    public static Observable<HomeGloryMusicModel> postHomeGloryMusic(String md5) {
        return retrofitService.postHomeGloryMusic(md5);
    }

    /**
     * 首页KTV列表
     *
     * @param md5
     * @param user_id
     * @return
     */
    public static Observable<HomeKTVModel> postHomeKTVRecycler(String md5, String user_id) {
        return retrofitService.postHomeKTVRecycler(md5, user_id);
    }

    /**
     * 首页高尔夫汇列表
     *
     * @param md5
     * @param user_id
     * @return
     */
    public static Observable<HomeGolfRecyclerModel> postHomeGolfRecycler(String md5, String user_id) {
        return retrofitService.postHomeGolfRecycler(md5, user_id);
    }

    /**
     * 首页马术列表接口
     *
     * @param md5
     * @param user_id
     * @return
     */
    public static Observable<HomeHorseRecyclerModel> postHomeHorseRecycler(String md5, String user_id) {
        return retrofitService.postHomeHorseRecycler(md5, user_id);
    }

    /**
     * 首页豪车列表接口
     *
     * @param md5
     * @param user_id
     * @return
     */
    public static Observable<HomeCarRecyclerModel> postHomeCarRecycler(String md5, String user_id) {
        return retrofitService.postHomeCarRecycler(md5, user_id);
    }

    /**
     * 首页游艇列表接口
     *
     * @param md5
     * @param user_id
     * @return
     */
    public static Observable<HomeYachtRecyclerModel> postHomeYachtRecycler(String md5, String user_id) {
        return retrofitService.postHomeYachtRecycler(md5, user_id);
    }

    /**
     * 高尔夫汇详情
     *
     * @param md5
     * @param golf_id
     * @return
     */
    public static Observable<HomeGolfDetailModel> postHomeGolfDetail(String md5, String golf_id) {
        return retrofitService.postHomeGolfDetail(md5, golf_id);
    }

    /**
     * 马术详情
     *
     * @param md5
     * @param horse_id
     * @return
     */
    public static Observable<HomeHorseDetailModel> postHomeHorseDetail(String md5, String horse_id) {
        return retrofitService.postHomeHorseDetail(md5, horse_id);
    }

    /**
     * 豪车详情接口
     *
     * @param md5
     * @param car_id
     * @return
     */
    public static Observable<HomeCarDetailModel> postHomeCarDetail(String md5, String car_id) {
        return retrofitService.postHomeCarDetail(md5, car_id);
    }

    /**
     * 游艇详情接口
     *
     * @param md5
     * @param yacht_id
     * @return
     */
    public static Observable<HomeYachtDetailModel> postHomeYachtDetail(String md5, String yacht_id) {
        return retrofitService.postHomeYachtDetail(md5, yacht_id);
    }

    /**
     * 飞机详情接口
     *
     * @param md5
     * @return
     */
    public static Observable<HomeCopterDetailModel> postHomeCopterDetail(String md5) {
        return retrofitService.postHomeCopterDetail(md5);
    }

    /**
     * 首页荣耀服务列表详情点击
     *
     * @param md5
     * @param server_id
     * @return
     */
    public static Observable<Object> postHomeGloryHorseDetail(String md5, String server_id, String SHOPTYPE) {
        return retrofitService.postHomeGloryHorseDetail(md5, server_id, SHOPTYPE);
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
    public static Observable<ResultModel> postMyOrderOk(String md5, String ORDERNUMBER, String HONOURUSER_ID, String ORDERSTATUS) {
        return retrofitService.postMyOrderOk(md5, ORDERNUMBER, HONOURUSER_ID, ORDERSTATUS);
    }

    /**
     * 订单中心酒吧全部订单查询
     *
     * @param md5
     * @param HONOURUSER_ID
     * @return
     */
    public static Observable<OrderCenterBarRecyclerModel> postOrderCenterBarRecycler(String md5, String HONOURUSER_ID, String ORDERSTATUS) {
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
    public static Observable<OrderCenterKTVRecyclerModel> postOrderCenterKTVRecycler(String md5, String HONOURUSER_ID, String ORDERSTATUS) {
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
    public static Observable<OrderCenterHotelRecyclerModel> postOrderCenterHotelRecycler(String md5, String HONOURUSER_ID, String ORDERSTATUS) {
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
    public static Observable<OrderCenterFoodRecyclerModel> postOrderCenterFoodRecycler(String md5, String HONOURUSER_ID, String ORDERSTATUS) {
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
    public static Observable<ResultModel> postZgChange(String md5, String HONOURUSER_ID, String ORDERNUMBER, String ORDERSTATUS) {
        return retrofitService.postZgChange(md5, HONOURUSER_ID, ORDERNUMBER, ORDERSTATUS);
    }

    /**
     * 美食筛选
     */
    public static Observable<HomeFoodModel> filterFoodList(Map<String, String> map) {
        return retrofitService.filterFoodList(map);
    }

    /**
     * 酒店筛选
     *
     * @param map
     * @return
     */
    public static Observable<HomeHotelModel> filterHotelList(Map<String, String> map) {
        return retrofitService.filterHotelList(map);
    }

    /**
     * KTV筛选
     *
     * @param map
     * @return
     */

    public static Observable<HomeKTVModel> filterKTVList(Map<String, String> map) {
        return retrofitService.filterKTVList(map);
    }

    /**
     * 酒吧筛选
     *
     * @param map
     * @return
     */
    public static Observable<HomeBarModel> filterBarList(Map<String, String> map) {
        return retrofitService.filterBarList(map);
    }

    public static Observable<LiveInfoListModel> pullLive(String appid) {
        return retrofitService.pullLive(appid);
    }

    /**
     * 首页荣耀杂志列表
     *
     * @param md5
     * @return
     */
    public static Observable<HomeGloryMagazineModel> postHomeGloryMagazine(String md5) {
        return retrofitService.postHomeGloryMagazine(md5);
    }

    /**
     * 粉丝列表
     *
     * @param md5
     * @param id
     * @return
     */
    public static Observable<AbMyFriendModel> myFollowList(String md5, String id) {
        return retrofitService.myFollowList(md5, id);
    }

    /**
     * 删除好友
     *
     * @param md5
     * @param id
     * @return
     */
    public static Observable<ResultModel> delFriend(String md5, String id, String delId) {
        return retrofitService.delFriend(md5, id, delId);
    }

    /**
     * 好友列表
     *
     * @param md5
     * @param id
     * @return
     */
    public static Observable<AbMyFriendModel> myFriendList(String md5, String id) {
        return retrofitService.myFriendsList(md5, id);
    }

    /**
     * 添加好友
     *
     * @param md5
     * @param id
     * @return
     */
    public static Observable<ResultModel> addFriend(String md5, String id, String delId) {
        return retrofitService.addFriends(md5, id, delId);
    }

    /**
     * 尊购发现菜单选项
     *
     * @param md5
     * @return
     */
    public static Observable<ZgFindTitleModel> postZgFindTiele(String md5) {
        return retrofitService.postZgFindTiele(md5);
    }

    /**
     * 尊购发现页面条目对应列表
     *
     * @param md5
     * @param id
     * @return
     */
    public static Observable<ZgFindModel> postZgFind(String md5, String id) {
        return retrofitService.postZgFind(md5, id);
    }

    /**
     * 美食，酒吧，酒店，KTV品牌和筛选条件请求
     *
     * @param md5
     * @param type
     * @param sortName
     * @return
     */
    public static Observable<FoodHotelBarKTVDialogModel> postFoodHotelBarKTVDialog(String md5, String type, String sortName) {
        return retrofitService.postFoodHotelBarKTVDialog(md5, type, sortName);
    }

    /**
     * 我的页面，圈子中心接口
     *
     * @param md5
     * @param user_id
     * @return
     */
    public static Observable<MyCircleModel> postCircleCenterRecycle(String md5, String user_id) {
        return retrofitService.postCircleCenterRecycle(md5, user_id);
    }

    /**
     * 圈子中心点赞和评论点赞接口
     *
     * @param md5
     * @param HONOURUSER_ID
     * @param circle_id
     * @param commend_id
     * @param statue
     * @return
     */
    public static Observable<ResultModel> postCircleCenterYeah(String md5, String HONOURUSER_ID, String circle_id, String commend_id, String statue) {
        return retrofitService.postCircleCenterYeah(md5, HONOURUSER_ID, circle_id, commend_id, statue);
    }

    /**
     * 圈子中心评论接口
     *
     * @param md5
     * @param CIRCLE_ID
     * @return
     */
    public static Observable<CircleCenterCommentRecyclerModel> postCircleCenterCommentRecycler(String md5, String CIRCLE_ID) {
        return retrofitService.postCircleCenterCommentRecycler(md5, CIRCLE_ID);
    }

    /**
     * 设置个人资料修改
     *
     * @param map
     * @return
     */
    public static Observable<ResultModel> postUserInfoChange(String md5, String user_id, Map<String, String> map) {
        return retrofitService.postUserInfoChange(md5, user_id, map);
    }

    /**
     * 设置帐号与安全登录密码修改
     *
     * @param md5
     * @param user_id
     * @param passWord
     * @return
     */
    public static Observable<ResultModel> postSecurityPassWord(String md5, String user_id, String passWord, String OLDPASSWORD) {
        return retrofitService.postSecurityPassWord(md5, user_id, passWord, OLDPASSWORD);
    }

    /**
     * 设置个人资料接口
     *
     * @param md5
     * @param user_id
     * @return
     */
    public static Observable<SettingUserInfoModel> postSettingUserInfo(String md5, String user_id) {
        return retrofitService.postSettingUserInfo(md5, user_id);
    }

    /**
     * 圈子中心评论接口
     *
     * @param md5
     * @param user_id
     * @param circle_id
     * @param content
     * @param reply_id
     * @return
     */
    public static Observable<ResultModel> postCircleCenterComment(String md5, String user_id, String circle_id, String content, String reply_id) {
        return retrofitService.postCircleCenterComment(md5, user_id, circle_id, content, reply_id);
    }

    /**
     * 电台列表
     *
     * @param md5
     * @return
     */
    public static Observable<MusicDjModel> getMusicDjList(String md5, String cate_name) {
        return retrofitService.getMusicDjList(md5, cate_name);
    }

    /**
     * 电台详情列表
     *
     * @param md5
     * @param channelName
     * @return
     */
    public static Observable<MusicDetailListModel> getMusicDjSongList(String md5, String channelName) {
        return retrofitService.getMusicDjSongList(md5, channelName);
    }

    /**
     * 歌曲详情
     *
     * @param md5
     * @param songId
     * @return
     */
    public static Observable<MusicSongDetailsModel> getSongDetails(String md5, String songId) {
        return retrofitService.getMusicSongDetail(md5, songId);
    }

    /**
     * 歌词
     *
     * @param md5
     * @param songid
     * @return
     */
    public static Observable<MusicLrcModel> getMusicLry(String md5, String songid) {
        return retrofitService.getMusicLry(md5, songid);
    }

    /**
     * 音乐排行榜列表
     *
     * @param md5
     * @param offset
     * @param type
     * @return
     */
    public static Observable<MusicRankingModel> getRankingList(String md5, String offset, String type) {
        return retrofitService.getRankingList(md5, offset, type);
    }

    /**
     * 音乐排行榜(首页)
     *
     * @param md5
     * @param offset
     * @param type
     * @return
     */
    public static Observable<MusicRankAllModel> getMusicRanking(String md5, String offset, String type) {
        return retrofitService.getMusicRanking(md5, offset, type);
    }

    /**
     * 推荐
     *
     * @param md5
     * @return
     */
    public static Observable<MusicRecommendModel> getMusicRecommendList(String md5) {
        return retrofitService.getMusicRecommendList(md5);
    }

    /**
     * 歌手列表
     *
     * @param md5
     * @param offset
     * @return
     */
    public static Observable<MusicSingerModel> getMusicSingerList(String md5, String offset, String sexType, String areaType) {
        return retrofitService.getMusicSingerList(md5, offset, sexType, areaType);
    }

    /**
     * 歌手歌曲列表
     *
     * @param md5
     * @param singerId
     * @param offset
     * @return
     */
    public static Observable<MusicSingerSongsModel> getSingerSongs(String md5, String singerId, String offset) {
        return retrofitService.getSingerSongs(md5, singerId, offset);
    }

    /**
     * 能量值各能量接口
     *
     * @param md5
     * @return
     */
    public static Observable<MyPowerModel> postMyPower(String md5, String HONOURUSER_ID) {
        return retrofitService.postMyPower(md5, HONOURUSER_ID);
    }

    /**
     * 注册时，卡类型所对应的图片
     *
     * @param md5
     * @param CARDTYPE_ID
     * @return
     */
    public static Observable<RegisterCardTypeModel> postRegisterCardType(String md5, String CARDTYPE_ID) {
        return retrofitService.postRegisterCardType(md5, CARDTYPE_ID);
    }

    /**
     * 注册时，手动选择号码功能
     *
     * @param md5
     * @param CARDTYPE_ID
     * @return
     */
    public static Observable<RegisterChangeNumberModel> postRegisterChangeNumber(String md5, String CARDTYPE_ID) {
        return retrofitService.postRegisterChangeNumber(md5, CARDTYPE_ID);
    }

    /**
     * 能量值曲线图接口
     *
     * @param md5
     * @param user_id
     * @return
     */
    public static Observable<MyPowerImageModel> postPowerImage(String md5, String user_id) {
        return retrofitService.postPowerImage(md5, user_id);
    }

    /**
     * 我的界面Vip中心接口
     *
     * @param md5
     * @param user_id
     * @return
     */
    public static Observable<MyVipCenterModel> postMyVipCenter(String md5, String user_id) {
        return retrofitService.postMyVipCenter(md5, user_id);
    }

    /**
     * 订单中心评论订单接口
     *
     * @param md5
     * @param PRODUCT_ID
     * @param HONOURUSER_ID
     * @param EVALUATECONTENT
     * @param EVALUATECOINT
     * @param ISSHOW
     * @return
     */
    public static Observable<ResultModel> postOrderCenterComment(String md5, String PRODUCT_ID, String HONOURUSER_ID, String EVALUATECONTENT, String EVALUATECOINT, String ISSHOW) {
        return retrofitService.postOrderCenterComment(md5, PRODUCT_ID, HONOURUSER_ID, EVALUATECONTENT, EVALUATECOINT, ISSHOW);
    }

    /**
     * 我的界面，获取头像、优惠券、黑咖币、能量值
     *
     * @param md5
     * @param user_id
     * @return
     */
    public static Observable<MyDisBlackPowerModel> postDisBlackPower(String md5, String user_id) {
        return retrofitService.postDisBlackPower(md5, user_id);
    }

    /**
     * 商品详情页面接口
     *
     * @param md5
     * @param PRODUCT_ID
     * @return
     */
    public static Observable<ResponseBody> commodityDteail(String md5, String PRODUCT_ID) {
        return retrofitService.commodityDteail(md5, PRODUCT_ID);
    }

    /**
     * 汇聚吃喝玩乐广告位置
     *
     * @param md5
     * @param AD_POSITION
     * @return
     */
    public static Observable<AdvertisementModel> postAdvertisement(String md5, String AD_POSITION) {
        return retrofitService.postAdvertisement(md5, AD_POSITION);
    }

    /**
     * 汇聚吃喝玩乐获取条件查询
     *
     * @param md5
     * @param CONVERGE_ID
     * @return
     */
    public static Observable<EatDrinkSearchModel> postEatDrinkSearch(String md5, String CONVERGE_ID) {
        return retrofitService.postEatDrinkSearch(md5, CONVERGE_ID);
    }

    /**
     * 获取话题列表
     *
     * @param md5
     * @param title
     * @return
     */
    public static Observable<TopicListModel> getTopicList(String md5, String title) {
        return retrofitService.getTopicList(md5, title);
    }

    /**
     * 添加话题
     *
     * @param md5
     * @param userID
     * @param title
     * @return
     */
    public static Observable<TopicListModel> addTopic(String md5, String userID, String title) {
        return retrofitService.addTopic(md5, userID, title);
    }

    /**
     * 荣耀杂志详情接口
     *
     * @param md5
     * @param MAGAZINE_ID
     * @param MAGAZINETYPE
     * @return
     */
    public static Observable<HomeGloryMagazineDetailModel> postHomeGloryMagazineDetail(String md5, String MAGAZINE_ID, String MAGAZINETYPE) {
        return retrofitService.postHomeGloryMagazineDetail(md5, MAGAZINE_ID, MAGAZINETYPE);
    }

    /**
     * 添加商品到选购收藏列表
     *
     * @param md5
     * @param HONOURUSER_ID
     * @param PRODUCT_ID
     * @return
     */
    public static Observable<ResultModel> postAddCollection(String md5, String HONOURUSER_ID, String PRODUCT_ID) {
        return retrofitService.postAddCollection(md5, HONOURUSER_ID, PRODUCT_ID);
    }

    /**
     * 从选购收藏删除商品
     *
     * @param md5
     * @param COLLECT_ID
     * @return
     */
    public static Observable<ResultModel> postDelCollection(String md5, String COLLECT_ID) {
        return retrofitService.postDelCollection(md5, COLLECT_ID);
    }


    /**
     * 商品分类右边列表
     *
     * @param md5
     * @param id
     * @return
     */
    public static Observable<CategoryRightModel> postCategoryRight(String md5, String id, String BRANDICON_ID) {
        return retrofitService.postCategoryRight(md5, id, BRANDICON_ID);
    }

    /**
     * 首页搜索页面热门搜索和推荐
     *
     * @param md5
     * @return
     */
    public static Observable<HomeSearchHotModel> postHomeSearchHot(String md5, String PARENT_ID) {
        return retrofitService.postHomeSearchHot(md5, PARENT_ID);
    }

    /**
     * 首页荣耀杂志更多界面
     *
     * @param md5
     * @return
     */
    public static Observable<MainGloryMagazineModel> postMainGloryMagazine(String md5, String MENU_ID) {
        return retrofitService.postMainGloryMagazine(md5, MENU_ID);
    }

    /**
     * 首页新闻头条发布新闻接口
     *
     * @param md5
     * @param title
     * @param user_id
     * @param DIS_TYPE
     * @param listPath
     * @param localMedia
     * @return
     */
    public static Observable<ResultModel> postHomeNewsSend(String md5, String title, String user_id, String DIS_TYPE, String CAIDAN_ID, List<MultipartBody.Part> listPath, List<LocalMedia> localMedia, String video, String videoPath) {
        if (video.equals("3")) {
            if (localMedia.size() != 0) {
                File file = new File(localMedia.get(0).getPath());
                RequestBody imageBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                MultipartBody.Part part = MultipartBody.Part.createFormData("showfile", file.getName(), imageBody);
                listPath.add(part);

                File file1 = new File(videoPath);
                RequestBody imageBody1 = RequestBody.create(MediaType.parse("multipart/form-data"), file1);
                MultipartBody.Part part1 = MultipartBody.Part.createFormData("fileList", "suoluetu.jpg", imageBody1);
                listPath.add(part1);
            }
        } else {
            if (localMedia.size() != 0) {
                for (int i = 0; i < localMedia.size(); i++) {
                    File file = new File(localMedia.get(i).getPath());
                    RequestBody imageBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                    MultipartBody.Part part = MultipartBody.Part.createFormData("fileList", file.getName(), imageBody);
                    listPath.add(part);
                }
            } else {
                RequestBody imageBody = RequestBody.create(MediaType.parse("multipart/form-data"), "");
                MultipartBody.Part part = MultipartBody.Part.createFormData("fileList", "", imageBody);
                listPath.add(part);
            }
        }

        return retrofitService.postHomeNewsSend(md5, title, user_id, DIS_TYPE, CAIDAN_ID, listPath);
    }

    /**
     * 荣耀音乐头部广告和歌手推荐
     *
     * @param md5
     * @return
     */
    public static Observable<MainMusicGloryModel> postMainGloryMusic(String md5) {
        return retrofitService.postMainGloryMusic(md5);
    }

    /**
     * 荣耀音乐电台接口
     *
     * @param md5
     * @return
     */
    public static Observable<MainGloryMusicDJModel> postMainGloryMusicDJ(String md5) {
        return retrofitService.postMainGloryMusicDJ(md5);
    }

    /**
     * 荣耀音乐曲库推荐接口
     *
     * @param md5
     * @return
     */
    public static Observable<MainGloryMusicLibModel> postMainGloryMusicLib(String md5) {
        return retrofitService.postMainGloryMusicLib(md5);
    }

    /**
     * 荣耀音乐歌曲推荐接口
     *
     * @param md5
     * @param offset
     * @return
     */
    public static Observable<MainGloryMusicSongModel> postMainGloryMusicSong(String md5, String offset) {
        return retrofitService.postMainGloryMusicSong(md5, offset);
    }

    /**
     * 荣耀音乐曲库二级接口
     *
     * @param md5
     * @param album_id
     * @return
     */
    public static Observable<MainGloryMusicLibDetailModel> postMainGloryMusicLibDetail(String md5, String album_id) {
        return retrofitService.postMainGloryMusicLibDetail(md5, album_id);
    }

    /**
     * 订单中心优惠券接口
     *
     * @param md5
     * @param BUSINESS_ID
     * @return
     */
    public static Observable<DisCountModel> postDisCount(String md5, String BUSINESS_ID) {
        return retrofitService.postDisCount(md5, BUSINESS_ID);
    }

    /**
     * 领取优惠券（暂未开发）
     *
     * @param md5
     * @param BUSINESS_ID
     * @param HONOURUSER_ID
     * @return
     */
    public static Observable<ResultModel> postAddCoupon(String md5, String BUSINESS_ID, String HONOURUSER_ID) {
        return retrofitService.postAddCoupon(md5, BUSINESS_ID, HONOURUSER_ID);
    }

    /**
     * 根据店铺id获取可用的优惠券(暂未开发)
     *
     * @param md5
     * @param BUSINESS_ID
     * @return
     */
    public static Observable<DisCountModel> postShopCoupon(String md5, String BUSINESS_ID) {
        return retrofitService.postShopCoupon(md5, BUSINESS_ID);
    }

    /**
     * 尊购页面列表接口(暂未开发)
     *
     * @param md5
     * @return
     */
    public static Observable<ZgHomeListModel> postZgList(String md5) {
        return retrofitService.postZgList(md5);
    }

    /**
     * 直播推流地址
     *
     * @param md5
     * @return
     */
    public static Observable<LivePushModel> getPushUrl(String md5, String id, String title) {
        return retrofitService.getPushUrl(md5, id, title);
    }

    /**
     * 直播拉流地址
     *
     * @param md5
     * @return
     */
    public static Observable<LivePullModel> getPullUrl(String md5) {
        return retrofitService.getPullUrl(md5);
    }

    /**
     * 直播拉流地址
     *
     * @param md5
     * @return
     */
    public static Observable<LivePushListModel> getPushList(String md5) {
        return retrofitService.getPushList(md5);
    }

    /**
     * 根据分类直播拉流地址
     *
     * @param md5
     * @return
     */
    public static Observable<LivePushListModel> getPushListByType(String md5, String LIVETYPE_ID) {
        return retrofitService.getPushListByType(md5, LIVETYPE_ID);
    }

    /**
     * 根据分类直播拉流地址
     *
     * @param md5
     * @return
     */
    public static Observable<LivePushListModel> getPushNearByList(String md5, String userId) {
        return retrofitService.getPushNearByList(md5, userId);
    }

    /**
     * 上传地址
     *
     * @param md5
     * @return
     */
    public static Observable<ResultModel> postLocation(String md5, String id, String str1, String str2) {
        return retrofitService.postLocation(md5, id, str1, str2);
    }

    /**
     * 上传地址
     *
     * @param md5
     * @return
     */
    public static Observable<ResultModel> closeLive(String md5, String id) {
        return retrofitService.closeLive(md5, id);
    }

    /**
     * 直播列表一级分类
     *
     * @param md5
     * @return
     */
    public static Observable<LiveTypeModel> getLiveTypeFirst(String md5) {
        return retrofitService.getLiveTypeFirst(md5);
    }

    /**
     * 直播列表二级分类
     *
     * @param md5
     * @return
     */
    public static Observable<LiveTypeModel> getLiveTypeSecond(String md5, String PARENT_ID) {
        return retrofitService.getLiveTypeSecond(md5, PARENT_ID);
    }

    /**
     * 直播附近筛选
     *
     * @param md5
     * @return
     */
    public static Observable<LivePushListModel> getNearByFilter(String md5, String sex, String time) {
        return retrofitService.getNearByFilter(md5, sex, time);
    }

    /**
     * 尚播搜索
     *
     * @param md5
     * @return
     */
    public static Observable<AbSearchModel> getAbSearchList(String md5, String name) {
        return retrofitService.getAbSearchList(md5, name);
    }

    /**
     * 尚播搜索热门
     *
     * @param md5
     * @return
     */
    public static Observable<AbSearchModel> getAbSearchHotList(String md5, String PARENT_ID) {
        return retrofitService.getAbSearchHotList(md5, PARENT_ID);
    }

    /**
     * 主播详情页面 Top详情
     *
     * @param md5
     * @return
     */
    public static Observable<LiveAncherDetailsModel> getLiveAncherDetails(String md5, String ancher_userId) {
        return retrofitService.getLiveAncherDetail(md5, ancher_userId);
    }

    /**
     * 主播详情页面 Top详情
     *
     * @param md5
     * @return
     */
    public static Observable<LiveAnchorMoreModel> getLiveAncherMore(String md5, String ancher_userId) {
        return retrofitService.getLiveAncherMore(md5, ancher_userId);
    }

    /**
     * 主播详情页面 微博
     *
     * @param md5
     * @return
     */
    public static Observable<LiveAncherDetailWBModel> getLiveAncherWeibo(String md5, String ancher_userId) {
        return retrofitService.getLiveAncherWeibo(md5, ancher_userId);
    }

    /**
     * 直播弹窗
     *
     * @param md5
     * @return
     */
    public static Observable<LiveRoomDialogModel> getAncherDialog(String md5, String ancher_userId, String myId) {
        return retrofitService.getAncherDialog(md5, ancher_userId, myId);
    }

    /**
     * 直播弹窗  关注主播
     *
     * @param md5
     * @return
     */
    public static Observable<LiveRoomDialogModel> fouseAncher(String md5, String ancher_userId, String myId) {
        return retrofitService.fouseAncher(md5, ancher_userId, myId);
    }

    /**
     * 直播弹窗  关注主播
     *
     * @param md5
     * @return
     */
    public static Observable<LiveRoomDialogModel> delAncher(String md5, String ancher_userId, String myId) {
        return retrofitService.delAncher(md5, ancher_userId, myId);
    }

    /**
     * 直播礼物
     *
     * @param md5
     * @return
     */
    public static Observable<LiveRoomDialogModel> sendLiveGift(String md5, String ancher_userId, String myId, String moeny) {
        return retrofitService.sendLiveGift(md5, ancher_userId, myId, moeny);
    }

    /**
     * 尚播
     * 个人资料
     *
     * @param md5
     * @param user_id
     * @return
     */
    public static Observable<AbMyModel> getAbMyInfo(String md5, String user_id) {
        return retrofitService.getAbMyInfo(md5, user_id);
    }

    /**
     * 签到数据
     *
     * @param md5
     * @param user_id
     * @return
     */
    public static Observable<SignInDataModel> getSignData(String md5, String user_id) {
        return retrofitService.getAbSignData(md5, user_id);
    }
    /**
     * 签到
     *
     * @param md5
     * @param user_id
     * @return
     */
    public static Observable<ResultModel> sendSingIn(String md5, String user_id) {
        return retrofitService.sendSingIn(md5, user_id);
    }
}
