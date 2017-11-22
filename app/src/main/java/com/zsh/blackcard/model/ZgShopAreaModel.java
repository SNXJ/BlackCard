package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/22.
 * 尊购商品专区，例如手表专区，包袋专区，都是点进去之后的子页面
 */

public class ZgShopAreaModel {


    /**
     * result : 01
     * pd : [{"BRAND_ID":"1b4ed4c57ef04933b97e8def48fc423a","PRODETAILSIMG":"","PRODUCTIMG":"75ed34e3d3bb45bdba6da9b931ad16df.png,b0da1b2c7e4640f1914857fd203b2f06.png,http://47.104.16.215:8088/productimgs/productimg/75ed34e3d3bb45bdba6da9b931ad16df.png,http://47.104.16.215:8088/productimgs/productimg/b0da1b2c7e4640f1914857fd203b2f06.png","PROPROPERTY":"暂无","PROTITLE":"天梭手表标题","PROPRICE":18888,"PRODETAILSINT":"天梭手表详情介绍","PROCOLOR":"#445866","PRODUCT_ID":"382902089497444352","PROBRAND":"天梭"},{"BRAND_ID":"1b4ed4c57ef04933b97e8def48fc423a","PRODETAILSIMG":"","PRODUCTIMG":"d7421a8bc0594003a3b21a61805bd1b8.png,http://47.104.16.215:8088/productimgs/productimg/d7421a8bc0594003a3b21a61805bd1b8.png,http://47.104.16.215:8088/productimgs/productimg/bcf84fa55f0846a6bc339f55e341a882.png","PROPROPERTY":"暂无","PROTITLE":"欧米伽标题","PROPRICE":22222,"PRODETAILSINT":"欧米伽介绍","PROCOLOR":"#436c8a","PRODUCT_ID":"382902529362493440","PROBRAND":"欧米伽"}]
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
         * BRAND_ID : 1b4ed4c57ef04933b97e8def48fc423a
         * PRODETAILSIMG :
         * PRODUCTIMG : 75ed34e3d3bb45bdba6da9b931ad16df.png,b0da1b2c7e4640f1914857fd203b2f06.png,http://47.104.16.215:8088/productimgs/productimg/75ed34e3d3bb45bdba6da9b931ad16df.png,http://47.104.16.215:8088/productimgs/productimg/b0da1b2c7e4640f1914857fd203b2f06.png
         * PROPROPERTY : 暂无
         * PROTITLE : 天梭手表标题
         * PROPRICE : 18888
         * PRODETAILSINT : 天梭手表详情介绍
         * PROCOLOR : #445866
         * PRODUCT_ID : 382902089497444352
         * PROBRAND : 天梭
         */

        private String BRAND_ID;
        private String PRODETAILSIMG;
        private String PRODUCTIMG;
        private String PROPROPERTY;
        private String PROTITLE;
        private int PROPRICE;
        private String PRODETAILSINT;
        private String PROCOLOR;
        private String PRODUCT_ID;
        private String PROBRAND;

        public String getBRAND_ID() {
            return BRAND_ID;
        }

        public void setBRAND_ID(String BRAND_ID) {
            this.BRAND_ID = BRAND_ID;
        }

        public String getPRODETAILSIMG() {
            return PRODETAILSIMG;
        }

        public void setPRODETAILSIMG(String PRODETAILSIMG) {
            this.PRODETAILSIMG = PRODETAILSIMG;
        }

        public String getPRODUCTIMG() {
            return PRODUCTIMG;
        }

        public void setPRODUCTIMG(String PRODUCTIMG) {
            this.PRODUCTIMG = PRODUCTIMG;
        }

        public String getPROPROPERTY() {
            return PROPROPERTY;
        }

        public void setPROPROPERTY(String PROPROPERTY) {
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
    }
}
