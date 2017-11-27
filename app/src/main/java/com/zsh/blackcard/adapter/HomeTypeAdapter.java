package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.HomeNewModel;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/21.
 * title头部适配器
 */

public class HomeTypeAdapter extends BaseQuickAdapter<HomeNewModel, BaseViewHolder> {

    public HomeTypeAdapter(int layoutResId, @Nullable List<HomeNewModel> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeNewModel item) {
        helper.setText(R.id.home_type_recycler_tv, item.getTitle());
        helper.setImageResource(R.id.home_type_recycler_img, item.getImageId());
    }
}
