package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.custom.GlideCircleTransform;
import com.zsh.blackcard.model.AbMyFriendModel;

import java.util.List;

/**
 * Name: HotelDetailsitemAdapter
 * Author: SNXJ
 * Date: 2017-11-23
 * Description:描述：
 */
public class AbMyFriendListAdapter extends BaseQuickAdapter<AbMyFriendModel.PdBean, BaseViewHolder> {
    public AbMyFriendListAdapter(@Nullable List<AbMyFriendModel.PdBean> data) {
        super(R.layout.ab_my_follow_item, data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, AbMyFriendModel.PdBean item) {

        helper.setText(R.id.tv_name, item.getNICKNAME());
        // helper.setText(R.id.tv_fans_num, item.getEVALUATEDATE());
        Glide.with(mContext).load(item.getPORTRAIT()).apply(RequestOptions.bitmapTransform(new GlideCircleTransform(mContext))).into((ImageView) helper.getView(R.id.im_head));
        helper.addOnClickListener(R.id.tv_item_delete);

    }
}
