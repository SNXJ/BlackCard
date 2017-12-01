package com.zsh.blackcard.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.OrderCenterBarRecyclerModel;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/18.
 */

public class MyOrderCenterOtherAdapter extends BaseMultiItemQuickAdapter<OrderCenterBarRecyclerModel.PdBean, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MyOrderCenterOtherAdapter(List<OrderCenterBarRecyclerModel.PdBean> data) {
        super(data);
        addItemType(OrderCenterBarRecyclerModel.PdBean.PAYMENT, R.layout.my_order_payment_item);
        addItemType(OrderCenterBarRecyclerModel.PdBean.USE, R.layout.my_order_use_item);
        addItemType(OrderCenterBarRecyclerModel.PdBean.COMMENT, R.layout.my_order_comment_item);

    }

    @Override
    protected void convert(BaseViewHolder helper, OrderCenterBarRecyclerModel.PdBean item) {

    }
}
