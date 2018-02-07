package com.zsh.blackcard.model;

/**
 * Name: AbMyModel
 * Author: Shing
 * Date: 2018/2/5 下午2:56
 * Description: ..
 */

public class AbMyModel {


    /**
     * result : 01
     * pd : {"NICKNAME":"White55开","PORTRAIT":"http://image.rongyaohk.com/userportrait/e6765efb97a84e60b9f381247a2a448b.jpg","BLACKCOIN":95,"FOCUSCOUNT":1,"HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","FANSCOUNT":1}
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
         * NICKNAME : White55开
         * PORTRAIT : http://image.rongyaohk.com/userportrait/e6765efb97a84e60b9f381247a2a448b.jpg
         * BLACKCOIN : 95
         * FOCUSCOUNT : 1
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         * FANSCOUNT : 1
         */

        private String NICKNAME;
        private String PORTRAIT;
        private String BLACKCOIN;
        private String FOCUSCOUNT;
        private String HONOURUSER_ID;
        private String FANSCOUNT;

        public String getNICKNAME() {
            return NICKNAME;
        }

        public void setNICKNAME(String NICKNAME) {
            this.NICKNAME = NICKNAME;
        }

        public String getPORTRAIT() {
            return PORTRAIT;
        }

        public void setPORTRAIT(String PORTRAIT) {
            this.PORTRAIT = PORTRAIT;
        }

        public String getBLACKCOIN() {
            return BLACKCOIN;
        }

        public void setBLACKCOIN(String BLACKCOIN) {
            this.BLACKCOIN = BLACKCOIN;
        }

        public String getFOCUSCOUNT() {
            return FOCUSCOUNT;
        }

        public void setFOCUSCOUNT(String FOCUSCOUNT) {
            this.FOCUSCOUNT = FOCUSCOUNT;
        }

        public String getHONOURUSER_ID() {
            return HONOURUSER_ID;
        }

        public void setHONOURUSER_ID(String HONOURUSER_ID) {
            this.HONOURUSER_ID = HONOURUSER_ID;
        }

        public String getFANSCOUNT() {
            return FANSCOUNT;
        }

        public void setFANSCOUNT(String FANSCOUNT) {
            this.FANSCOUNT = FANSCOUNT;
        }
    }
}
