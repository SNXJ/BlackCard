package com.zsh.blackcard.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.ui.AddressManageActivity;
import com.zsh.blackcard.ui.CollectionActivity;
import com.zsh.blackcard.ui.CusCenterChatActivity;
import com.zsh.blackcard.ui.DiscountCouponActivity;
import com.zsh.blackcard.ui.ExChangeActivity;
import com.zsh.blackcard.ui.IntegralActivity;
import com.zsh.blackcard.ui.MyOrderActivity;
import com.zsh.blackcard.ui.VipCenterActivity;
import com.zsh.blackcard.untils.ActivityUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kkkkk on 2017/11/28.
 * 订单中心，尊购以外的界面
 */

public class OrderNoZgFragment extends BaseFragment {
    @Override
    public void initDate(Bundle savedInstanceState) {

    }

    @Override
    public View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.order_no_zg_fragment, null);
        ButterKnife.bind(this, view);
        return view;
    }
}
