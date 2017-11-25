package com.zsh.blackcard.ui.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.CommentListAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.CommentModel;
import com.zsh.blackcard.untils.ActivityUtils;
import com.zsh.blackcard.view.Star;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Name: CommentActivity
 * Author: SNXJ
 * Date: 2017-11-15
 * Description:评论列表：
 */
public class CommentActivity extends BaseActivity {

    @BindView(R.id.im_back)
    ImageView imBack;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.tv_go_comment)
    TextView tvGoComment;
    @BindView(R.id.tv_score)
    TextView tvScore;
    @BindView(R.id.star)
    Star star;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private String id;
    private String score;
    private int type;//0酒店 1美食 2
    private CommentListAdapter adapter;
    private List<CommentModel.PdBean> dataList = new ArrayList<>();

    @Override
    protected void initUI() {
        setContentView(R.layout.comment_activity);
        id = getIntent().getStringExtra("data");
        // id = "53443f6feed94a1bbce17a65e63dae28";
        score = getIntent().getStringExtra("title");
        type = getIntent().getIntExtra("type", 0);
        ButterKnife.bind(this);
        star.setMark(Float.parseFloat(score));
        tvScore.setText(score);

    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    private void initData() {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postCommentList(id, type), new ResultListener<CommentModel>() {
            @Override
            public void responseSuccess(CommentModel obj) {
                dataList = obj.getPd();
                setRVData(dataList);
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void setRVData(final List<CommentModel.PdBean> dataList) {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        adapter = new CommentListAdapter(this, dataList);
        recyclerView.setAdapter(adapter);
    }

    @OnClick({R.id.im_back, R.id.tv_go_comment})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.im_back:
                finish();
                break;
            case R.id.tv_go_comment:
                ActivityUtils.startActivityForData(CommentActivity.this, CommentEditActivity.class, id, "", type);
                break;
        }
    }
}
