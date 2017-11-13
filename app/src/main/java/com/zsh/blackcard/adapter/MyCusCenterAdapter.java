package com.zsh.blackcard.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zsh.blackcard.R;
import com.zsh.blackcard.ui.CusCenterActivity;
import com.zsh.blackcard.ui.CusCenterChatActivity;
import com.zsh.blackcard.ui.HouseCenterActivity;
import com.zsh.blackcard.ui.MyFriendActivity;
import com.zsh.blackcard.untils.ActivityUtils;

/**
 * Created by kkkkk on 2017/11/10.
 */

public class MyCusCenterAdapter extends RecyclerView.Adapter<MyCusCenterAdapter.MyViewHolder>{

    private Context context;

    public MyCusCenterAdapter(CusCenterActivity cusCenterActivity) {
        this.context = cusCenterActivity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.my_cus_center_recycler_item,parent,false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.my_cus_center_chat_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.startActivity((CusCenterActivity)context, CusCenterChatActivity.class);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView my_cus_center_chat_img;

        public MyViewHolder(View itemView) {
            super(itemView);
            my_cus_center_chat_img = (ImageView) itemView.findViewById(R.id.my_cus_center_chat_img);
        }
    }
}
