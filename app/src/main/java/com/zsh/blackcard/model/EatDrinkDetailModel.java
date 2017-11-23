package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/23.
 * 汇聚指定聚会查看详情实体类
 */

public class EatDrinkDetailModel {

    /**
     * result : 01
     * pd : {"CONVERGETYPE":"jiuba","PRICEMAX":200,"ENDTIME":"2017-11-21","AGEMIN":18,"CONVERGEDETAIL_ID":"611861fdbf794fc5b25550f23c92aa3b","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","CONVERGESEX":1,"AGEMAX":30,"STARTTIME":"2017-11-20","CONVERGEDET":"你猜","CONVERGE_ID":"382889968336371712","PRICEMIN":100,"CONVERGEPER":"15","CONVERGEIMGS":["http://47.104.16.215:8088/convergeimgs/convergedetimgs/2.jpg","http://47.104.16.215:8088/convergeimgs/convergedetimgs/3.jpg","http://47.104.16.215:8088/convergeimgs/convergedetimgs/4.jpg","http://47.104.16.215:8088/convergeimgs/convergedetimgs/5.jpg"],"CONVERGETITLE":"LOL对赛"}
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
         * CONVERGETYPE : jiuba
         * PRICEMAX : 200
         * ENDTIME : 2017-11-21
         * AGEMIN : 18
         * CONVERGEDETAIL_ID : 611861fdbf794fc5b25550f23c92aa3b
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         * CONVERGESEX : 1
         * AGEMAX : 30
         * STARTTIME : 2017-11-20
         * CONVERGEDET : 你猜
         * CONVERGE_ID : 382889968336371712
         * PRICEMIN : 100
         * CONVERGEPER : 15
         * CONVERGEIMGS : ["http://47.104.16.215:8088/convergeimgs/convergedetimgs/2.jpg","http://47.104.16.215:8088/convergeimgs/convergedetimgs/3.jpg","http://47.104.16.215:8088/convergeimgs/convergedetimgs/4.jpg","http://47.104.16.215:8088/convergeimgs/convergedetimgs/5.jpg"]
         * CONVERGETITLE : LOL对赛
         */

        private String CONVERGETYPE;
        private int PRICEMAX;
        private String ENDTIME;
        private int AGEMIN;
        private String CONVERGEDETAIL_ID;
        private String HONOURUSER_ID;
        private int CONVERGESEX;
        private int AGEMAX;
        private String STARTTIME;
        private String CONVERGEDET;
        private String CONVERGE_ID;
        private int PRICEMIN;
        private String CONVERGEPER;
        private String CONVERGETITLE;
        private List<String> CONVERGEIMGS;

        public String getCONVERGETYPE() {
            return CONVERGETYPE;
        }

        public void setCONVERGETYPE(String CONVERGETYPE) {
            this.CONVERGETYPE = CONVERGETYPE;
        }

        public int getPRICEMAX() {
            return PRICEMAX;
        }

        public void setPRICEMAX(int PRICEMAX) {
            this.PRICEMAX = PRICEMAX;
        }

        public String getENDTIME() {
            return ENDTIME;
        }

        public void setENDTIME(String ENDTIME) {
            this.ENDTIME = ENDTIME;
        }

        public int getAGEMIN() {
            return AGEMIN;
        }

        public void setAGEMIN(int AGEMIN) {
            this.AGEMIN = AGEMIN;
        }

        public String getCONVERGEDETAIL_ID() {
            return CONVERGEDETAIL_ID;
        }

        public void setCONVERGEDETAIL_ID(String CONVERGEDETAIL_ID) {
            this.CONVERGEDETAIL_ID = CONVERGEDETAIL_ID;
        }

        public String getHONOURUSER_ID() {
            return HONOURUSER_ID;
        }

        public void setHONOURUSER_ID(String HONOURUSER_ID) {
            this.HONOURUSER_ID = HONOURUSER_ID;
        }

        public int getCONVERGESEX() {
            return CONVERGESEX;
        }

        public void setCONVERGESEX(int CONVERGESEX) {
            this.CONVERGESEX = CONVERGESEX;
        }

        public int getAGEMAX() {
            return AGEMAX;
        }

        public void setAGEMAX(int AGEMAX) {
            this.AGEMAX = AGEMAX;
        }

        public String getSTARTTIME() {
            return STARTTIME;
        }

        public void setSTARTTIME(String STARTTIME) {
            this.STARTTIME = STARTTIME;
        }

        public String getCONVERGEDET() {
            return CONVERGEDET;
        }

        public void setCONVERGEDET(String CONVERGEDET) {
            this.CONVERGEDET = CONVERGEDET;
        }

        public String getCONVERGE_ID() {
            return CONVERGE_ID;
        }

        public void setCONVERGE_ID(String CONVERGE_ID) {
            this.CONVERGE_ID = CONVERGE_ID;
        }

        public int getPRICEMIN() {
            return PRICEMIN;
        }

        public void setPRICEMIN(int PRICEMIN) {
            this.PRICEMIN = PRICEMIN;
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

        public List<String> getCONVERGEIMGS() {
            return CONVERGEIMGS;
        }

        public void setCONVERGEIMGS(List<String> CONVERGEIMGS) {
            this.CONVERGEIMGS = CONVERGEIMGS;
        }
    }
}
