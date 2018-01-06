package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.CollectionModel;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/18.
 * 炫购收藏列表适配器
 */

public class CollectionAdapter extends BaseQuickAdapter<CollectionModel.PdBean, BaseViewHolder> {

    public CollectionAdapter(int layoutResId, @Nullable List<CollectionModel.PdBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CollectionModel.PdBean item) {
        Glide.with(mContext).load(item.getPROSHOWIMG()).into((ImageView) helper.getView(R.id.collection_recycler_item_img));
        helper.setText(R.id.collection_recycler_item_title_tv, item.getPROTITLE());
        helper.setText(R.id.collection_recycler_item_price_tv, "¥" + item.getPROPRICE());
        helper.addOnClickListener(R.id.shopping_car_item_right_delete);
    }
}
