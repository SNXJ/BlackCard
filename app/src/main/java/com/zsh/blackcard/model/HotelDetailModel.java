package com.zsh.blackcard.model;

/**
 * Name: HotelDetailModel
 * Author: SNXJ
 * Date: 2017-11-22
 * Description:描述：
 */
public class HotelDetailModel {

    /**
     * result : 01
     * pd : {"HOTELEVALUATE":3.8,"HOTELADDRESS":"北京市, 北京市, 东城区, 建国门内大街, 26","SHOPSERVPARK":1,"HOTELNAMES":"如家酒店","SHOPSERVPAY":1,"HOTELDETAILSIMGS":"http://47.104.16.215:8088/sortimgs/sorthotelimgs/20171113175658128b05b1-42e4-4228-a3b9-bb5d112ff7f7.jpg,http://47.104.16.215:8088/sortimgs/sorthotelimgs/2017111317571523e9bc5c-fc7c-443d-9bc7-fe8f687bded7.jpg","SHOPSERVWIFI":1,"HOTELPHONE":"010-12345678","SHOPSERVFOOD":1,"HOTELEVACOUNT":1,"SHOPSERVFITNESS":1,"SHOPSERVSWIN":1}
     */

    private String result;
    private PdBean pd;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public PdBean getPd() {
        return pd;
    }

    public void setPd(PdBean pd) {
        this.pd = pd;
    }

    public static class PdBean {
        /**
         * HOTELEVALUATE : 3.8
         * HOTELADDRESS : 北京市, 北京市, 东城区, 建国门内大街, 26
         * SHOPSERVPARK : 1
         * HOTELNAMES : 如家酒店
         * SHOPSERVPAY : 1
         * HOTELDETAILSIMGS : http://47.104.16.215:8088/sortimgs/sorthotelimgs/20171113175658128b05b1-42e4-4228-a3b9-bb5d112ff7f7.jpg,http://47.104.16.215:8088/sortimgs/sorthotelimgs/2017111317571523e9bc5c-fc7c-443d-9bc7-fe8f687bded7.jpg
         * SHOPSERVWIFI : 1
         * HOTELPHONE : 010-12345678
         * SHOPSERVFOOD : 1
         * HOTELEVACOUNT : 1
         * SHOPSERVFITNESS : 1
         * SHOPSERVSWIN : 1
         */

        private double HOTELEVALUATE;
        private String HOTELADDRESS;
        private int SHOPSERVPARK;
        private String HOTELNAMES;
        private int SHOPSERVPAY;
        private String HOTELDETAILSIMGS;
        private int SHOPSERVWIFI;
        private String HOTELPHONE;
        private int SHOPSERVFOOD;
        private int HOTELEVACOUNT;
        private int SHOPSERVFITNESS;
        private int SHOPSERVSWIN;

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

        public int getSHOPSERVPARK() {
            return SHOPSERVPARK;
        }

        public void setSHOPSERVPARK(int SHOPSERVPARK) {
            this.SHOPSERVPARK = SHOPSERVPARK;
        }

        public String getHOTELNAMES() {
            return HOTELNAMES;
        }

        public void setHOTELNAMES(String HOTELNAMES) {
            this.HOTELNAMES = HOTELNAMES;
        }

        public int getSHOPSERVPAY() {
            return SHOPSERVPAY;
        }

        public void setSHOPSERVPAY(int SHOPSERVPAY) {
            this.SHOPSERVPAY = SHOPSERVPAY;
        }

        public String getHOTELDETAILSIMGS() {
            return HOTELDETAILSIMGS;
        }

        public void setHOTELDETAILSIMGS(String HOTELDETAILSIMGS) {
            this.HOTELDETAILSIMGS = HOTELDETAILSIMGS;
        }

        public int getSHOPSERVWIFI() {
            return SHOPSERVWIFI;
        }

        public void setSHOPSERVWIFI(int SHOPSERVWIFI) {
            this.SHOPSERVWIFI = SHOPSERVWIFI;
        }

        public String getHOTELPHONE() {
            return HOTELPHONE;
        }

        public void setHOTELPHONE(String HOTELPHONE) {
            this.HOTELPHONE = HOTELPHONE;
        }

        public int getSHOPSERVFOOD() {
            return SHOPSERVFOOD;
        }

        public void setSHOPSERVFOOD(int SHOPSERVFOOD) {
            this.SHOPSERVFOOD = SHOPSERVFOOD;
        }

        public int getHOTELEVACOUNT() {
            return HOTELEVACOUNT;
        }

        public void setHOTELEVACOUNT(int HOTELEVACOUNT) {
            this.HOTELEVACOUNT = HOTELEVACOUNT;
        }

        public int getSHOPSERVFITNESS() {
            return SHOPSERVFITNESS;
        }

        public void setSHOPSERVFITNESS(int SHOPSERVFITNESS) {
            this.SHOPSERVFITNESS = SHOPSERVFITNESS;
        }

        public int getSHOPSERVSWIN() {
            return SHOPSERVSWIN;
        }

        public void setSHOPSERVSWIN(int SHOPSERVSWIN) {
            this.SHOPSERVSWIN = SHOPSERVSWIN;
        }
    }
}
