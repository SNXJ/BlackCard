package com.zsh.blackcard.adapter;


import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.custom.GlideCircleTransform;
import com.zsh.blackcard.model.MusicSingerModel;

import java.util.List;

/**
 * Name: TicketSearchAdapter
 * Author: SNXJ
 * Date: 2017-11-21
 * Description:描述：
 */
public class MusicSingerAdapter extends BaseQuickAdapter<MusicSingerModel.PdBean.ArtistBean, BaseViewHolder> {

    public MusicSingerAdapter(List<MusicSingerModel.PdBean.ArtistBean> data) {
        super(R.layout.music_singer_item, data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, MusicSingerModel.PdBean.ArtistBean item) {
        helper.setText(R.id.tv_name, item.getName());
        Glide.with(mContext).load(item.getAvatar_small()).apply(RequestOptions.bitmapTransform(new GlideCircleTransform(mContext))).into((ImageView) helper.getView(R.id.im_image));
    }
}
