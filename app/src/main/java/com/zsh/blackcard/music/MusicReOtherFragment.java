package com.zsh.blackcard.music;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.MusicReOtherAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.MusicRankingModel;
import com.zsh.blackcard.untils.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Name: TicketSearchFragment
 * Author: SNXJ
 * Date: 2017-11-21
 * Description:描述：
 */
public class MusicReOtherFragment extends BaseFragment {
    public static final String TYPE = "TYPE";
    private int mType = 0;


    @Override
    public void initDate(Bundle savedInstanceState) {
        if (getArguments() != null) {
            mType = getArguments().getInt(TYPE);
        }
    }

    public static MusicReOtherFragment newInstance(int type) {
        MusicReOtherFragment fragment = new MusicReOtherFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(TYPE, type);
        fragment.setArguments(bundle);
        return fragment;
    }

    RecyclerView recyclerView;
    List<MusicRankingModel.PdBean.SongListBean> dataList = new ArrayList<>();
    MusicReOtherAdapter adapter;

    @Override
    public View initView(LayoutInflater inflater) {
        View view = View.inflate(getActivity(), R.layout.music_recommend_fragment, null);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_title);


        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            initData();
        }
    }

    private void initData() {
        DataManager.getInstance(getActivity()).RequestHttp(NetApi.getInstance(getActivity()).getRankingList(DataManager.getMd5Str("BILLLIST"), "1", mType + ""), new ResultListener<MusicRankingModel>() {
            @Override
            public void responseSuccess(MusicRankingModel obj) {
                dataList = obj.getPd().getSong_list();
                setData();
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void setData() {
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        adapter = new MusicReOtherAdapter(dataList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                MusicDetailActivity.setReOtherData(dataList);
                ActivityUtils.startActivity(getActivity(), MusicDetailActivity.class);
            }
        });
    }
}
