package com.zsh.blackcard.adapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.BardetailsItemModel;

import java.util.List;

/**
 * Name: HotelDetailsitemAdapter
 * Author: SNXJ
 * Date: 2017-11-27
 * Description:描述：
 */
public class BarDetailsitemAdapter extends BaseQuickAdapter<BardetailsItemModel.PdBean, BaseViewHolder> {
    private Context context;

    public BarDetailsitemAdapter(Context context, @Nullable List<BardetailsItemModel.PdBean> data) {
        super(R.layout.home_ktv_detail_item, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, BardetailsItemModel.PdBean item) {
        helper.setText(R.id.tv_money, "￥" + item.getBARDETPRICE());
        helper.setText(R.id.tv_time, item.getBARDETTITLE());

    }
}
