package com.zsh.blackcard.adapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.HomeKTVDetailItemModel;

import java.util.List;

/**
 * Name: HotelDetailsitemAdapter
 * Author: SNXJ
 * Date: 2017-11-23
 * Description:描述：
 */
public class KTVDetailsitemAdapter extends BaseQuickAdapter<HomeKTVDetailItemModel.PdBean, BaseViewHolder> {
    private Context context;

    public KTVDetailsitemAdapter(Context context, @Nullable List<HomeKTVDetailItemModel.PdBean> data) {
        super(R.layout.home_ktv_detail_item, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeKTVDetailItemModel.PdBean item) {
        helper.setText(R.id.tv_money, "￥" + item.getKTVDETPRICE());
        helper.setText(R.id.tv_time, item.getKTVDETTITLE());
    }
}
