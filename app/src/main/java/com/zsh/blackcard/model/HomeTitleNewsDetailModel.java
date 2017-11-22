package com.zsh.blackcard.model;

/**
 * Created by kkkkk on 2017/11/22.
 * 首页头条新闻点击详情
 */

public class HomeTitleNewsDetailModel {

    /**
     * result : 01
     * pd : {"NEWSIMG":"主图222","IMGPIECEONE":"huonan","NEWSTITLE":"德玛西亚2","ISSHOW":1,"TITLEPIECETHREE":"标题三","CONTENTPIECEONE":"timu","IMGPIECETHREE":"图片三","TITLEPIECETWO":"标题二","NEWS_ID":"382889968336371625","TITLEPIECEONE":"yasuo","CONTENTPIECETWO":"内容二","CONTENTPIECETHREE":"内容三","NEWSCONTENT":"5V5比赛222","IMGPIECETWO":"图片二"}
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
         * NEWSIMG : 主图222
         * IMGPIECEONE : huonan
         * NEWSTITLE : 德玛西亚2
         * ISSHOW : 1
         * TITLEPIECETHREE : 标题三
         * CONTENTPIECEONE : timu
         * IMGPIECETHREE : 图片三
         * TITLEPIECETWO : 标题二
         * NEWS_ID : 382889968336371625
         * TITLEPIECEONE : yasuo
         * CONTENTPIECETWO : 内容二
         * CONTENTPIECETHREE : 内容三
         * NEWSCONTENT : 5V5比赛222
         * IMGPIECETWO : 图片二
         */

        private String NEWSIMG;
        private String IMGPIECEONE;
        private String NEWSTITLE;
        private int ISSHOW;
        private String TITLEPIECETHREE;
        private String CONTENTPIECEONE;
        private String IMGPIECETHREE;
        private String TITLEPIECETWO;
        private String NEWS_ID;
        private String TITLEPIECEONE;
        private String CONTENTPIECETWO;
        private String CONTENTPIECETHREE;
        private String NEWSCONTENT;
        private String IMGPIECETWO;

        public String getNEWSIMG() {
            return NEWSIMG;
        }

        public void setNEWSIMG(String NEWSIMG) {
            this.NEWSIMG = NEWSIMG;
        }

        public String getIMGPIECEONE() {
            return IMGPIECEONE;
        }

        public void setIMGPIECEONE(String IMGPIECEONE) {
            this.IMGPIECEONE = IMGPIECEONE;
        }

        public String getNEWSTITLE() {
            return NEWSTITLE;
        }

        public void setNEWSTITLE(String NEWSTITLE) {
            this.NEWSTITLE = NEWSTITLE;
        }

        public int getISSHOW() {
            return ISSHOW;
        }

        public void setISSHOW(int ISSHOW) {
            this.ISSHOW = ISSHOW;
        }

        public String getTITLEPIECETHREE() {
            return TITLEPIECETHREE;
        }

        public void setTITLEPIECETHREE(String TITLEPIECETHREE) {
            this.TITLEPIECETHREE = TITLEPIECETHREE;
        }

        public String getCONTENTPIECEONE() {
            return CONTENTPIECEONE;
        }

        public void setCONTENTPIECEONE(String CONTENTPIECEONE) {
            this.CONTENTPIECEONE = CONTENTPIECEONE;
        }

        public String getIMGPIECETHREE() {
            return IMGPIECETHREE;
        }

        public void setIMGPIECETHREE(String IMGPIECETHREE) {
            this.IMGPIECETHREE = IMGPIECETHREE;
        }

        public String getTITLEPIECETWO() {
            return TITLEPIECETWO;
        }

        public void setTITLEPIECETWO(String TITLEPIECETWO) {
            this.TITLEPIECETWO = TITLEPIECETWO;
        }

        public String getNEWS_ID() {
            return NEWS_ID;
        }

        public void setNEWS_ID(String NEWS_ID) {
            this.NEWS_ID = NEWS_ID;
        }

        public String getTITLEPIECEONE() {
            return TITLEPIECEONE;
        }

        public void setTITLEPIECEONE(String TITLEPIECEONE) {
            this.TITLEPIECEONE = TITLEPIECEONE;
        }

        public String getCONTENTPIECETWO() {
            return CONTENTPIECETWO;
        }

        public void setCONTENTPIECETWO(String CONTENTPIECETWO) {
            this.CONTENTPIECETWO = CONTENTPIECETWO;
        }

        public String getCONTENTPIECETHREE() {
            return CONTENTPIECETHREE;
        }

        public void setCONTENTPIECETHREE(String CONTENTPIECETHREE) {
            this.CONTENTPIECETHREE = CONTENTPIECETHREE;
        }

        public String getNEWSCONTENT() {
            return NEWSCONTENT;
        }

        public void setNEWSCONTENT(String NEWSCONTENT) {
            this.NEWSCONTENT = NEWSCONTENT;
        }

        public String getIMGPIECETWO() {
            return IMGPIECETWO;
        }

        public void setIMGPIECETWO(String IMGPIECETWO) {
            this.IMGPIECETWO = IMGPIECETWO;
        }
    }
}
