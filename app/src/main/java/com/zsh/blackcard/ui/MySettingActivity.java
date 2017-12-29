package com.zsh.blackcard.ui;

import android.view.View;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.ui.my.NotificationActivity;
import com.zsh.blackcard.ui.my.SecurityActivity;
import com.zsh.blackcard.ui.my.UserInfoActivity;
import com.zsh.blackcard.utils.ActivityUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kkkkk on 2017/11/11.
 */

public class MySettingActivity extends BaseActivity {


    @Override
    protected void initUI() {
        setContentView(R.layout.activity_my_setting);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.blackwb_back, R.id.my_setting_info_relative, R.id.my_setting_notification_relative, R.id.my_setting_security_relative, R.id.my_setting_about_relative, R.id.my_setting_exit_relative})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.blackwb_back:
                finish();
                break;
            //个人资料
            case R.id.my_setting_info_relative:
                ActivityUtils.startActivity(this, UserInfoActivity.class);
                break;
            case R.id.my_setting_notification_relative:
                ActivityUtils.startActivity(this, NotificationActivity.class);
                break;
            case R.id.my_setting_security_relative:
                ActivityUtils.startActivity(this, SecurityActivity.class);
                break;
            case R.id.my_setting_about_relative:
                break;
            case R.id.my_setting_exit_relative:
                break;
        }
    }
}
