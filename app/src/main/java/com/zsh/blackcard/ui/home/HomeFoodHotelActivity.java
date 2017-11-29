package com.zsh.blackcard.ui.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.HomeBarAdapter;
import com.zsh.blackcard.adapter.HomeFoodAdapter;
import com.zsh.blackcard.adapter.HomeHotelAdapter;
import com.zsh.blackcard.adapter.HomeKTVAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.custom.HomeTypeConstant;
import com.zsh.blackcard.custom.PublicDialog;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.HomeBarModel;
import com.zsh.blackcard.model.HomeFoodModel;
import com.zsh.blackcard.model.HomeHotelModel;
import com.zsh.blackcard.model.HomeKTVRecyclerModel;
import com.zsh.blackcard.untils.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

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
    private List<HomeFoodModel.PdBean> foodList = new ArrayList<>();
    private HomeFoodAdapter foodAdapter;
    private List<HomeHotelModel.PdBean> hotelList = new ArrayList<>();
    private List<HomeBarModel.PdBean> barList = new ArrayList<>();
    private HomeHotelAdapter hotelAdapter;
    private HomeBarAdapter barAdapter;
    private List<HomeKTVRecyclerModel.PdBean> ktvList = new ArrayList<>();
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
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postHomeKTVRecycler(DataManager.getMd5Str("SORTKTV"), "d6a3779de8204dfd9359403f54f7d27c"), new ResultListener<HomeKTVRecyclerModel>() {
            @Override
            public void responseSuccess(HomeKTVRecyclerModel obj) {
                ktvList = obj.getPd();
                if (null != ktvAdapter) {
                    ktvAdapter.notifyDataSetChanged();
                } else {
                    ktvAdapter = new HomeKTVAdapter(ktvList, HomeFoodHotelActivity.this);
                    recyclerView.setAdapter(ktvAdapter);
                }
                ktvAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        ActivityUtils.startActivityForData(HomeFoodHotelActivity.this, HomeKTVDetailActivity.class, ktvList.get(position).getSORTKTV_ID());
                    }
                });
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
                barList = obj.getPd();
                if (null != barAdapter) {
                    barAdapter.notifyDataSetChanged();
                } else {
                    barAdapter = new HomeBarAdapter(barList, HomeFoodHotelActivity.this);
                    recyclerView.setAdapter(barAdapter);
                }
                barAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        ActivityUtils.startActivityForData(HomeFoodHotelActivity.this, HomeBarDetailActivity.class, barList.get(position).getSORTBAR_ID());
                    }
                });
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
                hotelList = obj.getPd();
                if (null != hotelAdapter) {
                    hotelAdapter.notifyDataSetChanged();
                } else {
                    hotelAdapter = new HomeHotelAdapter(hotelList, HomeFoodHotelActivity.this);
                    recyclerView.setAdapter(hotelAdapter);
                }
                hotelAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        ActivityUtils.startActivityForData(HomeFoodHotelActivity.this, HomeHotelDetailActivity.class, hotelList.get(position).getSORTHOTEL_ID());
                    }
                });
            }

            @Override
            public void onCompleted() {

            }
        });

    }

    private void initFoodData() {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postHomeFoodList(DataManager.getMd5Str("SORTFOOD")), new ResultListener<HomeFoodModel>() {
            @Override
            public void responseSuccess(HomeFoodModel obj) {
                foodList = obj.getPd();
                if (null != foodAdapter) {
                    foodAdapter.notifyDataSetChanged();
                } else {
                    foodAdapter = new HomeFoodAdapter(foodList, HomeFoodHotelActivity.this);
                    recyclerView.setAdapter(foodAdapter);
                }
                foodAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        ActivityUtils.startActivityForData(HomeFoodHotelActivity.this, HomeFoodDetailActivity.class, foodList.get(position).getSORTFOOD_ID());
                    }
                });
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
                PublicDialog.selectOneDialog(this, "foodSort.json", "推荐",
                        rbSort);
                break;
            case R.id.rb_brand:
                if (HomeTypeConstant.MORE_TYPE_FOOD.equals(type)) {
                    PublicDialog.selectOneDialog(this, "foodbrand.json", "海底捞",
                            rbBrand);
                } else {
                    PublicDialog.selectOneDialog(this, "hotelbrand.json", "全部品牌",
                            rbBrand);
                }
                break;
            case R.id.rb_filter:
                if (HomeTypeConstant.MORE_TYPE_FOOD.equals(type)) {
                    PublicDialog.selectOneDialog(this, "foodFilter.json", "火锅",
                            rbFilter);
                } else {
                    PublicDialog.selectOneDialog(this, "hotelFilter.json", "高端酒店",
                            rbFilter);
                }
                break;
        }
    }

}
