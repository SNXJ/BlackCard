package com.zsh.blackcard.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by kkkkk on 2017/12/4.
 * 订单中心全部美食订单实体类
 */

public class OrderCenterFoodRecyclerModel {

    /**
     * result : 01
     * pd : [{"ORDERMONEY":199,"SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sortfoodimgs/sortfoodshowimgs/ca48ec53999a4adfaff3a0c8f84cf531.png","FOODDETAIL_ID":"387192633518194688","SORTFOOD_ID":"382585520535896064","ORDERSTATUS":"0040001","FOODDETNAME":"双人套餐","FOODORDER_ID":"387239364465262592","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"},{"ORDERMONEY":369,"SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sortfoodimgs/sortfoodshowimgs/ca48ec53999a4adfaff3a0c8f84cf531.png","FOODDETAIL_ID":"387192778943102976","SORTFOOD_ID":"382585520535896064","ORDERSTATUS":"0040002","FOODDETNAME":"四人套餐","FOODORDER_ID":"387254974045749248","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"},{"ORDERMONEY":132,"SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sortfoodimgs/sortfoodshowimgs/9c576b0cdfd94c388b1dc48cc37fd4a7.png","FOODDETAIL_ID":"387197228994789376","SORTFOOD_ID":"382585869963362304","ORDERSTATUS":"0040002","FOODDETNAME":"午市双人套餐","FOODORDER_ID":"387255391395774464","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"}]
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
         * ORDERMONEY : 199
         * SHOWIMAGES : http://47.104.16.215:8088/sortimgs/sortfoodimgs/sortfoodshowimgs/ca48ec53999a4adfaff3a0c8f84cf531.png
         * FOODDETAIL_ID : 387192633518194688
         * SORTFOOD_ID : 382585520535896064
         * ORDERSTATUS : 0040001
         * FOODDETNAME : 双人套餐
         * FOODORDER_ID : 387239364465262592
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         */

        private int ORDERMONEY;
        private String SHOWIMAGES;
        private String FOODDETAIL_ID;
        private String SORTFOOD_ID;
        private String ORDERSTATUS;
        private String FOODDETNAME;
        private String FOODORDER_ID;
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

        public String getFOODDETAIL_ID() {
            return FOODDETAIL_ID;
        }

        public void setFOODDETAIL_ID(String FOODDETAIL_ID) {
            this.FOODDETAIL_ID = FOODDETAIL_ID;
        }

        public String getSORTFOOD_ID() {
            return SORTFOOD_ID;
        }

        public void setSORTFOOD_ID(String SORTFOOD_ID) {
            this.SORTFOOD_ID = SORTFOOD_ID;
        }

        public String getORDERSTATUS() {
            return ORDERSTATUS;
        }

        public void setORDERSTATUS(String ORDERSTATUS) {
            this.ORDERSTATUS = ORDERSTATUS;
        }

        public String getFOODDETNAME() {
            return FOODDETNAME;
        }

        public void setFOODDETNAME(String FOODDETNAME) {
            this.FOODDETNAME = FOODDETNAME;
        }

        public String getFOODORDER_ID() {
            return FOODORDER_ID;
        }

        public void setFOODORDER_ID(String FOODORDER_ID) {
            this.FOODORDER_ID = FOODORDER_ID;
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
