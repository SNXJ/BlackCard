package com.zsh.blackcard.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.BarDetailsMoreListModel;
import com.zsh.blackcard.view.Star;

import java.util.List;

/**
 * Name: HotelDetailsitemAdapter
 * Author: SNXJ
 * Date: 2017-11-23
 * Description:描述：
 */
public class BarDetailMoreListAdapter extends BaseQuickAdapter<BarDetailsMoreListModel.PdBean, BaseViewHolder> {
    private Context context;

    public BarDetailMoreListAdapter(Context context, @Nullable List<BarDetailsMoreListModel.PdBean> data) {
        super(R.layout.home_food_more_item, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, BarDetailsMoreListModel.PdBean item) {
        //TODO
        Star star = helper.getView(R.id.star);
        star.setMark((float) item.getBAREVALUATE());
        helper.setText(R.id.tv_money, "￥" + item.getBARPRICE());
        helper.setText(R.id.tv_name, item.getBARNAMES());
        helper.setText(R.id.tv_address, item.getBARADDRESS());
        helper.setText(R.id.tv_comment, "(" + item.getBAREVACOUNT() + "条评价)");
        String dis = item.getDistance();
        dis = dis.substring(0, dis.indexOf(".") + 2);
        helper.setText(R.id.tv_distance, dis + "公里");

        Glide.with(context).load(item.getSHOWIMAGES()).into((ImageView) helper.getView(R.id.im_img));
    }
}
