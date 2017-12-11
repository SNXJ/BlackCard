package com.zsh.blackcard.music;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.MusicRankingAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.MusicRankAllModel;
import com.zsh.blackcard.untils.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Name: MusicRankingActivity
 * Author: SNXJ
 * Date: 2017-12-07
 * Description:描述：排行榜
 */
public class MusicRankingActivity extends BaseActivity {
    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private MusicRankingAdapter adapter;
    List<MusicRankAllModel.PdBean> dataList = new ArrayList<>();
    private String[] type = new String[]{"21", "1", "12", "2", "11", "24", "22"};

    @Override
    protected void initUI() {
        setContentView(R.layout.music_ranking_activity);
        ButterKnife.bind(this);
        // setData();
        initDataAll();
    }

    private void initDataAll() {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).getMusicRanking(DataManager.getMd5Str("BILLLIST"), "1", "21,1,12,2,11,24,22"), new ResultListener<MusicRankAllModel>() {
            @Override
            public void responseSuccess(MusicRankAllModel obj) {
                dataList = obj.getPd();
                setData();
            }

            @Override
            public void onCompleted() {

            }
        });
    }
//    private void initData() {
//        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).getRankingList(DataManager.getMd5Str("BILLLIST"), "1", "1"), new ResultListener<MusicRankingModel>() {
//            @Override
//            public void responseSuccess(MusicRankingModel obj) {
////                dataList = obj.getPd().getResult().get(0).getChannellist();
//                setData();
//
//            }
//
//            @Override
//            public void onCompleted() {
//
//            }
//        });
//    }

    private void setData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MusicRankingAdapter(dataList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                MusicDetailActivity.setRankType(type[position]);
                ActivityUtils.startActivity(MusicRankingActivity.this, MusicDetailActivity.class);
            }
        });
        adapter.setEmptyView(R.layout.home_hotel_empty_layout, recyclerView);
    }

    @OnClick(R.id.title_back)
    public void onClick() {
        finish();
    }
}
