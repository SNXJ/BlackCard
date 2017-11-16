package com.zsh.blackcard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zsh.blackcard.R;
import com.zsh.blackcard.model.HomeNewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Name: HomeMoreAdapter
 * Author: SNXJ
 * Date: 2017-11-15
 * Description:描述：
 */
public class HomeMoreAdapter extends BaseAdapter {
    List<HomeNewModel> list = new ArrayList<>();
    private Context context;

    public HomeMoreAdapter(Context context, List<HomeNewModel> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HomeMoreAdapter.ViewHolder viewHolder = null;

        if (convertView == null) {
            viewHolder = new HomeMoreAdapter.ViewHolder();
            // 获得容器
            convertView = LayoutInflater.from(this.context).inflate(R.layout.home_more_item, null);

            // 初始化组件
            viewHolder.image = (ImageView) convertView.findViewById(R.id.item_img);
            viewHolder.tv = (TextView) convertView.findViewById(R.id.item_tv);

            // 给converHolder附加一个对象
            convertView.setTag(viewHolder);
        } else {
            // 取得converHolder附加的对象
            viewHolder = (HomeMoreAdapter.ViewHolder) convertView.getTag();
        }
        viewHolder.image.setImageResource(list.get(position).getImageId());
        viewHolder.tv.setText(list.get(position).getTitle());
        return convertView;
    }

    class ViewHolder {

        public ImageView image;
        public TextView tv;
    }
}
