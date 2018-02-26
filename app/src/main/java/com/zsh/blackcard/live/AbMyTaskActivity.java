package com.zsh.blackcard.live;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.BaseApplication;
import com.zsh.blackcard.R;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.AbTaskModel;
import com.zsh.blackcard.model.ResultModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Name: AbMyTaskActivity
 * Author: SNXJ
 * Date: 2017-11-13
 * Description: 任务中心
 */
public class AbMyTaskActivity extends BaseActivity {
    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.tv_task_port)
    TextView tvTaskPort;
    @BindView(R.id.tv_task_browse)
    TextView tvTaskBrowse;
    @BindView(R.id.tv_task_attention)
    TextView tvTaskAttention;
    @BindView(R.id.tv_task_gift)
    TextView tvTaskGift;
    @BindView(R.id.tv_task_all)
    TextView tvTaskAll;

    @Override
    protected void initUI() {
        setContentView(R.layout.sb_my_task_activity);
        ButterKnife.bind(this);
        initData();

    }

    private void initData() {
        DataManager.getInstance(this).RequestHttp(NetApi.getAbTaskStatus(DataManager.getMd5Str("TASK"), BaseApplication.getHonouruserId()), new ResultListener<AbTaskModel>() {
            @Override
            public void responseSuccess(AbTaskModel obj) {
                if (null != obj && "01".equals(obj.getResult())) {
                    if (0 == obj.getPd().getTASK_PORT()) {
                        tvTaskPort.setText("已完成");
                    } else {
                        tvTaskPort.setText("未完成");
                    }
                    if (0 == obj.getPd().getTASK_BROWSE()) {
                        tvTaskBrowse.setText("已完成");
                    } else {
                        tvTaskBrowse.setText("未完成");
                    }
                    if (0 == obj.getPd().getTASK_ATTENTION()) {
                        tvTaskAttention.setText("已完成");
                    } else {
                        tvTaskAttention.setText("未完成");
                    }
                    if (0 == obj.getPd().getTASK_GIFT()) {
                        tvTaskGift.setText("已完成");
                    } else {
                        tvTaskGift.setText("未完成");
                    }
                    if (0 == obj.getPd().getTASK_ALL()) {
                        tvTaskAll.setText("已完成");
                    } else {
                        tvTaskAll.setText("未完成");
                    }


                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }


    @OnClick(R.id.title_back)
    public void onViewClicked() {
        finish();

    }


}
