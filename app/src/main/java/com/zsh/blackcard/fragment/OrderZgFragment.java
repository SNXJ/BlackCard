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
import com.zsh.blackcard.utils.ActivityUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kkkkk on 2017/11/28.
 * 订单中心，尊购的界面
 */

public class OrderZgFragment extends BaseFragment {
    @Override
    public void initDate(Bundle savedInstanceState) {

    }

    @Override
    public View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.order_zg_fragment, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.zgmy_tv_dingdan, R.id.my_order_pay_rb, R.id.my_order_receipt_rb, R.id.my_order_comment_rb, R.id.my_order_service_rb, R.id.my_order_vip_rb, R.id.my_order_collection_rb, R.id.my_order_address_rb, R.id.my_order_customer_rb, R.id.my_order_integral_rb, R.id.my_order_discount_rb, R.id.my_order_gift_rb})
    public void onClick(View view) {
        switch (view.getId()) {
            //获取全部订单
            case R.id.zgmy_tv_dingdan:
                ActivityUtils.startActivityForData(getActivity(), MyOrderActivity.class, "1");
                break;
            //待支付
            case R.id.my_order_pay_rb:
                ActivityUtils.startActivityForData(getActivity(), MyOrderActivity.class, "2");
                break;
            case R.id.my_order_receipt_rb:
                ActivityUtils.startActivityForData(getActivity(), MyOrderActivity.class, "3");
                break;
            case R.id.my_order_comment_rb:
                ActivityUtils.startActivityForData(getActivity(), MyOrderActivity.class, "4");
                break;
            case R.id.my_order_service_rb:
                ActivityUtils.startActivityForData(getActivity(), MyOrderActivity.class, "5");
                break;
            case R.id.my_order_vip_rb:
                ActivityUtils.startActivity(getActivity(), VipCenterActivity.class);
                break;
            //炫购收藏
            case R.id.my_order_collection_rb:
                ActivityUtils.startActivity(getActivity(), CollectionActivity.class);
                break;
            case R.id.my_order_address_rb:
                ActivityUtils.startActivity(getActivity(), AddressManageActivity.class);
                break;
            case R.id.my_order_customer_rb:
                ActivityUtils.startActivity(getActivity(), CusCenterChatActivity.class);
                break;
            //优惠券
            case R.id.my_order_discount_rb:
                ActivityUtils.startActivity(getActivity(), DiscountCouponActivity.class);
                break;
            case R.id.my_order_integral_rb:
                ActivityUtils.startActivity(getActivity(), IntegralActivity.class);
                break;
            case R.id.my_order_gift_rb:
                ActivityUtils.startActivity(getActivity(), ExChangeActivity.class);
                break;
        }
    }
}
