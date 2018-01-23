package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.WelcomeModel;

import java.util.List;

/**
 * Name: WelcomeAdapter
 * Author: SNXJ
 * Date: 2017-11-23
 * Description:描述：
 */
public class WelcomeAdapter extends BaseQuickAdapter<WelcomeModel.PdBean, BaseViewHolder> {
    public WelcomeAdapter(@Nullable List<WelcomeModel.PdBean> data) {
        super(R.layout.welcome_banner_item, data);

    }

    @Override
    protected void convert(final BaseViewHolder helper, WelcomeModel.PdBean item) {
        Glide.with(mContext).load(item.getSHOWIMG()).into((ImageView) helper.getView(R.id.im_banner));
    }
}
