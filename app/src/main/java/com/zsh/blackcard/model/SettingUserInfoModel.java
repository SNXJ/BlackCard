package com.zsh.blackcard.model;

/**
 * Created by kkkkk on 2017/12/11.
 * 设置个人资料实体类
 */

public class SettingUserInfoModel {

    /**
     * result : 01
     * user : {"USERIDCARD":"","REALNAME":"yu","PORTRAIT":"http://47.104.16.215:8088/userportrait/0d41d194842b406e878d2d5c021c4286.fileName","PHONE":"17601680524","SEX":"男","SIGNNAME":"The ","SMALLCHANGE":0,"HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","NICKNAME":"Op","PASSWORD":"1","ADDRESS":"广东珠海香洲区","CUSTOM":0,"PROVINCE":"北京市","CARDNO":"10"}
     */

    private String result;
    private UserBean user;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean {
        /**
         * USERIDCARD :
         * REALNAME : yu
         * PORTRAIT : http://47.104.16.215:8088/userportrait/0d41d194842b406e878d2d5c021c4286.fileName
         * PHONE : 17601680524
         * SEX : 男
         * SIGNNAME : The
         * SMALLCHANGE : 0
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         * NICKNAME : Op
         * PASSWORD : 1
         * ADDRESS : 广东珠海香洲区
         * CUSTOM : 0
         * PROVINCE : 北京市
         * CARDNO : 10
         */

        private String USERIDCARD;
        private String REALNAME;
        private String PORTRAIT;
        private String PHONE;
        private String SEX;
        private String SIGNNAME;
        private int SMALLCHANGE;
        private String HONOURUSER_ID;
        private String NICKNAME;
        private String PASSWORD;
        private String ADDRESS;
        private int CUSTOM;
        private String PROVINCE;
        private String CARDNO;

        public String getUSERIDCARD() {
            return USERIDCARD;
        }

        public void setUSERIDCARD(String USERIDCARD) {
            this.USERIDCARD = USERIDCARD;
        }

        public String getREALNAME() {
            return REALNAME;
        }

        public void setREALNAME(String REALNAME) {
            this.REALNAME = REALNAME;
        }

        public String getPORTRAIT() {
            return PORTRAIT;
        }

        public void setPORTRAIT(String PORTRAIT) {
            this.PORTRAIT = PORTRAIT;
        }

        public String getPHONE() {
            return PHONE;
        }

        public void setPHONE(String PHONE) {
            this.PHONE = PHONE;
        }

        public String getSEX() {
            return SEX;
        }

        public void setSEX(String SEX) {
            this.SEX = SEX;
        }

        public String getSIGNNAME() {
            return SIGNNAME;
        }

        public void setSIGNNAME(String SIGNNAME) {
            this.SIGNNAME = SIGNNAME;
        }

        public int getSMALLCHANGE() {
            return SMALLCHANGE;
        }

        public void setSMALLCHANGE(int SMALLCHANGE) {
            this.SMALLCHANGE = SMALLCHANGE;
        }

        public String getHONOURUSER_ID() {
            return HONOURUSER_ID;
        }

        public void setHONOURUSER_ID(String HONOURUSER_ID) {
            this.HONOURUSER_ID = HONOURUSER_ID;
        }

        public String getNICKNAME() {
            return NICKNAME;
        }

        public void setNICKNAME(String NICKNAME) {
            this.NICKNAME = NICKNAME;
        }

        public String getPASSWORD() {
            return PASSWORD;
        }

        public void setPASSWORD(String PASSWORD) {
            this.PASSWORD = PASSWORD;
        }

        public String getADDRESS() {
            return ADDRESS;
        }

        public void setADDRESS(String ADDRESS) {
            this.ADDRESS = ADDRESS;
        }

        public int getCUSTOM() {
            return CUSTOM;
        }

        public void setCUSTOM(int CUSTOM) {
            this.CUSTOM = CUSTOM;
        }

        public String getPROVINCE() {
            return PROVINCE;
        }

        public void setPROVINCE(String PROVINCE) {
            this.PROVINCE = PROVINCE;
        }

        public String getCARDNO() {
            return CARDNO;
        }

        public void setCARDNO(String CARDNO) {
            this.CARDNO = CARDNO;
        }
    }
}
