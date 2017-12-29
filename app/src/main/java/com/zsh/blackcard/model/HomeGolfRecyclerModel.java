package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/28.
 * 高尔夫汇列表实体类
 */

public class HomeGolfRecyclerModel {

    /**
     * result : 01
     * ad : [{"SHOWIMG":"http://47.104.16.215:8088/advertisementimgs/dc0cde83a20544388bc5af1f3a2acbbb.png","AD_POSITION":"0","RELATED_ID":"7","CLICK_COUNT":0,"SORT_ORDER":1,"LINK_URL":"","ADVERTISEMENT_ID":"396322111322324992","NAME":"挥杆起我们走的更远"},{"SHOWIMG":"http://47.104.16.215:8088/advertisementimgs/9d0e89f334fa4d3fba47bda60fdd98c1.png","AD_POSITION":"0","RELATED_ID":"7","CLICK_COUNT":0,"SORT_ORDER":2,"LINK_URL":"","ADVERTISEMENT_ID":"396322479712239616","NAME":"荣耀，只因先行"},{"SHOWIMG":"http://47.104.16.215:8088/advertisementimgs/718e845d199d4be5888c8b0a5231395b.png","AD_POSITION":"0","RELATED_ID":"7","CLICK_COUNT":0,"SORT_ORDER":3,"LINK_URL":"","ADVERTISEMENT_ID":"396322707857211392","NAME":"尊贵显赫，皇者风范"}]
     * pd : [{"GOLFPHONE":"010-2222222","SHOWIMAGES":"http://47.104.16.215:8088/highsortimgs/golfshopimgs/d8e726c24aa04e77aee581ca517c23ae.png","GOLFLATITUDE":"18.297501","distance":"1207.8855920627445","GOLFPRICE":699,"GOLFLONGITUDE":"109.547489","GOLFNAMES":"成大高尔夫俱乐部","GOLFSHOP_ID":"383990831532474368","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","GOLFADDRESS":"海南省 三亚市 市辖区 G223(迎宾路) "},{"GOLFPHONE":"010-3333333","SHOWIMAGES":"http://47.104.16.215:8088/highsortimgs/golfshopimgs/f8ffb9c3c3e74804b23dcc139f705ab4.png","GOLFLATITUDE":"18.312127","distance":"1206.2728664083184","GOLFPRICE":588,"GOLFLONGITUDE":"109.568466","GOLFNAMES":"龙泉谷高尔夫球会","GOLFSHOP_ID":"383991011921100800","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","GOLFADDRESS":"海南省 三亚市 市辖区  "},{"GOLFPHONE":"010-4444444","SHOWIMAGES":"http://47.104.16.215:8088/highsortimgs/golfshopimgs/e19718ee76ee47669701cf7c79a4f91a.png","GOLFLATITUDE":"18.256392","distance":"1205.3047800032393","GOLFPRICE":399,"GOLFLONGITUDE":"109.620274","GOLFNAMES":"红峡谷三亚高尔夫球会","GOLFSHOP_ID":"387555412766883840","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","GOLFADDRESS":"海南省 三亚市 市辖区亚龙湾国家旅游度假区博后村 "},{"GOLFPHONE":"010-5555555","SHOWIMAGES":"http://47.104.16.215:8088/highsortimgs/golfshopimgs/1acda85bf47f4d5898b43ceb78174ce5.png","GOLFLATITUDE":"18.276081","distance":"1199.915528287302","GOLFPRICE":599,"GOLFLONGITUDE":"109.709345","GOLFNAMES":"三亚海棠湾海中海高尔夫球会","GOLFSHOP_ID":"387558296619319296","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","GOLFADDRESS":"海南省 三亚市 海塘区海棠湾青田村薄尾岭 "},{"GOLFPHONE":"010-6666666","SHOWIMAGES":"http://47.104.16.215:8088/highsortimgs/golfshopimgs/3b376d38e19c49118b425ddc4d2c8ee1.png","GOLFLATITUDE":"18.297385","distance":"1198.2837628373036","GOLFPRICE":699,"GOLFLONGITUDE":"109.726889","GOLFNAMES":"三亚海棠湾9号高尔夫练习场","GOLFSHOP_ID":"387560666837286912","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","GOLFADDRESS":"海南省 三亚市 市辖区 江林路 "},{"GOLFPHONE":"010-7777777","SHOWIMAGES":"http://47.104.16.215:8088/highsortimgs/golfshopimgs/e3c8dac784a94c21af14fcb40bf3bf92.png","GOLFLATITUDE":"18.214749","distance":"1213.345188182704","GOLFPRICE":788,"GOLFLONGITUDE":"109.496442","GOLFNAMES":"三亚鹿回头高尔夫球会","GOLFSHOP_ID":"387562320596828160","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","GOLFADDRESS":"海南省 三亚市 市辖区 鹿回头路 "}]
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
         * SHOWIMG : http://47.104.16.215:8088/advertisementimgs/dc0cde83a20544388bc5af1f3a2acbbb.png
         * AD_POSITION : 0
         * RELATED_ID : 7
         * CLICK_COUNT : 0
         * SORT_ORDER : 1
         * LINK_URL :
         * ADVERTISEMENT_ID : 396322111322324992
         * NAME : 挥杆起我们走的更远
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
         * GOLFPHONE : 010-2222222
         * SHOWIMAGES : http://47.104.16.215:8088/highsortimgs/golfshopimgs/d8e726c24aa04e77aee581ca517c23ae.png
         * GOLFLATITUDE : 18.297501
         * distance : 1207.8855920627445
         * GOLFPRICE : 699
         * GOLFLONGITUDE : 109.547489
         * GOLFNAMES : 成大高尔夫俱乐部
         * GOLFSHOP_ID : 383990831532474368
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         * GOLFADDRESS : 海南省 三亚市 市辖区 G223(迎宾路)
         */

        private String GOLFPHONE;
        private String SHOWIMAGES;
        private String GOLFLATITUDE;
        private String distance;
        private int GOLFPRICE;
        private String GOLFLONGITUDE;
        private String GOLFNAMES;
        private String GOLFSHOP_ID;
        private String HONOURUSER_ID;
        private String GOLFADDRESS;

        public String getGOLFPHONE() {
            return GOLFPHONE;
        }

        public void setGOLFPHONE(String GOLFPHONE) {
            this.GOLFPHONE = GOLFPHONE;
        }

        public String getSHOWIMAGES() {
            return SHOWIMAGES;
        }

        public void setSHOWIMAGES(String SHOWIMAGES) {
            this.SHOWIMAGES = SHOWIMAGES;
        }

        public String getGOLFLATITUDE() {
            return GOLFLATITUDE;
        }

        public void setGOLFLATITUDE(String GOLFLATITUDE) {
            this.GOLFLATITUDE = GOLFLATITUDE;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public int getGOLFPRICE() {
            return GOLFPRICE;
        }

        public void setGOLFPRICE(int GOLFPRICE) {
            this.GOLFPRICE = GOLFPRICE;
        }

        public String getGOLFLONGITUDE() {
            return GOLFLONGITUDE;
        }

        public void setGOLFLONGITUDE(String GOLFLONGITUDE) {
            this.GOLFLONGITUDE = GOLFLONGITUDE;
        }

        public String getGOLFNAMES() {
            return GOLFNAMES;
        }

        public void setGOLFNAMES(String GOLFNAMES) {
            this.GOLFNAMES = GOLFNAMES;
        }

        public String getGOLFSHOP_ID() {
            return GOLFSHOP_ID;
        }

        public void setGOLFSHOP_ID(String GOLFSHOP_ID) {
            this.GOLFSHOP_ID = GOLFSHOP_ID;
        }

        public String getHONOURUSER_ID() {
            return HONOURUSER_ID;
        }

        public void setHONOURUSER_ID(String HONOURUSER_ID) {
            this.HONOURUSER_ID = HONOURUSER_ID;
        }

        public String getGOLFADDRESS() {
            return GOLFADDRESS;
        }

        public void setGOLFADDRESS(String GOLFADDRESS) {
            this.GOLFADDRESS = GOLFADDRESS;
        }
    }
}
