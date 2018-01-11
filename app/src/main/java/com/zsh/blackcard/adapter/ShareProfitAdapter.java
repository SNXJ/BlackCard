package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;

import java.util.List;


/**
 * Name: ShareProfitAdapter
 * Author: Shing
 * Date: 2018/1/10 上午11:07
 * Description: ..
 */

public class ShareProfitAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public ShareProfitAdapter(@Nullable List<String> data) {
        super(R.layout.share_profit_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
