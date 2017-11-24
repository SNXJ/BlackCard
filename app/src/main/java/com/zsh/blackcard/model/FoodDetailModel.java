package com.zsh.blackcard.model;

import java.io.Serializable;
import java.util.List;

/**
 * Name: FoodDetailModel
 * Author: SNXJ
 * Date: 2017-11-24
 * Description:描述：
 */
public class FoodDetailModel {
    /**
     * result : 01
     * pd : {"SHOPDETAILSIMGS":["http://47.104.16.215:8088/sortimgs/sortfoodimgs/333deaff997247c0bc0f162f1ca9f387.png","http://47.104.16.215:8088/sortimgs/sortfoodimgs/5a8e1a58d9f14afba554168b93711eae.png","http://47.104.16.215:8088/sortimgs/sortfoodimgs/2d886d04ff2c41a4a598bbf30d4b641e.png","http://47.104.16.215:8088/sortimgs/sortfoodimgs/d48684d232fd4cac8facfd3390fd1a50.png"],"SHOPADDRESS":"北京市 北京市 朝阳区 潘家园路 甲1号","SHOPSERVPARK":1,"SHOPEVACOUNT":2,"SHOPPHONE":"0898-86868686","SHOPSERVPAY":1,"SHOPSERVWIFI":1,"SHOPSERVFOOD":1,"SHOPNAMES":"菲罗牛排主题自助西餐厅","SHOPEVALUATE":3.4,"SHOPSERVFITNESS":1,"SHOPSERVSWIN":1}
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

    public static class PdBean implements Serializable {
        /**
         * SHOPDETAILSIMGS : ["http://47.104.16.215:8088/sortimgs/sortfoodimgs/333deaff997247c0bc0f162f1ca9f387.png","http://47.104.16.215:8088/sortimgs/sortfoodimgs/5a8e1a58d9f14afba554168b93711eae.png","http://47.104.16.215:8088/sortimgs/sortfoodimgs/2d886d04ff2c41a4a598bbf30d4b641e.png","http://47.104.16.215:8088/sortimgs/sortfoodimgs/d48684d232fd4cac8facfd3390fd1a50.png"]
         * SHOPADDRESS : 北京市 北京市 朝阳区 潘家园路 甲1号
         * SHOPSERVPARK : 1
         * SHOPEVACOUNT : 2
         * SHOPPHONE : 0898-86868686
         * SHOPSERVPAY : 1
         * SHOPSERVWIFI : 1
         * SHOPSERVFOOD : 1
         * SHOPNAMES : 菲罗牛排主题自助西餐厅
         * SHOPEVALUATE : 3.4
         * SHOPSERVFITNESS : 1
         * SHOPSERVSWIN : 1
         */

        private String SHOPADDRESS;
        private int SHOPSERVPARK;
        private int SHOPEVACOUNT;
        private String SHOPPHONE;
        private int SHOPSERVPAY;
        private int SHOPSERVWIFI;
        private int SHOPSERVFOOD;
        private String SHOPNAMES;
        private double SHOPEVALUATE;
        private int SHOPSERVFITNESS;
        private int SHOPSERVSWIN;
        private List<String> SHOPDETAILSIMGS;

        public String getSHOPADDRESS() {
            return SHOPADDRESS;
        }

        public void setSHOPADDRESS(String SHOPADDRESS) {
            this.SHOPADDRESS = SHOPADDRESS;
        }

        public int getSHOPSERVPARK() {
            return SHOPSERVPARK;
        }

        public void setSHOPSERVPARK(int SHOPSERVPARK) {
            this.SHOPSERVPARK = SHOPSERVPARK;
        }

        public int getSHOPEVACOUNT() {
            return SHOPEVACOUNT;
        }

        public void setSHOPEVACOUNT(int SHOPEVACOUNT) {
            this.SHOPEVACOUNT = SHOPEVACOUNT;
        }

        public String getSHOPPHONE() {
            return SHOPPHONE;
        }

        public void setSHOPPHONE(String SHOPPHONE) {
            this.SHOPPHONE = SHOPPHONE;
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

        public String getSHOPNAMES() {
            return SHOPNAMES;
        }

        public void setSHOPNAMES(String SHOPNAMES) {
            this.SHOPNAMES = SHOPNAMES;
        }

        public double getSHOPEVALUATE() {
            return SHOPEVALUATE;
        }

        public void setSHOPEVALUATE(double SHOPEVALUATE) {
            this.SHOPEVALUATE = SHOPEVALUATE;
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

        public List<String> getSHOPDETAILSIMGS() {
            return SHOPDETAILSIMGS;
        }

        public void setSHOPDETAILSIMGS(List<String> SHOPDETAILSIMGS) {
            this.SHOPDETAILSIMGS = SHOPDETAILSIMGS;
        }
    }
}
