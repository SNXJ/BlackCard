package com.zsh.blackcard.model;

/**
 * Name: LoginModel
 * Author: SNXJ
 * Date: 2017-11-20
 * Description:描述：
 */
public class LoginModel {
    /**
     * result : 01
     * pd : {"START_TIME":"2015-12-02","NUMBER":"111","RIGHTS":"","IP":"","PHONE":"17601680524","SFID":"1212","USER_ID":"1e89e6504be349a68c025976b3ecc1d1","LAST_LOGIN":"","EMAIL":"313596790@qq.com","NAME":"会员甲","YEARS":2,"STATUS":"1","END_TIME":"2015-12-25","PASSWORD":"698d51a19d8a121ce581499d7b701668","BZ":"121","USERNAME":"a1","ROLE_ID":"115b386ff04f4352b060dffcd2b5d1da"}
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
         * START_TIME : 2015-12-02
         * NUMBER : 111
         * RIGHTS :
         * IP :
         * PHONE : 17601680524
         * SFID : 1212
         * USER_ID : 1e89e6504be349a68c025976b3ecc1d1
         * LAST_LOGIN :
         * EMAIL : 313596790@qq.com
         * NAME : 会员甲
         * YEARS : 2
         * STATUS : 1
         * END_TIME : 2015-12-25
         * PASSWORD : 698d51a19d8a121ce581499d7b701668
         * BZ : 121
         * USERNAME : a1
         * ROLE_ID : 115b386ff04f4352b060dffcd2b5d1da
         */

        private String START_TIME;
        private String NUMBER;
        private String RIGHTS;
        private String IP;
        private String PHONE;
        private String SFID;
        private String USER_ID;
        private String LAST_LOGIN;
        private String EMAIL;
        private String NAME;
        private int YEARS;
        private String STATUS;
        private String END_TIME;
        private String PASSWORD;
        private String BZ;
        private String USERNAME;
        private String ROLE_ID;

        public String getSTART_TIME() {
            return START_TIME;
        }

        public void setSTART_TIME(String START_TIME) {
            this.START_TIME = START_TIME;
        }

        public String getNUMBER() {
            return NUMBER;
        }

        public void setNUMBER(String NUMBER) {
            this.NUMBER = NUMBER;
        }

        public String getRIGHTS() {
            return RIGHTS;
        }

        public void setRIGHTS(String RIGHTS) {
            this.RIGHTS = RIGHTS;
        }

        public String getIP() {
            return IP;
        }

        public void setIP(String IP) {
            this.IP = IP;
        }

        public String getPHONE() {
            return PHONE;
        }

        public void setPHONE(String PHONE) {
            this.PHONE = PHONE;
        }

        public String getSFID() {
            return SFID;
        }

        public void setSFID(String SFID) {
            this.SFID = SFID;
        }

        public String getUSER_ID() {
            return USER_ID;
        }

        public void setUSER_ID(String USER_ID) {
            this.USER_ID = USER_ID;
        }

        public String getLAST_LOGIN() {
            return LAST_LOGIN;
        }

        public void setLAST_LOGIN(String LAST_LOGIN) {
            this.LAST_LOGIN = LAST_LOGIN;
        }

        public String getEMAIL() {
            return EMAIL;
        }

        public void setEMAIL(String EMAIL) {
            this.EMAIL = EMAIL;
        }

        public String getNAME() {
            return NAME;
        }

        public void setNAME(String NAME) {
            this.NAME = NAME;
        }

        public int getYEARS() {
            return YEARS;
        }

        public void setYEARS(int YEARS) {
            this.YEARS = YEARS;
        }

        public String getSTATUS() {
            return STATUS;
        }

        public void setSTATUS(String STATUS) {
            this.STATUS = STATUS;
        }

        public String getEND_TIME() {
            return END_TIME;
        }

        public void setEND_TIME(String END_TIME) {
            this.END_TIME = END_TIME;
        }

        public String getPASSWORD() {
            return PASSWORD;
        }

        public void setPASSWORD(String PASSWORD) {
            this.PASSWORD = PASSWORD;
        }

        public String getBZ() {
            return BZ;
        }

        public void setBZ(String BZ) {
            this.BZ = BZ;
        }

        public String getUSERNAME() {
            return USERNAME;
        }

        public void setUSERNAME(String USERNAME) {
            this.USERNAME = USERNAME;
        }

        public String getROLE_ID() {
            return ROLE_ID;
        }

        public void setROLE_ID(String ROLE_ID) {
            this.ROLE_ID = ROLE_ID;
        }
    }
}
