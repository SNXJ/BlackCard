package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.HomeSearchHotModel;

import java.util.List;

/**
 * Created by ZCY on 2018/1/10.
 */

public class ZgSearchRecommendAdapter extends BaseQuickAdapter<HomeSearchHotModel.ShowimgsBean, BaseViewHolder> {


    public ZgSearchRecommendAdapter(int layoutResId, @Nullable List<HomeSearchHotModel.ShowimgsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeSearchHotModel.ShowimgsBean item) {
        Glide.with(mContext).load(item.getSHOWIMAGES()).into((ImageView) helper.getView(R.id.home_search_hot_img));
    }
}
