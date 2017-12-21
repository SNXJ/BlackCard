package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.CommodityDetailModel;

import java.util.List;

/**
 * Created by kkkkk on 2017/12/21.
 * 商品详情大图文字适配器
 */

public class CommodityDetailImgRecyclerAdapter extends BaseQuickAdapter<CommodityDetailModel.DetailBean, BaseViewHolder> {
    public CommodityDetailImgRecyclerAdapter(int layoutResId, @Nullable List<CommodityDetailModel.DetailBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommodityDetailModel.DetailBean item) {
        if (item.getSHOWIMG().equals("")) {
            helper.getView(R.id.commodity_detail_one_img).setVisibility(View.GONE);
        } else {
            helper.getView(R.id.commodity_detail_one_img).setVisibility(View.VISIBLE);
            Glide.with(mContext).load(item.getSHOWIMG()).into((ImageView) helper.getView(R.id.commodity_detail_one_img));
        }

        if (item.getCONTENT().equals("")) {
            helper.getView(R.id.commodity_detail_one_tv).setVisibility(View.GONE);
        } else {
            helper.getView(R.id.commodity_detail_one_tv).setVisibility(View.VISIBLE);
            helper.setText(R.id.commodity_detail_one_tv, item.getCONTENT());
        }
    }
}
