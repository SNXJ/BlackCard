package com.zsh.blackcard.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.ResultModel;
import com.zsh.blackcard.untils.UIUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

/**
 * Created by kkkkk on 2017/12/18.
 * 给订单添加评论
 */

public class MyOrderCenterEditActivity extends BaseActivity {

    @BindView(R.id.et_comment)
    EditText et_comment;

    private String ISSHOW = "0";
    private String data = "";

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_my_order_center_edit);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        data = getIntent().getStringExtra("data");
    }

    @OnCheckedChanged(R.id.cb_show)
    public void onCheckChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            ISSHOW = "1";
            UIUtils.showToast("1");
        } else {
            UIUtils.showToast("0");
            ISSHOW = "0";
        }
    }

    @OnClick({R.id.im_back, R.id.tv_submmit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.im_back:
                finish();
                break;
            case R.id.tv_submmit:
                initComment();
                break;
        }
    }

    private void initComment() {
        if (!TextUtils.isEmpty(et_comment.getText().toString().trim())) {
            DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postOrderCenterComment(DataManager.getMd5Str("SPRODUCTADDEVA"), data, "d6a3779de8204dfd9359403f54f7d27c", et_comment.getText().toString(), "", ISSHOW), new ResultListener<ResultModel>() {
                @Override
                public void responseSuccess(ResultModel obj) {
                    if (obj.getResult().equals("01")) {
                        UIUtils.showToast("评论成功");
                        setResult(0);
                        finish();
                    }
                }

                @Override
                public void onCompleted() {

                }
            });
        } else {
            UIUtils.showToast("请输入评论内容");
        }
    }
}
