package com.zsh.blackcard.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;
import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.ZgShopAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.listener.ZGSlidingListener;
import com.zsh.blackcard.model.ZgBannerModel;
import com.zsh.blackcard.model.ZgShopModel;
import com.zsh.blackcard.ui.CommodityActivity;
import com.zsh.blackcard.ui.ZgSearchActivity;
import com.zsh.blackcard.ui.home.HomeScannerActivity;
import com.zsh.blackcard.untils.ActivityUtils;
import com.zsh.blackcard.view.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by admin on 2017/10/20.
 */

public class ZgFragment extends BaseFragment implements BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.zg_recycler)
    RecyclerView zg_recycler;
    //尊购商品区适配器
    private ZgShopAdapter zgShopAdapter;

    @BindView(R.id.zg_banner)
    Banner zg_banner;
    //设置商品区集合
    private List<ZgShopModel> list = new ArrayList<>();
    //设置轮播区图片集合
    private List<String> bannerList = new ArrayList<>();

    public void setZgSlidingListener(ZGSlidingListener zgSlidingListener) {
        this.zgSlidingListener = zgSlidingListener;
    }

    private ZGSlidingListener zgSlidingListener;


    //普通按钮点击事件
    @OnClick({R.id.zg_myleftimg, R.id.zg_title_search_linear, R.id.im_scanner})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.zg_myleftimg:
                zgSlidingListener.onMeauClick();
                break;
            case R.id.zg_title_search_linear:
                ActivityUtils.startActivity(getActivity(), ZgSearchActivity.class);
                break;
            case R.id.im_scanner:
                ActivityUtils.startActivity(getActivity(), HomeScannerActivity.class);
                break;
        }
    }

    //商品列表点击事件
    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        switch (position) {
            //手表
            case 0:
                ActivityUtils.startActivityForData(getActivity(), CommodityActivity.class, "1b4ed4c57ef04933b97e8def48fc423a", "手表专区");
                break;
            //包袋
            case 1:
                ActivityUtils.startActivityForData(getActivity(), CommodityActivity.class, "a34d1f14a4b7481e8284ad4ba97a496b", "包袋专区");
                break;
            //首饰
            case 2:
                ActivityUtils.startActivityForData(getActivity(), CommodityActivity.class, "2df2c7e628b14341be1e2932cb377c82", "首饰专区");
                break;
            //豪车
            case 3:
                ActivityUtils.startActivityForData(getActivity(), CommodityActivity.class, "c387f598e5c64a1ea275a7ca3e77518c", "豪车专区");
                break;
            //高尔夫汇
            case 4:
                //暂无
                break;
            //飞机游艇
            case 5:
                ActivityUtils.startActivityForData(getActivity(), CommodityActivity.class, "668b21fc68a44080899cfd840107af22", "飞机游艇");
                break;
            //家电数码
            case 6:
                ActivityUtils.startActivityForData(getActivity(), CommodityActivity.class, "a1d59672053f45e1a5499fb1d5850144", "家电数码");
                break;
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
    public void initDate(Bundle savedInstanceState) {
        //初始化轮播
        initBanner();
        //初始化商品区列表
        initShopList();
    }

    //初始化商品区列表
    private void initShopList() {
        for (int i = 1; i < 8; i++) {
            ZgShopModel zgShopModel = new ZgShopModel();
            if (i % 2 != 0) {
                zgShopModel.setItemType(1);
            } else {
                zgShopModel.setItemType(2);
            }
            list.add(zgShopModel);
        }
        if (zgShopAdapter == null) {
            zgShopAdapter = new ZgShopAdapter(list);
            zg_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
            zg_recycler.addItemDecoration(new SpacesItemDecoration(getActivity(), SpacesItemDecoration.VERTICAL_LIST));
            zg_recycler.setAdapter(zgShopAdapter);
            zg_recycler.setNestedScrollingEnabled(false);
            zgShopAdapter.setOnItemClickListener(this);
        }
    }


    //初始化banner轮播区
    private void initBanner() {
        DataManager.getInstance(getActivity()).RequestHttp(NetApi.getInstance(getActivity()).postZgBanner(DataManager.getMd5Str("SCAROUSELFIGURE")), new ResultListener<ZgBannerModel>() {
            @Override
            public void responseSuccess(ZgBannerModel obj) {
                //向集合添加图片网址
                for (int i = 0; i < obj.getPd().getSHOWIMAGES().size(); i++) {
                    bannerList.add(obj.getPd().getSHOWIMAGES().get(i));
                }
                zg_banner.setImages(bannerList);
                zg_banner.setImageLoader(new MyImageLoader());
                zg_banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
                zg_banner.setIndicatorGravity(BannerConfig.CENTER);
                zg_banner.isAutoPlay(true);
                zg_banner.setDelayTime(3000);
                zg_banner.start();
            }

            @Override
            public void onCompleted() {

            }
        });

    }


    @Override
    public View initView(LayoutInflater inflater) {
        view = View.inflate(getActivity(), R.layout.zgfragment, null);
        ButterKnife.bind(this, view);
        return view;
    }


}
