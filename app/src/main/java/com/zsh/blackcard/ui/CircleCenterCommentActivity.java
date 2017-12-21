package com.zsh.blackcard.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
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

public class CircleCenterCommentActivity extends BaseActivity implements BaseQuickAdapter.OnItemChildClickListener, View.OnLayoutChangeListener {

    @BindView(R.id.circle_center_comment_recycler)
    RecyclerView circle_center_comment_recycler;
    @BindView(R.id.circle_center_comment_content_et)
    EditText circle_center_comment_content_et;
    @BindView(R.id.circle_center_comment_send_img)
    ImageView circle_center_comment_send_img;
    @BindView(R.id.root_layout)
    RelativeLayout root_layout;


    private String data;
    private CircleCenterCommentRecycerAdapter circleCenterCommentRecycerAdapter;
    private List<CircleCenterCommentRecyclerModel.PdBean> list = new ArrayList<>();
    private String reply_id = "";
    private String user_id = "";

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_circle_center_comment);
        ButterKnife.bind(this);
        root_layout.addOnLayoutChangeListener(this);
        data = getIntent().getStringExtra("data");
        initData();
    }

    private void initData() {

        UIUtils.newProgressDialog(this).show();

        DataManager.getInstance(this).RequestHttp(NetApi.postCircleCenterCommentRecycler(DataManager.getMd5Str("COMMENTLIST"), data), new ResultListener<CircleCenterCommentRecyclerModel>() {
            @Override
            public void responseSuccess(CircleCenterCommentRecyclerModel obj) {
                if (obj.getResult().equals("01")) {
                    if (!list.isEmpty()) {
                        list.clear();
                    }

                    for (int i = 0; i < obj.getPd().size(); i++) {
                        if (obj.getPd().get(i).getREPLYHONOURUSER_ID().equals("")) {
                            obj.getPd().get(i).setItemType(1);
                        } else {
                            obj.getPd().get(i).setItemType(2);
                        }
                    }

                    list.addAll(obj.getPd());

                    if (circleCenterCommentRecycerAdapter == null) {
                        circleCenterCommentRecycerAdapter = new CircleCenterCommentRecycerAdapter(list);
                        circle_center_comment_recycler.setLayoutManager(new LinearLayoutManager(CircleCenterCommentActivity.this));
                        circle_center_comment_recycler.addItemDecoration(new SpacesItemDecoration(CircleCenterCommentActivity.this, SpacesItemDecoration.VERTICAL_LIST));
                        circle_center_comment_recycler.setAdapter(circleCenterCommentRecycerAdapter);
                        circleCenterCommentRecycerAdapter.setOnItemChildClickListener(CircleCenterCommentActivity.this);
                    } else {
                        circleCenterCommentRecycerAdapter.notifyDataSetChanged();
                        circle_center_comment_recycler.scrollToPosition(0);
                    }

                }
            }

            @Override
            public void onCompleted() {
                UIUtils.dismissProgressDialog();
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
                    initComment(data, reply_id);
                } else {
                    UIUtils.showToast("不能评论空内容");
                }
                break;
        }
    }

    //评论+回复功能
    private void initComment(String data, final String reply_id) {
        DataManager.getInstance(this).RequestHttp(NetApi.postCircleCenterComment(DataManager.getMd5Str("COMMENTADD"), "388279486010884099", data, circle_center_comment_content_et.getText().toString(), reply_id), new ResultListener<ResultModel>() {
            @Override
            public void responseSuccess(ResultModel obj) {
                if (obj.getResult().equals("01")) {
                    circle_center_comment_content_et.setText("");
                    initData();
                }
            }

            @Override
            public void onCompleted() {
                CircleCenterCommentActivity.this.reply_id = "";
                hideInputSoft();
            }
        });
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (view.getId()) {
            case R.id.circle_center_comment_reply_tv:
                reply_id = ((CircleCenterCommentRecyclerModel.PdBean) adapter.getData().get(position)).getHONOURUSER_ID();
                circle_center_comment_content_et.setHint("写给"+((CircleCenterCommentRecyclerModel.PdBean) adapter.getData().get(position)).getCOMMENTNICKNAME()+"的回复");
                showInputSoft(circle_center_comment_content_et);
                break;
            case R.id.circle_center_comment_item_up_img:
                initYeah(((CircleCenterCommentRecyclerModel.PdBean) adapter.getData().get(position)).getCOMMENT_ID(), "1");
                break;
            case R.id.circle_center_comment_item_down_img:
                initYeah(((CircleCenterCommentRecyclerModel.PdBean) adapter.getData().get(position)).getCOMMENT_ID(), "-1");
                break;
        }
    }

    private void initYeah(String comment_id, String status) {

        DataManager.getInstance(this).RequestHttp(NetApi.postCircleCenterYeah(DataManager.getMd5Str("DOTAGREE"), "d6a3779de8204dfd9359403f54f7d27c", "", comment_id, status), new ResultListener<ResultModel>() {
            @Override
            public void responseSuccess(ResultModel obj) {
                if (obj.getResult().equals("01")) {
                    UIUtils.showToast("点赞成功");
                    initData();
                } else if (obj.getResult().equals("02")) {
                    UIUtils.showToast("您已经点过赞了哟~");
                }
            }

            @Override
            public void onCompleted() {
            }
        });
    }

    @Override
    public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        if (oldBottom != 0 && bottom != 0 && (oldBottom - bottom > 0)) {
            //此时键盘为弹起状态
            UIUtils.showToast("1");
        } else if (oldBottom != 0 && bottom != 0 && (bottom - oldBottom > 0)) {
            //此时键盘为关闭状态
            UIUtils.showToast("2");
            CircleCenterCommentActivity.this.reply_id = "";
            circle_center_comment_content_et.setHint("有什么想要说的么？");
        }
    }
}
