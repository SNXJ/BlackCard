package com.zsh.blackcard.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zsh.blackcard.R;
import com.zsh.blackcard.model.HomeNewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Name: HomeNewAdapter
 * Author: SNXJ
 * Date: 2017-11-14
 * Description: 首页服务Adapter：
 */
public class HomeJournalAdapter extends RecyclerView.Adapter<HomeJournalAdapter.MyViewHolder> {
    private Context context;

    private List<HomeNewModel> homeNewList = new ArrayList<>();


    public HomeJournalAdapter(Integer[] images, Context context) {
        super();
        this.context = context;
        for (int i = 0; i < images.length; i++) {
            HomeNewModel homeNewModel = new HomeNewModel();
            //  homeNewModel.setTitle(titles[i]);
            homeNewModel.setImageId(images[i]);
            homeNewList.add(homeNewModel);
        }

    }


    @Override
    public HomeJournalAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.home_journalgv_item, parent, false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(HomeJournalAdapter.MyViewHolder holder, int position) {
        holder.img.setImageResource(homeNewList.get(position).getImageId());
    }

    @Override
    public int getItemCount() {
        return homeNewList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img;

        public MyViewHolder(View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.journal_img);

        }
    }

}
