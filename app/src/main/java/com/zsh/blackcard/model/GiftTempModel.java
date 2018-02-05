package com.zsh.blackcard.model;

/**
 * Name: GiftTempModel
 * Author: Shing
 * Date: 2018/2/1 下午4:37
 * Description: ..
 */

public class GiftTempModel {

    private String name;
    private String money;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    private Integer image;
}
