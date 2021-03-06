package com.zsh.blackcard.fragment.Abfragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.BaseApplication;
import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.AbreComFragmentAdapter;
import com.zsh.blackcard.aliLive.AliLivePlayActivity;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.custom.AbSpacesItemDecoration;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.LivePushListModel;
import com.zsh.blackcard.model.ResultModel;
import com.zsh.blackcard.utils.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Name: AbReComFragmemt
 * Author: SNXJ
 * Date: 2017-12-19
 * Description:描述：
 */
public class AbReComFragmemt extends BaseFragment {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    List<LivePushListModel.PdBean.PUSHONLINEBean.OnlineInfoBean.LiveStreamOnlineInfoBean> pushList = new ArrayList<>();
    private boolean isVisible = false;//再次可见

    private AbreComFragmentAdapter adapter;

    @Override
    public void initDate(Bundle savedInstanceState) {

//        getPusherList();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (isVisibleToUser) {
            getPusherList();
            isVisible = true;

        }
    }


    @Override
    public void onResume() {
        super.onResume();

        if (!isVisible) {
            getPusherList();
        }

    }

    @Override
    public void onPause() {
        super.onPause();

        isVisible = false;
    }

    private void getPusherList() {
//        showLoading(getActivity());
        DataManager.getInstance(getActivity()).RequestHttp(NetApi.getPushList(DataManager.getMd5Str("PUSHLIST")), new ResultListener<LivePushListModel>() {
            @Override
            public void responseSuccess(LivePushListModel obj) {

                setData(obj);
            }


            @Override
            public void onCompleted() {

            }
        });
    }

    private void setData(LivePushListModel obj) {
//        dialogDismiss();

        if (null != obj && "01".equals(obj.getResult())) {


            pushList = obj.getPd().getPUSHONLINE().getOnlineInfo().getLiveStreamOnlineInfo();
            adapter = new AbreComFragmentAdapter(pushList);
            recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
            recyclerView.setAdapter(adapter);
            adapter.setEmptyView(R.layout.live_empty_layout, recyclerView);
            AbSpacesItemDecoration decoration = new AbSpacesItemDecoration(4);
            recyclerView.addItemDecoration(decoration);
            adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    if (null != pushList && pushList.size() > 0) {
                        postliveNum();
                        ActivityUtils.startActivityForData(getActivity(), AliLivePlayActivity.class, pushList.get(position).getPublishUrl());
                    }
                }
            });
        }

    }

    private void postliveNum() {
        DataManager.getInstance(getActivity()).RequestHttp(NetApi.postLiveMum(DataManager.getMd5Str("NUMBER"), BaseApplication.getHonouruserId()), null);
    }

    @Override
    public View initView(LayoutInflater inflater) {
        view = View.inflate(getActivity(), R.layout.ab_recom_fragment, null);
        ButterKnife.bind(getActivity());
        return view;
    }


}
