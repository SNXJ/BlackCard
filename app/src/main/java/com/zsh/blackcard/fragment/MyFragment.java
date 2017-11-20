package com.zsh.blackcard.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.ui.BlackCurrencyActivity;
import com.zsh.blackcard.ui.CircleCenterActivity;
import com.zsh.blackcard.ui.CusCenterChatActivity;
import com.zsh.blackcard.ui.HouseCenterActivity;
import com.zsh.blackcard.ui.HuoDongActivity;
import com.zsh.blackcard.ui.MyFriendActivity;
import com.zsh.blackcard.ui.MyPowerActivity;
import com.zsh.blackcard.ui.MySettingActivity;
import com.zsh.blackcard.ui.OrderCenterActivity;
import com.zsh.blackcard.ui.VipCenterActivity;
import com.zsh.blackcard.ui.WalletCenterActivity;
import com.zsh.blackcard.ui.zgactivity.GameCenterActivity;
import com.zsh.blackcard.untils.ActivityUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by admin on 2017/10/11.
 */

public class MyFragment extends BaseFragment implements View.OnClickListener {

    @Override
    public void initDate(Bundle savedInstanceState) {

    }

    @Override
    public View initView(LayoutInflater inflater) {
        View view = View.inflate(getActivity(), R.layout.myfragment, null);
        //初始化ButterKnife
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.my_vip_center_relative, R.id.my_house_center_relative, R.id.my_circle_center_relative, R.id.my_huodong_center_relative, R.id.my_shop_center_relative, R.id.my_customer_center_relative, R.id.my_wallet_center_relative, R.id.my_game_center_relative, R.id.my_order_center_relative, R.id.my_setting_center_relative,R.id.my_friend_linear,R.id.my_black_linear,R.id.my_power_linear})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.my_vip_center_relative:
                ActivityUtils.startActivity(getActivity(), VipCenterActivity.class);
                break;
            case R.id.my_house_center_relative:
                ActivityUtils.startActivity(getActivity(), HouseCenterActivity.class);
                break;
            case R.id.my_circle_center_relative:
                ActivityUtils.startActivity(getActivity(), CircleCenterActivity.class);
                break;
            case R.id.my_huodong_center_relative:
                ActivityUtils.startActivity(getActivity(), HuoDongActivity.class);
                break;
            case R.id.my_shop_center_relative:
//                ActivityUtils.startActivity(getActivity(), );
                break;
            case R.id.my_customer_center_relative:
                ActivityUtils.startActivity(getActivity(), CusCenterChatActivity.class);
                break;
            case R.id.my_wallet_center_relative:
                ActivityUtils.startActivity(getActivity(), WalletCenterActivity.class);
                break;
            case R.id.my_game_center_relative:
                ActivityUtils.startActivity(getActivity(), GameCenterActivity.class);
                break;
            case R.id.my_order_center_relative:
                ActivityUtils.startActivity(getActivity(), OrderCenterActivity.class);
                break;
            case R.id.my_setting_center_relative:
                ActivityUtils.startActivity(getActivity(), MySettingActivity.class);
                break;
            case R.id.my_friend_linear:
                ActivityUtils.startActivity(getActivity(),MyFriendActivity.class);
                break;
            case R.id.my_black_linear:
                ActivityUtils.startActivity(getActivity(), BlackCurrencyActivity.class);
                break;
            case R.id.my_power_linear:
                ActivityUtils.startActivity(getActivity(),MyPowerActivity.class);
                break;
        }
    }

}
