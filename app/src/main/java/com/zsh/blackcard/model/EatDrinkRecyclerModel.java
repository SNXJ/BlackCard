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
     * ad : [{"SHOWIMG":"http://47.104.16.215:8088/advertisementimgs/d223c1c64da1434692a04189d53cf774.png","CONVERGE_ID":"382889968336371712","AD_POSITION":"0","CLICK_COUNT":1,"SORT_ORDER":1,"LINK_URL":"","ADVERTISEMENT_ID":"394912901892145152","NAME":"瓜子  免费估车"},{"SHOWIMG":"http://47.104.16.215:8088/advertisementimgs/8e0b351ccf024b1c81bbb49f8adc8126.png","CONVERGE_ID":"382889968336371712","AD_POSITION":"0","CLICK_COUNT":0,"SORT_ORDER":2,"LINK_URL":"","ADVERTISEMENT_ID":"394914800271884288","NAME":"买卖二手车上瓜子网"},{"SHOWIMG":"http://47.104.16.215:8088/advertisementimgs/51843249de7f4b6288d7a0f17c852919.png","CONVERGE_ID":"382889968336371712","AD_POSITION":"0","CLICK_COUNT":0,"SORT_ORDER":3,"LINK_URL":"","ADVERTISEMENT_ID":"394919861949562880","NAME":"三亚旅游节"}]
     * pd : [{"MYHONOURUSER_ID":"388279486010884096","CONVERGETYPE":"AA互动趴","distance":"293.74895958252796","ENDTIME":"2017-10-7","PORTRAIT":"http://47.104.16.215:8088/userportrait/e6765efb97a84e60b9f381247a2a448b.jpg","SEX":"男","CONVERGEDETAIL_ID":"384035671003627520","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","NICKNAME":"Ccc","STARTTIME":"2017-10-1","CONVERGEPER":"一对一","CONVERGEIMGS":["http://47.104.16.215:8088/convergeimgs/convergedetimgs/2.jpg","http://47.104.16.215:8088/convergeimgs/convergedetimgs/3.jpg","http://47.104.16.215:8088/convergeimgs/convergedetimgs/4.jpg","http://47.104.16.215:8088/convergeimgs/convergedetimgs/5.jpg"],"CONVERGETITLE":"一起去唱歌吧","BIRTHDAY":"1996-12-07","age":21},{"MYHONOURUSER_ID":"388279486010884096","CONVERGETYPE":"我请客","distance":"293.74895958252796","ENDTIME":"2017-12-26","PORTRAIT":"http://47.104.16.215:8088/userportrait/e6765efb97a84e60b9f381247a2a448b.jpg","SEX":"男","CONVERGEDETAIL_ID":"393471525786746880","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","NICKNAME":"Ccc","STARTTIME":"2017-12-28","CONVERGEPER":"5","CONVERGEIMGS":[],"CONVERGETITLE":"振华","BIRTHDAY":"1996-12-07","age":21},{"MYHONOURUSER_ID":"388279486010884096","CONVERGETYPE":"AA","distance":"293.74895958252796","ENDTIME":"2017-12-21","PORTRAIT":"http://47.104.16.215:8088/userportrait/e6765efb97a84e60b9f381247a2a448b.jpg","SEX":"男","CONVERGEDETAIL_ID":"393472568532664320","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","NICKNAME":"Ccc","STARTTIME":"2017-12-21","CONVERGEPER":"0","CONVERGEIMGS":[],"CONVERGETITLE":"啦啦啦","BIRTHDAY":"1996-12-07","age":21},{"MYHONOURUSER_ID":"388279486010884096","CONVERGETYPE":"AA","distance":"293.74895958252796","ENDTIME":"2017-12-22","PORTRAIT":"http://47.104.16.215:8088/userportrait/e6765efb97a84e60b9f381247a2a448b.jpg","SEX":"男","CONVERGEDETAIL_ID":"393718487186407424","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","NICKNAME":"Ccc","STARTTIME":"2017-12-22","CONVERGEPER":"0","CONVERGEIMGS":["http://47.104.16.215:8088/convergeimgs/launchactivityimgs/bf4b5fa2693643ba8518d16e94567827.jpg","http://47.104.16.215:8088/convergeimgs/launchactivityimgs/ae0b5f70f2224a78bf5371e23f0df4a4.JPEG"],"CONVERGETITLE":"啦啦啦","BIRTHDAY":"1996-12-07","age":21},{"MYHONOURUSER_ID":"388279486010884096","CONVERGETYPE":"AA","distance":"293.74895958252796","ENDTIME":"2017-12-22","PORTRAIT":"http://47.104.16.215:8088/userportrait/e6765efb97a84e60b9f381247a2a448b.jpg","SEX":"男","CONVERGEDETAIL_ID":"393719063517331456","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","NICKNAME":"Ccc","STARTTIME":"2017-12-22","CONVERGEPER":"0","CONVERGEIMGS":[],"CONVERGETITLE":"开始","BIRTHDAY":"1996-12-07","age":21},{"MYHONOURUSER_ID":"388279486010884096","CONVERGETYPE":"AA互动趴","distance":"293.74895958252796","ENDTIME":"2017-10-7","PORTRAIT":"http://47.104.16.215:8088/userportrait/e6765efb97a84e60b9f381247a2a448b.jpg","SEX":"男","CONVERGEDETAIL_ID":"393734139473297408","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","NICKNAME":"Ccc","STARTTIME":"2017-10-1","CONVERGEPER":"一对一","CONVERGEIMGS":["http://47.104.16.215:8088/convergeimgs/launchactivityimgs/8ead8a39ddd04a5b916a0c79d1572897.JPG","http://47.104.16.215:8088/convergeimgs/launchactivityimgs/a8967007f0f1472198763c2a440cf13d.JPG"],"CONVERGETITLE":"I'm ","BIRTHDAY":"1996-12-07","age":21},{"MYHONOURUSER_ID":"388279486010884096","CONVERGETYPE":"AA","distance":"293.74895958252796","ENDTIME":"2017-12-22","PORTRAIT":"http://47.104.16.215:8088/userportrait/e6765efb97a84e60b9f381247a2a448b.jpg","SEX":"男","CONVERGEDETAIL_ID":"393734711916101632","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","NICKNAME":"Ccc","STARTTIME":"2017-12-22","CONVERGEPER":"0","CONVERGEIMGS":["http://47.104.16.215:8088/convergeimgs/launchactivityimgs/65523c3299c3424097759d558a8a3592.JPEG","http://47.104.16.215:8088/convergeimgs/launchactivityimgs/659cebe196344abca68dd7ecb3e57be3.jpg"],"CONVERGETITLE":"太累了","BIRTHDAY":"1996-12-07","age":21},{"MYHONOURUSER_ID":"388279486010884096","CONVERGETYPE":"AA","distance":"293.74895958252796","ENDTIME":"2017-12-22","PORTRAIT":"http://47.104.16.215:8088/userportrait/e6765efb97a84e60b9f381247a2a448b.jpg","SEX":"男","CONVERGEDETAIL_ID":"393734955869405184","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","NICKNAME":"Ccc","STARTTIME":"2017-12-22","CONVERGEPER":"0","CONVERGEIMGS":["http://47.104.16.215:8088/convergeimgs/launchactivityimgs/e0edae3cc4514e25a586134406a42bf3.JPEG","http://47.104.16.215:8088/convergeimgs/launchactivityimgs/3a440b9af0f04ff3bef83ac4836fb05f.jpg"],"CONVERGETITLE":"太累了","BIRTHDAY":"1996-12-07","age":21},{"MYHONOURUSER_ID":"388279486010884096","CONVERGETYPE":"AA","distance":"293.74895958252796","ENDTIME":"2017-12-29","PORTRAIT":"http://47.104.16.215:8088/userportrait/e6765efb97a84e60b9f381247a2a448b.jpg","SEX":"男","CONVERGEDETAIL_ID":"393735347223134208","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","NICKNAME":"Ccc","STARTTIME":"2017-12-22","CONVERGEPER":"2","CONVERGEIMGS":["http://47.104.16.215:8088/convergeimgs/launchactivityimgs/4d14b0f085f241419655a39ae5ccb76e.jpg"],"CONVERGETITLE":"啦啦啦","BIRTHDAY":"1996-12-07","age":21}]
     */

    private String result;
    private List<AdBean> ad;
    private List<PdBean> pd;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<AdBean> getAd() {
        return ad;
    }

    public void setAd(List<AdBean> ad) {
        this.ad = ad;
    }

    public List<PdBean> getPd() {
        return pd;
    }

    public void setPd(List<PdBean> pd) {
        this.pd = pd;
    }

    public static class AdBean {
        /**
         * SHOWIMG : http://47.104.16.215:8088/advertisementimgs/d223c1c64da1434692a04189d53cf774.png
         * CONVERGE_ID : 382889968336371712
         * AD_POSITION : 0
         * CLICK_COUNT : 1
         * SORT_ORDER : 1
         * LINK_URL :
         * ADVERTISEMENT_ID : 394912901892145152
         * NAME : 瓜子  免费估车
         */

        private String SHOWIMG;
        private String CONVERGE_ID;
        private String AD_POSITION;
        private int CLICK_COUNT;
        private int SORT_ORDER;
        private String LINK_URL;
        private String ADVERTISEMENT_ID;
        private String NAME;

        public String getSHOWIMG() {
            return SHOWIMG;
        }

        public void setSHOWIMG(String SHOWIMG) {
            this.SHOWIMG = SHOWIMG;
        }

        public String getCONVERGE_ID() {
            return CONVERGE_ID;
        }

        public void setCONVERGE_ID(String CONVERGE_ID) {
            this.CONVERGE_ID = CONVERGE_ID;
        }

        public String getAD_POSITION() {
            return AD_POSITION;
        }

        public void setAD_POSITION(String AD_POSITION) {
            this.AD_POSITION = AD_POSITION;
        }

        public int getCLICK_COUNT() {
            return CLICK_COUNT;
        }

        public void setCLICK_COUNT(int CLICK_COUNT) {
            this.CLICK_COUNT = CLICK_COUNT;
        }

        public int getSORT_ORDER() {
            return SORT_ORDER;
        }

        public void setSORT_ORDER(int SORT_ORDER) {
            this.SORT_ORDER = SORT_ORDER;
        }

        public String getLINK_URL() {
            return LINK_URL;
        }

        public void setLINK_URL(String LINK_URL) {
            this.LINK_URL = LINK_URL;
        }

        public String getADVERTISEMENT_ID() {
            return ADVERTISEMENT_ID;
        }

        public void setADVERTISEMENT_ID(String ADVERTISEMENT_ID) {
            this.ADVERTISEMENT_ID = ADVERTISEMENT_ID;
        }

        public String getNAME() {
            return NAME;
        }

        public void setNAME(String NAME) {
            this.NAME = NAME;
        }
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
         * NICKNAME : Ccc
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
