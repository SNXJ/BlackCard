package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/27.
 * 首页汇聚玩趴实体类
 */

public class HomePlayModel {

    /**
     * result : 01
     * pd : [{"PARTYIMG":"http://47.104.16.215:8088/homeimgs/partyimgs/145cf9921bf344b7802e7296c2148e36.png","PARTYIMG_ID":"384672385179058176"},{"PARTYIMG":"http://47.104.16.215:8088/homeimgs/partyimgs/2226d8dcc4f646ee9729935e6834f0d1.png","PARTYIMG_ID":"399941661339156480"},{"PARTYIMG":"http://47.104.16.215:8088/homeimgs/partyimgs/19a474b0b149416dafdb9d486280ad5d.png","PARTYIMG_ID":"399941785545080832"},{"PARTYIMG":"http://47.104.16.215:8088/homeimgs/partyimgs/2c15212f8423463d9acc55692560f521.png","PARTYIMG_ID":"399941839815180288"},{"PARTYIMG":"http://47.104.16.215:8088/homeimgs/partyimgs/6a29cda02e91473292ff29b5569d60b3.png","PARTYIMG_ID":"399941934304460800"},{"PARTYIMG":"http://47.104.16.215:8088/homeimgs/partyimgs/1fab3e739a7d419e8277dcaf5ebc9612.png","PARTYIMG_ID":"399941980676685824"}]
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
