package com.zsh.blackcard.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;


public class EatDrinkActivity extends BaseActivity {

    private LinearLayout linearLayout;
    private ImageView back_img;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_eat_drink);

        findViewById(R.id.hj_eat_set).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), EatDrinkSetActivity.class));
            }
        });

        findViewById(R.id.linear_detail).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), EatDrinkDetailActivity.class));
            }
        });

        findViewById(R.id.blackwb_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
