package com.zsh.blackcard.live;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.BaseApplication;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.AbMyFriendListAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.AbMyFriendModel;
import com.zsh.blackcard.model.ResultModel;
import com.zsh.blackcard.utils.UIUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Name: AbMyFriendActivity
 * Author: SNXJ
 * Date: 2017-11-13
 * Description:  尚播—我的—关注/粉丝
 */
public class AbMyFriendActivity extends BaseActivity {
    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    private AbMyFriendListAdapter adapter;

    private List<AbMyFriendModel.PdBean> dataList;
    private String type;

    @Override
    protected void initUI() {
        setContentView(R.layout.sb_my_follow_activity);
        ButterKnife.bind(this);
        type = getIntent().getStringExtra("data");
        switch (type) {
            case "0":
                initFriendData();
                break;
            case "1":
                initFollowData();
                break;
        }
    }

    private void initFriendData() {
        titleTv.setText("我的关注");
        DataManager.getInstance(this).RequestHttp(NetApi.myFriendList(DataManager.getMd5Str("FLIST"), BaseApplication.getHonouruserId()), new ResultListener<AbMyFriendModel>() {
            @Override
            public void responseSuccess(AbMyFriendModel obj) {
                dataList = obj.getPd();
                adapter = new AbMyFriendListAdapter(dataList);
                recyclerview.setLayoutManager(new LinearLayoutManager(AbMyFriendActivity.this));
                recyclerview.setAdapter(adapter);
                adapter.setEmptyView(R.layout.home_hotel_empty_layout, recyclerview);
                adapter.setOnItemChildClickListener(onItemChildlistener);

            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void initFollowData() {
        titleTv.setText("关注我的");
        DataManager.getInstance(this).RequestHttp(NetApi.myFollowList(DataManager.getMd5Str("REFLIST"), BaseApplication.getHonouruserId()), new ResultListener<AbMyFriendModel>() {
            @Override
            public void responseSuccess(AbMyFriendModel obj) {
                dataList = obj.getPd();
                adapter = new AbMyFriendListAdapter(dataList);
                recyclerview.setLayoutManager(new LinearLayoutManager(AbMyFriendActivity.this));
                recyclerview.setAdapter(adapter);
                adapter.setEmptyView(R.layout.home_hotel_empty_layout, recyclerview);
                //  adapter.setOnItemChildClickListener(onItemChildlistener);
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    BaseQuickAdapter.OnItemChildClickListener onItemChildlistener = new BaseQuickAdapter.OnItemChildClickListener() {
        @Override
        public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
            switch (view.getId()) {
                case R.id.tv_item_delete:
                    removeItem(position);
                    break;
            }
        }
    };

    private void removeItem(final int position) {
        DataManager.getInstance(this).RequestHttp(NetApi.delFriend(DataManager.getMd5Str("FRIENDDEL"), BaseApplication.getHonouruserId(), dataList.get(position).getHONOURUSER_ID()), new ResultListener<ResultModel>() {
            @Override
            public void responseSuccess(ResultModel obj) {
                if ("01".equals(obj.getResult())) {
                    dataList.remove(position);
                    UIUtils.showToast("删除成功");
                    adapter.notifyItemRemoved(position);
                    adapter.notifyItemRangeChanged(position, dataList.size());
                } else {
                    UIUtils.showToast("删除失败");
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    @OnClick(R.id.title_back)
    public void onClick() {
        finish();
    }
}
