package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.HjRecyclerModel;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/22.
 */

public class HjRecyclerAdapter extends BaseQuickAdapter<HjRecyclerModel.PdBean,BaseViewHolder> {

    public HjRecyclerAdapter(int layoutResId, @Nullable List<HjRecyclerModel.PdBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HjRecyclerModel.PdBean item) {
        Glide.with(mContext).load(item.getCONVERGEIMG()).into((ImageView) helper.getView(R.id.hj_recycler_item_img));
        helper.setText(R.id.hj_recycler_item_china_tv,item.getIMGCNCHAR());
        helper.setText(R.id.hj_recycler_item_english_tv,item.getIMGENCHAR());
    }
}
