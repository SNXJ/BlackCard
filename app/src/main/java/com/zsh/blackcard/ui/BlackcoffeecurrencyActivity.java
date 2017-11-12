package com.zsh.blackcard.ui;

import android.view.View;
import android.widget.ImageView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;


public class BlackcoffeecurrencyActivity extends BaseActivity implements View.OnClickListener {

    private ImageView back_img;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_blackcoffeecurrency);
        initFindId();
        initOnClick();
    }

    private void initOnClick() {
        back_img.setOnClickListener(this);
    }

    private void initFindId() {
        back_img = (ImageView) findViewById(R.id.blackwb_back);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
