package com.zsh.blackcard.adapter;


import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.custom.GlideCircleTransform;
import com.zsh.blackcard.model.MusicSingerSongsModel;

import java.util.List;

/**
 * Name: TicketSearchAdapter
 * Author: SNXJ
 * Date: 2017-11-21
 * Description:描述：
 */
public class MusicSingerSongAdapter extends BaseQuickAdapter<MusicSingerSongsModel.PdBean.SonglistBean, BaseViewHolder> {

    public MusicSingerSongAdapter(List<MusicSingerSongsModel.PdBean.SonglistBean> data) {
        super(R.layout.music_details_item, data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, MusicSingerSongsModel.PdBean.SonglistBean item) {
        helper.setText(R.id.tv_name, item.getTitle());
        helper.setText(R.id.tv_des, item.getAuthor());
        Glide.with(mContext).load(item.getPic_small()).apply(RequestOptions.bitmapTransform(new GlideCircleTransform(mContext))).into((ImageView) helper.getView(R.id.im_image));
    }
}
