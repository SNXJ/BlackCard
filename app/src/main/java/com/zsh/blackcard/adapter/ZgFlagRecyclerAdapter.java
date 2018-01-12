package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;

import java.util.List;

/**
 * Created by ZCY on 2018/1/11.
 * 尊购旗舰店适配器
 */

public class ZgFlagRecyclerAdapter extends BaseQuickAdapter<Integer, BaseViewHolder> {

    public ZgFlagRecyclerAdapter(int layoutResId, @Nullable List<Integer> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Integer item) {
        helper.setImageResource(R.id.zg_flag_fragment_recycler_item_big_img,item);
    }
}
