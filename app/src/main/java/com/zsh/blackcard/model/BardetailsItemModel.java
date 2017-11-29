package com.zsh.blackcard.model;

import java.util.List;

/**
 * Name: BardetailsItemModel
 * Author: SNXJ
 * Date: 2017-11-27
 * Description:描述：
 */
public class BardetailsItemModel {

    /**
     * result : 01
     * pd : [{"SORTBAR_ID":"383578103407968256","BARDETPRICE":222,"BARDETTITLE":"酒吧套餐2","BARDETEND":"14:00","BARDETBEGIN":"12:00","BARDETAIL_ID":"384016591244754944","BARDETNUM":12},{"SORTBAR_ID":"383578103407968256","BARDETPRICE":111,"BARDETTITLE":"酒吧套餐1","BARDETEND":"5:00","BARDETBEGIN":"3:00","BARDETAIL_ID":"384016720660004864","BARDETNUM":11}]
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
         * SORTBAR_ID : 383578103407968256
         * BARDETPRICE : 222
         * BARDETTITLE : 酒吧套餐2
         * BARDETEND : 14:00
         * BARDETBEGIN : 12:00
         * BARDETAIL_ID : 384016591244754944
         * BARDETNUM : 12
         */

        private String SORTBAR_ID;
        private int BARDETPRICE;
        private String BARDETTITLE;
        private String BARDETEND;
        private String BARDETBEGIN;
        private String BARDETAIL_ID;
        private int BARDETNUM;

        public String getSORTBAR_ID() {
            return SORTBAR_ID;
        }

        public void setSORTBAR_ID(String SORTBAR_ID) {
            this.SORTBAR_ID = SORTBAR_ID;
        }

        public int getBARDETPRICE() {
            return BARDETPRICE;
        }

        public void setBARDETPRICE(int BARDETPRICE) {
            this.BARDETPRICE = BARDETPRICE;
        }

        public String getBARDETTITLE() {
            return BARDETTITLE;
        }

        public void setBARDETTITLE(String BARDETTITLE) {
            this.BARDETTITLE = BARDETTITLE;
        }

        public String getBARDETEND() {
            return BARDETEND;
        }

        public void setBARDETEND(String BARDETEND) {
            this.BARDETEND = BARDETEND;
        }

        public String getBARDETBEGIN() {
            return BARDETBEGIN;
        }

        public void setBARDETBEGIN(String BARDETBEGIN) {
            this.BARDETBEGIN = BARDETBEGIN;
        }

        public String getBARDETAIL_ID() {
            return BARDETAIL_ID;
        }

        public void setBARDETAIL_ID(String BARDETAIL_ID) {
            this.BARDETAIL_ID = BARDETAIL_ID;
        }

        public int getBARDETNUM() {
            return BARDETNUM;
        }

        public void setBARDETNUM(int BARDETNUM) {
            this.BARDETNUM = BARDETNUM;
        }
    }
}
