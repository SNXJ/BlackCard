package com.zsh.blackcard.adapter;


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
public class MusicRankingAdapter extends BaseQuickAdapter<MusicRankingModel.PdBean.SongListBean, BaseViewHolder> {

    public MusicRankingAdapter(List<MusicRankingModel.PdBean.SongListBean> data) {
        super(R.layout.music_ranking_item, data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, MusicRankingModel.PdBean.SongListBean item) {

    }
}
