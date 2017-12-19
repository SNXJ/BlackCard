package com.zsh.blackcard.model;

/**
 * Created by kkkkk on 2017/12/18.
 * 我的界面，优惠券、黑咖币、能量值实体类
 */

public class MyDisBlackPowerModel {

    /**
     * result : 01
     * my : {"ENERGY":65,"NICKNAME":"d6","COUPON":0,"PORTRAIT":"http://47.104.16.215:8088/userportrait/e6765efb97a84e60b9f381247a2a448b.jpg","BLACKCOIN":0,"HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"}
     */

    private String result;
    private MyBean my;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public MyBean getMy() {
        return my;
    }

    public void setMy(MyBean my) {
        this.my = my;
    }

    public static class MyBean {
        /**
         * ENERGY : 65
         * NICKNAME : d6
         * COUPON : 0
         * PORTRAIT : http://47.104.16.215:8088/userportrait/e6765efb97a84e60b9f381247a2a448b.jpg
         * BLACKCOIN : 0
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         */

        private int ENERGY;
        private String NICKNAME;
        private int COUPON;
        private String PORTRAIT;
        private int BLACKCOIN;
        private String HONOURUSER_ID;

        public int getENERGY() {
            return ENERGY;
        }

        public void setENERGY(int ENERGY) {
            this.ENERGY = ENERGY;
        }

        public String getNICKNAME() {
            return NICKNAME;
        }

        public void setNICKNAME(String NICKNAME) {
            this.NICKNAME = NICKNAME;
        }

        public int getCOUPON() {
            return COUPON;
        }

        public void setCOUPON(int COUPON) {
            this.COUPON = COUPON;
        }

        public String getPORTRAIT() {
            return PORTRAIT;
        }

        public void setPORTRAIT(String PORTRAIT) {
            this.PORTRAIT = PORTRAIT;
        }

        public int getBLACKCOIN() {
            return BLACKCOIN;
        }

        public void setBLACKCOIN(int BLACKCOIN) {
            this.BLACKCOIN = BLACKCOIN;
        }

        public String getHONOURUSER_ID() {
            return HONOURUSER_ID;
        }

        public void setHONOURUSER_ID(String HONOURUSER_ID) {
            this.HONOURUSER_ID = HONOURUSER_ID;
        }
    }
}
