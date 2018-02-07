package com.zsh.blackcard.live;

import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.BaseApplication;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.AbMyContrAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.AbContriModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Name: AbMyContributionActivity
 * Author: SNXJ
 * Date: 2017-11-13
 * Description: 尚播 我的  贡献榜
 */
public class AbMyContributionActivity extends BaseActivity {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.top_tab)
    TabLayout topTab;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private String[] title = {"日榜", "周榜", "月榜", "总榜"};
    private String[] type = {"DATE", "WEEK", "MONTH", "ALL"};

    @Override
    protected void initUI() {
        setContentView(R.layout.sb_my_contribution_activity);
        ButterKnife.bind(this);
        for (int i = 0; i < title.length; i++) {
            topTab.addTab(topTab.newTab().setText(title[i]));

        }
        topTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                getData(type[tab.getPosition()]);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        initRecycle();

        getData(type[0]);

    }

    private void getData(String type) {
        showLoading(this);
        DataManager.getInstance(this).RequestHttp(NetApi.getAbRankingList(DataManager.getMd5Str("RANKING"), BaseApplication.getHonouruserId(), type), new ResultListener<AbContriModel>() {
            @Override
            public void responseSuccess(AbContriModel obj) {
                if ("01".equals(obj.getResult())) {
                    list = null;
                    list = obj.getPd();
                    initRecycle();
                }

            }

            @Override
            public void onCompleted() {

            }
        });

    }

    List<AbContriModel.PdBean> list = new ArrayList<>();
    AbMyContrAdapter adapter;

    private void initRecycle() {
        dialogDismiss();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AbMyContrAdapter adapter = new AbMyContrAdapter(R.layout.ab_my_contri_item, list);
        adapter.setEmptyView(R.layout.zg_search_empty, recyclerView);
        recyclerView.setAdapter(adapter);
    }


    @OnClick(R.id.title_back)
    public void onViewClicked() {
        finish();
    }
}
