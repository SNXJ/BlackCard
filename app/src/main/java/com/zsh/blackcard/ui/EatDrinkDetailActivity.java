package com.zsh.blackcard.ui;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.BaseApplication;
import com.zsh.blackcard.R;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.EatDrinkDetailModel;
import com.zsh.blackcard.model.ResultModel;
import com.zsh.blackcard.utils.UIUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kkkkk on 2017/11/13.
 */

public class EatDrinkDetailActivity extends BaseActivity {

    //开始时间
    @BindView(R.id.hj_eat_detail_startTime_tv)
    TextView hj_eat_detail_startTime_tv;
    //结束时间
    @BindView(R.id.hj_eat_detail_endTime_tv)
    TextView hj_eat_detail_endTime_tv;
    //期望价格
    @BindView(R.id.hj_eat_detail_price_tv)
    TextView hj_eat_detail_price_tv;
    //方式
    @BindView(R.id.hj_eat_detail_type_tv)
    TextView hj_eat_detail_type_tv;
    //人数
    @BindView(R.id.hj_eat_detail_people_tv)
    TextView hj_eat_detail_people_tv;
    //性别
    @BindView(R.id.hj_eat_detail_sex_tv)
    TextView hj_eat_detail_sex_tv;
    //年龄
    @BindView(R.id.hj_eat_detail_year_tv)
    TextView hj_eat_detail_year_tv;
    //详情
    @BindView(R.id.hj_eat_detail_detail_tv)
    TextView hj_eat_detail_detail_tv;
    @BindView(R.id.blackwb_back)
    ImageView blackwbBack;
    @BindView(R.id.hj_child_recycler_head_img)
    ImageView hjChildRecyclerHeadImg;
    @BindView(R.id.tv_add_friend)
    TextView tvAddFriend;

    @BindView(R.id.hj_eat_set_startTime_relative)
    RelativeLayout hjEatSetStartTimeRelative;

    @BindView(R.id.hj_eat_set_endTime_relative)
    RelativeLayout hjEatSetEndTimeRelative;

    @BindView(R.id.hj_eat_set_price_relative)
    RelativeLayout hjEatSetPriceRelative;

    @BindView(R.id.hj_eat_set_type_relative)
    RelativeLayout hjEatSetTypeRelative;

    @BindView(R.id.hj_eat_set_people_relative)
    RelativeLayout hjEatSetPeopleRelative;

    @BindView(R.id.hj_eat_set_sex_relative)
    RelativeLayout hjEatSetSexRelative;

    @BindView(R.id.hj_eat_set_year_relative)
    RelativeLayout hjEatSetYearRelative;
    @BindView(R.id.hj_eat_detail_details_tv)
    TextView hjEatDetailDetailsTv;

    @BindView(R.id.hj_eat_set_detail_relative)
    RelativeLayout hjEatSetDetailRelative;
    @BindView(R.id.hj_eat_detail_release_btn)
    Button hjEatDetailReleaseBtn;
    @BindView(R.id.eat_drink_detail_title_tv)
    TextView eat_drink_detail_title_tv;

    private EatDrinkDetailModel eatDrinkDetaildata;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_eat_drink_detail);
        ButterKnife.bind(this);
        initDate();
    }

    @OnClick({R.id.blackwb_back, R.id.tv_add_friend})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.blackwb_back:
                finish();
                break;
            case R.id.tv_add_friend:
                addFriend(eatDrinkDetaildata.getPd().getHONOURUSER_ID());
                break;
        }
    }

    private void initDate() {
        String data = getIntent().getStringExtra("data");
        String title = getIntent().getStringExtra("title");
        eat_drink_detail_title_tv.setText(title);
        DataManager.getInstance(this).RequestHttp(NetApi.postHjRecyclerItemDetail(DataManager.getMd5Str("DETAILID"), data), new ResultListener<EatDrinkDetailModel>() {
            @Override
            public void responseSuccess(EatDrinkDetailModel obj) {
                eatDrinkDetaildata = obj;
                //开始时间
                hj_eat_detail_startTime_tv.setText(obj.getPd().getSTARTTIME());
                //结束时间
                hj_eat_detail_endTime_tv.setText(obj.getPd().getENDTIME());
                //期望价格
                hj_eat_detail_price_tv.setText(obj.getPd().getPRICEMIN() + "—" + obj.getPd().getPRICEMAX());
                //方式
                hj_eat_detail_type_tv.setText(obj.getPd().getCONVERGETYPE());
                //人数
                hj_eat_detail_people_tv.setText(obj.getPd().getCONVERGEPER());
                //性别
                if (obj.getPd().getCONVERGESEX() == 0) {
                    hj_eat_detail_sex_tv.setText("女");
                } else if (obj.getPd().getCONVERGESEX() == 1) {
                    hj_eat_detail_sex_tv.setText("男");
                } else {
                    hj_eat_detail_sex_tv.setText("不限");
                }
                //年龄
                hj_eat_detail_year_tv.setText(obj.getPd().getAGEMIN() + "—" + obj.getPd().getAGEMAX());
                //详情
                hj_eat_detail_detail_tv.setText(obj.getPd().getCONVERGEDET());
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void addFriend(String addId) {
        DataManager.getInstance(this).RequestHttp(NetApi.addFriend(DataManager.getMd5Str("FRIENDADD"), BaseApplication.getHonouruserId(), addId), new ResultListener<ResultModel>() {
            @Override
            public void responseSuccess(ResultModel obj) {
                UIUtils.showToast("添加成功");
            }

            @Override
            public void onCompleted() {

            }
        });
    }


}
