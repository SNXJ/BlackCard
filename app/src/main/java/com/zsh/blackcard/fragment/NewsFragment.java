package com.zsh.blackcard.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.ZgFindAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.ZgFindModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZMediaManager;
import cn.jzvd.JZUtils;
import cn.jzvd.JZVideoPlayer;

/**
 * Created by kkkkk on 2017/12/6.
 */

public class NewsFragment extends BaseFragment {

    private String CAIDAN_ID = null;

    @BindView(R.id.zg_find_recycler)
    RecyclerView zg_find_recycler;

    private ZgFindAdapter zgFindAdapter;

    public static NewsFragment newInstance(String id) {
        NewsFragment fragment = new NewsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void initDate(Bundle savedInstanceState) {
        if (getArguments() != null) {
            CAIDAN_ID = getArguments().getString("id");
        }
        DataManager.getInstance(getActivity()).RequestHttp(NetApi.postZgFind(DataManager.getMd5Str("DISCOVERLIST"), CAIDAN_ID), new ResultListener<ZgFindModel>() {
            @Override
            public void responseSuccess(ZgFindModel obj) {
                try {
                    if (obj.getResult().equals("01")) {
                        for (int i = 0; i < obj.getPd().size(); i++) {
                            if (obj.getPd().get(i).getDIS_TYPE().equals("2001")) {
                                obj.getPd().get(i).setItemType(2001);
                            } else if (obj.getPd().get(i).getDIS_TYPE().equals("2002")) {
                                obj.getPd().get(i).setItemType(2002);
                            } else if (obj.getPd().get(i).getDIS_TYPE().equals("2003")) {
                                obj.getPd().get(i).setItemType(2003);
                            } else {
                                obj.getPd().get(i).setItemType(2004);
                            }
                        }
                        zgFindAdapter = new ZgFindAdapter(obj.getPd());
                        zg_find_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
                        zg_find_recycler.setAdapter(zgFindAdapter);
                        zgFindAdapter.setEmptyView(R.layout.zg_search_empty, zg_find_recycler);
                        zg_find_recycler.addOnChildAttachStateChangeListener(new VideoLoad());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            JZVideoPlayer.releaseAllVideos();
        }
    }

    @Override
    public View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.zg_find_fragment, null);
        ButterKnife.bind(this, view);
        return view;
    }

    private class VideoLoad implements RecyclerView.OnChildAttachStateChangeListener {

        @Override
        public void onChildViewAttachedToWindow(View view) {

        }

        @Override
        public void onChildViewDetachedFromWindow(View view) {
            JZVideoPlayer jzVideoPlayer = (JZVideoPlayer) view.findViewById(R.id.zg_find_video);
            if (jzVideoPlayer != null && JZUtils.dataSourceObjectsContainsUri(jzVideoPlayer.dataSourceObjects, JZMediaManager.getCurrentDataSource())) {
                JZVideoPlayer.releaseAllVideos();
            }
        }
    }

}
