package com.zsh.blackcard.ui;

import android.view.View;
import android.widget.ImageView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.ui.zgactivity.BlackSurplusActivity;
import com.zsh.blackcard.utils.ActivityUtils;

/**
 * Created by kkkkk on 2017/11/10.
 */

public class WalletCenterActivity extends BaseActivity implements View.OnClickListener {

    private ImageView back_img, my_wallet_cash_img, my_wallet_surplus_img;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_my_wallet_center);
        initFindId();
        initOnClick();
        initDate();
    }

    private void initDate() {
    }

    private void initOnClick() {
        back_img.setOnClickListener(this);
        my_wallet_cash_img.setOnClickListener(this);
        my_wallet_surplus_img.setOnClickListener(this);
    }

    private void initFindId() {
        back_img = (ImageView) findViewById(R.id.blackwb_back);
        my_wallet_cash_img = (ImageView) findViewById(R.id.my_wallet_cash_img);
        my_wallet_surplus_img = (ImageView) findViewById(R.id.my_wallet_surplus_img);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.blackwb_back:
                finish();
                break;
            case R.id.my_wallet_cash_img:
                ActivityUtils.startActivity(this,WalletCashActivity.class);
                break;
            case R.id.my_wallet_surplus_img:
                ActivityUtils.startActivity(this, BlackSurplusActivity.class);
                break;
        }
    }
}
