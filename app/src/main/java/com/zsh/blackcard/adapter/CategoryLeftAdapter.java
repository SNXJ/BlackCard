package com.zsh.blackcard.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.CategoryLeftModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Name: CategoryLeftAdapter
 * Author: SNXJ
 * Date: 2017-11-12
 * Description:
 * 尊购界面商品分类左边列表 适配器
 */
public class CategoryLeftAdapter extends BaseQuickAdapter<CategoryLeftModel.PdBean, BaseViewHolder> {

    private List<Boolean> list = new ArrayList<>();

    public CategoryLeftAdapter(int layoutResId, @Nullable List<CategoryLeftModel.PdBean> data) {
        super(layoutResId, data);
        //根据boolean的状态给不同的item设置不同的背景颜色
        for (int i = 0; i < data.size(); i++) {
            if (i == 0) {
                list.add(true);
            } else {
                list.add(false);
            }
        }
    }

    @Override
    protected void convert(BaseViewHolder helper, CategoryLeftModel.PdBean item) {
        if (list.get(helper.getLayoutPosition())) {
            helper.setBackgroundColor(R.id.category_linear, Color.parseColor("#141414"));
        } else {
            helper.setBackgroundColor(R.id.category_linear, Color.parseColor("#0B0B0B"));
        }
        helper.setText(R.id.category_left_tv, item.getBRANDBANE());
    }

    public void selectState(int position) {
        for (int i = 0; i < list.size(); i++) {
            if (i == position) {
                list.set(position,true);
            }else{
                list.set(i,false);
            }
        }
    }
}
