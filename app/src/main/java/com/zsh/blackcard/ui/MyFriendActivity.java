package com.zsh.blackcard.ui;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.MyFriendAdapter;
import com.zsh.blackcard.view.SpacesItemDecoration;

/**
 * Created by kkkkk on 2017/11/10.
 */

public class MyFriendActivity extends BaseActivity {

    private RecyclerView my_friend_recycler;
    private MyFriendAdapter myFriendAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_my_friend);
        mfFindId();
        initDate();
    }

    private void initDate() {
        myFriendAdapter = new MyFriendAdapter(this);
        layoutManager = new LinearLayoutManager(this);
        my_friend_recycler.setLayoutManager(layoutManager);
        my_friend_recycler.setAdapter(myFriendAdapter);
        my_friend_recycler.addItemDecoration(new SpacesItemDecoration(this,SpacesItemDecoration.VERTICAL_LIST));
    }

    private void mfFindId() {
        my_friend_recycler = (RecyclerView) findViewById(R.id.my_friend_recycler);
    }
}
