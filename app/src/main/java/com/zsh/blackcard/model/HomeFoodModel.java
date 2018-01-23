package com.zsh.blackcard.model;

import java.util.List;

/**
 * Name: HomeFoodModel
 * Author: SNXJ
 * Date: 2017-11-22
 * Description:描述：
 */
public class HomeFoodModel {

    /**
     * result : 01
     * ad : [{"SHOWIMG":"http://47.104.16.215:8088/advertisementimgs/b698eb47e2fd488e8801b8f775c8cc37.png","AD_POSITION":"0","RELATED_ID":"0","CLICK_COUNT":0,"SORT_ORDER":1,"LINK_URL":"","ADVERTISEMENT_ID":"396312541355048960","NAME":""},{"SHOWIMG":"http://47.104.16.215:8088/advertisementimgs/b1f3c4d9702046a181adcfef37d80059.png","AD_POSITION":"0","RELATED_ID":"0","CLICK_COUNT":0,"SORT_ORDER":2,"LINK_URL":"","ADVERTISEMENT_ID":"396312908310511616","NAME":""},{"SHOWIMG":"http://47.104.16.215:8088/advertisementimgs/c2641301148e4c2799e89b6489cdbf5d.png","AD_POSITION":"0","RELATED_ID":"0","CLICK_COUNT":0,"SORT_ORDER":3,"LINK_URL":"","ADVERTISEMENT_ID":"396313209738362880","NAME":""}]
     * pd : [{"SHOPPRICE":399,"SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sortfoodimgs/sortfoodshowimgs/ca48ec53999a4adfaff3a0c8f84cf531.png","SHOPADDRESS":"北京市 北京市 朝阳区 潘家园路 甲1号","SORTFOOD_ID":"382585520535896064","distance":"5.942040455075951","SHOPEVACOUNT":6,"SHOPNAMES":"菲罗牛排主题自助西餐厅","SHOPEVALUATE":3.2,"HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"},{"SHOPPRICE":299,"SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sortfoodimgs/sortfoodshowimgs/9c576b0cdfd94c388b1dc48cc37fd4a7.png","SHOPADDRESS":"北京市 北京市 朝阳区 广渠路 52号","SORTFOOD_ID":"382585869963362304","distance":"5.050353703962636","SHOPEVACOUNT":2,"SHOPNAMES":"海底捞火锅(双井店)","SHOPEVALUATE":2.8,"HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"}]
     */

    private String result;
    private List<AdBean> ad;
    private List<PdBean> pd;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<AdBean> getAd() {
        return ad;
    }

    public void setAd(List<AdBean> ad) {
        this.ad = ad;
    }

    public List<PdBean> getPd() {
        return pd;
    }

    public void setPd(List<PdBean> pd) {
        this.pd = pd;
    }

    public static class AdBean {
        /**
         * SHOWIMG : http://47.104.16.215:8088/advertisementimgs/b698eb47e2fd488e8801b8f775c8cc37.png
         * AD_POSITION : 0
         * RELATED_ID : 0
         * CLICK_COUNT : 0
         * SORT_ORDER : 1
         * LINK_URL :
         * ADVERTISEMENT_ID : 396312541355048960
         * NAME :
         */

        private String SHOWIMG;
        private String AD_POSITION;
        private String RELATED_ID;
        private int CLICK_COUNT;
        private int SORT_ORDER;
        private String LINK_URL;
        private String ADVERTISEMENT_ID;
        private String NAME;

        public String getSHOWIMG() {
            return SHOWIMG;
        }

        public void setSHOWIMG(String SHOWIMG) {
            this.SHOWIMG = SHOWIMG;
        }

        public String getAD_POSITION() {
            return AD_POSITION;
        }

        public void setAD_POSITION(String AD_POSITION) {
            this.AD_POSITION = AD_POSITION;
        }

        public String getRELATED_ID() {
            return RELATED_ID;
        }

        public void setRELATED_ID(String RELATED_ID) {
            this.RELATED_ID = RELATED_ID;
        }

        public int getCLICK_COUNT() {
            return CLICK_COUNT;
        }

        public void setCLICK_COUNT(int CLICK_COUNT) {
            this.CLICK_COUNT = CLICK_COUNT;
        }

        public int getSORT_ORDER() {
            return SORT_ORDER;
        }

        public void setSORT_ORDER(int SORT_ORDER) {
            this.SORT_ORDER = SORT_ORDER;
        }

        public String getLINK_URL() {
            return LINK_URL;
        }

        public void setLINK_URL(String LINK_URL) {
            this.LINK_URL = LINK_URL;
        }

        public String getADVERTISEMENT_ID() {
            return ADVERTISEMENT_ID;
        }

        public void setADVERTISEMENT_ID(String ADVERTISEMENT_ID) {
            this.ADVERTISEMENT_ID = ADVERTISEMENT_ID;
        }

        public String getNAME() {
            return NAME;
        }

        public void setNAME(String NAME) {
            this.NAME = NAME;
        }
    }

    public static class PdBean {
        /**
         * SHOPPRICE : 399
         * SHOWIMAGES : http://47.104.16.215:8088/sortimgs/sortfoodimgs/sortfoodshowimgs/ca48ec53999a4adfaff3a0c8f84cf531.png
         * SHOPADDRESS : 北京市 北京市 朝阳区 潘家园路 甲1号
         * SORTFOOD_ID : 382585520535896064
         * distance : 5.942040455075951
         * SHOPEVACOUNT : 6
         * SHOPNAMES : 菲罗牛排主题自助西餐厅
         * SHOPEVALUATE : 3.2
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         */

        private int SHOPPRICE;
        private String SHOWIMAGES;
        private String SHOPADDRESS;
        private String SORTFOOD_ID;
        private String distance;
        private int SHOPEVACOUNT;
        private String SHOPNAMES;
        private double SHOPEVALUATE;
        private String HONOURUSER_ID;

        public int getSHOPPRICE() {
            return SHOPPRICE;
        }

        public void setSHOPPRICE(int SHOPPRICE) {
            this.SHOPPRICE = SHOPPRICE;
        }

        public String getSHOWIMAGES() {
            return SHOWIMAGES;
        }

        public void setSHOWIMAGES(String SHOWIMAGES) {
            this.SHOWIMAGES = SHOWIMAGES;
        }

        public String getSHOPADDRESS() {
            return SHOPADDRESS;
        }

        public void setSHOPADDRESS(String SHOPADDRESS) {
            this.SHOPADDRESS = SHOPADDRESS;
        }

        public String getSORTFOOD_ID() {
            return SORTFOOD_ID;
        }

        public void setSORTFOOD_ID(String SORTFOOD_ID) {
            this.SORTFOOD_ID = SORTFOOD_ID;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public int getSHOPEVACOUNT() {
            return SHOPEVACOUNT;
        }

        public void setSHOPEVACOUNT(int SHOPEVACOUNT) {
            this.SHOPEVACOUNT = SHOPEVACOUNT;
        }

        public String getSHOPNAMES() {
            return SHOPNAMES;
        }

        public void setSHOPNAMES(String SHOPNAMES) {
            this.SHOPNAMES = SHOPNAMES;
        }

        public double getSHOPEVALUATE() {
            return SHOPEVALUATE;
        }

        public void setSHOPEVALUATE(double SHOPEVALUATE) {
            this.SHOPEVALUATE = SHOPEVALUATE;
        }

        public String getHONOURUSER_ID() {
            return HONOURUSER_ID;
        }

        public void setHONOURUSER_ID(String HONOURUSER_ID) {
            this.HONOURUSER_ID = HONOURUSER_ID;
        }
    }
}
