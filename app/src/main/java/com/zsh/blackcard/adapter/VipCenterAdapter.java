package com.zsh.blackcard.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zsh.blackcard.R;
import com.zsh.blackcard.ui.VipCenterActivity;

/**
 * Created by kkkkk on 2017/11/10.
 */

public class VipCenterAdapter extends RecyclerView.Adapter {

    private Context context;

    public VipCenterAdapter(VipCenterActivity vipCenterActivity) {
        this.context = vipCenterActivity;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return 0;
            case 4:
                return 4;
        }
        return 10;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new OneViewHolder(LayoutInflater.from(context).inflate(R.layout.vip_center_recycler_first_item, parent, false));
        } else if (viewType == 4) {
            return new FiveViewHolder(LayoutInflater.from(context).inflate(R.layout.vip_center_recycler_last_item, parent, false));
        } else {
            return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.vip_center_recycler_item, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

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

    private class OneViewHolder extends MyViewHolder {

        public OneViewHolder(View itemView) {
            super(itemView);
        }
    }

    private class FiveViewHolder extends MyViewHolder {
        public FiveViewHolder(View inflate) {
            super(inflate);
        }
    }
}
