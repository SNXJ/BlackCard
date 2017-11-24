package com.zsh.blackcard.ui;

import android.view.View;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.untils.ActivityUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kkkkk on 2017/11/11.
 */

public class OrderCenterActivity extends BaseActivity {

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_zg_my);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.zgmyback, R.id.zgmy_tv_dingdan, R.id.my_order_pay_rb, R.id.my_order_receipt_rb, R.id.my_order_comment_rb, R.id.my_order_service_rb, R.id.my_order_vip_rb, R.id.my_order_collection_rb, R.id.my_order_address_rb, R.id.my_order_customer_rb, R.id.my_order_integral_rb, R.id.my_order_discount_rb, R.id.my_order_gift_rb})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.zgmyback:
                finish();
                break;
            case R.id.zgmy_tv_dingdan:
                ActivityUtils.startActivity(this, MyOrderActivity.class);
                break;
            case R.id.my_order_pay_rb:
                ActivityUtils.startActivityForData(this, MyOrderActivity.class, "2");
                break;
            case R.id.my_order_receipt_rb:
                ActivityUtils.startActivityForData(this, MyOrderActivity.class, "3");
                break;
            case R.id.my_order_comment_rb:
                ActivityUtils.startActivityForData(this, MyOrderActivity.class, "4");
                break;
            case R.id.my_order_service_rb:
                ActivityUtils.startActivityForData(this, MyOrderActivity.class, "5");
                break;
            case R.id.my_order_vip_rb:
                ActivityUtils.startActivity(this, VipCenterActivity.class);
                break;
                //炫购收藏
            case R.id.my_order_collection_rb:
                ActivityUtils.startActivity(this,CollectionActivity.class);
                break;
            case R.id.my_order_address_rb:
                ActivityUtils.startActivity(this, AddressManageActivity.class);
                break;
            case R.id.my_order_customer_rb:
                ActivityUtils.startActivity(this, CusCenterChatActivity.class);
                break;
            case R.id.my_order_discount_rb:
                ActivityUtils.startActivity(this, DiscountCouponActivity.class);
                break;
            case R.id.my_order_integral_rb:
                ActivityUtils.startActivity(this, IntegralActivity.class);
                break;
            case R.id.my_order_gift_rb:
                ActivityUtils.startActivity(this, ExChangeActivity.class);
                break;

        }

    }
}
