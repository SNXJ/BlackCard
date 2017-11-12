package com.zsh.blackcard.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zsh.blackcard.R;
import com.zsh.blackcard.ui.HuoDongActivity;
import com.zsh.blackcard.ui.VipCenterActivity;

/**
 * Created by kkkkk on 2017/11/10.
 */

public class MyHuoDongAdapter extends RecyclerView.Adapter<MyHuoDongAdapter.MyViewHolder> {

    private Context context;

    public MyHuoDongAdapter(HuoDongActivity huoDongActivity) {
        this.context = huoDongActivity;
    }

    @Override
    public MyHuoDongAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.my_huodong_recycler_item,parent,false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyHuoDongAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
