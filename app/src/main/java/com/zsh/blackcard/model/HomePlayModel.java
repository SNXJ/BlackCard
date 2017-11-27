package com.zsh.blackcard.model;

/**
 * Created by kkkkk on 2017/11/27.
 * 首页汇聚玩趴实体类
 */

public class HomePlayModel {

    /**
     * result : 01
     * pd : {"PARTYIMG":"http://47.104.16.215:8088/homeimgs/partyimgs/145cf9921bf344b7802e7296c2148e36.png","PARTYIMG_ID":"384672385179058176"}
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
         * PARTYIMG : http://47.104.16.215:8088/homeimgs/partyimgs/145cf9921bf344b7802e7296c2148e36.png
         * PARTYIMG_ID : 384672385179058176
         */

        private String PARTYIMG;
        private String PARTYIMG_ID;

        public String getPARTYIMG() {
            return PARTYIMG;
        }

        public void setPARTYIMG(String PARTYIMG) {
            this.PARTYIMG = PARTYIMG;
        }

        public String getPARTYIMG_ID() {
            return PARTYIMG_ID;
        }

        public void setPARTYIMG_ID(String PARTYIMG_ID) {
            this.PARTYIMG_ID = PARTYIMG_ID;
        }
    }
}
