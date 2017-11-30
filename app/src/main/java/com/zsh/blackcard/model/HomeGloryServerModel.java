package com.zsh.blackcard.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/27.
 * 首页荣耀服务实体类
 */

public class HomeGloryServerModel {

    /**
     * result : 01
     * pd : [{"SORTHIGH_ID":"383990553504645120","SERVER_ID":"385003765473738752","SEQUENCE":1,"SERVICEIMGS":"http://47.104.16.215:8088/serverimgs/7ef0279f0e514e8c833c66fc29aedb29.png","SERVICETITLE":"标题1","SERVICETYPE":"艺海品鉴 ","SHOPTYPE":"马术"},{"SORTHIGH_ID":"383995103208800256","SERVER_ID":"385003937079492608","SEQUENCE":2,"SERVICEIMGS":"http://47.104.16.215:8088/serverimgs/e3af08e44b7946e485772373fc8e5171.png","SERVICETITLE":"标题2","SERVICETYPE":"金鹿救援","SHOPTYPE":"飞机"},{"SORTHIGH_ID":"383990553504645120","SERVER_ID":"385004332946292736","SEQUENCE":4,"SERVICEIMGS":"http://47.104.16.215:8088/serverimgs/5d9c321ede834a26ac8d31160668b307.png","SERVICETITLE":"标题3","SERVICETYPE":"三亚马术俱乐部","SHOPTYPE":"马术"},{"SORTHIGH_ID":"383990553504645120","SERVER_ID":"385461828920016896","SEQUENCE":3,"SERVICEIMGS":"http://47.104.16.215:8088/serverimgs/2aed46a916764719b0799e58556c5795.png","SERVICETITLE":"标题1","SERVICETYPE":"九富投资顾问","SHOPTYPE":"马术"},{"SORTHIGH_ID":"383994744717443072","SERVER_ID":"385461993462562816","SEQUENCE":5,"SERVICEIMGS":"http://47.104.16.215:8088/serverimgs/11672d0791e74d8caaf97cf3291f0cf8.png","SERVICETITLE":"标题2","SERVICETYPE":"KK私人管家","SHOPTYPE":"豪车"}]
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

    public static class PdBean implements MultiItemEntity {
        /**
         * SORTHIGH_ID : 383990553504645120
         * SERVER_ID : 385003765473738752
         * SEQUENCE : 1
         * SERVICEIMGS : http://47.104.16.215:8088/serverimgs/7ef0279f0e514e8c833c66fc29aedb29.png
         * SERVICETITLE : 标题1
         * SERVICETYPE : 艺海品鉴
         * SHOPTYPE : 马术
         */

        public static final int LEFT = 1;
        public static final int CENTER = 2;
        public static final int RIGHT = 3;
        private int itemType;

        public void setItemType(int itemType) {
            this.itemType = itemType;
        }

        private String SORTHIGH_ID;
        private String SERVER_ID;
        private int SEQUENCE;
        private String SERVICEIMGS;
        private String SERVICETITLE;
        private String SERVICETYPE;
        private String SHOPTYPE;

        public String getSORTHIGH_ID() {
            return SORTHIGH_ID;
        }

        public void setSORTHIGH_ID(String SORTHIGH_ID) {
            this.SORTHIGH_ID = SORTHIGH_ID;
        }

        public String getSERVER_ID() {
            return SERVER_ID;
        }

        public void setSERVER_ID(String SERVER_ID) {
            this.SERVER_ID = SERVER_ID;
        }

        public int getSEQUENCE() {
            return SEQUENCE;
        }

        public void setSEQUENCE(int SEQUENCE) {
            this.SEQUENCE = SEQUENCE;
        }

        public String getSERVICEIMGS() {
            return SERVICEIMGS;
        }

        public void setSERVICEIMGS(String SERVICEIMGS) {
            this.SERVICEIMGS = SERVICEIMGS;
        }

        public String getSERVICETITLE() {
            return SERVICETITLE;
        }

        public void setSERVICETITLE(String SERVICETITLE) {
            this.SERVICETITLE = SERVICETITLE;
        }

        public String getSERVICETYPE() {
            return SERVICETYPE;
        }

        public void setSERVICETYPE(String SERVICETYPE) {
            this.SERVICETYPE = SERVICETYPE;
        }

        public String getSHOPTYPE() {
            return SHOPTYPE;
        }

        public void setSHOPTYPE(String SHOPTYPE) {
            this.SHOPTYPE = SHOPTYPE;
        }

        @Override
        public int getItemType() {
            return itemType;
        }
    }
}
