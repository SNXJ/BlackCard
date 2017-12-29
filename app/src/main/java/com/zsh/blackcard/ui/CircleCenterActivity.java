package com.zsh.blackcard.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.CircleCenterRecyclerAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.MyCircleModel;
import com.zsh.blackcard.model.ResultModel;
import com.zsh.blackcard.utils.ActivityUtils;
import com.zsh.blackcard.utils.UIUtils;
import com.zsh.blackcard.view.SpacesItemDecoration;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kkkkk on 2017/11/13.
 * 圈子中心页面
 */

public class CircleCenterActivity extends BaseActivity implements BaseQuickAdapter.OnItemChildClickListener {

    @BindView(R.id.circle_center_recycler)
    RecyclerView circle_center_recycler;

    private CircleCenterRecyclerAdapter circleCenterRecyclerAdapter;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_circle_center);
        ButterKnife.bind(this);
        iniData();
    }

    private void iniData() {

        showLoading(this);

        DataManager.getInstance(this).RequestHttp(NetApi.postCircleCenterRecycle(DataManager.getMd5Str("CIRCLELIST"), "d6a3779de8204dfd9359403f54f7d27c"), new ResultListener<MyCircleModel>() {
            @Override
            public void responseSuccess(MyCircleModel obj) {
                if (obj.getResult().equals("01")) {
                    for (int i = 0; i < obj.getPd().size(); i++) {
                        if (obj.getPd().get(i).getSHOWIMAGES().equals("")) {
                            obj.getPd().get(i).setItemType(2);
                        } else {
                            obj.getPd().get(i).setItemType(1);
                        }
                    }
                    circleCenterRecyclerAdapter = new CircleCenterRecyclerAdapter(obj.getPd());
                    circle_center_recycler.setLayoutManager(new LinearLayoutManager(CircleCenterActivity.this));
                    circle_center_recycler.addItemDecoration(new SpacesItemDecoration(CircleCenterActivity.this, SpacesItemDecoration.VERTICAL_LIST));
                    circle_center_recycler.setAdapter(circleCenterRecyclerAdapter);
                    circleCenterRecyclerAdapter.setOnItemChildClickListener(CircleCenterActivity.this);
                }
            }

            @Override
            public void onCompleted() {
                dialogDismiss();
            }
        });

    }

    @OnClick(R.id.blackwb_back)
    public void onClick() {
        finish();
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (view.getId()) {
            case R.id.circle_center_item_yeah_img:
                initYeah(((MyCircleModel.PdBean) adapter.getData().get(position)).getCIRCLE_ID());
                break;
            case R.id.circle_center_item_comment_img:
                ActivityUtils.startActivityForData(CircleCenterActivity.this, CircleCenterCommentActivity.class, ((MyCircleModel.PdBean) adapter.getData().get(position)).getCIRCLE_ID());
                break;
        }
    }

    private void initYeah(String circle_id) {

        DataManager.getInstance(this).RequestHttp(NetApi.postCircleCenterYeah(DataManager.getMd5Str("DOTAGREE"), "d6a3779de8204dfd9359403f54f7d27c", circle_id, "", "1"), new ResultListener<ResultModel>() {
            @Override
            public void responseSuccess(ResultModel obj) {
                if (obj.getResult().equals("01")) {
                    UIUtils.showToast("点赞成功");
                } else if (obj.getResult().equals("02")) {
                    UIUtils.showToast("您已经点过赞了哟~");
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }
}
