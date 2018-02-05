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
public class AbSearchAdapter extends BaseQuickAdapter<AbSearchModel.PdBean, BaseViewHolder> {
    public AbSearchAdapter(@Nullable List<AbSearchModel.PdBean> data) {
        super(R.layout.item_ab_secrch, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, AbSearchModel.PdBean item) {
        helper.setText(R.id.tv_name, item.getNICKNAME());
    }

}
