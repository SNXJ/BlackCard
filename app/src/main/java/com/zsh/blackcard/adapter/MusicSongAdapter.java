package com.zsh.blackcard.adapter;


import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.MusicRankAllModel;

import java.util.List;

/**
 * Name: MusicSongAdapter
 * Author: Shing
 * Date: 2018/1/11 下午1:52
 * Description: temp
 * 榜单推荐适配器
 */

public class MusicSongAdapter extends BaseQuickAdapter<MusicRankAllModel.PdBean, BaseViewHolder> {


    public MusicSongAdapter(int layoutResId, @Nullable List<MusicRankAllModel.PdBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MusicRankAllModel.PdBean item) {
        Glide.with(mContext).load(item.getBillboard().getPic_s640()).into((ImageView) helper.getView(R.id.img));
    }
}
