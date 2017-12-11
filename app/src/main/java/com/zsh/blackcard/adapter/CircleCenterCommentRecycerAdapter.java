package com.zsh.blackcard.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.custom.GlideCircleTransform;
import com.zsh.blackcard.model.CircleCenterCommentRecyclerModel;

import java.util.List;

/**
 * Created by kkkkk on 2017/12/8.
 * 圈子中心评论列表适配器
 */

public class CircleCenterCommentRecycerAdapter extends BaseMultiItemQuickAdapter<CircleCenterCommentRecyclerModel.PdBean, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public CircleCenterCommentRecycerAdapter(List<CircleCenterCommentRecyclerModel.PdBean> data) {
        super(data);
        addItemType(CircleCenterCommentRecyclerModel.PdBean.COMMENT, R.layout.circle_center_comment_recycler_item);
        addItemType(CircleCenterCommentRecyclerModel.PdBean.REPLY, R.layout.circle_center_reply_recycler_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, CircleCenterCommentRecyclerModel.PdBean item) {
        switch (helper.getItemViewType()) {
            case CircleCenterCommentRecyclerModel.PdBean.COMMENT:
                Glide.with(mContext).load(item.getPORTRAIT()).apply(RequestOptions.bitmapTransform(new GlideCircleTransform(mContext))).into((ImageView) helper.getView(R.id.circle_center_comment_item_head_img));
                helper.setText(R.id.circle_center_comment_item_content_tv, item.getCOMCONTENT());
                helper.setText(R.id.circle_center_comment_item_time_tv, item.getCOMMENTTIME().substring(0, 10));
                helper.setText(R.id.circle_center_comment_item_name_tv, item.getCOMMENTNICKNAME());
                break;
            case CircleCenterCommentRecyclerModel.PdBean.REPLY:
                Glide.with(mContext).load(item.getPORTRAIT()).apply(RequestOptions.bitmapTransform(new GlideCircleTransform(mContext))).into((ImageView) helper.getView(R.id.circle_center_comment_item_head_img));
                helper.setText(R.id.circle_center_comment_item_content_tv, item.getCOMCONTENT());
                helper.setText(R.id.circle_center_comment_item_time_tv, item.getCOMMENTTIME().substring(0, 10));
                helper.setText(R.id.circle_center_comment_item_name_tv, item.getREPLYNICKNAME());
                helper.setText(R.id.circle_center_comment_item_right_name_tv, item.getCOMMENTNICKNAME());
                break;
        }

    }
}
