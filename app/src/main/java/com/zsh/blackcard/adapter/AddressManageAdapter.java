package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.AddressManageModel;

import java.util.List;

/**
 * Name: AddressManageAdapter
 * Author: SNXJ
 * Date: 2017-11-24
 * Description:描述：
 */
public class AddressManageAdapter extends BaseQuickAdapter<AddressManageModel.PdBean, BaseViewHolder> {
    @Override
    protected void convert(BaseViewHolder helper, AddressManageModel.PdBean item) {
        helper.setText(R.id.tv_name, item.getCONSIGNEE());
        helper.setText(R.id.tv_tel, item.getADRPHONE());
        helper.setText(R.id.tv_address, item.getADDRESS());
        helper.addOnClickListener(R.id.rb_set);
        helper.addOnClickListener(R.id.rb_edit);
        helper.addOnClickListener(R.id.rb_del);

    }

    public AddressManageAdapter(@Nullable List<AddressManageModel.PdBean> data) {
        super(R.layout.adress_manage_item, data);
    }
}
