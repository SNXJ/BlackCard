package com.zsh.blackcard.ui.zgactivity;

import android.view.View;
import android.widget.ImageView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

/**
 * Created by kkkkk on 2017/11/11.
 */

public class GameCenterActivity extends BaseActivity implements View.OnClickListener {

    private ImageView back_img;
    @Override
    protected void initUI() {
        setContentView(R.layout.activity_game_center);
        initFindId();
        initOnClick();
        initDate();
    }

    private void initDate() {

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
