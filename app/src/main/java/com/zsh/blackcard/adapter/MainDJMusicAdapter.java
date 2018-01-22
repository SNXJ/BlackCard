package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.MainGloryMusicDJModel;

import java.util.List;

/**
 * Created by ZCY on 2018/1/19.
 * 电台适配器
 */

public class MainDJMusicAdapter extends BaseQuickAdapter<MainGloryMusicDJModel.PdBean, BaseViewHolder> {

    public MainDJMusicAdapter(int layoutResId, @Nullable List<MainGloryMusicDJModel.PdBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MainGloryMusicDJModel.PdBean item) {
        helper.setText(R.id.tv_one,item.getName());
//        helper.setText(R.id.tv_ones,item.getName());
        Glide.with(mContext).load(item.getThumb()).into((ImageView) helper.getView(R.id.img_one));
    }
}
