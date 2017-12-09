package com.zsh.blackcard.adapter;


import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.MusicDjModel;

import java.util.List;

/**
 * Name: TicketSearchAdapter
 * Author: SNXJ
 * Date: 2017-11-21
 * Description:描述：
 */
public class MusicDjAdapter extends BaseQuickAdapter<MusicDjModel.PdBean.ResultBean.ChannellistBean, BaseViewHolder> {

    public MusicDjAdapter(List<MusicDjModel.PdBean.ResultBean.ChannellistBean> data) {
        super(R.layout.music_dj_item, data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, MusicDjModel.PdBean.ResultBean.ChannellistBean item) {
        helper.setText(R.id.tv_name, item.getName());
        helper.setText(R.id.tv_des, "当前热度为" + item.getValue());
        Glide.with(mContext).load(item.getThumb()).into((ImageView) helper.getView(R.id.im_image));
    }
}
