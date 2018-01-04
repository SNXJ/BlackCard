package com.zsh.blackcard.model;

import java.util.List;

/**
 * Name: HomeHotelModel
 * Author: SNXJ
 * Date: 2017-11-22
 * Description:描述：
 */
public class HomeHotelModel {

    /**
     * result : 01
     * ad : [{"SHOWIMG":"http://47.104.16.215:8088/advertisementimgs/0683dfe5f3914319bbb2793ec2315dae.png","AD_POSITION":"0","RELATED_ID":"1","CLICK_COUNT":0,"SORT_ORDER":1,"LINK_URL":"","ADVERTISEMENT_ID":"396314154756997120","NAME":""},{"SHOWIMG":"http://47.104.16.215:8088/advertisementimgs/fefc9bbcadca494da30ee15fb8e2ff47.png","AD_POSITION":"0","RELATED_ID":"1","CLICK_COUNT":0,"SORT_ORDER":2,"LINK_URL":"","ADVERTISEMENT_ID":"396314339067297792","NAME":""},{"SHOWIMG":"http://47.104.16.215:8088/advertisementimgs/eb1a09e9000346e0899c15e0e553d60b.png","AD_POSITION":"0","RELATED_ID":"1","CLICK_COUNT":0,"SORT_ORDER":3,"LINK_URL":"","ADVERTISEMENT_ID":"396314588510945280","NAME":""}]
     * pd : [{"HOTELEVALUATE":2.8,"HOTELADDRESS":"北京市 北京市 东城区 朝阳门内大街 283号","HOTELPRICE":111,"SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sorthotelimgs/sorthotelshowimgs/eb835e3bba61461296aa88b443c3da43.png","HOTELNAMES":"如家快捷酒店(东四店)","distance":"10.068085026706724","SORTHOTEL_ID":"385471958017376256","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","HOTELEVACOUNT":1},{"HOTELEVALUATE":0.8,"HOTELADDRESS":"北京市 北京市 朝阳区 建国路 99号99-15三层","HOTELPRICE":123,"SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sorthotelimgs/sorthotelshowimgs/38ef1785007b46ea833b4f9603d31e28.png","HOTELNAMES":"锦江之星(国贸店)","distance":"5.051110587790447","SORTHOTEL_ID":"385472115253444608","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","HOTELEVACOUNT":1},{"HOTELEVALUATE":2.8,"HOTELADDRESS":"北京市 北京市 西城区 西黄城根南街 45号院-9号楼","HOTELPRICE":298,"SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sorthotelimgs/sorthotelshowimgs/8881d2f0170f42bfb00ea52aaa140787.png","HOTELNAMES":"7天连锁酒店(灵境胡同店)","distance":"14.645734140760268","SORTHOTEL_ID":"385472311504928768","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","HOTELEVACOUNT":2}]
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
         * SHOWIMG : http://47.104.16.215:8088/advertisementimgs/0683dfe5f3914319bbb2793ec2315dae.png
         * AD_POSITION : 0
         * RELATED_ID : 1
         * CLICK_COUNT : 0
         * SORT_ORDER : 1
         * LINK_URL :
         * ADVERTISEMENT_ID : 396314154756997120
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
         * HOTELEVALUATE : 2.8
         * HOTELADDRESS : 北京市 北京市 东城区 朝阳门内大街 283号
         * HOTELPRICE : 111
         * SHOWIMAGES : http://47.104.16.215:8088/sortimgs/sorthotelimgs/sorthotelshowimgs/eb835e3bba61461296aa88b443c3da43.png
         * HOTELNAMES : 如家快捷酒店(东四店)
         * distance : 10.068085026706724
         * SORTHOTEL_ID : 385471958017376256
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         * HOTELEVACOUNT : 1
         */

        private double HOTELEVALUATE;
        private String HOTELADDRESS;
        private int HOTELPRICE;
        private String SHOWIMAGES;
        private String HOTELNAMES;
        private String distance;
        private String SORTHOTEL_ID;
        private String HONOURUSER_ID;
        private int HOTELEVACOUNT;

        public double getHOTELEVALUATE() {
            return HOTELEVALUATE;
        }

        public void setHOTELEVALUATE(double HOTELEVALUATE) {
            this.HOTELEVALUATE = HOTELEVALUATE;
        }

        public String getHOTELADDRESS() {
            return HOTELADDRESS;
        }

        public void setHOTELADDRESS(String HOTELADDRESS) {
            this.HOTELADDRESS = HOTELADDRESS;
        }

        public int getHOTELPRICE() {
            return HOTELPRICE;
        }

        public void setHOTELPRICE(int HOTELPRICE) {
            this.HOTELPRICE = HOTELPRICE;
        }

        public String getSHOWIMAGES() {
            return SHOWIMAGES;
        }

        public void setSHOWIMAGES(String SHOWIMAGES) {
            this.SHOWIMAGES = SHOWIMAGES;
        }

        public String getHOTELNAMES() {
            return HOTELNAMES;
        }

        public void setHOTELNAMES(String HOTELNAMES) {
            this.HOTELNAMES = HOTELNAMES;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getSORTHOTEL_ID() {
            return SORTHOTEL_ID;
        }

        public void setSORTHOTEL_ID(String SORTHOTEL_ID) {
            this.SORTHOTEL_ID = SORTHOTEL_ID;
        }

        public String getHONOURUSER_ID() {
            return HONOURUSER_ID;
        }

        public void setHONOURUSER_ID(String HONOURUSER_ID) {
            this.HONOURUSER_ID = HONOURUSER_ID;
        }

        public int getHOTELEVACOUNT() {
            return HOTELEVACOUNT;
        }

        public void setHOTELEVACOUNT(int HOTELEVACOUNT) {
            this.HOTELEVACOUNT = HOTELEVACOUNT;
        }
    }
}
