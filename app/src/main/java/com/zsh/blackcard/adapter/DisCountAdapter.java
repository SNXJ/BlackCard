package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.DisCountModel;

import java.util.List;

/**
 * Created by ZCY on 2018/1/24.
 * 订单中心优惠券适配器
 */

public class DisCountAdapter extends BaseQuickAdapter<DisCountModel.PdBean, BaseViewHolder> {
    public DisCountAdapter(int layoutResId, @Nullable List<DisCountModel.PdBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DisCountModel.PdBean item) {
//        helper.setText(R.id.max_tv, "满" + item.getCOUPON_MININUM() + "元即可使用");
//        helper.setText(R.id.money_tv, "¥" + item.getCOUPON_VALUE());
    }
}
