package com.zsh.blackcard.ui;

import android.view.View;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.LoginModel;

import java.util.Map;
import java.util.TreeMap;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Name: LoginActivity
 * Author: SNXJ
 * Date: 2017-11-08
 * Description:描述：
 */
public class LoginActivity extends BaseActivity {
    // private CompositeSubscription compositeSubscription = new CompositeSubscription();


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
                // new DataManager(this).MyTest();
                Map<String, String> map = new TreeMap<>();
                // map.put("FKEY", DataManager.getMd5Str("COMMEND"));
                map.put("FKEY", DataManager.getMd5Str("REGISTER"));
                map.put("CARDNO", "0000000000");
                map.put("PHONE", "13888888888888");
                map.put("REALNAME", "XXXXXXXXXXX");
                map.put("PROVINCE", "XXXXXXXXXXX");
                map.put("ADDRESS", "XXXXXXXXXXXX");
                map.put("CUSTOM", "XXXXXXXXXXXXX");
                map.put("CUSTOMCONTENT", "XXXXXXXXXXXXXX");

                DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).getSearchBook(map), new ResultListener<LoginModel>() {
                    @Override
                    public void responSuccess(LoginModel obj) {
                        System.out.println("++++++++++222222222222++++++++++++" + obj.getResult());
                    }

                    @Override
                    public void onCompleted() {

                    }
                });

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
