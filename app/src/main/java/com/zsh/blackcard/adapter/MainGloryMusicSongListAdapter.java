package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.custom.GlideCircleTransform;
import com.zsh.blackcard.model.MainGloryMusicSongModel;

import java.util.List;

/**
 * Created by ZCY on 2018/1/20.
 * 歌单推荐适配器
 */

public class MainGloryMusicSongListAdapter extends BaseQuickAdapter<MainGloryMusicSongModel.SongRecommendBean.SongListBean, BaseViewHolder> {

    public MainGloryMusicSongListAdapter(int layoutResId, @Nullable List<MainGloryMusicSongModel.SongRecommendBean.SongListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MainGloryMusicSongModel.SongRecommendBean.SongListBean item) {
        helper.setText(R.id.tv_name, item.getTitle());
        helper.setText(R.id.tv_des, item.getAuthor());
        Glide.with(mContext).load(item.getPic_small()).apply(RequestOptions.bitmapTransform(new GlideCircleTransform(mContext))).into((ImageView) helper.getView(R.id.im_image));
    }
}
