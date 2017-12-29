package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/29.
 * 首页游艇列表实体类
 */

public class HomeYachtRecyclerModel {

    /**
     * result : 01
     * ad : [{"SHOWIMG":"http://47.104.16.215:8088/advertisementimgs/949b5e17d2b140e4909e35e0844d6f5a.png","AD_POSITION":"0","RELATED_ID":"5","CLICK_COUNT":0,"SORT_ORDER":1,"LINK_URL":"","ADVERTISEMENT_ID":"396317751813079040","NAME":"北斗星之夜游艇酒会"},{"SHOWIMG":"http://47.104.16.215:8088/advertisementimgs/6c58b92c657a44b48e9cbdd9f34eb816.png","AD_POSITION":"0","RELATED_ID":"5","CLICK_COUNT":0,"SORT_ORDER":2,"LINK_URL":"","ADVERTISEMENT_ID":"396318083335061504","NAME":"掌托非凡人生  驾驭巅峰激情"},{"SHOWIMG":"http://47.104.16.215:8088/advertisementimgs/03c938ef107643268c08df8a2b4b76f9.png","AD_POSITION":"0","RELATED_ID":"5","CLICK_COUNT":0,"SORT_ORDER":3,"LINK_URL":"","ADVERTISEMENT_ID":"396318267611807744","NAME":"58FT豪华游艇"}]
     * pd : [{"SHOWIMAGES":"http://47.104.16.215:8088/highsortimgs/yachtshopimgs/2e09feb4f9aa499197d195189f9ac2b6.png","YACHTSHOP_ID":"383995743632883712","YACHTLATITUDE":"18.235078","distance":"1211.8115276956214","YACHTNAMES":"江海游艇会所","YACHTLONGITUDE":"18.235078","YACHTADDRESS":"海南省, 三亚市, 市辖区, 南边海路, 115号","YACHTPRICE":3999,"HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","YACHTPHONE":"010-1111111"},{"SHOWIMAGES":"http://47.104.16.215:8088/highsortimgs/yachtshopimgs/649018b25c4a41bebf514e93416af2cf.png","YACHTSHOP_ID":"387615910145294336","YACHTLATITUDE":"18.216947","distance":"1213.6936272026403","YACHTNAMES":"三亚云中帆游艇俱乐部","YACHTLONGITUDE":"18.216947","YACHTADDRESS":"海南省, 三亚市, 市辖区,吉阳区 ,鹿回头路 ","YACHTPRICE":5888,"HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","YACHTPHONE":"010-2222222"},{"SHOWIMAGES":"http://47.104.16.215:8088/highsortimgs/yachtshopimgs/4577796e85734de88598a620e1a3e89b.png","YACHTSHOP_ID":"387616543216762880","YACHTLATITUDE":"18.236662","distance":"1211.4940104679445","YACHTNAMES":"三亚大白鲨豪华游艇俱乐部","YACHTLONGITUDE":"18.236662","YACHTADDRESS":"海南省, 三亚市, 市辖区, 鸿洲路, ","YACHTPRICE":8888,"HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","YACHTPHONE":"010-8888888"},{"SHOWIMAGES":"http://47.104.16.215:8088/highsortimgs/yachtshopimgs/2a9fb7578e1e4f77b444412067f4f296.png","YACHTSHOP_ID":"387617025423310848","YACHTLATITUDE":"18.238851","distance":"1211.2018005499042","YACHTNAMES":"三亚中际华悦游艇俱乐部","YACHTLONGITUDE":"18.238851","YACHTADDRESS":"海南省, 三亚市, 市辖区, G225(海榆(西)线), ","YACHTPRICE":6666,"HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","YACHTPHONE":"010-5555555"},{"SHOWIMAGES":"http://47.104.16.215:8088/highsortimgs/yachtshopimgs/99aa9ebaf9524acaa99dbc371fceee23.png","YACHTSHOP_ID":"387617474415165440","YACHTLATITUDE":"18.235207","distance":"1211.542012723888","YACHTNAMES":"三亚鸿洲国际游艇会","YACHTLONGITUDE":"18.235207","YACHTADDRESS":"海南省, 三亚市, 市辖区, 鸿洲路, ","YACHTPRICE":5888,"HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","YACHTPHONE":"010-6666666"},{"SHOWIMAGES":"http://47.104.16.215:8088/highsortimgs/yachtshopimgs/701e4c1f0a4e4f5a88e42ffb53e0b1ad.png","YACHTSHOP_ID":"387617939211157504","YACHTLATITUDE":"18.236409","distance":"1211.1549362384935","YACHTNAMES":"凤凰之星号游艇俱乐部","YACHTLONGITUDE":"18.236409","YACHTADDRESS":"海南省, 三亚市, 市辖区, G225(海榆(西)线), ","YACHTPRICE":4888,"HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","YACHTPHONE":"010-7777777"},{"SHOWIMAGES":"http://47.104.16.215:8088/highsortimgs/yachtshopimgs/e2a91c59f2eb40fb963ffa5b969a8577.png","YACHTSHOP_ID":"387618741036253184","YACHTLATITUDE":"18.235666","distance":"1211.548553102984","YACHTNAMES":"木头人游艇俱乐部","YACHTLONGITUDE":"18.235666","YACHTADDRESS":"海南省, 三亚市, 市辖区,南边海路三巷 ,鸿洲国际游艇酒店北 ","YACHTPRICE":8888,"HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","YACHTPHONE":"010-9999999"}]
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
         * SHOWIMG : http://47.104.16.215:8088/advertisementimgs/949b5e17d2b140e4909e35e0844d6f5a.png
         * AD_POSITION : 0
         * RELATED_ID : 5
         * CLICK_COUNT : 0
         * SORT_ORDER : 1
         * LINK_URL :
         * ADVERTISEMENT_ID : 396317751813079040
         * NAME : 北斗星之夜游艇酒会
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
         * SHOWIMAGES : http://47.104.16.215:8088/highsortimgs/yachtshopimgs/2e09feb4f9aa499197d195189f9ac2b6.png
         * YACHTSHOP_ID : 383995743632883712
         * YACHTLATITUDE : 18.235078
         * distance : 1211.8115276956214
         * YACHTNAMES : 江海游艇会所
         * YACHTLONGITUDE : 18.235078
         * YACHTADDRESS : 海南省, 三亚市, 市辖区, 南边海路, 115号
         * YACHTPRICE : 3999
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         * YACHTPHONE : 010-1111111
         */

        private String SHOWIMAGES;
        private String YACHTSHOP_ID;
        private String YACHTLATITUDE;
        private String distance;
        private String YACHTNAMES;
        private String YACHTLONGITUDE;
        private String YACHTADDRESS;
        private int YACHTPRICE;
        private String HONOURUSER_ID;
        private String YACHTPHONE;

        public String getSHOWIMAGES() {
            return SHOWIMAGES;
        }

        public void setSHOWIMAGES(String SHOWIMAGES) {
            this.SHOWIMAGES = SHOWIMAGES;
        }

        public String getYACHTSHOP_ID() {
            return YACHTSHOP_ID;
        }

        public void setYACHTSHOP_ID(String YACHTSHOP_ID) {
            this.YACHTSHOP_ID = YACHTSHOP_ID;
        }

        public String getYACHTLATITUDE() {
            return YACHTLATITUDE;
        }

        public void setYACHTLATITUDE(String YACHTLATITUDE) {
            this.YACHTLATITUDE = YACHTLATITUDE;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getYACHTNAMES() {
            return YACHTNAMES;
        }

        public void setYACHTNAMES(String YACHTNAMES) {
            this.YACHTNAMES = YACHTNAMES;
        }

        public String getYACHTLONGITUDE() {
            return YACHTLONGITUDE;
        }

        public void setYACHTLONGITUDE(String YACHTLONGITUDE) {
            this.YACHTLONGITUDE = YACHTLONGITUDE;
        }

        public String getYACHTADDRESS() {
            return YACHTADDRESS;
        }

        public void setYACHTADDRESS(String YACHTADDRESS) {
            this.YACHTADDRESS = YACHTADDRESS;
        }

        public int getYACHTPRICE() {
            return YACHTPRICE;
        }

        public void setYACHTPRICE(int YACHTPRICE) {
            this.YACHTPRICE = YACHTPRICE;
        }

        public String getHONOURUSER_ID() {
            return HONOURUSER_ID;
        }

        public void setHONOURUSER_ID(String HONOURUSER_ID) {
            this.HONOURUSER_ID = HONOURUSER_ID;
        }

        public String getYACHTPHONE() {
            return YACHTPHONE;
        }

        public void setYACHTPHONE(String YACHTPHONE) {
            this.YACHTPHONE = YACHTPHONE;
        }
    }
}
