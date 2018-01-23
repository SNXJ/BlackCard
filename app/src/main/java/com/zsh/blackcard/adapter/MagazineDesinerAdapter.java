package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.MainGloryMagazineModel;

import java.util.List;


/**
 * Name: MagazineDesinerAdapter
 * Author: Shing
 * Date: 2018/1/10 下午2:55
 * Description: ..
 */

public class MagazineDesinerAdapter extends BaseQuickAdapter<Integer, BaseViewHolder> {

    public MagazineDesinerAdapter(int layoutResId, @Nullable List<Integer> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Integer item) {
        Glide.with(mContext).load(item).into((ImageView) helper.getView(R.id.im));
    }
}
