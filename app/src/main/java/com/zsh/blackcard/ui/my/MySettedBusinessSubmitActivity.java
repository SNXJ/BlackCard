package com.zsh.blackcard.ui.my;

import android.view.View;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.utils.ActivityUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MySettedBusinessSubmitActivity extends BaseActivity {

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_my_setted_business_submit);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.relative_one, R.id.relative_four, R.id.relative_five})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.relative_one:
                ActivityUtils.startActivity(this, MySettedBusinessPhotoActivity.class);
                break;
            case R.id.relative_four:
                break;
            case R.id.relative_five:
                break;
        }
    }
}
