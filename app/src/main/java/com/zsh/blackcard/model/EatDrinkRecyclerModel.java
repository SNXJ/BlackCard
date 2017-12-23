package com.zsh.blackcard.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by kkkkk on 2017/12/5.
 * 吃喝完了列表实体类
 */

public class EatDrinkRecyclerModel {

    /**
     * result : 01
     * pd : [{"MYHONOURUSER_ID":"388279486010884096","CONVERGETYPE":"AA互动趴","distance":"293.74895958252796","ENDTIME":"2017-10-7","PORTRAIT":"http://47.104.16.215:8088/userportrait/e6765efb97a84e60b9f381247a2a448b.jpg","SEX":"男","CONVERGEDETAIL_ID":"384035671003627520","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","NICKNAME":"d6","STARTTIME":"2017-10-1","CONVERGEPER":"一对一","CONVERGEIMGS":["http://47.104.16.215:8088/convergeimgs/convergedetimgs/2.jpg","http://47.104.16.215:8088/convergeimgs/convergedetimgs/3.jpg","http://47.104.16.215:8088/convergeimgs/convergedetimgs/4.jpg","http://47.104.16.215:8088/convergeimgs/convergedetimgs/5.jpg"],"CONVERGETITLE":"一起去唱歌吧","BIRTHDAY":"1996-12-07","age":21},{"MYHONOURUSER_ID":"388279486010884096","CONVERGETYPE":"我请客","distance":"293.74895958252796","ENDTIME":"2017-12-26","PORTRAIT":"http://47.104.16.215:8088/userportrait/e6765efb97a84e60b9f381247a2a448b.jpg","SEX":"男","CONVERGEDETAIL_ID":"393471525786746880","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","NICKNAME":"d6","STARTTIME":"2017-12-28","CONVERGEPER":"5","CONVERGEIMGS":"","CONVERGETITLE":"振华","BIRTHDAY":"1996-12-07","age":21},{"MYHONOURUSER_ID":"388279486010884096","CONVERGETYPE":"AA","distance":"293.74895958252796","ENDTIME":"2017-12-21","PORTRAIT":"http://47.104.16.215:8088/userportrait/e6765efb97a84e60b9f381247a2a448b.jpg","SEX":"男","CONVERGEDETAIL_ID":"393472568532664320","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","NICKNAME":"d6","STARTTIME":"2017-12-21","CONVERGEPER":"0","CONVERGEIMGS":"","CONVERGETITLE":"啦啦啦","BIRTHDAY":"1996-12-07","age":21},{"MYHONOURUSER_ID":"388279486010884096","CONVERGETYPE":"AA","distance":"293.74895958252796","ENDTIME":"2017-12-22","PORTRAIT":"http://47.104.16.215:8088/userportrait/e6765efb97a84e60b9f381247a2a448b.jpg","SEX":"男","CONVERGEDETAIL_ID":"393718487186407424","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","NICKNAME":"d6","STARTTIME":"2017-12-22","CONVERGEPER":"0","CONVERGEIMGS":["http://47.104.16.215:8088/convergeimgs/launchactivityimgs/bf4b5fa2693643ba8518d16e94567827.jpg","http://47.104.16.215:8088/convergeimgs/launchactivityimgs/ae0b5f70f2224a78bf5371e23f0df4a4.JPEG"],"CONVERGETITLE":"啦啦啦","BIRTHDAY":"1996-12-07","age":21},{"MYHONOURUSER_ID":"388279486010884096","CONVERGETYPE":"AA","distance":"293.74895958252796","ENDTIME":"2017-12-22","PORTRAIT":"http://47.104.16.215:8088/userportrait/e6765efb97a84e60b9f381247a2a448b.jpg","SEX":"男","CONVERGEDETAIL_ID":"393719063517331456","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","NICKNAME":"d6","STARTTIME":"2017-12-22","CONVERGEPER":"0","CONVERGEIMGS":"","CONVERGETITLE":"开始","BIRTHDAY":"1996-12-07","age":21}]
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

    public static class PdBean implements MultiItemEntity {
        /**
         * MYHONOURUSER_ID : 388279486010884096
         * CONVERGETYPE : AA互动趴
         * distance : 293.74895958252796
         * ENDTIME : 2017-10-7
         * PORTRAIT : http://47.104.16.215:8088/userportrait/e6765efb97a84e60b9f381247a2a448b.jpg
         * SEX : 男
         * CONVERGEDETAIL_ID : 384035671003627520
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         * NICKNAME : d6
         * STARTTIME : 2017-10-1
         * CONVERGEPER : 一对一
         * CONVERGEIMGS : ["http://47.104.16.215:8088/convergeimgs/convergedetimgs/2.jpg","http://47.104.16.215:8088/convergeimgs/convergedetimgs/3.jpg","http://47.104.16.215:8088/convergeimgs/convergedetimgs/4.jpg","http://47.104.16.215:8088/convergeimgs/convergedetimgs/5.jpg"]
         * CONVERGETITLE : 一起去唱歌吧
         * BIRTHDAY : 1996-12-07
         * age : 21
         */

        private String MYHONOURUSER_ID;
        private String CONVERGETYPE;
        private String distance;
        private String ENDTIME;
        private String PORTRAIT;
        private String SEX;
        private String CONVERGEDETAIL_ID;
        private String HONOURUSER_ID;
        private String NICKNAME;
        private String STARTTIME;
        private String CONVERGEPER;
        private String CONVERGETITLE;
        private String BIRTHDAY;
        private int age;
        private List<String> CONVERGEIMGS;

        public String getMYHONOURUSER_ID() {
            return MYHONOURUSER_ID;
        }

        public void setMYHONOURUSER_ID(String MYHONOURUSER_ID) {
            this.MYHONOURUSER_ID = MYHONOURUSER_ID;
        }

        public String getCONVERGETYPE() {
            return CONVERGETYPE;
        }

        public void setCONVERGETYPE(String CONVERGETYPE) {
            this.CONVERGETYPE = CONVERGETYPE;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getENDTIME() {
            return ENDTIME;
        }

        public void setENDTIME(String ENDTIME) {
            this.ENDTIME = ENDTIME;
        }

        public String getPORTRAIT() {
            return PORTRAIT;
        }

        public void setPORTRAIT(String PORTRAIT) {
            this.PORTRAIT = PORTRAIT;
        }

        public String getSEX() {
            return SEX;
        }

        public void setSEX(String SEX) {
            this.SEX = SEX;
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

        public String getNICKNAME() {
            return NICKNAME;
        }

        public void setNICKNAME(String NICKNAME) {
            this.NICKNAME = NICKNAME;
        }

        public String getSTARTTIME() {
            return STARTTIME;
        }

        public void setSTARTTIME(String STARTTIME) {
            this.STARTTIME = STARTTIME;
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

        public String getBIRTHDAY() {
            return BIRTHDAY;
        }

        public void setBIRTHDAY(String BIRTHDAY) {
            this.BIRTHDAY = BIRTHDAY;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public List<String> getCONVERGEIMGS() {
            return CONVERGEIMGS;
        }

        public void setCONVERGEIMGS(List<String> CONVERGEIMGS) {
            this.CONVERGEIMGS = CONVERGEIMGS;
        }

        private int itemType;

        public static final int YES = 1;
        public static final int NO = 2;

        public void setItemType(int itemType) {
            this.itemType = itemType;
        }

        @Override
        public int getItemType() {
            return itemType;
        }
    }
}
