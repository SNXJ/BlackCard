package com.zsh.blackcard.model;

import java.util.List;

/**
 * Name: AbMyFriendModel
 * Author: SNXJ
 * Date: 2017-12-06
 * Description:描述：
 */

public class AbMyFriendModel {
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
        private String NICKNAME;
        private String PORTRAIT;
        private String HONOURUSER_ID;
        private String FANSCOUNT;

        public String getFANSCOUNT() {
            return FANSCOUNT;
        }

        public void setFANSCOUNT(String FANSCOUNT) {
            this.FANSCOUNT = FANSCOUNT;
        }

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

        public String getHONOURUSER_ID() {
            return HONOURUSER_ID;
        }

        public void setHONOURUSER_ID(String HONOURUSER_ID) {
            this.HONOURUSER_ID = HONOURUSER_ID;
        }
    }
}
