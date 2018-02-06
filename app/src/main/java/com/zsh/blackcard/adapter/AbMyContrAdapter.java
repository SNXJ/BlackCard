package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.custom.GlideCircleTransform;
import com.zsh.blackcard.model.AbContriModel;

import java.util.List;


/**
 * Name: AbMyContrAdapter
 * Author: Shing
 * Date: 2018/2/6 上午11:58
 * Description: ..
 */

public class AbMyContrAdapter extends BaseQuickAdapter<AbContriModel.PdBean, BaseViewHolder> {
    public AbMyContrAdapter(int layoutResId, @Nullable List<AbContriModel.PdBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AbContriModel.PdBean item) {

        TextView tv_rank = helper.getView(R.id.tv_rank);
        helper.setText(R.id.tv_name, item.getNICKNAME());
        helper.setText(R.id.tv_num, "贡献值：" + item.getSCORE());
        Glide.with(mContext).load(item.getPORTRAIT()).apply(RequestOptions.bitmapTransform(new GlideCircleTransform(mContext))).into((ImageView) helper.getView(R.id.im_head));

        int position = helper.getLayoutPosition();
        if (position == 0) {
            tv_rank.setBackgroundResource(R.mipmap.list_image_1);
        } else if (position == 1) {
            tv_rank.setBackgroundResource(R.mipmap.list_image_2);
        } else if (position == 2) {
            tv_rank.setBackgroundResource(R.mipmap.list_image_3);
        } else {
            tv_rank.setBackground(null);
            tv_rank.setText(position + 1 + "");
        }
        helper.addOnClickListener(R.id.tv_item_delete);

    }
}
