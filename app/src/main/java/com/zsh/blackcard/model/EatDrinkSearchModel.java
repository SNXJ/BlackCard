package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by ZCY on 2017/12/26.
 * 吃喝玩乐查询条件实体类
 */

public class EatDrinkSearchModel {

    /**
     * result : 01
     * pd : [{"CONVERGESORT_ID":"395245760737705984","CONVERGE_ID":"382889968336371712","NAME":"吃"},{"CONVERGESORT_ID":"395245782434840576","CONVERGE_ID":"382889968336371712","NAME":"喝"},{"CONVERGESORT_ID":"395245804178112512","CONVERGE_ID":"382889968336371712","NAME":"玩"},{"CONVERGESORT_ID":"395245888764641280","CONVERGE_ID":"382889968336371712","NAME":"乐"}]
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
         * CONVERGESORT_ID : 395245760737705984
         * CONVERGE_ID : 382889968336371712
         * NAME : 吃
         */

        private String CONVERGESORT_ID;
        private String CONVERGE_ID;
        private String NAME;

        public String getCONVERGESORT_ID() {
            return CONVERGESORT_ID;
        }

        public void setCONVERGESORT_ID(String CONVERGESORT_ID) {
            this.CONVERGESORT_ID = CONVERGESORT_ID;
        }

        public String getCONVERGE_ID() {
            return CONVERGE_ID;
        }

        public void setCONVERGE_ID(String CONVERGE_ID) {
            this.CONVERGE_ID = CONVERGE_ID;
        }

        public String getNAME() {
            return NAME;
        }

        public void setNAME(String NAME) {
            this.NAME = NAME;
        }
    }
}
