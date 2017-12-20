package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/12/19.
 * 商品详情类
 */

public class CommodityDetailModel {

    /**
     * result : 01
     * evaList : [{"NICKNAME":"******","EVALUATECONTENT":"包包本不错哦","PORTRAIT":"http://47.104.16.215:8088/userportrait/e6765efb97a84e60b9f381247a2a448b.jpg","PRODUCTEVALUATE_ID":"392331613750427648","EVALUATECOINT":4.7,"PRODUCT_ID":"388354150699630592","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","EVALUATEDATE":"2017-12-18"},{"NICKNAME":"******","EVALUATECONTENT":"包包是我买过最好的","PORTRAIT":"http://47.104.16.215:8088/userportrait/e3e8b2119dfa4a1c85abfa7e3eef7a98.jpg","PRODUCTEVALUATE_ID":"392332120623677440","EVALUATECOINT":5,"PRODUCT_ID":"388354150699630592","HONOURUSER_ID":"388279486010884100","EVALUATEDATE":"2017-12-18"},{"NICKNAME":"******","EVALUATECONTENT":"包包是我买过最好的","PORTRAIT":"http://47.104.16.215:8088/userportrait/e3e8b2119dfa4a1c85abfa7e3eef7a98.jpg","PRODUCTEVALUATE_ID":"392358479349678080","EVALUATECOINT":0,"PRODUCT_ID":"388354150699630592","HONOURUSER_ID":"388279486010884100","EVALUATEDATE":"2017-12-18"}]
     * pd : {"BRAND_ID":"a34d1f14a4b7481e8284ad4ba97a496b","PROEVALUATE":3.2,"PRODETAILSIMG":["http://47.104.16.215:8088/productimgs/prodetimgs/goods_image_113@2x.png","http://47.104.16.215:8088/productimgs/prodetimgs/goods_image_113@3x.png"],"PRODUCTIMG":["http://47.104.16.215:8088/productimgs/productimg/f3d5140931344d2e9f4e6644ae2c4efc.png","http://47.104.16.215:8088/productimgs/productimg/75a3ef3d2a624d70b68e1cb827b0ba95.png","http://47.104.16.215:8088/productimgs/productimg/4e6d7c575b9b4a86a045b83bab9d786d.png"],"PROPROPERTY":{"产地":"瑞士","防水":"日常生活防水","表带材质":"真皮","保修":"全国联保","表径":"42mm"},"PROTITLE":"Gucci/古奇 黑色虎头马刺扣链条手提包","PROPRICE":5688,"PRODETAILSINT":"古驰-1921年创立于意大利佛罗伦萨，是全球卓越的奢华精品品牌之一。以其卓越的品质和精湛的意大利工艺闻名于世，旗下精品包括皮件、鞋履、香氛、珠宝和腕表","PROCOLOR":"#000000","EVALUATECOUNT":3,"PRODUCT_ID":"388354150699630592","PROBRAND":"手提包"}
     */

    private String result;
    private PdBean pd;
    private List<EvaListBean> evaList;

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

    public List<EvaListBean> getEvaList() {
        return evaList;
    }

    public void setEvaList(List<EvaListBean> evaList) {
        this.evaList = evaList;
    }

    public static class PdBean {
        /**
         * BRAND_ID : a34d1f14a4b7481e8284ad4ba97a496b
         * PROEVALUATE : 3.2
         * PRODETAILSIMG : ["http://47.104.16.215:8088/productimgs/prodetimgs/goods_image_113@2x.png","http://47.104.16.215:8088/productimgs/prodetimgs/goods_image_113@3x.png"]
         * PRODUCTIMG : ["http://47.104.16.215:8088/productimgs/productimg/f3d5140931344d2e9f4e6644ae2c4efc.png","http://47.104.16.215:8088/productimgs/productimg/75a3ef3d2a624d70b68e1cb827b0ba95.png","http://47.104.16.215:8088/productimgs/productimg/4e6d7c575b9b4a86a045b83bab9d786d.png"]
         * PROPROPERTY : {"产地":"瑞士","防水":"日常生活防水","表带材质":"真皮","保修":"全国联保","表径":"42mm"}
         * PROTITLE : Gucci/古奇 黑色虎头马刺扣链条手提包
         * PROPRICE : 5688
         * PRODETAILSINT : 古驰-1921年创立于意大利佛罗伦萨，是全球卓越的奢华精品品牌之一。以其卓越的品质和精湛的意大利工艺闻名于世，旗下精品包括皮件、鞋履、香氛、珠宝和腕表
         * PROCOLOR : #000000
         * EVALUATECOUNT : 3
         * PRODUCT_ID : 388354150699630592
         * PROBRAND : 手提包
         */

        private String BRAND_ID;
        private double PROEVALUATE;
        private PROPROPERTYBean PROPROPERTY;
        private String PROTITLE;
        private int PROPRICE;
        private String PRODETAILSINT;
        private String PROCOLOR;
        private int EVALUATECOUNT;
        private String PRODUCT_ID;
        private String PROBRAND;
        private List<String> PRODETAILSIMG;
        private List<String> PRODUCTIMG;

        public String getBRAND_ID() {
            return BRAND_ID;
        }

        public void setBRAND_ID(String BRAND_ID) {
            this.BRAND_ID = BRAND_ID;
        }

        public double getPROEVALUATE() {
            return PROEVALUATE;
        }

        public void setPROEVALUATE(double PROEVALUATE) {
            this.PROEVALUATE = PROEVALUATE;
        }

        public PROPROPERTYBean getPROPROPERTY() {
            return PROPROPERTY;
        }

        public void setPROPROPERTY(PROPROPERTYBean PROPROPERTY) {
            this.PROPROPERTY = PROPROPERTY;
        }

        public String getPROTITLE() {
            return PROTITLE;
        }

        public void setPROTITLE(String PROTITLE) {
            this.PROTITLE = PROTITLE;
        }

        public int getPROPRICE() {
            return PROPRICE;
        }

        public void setPROPRICE(int PROPRICE) {
            this.PROPRICE = PROPRICE;
        }

        public String getPRODETAILSINT() {
            return PRODETAILSINT;
        }

        public void setPRODETAILSINT(String PRODETAILSINT) {
            this.PRODETAILSINT = PRODETAILSINT;
        }

        public String getPROCOLOR() {
            return PROCOLOR;
        }

        public void setPROCOLOR(String PROCOLOR) {
            this.PROCOLOR = PROCOLOR;
        }

        public int getEVALUATECOUNT() {
            return EVALUATECOUNT;
        }

        public void setEVALUATECOUNT(int EVALUATECOUNT) {
            this.EVALUATECOUNT = EVALUATECOUNT;
        }

        public String getPRODUCT_ID() {
            return PRODUCT_ID;
        }

        public void setPRODUCT_ID(String PRODUCT_ID) {
            this.PRODUCT_ID = PRODUCT_ID;
        }

        public String getPROBRAND() {
            return PROBRAND;
        }

        public void setPROBRAND(String PROBRAND) {
            this.PROBRAND = PROBRAND;
        }

        public List<String> getPRODETAILSIMG() {
            return PRODETAILSIMG;
        }

        public void setPRODETAILSIMG(List<String> PRODETAILSIMG) {
            this.PRODETAILSIMG = PRODETAILSIMG;
        }

        public List<String> getPRODUCTIMG() {
            return PRODUCTIMG;
        }

        public void setPRODUCTIMG(List<String> PRODUCTIMG) {
            this.PRODUCTIMG = PRODUCTIMG;
        }

        public static class PROPROPERTYBean {

        }
    }

    public static class EvaListBean {
        /**
         * NICKNAME : ******
         * EVALUATECONTENT : 包包本不错哦
         * PORTRAIT : http://47.104.16.215:8088/userportrait/e6765efb97a84e60b9f381247a2a448b.jpg
         * PRODUCTEVALUATE_ID : 392331613750427648
         * EVALUATECOINT : 4.7
         * PRODUCT_ID : 388354150699630592
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         * EVALUATEDATE : 2017-12-18
         */

        private String NICKNAME;
        private String EVALUATECONTENT;
        private String PORTRAIT;
        private String PRODUCTEVALUATE_ID;
        private double EVALUATECOINT;
        private String PRODUCT_ID;
        private String HONOURUSER_ID;
        private String EVALUATEDATE;

        public String getNICKNAME() {
            return NICKNAME;
        }

        public void setNICKNAME(String NICKNAME) {
            this.NICKNAME = NICKNAME;
        }

        public String getEVALUATECONTENT() {
            return EVALUATECONTENT;
        }

        public void setEVALUATECONTENT(String EVALUATECONTENT) {
            this.EVALUATECONTENT = EVALUATECONTENT;
        }

        public String getPORTRAIT() {
            return PORTRAIT;
        }

        public void setPORTRAIT(String PORTRAIT) {
            this.PORTRAIT = PORTRAIT;
        }

        public String getPRODUCTEVALUATE_ID() {
            return PRODUCTEVALUATE_ID;
        }

        public void setPRODUCTEVALUATE_ID(String PRODUCTEVALUATE_ID) {
            this.PRODUCTEVALUATE_ID = PRODUCTEVALUATE_ID;
        }

        public double getEVALUATECOINT() {
            return EVALUATECOINT;
        }

        public void setEVALUATECOINT(double EVALUATECOINT) {
            this.EVALUATECOINT = EVALUATECOINT;
        }

        public String getPRODUCT_ID() {
            return PRODUCT_ID;
        }

        public void setPRODUCT_ID(String PRODUCT_ID) {
            this.PRODUCT_ID = PRODUCT_ID;
        }

        public String getHONOURUSER_ID() {
            return HONOURUSER_ID;
        }

        public void setHONOURUSER_ID(String HONOURUSER_ID) {
            this.HONOURUSER_ID = HONOURUSER_ID;
        }

        public String getEVALUATEDATE() {
            return EVALUATEDATE;
        }

        public void setEVALUATEDATE(String EVALUATEDATE) {
            this.EVALUATEDATE = EVALUATEDATE;
        }
    }
}
