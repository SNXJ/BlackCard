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
import com.zsh.blackcard.adapter.MusicSingerAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.MusicSingerModel;
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
public class MusicSingerFragment extends BaseFragment {

    @Override
    public View initView(LayoutInflater inflater) {
        View view = View.inflate(getActivity(), R.layout.music_singer_activity, null);
        ButterKnife.bind(getActivity());
        return view;
    }


    @BindView(R.id.tablayout_area)
    TabLayout tablayoutArea;
    @BindView(R.id.tablayout_sex)
    TabLayout tablayoutSex;
    @BindView(R.id.singer_recyclerView)
    RecyclerView singerRecyclerView;
    @BindView(R.id.swipeLayout)
    SwipeRefreshLayout swipeLayout;

    private MusicSingerAdapter adapter;
    private List<MusicSingerModel.PdBean.ArtistBean> dataList = new ArrayList<>();
    private String[] areTab = new String[]{"全部", "内地", "港台", "欧美", "日本", "韩国"};
    private String[] areaType = new String[]{null, "0", "1", "2", "5", "6"};
    private String[] sexTab = new String[]{"全部", "男", "女", "组合"};
    private String[] sexType = new String[]{null, "0", "1", "2"};
    private String sexPoint = null;
    private String areaPoint = null;


    @Override
    public void initDate(Bundle savedInstanceState) {
        for (int i = 0; i < areTab.length; i++) {
            tablayoutArea.addTab(tablayoutArea.newTab().setText(areTab[i]));
        }
        for (int i = 0; i < sexTab.length; i++) {
            tablayoutSex.addTab(tablayoutSex.newTab().setText(sexTab[i]));
        }

        tablayoutArea.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                areaPoint = areaType[tab.getPosition()];
                getSingerList(sexPoint, areaPoint);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        tablayoutSex.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                sexPoint = sexType[tab.getPosition()];
                getSingerList(sexPoint, areaPoint);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        getSingerList(sexPoint, areaPoint);
    }


    private void getSingerList(String sexType, String areaType) {
        showLoading(getActivity());
        DataManager.getInstance(getActivity()).RequestHttp(NetApi.getMusicSingerList(DataManager.getMd5Str("HOTARTIST"), "1", sexType, areaType), new ResultListener<MusicSingerModel>() {
            @Override
            public void responseSuccess(MusicSingerModel obj) {
                if (null != obj && "01".equals(obj.getResult())) {
                    dataList = obj.getPd().getArtist();
                    setData();
                }

            }

            @Override
            public void onCompleted() {

            }
        });

    }

    private void setData() {
        singerRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new MusicSingerAdapter(dataList);
        singerRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                MusicDetailActivity.SingerData = (dataList.get(position));
                ActivityUtils.startActivity(getActivity(), MusicDetailActivity.class);
            }
        });
        swipeLayout.setOnRefreshListener(refreshListener);
        dialogDismiss();
    }

    SwipeRefreshLayout.OnRefreshListener refreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            swipeLayout.setRefreshing(false);
        }
    };

}
