package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.LivePushListModel;

import java.util.List;

/**
 * Name: AbSearchAdapter
 * Author: SNXJ
 * Date: 2017-12-19
 * Description:描述：
 */
public class AbreComFragmentAdapter extends BaseQuickAdapter<LivePushListModel.PdBean.PUSHONLINEBean.OnlineInfoBean.LiveStreamOnlineInfoBean, BaseViewHolder> {
    public AbreComFragmentAdapter(@Nullable List<LivePushListModel.PdBean.PUSHONLINEBean.OnlineInfoBean.LiveStreamOnlineInfoBean> data) {
        super(R.layout.ab_recom_fragment_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, LivePushListModel.PdBean.PUSHONLINEBean.OnlineInfoBean.LiveStreamOnlineInfoBean item) {


        Glide.with(mContext).load(item.getLiveCover()).into((ImageView) helper.getView(R.id.image_cover));

        helper.setText(R.id.tv_title, item.getLiveTitle());
        helper.setText(R.id.tv_num, String.valueOf(item.getUserNumber()));

    }

}
