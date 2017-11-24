package com.zsh.blackcard.ui.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.HomeHotelAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.HomeHotelModel;
import com.zsh.blackcard.untils.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class HomeHotelActivity extends BaseActivity {


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
    @BindView(R.id.ll_food_item)
    LinearLayout llFoodItem;
    private List<HomeHotelModel.PdBean> hotelList = new ArrayList<>();
    private HomeHotelAdapter hotelAdapter;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_home_food_hotel);
        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        initHotelData();

    }

    private void initHotelData() {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postHomeHotelList(DataManager.getMd5Str("SORTHOTEL")), new ResultListener<HomeHotelModel>() {
            @Override
            public void responseSuccess(HomeHotelModel obj) {
                hotelList = obj.getPd();
                if (null != hotelAdapter) {
                    hotelAdapter.notifyDataSetChanged();
                } else {
                    hotelAdapter = new HomeHotelAdapter(hotelList, HomeHotelActivity.this);
                    recyclerView.setAdapter(hotelAdapter);
                }
                hotelAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        ActivityUtils.startActivityForData(HomeHotelActivity.this, HomeHotelDetailActivity.class, hotelList.get(position).getSORTHOTEL_ID());
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
                break;
            case R.id.rb_sort:
                break;
            case R.id.rb_brand:
                break;
            case R.id.rb_filter:
                break;
        }
    }
}
