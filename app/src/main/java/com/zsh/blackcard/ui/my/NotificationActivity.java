package com.zsh.blackcard.ui.my;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class NotificationActivity extends BaseActivity {

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.blackwb_back)
    public void onClick(){
        finish();
    }
}
