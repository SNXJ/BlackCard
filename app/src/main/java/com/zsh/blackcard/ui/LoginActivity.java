package com.zsh.blackcard.ui;

import android.view.View;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.untils.ActivityUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Name: LoginActivity
 * Author: SNXJ
 * Date: 2017-11-08
 * Description:描述：
 */
public class LoginActivity extends BaseActivity {
    @Override
    protected void initUI() {
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.login_btn,R.id.login_register_tv,R.id.login_forget_tv})
    public void onClick(View view){
        switch (view.getId()){
            //登录
            case R.id.login_btn:

                break;
            //在线申请
            case R.id.login_register_tv:

                break;
            //忘记密码
            case R.id.login_forget_tv:

                break;
        }
    }
}
