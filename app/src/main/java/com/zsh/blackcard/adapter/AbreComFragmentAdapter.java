package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;

import java.util.List;

/**
 * Name: AbSearchAdapter
 * Author: SNXJ
 * Date: 2017-12-19
 * Description:描述：
 */
public class AbreComFragmentAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public AbreComFragmentAdapter(@Nullable List<String> data) {
        super(R.layout.ab_recom_fragment_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }

}
