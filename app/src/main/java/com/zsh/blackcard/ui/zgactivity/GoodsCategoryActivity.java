package com.zsh.blackcard.ui.zgactivity;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.CategoryLeftAdapter;
import com.zsh.blackcard.adapter.CategoryRightAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.custom.HomeTypeConstant;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.CategoryLeftModel;
import com.zsh.blackcard.model.CategoryRightModel;
import com.zsh.blackcard.ui.home.HomeFoodHotelActivity;
import com.zsh.blackcard.utils.UIUtils;
import com.zsh.blackcard.view.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Name: GoodsCategory
 * Author: SNXJ
 * Date: 2017-11-12
 * Description:商品分类列表：
 */
public class GoodsCategoryActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {
    //商品分类左边列表
    @BindView(R.id.goods_category_recycler_left)
    RecyclerView goods_category_recycler_left;
    //商品分类右边列表
    @BindView(R.id.goods_category_recycler_right)
    RecyclerView goods_category_recycler_right;
    //广告
    @BindView(R.id.goods_banner)
    Banner goods_banner;
    @BindView(R.id.search_three_br)
    RadioButton search_three_br;
    @BindView(R.id.goods_category_relative)
    RelativeLayout goods_category_relative;
    //商品分类左边列表适配器
    private CategoryLeftAdapter categoryLeftAdapter;
    //商品分类右边列表适配器
    private CategoryRightAdapter categoryRightAdapter;

    private List<String> listBanner = new ArrayList<>();
    private List<String> listSearch = new ArrayList<>();
    private List<String> listSearchId = new ArrayList<>();
    private String brand_id = "";

    @Override
    protected void initUI() {
        setContentView(R.layout.goods_category_avtivity);
        ButterKnife.bind(this);
        initData();
    }

    @OnClick({R.id.back_img, R.id.search_one_rb, R.id.search_two_rb, R.id.search_three_br})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.search_one_rb:
//                UIUtils.showToast("点击了1");
                break;
            case R.id.search_two_rb:
//                UIUtils.showToast("点击了2");
                break;
            case R.id.search_three_br:
                showSearch();
                break;
            case R.id.back_img:
                finish();
                break;
        }
    }

    //显示筛选条件框
    private void showSearch() {

        OptionsPickerView pvOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                initRecyclerRightSearch(listSearchId.get(options1));
            }
        })
                .setSubmitColor(Color.GRAY)
                .setCancelColor(Color.GRAY)
                .setTitleBgColor(Color.WHITE)
                .setDividerColor(Color.WHITE)
                .setContentTextSize(16)
                .setLineSpacingMultiplier(2f)
                .build();
        pvOptions.setNPicker(listSearch, null, null);
        pvOptions.show();
    }

    //条件筛选查询
    private void initRecyclerRightSearch(String searchId) {
        DataManager.getInstance(this).RequestHttp(NetApi.postCategoryRight(DataManager.getMd5Str("SHIPPBUSINESS"), brand_id, searchId), new ResultListener<CategoryRightModel>() {
            @Override
            public void responseSuccess(CategoryRightModel obj) {
                if (obj.getResult().equals("01")) {
                    //如果适配器为空则创建新适配器，如果不为空则刷新。
                    categoryRightAdapter.getData().clear();
                    categoryRightAdapter.getData().addAll(obj.getPd());
                    categoryRightAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void initData() {
        goods_category_recycler_right.setNestedScrollingEnabled(false);
        //商品分类左边列表
        DataManager.getInstance(this).RequestHttp(NetApi.postCategoryLeft(DataManager.getMd5Str("SHIPBR")), new ResultListener<CategoryLeftModel>() {
            @Override
            public void responseSuccess(CategoryLeftModel obj) {
                categoryLeftAdapter = new CategoryLeftAdapter(R.layout.category_left_item, obj.getPd());
                goods_category_recycler_left.setLayoutManager(new LinearLayoutManager(GoodsCategoryActivity.this));
                goods_category_recycler_left.addItemDecoration(new SpacesItemDecoration(GoodsCategoryActivity.this, SpacesItemDecoration.VERTICAL_LIST));
                goods_category_recycler_left.setAdapter(categoryLeftAdapter);
                categoryLeftAdapter.setOnItemClickListener(GoodsCategoryActivity.this);
                //如果左边列表加载成功，则默认加载列表中的第一个子列表
                initRecyclerRight(obj.getPd().get(0).getBRAND_ID(), "");
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    //加载右边列表的适配器
    private void initRecyclerRight(String brand_id, String BRANDICON_ID) {
        this.brand_id = brand_id;
        DataManager.getInstance(this).RequestHttp(NetApi.postCategoryRight(DataManager.getMd5Str("SHIPPBUSINESS"), brand_id, BRANDICON_ID), new ResultListener<CategoryRightModel>() {
            @Override
            public void responseSuccess(CategoryRightModel obj) {
                if (obj.getResult().equals("01")) {
                    //加载Banner广告
                    initBanner(obj.getAdList());
                    //加载筛选条件
                    listSearch.clear();
                    listSearchId.clear();
                    for (int i = 0; i < obj.getBrandIconList().size(); i++) {
                        listSearch.add(obj.getBrandIconList().get(i).getBRANDNAME());
                        listSearchId.add(obj.getBrandIconList().get(i).getBRANDICON_ID());
                    }
                    //如果适配器为空则创建新适配器，如果不为空则刷新。
                    if (categoryRightAdapter == null) {
                        categoryRightAdapter = new CategoryRightAdapter(R.layout.category_right_item_new, obj.getPd());
                        goods_category_recycler_right.setLayoutManager(new LinearLayoutManager(GoodsCategoryActivity.this));
                        goods_category_recycler_right.setAdapter(categoryRightAdapter);
                    } else {
                        categoryRightAdapter.getData().clear();
                        categoryRightAdapter.getData().addAll(obj.getPd());
                        categoryRightAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void initBanner(List<CategoryRightModel.AdListBean> adList) {
        listBanner.clear();
        for (int i = 0; i < adList.size(); i++) {
            listBanner.add(adList.get(i).getSHOWIMG());
        }
        goods_banner.setImages(listBanner);
        goods_banner.setImageLoader(new MyImageLoader());
        goods_banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        goods_banner.setIndicatorGravity(BannerConfig.CENTER);
        goods_banner.isAutoPlay(true);
        goods_banner.setDelayTime(3000);
        goods_banner.start();
    }

    //banner加载图片类
    private class MyImageLoader extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(GoodsCategoryActivity.this).load(path).into(imageView);
        }
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        //每次点击其他item，刷新列表。
        categoryLeftAdapter.selectState(position);
        categoryLeftAdapter.notifyDataSetChanged();
        //加载右边列表
        initRecyclerRight(((CategoryLeftModel.PdBean) adapter.getData().get(position)).getBRAND_ID(), "");
    }
}
