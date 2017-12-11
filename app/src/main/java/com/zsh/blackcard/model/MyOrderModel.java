package com.zsh.blackcard.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/18.
 */

public class MyOrderModel {

    /**
     * result : 01
     * pd : [{"ORDERMONEY":1200.5,"ORDER_ID":"383318869894234112","ORDERNUMBER":"171123181220423d27c","PROTITLE":"天梭手表的标题","PROSHOWIMG":"http://47.104.16.215:8088/productimgs/productshowimgs/c8a97a262b8640f2aae2305507332405.png","ORDERSTATUS":"待收货","PRODUCT_ID":"383674340182327296","PRODUCTCOUNT":2,"HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"},{"ORDERMONEY":25000,"ORDER_ID":"383318869894234113","ORDERNUMBER":"171123181220423d872","PROTITLE":"天梭手表的标题","PROSHOWIMG":"http://47.104.16.215:8088/productimgs/productshowimgs/c8a97a262b8640f2aae2305507332405.png","ORDERSTATUS":"待付款","PRODUCT_ID":"383674340182327296","PRODUCTCOUNT":3,"HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"},{"ORDERMONEY":28888,"ORDER_ID":"385136652479102976","ORDERNUMBER":"171128183533697d27c","PROTITLE":"天梭手表的标题","PROSHOWIMG":"http://47.104.16.215:8088/productimgs/productshowimgs/c8a97a262b8640f2aae2305507332405.png","ORDERSTATUS":"待付款","PRODUCT_ID":"383674340182327296","PRODUCTCOUNT":1,"HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"},{"ORDERMONEY":86664,"ORDER_ID":"385137942009479168","ORDERNUMBER":"171128184040749d27c","PROTITLE":"天梭手表的标题","PROSHOWIMG":"http://47.104.16.215:8088/productimgs/productshowimgs/c8a97a262b8640f2aae2305507332405.png","ORDERSTATUS":"待付款","PRODUCT_ID":"383674340182327296","PRODUCTCOUNT":3,"HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"}]
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

    public static class PdBean implements MultiItemEntity {
        /**
         * ORDERMONEY : 1200.5
         * ORDER_ID : 383318869894234112
         * ORDERNUMBER : 171123181220423d27c
         * PROTITLE : 天梭手表的标题
         * PROSHOWIMG : http://47.104.16.215:8088/productimgs/productshowimgs/c8a97a262b8640f2aae2305507332405.png
         * ORDERSTATUS : 待收货
         * PRODUCT_ID : 383674340182327296
         * PRODUCTCOUNT : 2
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         */

        private double ORDERMONEY;
        private String ORDER_ID;
        private String ORDERNUMBER;
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

        public String getORDER_ID() {
            return ORDER_ID;
        }

        public void setORDER_ID(String ORDER_ID) {
            this.ORDER_ID = ORDER_ID;
        }

        public String getORDERNUMBER() {
            return ORDERNUMBER;
        }

        public void setORDERNUMBER(String ORDERNUMBER) {
            this.ORDERNUMBER = ORDERNUMBER;
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
    }
}
