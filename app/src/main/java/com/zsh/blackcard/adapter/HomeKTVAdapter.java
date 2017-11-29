package com.zsh.blackcard.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.HomeKTVRecyclerModel;
import com.zsh.blackcard.view.Star;

import java.util.List;

/**
 * Name: HomeFoodAdapter
 * Author: SNXJ
 * Date: 2017-11-22
 * Description:描述：
 */
public class HomeKTVAdapter extends BaseQuickAdapter<HomeKTVRecyclerModel.PdBean, BaseViewHolder> {
    private Context context;

    public HomeKTVAdapter(List<HomeKTVRecyclerModel.PdBean> data, Context context) {
        super(R.layout.home_hotel_item, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeKTVRecyclerModel.PdBean item) {
        Star star = helper.getView(R.id.star);
        star.setMark((float) item.getKTVEVALUATE());
        helper.setText(R.id.tv_money, "￥" + item.getKTVPRICE());
        helper.setText(R.id.tv_name, item.getKTVNAMES());
        helper.setText(R.id.tv_address, item.getKTVADDRESS());
        helper.setText(R.id.tv_comment, "(" + item.getKTVEVACOUNT() + "条评价)");
        String dis = item.getDistance();
        dis = dis.substring(0, dis.indexOf("."));
        helper.setText(R.id.tv_distance, dis + "公里");
        Glide.with(context).load(item.getSHOWIMAGES()).into((ImageView) helper.getView(R.id.im_hotel));
    }
}
