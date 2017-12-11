package com.zsh.blackcard.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;

import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.OrderCenterBarRecyclerModel;
import com.zsh.blackcard.ui.AddressManageActivity;
import com.zsh.blackcard.ui.CollectionActivity;
import com.zsh.blackcard.ui.CusCenterChatActivity;
import com.zsh.blackcard.ui.DiscountCouponActivity;
import com.zsh.blackcard.ui.ExChangeActivity;
import com.zsh.blackcard.ui.IntegralActivity;
import com.zsh.blackcard.ui.MyOrderActivity;
import com.zsh.blackcard.ui.MyOrderOtherActivity;
import com.zsh.blackcard.ui.OrderCenterActivity;
import com.zsh.blackcard.ui.SbActivity;
import com.zsh.blackcard.ui.VipCenterActivity;
import com.zsh.blackcard.untils.ActivityUtils;
import com.zsh.blackcard.untils.UIUtils;

import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

/**
 * Created by kkkkk on 2017/11/28.
 * 订单中心，尊购以外的界面
 */

public class OrderNoZgFragment extends BaseFragment {

    private OrderCenterActivity orderCenterActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        orderCenterActivity = (OrderCenterActivity) getActivity();
    }

    @Override
    public void initDate(Bundle savedInstanceState) {

    }

    @Override
    public View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.order_no_zg_fragment, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.my_order_all_rb, R.id.my_order_fk_rb, R.id.my_order_sy_rb, R.id.my_order_pj_rb})
    public void onClick(View view) {
        switch (view.getId()) {
            //全部
            case R.id.my_order_all_rb:
                ActivityUtils.startActivityForData(getActivity(), MyOrderOtherActivity.class, "",orderCenterActivity.getSearchTitle());
                break;
            //待付款
            case R.id.my_order_fk_rb:
                ActivityUtils.startActivityForData(getActivity(), MyOrderOtherActivity.class, "0040001",orderCenterActivity.getSearchTitle());
                break;
            //待使用
            case R.id.my_order_sy_rb:
                ActivityUtils.startActivityForData(getActivity(), MyOrderOtherActivity.class, "0040002",orderCenterActivity.getSearchTitle());
                break;
            //待评价
            case R.id.my_order_pj_rb:
                ActivityUtils.startActivityForData(getActivity(), MyOrderOtherActivity.class, "0040003",orderCenterActivity.getSearchTitle());
                break;
        }
    }
}
