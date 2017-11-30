package com.zsh.blackcard.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.HotelDetailsMoreListModel;
import com.zsh.blackcard.view.Star;

import java.util.List;

/**
 * Name: HotelDetailsitemAdapter
 * Author: SNXJ
 * Date: 2017-11-23
 * Description:描述：
 */
public class HotelDetailMoreListAdapter extends BaseQuickAdapter<HotelDetailsMoreListModel.PdBean, BaseViewHolder> {
    private Context context;

    public HotelDetailMoreListAdapter(Context context, @Nullable List<HotelDetailsMoreListModel.PdBean> data) {
        super(R.layout.home_food_more_item, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, HotelDetailsMoreListModel.PdBean item) {
        Star star = helper.getView(R.id.star);
        star.setMark((float) item.getHOTELEVALUATE());
        helper.setText(R.id.tv_money, "￥" + item.getHOTELPRICE());
        helper.setText(R.id.tv_name, item.getHOTELNAMES());
        helper.setText(R.id.tv_address, item.getHOTELADDRESS());
        helper.setText(R.id.tv_comment, "(" + item.getHOTELEVACOUNT() + "条评价)");
        String dis = item.getDistance();
        dis = dis.substring(0, dis.indexOf(".") + 2);
        helper.setText(R.id.tv_distance, dis + "公里");
        Glide.with(context).load(item.getSHOWIMAGES()).into((ImageView) helper.getView(R.id.im_img));
    }
}
