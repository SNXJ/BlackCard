package com.zsh.blackcard.ui.home;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.HomeCarRecyclerAdapter;
import com.zsh.blackcard.adapter.HomeGolfRecyclerAdapter;
import com.zsh.blackcard.adapter.HomeHorseRecyclerAdapter;
import com.zsh.blackcard.adapter.HomeYachtRecyclerAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.custom.HomeTypeConstant;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.HomeCarRecyclerModel;
import com.zsh.blackcard.model.HomeGolfRecyclerModel;
import com.zsh.blackcard.model.HomeHorseRecyclerModel;
import com.zsh.blackcard.model.HomeYachtRecyclerModel;
import com.zsh.blackcard.ui.EatDrinkActivity;
import com.zsh.blackcard.utils.ActivityUtils;
import com.zsh.blackcard.view.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kkkkk on 2017/11/29.
 * 马术、豪车、游艇、高尔夫汇公用页面
 */

public class HomePublicRecyclerActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.title_tv)
    TextView title_tv;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.activity_home_public_banner)
    Banner activity_home_public_banner;

    //马术列表适配器
    private HomeHorseRecyclerAdapter homeHorseRecyclerAdapter;
    //豪车列表适配器
    private HomeCarRecyclerAdapter homeCarRecyclerAdapter;
    //游艇列表适配器
    private HomeYachtRecyclerAdapter homeYachtRecyclerAdapter;
    //高尔夫汇列表适配器
    private HomeGolfRecyclerAdapter homeGolfRecyclerAdapter;

    private List<String> listImage = new ArrayList<>();
    private List<String> listTitle = new ArrayList<>();

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_home_public_recycler);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        String data = getIntent().getStringExtra("data");
        recycler.setLayoutManager(new LinearLayoutManager(this));
        //给列表添加横线
        recycler.addItemDecoration(new SpacesItemDecoration(this, SpacesItemDecoration.VERTICAL_LIST));
        recycler.setNestedScrollingEnabled(false);
        switch (data) {
            case HomeTypeConstant.MORE_TYPE_HORSE:
                title_tv.setText("马术");
                //加载马术列表
                initHorse();
                break;
            case HomeTypeConstant.MORE_TYPE_CAR:
                title_tv.setText("豪车");
                //加载豪车列表
                initCar();
                break;
            case HomeTypeConstant.MORE_TYPE_YACHT:
                title_tv.setText("游艇");
                //加载游艇列表
                initYacht();
                break;
            case HomeTypeConstant.MORE_TYPE_GOLF:
                title_tv.setText("高尔夫");
                //加载高尔夫汇列表
                initGolf();
                break;
        }
    }

    private void initGolf() {
        DataManager.getInstance(this).RequestHttp(NetApi.postHomeGolfRecycler(DataManager.getMd5Str("SORTHIGHGOLF"), "d6a3779de8204dfd9359403f54f7d27c"), new ResultListener<HomeGolfRecyclerModel>() {
            @Override
            public void responseSuccess(HomeGolfRecyclerModel obj) {
                if (obj.getResult().equals("01")) {
                    //加载头部广告banner
                    for (int i = 0; i < obj.getAd().size(); i++) {
                        listImage.add(obj.getAd().get(i).getSHOWIMG());
                        listTitle.add(obj.getAd().get(i).getNAME());
                    }
                    initBanner(listImage,listTitle);
                    homeGolfRecyclerAdapter = new HomeGolfRecyclerAdapter(R.layout.home_public_recycler_item, obj.getPd());
                    recycler.setAdapter(homeGolfRecyclerAdapter);
                    homeGolfRecyclerAdapter.setOnItemClickListener(HomePublicRecyclerActivity.this);
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void initYacht() {
        DataManager.getInstance(this).RequestHttp(NetApi.postHomeYachtRecycler(DataManager.getMd5Str("SORTHIGHYACHT"), "d6a3779de8204dfd9359403f54f7d27c"), new ResultListener<HomeYachtRecyclerModel>() {
            @Override
            public void responseSuccess(HomeYachtRecyclerModel obj) {
                if (obj.getResult().equals("01")) {
                    //加载头部广告banner
                    for (int i = 0; i < obj.getAd().size(); i++) {
                        listImage.add(obj.getAd().get(i).getSHOWIMG());
                        listTitle.add(obj.getAd().get(i).getNAME());
                    }
                    initBanner(listImage,listTitle);
                    homeYachtRecyclerAdapter = new HomeYachtRecyclerAdapter(R.layout.home_public_recycler_item, obj.getPd());
                    recycler.setAdapter(homeYachtRecyclerAdapter);
                    homeYachtRecyclerAdapter.setOnItemClickListener(HomePublicRecyclerActivity.this);
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void initCar() {
        DataManager.getInstance(this).RequestHttp(NetApi.postHomeCarRecycler(DataManager.getMd5Str("SORTHIGHLUXCAR"), "d6a3779de8204dfd9359403f54f7d27c"), new ResultListener<HomeCarRecyclerModel>() {
            @Override
            public void responseSuccess(HomeCarRecyclerModel obj) {
                if (obj.getResult().equals("01")) {
                    //加载头部广告banner
                    for (int i = 0; i < obj.getAd().size(); i++) {
                        listImage.add(obj.getAd().get(i).getSHOWIMG());
                        listTitle.add(obj.getAd().get(i).getNAME());
                    }
                    initBanner(listImage, listTitle);
                    homeCarRecyclerAdapter = new HomeCarRecyclerAdapter(R.layout.home_public_recycler_item, obj.getPd());
                    recycler.setAdapter(homeCarRecyclerAdapter);
                    homeCarRecyclerAdapter.setOnItemClickListener(HomePublicRecyclerActivity.this);
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void initHorse() {
        DataManager.getInstance(this).RequestHttp(NetApi.postHomeHorseRecycler(DataManager.getMd5Str("SORTHIGHHORSE"), "d6a3779de8204dfd9359403f54f7d27c"), new ResultListener<HomeHorseRecyclerModel>() {
            @Override
            public void responseSuccess(HomeHorseRecyclerModel obj) {
                if (obj.getResult().equals("01")) {
                    //加载头部广告banner
                    for (int i = 0; i < obj.getAd().size(); i++) {
                        listImage.add(obj.getAd().get(i).getSHOWIMG());
                        listTitle.add(obj.getAd().get(i).getNAME());
                    }
                    initBanner(listImage,listTitle);
                    homeHorseRecyclerAdapter = new HomeHorseRecyclerAdapter(R.layout.home_public_recycler_item, obj.getPd());
                    recycler.setAdapter(homeHorseRecyclerAdapter);
                    homeHorseRecyclerAdapter.setOnItemClickListener(HomePublicRecyclerActivity.this);
                }
            }

            @Override
            public void onCompleted() {

            }
        });

    }

    //高尔夫汇列表点击
    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        if (adapter instanceof HomeGolfRecyclerAdapter) {
            //高尔夫汇列表点击
            ActivityUtils.startActivityForData(this, HomePublicDetailActivity.class, HomeTypeConstant.MORE_TYPE_GOLF, ((HomeGolfRecyclerModel.PdBean) adapter.getData().get(position)).getGOLFSHOP_ID());
        } else if (adapter instanceof HomeHorseRecyclerAdapter) {
            //马术详情点击
            ActivityUtils.startActivityForData(this, HomePublicDetailActivity.class, HomeTypeConstant.MORE_TYPE_HORSE, ((HomeHorseRecyclerModel.PdBean) adapter.getData().get(position)).getHORSESHOP_ID());
        } else if (adapter instanceof HomeCarRecyclerAdapter) {
            //豪车
            ActivityUtils.startActivityForData(this, HomePublicDetailActivity.class, HomeTypeConstant.MORE_TYPE_CAR, ((HomeCarRecyclerModel.PdBean) adapter.getData().get(position)).getLUXCARSHOP_ID());
        } else {
            //游艇
            ActivityUtils.startActivityForData(this, HomePublicDetailActivity.class, HomeTypeConstant.MORE_TYPE_YACHT, ((HomeYachtRecyclerModel.PdBean) adapter.getData().get(position)).getYACHTSHOP_ID());
        }
    }

    @OnClick(R.id.title_back)
    public void onClick() {
        finish();
    }

    private void initBanner(List<String> listImage, List<String> listTitle) {
        activity_home_public_banner.setImages(listImage);
        activity_home_public_banner.setImageLoader(new MyImageLoader());
        activity_home_public_banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        activity_home_public_banner.setIndicatorGravity(BannerConfig.CENTER);
        activity_home_public_banner.isAutoPlay(true);
        activity_home_public_banner.setDelayTime(3000);
        activity_home_public_banner.setBannerTitles(listTitle);
        activity_home_public_banner.start();
    }

    //banner加载图片类
    private class MyImageLoader extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(HomePublicRecyclerActivity.this).load(path).into(imageView);
        }
    }
}
