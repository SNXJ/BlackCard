package com.zsh.blackcard.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.HomeHotelModel;
import com.zsh.blackcard.view.Star;

import java.util.List;

/**
 * Name: HomeFoodAdapter
 * Author: SNXJ
 * Date: 2017-11-22
 * Description:描述：
 */
public class HomeHotelAdapter extends BaseQuickAdapter<HomeHotelModel.PdBean, BaseViewHolder> {
    private Context context;

    public HomeHotelAdapter(List<HomeHotelModel.PdBean> data, Context context) {
        super(R.layout.home_hotel_item, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeHotelModel.PdBean item) {
        Star star = helper.getView(R.id.star);
        star.setMark((float) item.getHOTELEVACOUNT());
        helper.setText(R.id.tv_money, "￥" + item.getHOTELPRICE());
        helper.setText(R.id.tv_name, null == item.getHOTELNAMES() ? "北京" : item.getHOTELNAMES());
        helper.setText(R.id.tv_address, item.getHOTELADDRESS());
        helper.setText(R.id.tv_comment, "(" + item.getHOTELEVACOUNT() + "条评价)");
        Glide.with(context).load(item.getSHOWIMAGES()).into((ImageView) helper.getView(R.id.im_img));
    }
}
