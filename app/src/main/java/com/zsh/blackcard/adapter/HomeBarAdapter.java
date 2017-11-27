package com.zsh.blackcard.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.HomeBarModel;
import com.zsh.blackcard.view.Star;

import java.util.List;

/**
 * Name: HomeFoodAdapter
 * Author: SNXJ
 * Date: 2017-11-22
 * Description:描述：
 */
public class HomeBarAdapter extends BaseQuickAdapter<HomeBarModel.PdBean, BaseViewHolder> {
    private Context context;

    public HomeBarAdapter(List<HomeBarModel.PdBean> data, Context context) {
        super(R.layout.home_hotel_item, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeBarModel.PdBean item) {
        Star star = helper.getView(R.id.star);
        star.setMark((float) item.getBAREVALUATE());
        helper.setText(R.id.tv_money, "￥" + item.getBARPRICE());
        helper.setText(R.id.tv_name, item.getBARNAMES());
        helper.setText(R.id.tv_address, item.getBARADDRESS());
        helper.setText(R.id.tv_comment, "(" + item.getBAREVACOUNT() + "条评价)");
        String dis = item.getDistance().getDistance();
        dis = dis.substring(0, dis.indexOf("."));
        helper.setText(R.id.tv_distance, dis + "公里");
        Glide.with(context).load(item.getSHOWIMAGES()).into((ImageView) helper.getView(R.id.im_hotel));
    }
}
