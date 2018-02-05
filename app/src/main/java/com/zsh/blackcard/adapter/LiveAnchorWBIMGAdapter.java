package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;

import java.util.List;


/**
 * Name: LiveAnchorWBAdapter
 * Author: Shing
 * Date: 2018/2/2 下午2:41
 * Description: ..
 */

public class LiveAnchorWBIMGAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public LiveAnchorWBIMGAdapter(@Nullable List<String> data) {
        super(R.layout.live_anchor_weibo_img_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

        if (item.endsWith(".MOV")) {
            return;
        }
        Glide.with(mContext).load(item).apply(new RequestOptions()).into((ImageView) helper.getView(R.id.im_image));

    }
}
