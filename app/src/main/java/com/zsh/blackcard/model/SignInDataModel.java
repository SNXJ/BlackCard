package com.zsh.blackcard.model;

/**
 * Name: SignInDataModel
 * Author: Shing
 * Date: 2018/2/5 下午3:47
 * Description: ..
 */

public class SignInDataModel {


    /**
     * result : 01
     * pd : {"CHECK_DATE":"2018-02-05","CHECK_INDAYS":2,"CHECK_DATES":"04,05"}
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
         * CHECK_DATE : 2018-02-05
         * CHECK_INDAYS : 2
         * CHECK_DATES : 04,05
         */

        private String CHECK_DATE;
        private String CHECK_INDAYS;
        private String CHECK_DATES;

        public String getCHECK_DATE() {
            return CHECK_DATE;
        }

        public void setCHECK_DATE(String CHECK_DATE) {
            this.CHECK_DATE = CHECK_DATE;
        }

        public String getCHECK_INDAYS() {
            return CHECK_INDAYS;
        }

        public void setCHECK_INDAYS(String CHECK_INDAYS) {
            this.CHECK_INDAYS = CHECK_INDAYS;
        }

        public String getCHECK_DATES() {
            return CHECK_DATES;
        }

        public void setCHECK_DATES(String CHECK_DATES) {
            this.CHECK_DATES = CHECK_DATES;
        }
    }
}
