package com.zsh.blackcard.fragment.zgfragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.youth.banner.Banner;
import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.ZgShopAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.ResultModel;
import com.zsh.blackcard.model.ZgBannerModel;
import com.zsh.blackcard.model.ZgHomeListModel;
import com.zsh.blackcard.ui.CommodityActivity;
import com.zsh.blackcard.utils.ActivityUtils;
import com.zsh.blackcard.utils.BannerUtils;
import com.zsh.blackcard.view.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2017/10/20.
 * 尊购首页
 */

public class ZgFragment extends BaseFragment {

    @BindView(R.id.zg_recycler)
    RecyclerView zg_recycler;
    //尊购商品区适配器
    private ZgShopAdapter zgShopAdapter;

    @BindView(R.id.zg_banner)
    Banner zg_banner;
    //设置轮播区图片集合
    private List<String> bannerList = new ArrayList<>();

    //尊购首页列表点击事件
    private class MyOnItem implements BaseQuickAdapter.OnItemClickListener {

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
    }

    @Override
    public void initDate(Bundle savedInstanceState) {
        //初始化轮播】
        initBanner();
        //初始化商品区列表
        initShopList();
    }

    //初始化商品区列表
    private void initShopList() {
        DataManager.getInstance(getActivity()).RequestHttp(NetApi.postZgList(DataManager.getMd5Str("FECTURELIST")), new ResultListener<ZgHomeListModel>() {
            @Override
            public void responseSuccess(ZgHomeListModel obj) {
                if (obj.getResult().equals("01")) {
                    int size = obj.getPd().size();
                    for (int i = 0; i < size; i++) {
                        if (i % 2 == 0) {
                            obj.getPd().get(i).setItemType(1);
                        } else {
                            obj.getPd().get(i).setItemType(2);
                        }
                    }
                    zgShopAdapter = new ZgShopAdapter(obj.getPd());
                    zg_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
                    zg_recycler.addItemDecoration(new SpacesItemDecoration(getActivity(), SpacesItemDecoration.VERTICAL_LIST));
                    zg_recycler.setAdapter(zgShopAdapter);
                    zg_recycler.setNestedScrollingEnabled(false);
                    zgShopAdapter.setOnItemClickListener(new MyOnItem());
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    //初始化banner轮播区
    private void initBanner() {
        DataManager.getInstance(getActivity()).RequestHttp(NetApi.postZgBanner(DataManager.getMd5Str("SCAROUSELFIGURE")), new ResultListener<ZgBannerModel>() {
            @Override
            public void responseSuccess(ZgBannerModel obj) {
                //向集合添加图片网址
                for (int i = 0; i < obj.getPd().getSHOWIMAGES().size(); i++) {
                    bannerList.add(obj.getPd().getSHOWIMAGES().get(i));
                }
                //banner加载
                BannerUtils.bannerNoImg(zg_banner, bannerList, 3000);
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
