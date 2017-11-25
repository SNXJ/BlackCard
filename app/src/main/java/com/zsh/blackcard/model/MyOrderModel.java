package com.zsh.blackcard.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/18.
 */

public class MyOrderModel {
    /**
     * result : 01
     * pd : [{"ORDERMONEY":1200.5,"PROTITLE":"天梭手表的标题","PROSHOWIMG":"http://47.104.16.215:8088/productimgs/productshowimgs/c8a97a262b8640f2aae2305507332405.png","ORDERSTATUS":"待收货","PRODUCT_ID":"383674340182327296","PRODUCTCOUNT":2,"HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"}]
     */

    private String result;
    private List<PdBean> pd;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<PdBean> getPd() {
        return pd;
    }

    public void setPd(List<PdBean> pd) {
        this.pd = pd;
    }

    public static class PdBean implements MultiItemEntity{
        /**
         * ORDERMONEY : 1200.5
         * PROTITLE : 天梭手表的标题
         * PROSHOWIMG : http://47.104.16.215:8088/productimgs/productshowimgs/c8a97a262b8640f2aae2305507332405.png
         * ORDERSTATUS : 待收货
         * PRODUCT_ID : 383674340182327296
         * PRODUCTCOUNT : 2
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         */


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

        public void setItemType(int itemType) {
            this.itemType = itemType;
        }

        private int itemType;

        @Override
        public int getItemType() {
            return itemType;
        }

        private double ORDERMONEY;
        private String PROTITLE;
        private String PROSHOWIMG;
        private String ORDERSTATUS;
        private String PRODUCT_ID;
        private int PRODUCTCOUNT;
        private String HONOURUSER_ID;

        public double getORDERMONEY() {
            return ORDERMONEY;
        }

        public void setORDERMONEY(double ORDERMONEY) {
            this.ORDERMONEY = ORDERMONEY;
        }

        public String getPROTITLE() {
            return PROTITLE;
        }

        public void setPROTITLE(String PROTITLE) {
            this.PROTITLE = PROTITLE;
        }

        public String getPROSHOWIMG() {
            return PROSHOWIMG;
        }

        public void setPROSHOWIMG(String PROSHOWIMG) {
            this.PROSHOWIMG = PROSHOWIMG;
        }

        public String getORDERSTATUS() {
            return ORDERSTATUS;
        }

        public void setORDERSTATUS(String ORDERSTATUS) {
            this.ORDERSTATUS = ORDERSTATUS;
        }

        public String getPRODUCT_ID() {
            return PRODUCT_ID;
        }

        public void setPRODUCT_ID(String PRODUCT_ID) {
            this.PRODUCT_ID = PRODUCT_ID;
        }

        public int getPRODUCTCOUNT() {
            return PRODUCTCOUNT;
        }

        public void setPRODUCTCOUNT(int PRODUCTCOUNT) {
            this.PRODUCTCOUNT = PRODUCTCOUNT;
        }

        public String getHONOURUSER_ID() {
            return HONOURUSER_ID;
        }

        public void setHONOURUSER_ID(String HONOURUSER_ID) {
            this.HONOURUSER_ID = HONOURUSER_ID;
        }
    }
}
