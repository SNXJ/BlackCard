package com.zsh.blackcard.ui.live;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Name: LiveOpenActivity
 * Author: SNXJ
 * Date: 2017-11-17
 * Description: 开启直播
 */
public class LiveOpenActivity extends BaseActivity {
    @BindView(R.id.im_close)
    ImageView imClose;
    @BindView(R.id.im_location)
    ImageView imLocation;
    @BindView(R.id.im_refresh)
    ImageView imRefresh;
    @BindView(R.id.et_edit_title)
    EditText etEditTitle;
    @BindView(R.id.btn_open)
    Button btnOpen;
    @BindView(R.id.tv_xieyi)
    TextView tvXieyi;

    @Override
    protected void initUI() {
        setContentView(R.layout.live_open_activity);
    }


    @OnClick({R.id.im_close, R.id.im_location, R.id.im_refresh, R.id.btn_open, R.id.tv_xieyi})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.im_close:
                finish();
                break;
            case R.id.im_location:
                break;
            case R.id.im_refresh:
                break;
            case R.id.btn_open:
                startActivity(new Intent(LiveOpenActivity.this, LiveRoomActivity.class));
                break;
            case R.id.tv_xieyi:
                break;
        }
    }
}
