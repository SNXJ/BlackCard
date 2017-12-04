package com.zsh.blackcard.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.HjRecyclerAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.HjRecyclerModel;
import com.zsh.blackcard.ui.EatDrinkActivity;
import com.zsh.blackcard.untils.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 汇聚页面
 */

public class HjFragment extends BaseFragment {

    @BindView(R.id.hj_recycler)
    RecyclerView hj_recycler;

    private HjRecyclerAdapter hjRecyclerAdapter;

    @Override
    public void initDate(Bundle savedInstanceState) {
        hj_recycler.setNestedScrollingEnabled(false);

        DataManager.getInstance(getActivity()).RequestHttp(NetApi.getInstance(getActivity()).postHjRecycler(DataManager.getMd5Str("CONVERGELIST")), new ResultListener<HjRecyclerModel>() {
            @Override
            public void responseSuccess(HjRecyclerModel obj) {
                hjRecyclerAdapter = new HjRecyclerAdapter(R.layout.hj_recycler_item,obj.getPd());
                hj_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
                hj_recycler.setAdapter(hjRecyclerAdapter);
                hjRecyclerAdapter.setOnItemClickListener(new HjOnItemClick());
            }

            @Override
            public void onCompleted() {

            }
        });



    }

    @Override
    public View initView(LayoutInflater inflater) {
        View view = View.inflate(getActivity(), R.layout.hjfragment, null);
        ButterKnife.bind(this,view);
        return view;
    }

    private class HjOnItemClick implements BaseQuickAdapter.OnItemClickListener{

        @Override
        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            //传递CONVERGE_ID和title标题
            ActivityUtils.startActivityForData(getActivity(), EatDrinkActivity.class,((HjRecyclerModel.PdBean)adapter.getData().get(position)).getCONVERGE_ID(),((HjRecyclerModel.PdBean)adapter.getData().get(position)).getIMGENCHAR());
        }
    }
}
