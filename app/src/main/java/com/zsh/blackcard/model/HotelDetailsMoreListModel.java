package com.zsh.blackcard.model;

import java.io.Serializable;
import java.util.List;

/**
 * Name: FoodDetailsListModel
 * Author: SNXJ
 * Date: 2017-11-29
 * Description:描述：
 */
public class HotelDetailsMoreListModel {
    /**
     * result : 01
     * pd : [{"HOTELADDRESS":"北京市 北京市 朝阳区 垂杨柳南街 甲11号","HOTELPRICE":111,"SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sorthotelimgs/sorthotelshowimgs/b52f8c2f67944d42891d466e4386c70d.png","HOTELNAMES":"如家酒店1","distance":"5.6704992302910675","SORTHOTEL_ID":"385471958017376256","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"},{"HOTELADDRESS":"北京市 北京市 朝阳区  ","HOTELPRICE":123,"SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sorthotelimgs/sorthotelshowimgs/e31501f187b44efda8856e51443d3eeb.png","HOTELNAMES":"如家酒店2","distance":"10.173005980700394","SORTHOTEL_ID":"385472115253444608","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"},{"HOTELADDRESS":"北京市 北京市 西城区  ","HOTELPRICE":98,"SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sorthotelimgs/sorthotelshowimgs/dfd7015a5a16499dada9312235a33943.png","HOTELNAMES":"如家酒店4","distance":"13.924132449249957","SORTHOTEL_ID":"385472311504928768","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"},{"HOTELEVALUATE":3.9,"HOTELADDRESS":"北京市 北京市 东城区 建国门内大街 26","HOTELPRICE":123,"SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sorthotelimgs/sorthotelshowimgs/f849b0edd3264537992a11fd9b093e81.png","HOTELNAMES":"如家酒店","distance":"9.590434005180756","SORTHOTEL_ID":"53443f6feed94a1bbce17a65e63dae28","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","HOTELEVACOUNT":10}]
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

    public static class PdBean implements Serializable {
        /**
         * HOTELADDRESS : 北京市 北京市 朝阳区 垂杨柳南街 甲11号
         * HOTELPRICE : 111
         * SHOWIMAGES : http://47.104.16.215:8088/sortimgs/sorthotelimgs/sorthotelshowimgs/b52f8c2f67944d42891d466e4386c70d.png
         * HOTELNAMES : 如家酒店1
         * distance : 5.6704992302910675
         * SORTHOTEL_ID : 385471958017376256
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         * HOTELEVALUATE : 3.9
         * HOTELEVACOUNT : 10
         */

        private String HOTELADDRESS;
        private int HOTELPRICE;
        private String SHOWIMAGES;
        private String HOTELNAMES;
        private String distance;
        private String SORTHOTEL_ID;
        private String HONOURUSER_ID;
        private double HOTELEVALUATE;
        private int HOTELEVACOUNT;

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

        public double getHOTELEVALUATE() {
            return HOTELEVALUATE;
        }

        public void setHOTELEVALUATE(double HOTELEVALUATE) {
            this.HOTELEVALUATE = HOTELEVALUATE;
        }

        public int getHOTELEVACOUNT() {
            return HOTELEVACOUNT;
        }

        public void setHOTELEVACOUNT(int HOTELEVACOUNT) {
            this.HOTELEVACOUNT = HOTELEVACOUNT;
        }
    }
}
