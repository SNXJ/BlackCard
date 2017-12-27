package com.zsh.blackcard.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.MyFriendAdapter;
import com.zsh.blackcard.view.SpacesItemDecoration;

/**
 * Created by kkkkk on 2017/11/10.
 */

public class MyFriendActivity extends BaseActivity implements View.OnClickListener {

    private RecyclerView my_friend_recycler;
    private MyFriendAdapter myFriendAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ImageView back_img;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_my_friend);
        mfFindId();
        initOnClick();
        initDate();
    }

    private void initOnClick() {
        back_img.setOnClickListener(this);
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
        back_img = (ImageView) findViewById(R.id.blackwb_back);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
