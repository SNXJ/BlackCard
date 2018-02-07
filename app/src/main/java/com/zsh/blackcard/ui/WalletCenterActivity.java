package com.zsh.blackcard.ui;

import android.view.View;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.ui.zgactivity.BlackSurplusActivity;
import com.zsh.blackcard.utils.ActivityUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kkkkk on 2017/11/10.
 * 钱包中心
 */

public class WalletCenterActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_my_wallet_center);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.blackwb_back, R.id.my_wallet_cash_img, R.id.my_wallet_surplus_img})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.blackwb_back:
                finish();
                break;
            case R.id.my_wallet_cash_img:
                ActivityUtils.startActivity(this, WalletCashActivity.class);
                break;
            case R.id.my_wallet_surplus_img:
                ActivityUtils.startActivity(this, BlackSurplusActivity.class);
                break;
        }
    }
}
