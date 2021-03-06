package com.zsh.blackcard.model;

import java.util.List;

/**
 * Name: FoodDetailsListModel
 * Author: SNXJ
 * Date: 2017-11-29
 * Description:描述：
 */
public class KTVDetailsMoreListModel {


    /**
     * result : 01
     * pd : [{"SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sortktvimgs/sortktvshowimgs/c955184693254a0db6da2b5296a86ad6.jpg","distance":"9.015481316522846","KTVNAMES":"麦田K00","SORTKTV_ID":"982e78719b9c42418f19fb8a85a18b09","KTVADDRESS":"北京市 北京市 丰台区 宋庄路 甲12号院","KTVPRICE":123,"HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"},{"SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sortktvimgs/sortktvshowimgs/d48fed9553514ae2bd92da27fe0a9e69.png","distance":"7.6938062127341595","KTVNAMES":"果冻KTV","SORTKTV_ID":"2674579cf39f4bff8697801196f2e629","KTVADDRESS":"北京市 北京市 东城区  ","KTVEVALUATE":3,"KTVEVACOUNT":4,"KTVPRICE":147,"HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"}]
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
         * SHOWIMAGES : http://47.104.16.215:8088/sortimgs/sortktvimgs/sortktvshowimgs/c955184693254a0db6da2b5296a86ad6.jpg
         * distance : 9.015481316522846
         * KTVNAMES : 麦田K00
         * SORTKTV_ID : 982e78719b9c42418f19fb8a85a18b09
         * KTVADDRESS : 北京市 北京市 丰台区 宋庄路 甲12号院
         * KTVPRICE : 123.0
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         * KTVEVALUATE : 3.0
         * KTVEVACOUNT : 4
         */

        private String SHOWIMAGES;
        private String distance;
        private String KTVNAMES;
        private String SORTKTV_ID;
        private String KTVADDRESS;
        private double KTVPRICE;
        private String HONOURUSER_ID;
        private double KTVEVALUATE;
        private int KTVEVACOUNT;

        public String getSHOWIMAGES() {
            return SHOWIMAGES;
        }

        public void setSHOWIMAGES(String SHOWIMAGES) {
            this.SHOWIMAGES = SHOWIMAGES;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getKTVNAMES() {
            return KTVNAMES;
        }

        public void setKTVNAMES(String KTVNAMES) {
            this.KTVNAMES = KTVNAMES;
        }

        public String getSORTKTV_ID() {
            return SORTKTV_ID;
        }

        public void setSORTKTV_ID(String SORTKTV_ID) {
            this.SORTKTV_ID = SORTKTV_ID;
        }

        public String getKTVADDRESS() {
            return KTVADDRESS;
        }

        public void setKTVADDRESS(String KTVADDRESS) {
            this.KTVADDRESS = KTVADDRESS;
        }

        public double getKTVPRICE() {
            return KTVPRICE;
        }

        public void setKTVPRICE(double KTVPRICE) {
            this.KTVPRICE = KTVPRICE;
        }

        public String getHONOURUSER_ID() {
            return HONOURUSER_ID;
        }

        public void setHONOURUSER_ID(String HONOURUSER_ID) {
            this.HONOURUSER_ID = HONOURUSER_ID;
        }

        public double getKTVEVALUATE() {
            return KTVEVALUATE;
        }

        public void setKTVEVALUATE(double KTVEVALUATE) {
            this.KTVEVALUATE = KTVEVALUATE;
        }

        public int getKTVEVACOUNT() {
            return KTVEVACOUNT;
        }

        public void setKTVEVACOUNT(int KTVEVACOUNT) {
            this.KTVEVACOUNT = KTVEVACOUNT;
        }
    }
}
