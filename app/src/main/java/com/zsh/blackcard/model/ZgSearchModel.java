package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/27.
 * 模糊查询实体类
 */

public class ZgSearchModel {

    /**
     * result : 01
     * pd : [{"BRAND_ID":"0e6184d78b374cfd8e97f9da5e34a835","BRANDNAME":"天梭腕表","ICONIMGS":"http://47.104.16.215:8088/productimgs/brandiconimgs/345211d0ea5d4f2198931caee8ad5e26.png","BRANDICON_ID":"383391618746548224"},{"BRAND_ID":"a8824559f11742d6acf0b07604a55337","BRANDNAME":"天然蜂蜜","ICONIMGS":"http://47.104.16.215:8088/productimgs/brandiconimgs/f59da296515e4724b971799adacd74f7.png","BRANDICON_ID":"383546747164557312"},{"BRAND_ID":"1b4ed4c57ef04933b97e8def48fc423a","BRANDNAME":"天梭","ICONIMGS":"http://47.104.16.215:8088/productimgs/brandiconimgs/949660e6138a4013976dff601e76a09d.png","BRANDICON_ID":"383548125043752960"}]
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
         * BRAND_ID : 0e6184d78b374cfd8e97f9da5e34a835
         * BRANDNAME : 天梭腕表
         * ICONIMGS : http://47.104.16.215:8088/productimgs/brandiconimgs/345211d0ea5d4f2198931caee8ad5e26.png
         * BRANDICON_ID : 383391618746548224
         */

        private String BRAND_ID;
        private String BRANDNAME;
        private String ICONIMGS;
        private String BRANDICON_ID;

        public String getBRAND_ID() {
            return BRAND_ID;
        }

        public void setBRAND_ID(String BRAND_ID) {
            this.BRAND_ID = BRAND_ID;
        }

        public String getBRANDNAME() {
            return BRANDNAME;
        }

        public void setBRANDNAME(String BRANDNAME) {
            this.BRANDNAME = BRANDNAME;
        }

        public String getICONIMGS() {
            return ICONIMGS;
        }

        public void setICONIMGS(String ICONIMGS) {
            this.ICONIMGS = ICONIMGS;
        }

        public String getBRANDICON_ID() {
            return BRANDICON_ID;
        }

        public void setBRANDICON_ID(String BRANDICON_ID) {
            this.BRANDICON_ID = BRANDICON_ID;
        }
    }
}
