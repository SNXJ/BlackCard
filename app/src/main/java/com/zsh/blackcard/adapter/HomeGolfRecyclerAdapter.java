package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.HomeGolfRecyclerModel;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/28.
 */

public class HomeGolfRecyclerAdapter extends BaseQuickAdapter<HomeGolfRecyclerModel.PdBean, BaseViewHolder> {

    public HomeGolfRecyclerAdapter(int layoutResId, @Nullable List<HomeGolfRecyclerModel.PdBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeGolfRecyclerModel.PdBean item) {
        Glide.with(mContext).load(item.getSHOWIMAGES()).into((ImageView) helper.getView(R.id.home_privilege_recycler_item_img));
        helper.setText(R.id.home_privilege_recycler_item_name_tv,item.getGOLFNAMES());
        helper.setText(R.id.home_privilege_recycler_item_address_tv,item.getGOLFADDRESS());
    }
}
