package com.zsh.blackcard.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zsh.blackcard.R;
import com.zsh.blackcard.model.HomeNewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Name: HomeNewAdapter
 * Author: SNXJ
 * Date: 2017-11-14
 * Description: 首页头条Adapter：
 */
public class HomeNewAdapter extends RecyclerView.Adapter<HomeNewAdapter.MyViewHolder> {
    private Context context;

    private List<HomeNewModel> homeNewList = new ArrayList<>();


    public HomeNewAdapter(String[] titles, Integer[] images, Context context) {
        super();
        this.context = context;
        for (int i = 0; i < images.length; i++) {
            HomeNewModel homeNewModel = new HomeNewModel();
            homeNewModel.setTitle(titles[i]);
            homeNewModel.setImageId(images[i]);
            homeNewList.add(homeNewModel);
        }

    }


    @Override
    public HomeNewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.home_headgv_item, parent, false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(HomeNewAdapter.MyViewHolder holder, int position) {
        holder.tv.setText(homeNewList.get(position).getTitle());
        holder.img.setImageResource(homeNewList.get(position).getImageId());
    }

    @Override
    public int getItemCount() {
        return homeNewList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        ImageView img;

        public MyViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.headnews_tv);
            img = (ImageView) view.findViewById(R.id.headnews_img);

        }
    }

}
