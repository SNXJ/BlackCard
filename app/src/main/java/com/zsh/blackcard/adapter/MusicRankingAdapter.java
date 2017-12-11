package com.zsh.blackcard.adapter;


import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.MusicRankAllModel;

import java.util.List;

/**
 * Name: TicketSearchAdapter
 * Author: SNXJ
 * Date: 2017-11-21
 * Description:描述：
 */
public class MusicRankingAdapter extends BaseQuickAdapter<MusicRankAllModel.PdBean, BaseViewHolder> {

    public MusicRankingAdapter(List<MusicRankAllModel.PdBean> data) {
        super(R.layout.music_ranking_item, data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, MusicRankAllModel.PdBean item) {
        helper.setText(R.id.tv_text1, item.getSong_list().get(0).getAuthor() + "-" + item.getSong_list().get(0).getTitle());
        helper.setText(R.id.tv_text2, item.getSong_list().get(1).getAuthor() + "-" + item.getSong_list().get(1).getTitle());
        helper.setText(R.id.tv_text3, item.getSong_list().get(2).getAuthor() + "-" + item.getSong_list().get(2).getTitle());
        Glide.with(mContext).load(item.getBillboard().getPic_s640()).into((ImageView) helper.getView(R.id.im_image));
    }
}
