package com.zsh.blackcard.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.HomeFoodModel;
import com.zsh.blackcard.view.Star;

import java.util.List;

/**
 * Name: HomeFoodAdapter
 * Author: SNXJ
 * Date: 2017-11-22
 * Description:描述：
 */
public class HomeFoodAdapter extends BaseQuickAdapter<HomeFoodModel.PdBean, BaseViewHolder> {
    private Context context;

    public HomeFoodAdapter(List<HomeFoodModel.PdBean> data, Context context) {
        super(R.layout.home_food_item, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeFoodModel.PdBean item) {
        Star star = helper.getView(R.id.star);
        star.setMark((float) item.getSHOPEVALUATE());
        helper.setText(R.id.tv_money, "￥" + item.getSHOPPRICE() + "/位");
        helper.setText(R.id.tv_address, item.getSHOPADDRESS());
        helper.setText(R.id.tv_comment, "(" + item.getSHOPEVACOUNT() + "条评价)");
        Glide.with(context).load(item.getSHOWIMAGES()).into((ImageView) helper.getView(R.id.im_food));
    }
}
