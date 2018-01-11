package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;

import java.util.List;


/**
 * Name: MagazineDesinerAdapter
 * Author: Shing
 * Date: 2018/1/10 下午2:55
 * Description: ..
 */

public class ZgDiscoverAdapter extends BaseQuickAdapter<Integer,BaseViewHolder> {
    public ZgDiscoverAdapter(@Nullable List<Integer> data) {
            super(R.layout.zg_discover_item,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Integer item) {
//        helper.getView(R.id.im).setBackgroundResource(item);

    }
}
