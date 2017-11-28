package com.zsh.blackcard.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kkkkk on 2017/11/28.
 * 订单中心订单筛选适配器
 */

public class ZgOrderCenterAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    private List<Boolean> list = new ArrayList<>();

    public ZgOrderCenterAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
        //初始化列表选择事项
        for (int i = 0; i < 8; i++) {
            if (i == 0) {
                list.add(true);
            } else {
                list.add(false);
            }
        }

    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.zg_my_order_popWindow_item_tv, item);
        if (list.get(helper.getLayoutPosition())) {
            helper.setTextColor(R.id.zg_my_order_popWindow_item_tv, Color.parseColor("#FFF29E19"));
            helper.setBackgroundRes(R.id.zg_my_order_popWindow_item_tv, R.drawable.group_11);
        } else {
            helper.setTextColor(R.id.zg_my_order_popWindow_item_tv, Color.parseColor("#FF929292"));
            helper.setBackgroundRes(R.id.zg_my_order_popWindow_item_tv, R.drawable.group_10);
        }
    }

    public void initSelect(int position) {
        for (int i = 0; i < 8; i++) {
            if (i == position) {
                list.set(position, true);
            } else {
                list.set(i, false);
            }
        }
    }
}
