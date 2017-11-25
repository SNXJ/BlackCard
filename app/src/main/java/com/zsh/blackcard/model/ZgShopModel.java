package com.zsh.blackcard.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by kkkkk on 2017/11/22.
 * 尊购页面 商品专区实体类，例如手表，包袋，首饰等
 */

public class ZgShopModel implements MultiItemEntity {

    public static final int LEFT = 1;
    public static final int RIGHT = 2;

    private int itemType;

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
