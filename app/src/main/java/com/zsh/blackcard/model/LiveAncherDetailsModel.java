package com.zsh.blackcard.model;

/**
 * Name: LiveAncherDetailsModel
 * Author: Shing
 * Date: 2018/2/2 上午11:21
 * Description: ..
 */

public class LiveAncherDetailsModel {


    /**
     * result : 01
     * pd : {"PublishUrl":"","NICKNAME":"White55开","LIVE_ONLINE":0,"STREAMNAME":"game1000000633247388","PORTRAIT":"http://image.rongyaohk.com/userportrait/e6765efb97a84e60b9f381247a2a448b.jpg","SIGNNAME":"也不知道签名写点什么","focus":1,"HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","fans":2}
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
         * PublishUrl :
         * NICKNAME : White55开
         * LIVE_ONLINE : 0
         * STREAMNAME : game1000000633247388
         * PORTRAIT : http://image.rongyaohk.com/userportrait/e6765efb97a84e60b9f381247a2a448b.jpg
         * SIGNNAME : 也不知道签名写点什么
         * focus : 1
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         * fans : 2
         */

        private String PublishUrl;
        private String NICKNAME;
        private String LIVE_ONLINE;
        private String STREAMNAME;
        private String PORTRAIT;
        private String SIGNNAME;
        private String FOCUSCOUNT;

        public String getFOCUSCOUNT() {
            return FOCUSCOUNT;
        }

        public void setFOCUSCOUNT(String FOCUSCOUNT) {
            this.FOCUSCOUNT = FOCUSCOUNT;
        }

        public String getFANSCOUNT() {
            return FANSCOUNT;
        }

        public void setFANSCOUNT(String FANSCOUNT) {
            this.FANSCOUNT = FANSCOUNT;
        }

        private String HONOURUSER_ID;
        private String FANSCOUNT;

        public String getPublishUrl() {
            return PublishUrl;
        }

        public void setPublishUrl(String PublishUrl) {
            this.PublishUrl = PublishUrl;
        }

        public String getNICKNAME() {
            return NICKNAME;
        }

        public void setNICKNAME(String NICKNAME) {
            this.NICKNAME = NICKNAME;
        }

        public String getLIVE_ONLINE() {
            return LIVE_ONLINE;
        }

        public void setLIVE_ONLINE(String LIVE_ONLINE) {
            this.LIVE_ONLINE = LIVE_ONLINE;
        }

        public String getSTREAMNAME() {
            return STREAMNAME;
        }

        public void setSTREAMNAME(String STREAMNAME) {
            this.STREAMNAME = STREAMNAME;
        }

        public String getPORTRAIT() {
            return PORTRAIT;
        }

        public void setPORTRAIT(String PORTRAIT) {
            this.PORTRAIT = PORTRAIT;
        }

        public String getSIGNNAME() {
            return SIGNNAME;
        }

        public void setSIGNNAME(String SIGNNAME) {
            this.SIGNNAME = SIGNNAME;
        }


        public String getHONOURUSER_ID() {
            return HONOURUSER_ID;
        }

        public void setHONOURUSER_ID(String HONOURUSER_ID) {
            this.HONOURUSER_ID = HONOURUSER_ID;
        }


    }
}
