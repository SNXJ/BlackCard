package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/29.
 * 马术列表实体类
 */

public class HomeHorseRecyclerModel {

    /**
     * result : 01
     * ad : [{"SHOWIMG":"http://47.104.16.215:8088/advertisementimgs/5934d88200a14c869a0211291d5eeec8.png","AD_POSITION":"0","RELATED_ID":"4","CLICK_COUNT":0,"SORT_ORDER":1,"LINK_URL":"","ADVERTISEMENT_ID":"396317051699855360","NAME":"马术争霸赛"},{"SHOWIMG":"http://47.104.16.215:8088/advertisementimgs/dc7c39540a284e6a933c015fe20bdcbd.png","AD_POSITION":"0","RELATED_ID":"4","CLICK_COUNT":0,"SORT_ORDER":2,"LINK_URL":"","ADVERTISEMENT_ID":"396317289126821888","NAME":"高尚骑术，贵族生活"},{"SHOWIMG":"http://47.104.16.215:8088/advertisementimgs/2e22308cc6a54ac6b09c134bf4a5184b.png","AD_POSITION":"0","RELATED_ID":"4","CLICK_COUNT":0,"SORT_ORDER":3,"LINK_URL":"","ADVERTISEMENT_ID":"396317461189754880","NAME":"马术体验券"}]
     * pd : [{"SHOWIMAGES":"http://47.104.16.215:8088/highsortimgs/horseshopimgs/6a470b861f734df5a8f57ca3e0570ffd.png","HORSEPHONE":"010-1111111","HORSELONGITUDE":"109.359904","HORSEADDRESS":"海南省 三亚市 黎三亚市黎陶生态农家庄  ","distance":"1218.056184483199","HORSESHOP_ID":"386524955925282816","HORSENAMES":"三亚马术俱乐部","HORSELATITUDE":"18.30186","HORSEPRICE":396,"HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"},{"SHOWIMAGES":"http://47.104.16.215:8088/highsortimgs/horseshopimgs/8a0f3d8930054308a0002d49304063cc.png","HORSEPHONE":"010-2222222","HORSELONGITUDE":"109.50437","HORSEADDRESS":"海南省 三亚市 市辖区 三亚湾路 35号","distance":"1211.3745988436833","HORSESHOP_ID":"386529392123183104","HORSENAMES":"青奥马术基地","HORSELATITUDE":"18.262229","HORSEPRICE":528,"HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"},{"SHOWIMAGES":"http://47.104.16.215:8088/highsortimgs/horseshopimgs/44c62509592e49d6b3b7f0071382c672.png","HORSEPHONE":"010-3333333","HORSELONGITUDE":"109.503364","HORSEADDRESS":"海南省 三亚市 市辖区 金鸡西六巷 ","distance":"1210.486113497757","HORSESHOP_ID":"387573511855538176","HORSENAMES":"鹏源马术俱乐部","HORSELATITUDE":"18.29134","HORSEPRICE":399,"HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"},{"SHOWIMAGES":"http://47.104.16.215:8088/highsortimgs/horseshopimgs/d4265d5b831c4457970e65c8b9bfe121.png","HORSEPHONE":"010-4444444","HORSELONGITUDE":"109.614897","HORSEADDRESS":"海南省 三亚市 市辖区 田独路 ","distance":"1204.3496553236832","HORSESHOP_ID":"387600182713253888","HORSENAMES":"调良国际马术俱乐部","HORSELATITUDE":"18.29436","HORSEPRICE":299,"HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"},{"SHOWIMAGES":"http://47.104.16.215:8088/highsortimgs/horseshopimgs/4db6819224a64635aef907b49b2355d8.png","HORSEPHONE":"010-5555555","HORSELONGITUDE":"109.52866","HORSEADDRESS":"海南省 三亚市 市辖区 大真岭巷 20号","distance":"1210.9598450471224","HORSESHOP_ID":"387602670510145536","HORSENAMES":"红叶马术俱乐部","HORSELATITUDE":"18.234349","HORSEPRICE":458,"HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"}]
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
         * SHOWIMG : http://47.104.16.215:8088/advertisementimgs/5934d88200a14c869a0211291d5eeec8.png
         * AD_POSITION : 0
         * RELATED_ID : 4
         * CLICK_COUNT : 0
         * SORT_ORDER : 1
         * LINK_URL :
         * ADVERTISEMENT_ID : 396317051699855360
         * NAME : 马术争霸赛
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
         * SHOWIMAGES : http://47.104.16.215:8088/highsortimgs/horseshopimgs/6a470b861f734df5a8f57ca3e0570ffd.png
         * HORSEPHONE : 010-1111111
         * HORSELONGITUDE : 109.359904
         * HORSEADDRESS : 海南省 三亚市 黎三亚市黎陶生态农家庄
         * distance : 1218.056184483199
         * HORSESHOP_ID : 386524955925282816
         * HORSENAMES : 三亚马术俱乐部
         * HORSELATITUDE : 18.30186
         * HORSEPRICE : 396
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         */

        private String SHOWIMAGES;
        private String HORSEPHONE;
        private String HORSELONGITUDE;
        private String HORSEADDRESS;
        private String distance;
        private String HORSESHOP_ID;
        private String HORSENAMES;
        private String HORSELATITUDE;
        private int HORSEPRICE;
        private String HONOURUSER_ID;

        public String getSHOWIMAGES() {
            return SHOWIMAGES;
        }

        public void setSHOWIMAGES(String SHOWIMAGES) {
            this.SHOWIMAGES = SHOWIMAGES;
        }

        public String getHORSEPHONE() {
            return HORSEPHONE;
        }

        public void setHORSEPHONE(String HORSEPHONE) {
            this.HORSEPHONE = HORSEPHONE;
        }

        public String getHORSELONGITUDE() {
            return HORSELONGITUDE;
        }

        public void setHORSELONGITUDE(String HORSELONGITUDE) {
            this.HORSELONGITUDE = HORSELONGITUDE;
        }

        public String getHORSEADDRESS() {
            return HORSEADDRESS;
        }

        public void setHORSEADDRESS(String HORSEADDRESS) {
            this.HORSEADDRESS = HORSEADDRESS;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getHORSESHOP_ID() {
            return HORSESHOP_ID;
        }

        public void setHORSESHOP_ID(String HORSESHOP_ID) {
            this.HORSESHOP_ID = HORSESHOP_ID;
        }

        public String getHORSENAMES() {
            return HORSENAMES;
        }

        public void setHORSENAMES(String HORSENAMES) {
            this.HORSENAMES = HORSENAMES;
        }

        public String getHORSELATITUDE() {
            return HORSELATITUDE;
        }

        public void setHORSELATITUDE(String HORSELATITUDE) {
            this.HORSELATITUDE = HORSELATITUDE;
        }

        public int getHORSEPRICE() {
            return HORSEPRICE;
        }

        public void setHORSEPRICE(int HORSEPRICE) {
            this.HORSEPRICE = HORSEPRICE;
        }

        public String getHONOURUSER_ID() {
            return HONOURUSER_ID;
        }

        public void setHONOURUSER_ID(String HONOURUSER_ID) {
            this.HONOURUSER_ID = HONOURUSER_ID;
        }
    }
}
