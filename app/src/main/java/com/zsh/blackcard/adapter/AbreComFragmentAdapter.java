package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.LivePushListModel;
import com.zsh.blackcard.utils.DisplayUtil;

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

        ImageView im_cover = helper.getView(R.id.image_cover);
        if (0 == helper.getLayoutPosition()) {
            setImage(im_cover, 165);

        } else {
            setImage(im_cover, 230);
        }

    }

    private void setImage(ImageView im_cover, int height) {
        ViewGroup.LayoutParams lpm = im_cover.getLayoutParams();
        lpm.width = ViewGroup.LayoutParams.MATCH_PARENT;
        lpm.height = DisplayUtil.dip2px(mContext, height);
        im_cover.setLayoutParams(lpm);
        im_cover.setMaxHeight(DisplayUtil.dip2px(mContext, height));
        im_cover.setMaxWidth(ViewGroup.LayoutParams.MATCH_PARENT);
    }

}
