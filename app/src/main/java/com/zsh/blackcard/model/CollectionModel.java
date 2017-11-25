package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/24.
 * 炫购收藏页面
 */

public class CollectionModel {

    /**
     * result : 01
     * pd : [{"PROTITLE":"天梭手表的标题","PROPRICE":28888,"PROSHOWIMG":"http://47.104.16.215:8088/productimgs/productshowimgs/c8a97a262b8640f2aae2305507332405.png","PRODUCT_ID":"383674340182327296"},{"PROTITLE":"天梭手表的标题","PROPRICE":28888,"PROSHOWIMG":"http://47.104.16.215:8088/productimgs/productshowimgs/c8a97a262b8640f2aae2305507332405.png","PRODUCT_ID":"383674340182327296"}]
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
         * PROTITLE : 天梭手表的标题
         * PROPRICE : 28888.0
         * PROSHOWIMG : http://47.104.16.215:8088/productimgs/productshowimgs/c8a97a262b8640f2aae2305507332405.png
         * PRODUCT_ID : 383674340182327296
         */

        private String PROTITLE;
        private double PROPRICE;
        private String PROSHOWIMG;
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

        public String getPROSHOWIMG() {
            return PROSHOWIMG;
        }

        public void setPROSHOWIMG(String PROSHOWIMG) {
            this.PROSHOWIMG = PROSHOWIMG;
        }

        public String getPRODUCT_ID() {
            return PRODUCT_ID;
        }

        public void setPRODUCT_ID(String PRODUCT_ID) {
            this.PRODUCT_ID = PRODUCT_ID;
        }
    }
}
