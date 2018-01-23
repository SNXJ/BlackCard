package com.zsh.blackcard.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.MyFriendAdapter;
import com.zsh.blackcard.view.SpacesItemDecoration;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kkkkk on 2017/11/10.
 */

public class MyFriendActivity extends BaseActivity {

    private MyFriendAdapter myFriendAdapter;

    @BindView(R.id.my_friend_recycler)
    RecyclerView my_friend_recycler;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_my_friend);
        ButterKnife.bind(this);
        initDate();
    }

    private void initDate() {
        myFriendAdapter = new MyFriendAdapter(this);
        my_friend_recycler.setLayoutManager(new LinearLayoutManager(this));
        my_friend_recycler.setAdapter(myFriendAdapter);
        my_friend_recycler.addItemDecoration(new SpacesItemDecoration(this, SpacesItemDecoration.VERTICAL_LIST));
    }

    @OnClick(R.id.blackwb_back)
    public void onClick() {
        finish();
    }
}