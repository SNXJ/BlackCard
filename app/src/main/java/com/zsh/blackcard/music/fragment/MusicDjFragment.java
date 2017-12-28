package com.zsh.blackcard.music.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.MusicDjAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.MusicDjModel;
import com.zsh.blackcard.music.MusicDetailActivity;
import com.zsh.blackcard.utils.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Name: MusicSingerFragment
 * Author: SNXJ
 * Date: 2017-12-13
 * Description:描述：
 */
public class MusicDjFragment extends BaseFragment {

    @BindView(R.id.dj_tablayout)
    TabLayout djTablayout;
    @BindView(R.id.dj_recyclerView)
    RecyclerView djRecyclerView;
    @BindView(R.id.swipeLayout)
    SwipeRefreshLayout swipeLayout;
    private MusicDjAdapter adapter;
    //    private List<MusicDjModel> dataList = new ArrayList<>();
    List<MusicDjModel.PdBean.ResultBean.ChannellistBean> dataList = new ArrayList<>();
    private String[] tabStr = new String[]{"全部", "傍晚", "最近", "情感", "场景", "曲风"};
    private String[] tabType = new String[]{"-1", "语种频道", "风格频道", "时光频道", "推荐频道", "心情频道"};
    private String cate_name = "-1";

    @Override
    public View initView(LayoutInflater inflater) {
        View view = View.inflate(getActivity(), R.layout.music_dj_activity, null);
        ButterKnife.bind(getActivity());
        return view;
    }

    @Override
    public void initDate(Bundle savedInstanceState) {
        for (int i = 0; i < tabStr.length; i++) {
            djTablayout.addTab(djTablayout.newTab().setText(tabStr[i]));
        }
        initData();
        djTablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                cate_name = tabType[tab.getPosition()];
                initData();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void adapterTemp() {
        adapter = new MusicDjAdapter(dataList);
        djRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        djRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                MusicDetailActivity.djData = dataList.get(position);
                ActivityUtils.startActivity(getActivity(), MusicDetailActivity.class);
            }
        });
        //  adapter.setOnLoadMoreListener(loadMoreListener);
        swipeLayout.setOnRefreshListener(refreshListener);
        dialogDismiss();
    }

    SwipeRefreshLayout.OnRefreshListener refreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            swipeLayout.setRefreshing(false);
        }
    };
    BaseQuickAdapter.RequestLoadMoreListener loadMoreListener = new BaseQuickAdapter.RequestLoadMoreListener() {
        @Override
        public void onLoadMoreRequested() {
//            adapter.loadMoreEnd();

        }
    };

    private void initData() {
        showLoading(getActivity());
        DataManager.getInstance(getActivity()).RequestHttp(NetApi.getMusicDjList(DataManager.getMd5Str("CATELIST"), cate_name), new ResultListener<MusicDjModel>() {
            @Override
            public void responseSuccess(MusicDjModel obj) {
                dataList = obj.getPd().getResult().getChannellist();
                adapterTemp();

            }

            @Override
            public void onCompleted() {

            }
        });
    }

}
