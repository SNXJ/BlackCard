package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/25.
 * 欢迎引导页实体类
 */

public class WelcomeModel {

    /**
     * result : 01
     * pd : [{"SHOWIMG":"http://47.104.16.215:8088/bootpageimgs/730f7285b35b4839bc1a1f7835a2d0da.png","STATUS":"1","BOOTPAGE_ID":"383560034786738176"},{"SHOWIMG":"http://47.104.16.215:8088/bootpageimgs/9b0b668f6c5c466ab4ad94b5e2c15b47.png","STATUS":"1","BOOTPAGE_ID":"383560369899044864"},{"SHOWIMG":"http://47.104.16.215:8088/bootpageimgs/54a46dd8f8b74dc78b597f2d10250e57.png","STATUS":"1","BOOTPAGE_ID":"383560422642417664"},{"SHOWIMG":"http://47.104.16.215:8088/bootpageimgs/d1169d4feb02469da89571843b86ba87.png","STATUS":"1","BOOTPAGE_ID":"383560470025469952"}]
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
         * SHOWIMG : http://47.104.16.215:8088/bootpageimgs/730f7285b35b4839bc1a1f7835a2d0da.png
         * STATUS : 1
         * BOOTPAGE_ID : 383560034786738176
         */

        private String SHOWIMG;
        private String STATUS;
        private String BOOTPAGE_ID;

        public String getSHOWIMG() {
            return SHOWIMG;
        }

        public void setSHOWIMG(String SHOWIMG) {
            this.SHOWIMG = SHOWIMG;
        }

        public String getSTATUS() {
            return STATUS;
        }

        public void setSTATUS(String STATUS) {
            this.STATUS = STATUS;
        }

        public String getBOOTPAGE_ID() {
            return BOOTPAGE_ID;
        }

        public void setBOOTPAGE_ID(String BOOTPAGE_ID) {
            this.BOOTPAGE_ID = BOOTPAGE_ID;
        }
    }
}
