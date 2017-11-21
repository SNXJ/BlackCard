package com.zsh.blackcard.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zsh.blackcard.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kkkkk on 2017/11/21.
 * title头部适配器
 */

public class HomeTypeAdapter extends RecyclerView.Adapter<HomeTypeAdapter.MyViewHolder> {

    private Context context;

    public HomeTypeAdapter(Context context){
        this.context = context;
    }

    private HomeTypeOnItemClick homeTypeOnItemClick;

    public void setHomeTypeOnItemClick(HomeTypeOnItemClick homeTypeOnItemClick) {
        this.homeTypeOnItemClick = homeTypeOnItemClick;
    }

    public interface HomeTypeOnItemClick{
        void homeTypeOnItemClick(int position);
    }


    @Override
    public HomeTypeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.home_type_recycler_item,parent,false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(HomeTypeAdapter.MyViewHolder holder, final int position) {

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(homeTypeOnItemClick != null){
                    homeTypeOnItemClick.homeTypeOnItemClick(position);
                }
            }
        });

        switch (position){
            case 0:
                holder.home_type_recycler_img.setImageResource(R.mipmap.home_food);
                holder.home_type_recycler_tv.setText("美食");
                break;
            case 1:
                holder.home_type_recycler_img.setImageResource(R.mipmap.home_hotel);
                holder.home_type_recycler_tv.setText("酒店");
                break;
            case 2:
                holder.home_type_recycler_img.setImageResource(R.mipmap.home_train);
                holder.home_type_recycler_tv.setText("火车票");
                break;
            case 3:
                holder.home_type_recycler_img.setImageResource(R.mipmap.home_plane);
                holder.home_type_recycler_tv.setText("机票");
                break;
            case 4:
                holder.home_type_recycler_img.setImageResource(R.mipmap.home_horse);
                holder.home_type_recycler_tv.setText("马术");
                break;
            case 5:
                holder.home_type_recycler_img.setImageResource(R.mipmap.home_ship);
                holder.home_type_recycler_tv.setText("游艇");
                break;
            case 6:
                holder.home_type_recycler_img.setImageResource(R.mipmap.home_car);
                holder.home_type_recycler_tv.setText("豪车");
                break;
            case 7:
                holder.home_type_recycler_img.setImageResource(R.mipmap.home_more);
                holder.home_type_recycler_tv.setText("更多");
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.home_type_recycler_img)
        ImageView home_type_recycler_img;
        @BindView(R.id.home_type_recycler_tv)
        TextView home_type_recycler_tv;

        private View view;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            view = itemView;
        }
    }
}
