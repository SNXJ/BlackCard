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
     * pd : [{"SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sortbarimgs/sortbarshowimgs/a791fabc6bd04cb2a5825d19fa01c93a.png","BARPHONE":"010-11111","BAREVACOUNT":3,"distance":{"result":"success","distance":"6.948098389930397"},"BARLATITUDE":"39.865397","BARPRICE":111,"BARNAMES":"BAR1","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","BARDETAILSIMGS":",http://47.104.16.215:8088/sortimgs/sortbarimgs/2c6bdf7fba624786b2ba0519306f6b7b.png,http://47.104.16.215:8088/sortimgs/sortbarimgs/999d6272809448c89fde5b676d1cc80f.png","BARLONGITUDE":"116.454093","SORTBAR_ID":"383578103407968256","BARADDRESS":"北京市 北京市 丰台区 南三环东路辅路 ","BAREVALUATE":3.7},{"BARLONGITUDE":"116.435695","SORTBAR_ID":"383578947431956480","SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sortbarimgs/sortbarshowimgs/55e19bf215474656a8e5c91be05dec89.png","BARPHONE":"010-2222","BARADDRESS":"北京市 北京市 东城区 左安门西街 ","distance":{"result":"success","distance":"8.805133810484016"},"BARLATITUDE":"39.879573","BARPRICE":222,"BARNAMES":"BAR22","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","BARDETAILSIMGS":",http://47.104.16.215:8088/sortimgs/sortbarimgs/3093abf09d974deca61cc3f1c7198092.png,http://47.104.16.215:8088/sortimgs/sortbarimgs/93c3ab834e9c4360a2b7c87913d70b05.png"}]
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
         * SHOWIMAGES : http://47.104.16.215:8088/sortimgs/sortbarimgs/sortbarshowimgs/a791fabc6bd04cb2a5825d19fa01c93a.png
         * BARPHONE : 010-11111
         * BAREVACOUNT : 3
         * distance : {"result":"success","distance":"6.948098389930397"}
         * BARLATITUDE : 39.865397
         * BARPRICE : 111
         * BARNAMES : BAR1
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         * BARDETAILSIMGS : ,http://47.104.16.215:8088/sortimgs/sortbarimgs/2c6bdf7fba624786b2ba0519306f6b7b.png,http://47.104.16.215:8088/sortimgs/sortbarimgs/999d6272809448c89fde5b676d1cc80f.png
         * BARLONGITUDE : 116.454093
         * SORTBAR_ID : 383578103407968256
         * BARADDRESS : 北京市 北京市 丰台区 南三环东路辅路
         * BAREVALUATE : 3.7
         */

        private String SHOWIMAGES;
        private String BARPHONE;
        private int BAREVACOUNT;
        private DistanceBean distance;
        private String BARLATITUDE;
        private int BARPRICE;
        private String BARNAMES;
        private String HONOURUSER_ID;
        private String BARDETAILSIMGS;
        private String BARLONGITUDE;
        private String SORTBAR_ID;
        private String BARADDRESS;
        private double BAREVALUATE;

        public String getSHOWIMAGES() {
            return SHOWIMAGES;
        }

        public void setSHOWIMAGES(String SHOWIMAGES) {
            this.SHOWIMAGES = SHOWIMAGES;
        }

        public String getBARPHONE() {
            return BARPHONE;
        }

        public void setBARPHONE(String BARPHONE) {
            this.BARPHONE = BARPHONE;
        }

        public int getBAREVACOUNT() {
            return BAREVACOUNT;
        }

        public void setBAREVACOUNT(int BAREVACOUNT) {
            this.BAREVACOUNT = BAREVACOUNT;
        }

        public DistanceBean getDistance() {
            return distance;
        }

        public void setDistance(DistanceBean distance) {
            this.distance = distance;
        }

        public String getBARLATITUDE() {
            return BARLATITUDE;
        }

        public void setBARLATITUDE(String BARLATITUDE) {
            this.BARLATITUDE = BARLATITUDE;
        }

        public int getBARPRICE() {
            return BARPRICE;
        }

        public void setBARPRICE(int BARPRICE) {
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

        public String getBARDETAILSIMGS() {
            return BARDETAILSIMGS;
        }

        public void setBARDETAILSIMGS(String BARDETAILSIMGS) {
            this.BARDETAILSIMGS = BARDETAILSIMGS;
        }

        public String getBARLONGITUDE() {
            return BARLONGITUDE;
        }

        public void setBARLONGITUDE(String BARLONGITUDE) {
            this.BARLONGITUDE = BARLONGITUDE;
        }

        public String getSORTBAR_ID() {
            return SORTBAR_ID;
        }

        public void setSORTBAR_ID(String SORTBAR_ID) {
            this.SORTBAR_ID = SORTBAR_ID;
        }

        public String getBARADDRESS() {
            return BARADDRESS;
        }

        public void setBARADDRESS(String BARADDRESS) {
            this.BARADDRESS = BARADDRESS;
        }

        public double getBAREVALUATE() {
            return BAREVALUATE;
        }

        public void setBAREVALUATE(double BAREVALUATE) {
            this.BAREVALUATE = BAREVALUATE;
        }

        public static class DistanceBean {
            /**
             * result : success
             * distance : 6.948098389930397
             */

            private String result;
            private String distance;

            public String getResult() {
                return result;
            }

            public void setResult(String result) {
                this.result = result;
            }

            public String getDistance() {
                return distance;
            }

            public void setDistance(String distance) {
                this.distance = distance;
            }
        }
    }
}
