package com.zsh.blackcard.fragment.live;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.zsh.blackcard.BaseApplication;
import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.LiveAnchorWBAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.LiveAncherDetailWBModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Name: LiveRankAnchorFragment
 * Author: SNXJ
 * Date: 2017-11-10
 * Description:  主播微博：
 */
public class LiveAnchorWeiboFragment extends BaseFragment {
    @BindView(R.id.id_stickynavlayout_innerscrollview)
    RecyclerView recyclerView;
    private List<LiveAncherDetailWBModel.PdBean> list = new ArrayList<>();

    @Override
    public void initDate(Bundle savedInstanceState) {
        DataManager.getInstance(getActivity()).RequestHttp(NetApi.getLiveAncherWeibo(DataManager.getMd5Str("WEIBOUSER"), BaseApplication.getHonouruserId()), new ResultListener<LiveAncherDetailWBModel>() {
            @Override
            public void responseSuccess(LiveAncherDetailWBModel obj) {
                if ("01".equals(obj.getResult()) || "02".equals(obj.getResult())) {

                    list = obj.getPd();
                    setData();
                }

            }

            @Override
            public void onCompleted() {

            }
        });


    }

    private void setData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        LiveAnchorWBAdapter adapter = new LiveAnchorWBAdapter(R.layout.live_anchor_wb_item, list);

        recyclerView.setAdapter(adapter);
        adapter.setEmptyView(R.layout.home_hotel_empty_layout, recyclerView);


    }

    @Override
    public View initView(LayoutInflater inflater) {
        View view = View.inflate(getActivity(), R.layout.live_anchor_weibo_fragment, null);
        ButterKnife.bind(getActivity());
        return view;
    }


}
