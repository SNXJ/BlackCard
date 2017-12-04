package com.zsh.blackcard.ui.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
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
import com.zsh.blackcard.model.HomeBarModel;
import com.zsh.blackcard.model.HomeFoodModel;
import com.zsh.blackcard.model.HomeHotelModel;
import com.zsh.blackcard.model.HomeKTVModel;
import com.zsh.blackcard.untils.ActivityUtils;

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


    private List<HomeFoodModel.PdBean> foodList = new ArrayList<>();
    private HomeFoodAdapter foodAdapter;
    private List<HomeHotelModel.PdBean> hotelList = new ArrayList<>();
    private List<HomeBarModel.PdBean> barList = new ArrayList<>();
    private HomeHotelAdapter hotelAdapter;
    private HomeBarAdapter barAdapter;
    private List<HomeKTVModel.PdBean> ktvList = new ArrayList<>();
    private HomeKTVAdapter ktvAdapter;
    private String type;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_home_food_hotel);
        type = getIntent().getStringExtra("data");
        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

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
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postHomeKTVRecycler(DataManager.getMd5Str("SORTKTV"), "d6a3779de8204dfd9359403f54f7d27c"), new ResultListener<HomeKTVModel>() {
            @Override
            public void responseSuccess(HomeKTVModel obj) {
                notifyKTVAdapter(obj);

            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void initBarData() {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postHomeBarList(DataManager.getMd5Str("SORTBAR")), new ResultListener<HomeBarModel>() {
            @Override
            public void responseSuccess(HomeBarModel obj) {
                notifyBarAdapter(obj);

            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void initHotelData() {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postHomeHotelList(DataManager.getMd5Str("SORTHOTEL")), new ResultListener<HomeHotelModel>() {
            @Override
            public void responseSuccess(HomeHotelModel obj) {
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
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).filterFoodList(map), new ResultListener<HomeFoodModel>() {
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
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).filterHotelList(map), new ResultListener<HomeHotelModel>() {
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
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).filterKTVList(map), new ResultListener<HomeKTVModel>() {
            @Override
            public void responseSuccess(HomeKTVModel obj) {
                notifyKTVAdapter(obj);
            }

            @Override
            public void onCompleted() {

            }
        });

    }

    private void notifyKTVAdapter(HomeKTVModel obj) {
        ktvList.clear();
        ktvList.addAll(obj.getPd());
        if (null != ktvAdapter) {
            ktvAdapter.notifyDataSetChanged();
        } else {
            ktvAdapter = new HomeKTVAdapter(ktvList, HomeFoodHotelActivity.this);
            recyclerView.setAdapter(ktvAdapter);
        }

        ktvAdapter.setEmptyView(R.layout.home_hotel_empty_layout, recyclerView);

        ktvAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ActivityUtils.startActivityForData(HomeFoodHotelActivity.this, HomeKTVDetailActivity.class, ktvList.get(position).getSORTKTV_ID());
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
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).filterBarList(map), new ResultListener<HomeBarModel>() {
            @Override
            public void responseSuccess(HomeBarModel obj) {
                notifyBarAdapter(obj);
            }

            @Override
            public void onCompleted() {

            }
        });

    }

    private void notifyBarAdapter(HomeBarModel obj) {
        barList.clear();
        barList.addAll(obj.getPd());
        if (null != barAdapter) {
            barAdapter.notifyDataSetChanged();
        } else {
            barAdapter = new HomeBarAdapter(barList, HomeFoodHotelActivity.this);
            recyclerView.setAdapter(barAdapter);
        }
        barAdapter.setEmptyView(R.layout.home_hotel_empty_layout, recyclerView);
        barAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ActivityUtils.startActivityForData(HomeFoodHotelActivity.this, HomeBarDetailActivity.class, barList.get(position).getSORTBAR_ID());
            }
        });
    }

    private void notifyHotelAdapter(HomeHotelModel obj) {
        hotelList.clear();
        hotelList.addAll(obj.getPd());
        if (null != hotelAdapter) {
            hotelAdapter.notifyDataSetChanged();
        } else {
            hotelAdapter = new HomeHotelAdapter(hotelList, HomeFoodHotelActivity.this);
            recyclerView.setAdapter(hotelAdapter);
        }
        hotelAdapter.setEmptyView(R.layout.home_hotel_empty_layout, recyclerView);
        hotelAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ActivityUtils.startActivityForData(HomeFoodHotelActivity.this, HomeHotelDetailActivity.class, hotelList.get(position).getSORTHOTEL_ID());
            }
        });
    }

    private void notifyFoodAdapter(HomeFoodModel obj) {
        foodList.clear();
        foodList.addAll(obj.getPd());
        if (null != foodAdapter) {
            foodAdapter.notifyDataSetChanged();

        } else {
            foodAdapter = new HomeFoodAdapter(foodList, HomeFoodHotelActivity.this);
            recyclerView.setAdapter(foodAdapter);
        }
        foodAdapter.setEmptyView(R.layout.home_hotel_empty_layout, recyclerView);
        foodAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ActivityUtils.startActivityForData(HomeFoodHotelActivity.this, HomeFoodDetailActivity.class, foodList.get(position).getSORTFOOD_ID());
            }
        });

    }


    private void initFoodData() {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postHomeFoodList(DataManager.getMd5Str("SORTFOOD")), new ResultListener<HomeFoodModel>() {
            @Override
            public void responseSuccess(HomeFoodModel obj) {
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
                PublicDialog.selectOneDialog(this, "foodbrand.json", "海底捞",
                        new FilterListener() {
                            @Override
                            public void resultListener(String str) {
                                filterFoodData("", "", str, "");
                            }
                        });
                break;
            case HomeTypeConstant.MORE_TYPE_HOTEL:
                PublicDialog.selectOneDialog(this, "hotelbrand.json", "全部品牌",
                        new FilterListener() {
                            @Override
                            public void resultListener(String str) {
                                filterHotelData("", "", str, "");
                            }
                        });
                break;
            case HomeTypeConstant.MORE_TYPE_BAR:
                PublicDialog.selectOneDialog(this, "foodbrand.json", "海底捞",
                        new FilterListener() {
                            @Override
                            public void resultListener(String str) {
                                filterBarData("", "", str, "");
                            }
                        });

                break;
            case HomeTypeConstant.MORE_TYPE_KTV:
                PublicDialog.selectOneDialog(this, "foodbrand.json", "海底捞",
                        new FilterListener() {
                            @Override
                            public void resultListener(String str) {
                                filterKTVData("", "", str, "");
                            }
                        });
                break;
        }

    }

    private void filterFilter() {
        switch (type) {
            case HomeTypeConstant.MORE_TYPE_FOOD:
                PublicDialog.selectOneDialog(this, "foodFilter.json", "火锅",
                        new FilterListener() {
                            @Override
                            public void resultListener(String str) {
                                filterFoodData("", "", "", str);
                            }
                        });
                break;
            case HomeTypeConstant.MORE_TYPE_HOTEL:
                PublicDialog.selectOneDialog(this, "hotelFilter.json", "高端酒店",
                        new FilterListener() {
                            @Override
                            public void resultListener(String str) {
                                filterHotelData("", "", "", str);
                            }
                        });
                break;
            case HomeTypeConstant.MORE_TYPE_BAR:
                PublicDialog.selectOneDialog(this, "foodFilter.json", "火锅",
                        new FilterListener() {
                            @Override
                            public void resultListener(String str) {
                                filterBarData("", "", "", str);
                            }
                        });

                break;
            case HomeTypeConstant.MORE_TYPE_KTV:
                PublicDialog.selectOneDialog(this, "foodFilter.json", "火锅",
                        new FilterListener() {
                            @Override
                            public void resultListener(String str) {
                                filterKTVData("", "", "", str);
                            }
                        });

                break;
        }
    }


}
