package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/12/5.
 * 吃喝完了列表实体类
 */

public class EatDrinkRecyclerModel {

    /**
     * result : 01
     * pd : [{"CONVERGETYPE":"给力邀约","STARTTIME":"2017-11-20","ENDTIME":"2017-11-21","CONVERGEPER":"多对多","CONVERGEIMGS":["http://47.104.16.215:8088/convergeimgs/convergedetimgs/2.jpg","http://47.104.16.215:8088/convergeimgs/convergedetimgs/3.jpg","http://47.104.16.215:8088/convergeimgs/convergedetimgs/4.jpg","http://47.104.16.215:8088/convergeimgs/convergedetimgs/5.jpg"],"CONVERGEDETAIL_ID":"611861fdbf794fc5b25550f23c92aa3b","CONVERGETITLE":"LOL对赛","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"}]
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
         * CONVERGETYPE : 给力邀约
         * STARTTIME : 2017-11-20
         * ENDTIME : 2017-11-21
         * CONVERGEPER : 多对多
         * CONVERGEIMGS : ["http://47.104.16.215:8088/convergeimgs/convergedetimgs/2.jpg","http://47.104.16.215:8088/convergeimgs/convergedetimgs/3.jpg","http://47.104.16.215:8088/convergeimgs/convergedetimgs/4.jpg","http://47.104.16.215:8088/convergeimgs/convergedetimgs/5.jpg"]
         * CONVERGEDETAIL_ID : 611861fdbf794fc5b25550f23c92aa3b
         * CONVERGETITLE : LOL对赛
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         */

        private String CONVERGETYPE;
        private String STARTTIME;
        private String ENDTIME;
        private String CONVERGEPER;
        private String CONVERGEDETAIL_ID;
        private String CONVERGETITLE;
        private String HONOURUSER_ID;
        private List<String> CONVERGEIMGS;

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

        public String getCONVERGEDETAIL_ID() {
            return CONVERGEDETAIL_ID;
        }

        public void setCONVERGEDETAIL_ID(String CONVERGEDETAIL_ID) {
            this.CONVERGEDETAIL_ID = CONVERGEDETAIL_ID;
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

        public List<String> getCONVERGEIMGS() {
            return CONVERGEIMGS;
        }

        public void setCONVERGEIMGS(List<String> CONVERGEIMGS) {
            this.CONVERGEIMGS = CONVERGEIMGS;
        }
    }
}
