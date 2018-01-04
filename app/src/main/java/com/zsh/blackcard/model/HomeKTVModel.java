package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/28.
 * 获取首页，KTV酒吧
 */

public class HomeKTVModel {

    /**
     * result : 01
     * ad : [{"SHOWIMG":"http://47.104.16.215:8088/advertisementimgs/8a2ab07689aa474bb6a7f161f6ca9b24.png","AD_POSITION":"0","RELATED_ID":"3","CLICK_COUNT":0,"SORT_ORDER":1,"LINK_URL":"","ADVERTISEMENT_ID":"396316187945861120","NAME":""},{"SHOWIMG":"http://47.104.16.215:8088/advertisementimgs/d4212cfc57c5404090fdc660ab5a2bdd.png","AD_POSITION":"0","RELATED_ID":"3","CLICK_COUNT":0,"SORT_ORDER":2,"LINK_URL":"","ADVERTISEMENT_ID":"396316398629945344","NAME":""},{"SHOWIMG":"http://47.104.16.215:8088/advertisementimgs/c65e3918d6e445818e24f25ef7080b5f.png","AD_POSITION":"0","RELATED_ID":"3","CLICK_COUNT":0,"SORT_ORDER":3,"LINK_URL":"","ADVERTISEMENT_ID":"396316584185954304","NAME":""}]
     * pd : [{"SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sortktvimgs/sortktvshowimgs/c49e19f154c84ea38513667711e11ee8.png","distance":"4.266122541373515","KTVNAMES":"麦乐迪KTV(双井店)","SORTKTV_ID":"2674579cf39f4bff8697801196f2e629","KTVADDRESS":"北京市 北京市 朝阳区 八棵杨北街 ","KTVEVALUATE":3,"KTVEVACOUNT":3,"KTVPRICE":147,"HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"},{"SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sortktvimgs/sortktvshowimgs/bdc57258097f45fd9c1ae9b8fd82b866.png","distance":"13.968476574121114","KTVNAMES":"麦酷主题KTV","SORTKTV_ID":"387197864960327680","KTVADDRESS":"北京市 北京市 西城区 兴华胡同 20号","KTVPRICE":599,"HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"},{"SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sortktvimgs/sortktvshowimgs/059c228217c144f0880910e6ce012f27.png","distance":"11.229681615217466","KTVNAMES":"铭赫东方喜福汇夜总会","SORTKTV_ID":"387198218410131456","KTVADDRESS":"北京市 北京市 东城区 阳春胡同 5号","KTVPRICE":1999,"HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"},{"SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sortktvimgs/sortktvshowimgs/ec164ab93b4c42a9bf2390afe8a9eaae.png","distance":"3.047587482340143","KTVNAMES":"东方之珠KTV(珠江帝景店)","SORTKTV_ID":"982e78719b9c42418f19fb8a85a18b09","KTVADDRESS":"北京市 北京市 朝阳区 广渠路 28号院-205","KTVEVALUATE":4,"KTVEVACOUNT":2,"KTVPRICE":199,"HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"}]
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
         * SHOWIMG : http://47.104.16.215:8088/advertisementimgs/8a2ab07689aa474bb6a7f161f6ca9b24.png
         * AD_POSITION : 0
         * RELATED_ID : 3
         * CLICK_COUNT : 0
         * SORT_ORDER : 1
         * LINK_URL :
         * ADVERTISEMENT_ID : 396316187945861120
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
         * SHOWIMAGES : http://47.104.16.215:8088/sortimgs/sortktvimgs/sortktvshowimgs/c49e19f154c84ea38513667711e11ee8.png
         * distance : 4.266122541373515
         * KTVNAMES : 麦乐迪KTV(双井店)
         * SORTKTV_ID : 2674579cf39f4bff8697801196f2e629
         * KTVADDRESS : 北京市 北京市 朝阳区 八棵杨北街
         * KTVEVALUATE : 3
         * KTVEVACOUNT : 3
         * KTVPRICE : 147
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         */

        private String SHOWIMAGES;
        private String distance;
        private String KTVNAMES;
        private String SORTKTV_ID;
        private String KTVADDRESS;
        private int KTVEVALUATE;
        private int KTVEVACOUNT;
        private int KTVPRICE;
        private String HONOURUSER_ID;

        public String getSHOWIMAGES() {
            return SHOWIMAGES;
        }

        public void setSHOWIMAGES(String SHOWIMAGES) {
            this.SHOWIMAGES = SHOWIMAGES;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getKTVNAMES() {
            return KTVNAMES;
        }

        public void setKTVNAMES(String KTVNAMES) {
            this.KTVNAMES = KTVNAMES;
        }

        public String getSORTKTV_ID() {
            return SORTKTV_ID;
        }

        public void setSORTKTV_ID(String SORTKTV_ID) {
            this.SORTKTV_ID = SORTKTV_ID;
        }

        public String getKTVADDRESS() {
            return KTVADDRESS;
        }

        public void setKTVADDRESS(String KTVADDRESS) {
            this.KTVADDRESS = KTVADDRESS;
        }

        public int getKTVEVALUATE() {
            return KTVEVALUATE;
        }

        public void setKTVEVALUATE(int KTVEVALUATE) {
            this.KTVEVALUATE = KTVEVALUATE;
        }

        public int getKTVEVACOUNT() {
            return KTVEVACOUNT;
        }

        public void setKTVEVACOUNT(int KTVEVACOUNT) {
            this.KTVEVACOUNT = KTVEVACOUNT;
        }

        public int getKTVPRICE() {
            return KTVPRICE;
        }

        public void setKTVPRICE(int KTVPRICE) {
            this.KTVPRICE = KTVPRICE;
        }

        public String getHONOURUSER_ID() {
            return HONOURUSER_ID;
        }

        public void setHONOURUSER_ID(String HONOURUSER_ID) {
            this.HONOURUSER_ID = HONOURUSER_ID;
        }
    }
}
