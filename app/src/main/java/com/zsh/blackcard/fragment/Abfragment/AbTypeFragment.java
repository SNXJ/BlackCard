package com.zsh.blackcard.fragment.Abfragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.AbreComFragmentAdapter;
import com.zsh.blackcard.adapter.LiveTypeAdapter;
import com.zsh.blackcard.aliLive.AliLivePlayActivity;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.LivePushListModel;
import com.zsh.blackcard.model.LiveTypeModel;
import com.zsh.blackcard.utils.ActivityUtils;
import com.zsh.blackcard.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Name: AbTypeFragment
 * Author: SNXJ
 * Date: 2017-12-19
 * Description:描述：
 */
public class AbTypeFragment extends BaseFragment {
    @BindView(R.id.recyclerView_first)
    RecyclerView recyclerViewFirst;
    @BindView(R.id.recyclerView_second)
    RecyclerView recyclerViewSecond;
    @BindView(R.id.recyclerView_content)
    RecyclerView recyclerViewContent;
    List<LivePushListModel.PdBean.PUSHONLINEBean.OnlineInfoBean.LiveStreamOnlineInfoBean> pushList = new ArrayList<>();

    private AbreComFragmentAdapter contentAdapter;

    @Override
    public void initDate(Bundle savedInstanceState) {

//        getFirstData();

    }


    private void getFirstData() {
        showLoading(getActivity());

        DataManager.getInstance(getActivity()).RequestHttp(NetApi.getLiveTypeFirst(DataManager.getMd5Str("LIVETYPE")), new ResultListener<LiveTypeModel>() {
            @Override
            public void responseSuccess(LiveTypeModel obj) {
                dialogDismiss();
                if ("01".equals(obj.getResult())) {
                    final List<LiveTypeModel.PdBean> fistTypeList = obj.getPd();
                    fistTypeList.get(0).setSelect(true);
                    getSecondData(fistTypeList.get(0).getLIVETYPE_ID());

                    LiveTypeAdapter firstAdapter = new LiveTypeAdapter(R.layout.live_type_fragment_item, fistTypeList);
                    recyclerViewFirst.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
                    recyclerViewFirst.setAdapter(firstAdapter);
                    firstAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter01, View view, int position) {
                            for (int i = 0; i < fistTypeList.size(); i++) {
                                fistTypeList.get(i).setSelect(false);
                            }
                            fistTypeList.get(position).setSelect(true);
                            adapter01.notifyDataSetChanged();

                            getSecondData(fistTypeList.get(position).getLIVETYPE_ID());
                        }
                    });
                }

            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void getSecondData(String liveType_id) {

        DataManager.getInstance(getActivity()).RequestHttp(NetApi.getLiveTypeSecond(DataManager.getMd5Str("LIVETYPE"), liveType_id), new ResultListener<LiveTypeModel>() {
            @Override
            public void responseSuccess(LiveTypeModel obj) {
                if ("01".equals(obj.getResult())) {
                    recyclerViewSecond.setVisibility(View.VISIBLE);
                    final List<LiveTypeModel.PdBean> secondTypeList = obj.getPd();
                    secondTypeList.get(0).setSelect(true);

                    LiveTypeAdapter secondAdapter = new LiveTypeAdapter(R.layout.live_type_fragment_item, secondTypeList);
                    recyclerViewSecond.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
                    recyclerViewSecond.setAdapter(secondAdapter);

                    getPusherListByType(secondTypeList.get(0).getLIVETYPE_ID());

                    secondAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            for (int i = 0; i < secondTypeList.size(); i++) {
                                secondTypeList.get(i).setSelect(false);
                            }

                            secondTypeList.get(position).setSelect(true);
                            adapter.notifyDataSetChanged();

                            getPusherListByType(secondTypeList.get(position).getLIVETYPE_ID());
                        }
                    });


                } else if ("02".equals(obj.getResult())) {
                    recyclerViewSecond.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void getPusherListByType(String LIVETYPE_ID) {
        DataManager.getInstance(getActivity()).RequestHttp(NetApi.getPushListByType(DataManager.getMd5Str("PUSHLIST"), LIVETYPE_ID), new ResultListener<LivePushListModel>() {
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

        if (null != obj && "01".equals(obj.getResult())) {

            pushList = obj.getPd().getPUSHONLINE().getOnlineInfo().getLiveStreamOnlineInfo();
            contentAdapter = new AbreComFragmentAdapter(pushList);
            recyclerViewContent.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
            recyclerViewContent.setAdapter(contentAdapter);
            contentAdapter.setEmptyView(R.layout.live_empty_layout, recyclerViewContent);

            contentAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    if (null != pushList && pushList.size() > 0) {

                        ActivityUtils.startActivityForData(getActivity(), AliLivePlayActivity.class, pushList.get(position).getPublishUrl());
                    }
                }
            });
        }

    }

    //    sb_typefragment  this is temp layout
    @Override
    public View initView(LayoutInflater inflater) {
        view = View.inflate(getActivity(), R.layout.ab_type_fragment, null);
        ButterKnife.bind(getActivity());
        return view;
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (isVisibleToUser) {
            getFirstData();
            isVisible = true;

        }
    }

    private boolean isVisible = false;

    @Override
    public void onResume() {
        super.onResume();
        LogUtils.i("++++++++++++++", "++++++++onResume++++++" + isVisible);
        if (!isVisible) {
//            getFirstData();
        }

    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtils.i("++++++++++++++", "++++++++onPause++++++" + isVisible);
        isVisible = false;
    }
}
