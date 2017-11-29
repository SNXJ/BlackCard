package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/29.
 * 首页豪车列表实体类
 */

public class HomeCarRecyclerModel {

    /**
     * result : 01
     * pd : [{"LUXCARPHONE":"111111","SHOWIMAGES":"http://47.104.16.215:8088/highsortimgs/luxcarshopimgs/bd6605ac4a334cc2b70d9b8b04e042d6.png","LUXCARADDRESS":"河北省 廊坊市 永清县 S273(廊霸线) ","distance":"","LUXCARLONGITUDE":"116.601271","LUXCARLATITUDE":"","LUXCARSHOP_ID":"383994744717443072","LUXCARPRICE":1,"LUXCARNAMES":"豪车11","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"}]
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
         * LUXCARPHONE : 111111
         * SHOWIMAGES : http://47.104.16.215:8088/highsortimgs/luxcarshopimgs/bd6605ac4a334cc2b70d9b8b04e042d6.png
         * LUXCARADDRESS : 河北省 廊坊市 永清县 S273(廊霸线)
         * distance :
         * LUXCARLONGITUDE : 116.601271
         * LUXCARLATITUDE :
         * LUXCARSHOP_ID : 383994744717443072
         * LUXCARPRICE : 1
         * LUXCARNAMES : 豪车11
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
