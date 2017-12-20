package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.custom.GlideCircleTransform;
import com.zsh.blackcard.model.CommodityDetailModel;

import java.util.List;

/**
 * Created by kkkkk on 2017/12/20.
 * 商品详情评论列表
 */

public class CommodityDetailCommentAdapter extends BaseQuickAdapter<CommodityDetailModel.EvaListBean, BaseViewHolder> {
    public CommodityDetailCommentAdapter(int layoutResId, @Nullable List<CommodityDetailModel.EvaListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommodityDetailModel.EvaListBean item) {
        Glide.with(mContext).load(item.getPORTRAIT()).apply(RequestOptions.bitmapTransform(new GlideCircleTransform(mContext))).into((ImageView) helper.getView(R.id.commodity_detail_comment_head_img));
        helper.setText(R.id.commodity_detail_time_tv,item.getEVALUATEDATE());
        helper.setText(R.id.commodity_detail_nick_tv,item.getNICKNAME());
        helper.setText(R.id.commodity_detail_comment_tv,item.getEVALUATECONTENT());
    }
}
