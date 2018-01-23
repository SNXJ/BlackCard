package com.zsh.blackcard.ui;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class BlackCurrencyActivity extends BaseActivity  {

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_blackcoffeecurrency);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.blackwb_back)
    public void onClick(){
        finish();
    }
}
