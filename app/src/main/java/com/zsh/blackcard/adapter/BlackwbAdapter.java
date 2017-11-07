package com.zsh.blackcard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.zsh.blackcard.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/10/18.
 */

public class BlackwbAdapter extends BaseAdapter {
    private Context context;

    private List<Picture> pictures = new ArrayList<Picture>();

    public BlackwbAdapter(Integer[] blackwbgv, Context context) {
        super();
        this.context = context;


        for (int i = 0; i < blackwbgv.length; i++) {
            BlackwbAdapter.Picture picture = new BlackwbAdapter.Picture(blackwbgv[i]);
            pictures.add(picture);
        }

    }

    @Override
    public int getCount() {
        if (null != pictures) {
            return pictures.size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        return pictures.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        BlackwbAdapter.ViewHolder viewHolder = null;

        if (convertView == null) {

            viewHolder = new BlackwbAdapter.ViewHolder();
            // 获得容器
            convertView = LayoutInflater.from(this.context).inflate(R.layout.blacklv_gv_item, null);

            // 初始化组件
            viewHolder.image = (ImageView) convertView.findViewById(R.id.blackwb_gv_img);

            // 给converHolder附加一个对象
            convertView.setTag(viewHolder);
        } else {
            // 取得converHolder附加的对象
            viewHolder = (BlackwbAdapter.ViewHolder) convertView.getTag();
        }

        // 给组件设置资源
        BlackwbAdapter.Picture picture = pictures.get(position);
        viewHolder.image.setImageResource(picture.getImageId());

        return convertView;
    }

    class ViewHolder {

        public ImageView image;
    }

    class Picture {

        private int imageId;

        public Picture(Integer imageId) {
            this.imageId = imageId;
        }


        public int getImageId() {
            return imageId;
        }

    }
}
