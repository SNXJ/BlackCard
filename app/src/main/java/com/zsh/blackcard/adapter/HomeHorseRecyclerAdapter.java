package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.HomeHorseRecyclerModel;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/29.
 * 马术列表适配器
 */

public class HomeHorseRecyclerAdapter extends BaseQuickAdapter<HomeHorseRecyclerModel.PdBean, BaseViewHolder> {
    public HomeHorseRecyclerAdapter(int layoutResId, @Nullable List<HomeHorseRecyclerModel.PdBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeHorseRecyclerModel.PdBean item) {
        helper.setText(R.id.home_privilege_recycler_item_name_tv, item.getHORSENAMES());
        helper.setText(R.id.home_privilege_recycler_item_address_tv, item.getHORSEADDRESS());
        helper.setText(R.id.home_privilege_recycler_item_distance_tv, item.getDistance().substring(0, item.getDistance().indexOf(".")) + "公里");
        Glide.with(mContext).load(item.getSHOWIMAGES()).into((ImageView) helper.getView(R.id.home_privilege_recycler_item_img));
    }
}
