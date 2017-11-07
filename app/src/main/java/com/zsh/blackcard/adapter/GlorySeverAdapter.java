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

public class GlorySeverAdapter extends BaseAdapter {
    private Context context;

    private List<Picture> pictures = new ArrayList<Picture>();

    public GlorySeverAdapter(Integer[] images1, Context context) {
        super();
        this.context = context;


        for (int i = 0; i < images1.length; i++) {
            GlorySeverAdapter.Picture picture = new GlorySeverAdapter.Picture(images1[i]);
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

        GlorySeverAdapter.ViewHolder viewHolder = null;

        if (convertView == null) {

            viewHolder = new GlorySeverAdapter.ViewHolder();
            // 获得容器
            convertView = LayoutInflater.from(this.context).inflate(R.layout.home_glorysevergv_item, null);

            // 初始化组件
            viewHolder.image = (ImageView) convertView.findViewById(R.id.glorysever_img);

            // 给converHolder附加一个对象
            convertView.setTag(viewHolder);
        } else {
            // 取得converHolder附加的对象
            viewHolder = (GlorySeverAdapter.ViewHolder) convertView.getTag();
        }

        // 给组件设置资源
        GlorySeverAdapter.Picture picture = pictures.get(position);
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
