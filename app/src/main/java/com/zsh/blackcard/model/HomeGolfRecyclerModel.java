package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/28.
 * 高尔夫汇列表实体类
 */

public class HomeGolfRecyclerModel {

    /**
     * result : 01
     * pd : [{"GOLFPHONE":"11111","SHOWIMAGES":"http://47.104.16.215:8088/highsortimgs/golfshopimgs/f33a5adc2c2c4d89a839d169d81785a8.png","GOLFLATITUDE":"39.851218","distance":"16.082041439905886","GOLFPRICE":1,"GOLFLONGITUDE":"116.656463","GOLFNAMES":"高尔夫11","GOLFSHOP_ID":"383990831532474368","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","GOLFADDRESS":"北京市 北京市 通州区 G1(京哈高速) "},{"GOLFPHONE":"2222222","SHOWIMAGES":"http://47.104.16.215:8088/highsortimgs/golfshopimgs/5bf447a1f56f4b859f62ebb2621343e2.png","GOLFLATITUDE":"39.872485","distance":"10.88233932040707","GOLFPRICE":2,"GOLFLONGITUDE":"116.417298","GOLFNAMES":"高尔夫2","GOLFSHOP_ID":"383991011921100800","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","GOLFADDRESS":"北京市 北京市 东城区 郭庄三条 甲17号"}]
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

    public static class PdBean {
        /**
         * GOLFPHONE : 11111
         * SHOWIMAGES : http://47.104.16.215:8088/highsortimgs/golfshopimgs/f33a5adc2c2c4d89a839d169d81785a8.png
         * GOLFLATITUDE : 39.851218
         * distance : 16.082041439905886
         * GOLFPRICE : 1
         * GOLFLONGITUDE : 116.656463
         * GOLFNAMES : 高尔夫11
         * GOLFSHOP_ID : 383990831532474368
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         * GOLFADDRESS : 北京市 北京市 通州区 G1(京哈高速)
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
