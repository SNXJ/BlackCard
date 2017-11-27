package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/27.
 * 尊购页面轮播图实体类
 */

public class ZgBannerModel {

    /**
     * result : 01
     * pd : {"SHOWIMAGES":["http://47.104.16.215:8088/productimgs/productimg/carouselfigureimgs/e3e7f8cf0a124030b17a724c0503a7ae.jpg","http://47.104.16.215:8088/productimgs/productimg/carouselfigureimgs/724d591204554ab18beb9ce740422870.jpg"],"STATUS":"1","UPLOADTIME":"2017-11-20","TITLE":"美食1","CAROUSELFIGURE_ID":"7f4eb925386e4991b7cbff2bca1b4ece"}
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
         * SHOWIMAGES : ["http://47.104.16.215:8088/productimgs/productimg/carouselfigureimgs/e3e7f8cf0a124030b17a724c0503a7ae.jpg","http://47.104.16.215:8088/productimgs/productimg/carouselfigureimgs/724d591204554ab18beb9ce740422870.jpg"]
         * STATUS : 1
         * UPLOADTIME : 2017-11-20
         * TITLE : 美食1
         * CAROUSELFIGURE_ID : 7f4eb925386e4991b7cbff2bca1b4ece
         */

        private String STATUS;
        private String UPLOADTIME;
        private String TITLE;
        private String CAROUSELFIGURE_ID;
        private List<String> SHOWIMAGES;

        public String getSTATUS() {
            return STATUS;
        }

        public void setSTATUS(String STATUS) {
            this.STATUS = STATUS;
        }

        public String getUPLOADTIME() {
            return UPLOADTIME;
        }

        public void setUPLOADTIME(String UPLOADTIME) {
            this.UPLOADTIME = UPLOADTIME;
        }

        public String getTITLE() {
            return TITLE;
        }

        public void setTITLE(String TITLE) {
            this.TITLE = TITLE;
        }

        public String getCAROUSELFIGURE_ID() {
            return CAROUSELFIGURE_ID;
        }

        public void setCAROUSELFIGURE_ID(String CAROUSELFIGURE_ID) {
            this.CAROUSELFIGURE_ID = CAROUSELFIGURE_ID;
        }

        public List<String> getSHOWIMAGES() {
            return SHOWIMAGES;
        }

        public void setSHOWIMAGES(List<String> SHOWIMAGES) {
            this.SHOWIMAGES = SHOWIMAGES;
        }
    }
}
