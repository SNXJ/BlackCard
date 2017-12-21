package com.zsh.blackcard.live;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.LiveListAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.LiveInfoListModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Name: LiveAnchorListActivity
 * Author: SNXJ
 * Date: 2017-12-04
 * Description:描述：
 */
public class LiveAnchorListActivity extends BaseActivity {
    @BindView(R.id.rv_live)
    RecyclerView rvLive;
    List<LiveInfoListModel> list = new ArrayList<>();

    @Override
    protected void initUI() {
        setContentView(R.layout.live_anchor_list);
        ButterKnife.bind(this);
        init();
    }


    protected void init() {
        DataManager.getInstance(this).RequestHttp(NetApi.pullLive(""), new ResultListener<LiveInfoListModel>() {
            @Override
            public void responseSuccess(final LiveInfoListModel obj) {
                List<LiveInfoListModel.DataBean.RoomListBean> list = obj.getData().getRoom_list();

                LiveListAdapter adapter = new LiveListAdapter(LiveAnchorListActivity.this, list);
                rvLive.setLayoutManager(new LinearLayoutManager(LiveAnchorListActivity.this));
                rvLive.setAdapter(adapter);
                adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        SingleAnchorPlayActivity.actionStart(LiveAnchorListActivity.this, obj.getData().getRoom_list().get(position));
                    }
                });
            }

            @Override
            public void onCompleted() {

            }
        });


    }
}
