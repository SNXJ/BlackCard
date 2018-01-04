package com.zsh.blackcard.ui.home;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
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
import com.zsh.blackcard.BaseApplication;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.HomeBarAdapter;
import com.zsh.blackcard.adapter.HomeFoodAdapter;
import com.zsh.blackcard.adapter.HomeHotelAdapter;
import com.zsh.blackcard.adapter.HomeKTVAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.custom.HomeTypeConstant;
import com.zsh.blackcard.custom.PublicDialog;
import com.zsh.blackcard.listener.FilterListener;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.FoodHotelBarKTVDialogModel;
import com.zsh.blackcard.model.HomeBarModel;
import com.zsh.blackcard.model.HomeFoodModel;
import com.zsh.blackcard.model.HomeHotelModel;
import com.zsh.blackcard.model.HomeKTVModel;
import com.zsh.blackcard.utils.ActivityUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 美食和酒店
 */
public class HomeFoodHotelActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.im_back)
    ImageView imBack;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.rb_sort)
    RadioButton rbSort;
    @BindView(R.id.rb_brand)
    RadioButton rbBrand;
    @BindView(R.id.rb_filter)
    RadioButton rbFilter;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.rl_hotel_empty)
    RelativeLayout rl_empty;
    @BindView(R.id.banner)
    Banner banner;

    private HomeFoodAdapter foodAdapter;
    private HomeHotelAdapter hotelAdapter;
    private HomeBarAdapter barAdapter;
    private HomeKTVAdapter ktvAdapter;
    private String type;
    private List<String> searchList = new ArrayList<>();
    private List<String> listBanner = new ArrayList<>();
    private List<String> listTitle = new ArrayList<>();

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_home_food_hotel);
        ButterKnife.bind(this);
        type = getIntent().getStringExtra("data");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setNestedScrollingEnabled(false);
        switch (type) {
            case HomeTypeConstant.MORE_TYPE_FOOD:
                initFoodData();
                break;
            case HomeTypeConstant.MORE_TYPE_HOTEL:
                initHotelData();
                break;
            case HomeTypeConstant.MORE_TYPE_BAR:
                initBarData();
                break;
            case HomeTypeConstant.MORE_TYPE_KTV:
                initKTVData();
                break;
        }
    }

    private void initKTVData() {
        DataManager.getInstance(this).RequestHttp(NetApi.postHomeKTVRecycler(DataManager.getMd5Str("SORTKTV"), "d6a3779de8204dfd9359403f54f7d27c"), new ResultListener<HomeKTVModel>() {
            @Override
            public void responseSuccess(HomeKTVModel obj) {
                initKTVBanner(obj);
                notifyKTVAdapter(obj);

            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void initBarData() {
        DataManager.getInstance(this).RequestHttp(NetApi.postHomeBarList(DataManager.getMd5Str("SORTBAR")), new ResultListener<HomeBarModel>() {
            @Override
            public void responseSuccess(HomeBarModel obj) {
                initBarBanner(obj);
                notifyBarAdapter(obj);

            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void initHotelData() {
        DataManager.getInstance(this).RequestHttp(NetApi.postHomeHotelList(DataManager.getMd5Str("SORTHOTEL")), new ResultListener<HomeHotelModel>() {
            @Override
            public void responseSuccess(HomeHotelModel obj) {
                initHotelBanner(obj);
                notifyHotelAdapter(obj);
            }

            @Override
            public void onCompleted() {

            }
        });

    }

    Map<String, String> map = new TreeMap<>();

    private void filterFoodData(String str1, String str2, String str3, String str4) {
        map.put("FKEY", DataManager.getMd5Str("SORTFOODSEQUENCE"));
        map.put("HONOURUSER_ID", BaseApplication.HONOURUSER_ID);
        map.put("COLUMN", str1);
        map.put("SEQUENCE", str2);
        map.put("BRAND", str3);
        map.put("STYLE", str4);
        DataManager.getInstance(this).RequestHttp(NetApi.filterFoodList(map), new ResultListener<HomeFoodModel>() {
            @Override
            public void responseSuccess(HomeFoodModel obj) {
                notifyFoodAdapter(obj);
            }

            @Override
            public void onCompleted() {

            }
        });

    }

    private void filterHotelData(String str1, String str2, String str3, String str4) {
        map.put("FKEY", DataManager.getMd5Str("SORTHOTELSEQUENCE"));
        map.put("HONOURUSER_ID", BaseApplication.HONOURUSER_ID);
        map.put("COLUMN", str1);
        map.put("SEQUENCE", str2);
        map.put("BRAND", str3);
        map.put("STYLE", str4);
        DataManager.getInstance(this).RequestHttp(NetApi.filterHotelList(map), new ResultListener<HomeHotelModel>() {
            @Override
            public void responseSuccess(HomeHotelModel obj) {
                notifyHotelAdapter(obj);
            }

            @Override
            public void onCompleted() {

            }
        });

    }

    private void filterKTVData(String str1, String str2, String str3, String str4) {
        map.put("FKEY", DataManager.getMd5Str("SORTKTVSEQUENCE"));
        map.put("HONOURUSER_ID", BaseApplication.HONOURUSER_ID);
        map.put("COLUMN", str1);
        map.put("SEQUENCE", str2);
        map.put("BRAND", str3);
        map.put("STYLE", str4);
        DataManager.getInstance(this).RequestHttp(NetApi.filterKTVList(map), new ResultListener<HomeKTVModel>() {
            @Override
            public void responseSuccess(HomeKTVModel obj) {
                notifyKTVAdapter(obj);
            }

            @Override
            public void onCompleted() {

            }
        });

    }

    private void notifyKTVAdapter(final HomeKTVModel obj) {
        if (null != ktvAdapter) {
            ktvAdapter.notifyDataSetChanged();
        } else {
            ktvAdapter = new HomeKTVAdapter(obj.getPd(), HomeFoodHotelActivity.this);
            recyclerView.setAdapter(ktvAdapter);
        }

        ktvAdapter.setEmptyView(R.layout.home_hotel_empty_layout, recyclerView);

        ktvAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ActivityUtils.startActivityForData(HomeFoodHotelActivity.this, HomeKTVDetailActivity.class, obj.getPd().get(position).getSORTKTV_ID());
            }
        });
    }


    private void filterBarData(String str1, String str2, String str3, String str4) {
        map.put("FKEY", DataManager.getMd5Str("SORTBARSEQUENCE"));
        map.put("HONOURUSER_ID", BaseApplication.HONOURUSER_ID);
        map.put("COLUMN", str1);
        map.put("SEQUENCE", str2);
        map.put("BRAND", str3);
        map.put("STYLE", str4);
        DataManager.getInstance(this).RequestHttp(NetApi.filterBarList(map), new ResultListener<HomeBarModel>() {
            @Override
            public void responseSuccess(HomeBarModel obj) {
                notifyBarAdapter(obj);
            }

            @Override
            public void onCompleted() {

            }
        });

    }

    private void notifyBarAdapter(final HomeBarModel obj) {
        if (null != barAdapter) {
            barAdapter.notifyDataSetChanged();
        } else {
            barAdapter = new HomeBarAdapter(obj.getPd(), HomeFoodHotelActivity.this);
            recyclerView.setAdapter(barAdapter);
        }
        barAdapter.setEmptyView(R.layout.home_hotel_empty_layout, recyclerView);
        barAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ActivityUtils.startActivityForData(HomeFoodHotelActivity.this, HomeBarDetailActivity.class, obj.getPd().get(position).getSORTBAR_ID());
            }
        });
    }

    private void notifyHotelAdapter(final HomeHotelModel obj) {
        if (null != hotelAdapter) {
            hotelAdapter.notifyDataSetChanged();
        } else {
            hotelAdapter = new HomeHotelAdapter(obj.getPd(), HomeFoodHotelActivity.this);
            recyclerView.setAdapter(hotelAdapter);
        }
        hotelAdapter.setEmptyView(R.layout.home_hotel_empty_layout, recyclerView);
        hotelAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ActivityUtils.startActivityForData(HomeFoodHotelActivity.this, HomeHotelDetailActivity.class, obj.getPd().get(position).getSORTHOTEL_ID());
            }
        });
    }

    //美食加载
    private void notifyFoodAdapter(final HomeFoodModel obj) {
        if (null != foodAdapter) {
            foodAdapter.notifyDataSetChanged();
        } else {
            foodAdapter = new HomeFoodAdapter(obj.getPd(), HomeFoodHotelActivity.this);
            recyclerView.setAdapter(foodAdapter);
        }
        foodAdapter.setEmptyView(R.layout.home_hotel_empty_layout, recyclerView);
        foodAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ActivityUtils.startActivityForData(HomeFoodHotelActivity.this, HomeFoodDetailActivity.class, obj.getPd().get(position).getSORTFOOD_ID());
            }
        });
    }

    private void initBanner(List<String> listBanner,List<String> listTitle){
        banner.setImages(listBanner);
        banner.setImageLoader(new HomeFoodHotelActivity.MyImageLoader());
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.isAutoPlay(true);
        banner.setDelayTime(3000);
        banner.setBannerTitles(listTitle);
        banner.start();
    }

    private void initKTVBanner(HomeKTVModel obj) {
        //加载头部广告banner
        for (int i = 0; i < obj.getAd().size(); i++) {
            listBanner.add(obj.getAd().get(i).getSHOWIMG());
            listTitle.add(obj.getAd().get(i).getNAME());
        }
        initBanner(listBanner,listTitle);
    }

    private void initBarBanner(HomeBarModel obj) {
        //加载头部广告banner
        for (int i = 0; i < obj.getAd().size(); i++) {
            listBanner.add(obj.getAd().get(i).getSHOWIMG());
            listTitle.add(obj.getAd().get(i).getNAME());
        }
        initBanner(listBanner,listTitle);
    }

    private void initHotelBanner(HomeHotelModel obj) {
        //加载头部广告banner
        for (int i = 0; i < obj.getAd().size(); i++) {
            listBanner.add(obj.getAd().get(i).getSHOWIMG());
            listTitle.add(obj.getAd().get(i).getNAME());
        }
        initBanner(listBanner,listTitle);
    }

    private void initFoodBanner(HomeFoodModel obj) {
        //加载头部广告banner
        for (int i = 0; i < obj.getAd().size(); i++) {
            listBanner.add(obj.getAd().get(i).getSHOWIMG());
            listTitle.add(obj.getAd().get(i).getNAME());
        }
        initBanner(listBanner,listTitle);
    }

    //banner加载图片类
    private class MyImageLoader extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(HomeFoodHotelActivity.this).load(path).into(imageView);
        }
    }

    //加载美食列表
    private void initFoodData() {
        DataManager.getInstance(this).RequestHttp(NetApi.postHomeFoodList(DataManager.getMd5Str("SORTFOOD")), new ResultListener<HomeFoodModel>() {
            @Override
            public void responseSuccess(HomeFoodModel obj) {
                initFoodBanner(obj);
                notifyFoodAdapter(obj);
            }

            @Override
            public void onCompleted() {

            }
        });

    }

    @OnClick({R.id.im_back, R.id.rb_sort, R.id.rb_brand, R.id.rb_filter})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.im_back:
                finish();
                break;
            case R.id.rb_sort:
                filterSort();
                break;
            case R.id.rb_brand:
                filterBrand();
                break;
            case R.id.rb_filter:
                filterFilter();
                break;
        }
    }


    private void filterSort() {
        //推荐。距离由近到远。评分由高到低 。价格由高到低。价格由低到高
        //TODO
        PublicDialog.selectOneDialog(this, "foodSort.json", "推荐",

                new FilterListener() {
                    @Override
                    public void resultListener(String str) {
                        String str1 = "";
                        String str2 = "";
                        switch (str) {
                            case "推荐":

                                break;
                            case "距离由近到远"://BAREVALUATE
                                str1 = "";
                                str2 = "";
                                break;
                            case "评分由高到低":
                                str1 = "SHOPEVALUATE";
                                str2 = "DESC";
                                break;
                            case "价格由高到低":
                                str1 = "SHOPPRICE";
                                str2 = "DESC";
                                break;
                            case "价格由低到高":
                                str1 = "SHOPPRICE";
                                str2 = "ASC";
                                break;

                        }
                        filterData(str1, str2);

                    }
                });
    }

    private void filterData(String str1, String str2) {
        switch (type) {
            case HomeTypeConstant.MORE_TYPE_FOOD:
                filterFoodData(str1, str2, "", "");
                break;
            case HomeTypeConstant.MORE_TYPE_HOTEL:
                filterHotelData(str1, str2, "", "");
                break;
            case HomeTypeConstant.MORE_TYPE_BAR:
                filterBarData(str1, str2, "", "");
                break;
            case HomeTypeConstant.MORE_TYPE_KTV:
                filterKTVData(str1, str2, "", "");
                break;
        }
    }

    private void filterBrand() {

        switch (type) {
            case HomeTypeConstant.MORE_TYPE_FOOD:
                //发起请求
                searchBrandAndScreen("0", "0");
                break;
            case HomeTypeConstant.MORE_TYPE_HOTEL:
                searchBrandAndScreen("0", "1");
                break;
            case HomeTypeConstant.MORE_TYPE_BAR:
                searchBrandAndScreen("0", "3");
                break;
            case HomeTypeConstant.MORE_TYPE_KTV:
                searchBrandAndScreen("0", "2");
                break;
        }

    }

    private void searchBrandAndScreen(final String type, String sortName) {
        DataManager.getInstance(this).RequestHttp(NetApi.postFoodHotelBarKTVDialog(DataManager.getMd5Str("BRANDLIST"), type, sortName), new ResultListener<FoodHotelBarKTVDialogModel>() {
            @Override
            public void responseSuccess(FoodHotelBarKTVDialogModel obj) {
                brandDialog(obj.getPd(), type);
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void brandDialog(final List<FoodHotelBarKTVDialogModel.PdBean> pd, final String type) {
        if (!searchList.isEmpty()) {
            searchList.clear();
        }
        for (int i = 0; i < pd.size(); i++) {
            searchList.add(pd.get(i).getNAME());
        }
        OptionsPickerView pvOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                if (type.equals("1")) {
                    switch (HomeFoodHotelActivity.this.type) {
                        case HomeTypeConstant.MORE_TYPE_FOOD:
                            filterFoodData("", "", "", pd.get(options1).getNAME());
                            break;
                        case HomeTypeConstant.MORE_TYPE_HOTEL:
                            filterHotelData("", "", "", pd.get(options1).getNAME());
                            break;
                        case HomeTypeConstant.MORE_TYPE_BAR:
                            filterBarData("", "", "", pd.get(options1).getNAME());
                            break;
                        case HomeTypeConstant.MORE_TYPE_KTV:
                            filterKTVData("", "", "", pd.get(options1).getNAME());
                            break;
                    }
                } else if (type.equals("0")) {
                    switch (HomeFoodHotelActivity.this.type) {
                        case HomeTypeConstant.MORE_TYPE_FOOD:
                            filterFoodData("", "", pd.get(options1).getNAME(), "");
                            break;
                        case HomeTypeConstant.MORE_TYPE_HOTEL:
                            filterHotelData("", "", pd.get(options1).getNAME(), "");
                            break;
                        case HomeTypeConstant.MORE_TYPE_BAR:
                            filterBarData("", "", pd.get(options1).getNAME(), "");
                            break;
                        case HomeTypeConstant.MORE_TYPE_KTV:
                            filterKTVData("", "", pd.get(options1).getNAME(), "");
                            break;
                    }
                }
            }
        })
                .setSubmitColor(Color.GRAY)
                .setCancelColor(Color.GRAY)
                .setTitleBgColor(Color.WHITE)
                .setDividerColor(Color.WHITE)
                .setContentTextSize(16)
                .setLineSpacingMultiplier(2f)
                .build();
        pvOptions.setNPicker(searchList, null, null);
        pvOptions.show();
    }

    private void filterFilter() {
        switch (type) {
            case HomeTypeConstant.MORE_TYPE_FOOD:
                searchBrandAndScreen("1", "0");
                break;
            case HomeTypeConstant.MORE_TYPE_HOTEL:
                searchBrandAndScreen("1", "1");
                break;
            case HomeTypeConstant.MORE_TYPE_BAR:
                searchBrandAndScreen("1", "3");
                break;
            case HomeTypeConstant.MORE_TYPE_KTV:
                searchBrandAndScreen("1", "2");
                break;
        }
    }
}
