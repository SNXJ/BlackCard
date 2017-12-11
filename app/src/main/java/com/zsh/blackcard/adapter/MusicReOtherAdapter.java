package com.zsh.blackcard.adapter;


import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.MusicRankingModel;

import java.util.List;

/**
 * Name: TicketSearchAdapter
 * Author: SNXJ
 * Date: 2017-11-21
 * Description:描述：
 */
public class MusicReOtherAdapter extends BaseQuickAdapter<MusicRankingModel.PdBean.SongListBean, BaseViewHolder> {


    private int type;

    public MusicReOtherAdapter(List<MusicRankingModel.PdBean.SongListBean> data) {
        super(R.layout.music_recommend_item, data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, MusicRankingModel.PdBean.SongListBean item) {
        helper.setText(R.id.tv_num, item.getLanguage());
        helper.setText(R.id.tv_des, item.getAuthor() + "-" + item.getTitle());
        Glide.with(mContext).load(item.getPic_big()).into((ImageView) helper.getView(R.id.im_image));
    }
}
