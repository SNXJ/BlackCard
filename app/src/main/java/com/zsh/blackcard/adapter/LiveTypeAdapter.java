package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.LiveTypeModel;

import java.util.List;


/**
 * Name: LiveTypeAdapter
 * Author: Shing
 * Date: 2018/1/29 上午10:53
 * Description: ..
 */

public class LiveTypeAdapter extends BaseQuickAdapter<LiveTypeModel.PdBean, BaseViewHolder> {

    public LiveTypeAdapter(int layoutResId, @Nullable List<LiveTypeModel.PdBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, LiveTypeModel.PdBean item) {

        helper.setText(R.id.tv_type, item.getNAME());


        if (item.getSelect()) {
//            helper.getView(R.id.tv_type).setSelected(true);
            ((TextView) helper.getView(R.id.tv_type)).setTextColor(mContext.getResources().getColor(R.color.bg_org));
        } else {
//            helper.getView(R.id.tv_type).setSelected(false);
            ((TextView) helper.getView(R.id.tv_type)).setTextColor(mContext.getResources().getColor(R.color.ff92_text));
        }
    }
}
