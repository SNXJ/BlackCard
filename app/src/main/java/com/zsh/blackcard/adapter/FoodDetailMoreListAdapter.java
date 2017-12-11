package com.zsh.blackcard.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.FoodDetailsMoreListModel;
import com.zsh.blackcard.view.Star;

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
        Star star = helper.getView(R.id.star);
        star.setMark((float) item.getSHOPEVALUATE());
        helper.setText(R.id.tv_money, "￥" + item.getSHOPPRICE());
        helper.setText(R.id.tv_name, item.getSHOPNAMES());
        helper.setText(R.id.tv_address, item.getSHOPADDRESS());
        helper.setText(R.id.tv_comment, "(" + item.getSHOPEVACOUNT() + "条评价)");
        String dis = item.getDistance();
        dis = dis.substring(0, dis.indexOf(".") + 2);
        helper.setText(R.id.tv_distance, dis + "公里");

        Glide.with(context).load(item.getSHOWIMAGES()).into((ImageView) helper.getView(R.id.im_img));
    }
}
