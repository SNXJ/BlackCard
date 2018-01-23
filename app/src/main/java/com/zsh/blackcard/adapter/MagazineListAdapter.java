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

public class MagazineListAdapter extends BaseQuickAdapter<MainGloryMagazineModel.MagazinesBean,BaseViewHolder> {

    public MagazineListAdapter(int layoutResId, @Nullable List<MainGloryMagazineModel.MagazinesBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MainGloryMagazineModel.MagazinesBean item) {
        Glide.with(mContext).load(item.getSHOWIMG()).into((ImageView) helper.getView(R.id.im));
    }
}
