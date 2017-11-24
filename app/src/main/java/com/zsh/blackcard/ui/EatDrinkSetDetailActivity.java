package com.zsh.blackcard.ui;

import android.content.Intent;
import android.widget.EditText;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kkkkk on 2017/11/23.
 * 发布页面填写详细要求，上传图片界面。
 */

public class EatDrinkSetDetailActivity extends BaseActivity{

    @BindView(R.id.eat_drink_set_detail_title_et)
    EditText eat_drink_set_detail_title_et;
    @BindView(R.id.eat_drink_set_detail_content_et)
    EditText eat_drink_set_detail_content_et;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_eat_drink_set_detail);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.blackwb_back)
    public void onClick(){
        Intent intent = new Intent();
        intent.putExtra("title",eat_drink_set_detail_title_et.getText().toString());
        intent.putExtra("content",eat_drink_set_detail_content_et.getText().toString());
        setResult(0,intent);
        finish();
    }
}
