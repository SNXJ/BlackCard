package com.zsh.blackcard.ui.my;

import android.view.View;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.untils.ActivityUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecurityActivity extends BaseActivity {

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_security);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.blackwb_back,R.id.my_setting_security_login_relative,R.id.my_setting_security_pay_relative,R.id.my_setting_security_print_relative})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.blackwb_back:
                finish();
                break;
            case R.id.my_setting_security_login_relative:
                ActivityUtils.startActivity(this,SecurityLoginActivity.class);
                break;
            case R.id.my_setting_security_pay_relative:
                ActivityUtils.startActivity(this,SecurityPayActivity.class);
                break;
            case R.id.my_setting_security_print_relative:
                break;
        }
    }
}
