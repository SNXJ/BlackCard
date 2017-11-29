package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.HomeCarRecyclerModel;
import com.zsh.blackcard.model.HomeYachtRecyclerModel;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/29.
 * 游艇列表适配器
 */

public class HomeYachtRecyclerAdapter extends BaseQuickAdapter<HomeYachtRecyclerModel.PdBean, BaseViewHolder> {
    public HomeYachtRecyclerAdapter(int layoutResId, @Nullable List<HomeYachtRecyclerModel.PdBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeYachtRecyclerModel.PdBean item) {
        helper.setText(R.id.home_privilege_recycler_item_name_tv, item.getYACHTNAMES());
        helper.setText(R.id.home_privilege_recycler_item_address_tv, item.getYACHTADDRESS());
        helper.setText(R.id.home_privilege_recycler_item_distance_tv, item.getDistance().substring(0, item.getDistance().indexOf(".")) + "公里");
        Glide.with(mContext).load(item.getSHOWIMAGES()).into((ImageView) helper.getView(R.id.home_privilege_recycler_item_img));
    }
}
