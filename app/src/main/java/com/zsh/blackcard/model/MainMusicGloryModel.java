package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by ZCY on 2018/1/19.
 * 荣耀音乐广告和歌手推荐
 */

public class MainMusicGloryModel {

    /**
     * result : 01
     * ads : [{"SHOWIMG":"http://image.rongyaohk.com/advertisementimgs/5701359584064188b7e10a81b4270e87.png","AD_POSITION":"","RELATED_ID":"8","CLICK_COUNT":0,"SORT_ORDER":1,"LINK_URL":"","ADVERTISEMENT_ID":"403932322727985152","NAME":""},{"SHOWIMG":"http://image.rongyaohk.com/advertisementimgs/8097f45d4efa415893b12b4c46d297ea.png","AD_POSITION":"","RELATED_ID":"8","CLICK_COUNT":0,"SORT_ORDER":2,"LINK_URL":"","ADVERTISEMENT_ID":"403932413949902848","NAME":""}]
     * singerList : [{"singer_id":"7996","singer_pic":"http://47.104.16.215:8088/musicimgs/singers/music_banner_3@2x.png"},{"singer_id":"7994","singer_pic":"http://47.104.16.215:8088/musicimgs/singers/music_banner_2@2x.png"},{"singer_id":"7997","singer_pic":"http://47.104.16.215:8088/musicimgs/singers/music_banner_4@2x.png"},{"singer_id":"7998","singer_pic":"http://47.104.16.215:8088/musicimgs/singers/music_banner_5@2x.png"}]
     */

    private String result;
    private List<AdsBean> ads;
    private List<SingerListBean> singerList;

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

    public List<SingerListBean> getSingerList() {
        return singerList;
    }

    public void setSingerList(List<SingerListBean> singerList) {
        this.singerList = singerList;
    }

    public static class AdsBean {
        /**
         * SHOWIMG : http://image.rongyaohk.com/advertisementimgs/5701359584064188b7e10a81b4270e87.png
         * AD_POSITION :
         * RELATED_ID : 8
         * CLICK_COUNT : 0
         * SORT_ORDER : 1
         * LINK_URL :
         * ADVERTISEMENT_ID : 403932322727985152
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

    public static class SingerListBean {
        /**
         * singer_id : 7996
         * singer_pic : http://47.104.16.215:8088/musicimgs/singers/music_banner_3@2x.png
         */

        private String singer_id;
        private String singer_pic;

        public String getSinger_id() {
            return singer_id;
        }

        public void setSinger_id(String singer_id) {
            this.singer_id = singer_id;
        }

        public String getSinger_pic() {
            return singer_pic;
        }

        public void setSinger_pic(String singer_pic) {
            this.singer_pic = singer_pic;
        }
    }
}
