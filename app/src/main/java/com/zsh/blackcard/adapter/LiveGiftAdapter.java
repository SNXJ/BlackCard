package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.GiftTempModel;

import java.util.List;


/**
 * Name: LiveGiftAdapter
 * Author: Shing
 * Date: 2018/2/1 下午3:28
 * Description: ..
 */

public class LiveGiftAdapter extends BaseQuickAdapter<GiftTempModel, BaseViewHolder> {

    private int selectItem = -1;

    public LiveGiftAdapter(@Nullable List<GiftTempModel> data) {
        super(R.layout.live_gift_recycle_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GiftTempModel item) {

        helper.setText(R.id.tv_name, item.getName());
        helper.setText(R.id.tv_money, item.getMoney() + "黑咖币");
        helper.getView(R.id.image_view).setBackgroundResource(item.getImage());
        int position = helper.getAdapterPosition();
        if (selectItem != -1) {
            if (selectItem == position) {

                helper.getView(R.id.ll_layout).setBackgroundResource(R.drawable.selector_gift_selected);
            } else {//bug
                helper.getView(R.id.ll_layout).setBackground(null);
            }
        } else {
            helper.getView(R.id.ll_layout).setBackground(null);
        }


    }

    public void setSelect(int position) {
        this.selectItem = position;
        notifyDataSetChanged();


    }
}
