package com.zsh.blackcard.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by kkkkk on 2017/11/18.
 */

public class MyOrderModel implements MultiItemEntity {

    //全部
    public static final int ALL = 1;
    //待付款
    public static final int PAYMENT = 2;
    //待收货
    public static final int RECEIPT = 3;
    //待评价
    public static final int COMMENT = 4;
    //退款售后
    public static final int SEVICE = 5;

    private int itemType;

    public MyOrderModel(int itemType){
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
