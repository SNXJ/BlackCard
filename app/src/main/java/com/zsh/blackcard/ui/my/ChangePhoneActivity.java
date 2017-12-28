package com.zsh.blackcard.ui.my;

import android.view.View;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangePhoneActivity extends BaseActivity {

    @BindView(R.id.activity_change_phone_tv)
    TextView activity_change_phone_tv;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_change_phone);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        String data = getIntent().getStringExtra("data");
        activity_change_phone_tv.setText(data);
    }

    @OnClick({R.id.blackwb_back, R.id.activity_change_next_tv,R.id.activity_remember_send_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.blackwb_back:
                finish();
                break;
            case R.id.activity_change_next_tv:
                break;
            case R.id.activity_remember_send_tv:

                break;
        }
    }
}
