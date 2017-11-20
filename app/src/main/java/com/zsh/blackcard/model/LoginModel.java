package com.zsh.blackcard.model;

/**
 * Created by kkkkk on 2017/11/20.
 */

public class LoginModel {

    /**
     * result : 01
     * pd : {"PASSWORD":"1","REALNAME":"yu","PHONE":"17601680524","ADDRESS":"2","PROVINCE":"B","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","CARDNO":"10"}
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
         * PASSWORD : 1
         * REALNAME : yu
         * PHONE : 17601680524
         * ADDRESS : 2
         * PROVINCE : B
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         * CARDNO : 10
         */

        private String PASSWORD;
        private String REALNAME;
        private String PHONE;
        private String ADDRESS;
        private String PROVINCE;
        private String HONOURUSER_ID;
        private String CARDNO;

        public String getPASSWORD() {
            return PASSWORD;
        }

        public void setPASSWORD(String PASSWORD) {
            this.PASSWORD = PASSWORD;
        }

        public String getREALNAME() {
            return REALNAME;
        }

        public void setREALNAME(String REALNAME) {
            this.REALNAME = REALNAME;
        }

        public String getPHONE() {
            return PHONE;
        }

        public void setPHONE(String PHONE) {
            this.PHONE = PHONE;
        }

        public String getADDRESS() {
            return ADDRESS;
        }

        public void setADDRESS(String ADDRESS) {
            this.ADDRESS = ADDRESS;
        }

        public String getPROVINCE() {
            return PROVINCE;
        }

        public void setPROVINCE(String PROVINCE) {
            this.PROVINCE = PROVINCE;
        }

        public String getHONOURUSER_ID() {
            return HONOURUSER_ID;
        }

        public void setHONOURUSER_ID(String HONOURUSER_ID) {
            this.HONOURUSER_ID = HONOURUSER_ID;
        }

        public String getCARDNO() {
            return CARDNO;
        }

        public void setCARDNO(String CARDNO) {
            this.CARDNO = CARDNO;
        }
    }
}
