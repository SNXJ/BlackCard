package com.zsh.blackcard.music.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.MusicRankingAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.MusicRankAllModel;
import com.zsh.blackcard.music.MusicDetailActivity;
import com.zsh.blackcard.untils.ActivityUtils;

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
public class MusicRankingFragment extends BaseFragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private MusicRankingAdapter adapter;
    List<MusicRankAllModel.PdBean> dataList = new ArrayList<>();
    private String[] type = new String[]{"21", "1", "12", "2", "11", "24", "22"};
    private String[] typeStr = new String[]{"飙升榜", "新歌榜", "歌手榜", "热歌榜", "原创榜", "赞赏榜", "老歌榜"};


    @Override
    public View initView(LayoutInflater inflater) {
        View view = View.inflate(getActivity(), R.layout.music_ranking_activity, null);
        ButterKnife.bind(getActivity());
        return view;
    }

    @Override
    public void initDate(Bundle savedInstanceState) {

        showLoading(getActivity());
        DataManager.getInstance(getActivity()).RequestHttp(NetApi.getInstance(getActivity()).getMusicRanking(DataManager.getMd5Str("BILLLIST"), "1", "21,1,12,2,11,24,22"), new ResultListener<MusicRankAllModel>() {
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


    private void setData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new MusicRankingAdapter(dataList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                MusicDetailActivity.rankType = (type[position]);
                MusicDetailActivity.rankStr = (typeStr[position]);
                MusicDetailActivity.rankImgUrl = dataList.get(position).getBillboard().getPic_s640();
                ActivityUtils.startActivity(getActivity(), MusicDetailActivity.class);
            }
        });
        adapter.setEmptyView(R.layout.home_hotel_empty_layout, recyclerView);
        dialogDismiss();
    }
}
