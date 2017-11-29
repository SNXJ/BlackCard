package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.HomeCarRecyclerModel;
import com.zsh.blackcard.model.HomeHorseRecyclerModel;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/29.
 * 豪车列表适配器
 */

public class HomeCarRecyclerAdapter extends BaseQuickAdapter<HomeCarRecyclerModel.PdBean, BaseViewHolder> {
    public HomeCarRecyclerAdapter(int layoutResId, @Nullable List<HomeCarRecyclerModel.PdBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeCarRecyclerModel.PdBean item) {
        helper.setText(R.id.home_privilege_recycler_item_name_tv, item.getLUXCARNAMES());
        helper.setText(R.id.home_privilege_recycler_item_address_tv, item.getLUXCARADDRESS());
        helper.setText(R.id.home_privilege_recycler_item_distance_tv, item.getDistance().substring(0, item.getDistance().indexOf(".")) + "公里");
        Glide.with(mContext).load(item.getSHOWIMAGES()).into((ImageView) helper.getView(R.id.home_privilege_recycler_item_img));
    }
}
