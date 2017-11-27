package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.ZgSearchModel;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/27.
 * 尊购模糊查询适配器
 */

public class ZgSearchAdapter extends BaseQuickAdapter<ZgSearchModel.PdBean, BaseViewHolder> {
    public ZgSearchAdapter(int layoutResId, @Nullable List<ZgSearchModel.PdBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ZgSearchModel.PdBean item) {
        helper.setText(R.id.zg_search_item_tv,item.getBRANDNAME());
    }
}
