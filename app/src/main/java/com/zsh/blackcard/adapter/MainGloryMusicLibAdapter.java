package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.MusicRankingModel;
import com.zsh.blackcard.model.MusicRecommendModel;

import java.util.List;

/**
 * Created by ZCY on 2018/1/19.
 * 荣耀音乐曲库推荐适配器
 */

public class MainGloryMusicLibAdapter extends BaseQuickAdapter<MusicRecommendModel.PdBean.ResultBean.ListBean, BaseViewHolder> {


    public MainGloryMusicLibAdapter(int layoutResId, @Nullable List<MusicRecommendModel.PdBean.ResultBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MusicRecommendModel.PdBean.ResultBean.ListBean item) {
        Glide.with(mContext).load(item.getPic_big()).into((ImageView) helper.getView(R.id.img));
    }
}

