package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by ZCY on 2017/12/26.
 * 广告
 */

public class AdvertisementModel {

    /**
     * result : 01
     * pd : [{"SHOWIMG":"http://47.104.16.215:8088/advertisementimgs/f4a3846c4f894527af7b431115bb580f.png","START_TIME":"2017-12-25","END_TIME":"2017-12-28","AD_POSITION":"0","CLICK_COUNT":1,"SORT_ORDER":1,"ENABLE":"1","LINK_URL":"","ADVERTISEMENT_ID":"394912901892145152","NAME":"瓜子  免费估车"},{"SHOWIMG":"http://47.104.16.215:8088/advertisementimgs/86b071cff9e247d59c02466748681816.png","START_TIME":"2017-12-25","END_TIME":"2017-12-30","AD_POSITION":"0","CLICK_COUNT":0,"SORT_ORDER":2,"ENABLE":"0","LINK_URL":"","ADVERTISEMENT_ID":"394914800271884288","NAME":"买卖二手车上瓜子网"},{"SHOWIMG":"http://47.104.16.215:8088/advertisementimgs/0fc314d0e38b4c26a22d2cfa364d736c.png","START_TIME":"2017-12-25","END_TIME":"2018-01-02","AD_POSITION":"0","CLICK_COUNT":0,"SORT_ORDER":3,"ENABLE":"1","LINK_URL":"","ADVERTISEMENT_ID":"394919861949562880","NAME":"三亚旅游节"}]
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
         * SHOWIMG : http://47.104.16.215:8088/advertisementimgs/f4a3846c4f894527af7b431115bb580f.png
         * START_TIME : 2017-12-25
         * END_TIME : 2017-12-28
         * AD_POSITION : 0
         * CLICK_COUNT : 1
         * SORT_ORDER : 1
         * ENABLE : 1
         * LINK_URL :
         * ADVERTISEMENT_ID : 394912901892145152
         * NAME : 瓜子  免费估车
         */

        private String SHOWIMG;
        private String START_TIME;
        private String END_TIME;
        private String AD_POSITION;
        private int CLICK_COUNT;
        private int SORT_ORDER;
        private String ENABLE;
        private String LINK_URL;
        private String ADVERTISEMENT_ID;
        private String NAME;

        public String getSHOWIMG() {
            return SHOWIMG;
        }

        public void setSHOWIMG(String SHOWIMG) {
            this.SHOWIMG = SHOWIMG;
        }

        public String getSTART_TIME() {
            return START_TIME;
        }

        public void setSTART_TIME(String START_TIME) {
            this.START_TIME = START_TIME;
        }

        public String getEND_TIME() {
            return END_TIME;
        }

        public void setEND_TIME(String END_TIME) {
            this.END_TIME = END_TIME;
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

        public String getENABLE() {
            return ENABLE;
        }

        public void setENABLE(String ENABLE) {
            this.ENABLE = ENABLE;
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
}
