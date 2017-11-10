package com.zsh.blackcard.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.ui.BlackcoffeecurrencyActivity;
import com.zsh.blackcard.ui.CusCenterActivity;
import com.zsh.blackcard.ui.MyFriendActivity;
import com.zsh.blackcard.ui.VipCenterActivity;
import com.zsh.blackcard.ui.WalletCenterActivity;
import com.zsh.blackcard.untils.ActivityUtils;


/**
 * Created by admin on 2017/10/11.
 */

public class MyFragment extends BaseFragment implements View.OnClickListener {
    private View view;
    private TextView blackmoney_tv, myfriend_tv;
    private ImageView my_vip_center_img, my_cus_center_img, my_wallet_center_img;

    @Override
    public void initDate(Bundle savedInstanceState) {

    }

    @Override
    public View initView(LayoutInflater inflater) {
        view = View.inflate(getActivity(), R.layout.myfragment, null);
        //初始化ButterKnife
        myfindID();
        myOnClick();
        return view;
    }

    private void myOnClick() {
        //黑咖币点击
        blackmoney_tv.setOnClickListener(this);
        //好友点击
        myfriend_tv.setOnClickListener(this);
        //会员中心点击
        my_vip_center_img.setOnClickListener(this);
        //客服中心点击
        my_cus_center_img.setOnClickListener(this);
        //钱包中心点击
        my_wallet_center_img.setOnClickListener(this);
    }

    private void myfindID() {
        blackmoney_tv = (TextView) view.findViewById(R.id.my_blackmoney_tv);
        myfriend_tv = (TextView) view.findViewById(R.id.my_friend_tv);
        my_vip_center_img = (ImageView) view.findViewById(R.id.my_vip_center_img);
        my_cus_center_img = (ImageView) view.findViewById(R.id.my_cus_center_img);
        my_wallet_center_img = (ImageView) view.findViewById(R.id.my_wallet_center_img);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.my_blackmoney_tv:
                ActivityUtils.startActivity(getActivity(), BlackcoffeecurrencyActivity.class);
                break;
            case R.id.my_friend_tv:
                ActivityUtils.startActivity(getActivity(), MyFriendActivity.class);
                break;
            case R.id.my_vip_center_img:
                ActivityUtils.startActivity(getActivity(), VipCenterActivity.class);
                break;
            case R.id.my_cus_center_img:
                ActivityUtils.startActivity(getActivity(), CusCenterActivity.class);
                break;
            case R.id.my_wallet_center_img:
                ActivityUtils.startActivity(getActivity(), WalletCenterActivity.class);
        }
    }
}
