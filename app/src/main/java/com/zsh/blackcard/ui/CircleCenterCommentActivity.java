package com.zsh.blackcard.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.CircleCenterCommentRecycerAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.CircleCenterCommentRecyclerModel;
import com.zsh.blackcard.model.ResultModel;
import com.zsh.blackcard.untils.UIUtils;
import com.zsh.blackcard.view.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CircleCenterCommentActivity extends BaseActivity {

    @BindView(R.id.circle_center_comment_recycler)
    RecyclerView circle_center_comment_recycler;
    @BindView(R.id.circle_center_comment_content_et)
    EditText circle_center_comment_content_et;
    @BindView(R.id.circle_center_comment_send_img)
    ImageView circle_center_comment_send_img;

    private String data;
    private CircleCenterCommentRecycerAdapter circleCenterCommentRecycerAdapter;
    private List<CircleCenterCommentRecyclerModel.PdBean> list = new ArrayList<>();

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_circle_center_comment);
        ButterKnife.bind(this);
        data = getIntent().getStringExtra("data");
        initData();
    }

    private void initData() {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postCircleCenterCommentRecycler(DataManager.getMd5Str("COMMENTLIST"), data), new ResultListener<CircleCenterCommentRecyclerModel>() {
            @Override
            public void responseSuccess(CircleCenterCommentRecyclerModel obj) {
                if (obj.getResult().equals("01")) {
                    for (int i = 0; i < obj.getPd().size(); i++) {
                        if (obj.getPd().get(i).getREPLYHONOURUSER_ID().equals("")) {
                            obj.getPd().get(i).setItemType(1);
                        } else {
                            obj.getPd().get(i).setItemType(2);
                        }
                    }

                    if (!list.isEmpty()) {
                        list.clear();
                    }
                    list.addAll(obj.getPd());

                    if (circleCenterCommentRecycerAdapter == null) {
                        circleCenterCommentRecycerAdapter = new CircleCenterCommentRecycerAdapter(list);
                        circle_center_comment_recycler.setLayoutManager(new LinearLayoutManager(CircleCenterCommentActivity.this));
                        circle_center_comment_recycler.addItemDecoration(new SpacesItemDecoration(CircleCenterCommentActivity.this, SpacesItemDecoration.VERTICAL_LIST));
                        circle_center_comment_recycler.setAdapter(circleCenterCommentRecycerAdapter);
                    } else {
                        circleCenterCommentRecycerAdapter.notifyDataSetChanged();
                        circle_center_comment_recycler.scrollToPosition(list.size()-1);
                    }

                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    @OnClick({R.id.blackwb_back, R.id.circle_center_comment_send_img})
    public void onClick(View view) {
        switch (view.getId()) {
            //退出页面
            case R.id.blackwb_back:
                finish();
                break;
            //发送评论
            case R.id.circle_center_comment_send_img:
                if (!TextUtils.isEmpty(circle_center_comment_content_et.getText().toString().trim())) {
                    initComment(data);
                } else {
                    UIUtils.showToast("不能评论空内容");
                }
                break;
        }
    }

    private void initComment(String data) {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postCircleCenterComment(DataManager.getMd5Str("COMMENTADD"), "d6a3779de8204dfd9359403f54f7d27c", data, circle_center_comment_content_et.getText().toString(), ""), new ResultListener<ResultModel>() {
            @Override
            public void responseSuccess(ResultModel obj) {
                if (obj.getResult().equals("01")) {
                    initData();
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }
}
