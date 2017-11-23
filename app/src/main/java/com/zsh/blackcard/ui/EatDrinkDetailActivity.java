package com.zsh.blackcard.ui;

import android.view.View;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.EatDrinkDetailModel;

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

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_eat_drink_detail);
        ButterKnife.bind(this);
        initDate();
    }

    @OnClick({R.id.blackwb_back})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.blackwb_back:
                finish();
                break;
        }
    }


    private void initDate() {
        String data = getIntent().getStringExtra("data");
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postHjRecyclerItemDetail(DataManager.getMd5Str("DETAILID"), data), new ResultListener<EatDrinkDetailModel>() {
            @Override
            public void responseSuccess(EatDrinkDetailModel obj) {
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
                hj_eat_detail_year_tv.setText(obj.getPd().getAGEMIN()+"—"+obj.getPd().getAGEMAX());
                //详情
                hj_eat_detail_detail_tv.setText(obj.getPd().getCONVERGEDET());
            }

            @Override
            public void onCompleted() {

            }
        });
    }
}
