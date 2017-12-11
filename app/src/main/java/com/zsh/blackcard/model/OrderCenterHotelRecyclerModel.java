package com.zsh.blackcard.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by kkkkk on 2017/12/4.
 * 订单中心酒店订单实体类
 */

public class OrderCenterHotelRecyclerModel {

    /**
     * result : 01
     * pd : [{"ORDERMONEY":444,"SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sorthotelimgs/sorthotelshowimgs/eb835e3bba61461296aa88b443c3da43.png","HOTELDETNAME":"豪华双人间","ORDERSTATUS":"0040001","SORTHOTEL_ID":"385471958017376256","HOTELORDER_ID":"387245460571553792","HOTELDETAIL_ID":"385731450864926720","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"},{"ORDERMONEY":444,"SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sorthotelimgs/sorthotelshowimgs/8881d2f0170f42bfb00ea52aaa140787.png","HOTELDETNAME":"豪华单人间","ORDERSTATUS":"0040001","SORTHOTEL_ID":"385472311504928768","HOTELORDER_ID":"387245472948944896","HOTELDETAIL_ID":"385731874523185152","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"}]
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
         * ORDERMONEY : 444
         * SHOWIMAGES : http://47.104.16.215:8088/sortimgs/sorthotelimgs/sorthotelshowimgs/eb835e3bba61461296aa88b443c3da43.png
         * HOTELDETNAME : 豪华双人间
         * ORDERSTATUS : 0040001
         * SORTHOTEL_ID : 385471958017376256
         * HOTELORDER_ID : 387245460571553792
         * HOTELDETAIL_ID : 385731450864926720
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         */

        private int ORDERMONEY;
        private String SHOWIMAGES;
        private String HOTELDETNAME;
        private String ORDERSTATUS;
        private String SORTHOTEL_ID;
        private String HOTELORDER_ID;
        private String HOTELDETAIL_ID;
        private String HONOURUSER_ID;

        public int getORDERMONEY() {
            return ORDERMONEY;
        }

        public void setORDERMONEY(int ORDERMONEY) {
            this.ORDERMONEY = ORDERMONEY;
        }

        public String getSHOWIMAGES() {
            return SHOWIMAGES;
        }

        public void setSHOWIMAGES(String SHOWIMAGES) {
            this.SHOWIMAGES = SHOWIMAGES;
        }

        public String getHOTELDETNAME() {
            return HOTELDETNAME;
        }

        public void setHOTELDETNAME(String HOTELDETNAME) {
            this.HOTELDETNAME = HOTELDETNAME;
        }

        public String getORDERSTATUS() {
            return ORDERSTATUS;
        }

        public void setORDERSTATUS(String ORDERSTATUS) {
            this.ORDERSTATUS = ORDERSTATUS;
        }

        public String getSORTHOTEL_ID() {
            return SORTHOTEL_ID;
        }

        public void setSORTHOTEL_ID(String SORTHOTEL_ID) {
            this.SORTHOTEL_ID = SORTHOTEL_ID;
        }

        public String getHOTELORDER_ID() {
            return HOTELORDER_ID;
        }

        public void setHOTELORDER_ID(String HOTELORDER_ID) {
            this.HOTELORDER_ID = HOTELORDER_ID;
        }

        public String getHOTELDETAIL_ID() {
            return HOTELDETAIL_ID;
        }

        public void setHOTELDETAIL_ID(String HOTELDETAIL_ID) {
            this.HOTELDETAIL_ID = HOTELDETAIL_ID;
        }

        public String getHONOURUSER_ID() {
            return HONOURUSER_ID;
        }

        public void setHONOURUSER_ID(String HONOURUSER_ID) {
            this.HONOURUSER_ID = HONOURUSER_ID;
        }

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

        @Override
        public int getItemType() {
            return itemType;
        }
    }
}
