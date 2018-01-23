package com.zsh.blackcard.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.HjRecyclerAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.CityEventModel;
import com.zsh.blackcard.model.HjRecyclerModel;
import com.zsh.blackcard.ui.EatDrinkActivity;
import com.zsh.blackcard.ui.HjSearchActivity;
import com.zsh.blackcard.utils.ActivityUtils;
import com.zsh.blackcard.view.selectcity.SelectCityActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * 汇聚页面
 */

public class HjFragment extends BaseFragment {

    @BindView(R.id.hj_recycler)
    RecyclerView hj_recycler;
    @BindView(R.id.rb_hj_city)
    RadioButton rbHjCity;

    private HjRecyclerAdapter hjRecyclerAdapter;

    @Override
    public void initDate(Bundle savedInstanceState) {
        hj_recycler.setNestedScrollingEnabled(false);

        showLoading(getActivity());

        DataManager.getInstance(getActivity()).RequestHttp(NetApi.postHjRecycler(DataManager.getMd5Str("CONVERGELIST")), new ResultListener<HjRecyclerModel>() {
            @Override
            public void responseSuccess(HjRecyclerModel obj) {
                hjRecyclerAdapter = new HjRecyclerAdapter(R.layout.hj_recycler_item, obj.getPd());
                hj_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
                hj_recycler.setAdapter(hjRecyclerAdapter);
                hjRecyclerAdapter.setOnItemClickListener(new HjOnItemClick());
            }

            @Override
            public void onCompleted() {
                dialogDismiss();
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(CityEventModel event) {
        rbHjCity.setText(event.getCity());
    }


    @Override
    public View initView(LayoutInflater inflater) {
        View view = View.inflate(getActivity(), R.layout.hjfragment, null);
        ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);
        return view;
    }


    @OnClick({R.id.rb_hj_city, R.id.hj_linear_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb_hj_city:
                ActivityUtils.startActivity(getActivity(), SelectCityActivity.class);
                break;
            case R.id.hj_linear_search:
                ActivityUtils.startActivity(getActivity(), HjSearchActivity.class);
                break;
        }
    }


    private class HjOnItemClick implements BaseQuickAdapter.OnItemClickListener {

        @Override
        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            //传递CONVERGE_ID和title标题
            ActivityUtils.startActivityForData(getActivity(), EatDrinkActivity.class, ((HjRecyclerModel.PdBean) adapter.getData().get(position)).getCONVERGE_ID(), ((HjRecyclerModel.PdBean) adapter.getData().get(position)).getIMGCNCHAR());
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
