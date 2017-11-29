package com.zsh.blackcard.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.MyOrderModel;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/18.
 */

public class MyOrderCenterAdapter extends BaseMultiItemQuickAdapter<MyOrderModel.PdBean, BaseViewHolder> {


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MyOrderCenterAdapter(List<MyOrderModel.PdBean> data) {
        super(data);
        addItemType(MyOrderModel.PdBean.PAYMENT, R.layout.my_order_payment_item);
        addItemType(MyOrderModel.PdBean.RECEIPT, R.layout.my_order_receipt_item);
        addItemType(MyOrderModel.PdBean.COMMENT, R.layout.my_order_comment_item);
        addItemType(MyOrderModel.PdBean.SEVICE, R.layout.my_order_service_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyOrderModel.PdBean item) {
        Glide.with(mContext).load(item.getPROSHOWIMG()).into((ImageView) helper.getView(R.id.my_order_img));
        helper.setText(R.id.my_order_title_tv, item.getPROTITLE());
    }
}
