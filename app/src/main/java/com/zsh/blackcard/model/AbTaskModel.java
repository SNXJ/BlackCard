package com.zsh.blackcard.model;

/**
 * Name: AbTaskModel
 * Author: Shing
 * Date: 2018/2/26 14:36
 * Description: ..
 */

public class AbTaskModel {


    /**
     * result : 01
     * pd : {"TASK_ALL":0,"TASK_BROWSE":0,"TASK_ATTENTION":0,"TASK_GIFT":0,"TASK_PORT":0,"HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"}
     */

    private String result;
    private PdBean pd;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public PdBean getPd() {
        return pd;
    }

    public void setPd(PdBean pd) {
        this.pd = pd;
    }

    public static class PdBean {
        /**
         * TASK_ALL : 0
         * TASK_BROWSE : 0
         * TASK_ATTENTION : 0
         * TASK_GIFT : 0
         * TASK_PORT : 0
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         */

        private int TASK_ALL;
        private int TASK_BROWSE;
        private int TASK_ATTENTION;
        private int TASK_GIFT;
        private int TASK_PORT;
        private String HONOURUSER_ID;

        public int getTASK_ALL() {
            return TASK_ALL;
        }

        public void setTASK_ALL(int TASK_ALL) {
            this.TASK_ALL = TASK_ALL;
        }

        public int getTASK_BROWSE() {
            return TASK_BROWSE;
        }

        public void setTASK_BROWSE(int TASK_BROWSE) {
            this.TASK_BROWSE = TASK_BROWSE;
        }

        public int getTASK_ATTENTION() {
            return TASK_ATTENTION;
        }

        public void setTASK_ATTENTION(int TASK_ATTENTION) {
            this.TASK_ATTENTION = TASK_ATTENTION;
        }

        public int getTASK_GIFT() {
            return TASK_GIFT;
        }

        public void setTASK_GIFT(int TASK_GIFT) {
            this.TASK_GIFT = TASK_GIFT;
        }

        public int getTASK_PORT() {
            return TASK_PORT;
        }

        public void setTASK_PORT(int TASK_PORT) {
            this.TASK_PORT = TASK_PORT;
        }

        public String getHONOURUSER_ID() {
            return HONOURUSER_ID;
        }

        public void setHONOURUSER_ID(String HONOURUSER_ID) {
            this.HONOURUSER_ID = HONOURUSER_ID;
        }
    }
}
