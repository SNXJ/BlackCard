package com.zsh.blackcard.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.untils.ActivityUtils;

/**
 * Created by kkkkk on 2017/11/13.
 */

public class MyPowerActivity extends BaseActivity implements View.OnClickListener {

    private TextView my_power_one_tv,my_power_two_tv,my_power_three_tv,my_power_four_tv,my_power_five_tv,my_power_exchange_tv;
    private ImageView back_img;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_my_power);
        initView();
        initOnClick();
        initDate();
    }

    private void initDate() {
        my_power_one_tv.setText("99\n购物分");
        my_power_two_tv.setText("99\n活动分");
        my_power_three_tv.setText("99\n互动分");
        my_power_four_tv.setText("99\n基础分");
        my_power_five_tv.setText("99\n荣耀分");
    }

    private void initOnClick() {
        my_power_exchange_tv.setOnClickListener(this);
    }

    private void initView() {
        my_power_one_tv = (TextView) findViewById(R.id.my_power_one_tv);
        my_power_two_tv = (TextView) findViewById(R.id.my_power_two_tv);
        my_power_three_tv = (TextView) findViewById(R.id.my_power_three_tv);
        my_power_four_tv = (TextView) findViewById(R.id.my_power_four_tv);
        my_power_five_tv = (TextView) findViewById(R.id.my_power_five_tv);
        my_power_exchange_tv = (TextView) findViewById(R.id.my_power_exchange_tv);
        back_img = (ImageView) findViewById(R.id.blackwb_back);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.my_power_exchange_tv:
                ActivityUtils.startActivity(this,ExChangeActivity.class);
                break;
            case R.id.blackwb_back:
                finish();
                break;
        }
    }
}
