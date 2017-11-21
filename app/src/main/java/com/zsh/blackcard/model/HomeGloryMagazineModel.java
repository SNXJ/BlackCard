package com.zsh.blackcard.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by kkkkk on 2017/11/21.
 * 荣耀杂志实体类
 */

public class HomeGloryMagazineModel implements MultiItemEntity{

    public static final int LEFT = 1;
    public static final int CENTER = 2;
    public static final int RIGHT = 3;

    private int itemType;

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
