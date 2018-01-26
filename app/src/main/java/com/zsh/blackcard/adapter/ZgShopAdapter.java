package com.zsh.blackcard.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.ZgHomeListModel;
import com.zsh.blackcard.model.ZgShopAreaModel;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/22.
 * 尊购商品区适配器
 */

public class ZgShopAdapter extends BaseMultiItemQuickAdapter<ZgHomeListModel.PdBean, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public ZgShopAdapter(List<ZgHomeListModel.PdBean> data) {
        super(data);
        addItemType(ZgHomeListModel.PdBean.LEFT, R.layout.zg_shop_left_item);
        addItemType(ZgHomeListModel.PdBean.RIGHT, R.layout.zg_shop_right_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, ZgHomeListModel.PdBean item) {
        helper.setText(R.id.zg_shop__tv, item.getBRANDBANE());
        Glide.with(mContext).load(item.getSHOWIMG()).into((ImageView) helper.getView(R.id.zg_shop_img));
    }
}
