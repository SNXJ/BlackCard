package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/29.
 * 首页豪车列表实体类
 */

public class HomeCarRecyclerModel {

    /**
     * result : 01
     * ad : [{"SHOWIMG":"http://47.104.16.215:8088/advertisementimgs/52e2c351d93f46caace39c2781a40052.png","AD_POSITION":"0","RELATED_ID":"6","CLICK_COUNT":0,"SORT_ORDER":1,"LINK_URL":"","ADVERTISEMENT_ID":"396319715686875136","NAME":"驭见英伦"},{"SHOWIMG":"http://47.104.16.215:8088/advertisementimgs/1d75b49cc0ea4fadae0f692a822bf23c.png","AD_POSITION":"0","RELATED_ID":"6","CLICK_COUNT":0,"SORT_ORDER":2,"LINK_URL":"","ADVERTISEMENT_ID":"396321372319514624","NAME":"T时代驾临"},{"SHOWIMG":"http://47.104.16.215:8088/advertisementimgs/826a328e6b884cae8995d69d163ef206.png","AD_POSITION":"0","RELATED_ID":"6","CLICK_COUNT":0,"SORT_ORDER":3,"LINK_URL":"","ADVERTISEMENT_ID":"396321612011405312","NAME":"ACYZ爱车一族"}]
     * pd : [{"LUXCARPHONE":"010-8888888","SHOWIMAGES":"http://47.104.16.215:8088/highsortimgs/luxcarshopimgs/baae579c7f8646fa9758266d4ce4cb1a.png","LUXCARADDRESS":"海南省 三亚市 市辖区 海韵路 19号","distance":"1211.4301567450211","LUXCARLONGITUDE":"109.524348","LUXCARLATITUDE":"18.227069","LUXCARSHOP_ID":"383994744717443072","LUXCARPRICE":3999,"LUXCARNAMES":"海棠汽车租赁","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"},{"LUXCARPHONE":"010-6666666","SHOWIMAGES":"http://47.104.16.215:8088/highsortimgs/luxcarshopimgs/209951ade4614989b39f57adadfe9dd6.png","LUXCARADDRESS":"海南省 三亚市 市辖区 胜利路 256","distance":"1211.5058271088483","LUXCARLONGITUDE":"109.511125","LUXCARLATITUDE":"18.246847","LUXCARSHOP_ID":"385383300719443968","LUXCARPRICE":6999,"LUXCARNAMES":"龙达汽车租赁","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"},{"LUXCARPHONE":"010-7777777","SHOWIMAGES":"http://47.104.16.215:8088/highsortimgs/luxcarshopimgs/d934b2801ca9418da971d6db25eea3e2.png","LUXCARADDRESS":"海南省 三亚市 市辖区 解放四路 1249号","distance":"1211.207185986112","LUXCARLONGITUDE":"109.49845","LUXCARLATITUDE":"18.277356","LUXCARSHOP_ID":"387607890149507072","LUXCARPRICE":4999,"LUXCARNAMES":"三亚岳顺汽车租赁","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"},{"LUXCARPHONE":"010-5555555","SHOWIMAGES":"http://47.104.16.215:8088/highsortimgs/luxcarshopimgs/d5c034a681834506b999ae62245d8b4f.png","LUXCARADDRESS":"海南省 三亚市 市辖区 凤凰路 170","distance":"1209.9112604281688","LUXCARLONGITUDE":"109.519309","LUXCARLATITUDE":"18.282273","LUXCARSHOP_ID":"387608635162755072","LUXCARPRICE":5888,"LUXCARNAMES":"椰林风汽车租赁","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"},{"LUXCARPHONE":"010-9999999","SHOWIMAGES":"http://47.104.16.215:8088/highsortimgs/luxcarshopimgs/87ade343cca74d979230fe3fdeb6429a.png","LUXCARADDRESS":"海南省 三亚市 市辖区 凤凰路 ","distance":"1213.8049235659744","LUXCARLONGITUDE":"109.429123","LUXCARLATITUDE":"18.314757","LUXCARSHOP_ID":"387609371183415296","LUXCARPRICE":8888,"LUXCARNAMES":"宝马跑车一族租赁","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"}]
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
         * SHOWIMG : http://47.104.16.215:8088/advertisementimgs/52e2c351d93f46caace39c2781a40052.png
         * AD_POSITION : 0
         * RELATED_ID : 6
         * CLICK_COUNT : 0
         * SORT_ORDER : 1
         * LINK_URL :
         * ADVERTISEMENT_ID : 396319715686875136
         * NAME : 驭见英伦
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
         * LUXCARPHONE : 010-8888888
         * SHOWIMAGES : http://47.104.16.215:8088/highsortimgs/luxcarshopimgs/baae579c7f8646fa9758266d4ce4cb1a.png
         * LUXCARADDRESS : 海南省 三亚市 市辖区 海韵路 19号
         * distance : 1211.4301567450211
         * LUXCARLONGITUDE : 109.524348
         * LUXCARLATITUDE : 18.227069
         * LUXCARSHOP_ID : 383994744717443072
         * LUXCARPRICE : 3999
         * LUXCARNAMES : 海棠汽车租赁
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         */

        private String LUXCARPHONE;
        private String SHOWIMAGES;
        private String LUXCARADDRESS;
        private String distance;
        private String LUXCARLONGITUDE;
        private String LUXCARLATITUDE;
        private String LUXCARSHOP_ID;
        private int LUXCARPRICE;
        private String LUXCARNAMES;
        private String HONOURUSER_ID;

        public String getLUXCARPHONE() {
            return LUXCARPHONE;
        }

        public void setLUXCARPHONE(String LUXCARPHONE) {
            this.LUXCARPHONE = LUXCARPHONE;
        }

        public String getSHOWIMAGES() {
            return SHOWIMAGES;
        }

        public void setSHOWIMAGES(String SHOWIMAGES) {
            this.SHOWIMAGES = SHOWIMAGES;
        }

        public String getLUXCARADDRESS() {
            return LUXCARADDRESS;
        }

        public void setLUXCARADDRESS(String LUXCARADDRESS) {
            this.LUXCARADDRESS = LUXCARADDRESS;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getLUXCARLONGITUDE() {
            return LUXCARLONGITUDE;
        }

        public void setLUXCARLONGITUDE(String LUXCARLONGITUDE) {
            this.LUXCARLONGITUDE = LUXCARLONGITUDE;
        }

        public String getLUXCARLATITUDE() {
            return LUXCARLATITUDE;
        }

        public void setLUXCARLATITUDE(String LUXCARLATITUDE) {
            this.LUXCARLATITUDE = LUXCARLATITUDE;
        }

        public String getLUXCARSHOP_ID() {
            return LUXCARSHOP_ID;
        }

        public void setLUXCARSHOP_ID(String LUXCARSHOP_ID) {
            this.LUXCARSHOP_ID = LUXCARSHOP_ID;
        }

        public int getLUXCARPRICE() {
            return LUXCARPRICE;
        }

        public void setLUXCARPRICE(int LUXCARPRICE) {
            this.LUXCARPRICE = LUXCARPRICE;
        }

        public String getLUXCARNAMES() {
            return LUXCARNAMES;
        }

        public void setLUXCARNAMES(String LUXCARNAMES) {
            this.LUXCARNAMES = LUXCARNAMES;
        }

        public String getHONOURUSER_ID() {
            return HONOURUSER_ID;
        }

        public void setHONOURUSER_ID(String HONOURUSER_ID) {
            this.HONOURUSER_ID = HONOURUSER_ID;
        }
    }
}
