package com.zsh.blackcard.model;

import java.util.List;

/**
 * Name: BarDetailModel
 * Author: SNXJ
 * Date: 2017-11-27
 * Description:描述：
 */
public class BarDetailModel {
    /**
     * result : 01
     * pd : {"BAREVACOUNT":4,"BARPHONE":"010-11111","BARADDRESS":"北京市 北京市 丰台区 南三环东路辅路 ","SHOPSERVPARK":1,"SHOPSERVPAY":1,"SHOPSERVWIFI":1,"SHOPSERVFOOD":1,"BARNAMES":"BAR1","BAREVALUATE":3.6,"BARDETAILSIMGS":["","http://47.104.16.215:8088/sortimgs/sortbarimgs/2c6bdf7fba624786b2ba0519306f6b7b.png","http://47.104.16.215:8088/sortimgs/sortbarimgs/999d6272809448c89fde5b676d1cc80f.png"]}
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
         * BAREVACOUNT : 4
         * BARPHONE : 010-11111
         * BARADDRESS : 北京市 北京市 丰台区 南三环东路辅路
         * SHOPSERVPARK : 1
         * SHOPSERVPAY : 1
         * SHOPSERVWIFI : 1
         * SHOPSERVFOOD : 1
         * BARNAMES : BAR1
         * BAREVALUATE : 3.6
         * BARDETAILSIMGS : ["","http://47.104.16.215:8088/sortimgs/sortbarimgs/2c6bdf7fba624786b2ba0519306f6b7b.png","http://47.104.16.215:8088/sortimgs/sortbarimgs/999d6272809448c89fde5b676d1cc80f.png"]
         */

        private int BAREVACOUNT;
        private String BARPHONE;
        private String BARADDRESS;
        private int SHOPSERVPARK;
        private int SHOPSERVPAY;
        private int SHOPSERVWIFI;
        private int SHOPSERVFOOD;
        private String BARNAMES;
        private double BAREVALUATE;
        private List<String> BARDETAILSIMGS;
        private int SHOPSERVFITNESS;
        private int SHOPSERVSWIN;

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

        public int getBAREVACOUNT() {
            return BAREVACOUNT;
        }

        public void setBAREVACOUNT(int BAREVACOUNT) {
            this.BAREVACOUNT = BAREVACOUNT;
        }

        public String getBARPHONE() {
            return BARPHONE;
        }

        public void setBARPHONE(String BARPHONE) {
            this.BARPHONE = BARPHONE;
        }

        public String getBARADDRESS() {
            return BARADDRESS;
        }

        public void setBARADDRESS(String BARADDRESS) {
            this.BARADDRESS = BARADDRESS;
        }

        public int getSHOPSERVPARK() {
            return SHOPSERVPARK;
        }

        public void setSHOPSERVPARK(int SHOPSERVPARK) {
            this.SHOPSERVPARK = SHOPSERVPARK;
        }

        public int getSHOPSERVPAY() {
            return SHOPSERVPAY;
        }

        public void setSHOPSERVPAY(int SHOPSERVPAY) {
            this.SHOPSERVPAY = SHOPSERVPAY;
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

        public String getBARNAMES() {
            return BARNAMES;
        }

        public void setBARNAMES(String BARNAMES) {
            this.BARNAMES = BARNAMES;
        }

        public double getBAREVALUATE() {
            return BAREVALUATE;
        }

        public void setBAREVALUATE(double BAREVALUATE) {
            this.BAREVALUATE = BAREVALUATE;
        }

        public List<String> getBARDETAILSIMGS() {
            return BARDETAILSIMGS;
        }

        public void setBARDETAILSIMGS(List<String> BARDETAILSIMGS) {
            this.BARDETAILSIMGS = BARDETAILSIMGS;
        }
    }
}
