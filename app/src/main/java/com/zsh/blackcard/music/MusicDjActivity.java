package com.zsh.blackcard.music;

import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.MusicDjAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.MusicDjModel;
import com.zsh.blackcard.model.ResultModel;
import com.zsh.blackcard.untils.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Name: MusicDjActivity
 * Author: SNXJ
 * Date: 2017-12-08
 * Description:描述：
 */
public class MusicDjActivity extends BaseActivity {
    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.dj_tablayout)
    TabLayout djTablayout;
    @BindView(R.id.dj_recyclerView)
    RecyclerView djRecyclerView;
    private MusicDjAdapter adapter;
    //    private List<MusicDjModel> dataList = new ArrayList<>();
    List<MusicDjModel.PdBean.ResultBean.ChannellistBean> dataList = new ArrayList<>();
    private String[] tab = new String[]{"全部", "傍晚", "最近", "情感", "场景", "曲风", "其他"};

    @Override
    protected void initUI() {
        setContentView(R.layout.music_dj_activity);
        ButterKnife.bind(this);

        for (int i = 0; i < tab.length - 1; i++) {
            djTablayout.addTab(djTablayout.newTab().setText(tab[i]));
        }
        //  adapterTemp();
        initData();
//        getLry();

    }

    private void adapterTemp() {
        adapter = new MusicDjAdapter(dataList);
        djRecyclerView.setLayoutManager(new LinearLayoutManager(MusicDjActivity.this));
        djRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ActivityUtils.startActivityForData(MusicDjActivity.this, MusicDetailActivity.class, dataList.get(position).getCh_name());
            }
        });
    }

    private void initData() {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).getMusicDjList(DataManager.getMd5Str("CATELIST")), new ResultListener<MusicDjModel>() {
            @Override
            public void responseSuccess(MusicDjModel obj) {
                dataList = obj.getPd().getResult().get(0).getChannellist();
                adapterTemp();

            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void getLry() {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).getMusicLry(DataManager.getMd5Str("LRY"), "877578"), new ResultListener<ResultModel>() {
            @Override
            public void responseSuccess(ResultModel obj) {
//                adapter = new MusicDjAdapter(dataList);
//                djRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//                djRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    @OnClick(R.id.title_back)
    public void onClick() {
        finish();
    }
}
