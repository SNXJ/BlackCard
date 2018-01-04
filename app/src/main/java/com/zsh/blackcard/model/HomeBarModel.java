package com.zsh.blackcard.model;

import java.util.List;

/**
 * Name: HomeHotelModel
 * Author: SNXJ
 * Date: 2017-11-22
 * Description:描述：
 */
public class HomeBarModel {

    /**
     * result : 01
     * ad : [{"SHOWIMG":"http://47.104.16.215:8088/advertisementimgs/56c2c472c4844526934ec4b1822f70f3.png","AD_POSITION":"0","RELATED_ID":"2","CLICK_COUNT":0,"SORT_ORDER":1,"LINK_URL":"","ADVERTISEMENT_ID":"396315145342550016","NAME":""},{"SHOWIMG":"http://47.104.16.215:8088/advertisementimgs/7e65ca75d27b419281fe6ff69deeacfa.png","AD_POSITION":"0","RELATED_ID":"2","CLICK_COUNT":0,"SORT_ORDER":2,"LINK_URL":"","ADVERTISEMENT_ID":"396315396229038080","NAME":""},{"SHOWIMG":"http://47.104.16.215:8088/advertisementimgs/5e49c8eb16154a628fdac9d96d4b8230.png","AD_POSITION":"0","RELATED_ID":"2","CLICK_COUNT":0,"SORT_ORDER":3,"LINK_URL":"","ADVERTISEMENT_ID":"396315711254822912","NAME":""}]
     * pd : [{"SORTBAR_ID":"385367746201780224","SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sortbarimgs/sortbarshowimgs/99fd5e8f94304938a374668652f781c3.png","BARADDRESS":"北京市 北京市 丰台区  ","distance":"13.440160937693182","BARPRICE":111,"BARNAMES":"Janes and Hooch(双井店)","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"},{"SORTBAR_ID":"385374599321223168","SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sortbarimgs/sortbarshowimgs/d339ffbdaa404d5baf16a30b06f6ca16.png","BARADDRESS":"北京市 北京市 顺义区  ","distance":"23.69741882716209","BARPRICE":11,"BARNAMES":"The Tiki Bungalow(顺义店)","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"}]
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
         * SHOWIMG : http://47.104.16.215:8088/advertisementimgs/56c2c472c4844526934ec4b1822f70f3.png
         * AD_POSITION : 0
         * RELATED_ID : 2
         * CLICK_COUNT : 0
         * SORT_ORDER : 1
         * LINK_URL :
         * ADVERTISEMENT_ID : 396315145342550016
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
         * SORTBAR_ID : 385367746201780224
         * SHOWIMAGES : http://47.104.16.215:8088/sortimgs/sortbarimgs/sortbarshowimgs/99fd5e8f94304938a374668652f781c3.png
         * BARADDRESS : 北京市 北京市 丰台区
         * distance : 13.440160937693182
         * BARPRICE : 111.0
         * BARNAMES : Janes and Hooch(双井店)
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         */

        private double BAREVALUATE;
        private String SORTBAR_ID;
        private String SHOWIMAGES;
        private String BARADDRESS;
        private String distance;
        private double BARPRICE;
        private String BARNAMES;
        private String HONOURUSER_ID;
        private int BAREVACOUNT;

        public double getBAREVALUATE() {
            return BAREVALUATE;
        }

        public void setBAREVALUATE(double BAREVALUATE) {
            this.BAREVALUATE = BAREVALUATE;
        }

        public int getBAREVACOUNT() {
            return BAREVACOUNT;
        }

        public void setBAREVACOUNT(int BAREVACOUNT) {
            this.BAREVACOUNT = BAREVACOUNT;
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

        public String getBARADDRESS() {
            return BARADDRESS;
        }

        public void setBARADDRESS(String BARADDRESS) {
            this.BARADDRESS = BARADDRESS;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public double getBARPRICE() {
            return BARPRICE;
        }

        public void setBARPRICE(double BARPRICE) {
            this.BARPRICE = BARPRICE;
        }

        public String getBARNAMES() {
            return BARNAMES;
        }

        public void setBARNAMES(String BARNAMES) {
            this.BARNAMES = BARNAMES;
        }

        public String getHONOURUSER_ID() {
            return HONOURUSER_ID;
        }

        public void setHONOURUSER_ID(String HONOURUSER_ID) {
            this.HONOURUSER_ID = HONOURUSER_ID;
        }
    }
}
