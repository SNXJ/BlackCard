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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZMediaManager;
import cn.jzvd.JZUtils;
import cn.jzvd.JZVideoPlayer;

/**
 * Created by kkkkk on 2017/12/6.
 */

public class ZgFindFragment extends BaseFragment {

    private String CAIDAN_ID = null;

    @BindView(R.id.zg_find_recycler)
    RecyclerView zg_find_recycler;

    private ZgFindAdapter zgFindAdapter;
    private List<ZgFindModel.PdBean> list = new ArrayList<>();

    @Override
    public void initDate(Bundle savedInstanceState) {
        CAIDAN_ID = getArguments().getString("id");
        DataManager.getInstance(getActivity()).RequestHttp(NetApi.postZgFind(DataManager.getMd5Str("DISCOVERLIST"), CAIDAN_ID), new ResultListener<ZgFindModel>() {
            @Override
            public void responseSuccess(ZgFindModel obj) {
                if (obj.getResult().equals("01")) {
                    for (int i = 0; i < obj.getPd().size(); i++) {
                        if(!obj.getPd().get(i).getSHOWVIDEO().equals("")){
                            obj.getPd().get(i).setItemType(1);
                        }else{
                            obj.getPd().get(i).setItemType(2);
                        }
                    }
                    list.addAll(obj.getPd());
                    zgFindAdapter = new ZgFindAdapter(list);
                    zg_find_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
                    zg_find_recycler.setAdapter(zgFindAdapter);
                    zg_find_recycler.addOnChildAttachStateChangeListener(new VideoLoad());
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
