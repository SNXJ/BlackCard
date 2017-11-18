package com.zsh.blackcard.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.MyOrderModel;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/18.
 */

public class MyOrderCenterAdapter extends BaseMultiItemQuickAdapter<MyOrderModel, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MyOrderCenterAdapter(List<MyOrderModel> data) {
        super(data);
        addItemType(MyOrderModel.PAYMENT, R.layout.my_order_payment_item);
        addItemType(MyOrderModel.RECEIPT, R.layout.my_order_receipt_item);
        addItemType(MyOrderModel.COMMENT, R.layout.my_order_comment_item);
        addItemType(MyOrderModel.SEVICE, R.layout.my_order_service_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyOrderModel item) {
        switch (helper.getItemViewType()) {
            case MyOrderModel.PAYMENT:

                break;
            case MyOrderModel.RECEIPT:

                break;
            case MyOrderModel.COMMENT:

                break;
            case MyOrderModel.SEVICE:

                break;
        }
    }
}
