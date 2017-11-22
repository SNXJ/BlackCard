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
import com.zsh.blackcard.adapter.HomeFoodAdapter;
import com.zsh.blackcard.adapter.HomeHotelAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.custom.PublicDialog;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.HomeFoodModel;
import com.zsh.blackcard.model.HomeHotelModel;
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
    private HomeHotelAdapter hotelAdapter;

    private int type;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_home_food_hotel);
        type = getIntent().getIntExtra("data", 0);
        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        if (0 == type) {
            initFoodData();
        } else {
            initHotelData();
        }
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
                        ActivityUtils.startActivityForData(HomeFoodHotelActivity.this, HomeHotelActivityDetail.class, hotelList.get(position).getSORTHOTEL_ID());
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
                        ActivityUtils.startActivityForData(HomeFoodHotelActivity.this, HomeFoodActivityDetail.class, foodList.get(position).getSORTFOOD_ID());
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
                if (0 == type) {
                    PublicDialog.selectOneDialog(this, "foodbrand.json", "海底捞",
                            rbBrand);
                } else {
                    PublicDialog.selectOneDialog(this, "hotelbrand.json", "全部品牌",
                            rbBrand);
                }
                break;
            case R.id.rb_filter:
                if (0 == type) {
                    PublicDialog.selectOneDialog(this, "foodFilter.json", "火锅",
                            rbFilter);
                } else {
                    PublicDialog.selectOneDialog(this, "hotelFilter.json", "高端酒店",
                            rbFilter);
                }
                break;
        }
    }


//    酒店
//    排序：推荐。距离由近到远。评分由高到低 。价格由高到低。价格由低到高
//    品牌：全部品牌。如家。7天。汉庭。锦江之星。
//    筛选：经济型酒店。高端酒店。主题酒店。度假酒店。公寓型酒店。客栈。青年旅社
//
//            美食
//    排序：推荐。距离由近到远。评分由高到低 。价格由高到低。价格由低到高
//    品牌：全聚德。海底捞。眉州小吃。呷浦呷哺。肯德基。必胜客//foodbrand
//    筛选：甜点饮品。火锅。自助餐。小吃快餐。日韩料理。西餐。烧烤烤肉。素食
}
