package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.AbSearchModel;

import java.util.List;

/**
 * Name: AbSearchAdapter
 * Author: SNXJ
 * Date: 2017-12-19
 * Description:描述：
 */
public class AbSearchHotAdapter extends BaseQuickAdapter<AbSearchModel.PdBean, BaseViewHolder> {
    public AbSearchHotAdapter(@Nullable List<AbSearchModel.PdBean> data) {
        super(R.layout.item_ab_hot_secrch, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AbSearchModel.PdBean item) {
        String name = item.getNICKNAME();
        if (name.length() > 4) {
            name = name.substring(0, 2) + "..." + name.substring(name.length() - 3, name.length() - 1);
        }

        helper.setText(R.id.tv_name, name);
    }

}
