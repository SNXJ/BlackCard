package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;

import java.util.List;


/**
 * Name: SelectTopicAdapter
 * Author: Shing
 * Date: 17/12/26 上午11:07
 * Description: ..
 */

public class SelectTopicAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public SelectTopicAdapter(@Nullable List<String> data) {
        super(R.layout.item_select_topic,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

            helper.setText(R.id.tv_topic,item);

    }
}
