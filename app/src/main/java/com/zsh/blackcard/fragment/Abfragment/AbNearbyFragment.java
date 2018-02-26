package com.zsh.blackcard.fragment.Abfragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.BaseApplication;
import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.AbreComFragmentAdapter;
import com.zsh.blackcard.aliLive.AliLivePlayActivity;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.custom.AbSpacesItemDecoration;
import com.zsh.blackcard.custom.PublicDialog;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.listener.SbNearChangeListener;
import com.zsh.blackcard.model.LivePushListModel;
import com.zsh.blackcard.model.ResultModel;
import com.zsh.blackcard.model.SbNearChangeModel;
import com.zsh.blackcard.utils.ActivityUtils;
import com.zsh.blackcard.utils.LogUtils;
import com.zsh.blackcard.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 尚播的附近
 */

public class AbNearbyFragment extends BaseFragment {

    @BindView(R.id.sb_change_linear)
    RelativeLayout sb_change_linear;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;


    private List<ImageView> listImage = new ArrayList<>();
    private SbNearChangeModel sbNearChangeModel = new SbNearChangeModel();
    List<LivePushListModel.PdBean.PUSHONLINEBean.OnlineInfoBean.LiveStreamOnlineInfoBean> pushList = new ArrayList<>();

    private AbreComFragmentAdapter adapter;

    @Override
    public void initDate(Bundle savedInstanceState) {

    }


    //    sb_nearbyfragment  this is temp
    @Override
    public View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.sb_nearby_fragment, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.sb_change_linear)
    public void onClick() {
        PublicDialog.sbChangeDialog(getActivity(), listImage, sbNearChangeModel, new SbNearChangeListener() {
            @Override
            public void onClick(SbNearChangeModel sbNearChangeModel, Dialog dialog) {
                if (sbNearChangeModel.getType() != null && sbNearChangeModel.getSex() != null && sbNearChangeModel.getTime() != null) {
                    UIUtils.showToast("筛选成功");

                    dialog.dismiss();
                    getNearByFilter(sbNearChangeModel);
                } else {
                    UIUtils.showToast("请选择筛选条件");
                }
            }
        });
    }

    private void getNearByFilter(SbNearChangeModel sbNearChangeModel) {
        showLoading(getActivity());

        DataManager.getInstance(getActivity()).RequestHttp(NetApi.getNearByFilter(DataManager.getMd5Str("SCREENLIST"), sbNearChangeModel.getSex(), sbNearChangeModel.getTime()), new ResultListener<LivePushListModel>() {
            @Override
            public void responseSuccess(LivePushListModel obj) {

                setData(obj);
            }

            @Override
            public void onCompleted() {

            }
        });

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (isVisibleToUser) {
            getNearByData();
            isVisible = true;

        }
    }

    private boolean isVisible = false;

    @Override
    public void onResume() {
        super.onResume();

        if (!isVisible) {
//            getNearByData();
        }

    }

    @Override
    public void onPause() {
        super.onPause();

        isVisible = false;
    }

    private void getNearByData() {
        showLoading(getActivity());
        DataManager.getInstance(getActivity()).RequestHttp(NetApi.getPushNearByList(DataManager.getMd5Str("PUSHNEARLIST"), BaseApplication.getHonouruserId()), new ResultListener<LivePushListModel>() {
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

        dialogDismiss();

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
}
