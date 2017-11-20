package com.zsh.blackcard.ui;

import android.view.View;
import android.widget.ImageView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

/**
 * 吃喝玩乐
 */
public class EatDrinkSetActivity extends BaseActivity implements View.OnClickListener {

    private ImageView back_img;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_eat_drink_set);
        initView();
        initOnClick();
    }

    private void initOnClick() {
        back_img.setOnClickListener(this);
    }

    private void initView() {
        back_img = (ImageView) findViewById(R.id.blackwb_back);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.blackwb_back:
                finish();
                break;
        }
    }
}
