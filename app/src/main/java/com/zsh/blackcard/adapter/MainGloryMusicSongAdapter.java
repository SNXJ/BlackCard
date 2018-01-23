package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.MainGloryMusicSongModel;

import java.util.List;

/**
 * Created by ZCY on 2018/1/20.
 * 荣耀音乐歌曲推荐适配器
 */

public class MainGloryMusicSongAdapter extends BaseQuickAdapter<MainGloryMusicSongModel.SongRecommendBean, BaseViewHolder> {
    public MainGloryMusicSongAdapter(int layoutResId, @Nullable List<MainGloryMusicSongModel.SongRecommendBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MainGloryMusicSongModel.SongRecommendBean item) {
        helper.setText(R.id.tv,item.getBillboard().getName());
        Glide.with(mContext).load(item.getBillboard().getPic_s192()).into((ImageView) helper.getView(R.id.img));
    }
}
