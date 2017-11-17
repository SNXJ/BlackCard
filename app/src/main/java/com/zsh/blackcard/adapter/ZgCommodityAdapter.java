package com.zsh.blackcard.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zsh.blackcard.R;
import com.zsh.blackcard.ui.CommodityActivity;

import butterknife.ButterKnife;

/**
 * Created by kkkkk on 2017/11/17.
 * 尊购所有专区的适配器
 */

public class ZgCommodityAdapter extends RecyclerView.Adapter<ZgCommodityAdapter.MyViewHolder> {

    private Context context;

    public ZgCommodityAdapter(CommodityActivity commodityActivity) {
        this.context = commodityActivity;
    }

    private ZgCommodityOnItemClick zgCommodityOnItemClick;

    public void setZgCommodityOnItemClick(ZgCommodityOnItemClick zgCommodityOnItemClick) {
        this.zgCommodityOnItemClick = zgCommodityOnItemClick;
    }

    public interface ZgCommodityOnItemClick{
        void commodityOnItemClick(int position);
    }

    @Override
    public ZgCommodityAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.zg_commodity_recycler_item,parent,false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(ZgCommodityAdapter.MyViewHolder holder, final int position) {
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zgCommodityOnItemClick != null){
                    zgCommodityOnItemClick.commodityOnItemClick(position);
                }
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
            ButterKnife.bind(this,itemView);
            view = itemView;
        }
    }
}
