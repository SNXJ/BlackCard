package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.ZgShopAreaModel;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/17.
 * 尊购所有专区的适配器
 */

public class ZgCommodityAdapter extends BaseQuickAdapter<ZgShopAreaModel.PdBean,BaseViewHolder> {

    public ZgCommodityAdapter(int layoutResId, @Nullable List<ZgShopAreaModel.PdBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ZgShopAreaModel.PdBean item) {
        Glide.with(mContext).load(item.getPROSHOWIMG()).into((ImageView) helper.getView(R.id.commodity_recycler_item_img));
        helper.setText(R.id.commodity_recycler_item_name_tv,item.getPROTITLE());
        helper.setText(R.id.commodity_recycler_item_price_tv,"￥"+item.getPROPRICE());
    }
}
