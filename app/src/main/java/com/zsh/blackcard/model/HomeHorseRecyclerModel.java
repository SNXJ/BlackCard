package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/29.
 * 马术列表实体类
 */

public class HomeHorseRecyclerModel {

    /**
     * result : 01
     * pd : [{"SHOWIMAGES":"http://47.104.16.215:8088/highsortimgs/horseshopimgs/28ec5ab2efa7488db1355cb33fd121be.png","HORSEPHONE":"111111","HORSELONGITUDE":"116.463291","HORSEADDRESS":"北京市 北京市 丰台区  ","distance":"6.096652588864877","HORSESHOP_ID":"383990553504645120","HORSENAMES":"马术1","HORSELATITUDE":"39.858307","HORSEPRICE":1,"HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"},{"SHOWIMAGES":"http://47.104.16.215:8088/highsortimgs/horseshopimgs/7ee2e19bb94f421ca801fedd15c3fdfa.png","HORSEPHONE":"22222","HORSELONGITUDE":"116.693257","HORSEADDRESS":"北京市 北京市 通州区  ","distance":"21.48940020626861","HORSESHOP_ID":"383990636543475712","HORSENAMES":"马术2","HORSELATITUDE":"39.744781","HORSEPRICE":2,"HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"}]
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
         * SHOWIMAGES : http://47.104.16.215:8088/highsortimgs/horseshopimgs/28ec5ab2efa7488db1355cb33fd121be.png
         * HORSEPHONE : 111111
         * HORSELONGITUDE : 116.463291
         * HORSEADDRESS : 北京市 北京市 丰台区
         * distance : 6.096652588864877
         * HORSESHOP_ID : 383990553504645120
         * HORSENAMES : 马术1
         * HORSELATITUDE : 39.858307
         * HORSEPRICE : 1
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
