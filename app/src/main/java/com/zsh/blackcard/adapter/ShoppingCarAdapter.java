package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.ShoppingCarModel;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/25.
 * 购物车列表适配器
 */

public class ShoppingCarAdapter extends BaseQuickAdapter<ShoppingCarModel.PdBean, BaseViewHolder> {

    public ShoppingCarAdapter(int layoutResId, @Nullable List<ShoppingCarModel.PdBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShoppingCarModel.PdBean item) {
        helper.setText(R.id.shopping_car_title_tv,item.getPROTITLE());
        helper.setText(R.id.shopping_car_price_tv,"￥"+item.getPROPRICE());
        helper.setText(R.id.shopping_car_number_et,String.valueOf(item.getPRODUCTCOUNT()));
        Glide.with(mContext).load(item.getPROSHOWIMG()).into((ImageView) helper.getView(R.id.shopping_car_icon_img));
        //侧滑删除绑定点击
        helper.addOnClickListener(R.id.shopping_car_item_right_delete);
        //这是整个行布局的id绑定点击
        helper.addOnClickListener(R.id.shopping_car_item_relative);
        helper.addOnClickListener(R.id.shopping_car_item_cb);
    }
}
