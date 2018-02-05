package com.zsh.blackcard.model;

import java.util.List;

/**
 * Name: LiveAncherDetailWBModel
 * Author: Shing
 * Date: 2018/2/2 下午2:38
 * Description: ..
 */

public class LiveAncherDetailWBModel {


    /**
     * result : 01
     * pd : [{"AGREECOUNT":1,"COMMENTCOUNT":2,"SHOWIMAGES":["http://image.rongyaohk.com/circleimgs/10a18d323f8b4f3a8b45c015caa1e081.png"],"NICKNAME":"White55开","PUBLISHTIME":"2018-02-01 14:25","PORTRAIT":"http://image.rongyaohk.com/userportrait/e6765efb97a84e60b9f381247a2a448b.jpg","CIRCLE_ID":"408628858519027712","CONTENT":"A站融资失败，作为当局者，我该怎么办？","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"}]
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
        public String getSTATUS() {
            return STATUS;
        }

        public void setSTATUS(String STATUS) {
            this.STATUS = STATUS;
        }

        /**
         * AGREECOUNT : 1
         * COMMENTCOUNT : 2
         * SHOWIMAGES : ["http://image.rongyaohk.com/circleimgs/10a18d323f8b4f3a8b45c015caa1e081.png"]
         * NICKNAME : White55开
         * PUBLISHTIME : 2018-02-01 14:25
         * PORTRAIT : http://image.rongyaohk.com/userportrait/e6765efb97a84e60b9f381247a2a448b.jpg
         * CIRCLE_ID : 408628858519027712
         * CONTENT : A站融资失败，作为当局者，我该怎么办？
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         */
        private String STATUS;//0为没有点赞，1为点赞
        private String AGREECOUNT;
        private String COMMENTCOUNT;
        private String NICKNAME;
        private String PUBLISHTIME;
        private String PORTRAIT;
        private String CIRCLE_ID;
        private String CONTENT;
        private String HONOURUSER_ID;
        private List<String> SHOWIMAGES;

        public String getAGREECOUNT() {
            return AGREECOUNT;
        }

        public void setAGREECOUNT(String AGREECOUNT) {
            this.AGREECOUNT = AGREECOUNT;
        }

        public String getCOMMENTCOUNT() {
            return COMMENTCOUNT;
        }

        public void setCOMMENTCOUNT(String COMMENTCOUNT) {
            this.COMMENTCOUNT = COMMENTCOUNT;
        }

        public String getNICKNAME() {
            return NICKNAME;
        }

        public void setNICKNAME(String NICKNAME) {
            this.NICKNAME = NICKNAME;
        }

        public String getPUBLISHTIME() {
            return PUBLISHTIME;
        }

        public void setPUBLISHTIME(String PUBLISHTIME) {
            this.PUBLISHTIME = PUBLISHTIME;
        }

        public String getPORTRAIT() {
            return PORTRAIT;
        }

        public void setPORTRAIT(String PORTRAIT) {
            this.PORTRAIT = PORTRAIT;
        }

        public String getCIRCLE_ID() {
            return CIRCLE_ID;
        }

        public void setCIRCLE_ID(String CIRCLE_ID) {
            this.CIRCLE_ID = CIRCLE_ID;
        }

        public String getCONTENT() {
            return CONTENT;
        }

        public void setCONTENT(String CONTENT) {
            this.CONTENT = CONTENT;
        }

        public String getHONOURUSER_ID() {
            return HONOURUSER_ID;
        }

        public void setHONOURUSER_ID(String HONOURUSER_ID) {
            this.HONOURUSER_ID = HONOURUSER_ID;
        }

        public List<String> getSHOWIMAGES() {
            return SHOWIMAGES;
        }

        public void setSHOWIMAGES(List<String> SHOWIMAGES) {
            this.SHOWIMAGES = SHOWIMAGES;
        }
    }
}
