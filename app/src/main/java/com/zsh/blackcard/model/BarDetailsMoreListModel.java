package com.zsh.blackcard.model;

import java.util.List;

/**
 * Name: FoodDetailsListModel
 * Author: SNXJ
 * Date: 2017-11-29
 * Description:描述：
 */
public class BarDetailsMoreListModel {
    /**
     * result : 01
     * pd : [{"SORTBAR_ID":"385367746201780224","SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sortbarimgs/sortbarshowimgs/594f01ccdd7d4143ace4f92141c223d5.png","BARADDRESS":"北京市 北京市 东城区 天坛西里 1-2号","distance":"11.822189427429164","BARPRICE":111,"BARNAMES":"BAR1","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"},{"SORTBAR_ID":"385374599321223168","SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sortbarimgs/sortbarshowimgs/d18e626a12ae45228f69acf717554953.png","BARADDRESS":"北京市 北京市 东城区 建国门内大街 69号","distance":"9.753452971172925","BARPRICE":11,"BARNAMES":"BAR2","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"}]
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
         * SORTBAR_ID : 385367746201780224
         * SHOWIMAGES : http://47.104.16.215:8088/sortimgs/sortbarimgs/sortbarshowimgs/594f01ccdd7d4143ace4f92141c223d5.png
         * BARADDRESS : 北京市 北京市 东城区 天坛西里 1-2号
         * distance : 11.822189427429164
         * BARPRICE : 111
         * BARNAMES : BAR1
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         */


        private String BAREVACOUNT;

        public String getBAREVACOUNT() {
            return BAREVACOUNT;
        }

        public void setBAREVACOUNT(String BAREVACOUNT) {
            this.BAREVACOUNT = BAREVACOUNT;
        }

        public double getBAREVALUATE() {
            return BAREVALUATE;
        }

        public void setBAREVALUATE(double BAREVALUATE) {
            this.BAREVALUATE = BAREVALUATE;
        }

        private double BAREVALUATE;
        private String SORTBAR_ID;
        private String SHOWIMAGES;
        private String BARADDRESS;
        private String distance;
        private int BARPRICE;
        private String BARNAMES;
        private String HONOURUSER_ID;

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
    }
}
