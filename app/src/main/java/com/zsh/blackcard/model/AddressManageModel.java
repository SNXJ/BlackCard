package com.zsh.blackcard.model;

import java.io.Serializable;
import java.util.List;

/**
 * Name: AddressManageModel
 * Author: SNXJ
 * Date: 2017-11-24
 * Description:描述：
 */
public class AddressManageModel {
    /**
     * result : 01
     * pd : [{"ADRPHONE":"11111111111","ADDRESS":"朝阳区珠江帝景D区","PROVINCE":"北京市","CONSIGNEE":"孙非凡","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","ADDRESS_ID":"383264690228166656"}]
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

    public static class PdBean implements Serializable {
        /**
         * ADRPHONE : 11111111111
         * ADDRESS : 朝阳区珠江帝景D区
         * PROVINCE : 北京市
         * CONSIGNEE : 孙非凡
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         * ADDRESS_ID : 383264690228166656
         */

        private String ADRPHONE;
        private String ADDRESS;
        private String PROVINCE;
        private String CONSIGNEE;
        private String HONOURUSER_ID;
        private String ADDRESS_ID;

        public String getADRPHONE() {
            return ADRPHONE;
        }

        public void setADRPHONE(String ADRPHONE) {
            this.ADRPHONE = ADRPHONE;
        }

        public String getADDRESS() {
            return ADDRESS;
        }

        public void setADDRESS(String ADDRESS) {
            this.ADDRESS = ADDRESS;
        }

        public String getPROVINCE() {
            return PROVINCE;
        }

        public void setPROVINCE(String PROVINCE) {
            this.PROVINCE = PROVINCE;
        }

        public String getCONSIGNEE() {
            return CONSIGNEE;
        }

        public void setCONSIGNEE(String CONSIGNEE) {
            this.CONSIGNEE = CONSIGNEE;
        }

        public String getHONOURUSER_ID() {
            return HONOURUSER_ID;
        }

        public void setHONOURUSER_ID(String HONOURUSER_ID) {
            this.HONOURUSER_ID = HONOURUSER_ID;
        }

        public String getADDRESS_ID() {
            return ADDRESS_ID;
        }

        public void setADDRESS_ID(String ADDRESS_ID) {
            this.ADDRESS_ID = ADDRESS_ID;
        }
    }
}
