package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/29.
 * 首页游艇列表实体类
 */

public class HomeYachtRecyclerModel {

    /**
     * result : 01
     * pd : [{"SHOWIMAGES":"http://47.104.16.215:8088/highsortimgs/yachtshopimgs/5fcd8db844544a20b73c2243f25bb452.png","YACHTSHOP_ID":"383995743632883712","YACHTLATITUDE":"39.879573","distance":"10.836238419905905","YACHTNAMES":"游艇1","YACHTLONGITUDE":"39.879573","YACHTADDRESS":"北京市, 北京市, 东城区, 永内东街, 东1楼","YACHTPRICE":1,"HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","YACHTPHONE":"111111"}]
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
         * SHOWIMAGES : http://47.104.16.215:8088/highsortimgs/yachtshopimgs/5fcd8db844544a20b73c2243f25bb452.png
         * YACHTSHOP_ID : 383995743632883712
         * YACHTLATITUDE : 39.879573
         * distance : 10.836238419905905
         * YACHTNAMES : 游艇1
         * YACHTLONGITUDE : 39.879573
         * YACHTADDRESS : 北京市, 北京市, 东城区, 永内东街, 东1楼
         * YACHTPRICE : 1
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         * YACHTPHONE : 111111
         */

        private String SHOWIMAGES;
        private String YACHTSHOP_ID;
        private String YACHTLATITUDE;
        private String distance;
        private String YACHTNAMES;
        private String YACHTLONGITUDE;
        private String YACHTADDRESS;
        private int YACHTPRICE;
        private String HONOURUSER_ID;
        private String YACHTPHONE;

        public String getSHOWIMAGES() {
            return SHOWIMAGES;
        }

        public void setSHOWIMAGES(String SHOWIMAGES) {
            this.SHOWIMAGES = SHOWIMAGES;
        }

        public String getYACHTSHOP_ID() {
            return YACHTSHOP_ID;
        }

        public void setYACHTSHOP_ID(String YACHTSHOP_ID) {
            this.YACHTSHOP_ID = YACHTSHOP_ID;
        }

        public String getYACHTLATITUDE() {
            return YACHTLATITUDE;
        }

        public void setYACHTLATITUDE(String YACHTLATITUDE) {
            this.YACHTLATITUDE = YACHTLATITUDE;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getYACHTNAMES() {
            return YACHTNAMES;
        }

        public void setYACHTNAMES(String YACHTNAMES) {
            this.YACHTNAMES = YACHTNAMES;
        }

        public String getYACHTLONGITUDE() {
            return YACHTLONGITUDE;
        }

        public void setYACHTLONGITUDE(String YACHTLONGITUDE) {
            this.YACHTLONGITUDE = YACHTLONGITUDE;
        }

        public String getYACHTADDRESS() {
            return YACHTADDRESS;
        }

        public void setYACHTADDRESS(String YACHTADDRESS) {
            this.YACHTADDRESS = YACHTADDRESS;
        }

        public int getYACHTPRICE() {
            return YACHTPRICE;
        }

        public void setYACHTPRICE(int YACHTPRICE) {
            this.YACHTPRICE = YACHTPRICE;
        }

        public String getHONOURUSER_ID() {
            return HONOURUSER_ID;
        }

        public void setHONOURUSER_ID(String HONOURUSER_ID) {
            this.HONOURUSER_ID = HONOURUSER_ID;
        }

        public String getYACHTPHONE() {
            return YACHTPHONE;
        }

        public void setYACHTPHONE(String YACHTPHONE) {
            this.YACHTPHONE = YACHTPHONE;
        }
    }
}
