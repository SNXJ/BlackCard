package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;

import java.util.List;


/**
 * Name: LiveViewerAdapter
 * Author: Shing
 * Date: 2018/1/9 下午5:15
 * Description: ..
 */

public class LiveViewerAdapter extends BaseQuickAdapter<Integer, BaseViewHolder> {

    public LiveViewerAdapter(@Nullable List<Integer> data) {
        super(R.layout.live_viewer_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Integer item) {
        helper.getView(R.id.image_view).setBackgroundResource(item);

    }
}
