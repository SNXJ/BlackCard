package com.zsh.blackcard.ui;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.EatDrinkRecyclerAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.EatDrinkRecyclerModel;
import com.zsh.blackcard.untils.ActivityUtils;
import com.zsh.blackcard.view.SpacesItemDecoration;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 吃喝玩乐列表页面
 */
public class EatDrinkActivity extends BaseActivity {

    @BindView(R.id.hj_recycler_detail_title)
    TextView hj_recycler_detail_title;

    //汇聚指定聚会列表
    @BindView(R.id.eat_drink_recycler)
    RecyclerView eat_drink_recycler;

    private EatDrinkRecyclerAdapter eatDrinkRecyclerAdapter;

    private String data;


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
                case R.id.hj_child_recycler_linear:
                    ActivityUtils.startActivityForData(EatDrinkActivity.this, EatDrinkDetailActivity.class,((EatDrinkRecyclerModel.PdBean) adapter.getData().get(position)).getCONVERGEDETAIL_ID());
                    break;
                case R.id.hj_child_recycler_head_img:

                    break;
            }
        }
    }

    @OnClick({R.id.blackwb_back, R.id.hj_eat_set})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.blackwb_back:
                finish();
                break;
            case R.id.hj_eat_set:
                //跳转至去发布
                ActivityUtils.startActivityForData(this, EatDrinkSetActivity.class, data);
                break;
        }
    }

    private void initData() {
        Intent intent = getIntent();
        data = intent.getStringExtra("data");
        String title = intent.getStringExtra("title");
        hj_recycler_detail_title.setText(title);

        //初始化指定汇聚下所有聚会列表
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postEatDrinkRecycler(DataManager.getMd5Str("PARTYLIST"), "", data, ""), new ResultListener<EatDrinkRecyclerModel>() {
            @Override
            public void responseSuccess(EatDrinkRecyclerModel obj) {
                if (eatDrinkRecyclerAdapter == null) {
                    eatDrinkRecyclerAdapter = new EatDrinkRecyclerAdapter(R.layout.hj_child_recycler_item, obj.getPd());
                    eat_drink_recycler.setLayoutManager(new LinearLayoutManager(EatDrinkActivity.this));
                    eat_drink_recycler.setAdapter(eatDrinkRecyclerAdapter);
                    eatDrinkRecyclerAdapter.setOnItemChildClickListener(new HjChildRecyclerOnItemClick());
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }
}