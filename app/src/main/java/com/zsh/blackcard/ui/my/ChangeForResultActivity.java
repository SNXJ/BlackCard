package com.zsh.blackcard.ui.my;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.untils.UIUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangeForResultActivity extends BaseActivity {

    @BindView(R.id.change_for_result_title_tv)
    TextView change_for_result_title_tv;
    @BindView(R.id.change_for_result_et)
    EditText change_for_result_et;
    @BindView(R.id.change_for_result_save_tv)
    TextView change_for_result_save_tv;
    private String title = null;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_change_for_result);
        ButterKnife.bind(this);
        title = getIntent().getStringExtra("data");
        change_for_result_title_tv.setText(title);
    }

    @OnClick({R.id.back_img, R.id.change_for_result_save_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_img:
                finish();
                break;
            case R.id.change_for_result_save_tv:
                if (!TextUtils.isEmpty(change_for_result_et.getText().toString().trim())) {
                    switch (title) {
                        case "昵称":
                            setMyResult(1, change_for_result_et.getText().toString().trim());
                            break;
                        case "个性签名":
                            setMyResult(2, change_for_result_et.getText().toString().trim());
                            break;
                        case "QQ号码":
                            setMyResult(3, change_for_result_et.getText().toString().trim());
                            break;
                        case "微信":
                            setMyResult(4, change_for_result_et.getText().toString().trim());
                            break;
                        case "新浪微博":
                            setMyResult(5, change_for_result_et.getText().toString().trim());
                            break;
                    }
                } else {
                    UIUtils.showToast("不能保存空数据");
                }
                break;
        }
    }

    private void setMyResult(int resultCode, String data) {
        Intent intent = new Intent();
        intent.putExtra("data", data);
        setResult(resultCode, intent);
        finish();
    }
}
