package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;
import android.widget.CheckBox;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.AddressManageModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Name: AddressManageAdapter
 * Author: SNXJ
 * Date: 2017-11-24
 * Description:描述：
 */
public class AddressManageAdapter extends BaseQuickAdapter<AddressManageModel.PdBean, BaseViewHolder> {

    private List<Boolean> booleanList = new ArrayList<>();

    @Override
    protected void convert(BaseViewHolder helper, AddressManageModel.PdBean item) {
        helper.setText(R.id.tv_name, item.getCONSIGNEE());
        helper.setText(R.id.tv_tel, item.getADRPHONE());
        helper.setText(R.id.tv_address, item.getADDRESS());
        helper.addOnClickListener(R.id.cb_set);
        helper.addOnClickListener(R.id.rb_edit);
        helper.addOnClickListener(R.id.rb_del);
        if (booleanList.get(helper.getLayoutPosition())) {
            ((CheckBox) helper.getView(R.id.cb_set)).setChecked(true);
        } else {
            ((CheckBox) helper.getView(R.id.cb_set)).setChecked(false);
        }
    }

    public AddressManageAdapter(@Nullable List<AddressManageModel.PdBean> data) {
        super(R.layout.adress_manage_item, data);
        for (int i = 0; i < data.size(); i++) {
            booleanList.add(false);
        }
    }

    public void initSelect(int position, boolean b) {
        for (int i = 0; i < booleanList.size(); i++) {
            if (i == position) {
                booleanList.set(i, b);
            } else {
                booleanList.set(i, false);
            }
        }
    }

    public void initBoolean(int size) {
        for (int i = booleanList.size()-1; i < size; i++) {
            booleanList.add(false);
        }
    }
}
