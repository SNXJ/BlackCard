package com.zsh.blackcard.adapter;


import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.luck.picture.lib.entity.LocalMedia;
import com.zsh.blackcard.R;

import java.util.List;

/**
 * Created by kkkkk on 2017/12/7.
 */

public class SendWeiBoAdapter extends BaseQuickAdapter<LocalMedia, BaseViewHolder> {

    private List<LocalMedia> list;

    public SendWeiBoAdapter(int layoutResId, @Nullable List<LocalMedia> data) {
        super(layoutResId, data);
        this.list = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, LocalMedia item) {
        if (list.get(helper.getLayoutPosition()).getPath() == null) {
            helper.setImageResource(R.id.send_weibo_recycler_item_img, R.mipmap.detail_group_2);
        } else {
            Glide.with(mContext).load(item.getPath()).into((ImageView) helper.getView(R.id.send_weibo_recycler_item_img));
            System.out.println();
        }
    }
}
