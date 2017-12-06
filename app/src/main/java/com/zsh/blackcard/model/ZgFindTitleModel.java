package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/12/6.
 * 尊购发现标题实体类
 */

public class ZgFindTitleModel {

    /**
     * result : 01
     * pd : [{"CAIDAN_ID":"387563351791632384","NAME":"精选"},{"CAIDAN_ID":"387563399975796736","NAME":"数码"},{"CAIDAN_ID":"387563457622310912","NAME":"亲子"},{"CAIDAN_ID":"387563486307155968","NAME":"时尚"},{"CAIDAN_ID":"387563525268045824","NAME":"美食"}]
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
         * CAIDAN_ID : 387563351791632384
         * NAME : 精选
         */

        private String CAIDAN_ID;
        private String NAME;

        public String getCAIDAN_ID() {
            return CAIDAN_ID;
        }

        public void setCAIDAN_ID(String CAIDAN_ID) {
            this.CAIDAN_ID = CAIDAN_ID;
        }

        public String getNAME() {
            return NAME;
        }

        public void setNAME(String NAME) {
            this.NAME = NAME;
        }
    }
}

