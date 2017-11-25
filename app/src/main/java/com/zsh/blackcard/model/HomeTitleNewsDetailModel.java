package com.zsh.blackcard.model;

/**
 * Created by kkkkk on 2017/11/22.
 * 首页头条新闻点击详情
 */

public class HomeTitleNewsDetailModel {


    /**
     * result : 01
     * pd : {"NEWSIMG":"http://47.104.16.215:8088/newsimgs/73035c93f0d5418dae8a40d70f0fa3eb.png","IMGPIECEONE":"http://47.104.16.215:8088/newsimgs/c2cfe744ebfe49fa83736892aa46cb14.png","NEWSTITLE":"新闻标题","ISSHOW":1,"TITLEPIECETHREE":"新闻小标题3","CONTENTPIECEONE":"新闻小内容1","IMGPIECETHREE":"http://47.104.16.215:8088/newsimgs/25d7ca409aba4d4a8c927b9bb46ae55a.png","TITLEPIECETWO":"新闻小标题2","NEWS_ID":"383254886982090752","TITLEPIECEONE":"新闻小标题1","CONTENTPIECETWO":"新闻小内容2","CONTENTPIECETHREE":"新闻小内容3","NEWSCONTENT":"新闻内容","IMGPIECETWO":"http://47.104.16.215:8088/newsimgs/e9d45f52347549319375c96294670b7b.png"}
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
         * NEWSIMG : http://47.104.16.215:8088/newsimgs/73035c93f0d5418dae8a40d70f0fa3eb.png
         * IMGPIECEONE : http://47.104.16.215:8088/newsimgs/c2cfe744ebfe49fa83736892aa46cb14.png
         * NEWSTITLE : 新闻标题
         * ISSHOW : 1
         * TITLEPIECETHREE : 新闻小标题3
         * CONTENTPIECEONE : 新闻小内容1
         * IMGPIECETHREE : http://47.104.16.215:8088/newsimgs/25d7ca409aba4d4a8c927b9bb46ae55a.png
         * TITLEPIECETWO : 新闻小标题2
         * NEWS_ID : 383254886982090752
         * TITLEPIECEONE : 新闻小标题1
         * CONTENTPIECETWO : 新闻小内容2
         * CONTENTPIECETHREE : 新闻小内容3
         * NEWSCONTENT : 新闻内容
         * IMGPIECETWO : http://47.104.16.215:8088/newsimgs/e9d45f52347549319375c96294670b7b.png
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
