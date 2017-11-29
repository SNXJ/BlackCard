package com.zsh.blackcard.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.CommentModel;

import java.util.List;

/**
 * Name: HotelDetailsitemAdapter
 * Author: SNXJ
 * Date: 2017-11-23
 * Description:描述：
 */
public class CommentListAdapter extends BaseQuickAdapter<CommentModel.PdBean, BaseViewHolder> {
    private Context context;

    public CommentListAdapter(Context context, @Nullable List<CommentModel.PdBean> data) {
        super(R.layout.comment_item, data);
        this.context = context;
    }

    @Override
    protected void convert(final BaseViewHolder helper, CommentModel.PdBean item) {

        helper.setText(R.id.tv_name, item.getNICKNAME());
        helper.setText(R.id.tv_time, item.getEVALUATEDATE());
        //TODO
        helper.setText(R.id.tv_content, item.getEVALUATECONTENT());
//
        Glide.with(context).load(item.getPORTRAIT()).into((ImageView) helper.getView(R.id.im_head));


    }
}
