package com.zsh.blackcard.model;

import java.util.List;

/**
 * Name: HomeKTVDetailModel
 * Author: SNXJ
 * Date: 2017-11-24
 * Description:描述：
 */
public class HomeKTVDetailModel {
    /**
     * result : 01
     * pd : {"SHOPSERVPARK":1,"KTVNAMES":"果冻KTV","SHOPSERVPAY":1,"KTVEVALUATE":2.7,"KTVADDRESS":"北京市 北京市 东城区  ","KTVDETAILSIMGS":["http://47.104.16.215:8088/sortimgs/sortktvimgs/41927bbc6c6843139e7c86c8ef3be112.jpg","http://47.104.16.215:8088/sortimgs/sortktvimgs/b8ad335845dd49be8c277c83115a59b7.jpg"],"SHOPSERVWIFI":1,"SHOPSERVFOOD":1,"KTVEVACOUNT":3,"KTVPHONE":"010-123456111","SHOPSERVFITNESS":1,"SHOPSERVSWIN":1}
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
         * SHOPSERVPARK : 1
         * KTVNAMES : 果冻KTV
         * SHOPSERVPAY : 1
         * KTVEVALUATE : 2.7
         * KTVADDRESS : 北京市 北京市 东城区
         * KTVDETAILSIMGS : ["http://47.104.16.215:8088/sortimgs/sortktvimgs/41927bbc6c6843139e7c86c8ef3be112.jpg","http://47.104.16.215:8088/sortimgs/sortktvimgs/b8ad335845dd49be8c277c83115a59b7.jpg"]
         * SHOPSERVWIFI : 1
         * SHOPSERVFOOD : 1
         * KTVEVACOUNT : 3
         * KTVPHONE : 010-123456111
         * SHOPSERVFITNESS : 1
         * SHOPSERVSWIN : 1
         */

        private int SHOPSERVPARK;
        private String KTVNAMES;
        private int SHOPSERVPAY;
        private double KTVEVALUATE;
        private String KTVADDRESS;
        private int SHOPSERVWIFI;
        private int SHOPSERVFOOD;
        private int KTVEVACOUNT;
        private String KTVPHONE;
        private int SHOPSERVFITNESS;
        private int SHOPSERVSWIN;
        private List<String> KTVDETAILSIMGS;

        public int getSHOPSERVPARK() {
            return SHOPSERVPARK;
        }

        public void setSHOPSERVPARK(int SHOPSERVPARK) {
            this.SHOPSERVPARK = SHOPSERVPARK;
        }

        public String getKTVNAMES() {
            return KTVNAMES;
        }

        public void setKTVNAMES(String KTVNAMES) {
            this.KTVNAMES = KTVNAMES;
        }

        public int getSHOPSERVPAY() {
            return SHOPSERVPAY;
        }

        public void setSHOPSERVPAY(int SHOPSERVPAY) {
            this.SHOPSERVPAY = SHOPSERVPAY;
        }

        public double getKTVEVALUATE() {
            return KTVEVALUATE;
        }

        public void setKTVEVALUATE(double KTVEVALUATE) {
            this.KTVEVALUATE = KTVEVALUATE;
        }

        public String getKTVADDRESS() {
            return KTVADDRESS;
        }

        public void setKTVADDRESS(String KTVADDRESS) {
            this.KTVADDRESS = KTVADDRESS;
        }

        public int getSHOPSERVWIFI() {
            return SHOPSERVWIFI;
        }

        public void setSHOPSERVWIFI(int SHOPSERVWIFI) {
            this.SHOPSERVWIFI = SHOPSERVWIFI;
        }

        public int getSHOPSERVFOOD() {
            return SHOPSERVFOOD;
        }

        public void setSHOPSERVFOOD(int SHOPSERVFOOD) {
            this.SHOPSERVFOOD = SHOPSERVFOOD;
        }

        public int getKTVEVACOUNT() {
            return KTVEVACOUNT;
        }

        public void setKTVEVACOUNT(int KTVEVACOUNT) {
            this.KTVEVACOUNT = KTVEVACOUNT;
        }

        public String getKTVPHONE() {
            return KTVPHONE;
        }

        public void setKTVPHONE(String KTVPHONE) {
            this.KTVPHONE = KTVPHONE;
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

        public List<String> getKTVDETAILSIMGS() {
            return KTVDETAILSIMGS;
        }

        public void setKTVDETAILSIMGS(List<String> KTVDETAILSIMGS) {
            this.KTVDETAILSIMGS = KTVDETAILSIMGS;
        }
    }
}
