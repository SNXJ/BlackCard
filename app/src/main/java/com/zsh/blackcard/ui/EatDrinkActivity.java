package com.zsh.blackcard.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.zhouwei.library.CustomPopWindow;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.BaseApplication;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.EatDrinkRecyclerAdapter;
import com.zsh.blackcard.adapter.ZgOrderCenterAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.EatDrinkRecyclerModel;
import com.zsh.blackcard.model.EatDrinkSearchModel;
import com.zsh.blackcard.model.ResultModel;
import com.zsh.blackcard.untils.ActivityUtils;
import com.zsh.blackcard.untils.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 吃喝玩乐列表页面
 */
public class EatDrinkActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.hj_recycler_detail_title)
    TextView hj_recycler_detail_title;

    //汇聚指定聚会列表
    @BindView(R.id.eat_drink_recycler)
    RecyclerView eat_drink_recycler;

    @BindView(R.id.eat_drink_relative)
    RelativeLayout eat_drink_relative;

    @BindView(R.id.eat_drink_banner)
    Banner eat_drink_banner;

    @BindView(R.id.blackwb_back)
    ImageView blackwb_back;

    private List<String> listBanner = new ArrayList<>();
    private List<String> listTitle = new ArrayList<>();
    private List<String> listSearch = new ArrayList<>();
    private List<String> listSearchId = new ArrayList<>();

    private EatDrinkRecyclerAdapter eatDrinkRecyclerAdapter;
    private ZgOrderCenterAdapter zgOrderCenterAdapter;

    private String data;
    private String title;
    private View viewPop;
    private CustomPopWindow customPopWindow;


    @Override
    protected void initUI() {
        setContentView(R.layout.activity_eat_drink);
        ButterKnife.bind(this);
        initData();
    }

    //吃喝玩乐列表子控件的点击事件
    private class HjChildRecyclerOnItemClick implements BaseQuickAdapter.OnItemChildClickListener {

        @Override
        public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
            switch (view.getId()) {
                //查看指定聚会详情
                case R.id.hj_child_recycler_item_linear:
                    ActivityUtils.startActivityForData(EatDrinkActivity.this, EatDrinkDetailActivity.class, ((EatDrinkRecyclerModel.PdBean) adapter.getData().get(position)).getCONVERGEDETAIL_ID(), title);
                    break;
                case R.id.hj_child_recycler_head_img:

                    break;
                case R.id.tv_add_friend://加好友
                    String id = ((EatDrinkRecyclerModel.PdBean) adapter.getData().get(position)).getHONOURUSER_ID();
                    addFriend(id);
                    break;
            }
        }
    }

    @OnClick({R.id.blackwb_back, R.id.hj_eat_set, R.id.hj_recycler_detail_title})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.blackwb_back:
                finish();
                break;
            case R.id.hj_eat_set:
                //跳转至去发布
                ActivityUtils.startActivityForDataList(this, EatDrinkSetActivity.class, data,listSearch,listSearchId);
                break;
            case R.id.hj_recycler_detail_title:
                showPopWindow(viewPop);
                break;
        }
    }

    /**
     * 显示PopWindow
     *
     * @param viewPop
     */
    private void showPopWindow(View viewPop) {
        customPopWindow = new CustomPopWindow.PopupWindowBuilder(this)
                .setView(viewPop)
                .enableBackgroundDark(true)
                .setBgDarkAlpha(1f)
                .size(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
                .setOutsideTouchable(false)
                .setFocusable(false)
                .create()
                .showAsDropDown(eat_drink_relative, 0, 0);
        hj_recycler_detail_title.setClickable(false);
        blackwb_back.setClickable(false);
    }

    private void initData() {
        Intent intent = getIntent();
        data = intent.getStringExtra("data");
        title = intent.getStringExtra("title");
        hj_recycler_detail_title.setText(title);
        eat_drink_recycler.setNestedScrollingEnabled(false);

        //初始化指定汇聚下所有聚会列表
        DataManager.getInstance(this).RequestHttp(NetApi.postEatDrinkRecycler(DataManager.getMd5Str("PARTYLIST"), "388279486010884096", data, "", ""), new ResultListener<EatDrinkRecyclerModel>() {
            @Override
            public void responseSuccess(EatDrinkRecyclerModel obj) {

                if (obj.getResult().equals("01")) {
                    //加载头部广告banner
                    for (int i = 0; i < obj.getAd().size(); i++) {
                        listBanner.add(obj.getAd().get(i).getSHOWIMG());
                        listTitle.add(obj.getAd().get(i).getNAME());
                    }
                    eat_drink_banner.setImages(listBanner);
                    eat_drink_banner.setImageLoader(new MyImageLoader());
                    eat_drink_banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
                    eat_drink_banner.setIndicatorGravity(BannerConfig.CENTER);
                    eat_drink_banner.isAutoPlay(true);
                    eat_drink_banner.setDelayTime(3000);
                    eat_drink_banner.setBannerTitles(listTitle);
                    eat_drink_banner.start();

                    //加载吃喝玩乐聚会列表
                    for (int i = 0; i < obj.getPd().size(); i++) {
                        if (obj.getPd().get(i).getCONVERGEIMGS().size() != 0) {
                            obj.getPd().get(i).setItemType(1);
                        } else {
                            obj.getPd().get(i).setItemType(2);
                        }
                    }
                    eatDrinkRecyclerAdapter = new EatDrinkRecyclerAdapter(obj.getPd());
                    eat_drink_recycler.setLayoutManager(new LinearLayoutManager(EatDrinkActivity.this));
                    eat_drink_recycler.setAdapter(eatDrinkRecyclerAdapter);
                    eatDrinkRecyclerAdapter.setOnItemChildClickListener(new HjChildRecyclerOnItemClick());
                }
            }

            @Override
            public void onCompleted() {

            }
        });

        //获取吃喝玩乐查询条件
        DataManager.getInstance(this).RequestHttp(NetApi.postEatDrinkSearch(DataManager.getMd5Str("GETCONVERGESORT"), data), new ResultListener<EatDrinkSearchModel>() {
            @Override
            public void responseSuccess(EatDrinkSearchModel obj) {
                if (obj.getResult().equals("01")) {
                    for (int i = 0; i < obj.getPd().size(); i++) {
                        listSearch.add(obj.getPd().get(i).getNAME());
                        listSearchId.add(obj.getPd().get(i).getCONVERGESORT_ID());
                    }
                    zgOrderCenterAdapter = new ZgOrderCenterAdapter(R.layout.zg_my_order_recycler_popwindow_item, listSearch);
                    viewPop = LayoutInflater.from(EatDrinkActivity.this).inflate(R.layout.zg_my_order_popwindow, null);
                    RecyclerView recyclerView = (RecyclerView) viewPop.findViewById(R.id.zg_my_order_popWindow_recycler);
                    recyclerView.setLayoutManager(new GridLayoutManager(EatDrinkActivity.this, 3));
                    recyclerView.setAdapter(zgOrderCenterAdapter);
                    zgOrderCenterAdapter.setOnItemClickListener(EatDrinkActivity.this);
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    //订单筛选点击事件
    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        hj_recycler_detail_title.setText(listSearch.get(position));
        zgOrderCenterAdapter.initSelect(position);
        zgOrderCenterAdapter.notifyDataSetChanged();
        hj_recycler_detail_title.setClickable(true);
        blackwb_back.setClickable(true);
        customPopWindow.dissmiss();
        initSearch(listSearchId.get(position));
    }

    //指定条件查询
    private void initSearch(String converge_id) {
        DataManager.getInstance(this).RequestHttp(NetApi.postEatDrinkRecycler(DataManager.getMd5Str("PARTYLIST"), "388279486010884096", data, "", converge_id), new ResultListener<EatDrinkRecyclerModel>() {
            @Override
            public void responseSuccess(EatDrinkRecyclerModel obj) {

                if (obj.getResult().equals("01")) {
                    //加载头部广告banner
                    listBanner.clear();
                    listTitle.clear();
                    for (int i = 0; i < obj.getAd().size(); i++) {
                        listBanner.add(obj.getAd().get(i).getSHOWIMG());
                        listTitle.add(obj.getAd().get(i).getNAME());
                    }
                    eat_drink_banner.setImages(listBanner);
                    eat_drink_banner.setImageLoader(new MyImageLoader());
                    eat_drink_banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
                    eat_drink_banner.setIndicatorGravity(BannerConfig.CENTER);
                    eat_drink_banner.isAutoPlay(true);
                    eat_drink_banner.setDelayTime(3000);
                    eat_drink_banner.setBannerTitles(listTitle);
                    eat_drink_banner.start();

                    //加载吃喝玩乐聚会列表
                    for (int i = 0; i < obj.getPd().size(); i++) {
                        if (obj.getPd().get(i).getCONVERGEIMGS().size() != 0) {
                            obj.getPd().get(i).setItemType(1);
                        } else {
                            obj.getPd().get(i).setItemType(2);
                        }
                    }
                    eatDrinkRecyclerAdapter.getData().clear();
                    eatDrinkRecyclerAdapter.getData().addAll(obj.getPd());
                    eatDrinkRecyclerAdapter.notifyDataSetChanged();
                    eatDrinkRecyclerAdapter.setOnItemChildClickListener(new HjChildRecyclerOnItemClick());
                }
            }

            @Override
            public void onCompleted() {

            }
        });

    }

    //banner加载图片类
    private class MyImageLoader extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(EatDrinkActivity.this).load(path).into(imageView);
        }
    }

    private void addFriend(String addId) {
        DataManager.getInstance(this).RequestHttp(NetApi.addFriend(DataManager.getMd5Str("FRIENDADD"), BaseApplication.getHonouruserId(), addId), new ResultListener<ResultModel>() {
            @Override
            public void responseSuccess(ResultModel obj) {
                //TODO 修改状态
                UIUtils.showToast("已添加");
            }

            @Override
            public void onCompleted() {

            }
        });
    }
}