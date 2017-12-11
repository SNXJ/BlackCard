package com.zsh.blackcard.model;

import java.util.List;

/**
 * Name: FoodDetailsListModel
 * Author: SNXJ
 * Date: 2017-11-29
 * Description:描述：
 */
public class FoodDetailsMoreListModel {

    /**
     * result : 01
     * pd : [{"SHOPPRICE":299,"SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sortfoodimgs/sortfoodshowimgs/9c576b0cdfd94c388b1dc48cc37fd4a7.png","SHOPADDRESS":"北京市 北京市 朝阳区 广渠路 52号","SORTFOOD_ID":"382585869963362304","distance":"5.050353703962636","SHOPEVACOUNT":2,"SHOPNAMES":"菲罗牛排主题自助西餐厅双井分店","SHOPEVALUATE":2.8,"HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"},{"SHOPPRICE":399,"SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sortfoodimgs/sortfoodshowimgs/ca48ec53999a4adfaff3a0c8f84cf531.png","SHOPADDRESS":"北京市 北京市 朝阳区 潘家园路 甲1号","SORTFOOD_ID":"382585520535896064","distance":"5.942040455075951","SHOPEVACOUNT":6,"SHOPNAMES":"菲罗牛排主题自助西餐厅","SHOPEVALUATE":3.2,"HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"}]
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
         * SHOPPRICE : 299
         * SHOWIMAGES : http://47.104.16.215:8088/sortimgs/sortfoodimgs/sortfoodshowimgs/9c576b0cdfd94c388b1dc48cc37fd4a7.png
         * SHOPADDRESS : 北京市 北京市 朝阳区 广渠路 52号
         * SORTFOOD_ID : 382585869963362304
         * distance : 5.050353703962636
         * SHOPEVACOUNT : 2
         * SHOPNAMES : 菲罗牛排主题自助西餐厅双井分店
         * SHOPEVALUATE : 2.8
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         */

        private int SHOPPRICE;
        private String SHOWIMAGES;
        private String SHOPADDRESS;
        private String SORTFOOD_ID;
        private String distance;
        private int SHOPEVACOUNT;
        private String SHOPNAMES;
        private double SHOPEVALUATE;
        private String HONOURUSER_ID;

        public int getSHOPPRICE() {
            return SHOPPRICE;
        }

        public void setSHOPPRICE(int SHOPPRICE) {
            this.SHOPPRICE = SHOPPRICE;
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

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public int getSHOPEVACOUNT() {
            return SHOPEVACOUNT;
        }

        public void setSHOPEVACOUNT(int SHOPEVACOUNT) {
            this.SHOPEVACOUNT = SHOPEVACOUNT;
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

        public String getHONOURUSER_ID() {
            return HONOURUSER_ID;
        }

        public void setHONOURUSER_ID(String HONOURUSER_ID) {
            this.HONOURUSER_ID = HONOURUSER_ID;
        }
    }
}
