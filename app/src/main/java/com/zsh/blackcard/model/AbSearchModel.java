package com.zsh.blackcard.model;

import java.util.List;

/**
 * Name: AbSearchModel
 * Author: Shing
 * Date: 2018/1/31 上午10:49
 * Description: ..
 */

public class AbSearchModel {


    /**
     * result : 01
     * pd : [{"NICKNAME":"菜鸡维","HONOURUSER_ID":"392272912112943104"}]
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
         * NICKNAME : 菜鸡维
         * HONOURUSER_ID : 392272912112943104
         */

        private String NICKNAME;
        private String HONOURUSER_ID;

        public String getNICKNAME() {
            return NICKNAME;
        }

        public void setNICKNAME(String NICKNAME) {
            this.NICKNAME = NICKNAME;
        }

        public String getHONOURUSER_ID() {
            return HONOURUSER_ID;
        }

        public void setHONOURUSER_ID(String HONOURUSER_ID) {
            this.HONOURUSER_ID = HONOURUSER_ID;
        }
    }
}
