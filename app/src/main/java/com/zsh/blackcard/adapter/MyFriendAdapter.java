package com.zsh.blackcard.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zsh.blackcard.R;
import com.zsh.blackcard.ui.MyFriendActivity;

/**
 * Created by kkkkk on 2017/11/10.
 */

public class MyFriendAdapter extends RecyclerView.Adapter<MyFriendAdapter.MyViewHolder>{

    private Context context;

    public MyFriendAdapter(MyFriendActivity myFriendActivity) {
        this.context = myFriendActivity;
    }

    @Override
    public MyFriendAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.my_friend_recycler_item,parent,false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyFriendAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 15;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
