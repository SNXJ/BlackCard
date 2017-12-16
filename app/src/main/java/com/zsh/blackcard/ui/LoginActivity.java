package com.zsh.blackcard.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.LoginModel;
import com.zsh.blackcard.untils.ActivityUtils;
import com.zsh.blackcard.untils.UIUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Name: LoginActivity
 * Author: SNXJ
 * Date: 2017-11-08
 * Description:描述：
 */
public class LoginActivity extends BaseActivity {

    @BindView(R.id.login_user_et)
    EditText login_user_et;
    @BindView(R.id.login_pass_et)
    EditText login_pass_et;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.login_btn, R.id.login_register_tv, R.id.login_forget_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            //登录
            case R.id.login_btn:
                //登录
                initLogin();
                break;
            //在线申请
            case R.id.login_register_tv:
                ActivityUtils.startActivity(this, RegisterActivity.class);
                break;
            //忘记密码
            case R.id.login_forget_tv:

                break;
        }
    }

    //登录方法
    private void initLogin() {
        if (TextUtils.isEmpty(login_user_et.getText().toString().trim()) || TextUtils.isEmpty(login_pass_et.getText().toString().trim())) {
            UIUtils.showToast("帐号或密码不能为空");
        } else {
            DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postLoginCard(DataManager.getMd5Str("LOGIN"), login_user_et.getText().toString().trim(), login_pass_et.getText().toString().trim()), new ResultListener<LoginModel>() {
                @Override
                public void responseSuccess(LoginModel obj) {
                    if (obj.getResult().equals("01")) {
                        ActivityUtils.startActivity(LoginActivity.this, MainActivity.class);
                        finish();
                    } else if (obj.getResult().equals("06")) {
                        UIUtils.showToast("密码错误");
                    } else if (obj.getResult().equals("04")) {
                        UIUtils.showToast("没有该卡号");
                    }
                }

                @Override
                public void onCompleted() {

                }
            });
        }
    }
}
