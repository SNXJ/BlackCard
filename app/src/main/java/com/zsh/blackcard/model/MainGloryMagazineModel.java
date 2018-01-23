package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by ZCY on 2018/1/12.
 * 首页荣耀杂志二级页面实体类
 */

public class MainGloryMagazineModel {

    /**
     * result : 01
     * ads : [{"SHOWIMG":"http://47.104.16.215:8088/advertisementimgs/ce36823ec12e4dd983ed5dd052192794.png","AD_POSITION":"","RELATED_ID":"212","CLICK_COUNT":0,"SORT_ORDER":1,"LINK_URL":"","ADVERTISEMENT_ID":"401402185927098368","NAME":""},{"SHOWIMG":"http://47.104.16.215:8088/advertisementimgs/ef6e4352dd42479887297254effd11ad.png","AD_POSITION":"","RELATED_ID":"212","CLICK_COUNT":0,"SORT_ORDER":2,"LINK_URL":"","ADVERTISEMENT_ID":"401402290876973056","NAME":""},{"SHOWIMG":"http://47.104.16.215:8088/advertisementimgs/a70bed9cba534f3195a7fe2bf8a27da6.png","AD_POSITION":"","RELATED_ID":"212","CLICK_COUNT":0,"SORT_ORDER":3,"LINK_URL":"","ADVERTISEMENT_ID":"401402379984961536","NAME":""}]
     * pd : [{"MENU_ID":213,"MENU_NAME":"推荐","PARENT_ID":"212"},{"MENU_ID":214,"MENU_NAME":"科技","PARENT_ID":"212"},{"MENU_ID":215,"MENU_NAME":"吃喝","PARENT_ID":"212"},{"MENU_ID":216,"MENU_NAME":"心灵","PARENT_ID":"212"},{"MENU_ID":217,"MENU_NAME":"时尚","PARENT_ID":"212"},{"MENU_ID":218,"MENU_NAME":"运动","PARENT_ID":"212"},{"MENU_ID":219,"MENU_NAME":"摄影","PARENT_ID":"212"}]
     * magazines : [{"SHOWIMG":"http://47.104.16.215:8088/magazineimgs/e2366f871225463a87e876117e7bd325.png","MAGAZINE_ID":"401408260122345472"},{"SHOWIMG":"http://47.104.16.215:8088/magazineimgs/aa0770417cc84412bad01db46ef28a74.png","MAGAZINE_ID":"401408071630323712"},{"SHOWIMG":"http://47.104.16.215:8088/magazineimgs/cbc0612a889d4996bc2321ad516c7153.png","MAGAZINE_ID":"401409283662544896"},{"SHOWIMG":"http://47.104.16.215:8088/magazineimgs/065d61c4930f498d9337b428eb36a89b.png","MAGAZINE_ID":"401407641017909248"},{"SHOWIMG":"http://47.104.16.215:8088/magazineimgs/04c55a237e2d473e91b85454c89d39a1.png","MAGAZINE_ID":"401408891960688640"},{"SHOWIMG":"http://47.104.16.215:8088/magazineimgs/96ec2b4b6655480ab96cae58525693de.png","MAGAZINE_ID":"401408945530339328"},{"SHOWIMG":"http://47.104.16.215:8088/magazineimgs/40606c13c28443088882f89cb4ca64af.png","MAGAZINE_ID":"401408565954215936"},{"SHOWIMG":"http://47.104.16.215:8088/magazineimgs/a4df6eb28cee4e1ebec4daab521e08d9.png","MAGAZINE_ID":"401407929988677632"}]
     */

    private String result;
    private List<AdsBean> ads;
    private List<PdBean> pd;
    private List<MagazinesBean> magazines;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<AdsBean> getAds() {
        return ads;
    }

    public void setAds(List<AdsBean> ads) {
        this.ads = ads;
    }

    public List<PdBean> getPd() {
        return pd;
    }

    public void setPd(List<PdBean> pd) {
        this.pd = pd;
    }

    public List<MagazinesBean> getMagazines() {
        return magazines;
    }

    public void setMagazines(List<MagazinesBean> magazines) {
        this.magazines = magazines;
    }

    public static class AdsBean {
        /**
         * SHOWIMG : http://47.104.16.215:8088/advertisementimgs/ce36823ec12e4dd983ed5dd052192794.png
         * AD_POSITION :
         * RELATED_ID : 212
         * CLICK_COUNT : 0
         * SORT_ORDER : 1
         * LINK_URL :
         * ADVERTISEMENT_ID : 401402185927098368
         * NAME :
         */

        private String SHOWIMG;
        private String AD_POSITION;
        private String RELATED_ID;
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

        public String getAD_POSITION() {
            return AD_POSITION;
        }

        public void setAD_POSITION(String AD_POSITION) {
            this.AD_POSITION = AD_POSITION;
        }

        public String getRELATED_ID() {
            return RELATED_ID;
        }

        public void setRELATED_ID(String RELATED_ID) {
            this.RELATED_ID = RELATED_ID;
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

    public static class PdBean {
        /**
         * MENU_ID : 213
         * MENU_NAME : 推荐
         * PARENT_ID : 212
         */

        private int MENU_ID;
        private String MENU_NAME;
        private String PARENT_ID;

        public int getMENU_ID() {
            return MENU_ID;
        }

        public void setMENU_ID(int MENU_ID) {
            this.MENU_ID = MENU_ID;
        }

        public String getMENU_NAME() {
            return MENU_NAME;
        }

        public void setMENU_NAME(String MENU_NAME) {
            this.MENU_NAME = MENU_NAME;
        }

        public String getPARENT_ID() {
            return PARENT_ID;
        }

        public void setPARENT_ID(String PARENT_ID) {
            this.PARENT_ID = PARENT_ID;
        }
    }

    public static class MagazinesBean {
        /**
         * SHOWIMG : http://47.104.16.215:8088/magazineimgs/e2366f871225463a87e876117e7bd325.png
         * MAGAZINE_ID : 401408260122345472
         */

        private String SHOWIMG;
        private String MAGAZINE_ID;

        public String getSHOWIMG() {
            return SHOWIMG;
        }

        public void setSHOWIMG(String SHOWIMG) {
            this.SHOWIMG = SHOWIMG;
        }

        public String getMAGAZINE_ID() {
            return MAGAZINE_ID;
        }

        public void setMAGAZINE_ID(String MAGAZINE_ID) {
            this.MAGAZINE_ID = MAGAZINE_ID;
        }
    }
}
