package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/22.
 * 汇聚 吃喝玩乐 点击后的实体类
 */

public class EatDrinkModel {

    /**
     * result : 01
     * pd : [{"CONVERGETYPE":"jiuba","STARTTIME":"2017-11-20","ENDTIME":"2017-11-21","CONVERGEPER":"15","CONVERGETITLE":"LOL对赛","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"}]
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
         * CONVERGETYPE : jiuba
         * STARTTIME : 2017-11-20
         * ENDTIME : 2017-11-21
         * CONVERGEPER : 15
         * CONVERGETITLE : LOL对赛
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         */

        private String CONVERGETYPE;
        private String STARTTIME;
        private String ENDTIME;
        private String CONVERGEPER;
        private String CONVERGETITLE;
        private String HONOURUSER_ID;

        public String getCONVERGETYPE() {
            return CONVERGETYPE;
        }

        public void setCONVERGETYPE(String CONVERGETYPE) {
            this.CONVERGETYPE = CONVERGETYPE;
        }

        public String getSTARTTIME() {
            return STARTTIME;
        }

        public void setSTARTTIME(String STARTTIME) {
            this.STARTTIME = STARTTIME;
        }

        public String getENDTIME() {
            return ENDTIME;
        }

        public void setENDTIME(String ENDTIME) {
            this.ENDTIME = ENDTIME;
        }

        public String getCONVERGEPER() {
            return CONVERGEPER;
        }

        public void setCONVERGEPER(String CONVERGEPER) {
            this.CONVERGEPER = CONVERGEPER;
        }

        public String getCONVERGETITLE() {
            return CONVERGETITLE;
        }

        public void setCONVERGETITLE(String CONVERGETITLE) {
            this.CONVERGETITLE = CONVERGETITLE;
        }

        public String getHONOURUSER_ID() {
            return HONOURUSER_ID;
        }

        public void setHONOURUSER_ID(String HONOURUSER_ID) {
            this.HONOURUSER_ID = HONOURUSER_ID;
        }
    }
}
