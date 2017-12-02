package com.zsh.blackcard.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by kkkkk on 2017/12/2.
 * 订单在中心KTV全部订单列表
 */

public class OrderCenterKTVRecyclerModel {

    /**
     * result : 01
     * pd : [{"ORDERMONEY":216,"SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sortktvimgs/sortktvshowimgs/c955184693254a0db6da2b5296a86ad6.jpg","KTVDETAIL_ID":"f8c04beb271c43448cc77633e6cf3f51","SORTKTV_ID":"982e78719b9c42418f19fb8a85a18b09","KTVORDER_ID":"7aaa1624c66f4e1aace08cc298b589eb","ORDERSTATUS":"0040002","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","KTVDETTITLE":"阳光场套餐"},{"ORDERMONEY":116,"SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sortktvimgs/sortktvshowimgs/c955184693254a0db6da2b5296a86ad6.jpg","KTVDETAIL_ID":"f8c04beb271c43448cc77633e6cf3f51","SORTKTV_ID":"982e78719b9c42418f19fb8a85a18b09","KTVORDER_ID":"b1f3410e900743439ae8850611a9f5c7","ORDERSTATUS":"0040001","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","KTVDETTITLE":"阳光场套餐"},{"ORDERMONEY":2216,"SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sortktvimgs/sortktvshowimgs/c955184693254a0db6da2b5296a86ad6.jpg","KTVDETAIL_ID":"f8c04beb271c43448cc77633e6cf3f51","SORTKTV_ID":"982e78719b9c42418f19fb8a85a18b09","KTVORDER_ID":"ec4e8b44349d4b2a9f16422ace722f13","ORDERSTATUS":"0040001","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","KTVDETTITLE":"阳光场套餐"}]
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
         * ORDERMONEY : 216
         * SHOWIMAGES : http://47.104.16.215:8088/sortimgs/sortktvimgs/sortktvshowimgs/c955184693254a0db6da2b5296a86ad6.jpg
         * KTVDETAIL_ID : f8c04beb271c43448cc77633e6cf3f51
         * SORTKTV_ID : 982e78719b9c42418f19fb8a85a18b09
         * KTVORDER_ID : 7aaa1624c66f4e1aace08cc298b589eb
         * ORDERSTATUS : 0040002
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         * KTVDETTITLE : 阳光场套餐
         */

        private int ORDERMONEY;
        private String SHOWIMAGES;
        private String KTVDETAIL_ID;
        private String SORTKTV_ID;
        private String KTVORDER_ID;
        private String ORDERSTATUS;
        private String HONOURUSER_ID;
        private String KTVDETTITLE;

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

        public String getKTVDETAIL_ID() {
            return KTVDETAIL_ID;
        }

        public void setKTVDETAIL_ID(String KTVDETAIL_ID) {
            this.KTVDETAIL_ID = KTVDETAIL_ID;
        }

        public String getSORTKTV_ID() {
            return SORTKTV_ID;
        }

        public void setSORTKTV_ID(String SORTKTV_ID) {
            this.SORTKTV_ID = SORTKTV_ID;
        }

        public String getKTVORDER_ID() {
            return KTVORDER_ID;
        }

        public void setKTVORDER_ID(String KTVORDER_ID) {
            this.KTVORDER_ID = KTVORDER_ID;
        }

        public String getORDERSTATUS() {
            return ORDERSTATUS;
        }

        public void setORDERSTATUS(String ORDERSTATUS) {
            this.ORDERSTATUS = ORDERSTATUS;
        }

        public String getHONOURUSER_ID() {
            return HONOURUSER_ID;
        }

        public void setHONOURUSER_ID(String HONOURUSER_ID) {
            this.HONOURUSER_ID = HONOURUSER_ID;
        }

        public String getKTVDETTITLE() {
            return KTVDETTITLE;
        }

        public void setKTVDETTITLE(String KTVDETTITLE) {
            this.KTVDETTITLE = KTVDETTITLE;
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
