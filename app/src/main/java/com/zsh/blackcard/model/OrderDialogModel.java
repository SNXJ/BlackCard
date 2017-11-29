package com.zsh.blackcard.model;

import java.io.Serializable;

/**
 * Name: OrderDialogModel
 * Author: SNXJ
 * Date: 2017-11-27
 * Description:订单
 */
public class OrderDialogModel implements Serializable {


    private String dj_return_id;//返回的订单ID
    private String dj_item_id;//条目的ID

    private String dj_top_name;
    private String dj_score;
    private String dj_check_in;

    private String dj_check_out;
    private String dj_check_count;
    private int dj_wifi;
    private int dj_pay;
    private int dj_park;
    private int dj_food;
    private int dj_swim;
    private int dj_fit;
    private String dj_item_name;//上
    private String dj_item_date;//中
    private String dj_item_des;//下
    private String dj_item_money;
    private String dj_item_img;
    private String dj_order_num;
    private String dj_order_name;
    private String dj_order_phone;
    private String dj_order_other;
    public String getDj_item_id() {
        return dj_item_id;
    }

    public void setDj_item_id(String dj_item_id) {
        this.dj_item_id = dj_item_id;
    }
    public String getDj_return_id() {
        return dj_return_id;
    }

    public void setDj_return_id(String dj_return_id) {
        this.dj_return_id = dj_return_id;
    }

    public String getDj_top_name() {
        return dj_top_name;
    }

    public void setDj_top_name(String dj_top_name) {
        this.dj_top_name = dj_top_name;
    }

    public String getDj_score() {
        return dj_score;
    }

    public void setDj_score(String dj_score) {
        this.dj_score = dj_score;
    }

    public String getDj_check_in() {
        return dj_check_in;
    }

    public void setDj_check_in(String dj_check_in) {
        this.dj_check_in = dj_check_in;
    }

    public String getDj_check_out() {
        return dj_check_out;
    }

    public void setDj_check_out(String dj_check_out) {
        this.dj_check_out = dj_check_out;
    }

    public String getDj_check_count() {
        return dj_check_count;
    }

    public void setDj_check_count(String dj_check_count) {
        this.dj_check_count = dj_check_count;
    }

    public int getDj_wifi() {
        return dj_wifi;
    }

    public void setDj_wifi(int dj_wifi) {
        this.dj_wifi = dj_wifi;
    }

    public int getDj_pay() {
        return dj_pay;
    }

    public void setDj_pay(int dj_pay) {
        this.dj_pay = dj_pay;
    }

    public int getDj_park() {
        return dj_park;
    }

    public void setDj_park(int dj_park) {
        this.dj_park = dj_park;
    }

    public int getDj_food() {
        return dj_food;
    }

    public void setDj_food(int dj_food) {
        this.dj_food = dj_food;
    }

    public int getDj_swim() {
        return dj_swim;
    }

    public void setDj_swim(int dj_swim) {
        this.dj_swim = dj_swim;
    }

    public int getDj_fit() {
        return dj_fit;
    }

    public void setDj_fit(int dj_fit) {
        this.dj_fit = dj_fit;
    }

    public String getDj_item_name() {
        return dj_item_name;
    }

    public void setDj_item_name(String dj_item_name) {
        this.dj_item_name = dj_item_name;
    }

    public String getDj_item_date() {
        return dj_item_date;
    }

    public void setDj_item_date(String dj_item_date) {
        this.dj_item_date = dj_item_date;
    }

    public String getDj_item_des() {
        return dj_item_des;
    }

    public void setDj_item_des(String dj_item_des) {
        this.dj_item_des = dj_item_des;
    }

    public String getDj_item_money() {
        return dj_item_money;
    }

    public void setDj_item_money(String dj_item_money) {
        this.dj_item_money = dj_item_money;
    }

    public String getDj_item_img() {
        return dj_item_img;
    }

    public void setDj_item_img(String dj_item_img) {
        this.dj_item_img = dj_item_img;
    }

    public String getDj_order_num() {
        return dj_order_num;
    }

    public void setDj_order_num(String dj_order_num) {
        this.dj_order_num = dj_order_num;
    }

    public String getDj_order_name() {
        return dj_order_name;
    }

    public void setDj_order_name(String dj_order_name) {
        this.dj_order_name = dj_order_name;
    }

    public String getDj_order_phone() {
        return dj_order_phone;
    }

    public void setDj_order_phone(String dj_order_phone) {
        this.dj_order_phone = dj_order_phone;
    }

    public String getDj_order_other() {
        return dj_order_other;
    }

    public void setDj_order_other(String dj_order_other) {
        this.dj_order_other = dj_order_other;
    }
}
