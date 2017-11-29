package com.zsh.blackcard.adapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.FoodDetailsMoreListModel;

import java.util.List;

/**
 * Name: HotelDetailsitemAdapter
 * Author: SNXJ
 * Date: 2017-11-23
 * Description:描述：
 */
public class FoodDetailMoreListAdapter extends BaseQuickAdapter<FoodDetailsMoreListModel.PdBean, BaseViewHolder> {
    private Context context;

    public FoodDetailMoreListAdapter(Context context, @Nullable List<FoodDetailsMoreListModel.PdBean> data) {
        super(R.layout.home_food_more_item, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, FoodDetailsMoreListModel.PdBean item) {
//        helper.setText(R.id.tv_money, "￥" + item.getHOTELDETPRICE());
//        helper.setText(R.id.tv_name, item.getHOTELDETNAME());
//        helper.setText(R.id.tv_des, item.getHOTELDETBEDTYPE());
//        //TODO
//        // helper.setText(R.id.tv_vip, item.getHOTELDETBEDTYPE());
//
//        Glide.with(context).load(item.getHOTELDETIMGS()).into((ImageView) helper.getView(R.id.im_img));
    }
}
