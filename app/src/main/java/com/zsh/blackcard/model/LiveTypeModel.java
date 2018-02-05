package com.zsh.blackcard.model;

import java.util.List;

/**
 * Name: LiveTypeModel
 * Author: Shing
 * Date: 2018/1/29 上午10:35
 * Description: ..
 */

public class LiveTypeModel {


    /**
     * result : 01
     * pd : [{"LIVETYPE_ID":"405384436780105728","NAME":"黑咖达人"},{"LIVETYPE_ID":"405384762706886656","NAME":"黑咖名人"},{"LIVETYPE_ID":"405384802292727808","NAME":"黑咖明星"},{"LIVETYPE_ID":"405384832596574208","NAME":"黑咖帅哥"},{"LIVETYPE_ID":"405385649038819328","NAME":"黑咖美女"}]
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
         * LIVETYPE_ID : 405384436780105728
         * NAME : 黑咖达人
         */
        private boolean isSelect;
        private String LIVETYPE_ID;
        private String NAME;

        public String getLIVETYPE_ID() {
            return LIVETYPE_ID;
        }

        public void setLIVETYPE_ID(String LIVETYPE_ID) {
            this.LIVETYPE_ID = LIVETYPE_ID;
        }

        public String getNAME() {
            return NAME;
        }

        public void setNAME(String NAME) {
            this.NAME = NAME;
        }

        public boolean getSelect() {
            return isSelect;
        }

        public void setSelect(boolean select) {
            isSelect = select;
        }

    }
}
