package com.zsh.blackcard.model;

import java.util.List;

/**
 * Name: HomeFoodModel
 * Author: SNXJ
 * Date: 2017-11-22
 * Description:描述：
 */
public class HomeFoodModel {
    /**
     * result : 01
     * pd : [{"SHOPPRICE":399,"SHOPDETAILSIMGS":"http://47.104.16.215:8088/sortimgs/sortfoodimgs/333deaff997247c0bc0f162f1ca9f387.png,http://47.104.16.215:8088/sortimgs/sortfoodimgs/5a8e1a58d9f14afba554168b93711eae.png,http://47.104.16.215:8088/sortimgs/sortfoodimgs/2d886d04ff2c41a4a598bbf30d4b641e.png,http://47.104.16.215:8088/sortimgs/sortfoodimgs/d48684d232fd4cac8facfd3390fd1a50.png","SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sortfoodimgs/sortfoodshowimgs/ca48ec53999a4adfaff3a0c8f84cf531.png","SHOPADDRESS":"北京市, 北京市, 朝阳区, 潘家园路, 甲1号","SORTFOOD_ID":"382585520535896064","SHOPPHONE":"0898-86868686","SHOPEVACOUNT":1,"SHOPLONGITUDE":"116.461566","SHOPLATITUDE":"39.882244","SHOPNAMES":"菲罗牛排主题自助西餐厅","SHOPEVALUATE":3.5},{"SHOPPRICE":299,"SHOPDETAILSIMGS":"http://47.104.16.215:8088/sortimgs/sortfoodimgs/4f1c969725c44776958f4d7e7a49c393.png,http://47.104.16.215:8088/sortimgs/sortfoodimgs/251ac9806f1c46f397138aac86c02a7d.png,http://47.104.16.215:8088/sortimgs/sortfoodimgs/f56e60a3572d42d69a82d1e2cd6a069a.png,http://47.104.16.215:8088/sortimgs/sortfoodimgs/5d0757ca6a6c49e1a9c828834bf276ba.png","SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sortfoodimgs/sortfoodshowimgs/9c576b0cdfd94c388b1dc48cc37fd4a7.png","SHOPADDRESS":"北京市, 北京市, 朝阳区, 广渠路, 52号","SORTFOOD_ID":"382585869963362304","SHOPPHONE":"0868-12345678","SHOPEVACOUNT":1,"SHOPLONGITUDE":"116.468708","SHOPLATITUDE":"39.89861","SHOPNAMES":"菲罗牛排主题自助西餐厅双井分店","SHOPEVALUATE":3.5}]
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
         * SHOPPRICE : 399
         * SHOPDETAILSIMGS : http://47.104.16.215:8088/sortimgs/sortfoodimgs/333deaff997247c0bc0f162f1ca9f387.png,http://47.104.16.215:8088/sortimgs/sortfoodimgs/5a8e1a58d9f14afba554168b93711eae.png,http://47.104.16.215:8088/sortimgs/sortfoodimgs/2d886d04ff2c41a4a598bbf30d4b641e.png,http://47.104.16.215:8088/sortimgs/sortfoodimgs/d48684d232fd4cac8facfd3390fd1a50.png
         * SHOWIMAGES : http://47.104.16.215:8088/sortimgs/sortfoodimgs/sortfoodshowimgs/ca48ec53999a4adfaff3a0c8f84cf531.png
         * SHOPADDRESS : 北京市, 北京市, 朝阳区, 潘家园路, 甲1号
         * SORTFOOD_ID : 382585520535896064
         * SHOPPHONE : 0898-86868686
         * SHOPEVACOUNT : 1
         * SHOPLONGITUDE : 116.461566
         * SHOPLATITUDE : 39.882244
         * SHOPNAMES : 菲罗牛排主题自助西餐厅
         * SHOPEVALUATE : 3.5
         */

        private int SHOPPRICE;
        private String SHOPDETAILSIMGS;
        private String SHOWIMAGES;
        private String SHOPADDRESS;
        private String SORTFOOD_ID;
        private String SHOPPHONE;
        private int SHOPEVACOUNT;
        private String SHOPLONGITUDE;
        private String SHOPLATITUDE;
        private String SHOPNAMES;
        private double SHOPEVALUATE;

        public int getSHOPPRICE() {
            return SHOPPRICE;
        }

        public void setSHOPPRICE(int SHOPPRICE) {
            this.SHOPPRICE = SHOPPRICE;
        }

        public String getSHOPDETAILSIMGS() {
            return SHOPDETAILSIMGS;
        }

        public void setSHOPDETAILSIMGS(String SHOPDETAILSIMGS) {
            this.SHOPDETAILSIMGS = SHOPDETAILSIMGS;
        }

        public String getSHOWIMAGES() {
            return SHOWIMAGES;
        }

        public void setSHOWIMAGES(String SHOWIMAGES) {
            this.SHOWIMAGES = SHOWIMAGES;
        }

        public String getSHOPADDRESS() {
            return SHOPADDRESS;
        }

        public void setSHOPADDRESS(String SHOPADDRESS) {
            this.SHOPADDRESS = SHOPADDRESS;
        }

        public String getSORTFOOD_ID() {
            return SORTFOOD_ID;
        }

        public void setSORTFOOD_ID(String SORTFOOD_ID) {
            this.SORTFOOD_ID = SORTFOOD_ID;
        }

        public String getSHOPPHONE() {
            return SHOPPHONE;
        }

        public void setSHOPPHONE(String SHOPPHONE) {
            this.SHOPPHONE = SHOPPHONE;
        }

        public int getSHOPEVACOUNT() {
            return SHOPEVACOUNT;
        }

        public void setSHOPEVACOUNT(int SHOPEVACOUNT) {
            this.SHOPEVACOUNT = SHOPEVACOUNT;
        }

        public String getSHOPLONGITUDE() {
            return SHOPLONGITUDE;
        }

        public void setSHOPLONGITUDE(String SHOPLONGITUDE) {
            this.SHOPLONGITUDE = SHOPLONGITUDE;
        }

        public String getSHOPLATITUDE() {
            return SHOPLATITUDE;
        }

        public void setSHOPLATITUDE(String SHOPLATITUDE) {
            this.SHOPLATITUDE = SHOPLATITUDE;
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
    }
}
