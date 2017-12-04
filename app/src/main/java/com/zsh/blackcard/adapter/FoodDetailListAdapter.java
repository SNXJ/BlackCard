package com.zsh.blackcard.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.FoodDetailsListModel;
import com.zsh.blackcard.model.HomeFoodDetailPackageModel;

import java.util.List;

/**
 * Name: HotelDetailsitemAdapter
 * Author: SNXJ
 * Date: 2017-11-23
 * Description:描述：
 */
public class FoodDetailListAdapter extends BaseQuickAdapter<HomeFoodDetailPackageModel.PdBean, BaseViewHolder> {
    private Context context;

    public FoodDetailListAdapter(Context context, @Nullable List<HomeFoodDetailPackageModel.PdBean> data) {
        super(R.layout.home_hotel_food_detail_item, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeFoodDetailPackageModel.PdBean item) {
        helper.setText(R.id.tv_money, "￥" + item.getFOODDETPRICE());
        helper.setText(R.id.tv_name, item.getFOODDETNAME());
        helper.setText(R.id.tv_des, item.getFOODDETREMARK());
        //TODO
        // helper.setText(R.id.tv_vip, item.getHOTELDETBEDTYPE());

        Glide.with(context).load(item.getFOODDETIMGS()).into((ImageView) helper.getView(R.id.im_img));
    }
}
