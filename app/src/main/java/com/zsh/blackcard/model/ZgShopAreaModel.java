package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/22.
 * 尊购商品专区，例如手表专区，包袋专区，都是点进去之后的子页面
 */

public class ZgShopAreaModel {

    /**
     * result : 01
     * pd : [{"PROTITLE":"天梭手表的标题","PROPRICE":28888,"PROSHOWIMG":"http://47.104.16.215:8088/productimgs/productshowimgs/c8a97a262b8640f2aae2305507332405.png","PRODUCT_ID":"383674340182327296"}]
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
         * PROPRICE : 28888
         * PROSHOWIMG : http://47.104.16.215:8088/productimgs/productshowimgs/c8a97a262b8640f2aae2305507332405.png
         * PRODUCT_ID : 383674340182327296
         */

        private String PROTITLE;
        private int PROPRICE;
        private String PROSHOWIMG;
        private String PRODUCT_ID;

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
