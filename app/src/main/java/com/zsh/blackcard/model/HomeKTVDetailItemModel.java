package com.zsh.blackcard.model;

import java.util.List;

/**
 * Name: HomeKTVDetailItemModel
 * Author: SNXJ
 * Date: 2017-11-24
 * Description:描述：
 */
public class HomeKTVDetailItemModel {
    /**
     * result : 01
     * pd : [{"KTVDETEND":"18:00","KTVDETAIL_ID":"383630596821221376","KTVDETNUM":10,"SORTKTV_ID":"2674579cf39f4bff8697801196f2e629","KTVDETPRICE":199,"KTVDETTYPE":"小包（1-3人）","KTVDETBEGIN":"9:00","KTVDETTITLE":"09:00-18:00内任选3小时"},{"KTVDETEND":"18:00","KTVDETAIL_ID":"383630785359380480","KTVDETNUM":5,"SORTKTV_ID":"2674579cf39f4bff8697801196f2e629","KTVDETPRICE":208,"KTVDETTYPE":"中包（1-3人）","KTVDETBEGIN":"12:00","KTVDETTITLE":"12:00-18:00内任选2小时"}]
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
         * KTVDETEND : 18:00
         * KTVDETAIL_ID : 383630596821221376
         * KTVDETNUM : 10
         * SORTKTV_ID : 2674579cf39f4bff8697801196f2e629
         * KTVDETPRICE : 199
         * KTVDETTYPE : 小包（1-3人）
         * KTVDETBEGIN : 9:00
         * KTVDETTITLE : 09:00-18:00内任选3小时
         */

        private String KTVDETEND;
        private String KTVDETAIL_ID;
        private int KTVDETNUM;
        private String SORTKTV_ID;
        private int KTVDETPRICE;
        private String KTVDETTYPE;
        private String KTVDETBEGIN;
        private String KTVDETTITLE;

        public String getKTVDETEND() {
            return KTVDETEND;
        }

        public void setKTVDETEND(String KTVDETEND) {
            this.KTVDETEND = KTVDETEND;
        }

        public String getKTVDETAIL_ID() {
            return KTVDETAIL_ID;
        }

        public void setKTVDETAIL_ID(String KTVDETAIL_ID) {
            this.KTVDETAIL_ID = KTVDETAIL_ID;
        }

        public int getKTVDETNUM() {
            return KTVDETNUM;
        }

        public void setKTVDETNUM(int KTVDETNUM) {
            this.KTVDETNUM = KTVDETNUM;
        }

        public String getSORTKTV_ID() {
            return SORTKTV_ID;
        }

        public void setSORTKTV_ID(String SORTKTV_ID) {
            this.SORTKTV_ID = SORTKTV_ID;
        }

        public int getKTVDETPRICE() {
            return KTVDETPRICE;
        }

        public void setKTVDETPRICE(int KTVDETPRICE) {
            this.KTVDETPRICE = KTVDETPRICE;
        }

        public String getKTVDETTYPE() {
            return KTVDETTYPE;
        }

        public void setKTVDETTYPE(String KTVDETTYPE) {
            this.KTVDETTYPE = KTVDETTYPE;
        }

        public String getKTVDETBEGIN() {
            return KTVDETBEGIN;
        }

        public void setKTVDETBEGIN(String KTVDETBEGIN) {
            this.KTVDETBEGIN = KTVDETBEGIN;
        }

        public String getKTVDETTITLE() {
            return KTVDETTITLE;
        }

        public void setKTVDETTITLE(String KTVDETTITLE) {
            this.KTVDETTITLE = KTVDETTITLE;
        }
    }
}

