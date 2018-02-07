package com.zsh.blackcard.ui;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kkkkk on 2017/11/13.
 */

public class WalletCashActivity extends BaseActivity {

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_my_wallet_cash);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.blackwb_back)
    public void onClick(){
        finish();
    }
}
