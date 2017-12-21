package com.zsh.blackcard.ui.my;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.ResultModel;
import com.zsh.blackcard.untils.UIUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecurityLoginActivity extends BaseActivity {

    @BindView(R.id.activity_security_original_et)
    EditText activity_security_original_et;
    @BindView(R.id.activity_security_new_et)
    EditText activity_security_new_et;
    @BindView(R.id.activity_security_new_again_et)
    EditText activity_security_new_again_et;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_security_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.blackwb_back, R.id.my_setting_security_login_save_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.blackwb_back:
                finish();
                break;
            case R.id.my_setting_security_login_save_tv:
                if (!TextUtils.isEmpty(activity_security_original_et.getText().toString()) && !TextUtils.isEmpty(activity_security_new_et.getText().toString()) && !TextUtils.isEmpty(activity_security_new_again_et.getText().toString()) && activity_security_new_et.getText().toString().equals(activity_security_new_again_et.getText().toString())) {
                    initChangePassWord();
                } else {
                    UIUtils.showToast("密码不能为空或输入错误");
                }
                break;
        }
    }

    private void initChangePassWord() {
        DataManager.getInstance(this).RequestHttp(NetApi.postSecurityPassWord(DataManager.getMd5Str("UPDUSERPASSWORD"), "d6a3779de8204dfd9359403f54f7d27c", activity_security_new_et.getText().toString().trim(), activity_security_original_et.getText().toString().trim()), new ResultListener<ResultModel>() {
            @Override
            public void responseSuccess(ResultModel obj) {
                if (obj.getResult().equals("01")) {
                    UIUtils.showToast("修改密码成功");
                    finish();
                } else if (obj.getResult().equals("06")) {
                    UIUtils.showToast("您的原始密码不正确");
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }
}
