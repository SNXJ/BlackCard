package com.zsh.blackcard.model;

/**
 * Name: LiveAnchorMoreModel
 * Author: Shing
 * Date: 2018/2/2 下午4:57
 * Description: ..
 */

public class LiveAnchorMoreModel {


    /**
     * result : 01
     * pd : {"NICKNAME":"White55开","SEX":"男","SIGNNAME":"也不知道签名写点什么","BIRTHDAY":"1996-12-07"}
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
         * SEX : 男
         * SIGNNAME : 也不知道签名写点什么
         * BIRTHDAY : 1996-12-07
         */

        private String NICKNAME;
        private String SEX;
        private String SIGNNAME;
        private String BIRTHDAY;

        public String getNICKNAME() {
            return NICKNAME;
        }

        public void setNICKNAME(String NICKNAME) {
            this.NICKNAME = NICKNAME;
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

        public String getBIRTHDAY() {
            return BIRTHDAY;
        }

        public void setBIRTHDAY(String BIRTHDAY) {
            this.BIRTHDAY = BIRTHDAY;
        }
    }
}
