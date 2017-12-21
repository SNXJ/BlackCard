package com.zsh.blackcard.music.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.MusicRecommendAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.MusicRecommendModel;
import com.zsh.blackcard.music.MusicDetailActivity;
import com.zsh.blackcard.untils.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Name: TicketSearchFragment
 * Author: SNXJ
 * Date: 2017-11-21
 * Description:描述：
 */
public class MusicRecommendFragment extends BaseFragment {
    public static final String TYPE = "TYPE";
    private int mType = 0;


    @Override
    public void initDate(Bundle savedInstanceState) {
        if (getArguments() != null) {
            mType = getArguments().getInt(TYPE);
        }
    }

    public static MusicRecommendFragment newInstance(int type) {
        MusicRecommendFragment fragment = new MusicRecommendFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(TYPE, type);
        fragment.setArguments(bundle);
        return fragment;
    }

    RecyclerView recyclerView;
    static List<MusicRecommendModel.PdBean.ResultBean.ListBean> dataList = new ArrayList<>();
    MusicRecommendAdapter adapter;

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
        DataManager.getInstance(getActivity()).RequestHttp(NetApi.getMusicRecommendList(DataManager.getMd5Str("SONGLIST")), new ResultListener<MusicRecommendModel>() {
            @Override
            public void responseSuccess(MusicRecommendModel obj) {
                dataList.addAll(obj.getPd().getResult().getList());
                setData();
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void setData() {
        adapter = new MusicRecommendAdapter(dataList, mType);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(onItemClickListener);
    }

    BaseQuickAdapter.OnItemClickListener onItemClickListener = new BaseQuickAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            MusicDetailActivity.setData((List<MusicRecommendModel.PdBean.ResultBean.ListBean>) adapter.getData(), position);
            ActivityUtils.startActivity(getActivity(), MusicDetailActivity.class);
        }
    };
}
