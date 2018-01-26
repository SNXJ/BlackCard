package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by ZCY on 2018/1/24.
 * 订单中心优惠券实体类
 */

public class DisCountModel {

    /**
     * result : 01
     * pd : [{"USED_COUNT":0,"COUPON_STARTTIME":"2018-01-23","COUPON_ENDTIME":"2018-01-31","BUSINESS_ID":"system","COUPON_STATE":"1","COUPON_MININUM":2000,"COUPON_TYPE":"0","COUPON_VALUE":200,"COUPON_ID":"405312048105259008","SEND_COUNT":0,"TOTALCOUNT":20},{"USED_COUNT":0,"COUPON_STARTTIME":"2018-01-23","COUPON_ENDTIME":"2018-01-31","BUSINESS_ID":"system","COUPON_STATE":"1","COUPON_MININUM":1000,"COUPON_TYPE":"0","COUPON_VALUE":100,"COUPON_ID":"405309204782383104","SEND_COUNT":0,"TOTALCOUNT":20}]
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
         * USED_COUNT : 0
         * COUPON_STARTTIME : 2018-01-23
         * COUPON_ENDTIME : 2018-01-31
         * BUSINESS_ID : system
         * COUPON_STATE : 1
         * COUPON_MININUM : 2000
         * COUPON_TYPE : 0
         * COUPON_VALUE : 200
         * COUPON_ID : 405312048105259008
         * SEND_COUNT : 0
         * TOTALCOUNT : 20
         */

        private int USED_COUNT;
        private String COUPON_STARTTIME;
        private String COUPON_ENDTIME;
        private String BUSINESS_ID;
        private String COUPON_STATE;
        private int COUPON_MININUM;
        private String COUPON_TYPE;
        private int COUPON_VALUE;
        private String COUPON_ID;
        private int SEND_COUNT;
        private int TOTALCOUNT;

        public int getUSED_COUNT() {
            return USED_COUNT;
        }

        public void setUSED_COUNT(int USED_COUNT) {
            this.USED_COUNT = USED_COUNT;
        }

        public String getCOUPON_STARTTIME() {
            return COUPON_STARTTIME;
        }

        public void setCOUPON_STARTTIME(String COUPON_STARTTIME) {
            this.COUPON_STARTTIME = COUPON_STARTTIME;
        }

        public String getCOUPON_ENDTIME() {
            return COUPON_ENDTIME;
        }

        public void setCOUPON_ENDTIME(String COUPON_ENDTIME) {
            this.COUPON_ENDTIME = COUPON_ENDTIME;
        }

        public String getBUSINESS_ID() {
            return BUSINESS_ID;
        }

        public void setBUSINESS_ID(String BUSINESS_ID) {
            this.BUSINESS_ID = BUSINESS_ID;
        }

        public String getCOUPON_STATE() {
            return COUPON_STATE;
        }

        public void setCOUPON_STATE(String COUPON_STATE) {
            this.COUPON_STATE = COUPON_STATE;
        }

        public int getCOUPON_MININUM() {
            return COUPON_MININUM;
        }

        public void setCOUPON_MININUM(int COUPON_MININUM) {
            this.COUPON_MININUM = COUPON_MININUM;
        }

        public String getCOUPON_TYPE() {
            return COUPON_TYPE;
        }

        public void setCOUPON_TYPE(String COUPON_TYPE) {
            this.COUPON_TYPE = COUPON_TYPE;
        }

        public int getCOUPON_VALUE() {
            return COUPON_VALUE;
        }

        public void setCOUPON_VALUE(int COUPON_VALUE) {
            this.COUPON_VALUE = COUPON_VALUE;
        }

        public String getCOUPON_ID() {
            return COUPON_ID;
        }

        public void setCOUPON_ID(String COUPON_ID) {
            this.COUPON_ID = COUPON_ID;
        }

        public int getSEND_COUNT() {
            return SEND_COUNT;
        }

        public void setSEND_COUNT(int SEND_COUNT) {
            this.SEND_COUNT = SEND_COUNT;
        }

        public int getTOTALCOUNT() {
            return TOTALCOUNT;
        }

        public void setTOTALCOUNT(int TOTALCOUNT) {
            this.TOTALCOUNT = TOTALCOUNT;
        }
    }
}