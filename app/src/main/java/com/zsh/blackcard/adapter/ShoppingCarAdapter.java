package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.untils.UIUtils;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/25.
 * 购物车列表适配器
 */

public class ShoppingCarAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public ShoppingCarAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.addOnClickListener(R.id.shopping_car_item_right_delete);
    }
}
