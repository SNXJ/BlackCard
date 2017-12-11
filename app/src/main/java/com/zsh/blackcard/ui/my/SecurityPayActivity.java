package com.zsh.blackcard.ui.my;

import android.view.View;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kkkkk on 2017/12/9.
 */

public class SecurityPayActivity extends BaseActivity {
    @Override
    protected void initUI() {
        setContentView(R.layout.activity_security_pay);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.blackwb_back,R.id.my_setting_security_login_save_tv})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.blackwb_back:
                finish();
                break;
            case R.id.my_setting_security_login_save_tv:

                break;
        }
    }
}
