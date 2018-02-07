package com.zsh.blackcard.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kkkkk on 2017/12/6.
 * 尊购发现标题实体类
 */

public class NewsChannelModel implements Serializable {

    /**
     * result : 01
     * pd : [{"CAIDAN_ID":"387563351791632384","NAME":"精选"},{"CAIDAN_ID":"387563399975796736","NAME":"数码"},{"CAIDAN_ID":"387563457622310912","NAME":"亲子"},{"CAIDAN_ID":"387563486307155968","NAME":"时尚"},{"CAIDAN_ID":"387563525268045824","NAME":"美食"}]
     */

    private String result;
    private List<ChannelModel> pd;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<ChannelModel> getPd() {
        return pd;
    }

    public void setPd(List<ChannelModel> pd) {
        this.pd = pd;
    }

//    public static class PdBean {
//        /**
//         * CAIDAN_ID : 387563351791632384
//         * NAME : 精选
//         */
//
//        private String CAIDAN_ID;
//        private String NAME;
//
//        public String getCAIDAN_ID() {
//            return CAIDAN_ID;
//        }
//
//        public void setCAIDAN_ID(String CAIDAN_ID) {
//            this.CAIDAN_ID = CAIDAN_ID;
//        }
//
//        public String getNAME() {
//            return NAME;
//        }
//
//        public void setNAME(String NAME) {
//            this.NAME = NAME;
//        }
//    }
}

