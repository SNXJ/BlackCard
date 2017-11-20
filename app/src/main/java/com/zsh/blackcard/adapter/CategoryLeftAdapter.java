package com.zsh.blackcard.adapter;

import android.graphics.Color;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;

import java.util.List;

/**
 * Name: CategoryLeftAdapter
 * Author: SNXJ
 * Date: 2017-11-12
 * Description:描述：
 */
public class CategoryLeftAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    private int selectPos = 0;

    public CategoryLeftAdapter(List<String> data) {
        super(R.layout.category_left_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String str) {
        if (selectPos == helper.getAdapterPosition()) {
            helper.setVisible(R.id.item_category_left_bg, true);
            helper.convertView.setBackgroundColor(Color.parseColor("#FFFFFF"));
            helper.setTextColor(R.id.item_category_left_type, Color.parseColor("#40a5f3"));
        } else {
            helper.convertView.setBackgroundColor(Color.parseColor("#f7f7f7"));
            helper.setTextColor(R.id.item_category_left_type, Color.parseColor("#333333"));
            helper.setVisible(R.id.item_category_left_bg, false);
        }

        helper.setText(R.id.item_category_left_type, str);

    }


    public int getSelectPos() {
        return selectPos;
    }

    public void setSelectPos(int selectPos) {
        this.selectPos = selectPos;
    }
}
