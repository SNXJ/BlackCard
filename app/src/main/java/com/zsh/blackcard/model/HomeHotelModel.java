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
     * pd : [{"HOTELEVALUATE":2.8,"HOTELADDRESS":"北京市, 北京市, 东城区, 建国门内大街, 26","HOTELPRICE":123,"SHOWIMAGES":"http://47.104.16.215:8088/\nsortimgs/sorthotelimgs/sorthotelshowimgs/f849b0edd3264537992a11fd9b093e81.png","HOTELNAMES":"如家酒店","HOTELLATITUDE":"39.913672","HOTELLONGITUDE":"116.427934","HOTELDETAILSIMGS":",http://47.104.16.215:8088/\nsortimgs/sorthotelimgs/20171113175658128b05b1-42e4-4228-a3b9-bb5d112ff7f7.jpg,http://47.104.16.215:8088/\nsortimgs/sorthotelimgs/2017111317571523e9bc5c-fc7c-443d-9bc7-fe8f687bded7.jpg","HOTELPHONE":"010-12345678","SORTHOTEL_ID":"53443f6feed94a1bbce17a65e63dae28","HOTELEVACOUNT":5}]
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
         * HOTELEVALUATE : 2.8
         * HOTELADDRESS : 北京市, 北京市, 东城区, 建国门内大街, 26
         * HOTELPRICE : 123
         * SHOWIMAGES : http://47.104.16.215:8088/
         sortimgs/sorthotelimgs/sorthotelshowimgs/f849b0edd3264537992a11fd9b093e81.png
         * HOTELNAMES : 如家酒店
         * HOTELLATITUDE : 39.913672
         * HOTELLONGITUDE : 116.427934
         * HOTELDETAILSIMGS : ,http://47.104.16.215:8088/
         sortimgs/sorthotelimgs/20171113175658128b05b1-42e4-4228-a3b9-bb5d112ff7f7.jpg,http://47.104.16.215:8088/
         sortimgs/sorthotelimgs/2017111317571523e9bc5c-fc7c-443d-9bc7-fe8f687bded7.jpg
         * HOTELPHONE : 010-12345678
         * SORTHOTEL_ID : 53443f6feed94a1bbce17a65e63dae28
         * HOTELEVACOUNT : 5
         */

        private double HOTELEVALUATE;
        private String HOTELADDRESS;
        private int HOTELPRICE;
        private String SHOWIMAGES;
        private String HOTELNAMES;
        private String HOTELLATITUDE;
        private String HOTELLONGITUDE;
        private String HOTELDETAILSIMGS;
        private String HOTELPHONE;
        private String SORTHOTEL_ID;
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

        public String getHOTELLATITUDE() {
            return HOTELLATITUDE;
        }

        public void setHOTELLATITUDE(String HOTELLATITUDE) {
            this.HOTELLATITUDE = HOTELLATITUDE;
        }

        public String getHOTELLONGITUDE() {
            return HOTELLONGITUDE;
        }

        public void setHOTELLONGITUDE(String HOTELLONGITUDE) {
            this.HOTELLONGITUDE = HOTELLONGITUDE;
        }

        public String getHOTELDETAILSIMGS() {
            return HOTELDETAILSIMGS;
        }

        public void setHOTELDETAILSIMGS(String HOTELDETAILSIMGS) {
            this.HOTELDETAILSIMGS = HOTELDETAILSIMGS;
        }

        public String getHOTELPHONE() {
            return HOTELPHONE;
        }

        public void setHOTELPHONE(String HOTELPHONE) {
            this.HOTELPHONE = HOTELPHONE;
        }

        public String getSORTHOTEL_ID() {
            return SORTHOTEL_ID;
        }

        public void setSORTHOTEL_ID(String SORTHOTEL_ID) {
            this.SORTHOTEL_ID = SORTHOTEL_ID;
        }

        public int getHOTELEVACOUNT() {
            return HOTELEVACOUNT;
        }

        public void setHOTELEVACOUNT(int HOTELEVACOUNT) {
            this.HOTELEVACOUNT = HOTELEVACOUNT;
        }
    }
}
