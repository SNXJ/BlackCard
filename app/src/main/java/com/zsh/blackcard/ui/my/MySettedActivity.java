package com.zsh.blackcard.ui.my;

import android.view.View;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 入驻商家页面
 */
public class MySettedActivity extends BaseActivity {

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_my_setted);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.blackwb_back, R.id.one, R.id.two, R.id.three, R.id.four, R.id.five, R.id.six, R.id.seven, R.id.eight, R.id.nine, R.id.ten, R.id.elven, R.id.twelve})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //美食商家入驻
            case R.id.one:
                break;
            //酒店商家入驻
            case R.id.two:
                break;
            //马术商家入驻
            case R.id.three:
                break;
            //游艇商家入驻
            case R.id.four:
                break;
            //豪车商家入驻
            case R.id.five:
                break;
            //高尔夫商家入驻
            case R.id.six:
                break;
            //飞机商家入驻
            case R.id.seven:
                break;
            //高端品鉴商家入驻
            case R.id.eight:
                break;
            //娱乐商家入驻
            case R.id.nine:
                break;
            //金融机构入驻
            case R.id.ten:
                break;
            //自媒体入驻
            case R.id.elven:
                break;
            //美食商家入驻
            case R.id.twelve:
                break;
            //后退按钮
            case R.id.blackwb_back:
                finish();
                break;
        }
    }
}
