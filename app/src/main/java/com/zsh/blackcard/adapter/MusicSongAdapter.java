package com.zsh.blackcard.adapter;


import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Name: MusicSongAdapter
 * Author: Shing
 * Date: 2018/1/11 下午1:52
 * Description: temp
 */

public class MusicSongAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public MusicSongAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
