package com.zsh.blackcard.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.EatDrinkRecyclerAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.EatDrinkRecyclerModel;
import com.zsh.blackcard.view.SpacesItemDecoration;
import com.zsh.blackcard.view.SpacesItemLastDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

/**
 * Created by kkkkk on 2017/11/11.
 */

public class HuoDongActivity extends BaseActivity {

    @BindView(R.id.my_huodong_recyclerView)
    RecyclerView my_huodong_recyclerView;

    @BindView(R.id.my_huodong_left_rb)
    RadioButton my_huodong_left_rb;
    @BindView(R.id.my_huodong_right_rb)
    RadioButton my_huodong_right_rb;

    private EatDrinkRecyclerAdapter eatDrinkRecyclerAdapter;
    private List<EatDrinkRecyclerModel.PdBean> pdBeans = new ArrayList<>();

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_huodong);
        ButterKnife.bind(this);
        initDate();
    }

    private void initDate() {
        my_huodong_left_rb.setChecked(true);
    }

    @OnCheckedChanged({R.id.my_huodong_left_rb, R.id.my_huodong_right_rb})
    public void onChecked(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.my_huodong_left_rb:
                if (isChecked) {
                    initHttp("0");
                }
                break;
            case R.id.my_huodong_right_rb:
                if (isChecked) {
                    initHttp("1");
                }
                break;
        }
    }

    //加载列表
    private void initHttp(String state) {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postEatDrinkRecycler(DataManager.getMd5Str("PARTYLIST"), "d6a3779de8204dfd9359403f54f7d27c", "", state), new ResultListener<EatDrinkRecyclerModel>() {
            @Override
            public void responseSuccess(EatDrinkRecyclerModel obj) {
                if (obj.getResult().equals("01")) {
                    pdBeans.clear();
                    pdBeans.addAll(obj.getPd());
                } else {
                    pdBeans.clear();
                }


                if (eatDrinkRecyclerAdapter == null) {
                    eatDrinkRecyclerAdapter = new EatDrinkRecyclerAdapter(R.layout.hj_child_recycler_item, pdBeans);
                    my_huodong_recyclerView.setLayoutManager(new LinearLayoutManager(HuoDongActivity.this));
                    my_huodong_recyclerView.addItemDecoration(new SpacesItemDecoration(HuoDongActivity.this, SpacesItemDecoration.VERTICAL_LIST));
                    my_huodong_recyclerView.setAdapter(eatDrinkRecyclerAdapter);
                } else {
                    eatDrinkRecyclerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    @OnClick(R.id.blackwb_back)
    public void onClick() {
        finish();
    }
}
