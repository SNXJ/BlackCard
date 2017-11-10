package com.zsh.blackcard.ui.home;

import android.content.Intent;
import android.view.View;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;


public class HomeHotelActivity extends BaseActivity {


    @Override
    protected void initUI() {
        setContentView(R.layout.activity_home_hotel);
        findViewById(R.id.ll_hotel_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HomeHotelActivityDetail.class));
            }
        });
    }
}
