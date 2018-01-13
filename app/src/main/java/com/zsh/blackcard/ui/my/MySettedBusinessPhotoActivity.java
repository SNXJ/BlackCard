package com.zsh.blackcard.ui.my;

import android.os.Bundle;
import android.view.View;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 上传图片页面
 */
public class MySettedBusinessPhotoActivity extends BaseActivity {

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_my_setted_business_photo);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.blackwb_back, R.id.id_positive, R.id.id_opposite})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.blackwb_back:
                finish();
                break;
            case R.id.id_positive:
                break;
            case R.id.id_opposite:
                break;
        }
    }
}
