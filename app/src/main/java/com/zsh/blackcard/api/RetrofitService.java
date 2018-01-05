package com.zsh.blackcard.api;

import com.zsh.blackcard.model.AbMyFriendModel;
import com.zsh.blackcard.model.AddressManageModel;
import com.zsh.blackcard.model.AdvertisementModel;
import com.zsh.blackcard.model.BarDetailModel;
import com.zsh.blackcard.model.BarDetailsMoreListModel;
import com.zsh.blackcard.model.BardetailsItemModel;
import com.zsh.blackcard.model.CategoryLeftModel;
import com.zsh.blackcard.model.CategoryRightModel;
import com.zsh.blackcard.model.CircleCenterCommentRecyclerModel;
import com.zsh.blackcard.model.CollectionModel;
import com.zsh.blackcard.model.CommentAddModel;
import com.zsh.blackcard.model.CommentModel;
import com.zsh.blackcard.model.EatDrinkDetailModel;
import com.zsh.blackcard.model.EatDrinkRecyclerModel;
import com.zsh.blackcard.model.EatDrinkSearchModel;
import com.zsh.blackcard.model.FoodDetailModel;
import com.zsh.blackcard.model.FoodDetailsMoreListModel;
import com.zsh.blackcard.model.FoodHotelBarKTVDialogModel;
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
import com.zsh.blackcard.model.MusicDetailListModel;
import com.zsh.blackcard.model.MusicDjModel;
import com.zsh.blackcard.model.MusicLrcModel;
import com.zsh.blackcard.model.MusicRankAllModel;
import com.zsh.blackcard.model.MusicRankingModel;
import com.zsh.blackcard.model.MusicRecommendModel;
import com.zsh.blackcard.model.MusicSingerModel;
import com.zsh.blackcard.model.MusicSingerSongsModel;
import com.zsh.blackcard.model.MusicSongDetailsModel;
import com.zsh.blackcard.model.MyCircleModel;
import com.zsh.blackcard.model.MyDisBlackPowerModel;
import com.zsh.blackcard.model.MyOrderModel;
import com.zsh.blackcard.model.MyPowerImageModel;
import com.zsh.blackcard.model.MyPowerModel;
import com.zsh.blackcard.model.MyVipCenterModel;
import com.zsh.blackcard.model.OrderCenterBarRecyclerModel;
import com.zsh.blackcard.model.OrderCenterFoodRecyclerModel;
import com.zsh.blackcard.model.OrderCenterHotelRecyclerModel;
import com.zsh.blackcard.model.OrderCenterKTVRecyclerModel;
import com.zsh.blackcard.model.OrderResultModel;
import com.zsh.blackcard.model.RegisterCardTypeModel;
import com.zsh.blackcard.model.RegisterChangeNumberModel;
import com.zsh.blackcard.model.RegisterModel;
import com.zsh.blackcard.model.ResultModel;
import com.zsh.blackcard.model.SettingUserInfoModel;
import com.zsh.blackcard.model.ShoppingCarModel;
import com.zsh.blackcard.model.TopicListModel;
import com.zsh.blackcard.model.TrainModel;
import com.zsh.blackcard.model.WelcomeModel;
import com.zsh.blackcard.model.ZgBannerModel;
import com.zsh.blackcard.model.ZgFindModel;
import com.zsh.blackcard.model.ZgFindTitleModel;
import com.zsh.blackcard.model.ZgPersonalTailorDatailModel;
import com.zsh.blackcard.model.ZgPersonalTailorModel;
import com.zsh.blackcard.model.ZgSearchModel;
import com.zsh.blackcard.model.ZgShopAreaModel;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
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
    Observable<HjRecyclerModel> postHjRecycler(@Field("FKEY") String md5);

    //汇聚页面指定聚会列表
    @FormUrlEncoded
    @POST("appconvergein/getpartylist?")
    Observable<EatDrinkRecyclerModel> postEatDrinkRecycler(@Field("FKEY") String md5,
                                                           @Field("HONOURUSER_ID") String HONOURUSER_ID,
                                                           @Field("CONVERGE_ID") String CONVERGE_ID,
                                                           @Field("STATUS") String STATUS,
                                                           @Field("CONVERGESORT_ID") String CONVERGESORT_ID);

    //首页美食
    @FormUrlEncoded
    @POST("appsfoodin/sfood?")
    Observable<HomeFoodModel> postHomeFoodList(@Field("FKEY") String md5, @Field("HONOURUSER_ID") String userId);

    //美食详情
    @FormUrlEncoded
    @POST("appsfoodin/foodsyn?")
    Observable<FoodDetailModel> postFoodDetail(@Field("FKEY") String md5, @Field("SORTFOOD_ID") String id);

    //首页酒店
    @FormUrlEncoded
    @POST("appshotelin/shotel.do?")
    Observable<HomeHotelModel> postHomeHotelList(@Field("FKEY") String md5, @Field("HONOURUSER_ID") String userId);

    //首页酒吧列表
    @FormUrlEncoded
    @POST("appsbarin/sbar.do?")
    Observable<HomeBarModel> postHomeBarlList(@Field("FKEY") String md5, @Field("HONOURUSER_ID") String userId);

    //酒店详情
    @FormUrlEncoded
    @POST("appshotelin/hotelsyn?")
    Observable<HotelDetailModel> postHotelDetail(@Field("FKEY") String md5, @Field("SORTHOTEL_ID") String id);

    //酒吧详情
    @FormUrlEncoded
    @POST("appsbarin/barsyn.do?")
    Observable<BarDetailModel> postBarDetail(@Field("FKEY") String md5, @Field("SORTBAR_ID") String id);

    //酒吧详情列表
    @FormUrlEncoded
    @POST("appsbarin/bardetaillist.do?")
    Observable<BardetailsItemModel> postBarDetailList(@Field("FKEY") String md5, @Field("SORTBAR_ID") String id);

    //酒店详情列表
    @FormUrlEncoded
    @POST("appshotelin/hoteldetaillist?")
    Observable<HoteldetailsItemModel> postHotelDetailList(@Field("FKEY") String md5, @Field("SORTHOTEL_ID") String id);

    //美食套餐列表
    @FormUrlEncoded
    @POST("appsfoodin/fooddetaillist.do?")
    Observable<HomeFoodDetailPackageModel> postFoodDetailList(@Field("FKEY") String md5, @Field("SORTFOOD_ID") String id);

    //美食详情更多列表
    @FormUrlEncoded
    @POST("appsfoodin/sfoodlistrand.do?")
    Observable<FoodDetailsMoreListModel> postFoodDetailMoreList(@Field("FKEY") String md5, @Field("HONOURUSER_ID") String id);

    //酒店详情更多列表
    @FormUrlEncoded
    @POST("appshotelin/shotellistrand.do?")
    Observable<HotelDetailsMoreListModel> postHotelDetailMoreList(@Field("FKEY") String md5, @Field("HONOURUSER_ID") String id);

    //KTV详情更多列表
    @FormUrlEncoded
    @POST("appsktvin/sktvlistrand.do?")
    Observable<KTVDetailsMoreListModel> postKTVDetailMoreList(@Field("FKEY") String md5, @Field("HONOURUSER_ID") String id);

    //酒吧详情更多列表
    @FormUrlEncoded
    @POST("appsbarin/sbarlistrand.do?")
    Observable<BarDetailsMoreListModel> postBarDetailMoreList(@Field("FKEY") String md5, @Field("HONOURUSER_ID") String id);

    //KTV详情
    @FormUrlEncoded
    @POST("appsktvin/ktvsyn?")
    Observable<HomeKTVDetailModel> postKTVDetail(@Field("FKEY") String md5, @Field("SORTKTV_ID") String id);

    //KTV详情列表
    @FormUrlEncoded
    @POST("appsktvin/ktvdetaillist?")
    Observable<HomeKTVDetailItemModel> postKTVDetailList(@Field("FKEY") String md5, @Field("SORTKTV_ID") String id);

    //酒店评论列表
    @FormUrlEncoded
    @POST("appshotelin/hotelevalist?")
    Observable<CommentModel> postHotelCommentList(@Field("FKEY") String md5, @Field("SORTHOTEL_ID") String id);

    //Food评论列表
    @FormUrlEncoded
    @POST("appsfoodin/foodevalist?")
//FOODEVA
    Observable<CommentModel> postFoodCommentList(@Field("FKEY") String md5, @Field("SORTFOOD_ID") String id);

    //KTV评论列表
    @FormUrlEncoded
    @POST("appsktvin/ktvevalist?")
    Observable<CommentModel> postKTVCommentList(@Field("FKEY") String md5, @Field("SORTKTV_ID") String id);

    //KTV评论列表
    @FormUrlEncoded
    @POST("appsbarin/barevalist?")
    Observable<CommentModel> postBarCommentList(@Field("FKEY") String md5, @Field("SORTBAR_ID") String id);

    //添加Hotel评论

    @GET("appshotelin/shoteladdeva?")
    Observable<CommentAddModel> addHotelComment(@QueryMap Map<String, String> map);

    //添加Food评论
    @GET("appsfoodin/sfoodaddeva?")
//SFOODADDEVA
    Observable<CommentAddModel> addFoodComment(@QueryMap Map<String, String> map);

    //添加KTV评论
    @GET("appsktvin/sktvaddeva?")
    //SKTVADDEVA
    Observable<CommentAddModel> addKTVComment(@QueryMap Map<String, String> map);

    //添加Bar评论
    @GET("appsbarin/addbareva.do?")
    //ADDBAREVA
    Observable<CommentAddModel> addBarComment(@QueryMap Map<String, String> map);

    //生成酒店订单
    @GET("appshotelin/shiphotelorder?")
    //ADDBAREVA
    Observable<OrderResultModel> hotelOrder(@QueryMap Map<String, String> map);

    //生成KTV订单
    @GET("appsbarin/addbarorder.do?")
    Observable<OrderResultModel> KTVOrder(@QueryMap Map<String, String> map);

    //生成Bar订单
    @GET("appsktvin/shipktvorder?")
    Observable<OrderResultModel> BarOrder(@QueryMap Map<String, String> map);

    //火车票
    @FormUrlEncoded
    @POST("apppersonalin/trainselect?")
    Observable<TrainModel> postTrain(@QueryMap Map<String, String> map);

    //汇聚页面指定聚会列表点击了解详情
    @FormUrlEncoded
    @POST("appconvergein/getdetailbyid?")
    Observable<EatDrinkDetailModel> postHjRecyclerItemDetail(@Field("FKEY") String md5,
                                                             @Field("CONVERGEDETAIL_ID") String id);

    //地址管理
    @FormUrlEncoded
    @POST("appuserin/usershipadr?")
    Observable<AddressManageModel> postAddressManage(@Field("FKEY") String md5, @Field("HONOURUSER_ID") String id);


    //添加地址
//    @Multipart
    @GET("appuserin/useraddshipadr?")
    Observable<ResultModel> addressAdd(@QueryMap Map<String, String> map);

    //删除地址
    @FormUrlEncoded
    @POST("appuserin/userdelshipadr?")
    Observable<ResultModel> delAddress(@Field("FKEY") String md5,
                                       @Field("ADDRESS_ID") String id);

    //编辑地址
    @GET("appuserin/useredishipadr?")
    Observable<ResultModel> addressEdit(@QueryMap Map<String, String> map);

    //首页特权
    @FormUrlEncoded
    @POST("apphomein/privilegelist?")
    Observable<HomePrivilegeModel> postHomePrivilege(@Field("FKEY") String md5);

    //首页特权(仅马术，游艇，飞机，高尔夫，豪车)
    @FormUrlEncoded
    @POST("apphomein/privilegedet?")
    Observable<HomePrivilegeModel> privilegePart(@Field("FKEY") String md5, @Field("PRIVILEGE_ID") String id);

    //尊购侧滑页面私人定制列表
    @FormUrlEncoded
    @POST("apppersonalin/personallist?")
    Observable<ZgPersonalTailorModel> postZgPersonalTailorModel(@Field("FKEY") String md5);

    //尊购侧滑页面私人定制详情
    @FormUrlEncoded
    @POST("apppersonalin/personaldet.do?")
    Observable<ZgPersonalTailorDatailModel> postZgPersonalTailorDetail(@Field("FKEY") String md5,
                                                                       @Field("PERSONAL_ID") String id);

    //炫购收藏列表页面
    @FormUrlEncoded
    @POST("appshipin/shipcollect?")
    Observable<CollectionModel> postCollection(@Field("FKEY") String md5,
                                               @Field("HONOURUSER_ID") String id);

    /**
     * 上传头像
     */

    @Multipart
    @POST("appuserin/up.do?")
    Observable<ResultModel> uploadHead(@Query("FKEY") String md5, @Query("HONOURUSER_ID") String id, @Part MultipartBody.Part part);

    /**
     * 上传黑微博内容和图片
     *
     * @param md5
     * @param HONOURUSER_ID
     * @param CONTENT
     * @param fileList
     * @return
     */
    @Multipart
    @POST("appcirclein/addcircle.do?")
    Observable<ResultModel> postSendWeiBo(@Query("FKEY") String md5,
                                          @Query("HONOURUSER_ID") String HONOURUSER_ID,
                                          @Query("CONTENT") String CONTENT,
                                          @Query("TOPIC_ID") String TOPIC_ID,
                                          @Query("TITLE") String TITLE,
                                          @Part List<MultipartBody.Part> fileList,
                                          @Query("TYPE") String type);

    //发布聚会
    @Multipart
    @POST("appconvergein/adddetailparty?")
    Observable<HjReleaseModel> postHjRelease(@QueryMap Map<String, String> map,
                                             @Part List<MultipartBody.Part> fileList);

    /**
     * 上传多张
     */

    @Multipart
    @POST("appuserin/up.do?")
    Observable<ResultModel> uploadListIMG(@Query("FKEY") String md5, @Query("HONOURUSER_ID") String id, @Part List<MultipartBody.Part> partList);
    //


    //查询全部订单接口
    @FormUrlEncoded
    @POST("apporderin/orderalllist?")
    Observable<MyOrderModel> postMyAllOrder(@Field("FKEY") String md5,
                                            @Field("HONOURUSER_ID") String id);

    //指定查询订单接口（如：查询待收货，待付款等。）
    @FormUrlEncoded
    @POST("apporderin/orderconlist?")
    Observable<MyOrderModel> postMyAppointOrder(@Field("FKEY") String md5,
                                                @Field("HONOURUSER_ID") String id,
                                                @Field("ORDERSTATUS") String state);

    //商品分类左边列表
    @FormUrlEncoded
    @POST("appshipin/shipbrandlist?")
    Observable<CategoryLeftModel> postCategoryLeft(@Field("FKEY") String md5);

    //商品分类右边列表
    @FormUrlEncoded
    @POST("appshipin/shipbrandiconlist?")
    Observable<CategoryRightModel> postCategoryRight(@Field("FKEY") String md5,
                                                     @Field("BRAND_ID") String id);

    //获取欢迎引导页的滚动图片数据
    @FormUrlEncoded
    @POST("appbootpagein/bootpagelist?")
    Observable<WelcomeModel> postWelcome(@Field("FKEY") String md5);

    //购物车列表接口(未完成，有待修改)
    @FormUrlEncoded
    @POST("apporderin/shoppingcart?")
    Observable<ShoppingCarModel> postShoppingCar(@Field("FKEY") String md5,
                                                 @Field("HONOURUSER_ID") String id);

    //从购物车删除商品(未完成，有待修改)
    @FormUrlEncoded
    @POST("apporderin/shoppingcartdel?")
    Observable<ResultModel> postShoppingCarDelete(@Field("FKEY") String md5,
                                                  @Field("PRODUCT_ID") String PRODUCT_ID,
                                                  @Field("HONOURUSER_ID") String HONOURUSER_ID);

    //添加商品到购物车
    @FormUrlEncoded
    @POST("apporderin/shoppingcartadd?")
    Observable<ResultModel> postShoppingCarAdd(@Field("FKEY") String md5,
                                               @Field("PRODUCT_ID") String PRODUCT_ID,
                                               @Field("HONOURUSER_ID") String HONOURUSER_ID,
                                               @Field("PRODUCTCOUNT") String PRODUCTCOUNT);

    //尊购界面banner轮播图
    @FormUrlEncoded
    @POST("appshipin/scarouselfigure?")
    Observable<ZgBannerModel> postZgBanner(@Field("FKEY") String md5);

    //尊购模糊查询接口
    @FormUrlEncoded
    @POST("appshipin/shipdimquery?")
    Observable<ZgSearchModel> postZgSearch(@Field("FKEY") String md5,
                                           @Field("HONOURUSER_ID") String HONOURUSER_ID,
                                           @Field("KEYWORDS") String KEYWORDS);

    //首页汇聚玩趴图片接口
    @FormUrlEncoded
    @POST("apphomein/partyimg.do?")
    Observable<HomePlayModel> postHomePlay(@Field("FKEY") String md5);

    //首页荣耀服务图片接口
    @FormUrlEncoded
    @POST("appserverin/server.do?")
    Observable<HomeGloryServerModel> postHomeGloryServer(@Field("FKEY") String md5);

    //首页荣耀音乐
    @FormUrlEncoded
    @POST("appmusicin/musicreclist.do?")
    Observable<HomeGloryMusicModel> postHomeGloryMusic(@Field("FKEY") String md5);

    //首页KTV列表接口
    @FormUrlEncoded
    @POST("appsktvin/sktv.do?")
    Observable<HomeKTVModel> postHomeKTVRecycler(@Field("FKEY") String md5,
                                                 @Field("HONOURUSER_ID") String HONOURUSER_ID);

    //首页高尔夫汇列表接口
    @FormUrlEncoded
    @POST("appserverin/sgolflist.do?")
    Observable<HomeGolfRecyclerModel> postHomeGolfRecycler(@Field("FKEY") String md5,
                                                           @Field("HONOURUSER_ID") String HONOURUSER_ID);

    //首页马术列表接口
    @FormUrlEncoded
    @POST("appserverin/shorselist.do?")
    Observable<HomeHorseRecyclerModel> postHomeHorseRecycler(@Field("FKEY") String md5,
                                                             @Field("HONOURUSER_ID") String HONOURUSER_ID);

    //首页豪车列表接口
    @FormUrlEncoded
    @POST("appserverin/sluxcarlist.do?")
    Observable<HomeCarRecyclerModel> postHomeCarRecycler(@Field("FKEY") String md5,
                                                         @Field("HONOURUSER_ID") String HONOURUSER_ID);

    //首页游艇列表接口
    @FormUrlEncoded
    @POST("appserverin/syachtlist.do?")
    Observable<HomeYachtRecyclerModel> postHomeYachtRecycler(@Field("FKEY") String md5,
                                                             @Field("HONOURUSER_ID") String HONOURUSER_ID);

    //高尔夫汇详情接口
    @FormUrlEncoded
    @POST("appserverin/golfdetail.do?")
    Observable<HomeGolfDetailModel> postHomeGolfDetail(@Field("FKEY") String md5,
                                                       @Field("GOLFSHOP_ID") String GOLFSHOP_ID);

    //马术详情接口
    @FormUrlEncoded
    @POST("appserverin/horsedetail.do?")
    Observable<HomeHorseDetailModel> postHomeHorseDetail(@Field("FKEY") String md5,
                                                         @Field("HORSESHOP_ID") String HORSESHOP_ID);

    //豪车详情接口
    @FormUrlEncoded
    @POST("appserverin/luxcardetail.do?")
    Observable<HomeCarDetailModel> postHomeCarDetail(@Field("FKEY") String md5,
                                                     @Field("LUXCARSHOP_ID") String LUXCARSHOP_ID);

    //游艇详情接口
    @FormUrlEncoded
    @POST("appserverin/yachtdetail.do?")
    Observable<HomeYachtDetailModel> postHomeYachtDetail(@Field("FKEY") String md5,
                                                         @Field("YACHTSHOP_ID") String YACHTSHOP_ID);

    //飞机详情接口
    @FormUrlEncoded
    @POST("appserverin/planedetail.do?")
    Observable<HomeCopterDetailModel> postHomeCopterDetail(@Field("FKEY") String md5);

    //荣耀服务列表详情点击
    @FormUrlEncoded
    @POST("appserverin/serverdetaillist.do?")
    Observable<Object> postHomeGloryHorseDetail(@Field("FKEY") String md5,
                                                @Field("SERVER_ID") String SERVER_ID);

    //订单中心确认收货按钮接口
    @FormUrlEncoded
    @POST("apporderin/shiporderstaupd?")
    Observable<ResultModel> postMyOrderOk(@Field("FKEY") String md5,
                                          @Field("ORDERNUMBER") String ORDERNUMBER,
                                          @Field("HONOURUSER_ID") String HONOURUSER_ID,
                                          @Field("ORDERSTATUS") String ORDERSTATUS);


    //美食筛选
    @GET("appsfoodin/sfoodlistsequence.do?")
    Observable<HomeFoodModel> filterFoodList(@QueryMap Map<String, String> map);

    //Hotel筛选
    @GET("appshotelin/shotellistsequence.do?")
    Observable<HomeHotelModel> filterHotelList(@QueryMap Map<String, String> map);

    //KTV筛选
    @GET("appsktvin/sktvlistsequence.do?")
    Observable<HomeKTVModel> filterKTVList(@QueryMap Map<String, String> map);

    //筛选
    @GET("appsbarin/sbarlistsequence.do?")
    Observable<HomeBarModel> filterBarList(@QueryMap Map<String, String> map);

    //订单中心所有酒吧订单
    @FormUrlEncoded
    @POST("appsbarin/barorderalllist.do?")
    Observable<OrderCenterBarRecyclerModel> postOrderCenterBarRecycler(@Field("FKEY") String md5,
                                                                       @Field("HONOURUSER_ID") String HONOURUSER_ID,
                                                                       @Field("ORDERSTATUS") String ORDERSTATUS);

    //订单中心所有KTV订单
    @FormUrlEncoded
    @POST("appsktvin/ktvorderalllist?")
    Observable<OrderCenterKTVRecyclerModel> postOrderCenterKTVRecycler(@Field("FKEY") String md5,
                                                                       @Field("HONOURUSER_ID") String HONOURUSER_ID,
                                                                       @Field("ORDERSTATUS") String ORDERSTATUS);

    //订单中心所有酒店订单
    @FormUrlEncoded
    @POST("appshotelin/hotelorderalllist.do?")
    Observable<OrderCenterHotelRecyclerModel> postOrderCenterHotelRecycler(@Field("FKEY") String md5,
                                                                           @Field("HONOURUSER_ID") String HONOURUSER_ID,
                                                                           @Field("ORDERSTATUS") String ORDERSTATUS);

    //订单中心所有美食订单
    @FormUrlEncoded
    @POST("appsfoodin/foodorderalllist.do?")
    Observable<OrderCenterFoodRecyclerModel> postOrderCenterFoodRecycler(@Field("FKEY") String md5,
                                                                         @Field("HONOURUSER_ID") String HONOURUSER_ID,
                                                                         @Field("ORDERSTATUS") String ORDERSTATUS);

    //尊购订单状态修改
    @FormUrlEncoded
    @POST("apporderin/shiporderstaupd?")
    Observable<ResultModel> postZgChange(@Field("FKEY") String md5,
                                         @Field("HONOURUSER_ID") String HONOURUSER_ID,
                                         @Field("ORDERNUMBER") String ORDERNUMBER,
                                         @Field("ORDERSTATUS") String ORDERSTATUS);


    @GET("https://liveroom1739272706-api.zego.im/demo/roomlist?appid=1739272706")
    Observable<LiveInfoListModel> pullLive(@Query("FKEY") String md5);

    //首页荣耀杂志列表
    @FormUrlEncoded
    @POST("apphomein/magazinelist?")
    Observable<HomeGloryMagazineModel> postHomeGloryMagazine(@Field("FKEY") String md5);

    //尊购发现页面菜单选项
    @FormUrlEncoded
    @POST("appdiscoverin/caidan.do?")
    Observable<ZgFindTitleModel> postZgFindTiele(@Field("FKEY") String md5);

    //尊购发现页面条目对应的列表
    @FormUrlEncoded
    @POST("appdiscoverin/discoverlist.do?")
    Observable<ZgFindModel> postZgFind(@Field("FKEY") String md5,
                                       @Field("CAIDAN_ID") String CAIDAN_ID);

    //粉丝列表
    @FormUrlEncoded
    @POST("appfriendin/refriendlist?")
    Observable<AbMyFriendModel> myFollowList(@Field("FKEY") String md5, @Field("HONOURUSER_ID") String id);

    //删除好友
    @FormUrlEncoded
    @POST("appfriendin/delfriend?")
    Observable<ResultModel> delFriend(@Field("FKEY") String md5, @Field("HONOURUSER_ID") String id, @Field("REHONOURUSER_ID") String delId);

    //好友列表
    @FormUrlEncoded
    @POST("appfriendin/friendlist?")
    Observable<AbMyFriendModel> myFriendsList(@Field("FKEY") String md5, @Field("HONOURUSER_ID") String id);

    //添加好友
    @FormUrlEncoded
    @POST("appfriendin/addfriend?")
    Observable<ResultModel> addFriends(@Field("FKEY") String md5, @Field("HONOURUSER_ID") String id, @Field("REHONOURUSER_ID") String addId);


    //获取酒店、美食、KTV、酒吧的条件筛选获取
    @FormUrlEncoded
    @POST("appsfoodin/brandstylelist.do?")
    Observable<FoodHotelBarKTVDialogModel> postFoodHotelBarKTVDialog(@Field("FKEY") String md5,
                                                                     @Field("TYPE") String type,
                                                                     @Field("SORTNAME") String sortName);

    //我的页面，圈子中心接口
    @FormUrlEncoded
    @POST("appcirclein/circlelist.do?")
    Observable<MyCircleModel> postCircleCenterRecycle(@Field("FKEY") String md5,
                                                      @Field("HONOURUSER_ID") String HONOURUSER_ID);

    //圈子中心点赞接口
    @FormUrlEncoded
    @POST("appcirclein/dotAgree.do?")
    Observable<ResultModel> postCircleCenterYeah(@Field("FKEY") String md5,
                                                 @Field("HONOURUSER_ID") String HONOURUSER_ID,
                                                 @Field("CIRCLE_ID") String CIRCLE_ID,
                                                 @Field("COMMENT_ID") String COMMENT_ID,
                                                 @Field("STATUS") String status);

    //圈子中心获取评论接口
    @FormUrlEncoded
    @POST("appcirclein/commentlist.do?")
    Observable<CircleCenterCommentRecyclerModel> postCircleCenterCommentRecycler(@Field("FKEY") String md5,
                                                                                 @Field("CIRCLE_ID") String CIRCLE_ID);

    //修改用户个人资料
    @FormUrlEncoded
    @POST("appuserin/userpersonalinfo.do?")
    Observable<ResultModel> postUserInfoChange(@Field("FKEY") String md5,
                                               @Field("HONOURUSER_ID") String HONOURUSER_ID,
                                               @FieldMap Map<String, String> map);

    //设置帐号与安全登录密码修改
    @FormUrlEncoded
    @POST("appuserin/userupdpassword.do?")
    Observable<ResultModel> postSecurityPassWord(@Field("FKEY") String md5,
                                                 @Field("HONOURUSER_ID") String TOHONOURUSER_ID,
                                                 @Field("PASSWORD") String PASSWORD,
                                                 @Field("OLDPASSWORD") String OLDPASSWORD);

    //设置个人资料接口
    @FormUrlEncoded
    @POST("appuserin/getuserinfo.do?")
    Observable<SettingUserInfoModel> postSettingUserInfo(@Field("FKEY") String md5,
                                                         @Field("HONOURUSER_ID") String user_id);

    //圈子中心评论接口
    @FormUrlEncoded
    @POST("appcirclein/addcomment.do?")
    Observable<ResultModel> postCircleCenterComment(@Field("FKEY") String md5,
                                                    @Field("HONOURUSER_ID") String HONOURUSER_ID,
                                                    @Field("CIRCLE_ID") String CIRCLE_ID,
                                                    @Field("COMCONTENT") String COMCONTENT,
                                                    @Field("REPLYHONOURUSER_ID") String REPLYHONOURUSER_ID);

    //电台列表
    @FormUrlEncoded
    @POST("appmusicin/getcategorylist?")
    Observable<MusicDjModel> getMusicDjList(@Field("FKEY") String md5, @Field("cate_sname") String cate_name);

    //电台下的歌曲列表
    @FormUrlEncoded
    @POST("appmusicin/getchannelsong?")
    Observable<MusicDetailListModel> getMusicDjSongList(@Field("FKEY") String md5, @Field("ch_name") String channelName);

    //歌曲详情
    @FormUrlEncoded
    @POST("appmusicin/getsongplay?")
    Observable<MusicSongDetailsModel> getMusicSongDetail(@Field("FKEY") String md5, @Field("songid") String songId);

    //查询歌曲列表
    @FormUrlEncoded
    @POST("appmusicin/getsearchsong?")
    Observable<ResultModel> getMusicQueryList(@Field("FKEY") String md5, @Field("query") String searchStr);

    //音乐排行榜
    @FormUrlEncoded
    @POST("appmusicin/getbilllist?")
    Observable<MusicRankingModel> getRankingList(@Field("FKEY") String md5, @Field("offset") String offset, @Field("type") String type);

    //音乐排行榜(首页)
    @FormUrlEncoded
    @POST("appmusicin/getbilllistall?")
    Observable<MusicRankAllModel> getMusicRanking(@Field("FKEY") String md5, @Field("offset") String offset, @Field("type") String str);

    //获得某首歌曲的歌词
    @FormUrlEncoded
    @POST("appmusicin/getlry?")
    Observable<MusicLrcModel> getMusicLry(@Field("FKEY") String md5, @Field("songid") String songId);

    //每日推荐歌曲
    @FormUrlEncoded
    @POST("appmusicin/getrecommandsonglist?")
    Observable<MusicRecommendModel> getMusicRecommendList(@Field("FKEY") String md5);

    //歌手
    @FormUrlEncoded
    @POST("appmusicin/gethotartist?")
    Observable<MusicSingerModel> getMusicSingerList(@Field("FKEY") String md5, @Field("offset") String offset, @Field("gender") String sexType, @Field("area") String areaType);

    //歌手所有歌曲
    @FormUrlEncoded
    @POST("appmusicin/getsonglist?")
    Observable<MusicSingerSongsModel> getSingerSongs(@Field("FKEY") String md5, @Field("tinguid") String tinguid, @Field("offset") String offset);

    //能量值各能量接口
    @FormUrlEncoded
    @POST("appengrgyin/energylist.do?")
    Observable<MyPowerModel> postMyPower(@Field("FKEY") String md5,
                                         @Field("HONOURUSER_ID") String HONOURUSER_ID);

    //注册时，选择卡种类所对应的图片
    @FormUrlEncoded
    @POST("appbootpagein/getcardimgs?")
    Observable<RegisterCardTypeModel> postRegisterCardType(@Field("FKEY") String md5,
                                                           @Field("CARDTYPE_ID") String CARDTYPE_ID);

    //注册时，选择卡号，手选功能接口
    @FormUrlEncoded
    @POST("appbootpagein/getcardnum?")
    Observable<RegisterChangeNumberModel> postRegisterChangeNumber(@Field("FKEY") String md5,
                                                                   @Field("CARDTYPE_ID") String CARDTYPE_ID);

    //能量值曲线图接口
    @FormUrlEncoded
    @POST("appengrgyin/energyvaluemonth.do?")
    Observable<MyPowerImageModel> postPowerImage(@Field("FKEY") String md5,
                                                 @Field("HONOURUSER_ID") String HONOURUSER_ID);

    //我的界面Vip中心接口
    @FormUrlEncoded
    @POST("appuserin/getmemberinfo.do?")
    Observable<MyVipCenterModel> postMyVipCenter(@Field("FKEY") String md5,
                                                 @Field("HONOURUSER_ID") String HONOURUSER_ID);

    //订单中心评论接口
    @FormUrlEncoded
    @POST("appshipin/sproductaddeva.do?")
    Observable<ResultModel> postOrderCenterComment(@Field("FKEY") String md5,
                                                   @Field("PRODUCT_ID") String PRODUCT_ID,
                                                   @Field("HONOURUSER_ID") String HONOURUSER_ID,
                                                   @Field("EVALUATECONTENT") String EVALUATECONTENT,
                                                   @Field("EVALUATECOINT") String EVALUATECOINT,
                                                   @Field("ISSHOW") String ISSHOW);

    //我的界面获取头像、优惠券、黑咖币、能量值
    @FormUrlEncoded
    @POST("appuserin/getmycoublackenergy.do?")
    Observable<MyDisBlackPowerModel> postDisBlackPower(@Field("FKEY") String md5,
                                                       @Field("HONOURUSER_ID") String HONOURUSER_ID);

    //商品详情接口
    @FormUrlEncoded
    @POST("appshipin/shipdetails.do?")
    Observable<ResponseBody> commodityDteail(@Field("FKEY") String md5,
                                             @Field("PRODUCT_ID") String PRODUCT_ID);

    //根据广告栏位置查询广告
    @FormUrlEncoded
    @POST("appadvertismentin/advertiselist.do?")
    Observable<AdvertisementModel> postAdvertisement(@Field("FKEY") String md5,
                                                     @Field("AD_POSITION") String AD_POSITION);

    //吃喝玩乐获取查询条件
    @FormUrlEncoded
    @POST("appconvergein/getconvergesort.do?")
    Observable<EatDrinkSearchModel> postEatDrinkSearch(@Field("FKEY") String md5,

                                                      @Field("CONVERGE_ID") String CONVERGE_ID);
    //话题列表模糊查询
    @FormUrlEncoded
    @POST("appcirclein/gettopiclist.do?")
    Observable<TopicListModel>  getTopicList(@Field("FKEY") String md5, @Field("TITLE") String title);
    //添加话题单独接口
    @FormUrlEncoded
    @POST("appcirclein/addtopic.do?")
    Observable<TopicListModel>  addTopic(@Field("FKEY") String md5,@Field("HONOURUSER_ID") String userId,@Field("TITLE") String title);
}

