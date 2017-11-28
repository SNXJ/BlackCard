package com.zsh.blackcard.ui.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.HomeGolfRecyclerAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.HomeGolfRecyclerModel;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kkkkk on 2017/11/28.
 */

public class HomeGolfActivity extends BaseActivity {
    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    private HomeGolfRecyclerAdapter homeGolfRecyclerAdapter;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_golf_recycler);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postHomeGolfRecycler(DataManager.getMd5Str("SORTHIGHGOLF"), "d6a3779de8204dfd9359403f54f7d27c"), new ResultListener<HomeGolfRecyclerModel>() {
            @Override
            public void responseSuccess(HomeGolfRecyclerModel obj) {
                homeGolfRecyclerAdapter = new HomeGolfRecyclerAdapter(R.layout.home_privilege_recycler_item,obj.getPd());
                recyclerView.setLayoutManager(new LinearLayoutManager(HomeGolfActivity.this));
                recyclerView.setAdapter(homeGolfRecyclerAdapter);
            }

            @Override
            public void onCompleted() {

            }
        });
    }
}
