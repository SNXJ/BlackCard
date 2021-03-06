package com.zsh.blackcard.fragment;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;
import com.zsh.blackcard.BaseApplication;
import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.HomeGloryMagazineAdapter;
import com.zsh.blackcard.adapter.HomeGloryMusicAdapter;
import com.zsh.blackcard.adapter.HomeGloryServiceAdapter;
import com.zsh.blackcard.adapter.HomeTopAdapter;
import com.zsh.blackcard.adapter.HomeTypeAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.custom.HomeTypeConstant;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.CityEventModel;
import com.zsh.blackcard.model.HomeGloryMagazineModel;
import com.zsh.blackcard.model.HomeGloryMusicModel;
import com.zsh.blackcard.model.HomeGloryServerModel;
import com.zsh.blackcard.model.HomeNewModel;
import com.zsh.blackcard.model.HomePlayModel;
import com.zsh.blackcard.model.HomeTitleNewsModel;
import com.zsh.blackcard.model.HomeTopModel;
import com.zsh.blackcard.music.MusicHomeActivity;
import com.zsh.blackcard.ui.MsgCenterActivity;
import com.zsh.blackcard.ui.MsgSysCenterActivity;
import com.zsh.blackcard.ui.home.HomeBarDetailActivity;
import com.zsh.blackcard.ui.home.HomeFoodDetailActivity;
import com.zsh.blackcard.ui.home.HomeFoodHotelActivity;
import com.zsh.blackcard.ui.home.HomeGloryMagazineActivity;
import com.zsh.blackcard.ui.home.HomeGloryServerDetailActivity;
import com.zsh.blackcard.ui.home.HomeHotelDetailActivity;
import com.zsh.blackcard.ui.home.HomeKTVDetailActivity;
import com.zsh.blackcard.ui.home.HomeMoreActivity;
import com.zsh.blackcard.ui.home.HomeNewsActivity;
import com.zsh.blackcard.ui.home.HomePlaneActivity;
import com.zsh.blackcard.ui.home.HomePublicRecyclerActivity;
import com.zsh.blackcard.ui.home.HomeScannerActivity;
import com.zsh.blackcard.ui.home.HomeSearchActivity;
import com.zsh.blackcard.ui.home.HomeTipView;
import com.zsh.blackcard.ui.home.HomeTrainActivity;
import com.zsh.blackcard.ui.home.MainGloryMagazineActivity;
import com.zsh.blackcard.ui.home.MainMusicActivity;
import com.zsh.blackcard.utils.ActivityUtils;
import com.zsh.blackcard.utils.LogUtils;
import com.zsh.blackcard.utils.MPermissionUtils;
import com.zsh.blackcard.view.selectcity.SelectCityActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by admin on 2017/10/11.
 */

public class HomeFragment extends BaseFragment implements BaseQuickAdapter.OnItemClickListener {


    private String[] titles = new String[]{
            "美食", "酒店", "火车票", "机票", "马术", "游艇", "豪车", "更多"};

    //汇聚玩趴banner图片集合
    private List<String> listBanner = new ArrayList<>();

    private Integer[] images = {
            R.mipmap.home_food,
            R.mipmap.home_hotel,
            R.mipmap.home_train,
            R.mipmap.home_plane,
            R.mipmap.home_horse,
            R.mipmap.home_ship,
            R.mipmap.home_car,
            R.mipmap.home_more,
    };
    List<HomeNewModel> typeList = new ArrayList<>();

    public LocationClient locationClient = null;
    private MyLocation myLocation = new MyLocation();

    static {
        System.loadLibrary("locSDK7a");
    }

    @BindView(R.id.rb_city_home)
    RadioButton rb_city_home;

    private class MyLocation extends BDAbstractLocationListener {

        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            double latitude = bdLocation.getLatitude();    //获取纬度信息
            double longitude = bdLocation.getLongitude();    //获取经度信息
            float radius = bdLocation.getRadius();    //获取定位精度，默认值为0.0f
            String city = bdLocation.getCity();
            if (city.contains("市")) {
                rb_city_home.setText(city.substring(0, city.indexOf("市")));
            }

            BaseApplication.setCITY(city);

            String coorType = bdLocation.getCoorType();
            //获取经纬度坐标类型，以LocationClientOption中设置过的坐标类型为准
            int errorCode = bdLocation.getLocType();
            LogUtils.i("+++++++++", errorCode + "+++++location+++++++" + city);
            DataManager.getInstance(getActivity()).RequestHttp(NetApi.postLocation("TRAPEZE", BaseApplication.getHonouruserId(), String.valueOf(longitude), String.valueOf(latitude)), null);
        }
    }


    //当碎片隐藏时 关闭定位，当打开时开启定位
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (null != locationClient) {
            if (hidden) {
                locationClient.stop();
            } else {
                locationClient.start();
            }
        }

    }

    //初始化定位方法
    private void initLocation() {
        locationClient = new LocationClient(BaseApplication.getInstance());
        locationClient.registerLocationListener(myLocation);

        LocationClientOption option = new LocationClientOption();
        //高精度定位
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        //定位编码
        option.setCoorType("bd09ll");
        //需要详细地址信息
        option.setIsNeedAddress(true);
        //定位周期（毫秒）
        option.setScanSpan(5000 * 12 * 60 * 2);
        locationClient.setLocOption(option);
        locationClient.start();
    }

    //HomeTop 头条的item点击事件
    private class HomeTopOnItemClick implements BaseQuickAdapter.OnItemClickListener {

        @Override
        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            switch (((HomeTopModel.PdBean) adapter.getData().get(position)).getSHOPTYPE()) {
                case "酒吧"://
                    topGoDetails(HomeBarDetailActivity.class, adapter, position);
                    break;
                case "美食":
                    topGoDetails(HomeFoodDetailActivity.class, adapter, position);
                    break;
                case "KTV":
                    topGoDetails(HomeKTVDetailActivity.class, adapter, position);
                    break;
                case "酒店":
                    topGoDetails(HomeHotelDetailActivity.class, adapter, position);
                    break;
            }
        }
    }

    private void topGoDetails(Class<?> cls, BaseQuickAdapter adapter, int position) {
        ActivityUtils.startActivityForData(getActivity(), cls, ((HomeTopModel.PdBean) adapter.getData().get(position)).getSORT_ID());
    }

    //通过接口向Activity调用方法
    public interface SendMainActivity {
        void goIntent();
    }

    private SendMainActivity sendMainActivity;

    //头部选择列表
    @BindView(R.id.home_type_recycler)
    RecyclerView home_type_recycler;
    //头条选择列表
    @BindView(R.id.home_top_recycler)
    RecyclerView home_top_recycler;
    //荣耀服务列表
    @BindView(R.id.home_glory_service_recycler)
    RecyclerView home_glory_service_recycler;
    //荣耀杂志列表
    @BindView(R.id.home_glory_magazine_recycler)
    RecyclerView home_glory_magazine_recycler;
    //汇聚玩趴图片
    @BindView(R.id.home_play_banner)
    Banner home_play_banner;
    //荣耀音乐
    @BindView(R.id.home_glory_music_recycler)
    RecyclerView homeGloryMusicRecycler;

    @BindView(R.id.home_top_tvs)
    TextSwitcher home_top_tvs;
    @BindView(R.id.home_top_pop)
    ImageView home_top_pop;

    //头部列表选择适配器
    private HomeTypeAdapter homeTypeAdapter;
    //头条列表选择适配器
    private HomeTopAdapter homeTopAdapter;
    //荣耀服务列表选择适配器
    private HomeGloryServiceAdapter homeGloryServiceAdapter;
    private HomeGloryMusicAdapter homeGloryMusicAdapter;
    //荣耀杂志列表适配器
    private HomeGloryMagazineAdapter homeGloryMagazineAdapter;

    private HomeTitleNewsModel homeTitleNewsModel;

    private int mSwitcherCount = 0;
    private Handler handler = new Handler(new Handler.Callback() {//2
        @Override
        public boolean handleMessage(Message msg) {
            home_top_tvs.setText(homeTitleNewsModel.getPd().get(mSwitcherCount).getNEWSTITLE());
            mSwitcherCount++;//1,2,0
            if (mSwitcherCount == homeTitleNewsModel.getPd().size()) {
                mSwitcherCount = 0;
            }
            handler.sendEmptyMessageDelayed(1, 3000);
            return false;
        }
    });

    /**
     * 荣耀服务点击列表
     */
    private class HomeGloryServerOnItemClick implements BaseQuickAdapter.OnItemClickListener {

        @Override
        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            ActivityUtils.startActivityForData(getActivity(), HomeGloryServerDetailActivity.class, ((HomeGloryServerModel.PdBean) adapter.getData().get(position)).getSHOPTYPE(), ((HomeGloryServerModel.PdBean) adapter.getData().get(position)).getSERVER_ID());
        }
    }

    private class HomeMusicServerOnItemClick implements BaseQuickAdapter.OnItemClickListener {

        @Override
        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            ActivityUtils.startActivityForData(getActivity(), MusicHomeActivity.class, position + "");
//            switch (position) {
//                case 0:
//                    ActivityUtils.startActivity(getActivity(), MusicSingerActivity.class);
//                    break;
//                case 1:
//                    ActivityUtils.startActivity(getActivity(), MusicRankingActivity.class);
//                    break;
//                case 2:
//                    ActivityUtils.startActivity(getActivity(), MusicLibraryActivity.class);
//                    break;
//                case 3:
//                    ActivityUtils.startActivity(getActivity(), MusicDjActivity.class);
//                    break;
//            }

        }
    }

    /**
     * 所有权限列表的点击事件
     */
    private class HomeTypeOnItemClick implements BaseQuickAdapter.OnItemClickListener {

        @Override
        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            switch (position) {
                //美食
                case 0:
                    ActivityUtils.startActivityForData(getActivity(), HomeFoodHotelActivity.class, HomeTypeConstant.MORE_TYPE_FOOD);
                    break;
                //酒店
                case 1:
                    ActivityUtils.startActivityForData(getActivity(), HomeFoodHotelActivity.class, HomeTypeConstant.MORE_TYPE_HOTEL);
                    break;
                //火车票
                case 2:
                    ActivityUtils.startActivity(getActivity(), HomeTrainActivity.class);
                    break;
                //机票
                case 3:
                    ActivityUtils.startActivity(getActivity(), HomePlaneActivity.class);
                    break;
                //马术
                case 4://
                    ActivityUtils.startActivityForData(getActivity(), HomePublicRecyclerActivity.class, HomeTypeConstant.MORE_TYPE_HORSE);
                    break;
                //游艇
                case 5:
                    //游艇详情界面
//                    ActivityUtils.startActivity(getActivity(), HomeCruiseShipActivity.class);
                    ActivityUtils.startActivityForData(getActivity(), HomePublicRecyclerActivity.class, HomeTypeConstant.MORE_TYPE_YACHT);
                    break;
                //豪车
                case 6:
                    //豪车详情页面
//                    ActivityUtils.startActivity(getActivity(), HomeCarDetailActivity.class);
                    ActivityUtils.startActivityForData(getActivity(), HomePublicRecyclerActivity.class, HomeTypeConstant.MORE_TYPE_CAR);
                    break;
                //更多
                case 7:
                    ActivityUtils.startActivity(getActivity(), HomeMoreActivity.class);
                    break;
            }
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //实例化接口
        sendMainActivity = (SendMainActivity) getActivity();
    }

    //荣耀杂志点击事件
    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        //TODO

        switch (position) {
            case 0:
                ActivityUtils.startActivityForData(getActivity(), HomeGloryMagazineActivity.class, "0", ((HomeGloryMagazineModel.PdBean) adapter.getData().get(position)).getSHOWIMG());
                break;
            case 1:
                ActivityUtils.startActivityForData(getActivity(), HomeGloryMagazineActivity.class, "1", ((HomeGloryMagazineModel.PdBean) adapter.getData().get(position)).getSHOWIMG());
                break;
            case 2:
                ActivityUtils.startActivityForData(getActivity(), HomeGloryMagazineActivity.class, "2", ((HomeGloryMagazineModel.PdBean) adapter.getData().get(position)).getSHOWIMG());
                break;
            case 3:
                ActivityUtils.startActivityForData(getActivity(), HomeGloryMagazineActivity.class, "3", ((HomeGloryMagazineModel.PdBean) adapter.getData().get(position)).getSHOWIMG());
                break;
            case 4:
                ActivityUtils.startActivityForData(getActivity(), HomeGloryMagazineActivity.class, "4", ((HomeGloryMagazineModel.PdBean) adapter.getData().get(position)).getSHOWIMG());
                break;
        }
    }

    @Override
    public void initDate(Bundle savedInstanceState) {
        //初始化定位
        requestLocationPer();
        //初始化类型选择列表（美食，酒店，品鉴...）
        for (int i = 0; i < titles.length; i++) {
            HomeNewModel pic = new HomeNewModel();
            pic.setImageId(images[i]);
            pic.setTitle(titles[i]);
            typeList.add(pic);
        }
        homeTypeAdapter = new HomeTypeAdapter(R.layout.home_type_recycler_item, typeList);
        home_type_recycler.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        home_type_recycler.setNestedScrollingEnabled(false);
        home_type_recycler.setAdapter(homeTypeAdapter);
        homeTypeAdapter.setOnItemClickListener(new HomeTypeOnItemClick());
        //初始化头条文字滚动器
        home_top_tvs.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getActivity());
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                textView.setTextColor(getResources().getColor(R.color.recharge_text));
                textView.setGravity(Gravity.CENTER_VERTICAL);
                return textView;
            }
        });
        //给滚动文字设置滚动动画
        home_top_tvs.setInAnimation(getActivity(), R.anim.enter_bottom);
        home_top_tvs.setOutAnimation(getActivity(), R.anim.leave_top);

        //请求头条滚动文字
        DataManager.getInstance(getActivity()).RequestHttp(NetApi.postHomeTitleNews(DataManager.getMd5Str("NEWSLIST")), new ResultListener<HomeTitleNewsModel>() {
            @Override
            public void responseSuccess(HomeTitleNewsModel obj) {
                homeTitleNewsModel = obj;
                handler.removeMessages(1);
                handler.sendEmptyMessage(1);
            }

            @Override
            public void onCompleted() {

            }
        });


        //初始化头条列表 2.4.6.8酒吧 三亚国际饭店 麦乐迪KTV
        DataManager.getInstance(getActivity()).RequestHttp(NetApi.postHomePage(DataManager.getMd5Str("COMMEND")), new ResultListener<HomeTopModel>() {
            @Override
            public void responseSuccess(HomeTopModel obj) {
                System.out.println(obj);
                for (int i = 0; i < obj.getPd().size(); i++) {
                    if (i == 0) {
                        obj.getPd().get(i).setItemType(1);
                    } else if (i == obj.getPd().size() - 1) {
                        obj.getPd().get(i).setItemType(3);
                    } else {
                        obj.getPd().get(i).setItemType(2);
                    }
                }

                //三亚国际饭店
                if (homeTopAdapter == null) {
                    homeTopAdapter = new HomeTopAdapter(obj.getPd(), getActivity());
                    home_top_recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
                    home_top_recycler.setAdapter(homeTopAdapter);
                    home_top_recycler.setNestedScrollingEnabled(false);
                    homeTopAdapter.setOnItemClickListener(new HomeTopOnItemClick());
                }
            }

            @Override
            public void onCompleted() {

            }
        });

        //初始化荣耀服务列表
        DataManager.getInstance(getActivity()).RequestHttp(NetApi.postHomeGloryServer(DataManager.getMd5Str("SERVER")), new ResultListener<HomeGloryServerModel>() {
            @Override
            public void responseSuccess(HomeGloryServerModel obj) {
                for (int i = 0; i < obj.getPd().size(); i++) {
                    if (i == 0) {
                        obj.getPd().get(i).setItemType(1);
                    } else if (i == obj.getPd().size() - 1) {
                        obj.getPd().get(i).setItemType(3);
                    } else {
                        obj.getPd().get(i).setItemType(2);
                    }
                }

                if (homeGloryServiceAdapter == null) {
                    homeGloryServiceAdapter = new HomeGloryServiceAdapter(obj.getPd());
                    home_glory_service_recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
                    home_glory_service_recycler.setNestedScrollingEnabled(false);
                    home_glory_service_recycler.setAdapter(homeGloryServiceAdapter);
                    homeGloryServiceAdapter.setOnItemClickListener(new HomeGloryServerOnItemClick());
                }

            }

            @Override
            public void onCompleted() {

            }
        });

        //初始化汇聚玩趴图片接口
        DataManager.getInstance(getActivity()).RequestHttp(NetApi.postHomePlay(DataManager.getMd5Str("PARTY")), new ResultListener<HomePlayModel>() {
            @Override
            public void responseSuccess(HomePlayModel obj) {
                if (obj.getResult().equals("01")) {

                    for (int i = 0; i < obj.getPd().size(); i++) {
                        listBanner.add(obj.getPd().get(i).getPARTYIMG());
                    }

                    home_play_banner.setOnBannerListener(new MyPlayBanner());
                    home_play_banner.setImages(listBanner);
                    home_play_banner.setImageLoader(new MyImageLoader());
                    home_play_banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
                    home_play_banner.setIndicatorGravity(BannerConfig.CENTER);
                    home_play_banner.isAutoPlay(true);
                    home_play_banner.setDelayTime(3000);
                    home_play_banner.start();
                }
            }

            @Override
            public void onCompleted() {

            }
        });

        //初始化荣耀杂志列表
        DataManager.getInstance(getActivity()).RequestHttp(NetApi.postHomeGloryMagazine(DataManager.getMd5Str("MAGAZINE")), new ResultListener<HomeGloryMagazineModel>() {
            @Override
            public void responseSuccess(HomeGloryMagazineModel obj) {
                for (int i = 0; i < obj.getPd().size(); i++) {
                    if (i == 0) {
                        obj.getPd().get(i).setItemType(1);
                    } else if (i == obj.getPd().size() - 1) {
                        obj.getPd().get(i).setItemType(3);
                    } else {
                        obj.getPd().get(i).setItemType(2);
                    }
                }

                if (homeGloryMagazineAdapter == null) {
                    homeGloryMagazineAdapter = new HomeGloryMagazineAdapter(obj.getPd());
                    home_glory_magazine_recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
                    home_glory_magazine_recycler.setAdapter(homeGloryMagazineAdapter);
                    home_glory_magazine_recycler.setNestedScrollingEnabled(false);
                    homeGloryMagazineAdapter.setOnItemClickListener(HomeFragment.this);
                }
            }

            @Override
            public void onCompleted() {

            }
        });

        //初始化荣耀音乐
        DataManager.getInstance(getActivity()).RequestHttp(NetApi.postHomeGloryMusic(DataManager.getMd5Str("MUSICLIST")), new ResultListener<HomeGloryMusicModel>() {
            @Override
            public void responseSuccess(HomeGloryMusicModel obj) {
                for (int i = 0; i < obj.getPd().size(); i++) {
                    if (i == 0) {
                        obj.getPd().get(i).setItemType(1);
                    } else if (i == obj.getPd().size() - 1) {
                        obj.getPd().get(i).setItemType(3);
                    } else {
                        obj.getPd().get(i).setItemType(2);
                    }
                }

                if (homeGloryMusicAdapter == null) {
                    homeGloryMusicAdapter = new HomeGloryMusicAdapter(obj.getPd());
                    homeGloryMusicRecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
                    homeGloryMusicRecycler.setNestedScrollingEnabled(false);
                    homeGloryMusicRecycler.setAdapter(homeGloryMusicAdapter);
                    homeGloryMusicAdapter.setOnItemClickListener(new HomeMusicServerOnItemClick());
                }

            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private class MyPlayBanner implements OnBannerListener {

        @Override
        public void OnBannerClick(int position) {
            if (sendMainActivity != null) {
                sendMainActivity.goIntent();
            }
        }
    }

    //banner加载图片类
    private class MyImageLoader extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(getActivity()).load(path).into(imageView);
        }
    }

    @Override
    public View initView(LayoutInflater inflater) {
        View view = View.inflate(getActivity(), R.layout.homefragment, null);
        ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);
        return view;
    }

    //title头条新闻标题点击事件
    @OnClick(R.id.home_top_tvs)
    public void titleNewsOnClick() {
        //根据不同的新闻标题id，加载不同的页面详情
//        switch (mSwitcherCount) {
//            case 0:
//                ActivityUtils.startActivityForData(getActivity(), HomeTopNewsDetailActivity.class, homeTitleNewsModel.getPd().get(homeTitleNewsModel.getPd().size() - 1).getNEWS_ID());
//                break;
//            case 1:
//                ActivityUtils.startActivityForData(getActivity(), HomeTopNewsDetailActivity.class, homeTitleNewsModel.getPd().get(mSwitcherCount - 1).getNEWS_ID());
//                break;
//            case 2:
//                ActivityUtils.startActivityForData(getActivity(), HomeTopNewsDetailActivity.class, homeTitleNewsModel.getPd().get(mSwitcherCount - 1).getNEWS_ID());
//                break;
        //暂时跳转至发现页面
        ActivityUtils.startActivity(getActivity(), HomeNewsActivity.class);
//        }
    }

    private HomeTipView topDialog;

    //普通控件的onClick事件
    @OnClick({R.id.home_top_pop, R.id.rb_city_home, R.id.home_search_linear, R.id.home_glory_magazine_rl, R.id.home_music_rl})
    public void onClick(View view) {
        switch (view.getId()) {
//            case R.id.home_play_img:
//
//                break;
            case R.id.rb_city_home:
                ActivityUtils.startActivity(getActivity(), SelectCityActivity.class);
                break;
            case R.id.home_top_pop:
                if (topDialog == null) {
                    topDialog = new HomeTipView();
                }
                topDialog.show(getFragmentManager(), "Show", view);
                topDialog.setOnHomeTipItemClick(topPopItemListener);
                break;
            //搜索界面
            case R.id.home_search_linear:
                ActivityUtils.startActivity(getActivity(), HomeSearchActivity.class);
                break;
            case R.id.home_glory_magazine_rl://杂志
                ActivityUtils.startActivity(getActivity(), MainGloryMagazineActivity.class);
                break;
            case R.id.home_music_rl://音乐
                ActivityUtils.startActivity(getActivity(), MainMusicActivity.class);
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(CityEventModel event) {
        rb_city_home.setText(event.getCity());
    }

    private HomeTipView.OnHomeTipItemClick topPopItemListener = new HomeTipView.OnHomeTipItemClick() {
        @Override
        public void homeTipItemClick(int position) {
            switch (position) {
                case 0:
                    requestCAMERA();
                    break;
                case 1:
                    ActivityUtils.startActivity(getActivity(), MsgCenterActivity.class);
                    break;
                case 2:
                    ActivityUtils.startActivity(getActivity(), MsgSysCenterActivity.class);
                    break;
                case 3:
                    ActivityUtils.startActivity(getActivity(), MsgCenterActivity.class);
                    break;
            }
        }
    };

    private void requestCAMERA() {
        String[] PERMISSIONS_STORAGE = {
                Manifest.permission.CAMERA
        };
        MPermissionUtils.requestPermissionsResult(this, 1, PERMISSIONS_STORAGE
                , new MPermissionUtils.OnPermissionListener() {
                    @Override
                    public void onPermissionGranted() {
                        ActivityUtils.startActivity(getActivity(), HomeScannerActivity.class);
                    }

                    @Override
                    public void onPermissionDenied() {
                        MPermissionUtils.showTipsDialog(getActivity());
                    }
                });

    }

    private void requestLocationPer() {
        String[] PERMISSIONS_STORAGE = {
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
        };
        MPermissionUtils.requestPermissionsResult(this, 1, PERMISSIONS_STORAGE
                , new MPermissionUtils.OnPermissionListener() {
                    @Override
                    public void onPermissionGranted() {
                        initLocation();
                    }

                    @Override
                    public void onPermissionDenied() {
                        MPermissionUtils.showTipsDialog(getActivity());
                    }
                });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}