package com.zsh.blackcard.adapter;


import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.MusicRecommendModel;

import java.util.List;

/**
 * Name: TicketSearchAdapter
 * Author: SNXJ
 * Date: 2017-11-21
 * Description:描述：
 */
public class MusicRecommendAdapter extends BaseQuickAdapter<MusicRecommendModel.PdBean.ResultBean.ListBean, BaseViewHolder> {


    private int type;

    public MusicRecommendAdapter(List<MusicRecommendModel.PdBean.ResultBean.ListBean> data, int type) {
        super(R.layout.music_recommend_item, data);
        this.type = type;
    }

    @Override
    protected void convert(final BaseViewHolder helper, MusicRecommendModel.PdBean.ResultBean.ListBean item) {
        helper.setText(R.id.tv_num, item.getLanguage());
        helper.setText(R.id.tv_des, item.getAuthor() + "-" + item.getTitle());
        Glide.with(mContext).load(item.getPic_big()).into((ImageView) helper.getView(R.id.im_image));
    }
}
