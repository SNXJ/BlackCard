package com.zsh.blackcard.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zsh.blackcard.R;
import com.zsh.blackcard.ui.CusCenterChatActivity;
import com.zsh.blackcard.ui.MyFriendActivity;
import com.zsh.blackcard.utils.ActivityUtils;

/**
 * Created by kkkkk on 2017/11/10.
 */

public class MyFriendAdapter extends RecyclerView.Adapter<MyFriendAdapter.MyViewHolder>{

    private Context context;

    public MyFriendAdapter(MyFriendActivity myFriendActivity) {
        this.context = myFriendActivity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.my_friend_recycler_item,parent,false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.startActivity((MyFriendActivity)context, CusCenterChatActivity.class);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private View view;

        public MyViewHolder(View itemView) {
            super(itemView);
            view = itemView;
        }
    }
}
