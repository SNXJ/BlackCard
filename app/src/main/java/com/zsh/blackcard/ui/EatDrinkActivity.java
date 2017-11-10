package com.zsh.blackcard.ui;

import android.content.Intent;
import android.view.View;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;


public class EatDrinkActivity extends BaseActivity {

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_eat_drink);

        findViewById(R.id.hj_eat_set).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), EatDrinkSetActivity.class));
            }
        });


    }
}
