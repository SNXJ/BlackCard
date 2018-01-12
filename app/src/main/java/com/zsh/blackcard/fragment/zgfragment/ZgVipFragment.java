package com.zsh.blackcard.fragment.zgfragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.ZgPersonalTailorAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.ZgPersonalTailorModel;
import com.zsh.blackcard.ui.ZgPersonalTailorDetailActivity;
import com.zsh.blackcard.utils.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ZCY on 2018/1/11.
 * 会员特权碎片
 */

public class ZgVipFragment extends BaseFragment {

    @BindView(R.id.zg_vip_frg_recycler)
    RecyclerView zg_vip_frg_recycler;

    private ZgPersonalTailorAdapter zgPersonalTailorAdapter;

    @Override
    public void initDate(Bundle savedInstanceState) {
        DataManager.getInstance(getActivity()).RequestHttp(NetApi.postZgPersonalTailorModel(DataManager.getMd5Str("PERSONAL")), new ResultListener<ZgPersonalTailorModel>() {
            @Override
            public void responseSuccess(ZgPersonalTailorModel obj) {
                zgPersonalTailorAdapter = new ZgPersonalTailorAdapter(R.layout.zg_drawer_personal_recycler_item, obj.getPd());
                zg_vip_frg_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
                zg_vip_frg_recycler.setAdapter(zgPersonalTailorAdapter);
                zgPersonalTailorAdapter.setOnItemChildClickListener(new ZgPersonalTailorOnItemClick());
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    @Override
    public View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.zg_vip_fragment, null);
        ButterKnife.bind(this, view);
        return view;
    }

    private class ZgPersonalTailorOnItemClick implements BaseQuickAdapter.OnItemChildClickListener {

        @Override
        public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
            ActivityUtils.startActivityForData(getActivity(), ZgPersonalTailorDetailActivity.class, ((ZgPersonalTailorModel.PdBean) adapter.getData().get(position)).getPERSONAL_ID());
        }
    }
}
