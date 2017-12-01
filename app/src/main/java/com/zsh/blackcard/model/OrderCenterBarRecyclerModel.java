package com.zsh.blackcard.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by kkkkk on 2017/12/1.
 * 订单中心，筛选酒吧的全部订单 实体类
 */

public class OrderCenterBarRecyclerModel {


    /**
     * result : 01
     * pd : [{"ORDERMONEY":210,"BARORDER_ID":"386196345607684096","SORTBAR_ID":"385374599321223168","SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sortbarimgs/sortbarshowimgs/d18e626a12ae45228f69acf717554953.png","BARDETTITLE":"酒吧套餐2","ORDERSTATUS":"0040001","BARDETAIL_ID":"384016591244754944","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"}]
     */

    private String result;
    private List<OrderCenterBarRecyclerModel.PdBean> pd;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<OrderCenterBarRecyclerModel.PdBean> getPd() {
        return pd;
    }

    public void setPd(List<OrderCenterBarRecyclerModel.PdBean> pd) {
        this.pd = pd;
    }

    public static class PdBean implements MultiItemEntity {
        /**
         * ORDERMONEY : 210
         * BARORDER_ID : 386196345607684096
         * SORTBAR_ID : 385374599321223168
         * SHOWIMAGES : http://47.104.16.215:8088/sortimgs/sortbarimgs/sortbarshowimgs/d18e626a12ae45228f69acf717554953.png
         * BARDETTITLE : 酒吧套餐2
         * ORDERSTATUS : 0040001
         * BARDETAIL_ID : 384016591244754944
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         */

        private double ORDERMONEY;
        private String BARORDER_ID;
        private String SORTBAR_ID;
        private String SHOWIMAGES;
        private String BARDETTITLE;
        private String ORDERSTATUS;
        private String BARDETAIL_ID;
        private String HONOURUSER_ID;

        public double getORDERMONEY() {
            return ORDERMONEY;
        }

        public void setORDERMONEY(int ORDERMONEY) {
            this.ORDERMONEY = ORDERMONEY;
        }

        public String getBARORDER_ID() {
            return BARORDER_ID;
        }

        public void setBARORDER_ID(String BARORDER_ID) {
            this.BARORDER_ID = BARORDER_ID;
        }

        public String getSORTBAR_ID() {
            return SORTBAR_ID;
        }

        public void setSORTBAR_ID(String SORTBAR_ID) {
            this.SORTBAR_ID = SORTBAR_ID;
        }

        public String getSHOWIMAGES() {
            return SHOWIMAGES;
        }

        public void setSHOWIMAGES(String SHOWIMAGES) {
            this.SHOWIMAGES = SHOWIMAGES;
        }

        public String getBARDETTITLE() {
            return BARDETTITLE;
        }

        public void setBARDETTITLE(String BARDETTITLE) {
            this.BARDETTITLE = BARDETTITLE;
        }

        public String getORDERSTATUS() {
            return ORDERSTATUS;
        }

        public void setORDERSTATUS(String ORDERSTATUS) {
            this.ORDERSTATUS = ORDERSTATUS;
        }

        public String getBARDETAIL_ID() {
            return BARDETAIL_ID;
        }

        public void setBARDETAIL_ID(String BARDETAIL_ID) {
            this.BARDETAIL_ID = BARDETAIL_ID;
        }

        public String getHONOURUSER_ID() {
            return HONOURUSER_ID;
        }

        public void setHONOURUSER_ID(String HONOURUSER_ID) {
            this.HONOURUSER_ID = HONOURUSER_ID;
        }

        @Override
        public int getItemType() {
            return itemType;
        }

        //全部
//        public static final int ALL = 1;
        //待付款
        public static final int PAYMENT = 2;
        //待使用
        public static final int USE = 3;
        //待评价
        public static final int COMMENT = 4;

        public void setItemType(int itemType) {
            this.itemType = itemType;
        }

        private int itemType;
    }
}
