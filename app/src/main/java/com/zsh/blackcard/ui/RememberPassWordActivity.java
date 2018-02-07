package com.zsh.blackcard.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.utils.UIUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/***
 * 找回登录密码
 */
public class RememberPassWordActivity extends BaseActivity {

    @BindView(R.id.activity_remember_user_et)
    EditText activity_remember_user_et;
    @BindView(R.id.activity_remember_id_et)
    EditText activity_remember_id_et;
    @BindView(R.id.activity_remember_phone_et)
    EditText activity_remember_phone_et;
    @BindView(R.id.activity_remember_code_et)
    EditText activity_remember_code_et;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_remember_pass_word);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.blackwb_back, R.id.activity_remember_send_tv, R.id.activity_remember_next_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.blackwb_back:
                finish();
                break;
            case R.id.activity_remember_send_tv:
                if (!TextUtils.isEmpty(activity_remember_user_et.getText().toString()) && !TextUtils.isEmpty(activity_remember_id_et.getText().toString()) && !TextUtils.isEmpty(activity_remember_phone_et.getText().toString())) {

                } else {
                    UIUtils.showToast("请补全填入信息");
                }
                break;
            case R.id.activity_remember_next_tv:
                if (!TextUtils.isEmpty(activity_remember_user_et.getText().toString()) && !TextUtils.isEmpty(activity_remember_id_et.getText().toString()) && !TextUtils.isEmpty(activity_remember_phone_et.getText().toString()) && !TextUtils.isEmpty(activity_remember_code_et.getText().toString())) {

                } else {
                    UIUtils.showToast("请补全填入信息");
                }
                break;
        }
    }
}
