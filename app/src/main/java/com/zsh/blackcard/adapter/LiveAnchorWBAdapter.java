package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.custom.GlideCircleTransform;
import com.zsh.blackcard.model.LiveAncherDetailWBModel;

import java.util.List;


/**
 * Name: LiveAnchorWBAdapter
 * Author: Shing
 * Date: 2018/2/2 下午2:41
 * Description: ..
 */

public class LiveAnchorWBAdapter extends BaseQuickAdapter<LiveAncherDetailWBModel.PdBean, BaseViewHolder> {
    public LiveAnchorWBAdapter(int layoutResId, @Nullable List<LiveAncherDetailWBModel.PdBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, LiveAncherDetailWBModel.PdBean item) {

        helper.setText(R.id.tv_name, item.getNICKNAME());
        helper.setText(R.id.tv_time, item.getPUBLISHTIME());
        helper.setText(R.id.tv_describe, item.getCONTENT());
        helper.setText(R.id.tv_agreeNum, item.getAGREECOUNT());//TODO 是否点过赞
        if ("1".equals(item.getSTATUS())) {//1为点赞
//            helper.getView(R.id.im_dotAgree).setImg();
        }
        helper.setText(R.id.tv_commentNum, item.getCOMMENTCOUNT());

//        helper.setText(R.id.tv_gifts_num, item.getAGREECOUNT());//打赏 没返回


        Glide.with(mContext).load(item.getPORTRAIT()).apply(RequestOptions.bitmapTransform(new GlideCircleTransform(mContext))).into((ImageView) helper.getView(R.id.im_head));

        RecyclerView rv = helper.getView(R.id.recyclerView);
        rv.setLayoutManager(new GridLayoutManager(mContext, 4));
        rv.setNestedScrollingEnabled(false);
        rv.setAdapter(new LiveAnchorWBIMGAdapter(item.getSHOWIMAGES()));
    }
}
