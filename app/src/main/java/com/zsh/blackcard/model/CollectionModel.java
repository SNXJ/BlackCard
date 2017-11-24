package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/24.
 * 炫购收藏页面
 */

public class CollectionModel {

    /**
     * result : 01
     * pd : [{"PROTITLE":"欧米伽手表标题","PROPRICE":18888,"PRODUCT_ID":"382984525619134464"},{"PROTITLE":"卡地亚珠宝标题","PROPRICE":22222,"PRODUCT_ID":"382974470014369792"},{"PROTITLE":"欧米伽手表标题","PROPRICE":18888,"PRODUCT_ID":"382984525619134464"},{"PROTITLE":"卡地亚珠宝标题","PROPRICE":22222,"PRODUCT_ID":"382984525619134464"}]
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
         * PROTITLE : 欧米伽手表标题
         * PROPRICE : 18888.0
         * PRODUCT_ID : 382984525619134464
         */

        private String PROTITLE;
        private double PROPRICE;
        private String PRODUCT_ID;

        public String getPROTITLE() {
            return PROTITLE;
        }

        public void setPROTITLE(String PROTITLE) {
            this.PROTITLE = PROTITLE;
        }

        public double getPROPRICE() {
            return PROPRICE;
        }

        public void setPROPRICE(double PROPRICE) {
            this.PROPRICE = PROPRICE;
        }

        public String getPRODUCT_ID() {
            return PRODUCT_ID;
        }

        public void setPRODUCT_ID(String PRODUCT_ID) {
            this.PRODUCT_ID = PRODUCT_ID;
        }
    }
}
