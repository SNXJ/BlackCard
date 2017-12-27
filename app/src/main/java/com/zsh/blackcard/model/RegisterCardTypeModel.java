package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/12/14.
 */

public class RegisterCardTypeModel {

    /**
     * result : 01
     * pd : {"CARDTYPENAME":"至尊会籍卡","CARDIMGS":["http://47.104.16.215:8088/cardimgs/cardtypeimgs/ccb23411c6f74e18ac3b8eb0f0a808f4.jpg","http://47.104.16.215:8088/cardimgs/cardtypeimgs/bdebb4f5bf7f4c58853a43a24740c00c.jpg","http://47.104.16.215:8088/cardimgs/cardtypeimgs/e61c07bb7426473daa4c5c71f304e6a7.jpg"],"CARDTYPE":"至尊会籍卡","CARDTYPE_ID":"390181853778149376"}
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
         * CARDTYPENAME : 至尊会籍卡
         * CARDIMGS : ["http://47.104.16.215:8088/cardimgs/cardtypeimgs/ccb23411c6f74e18ac3b8eb0f0a808f4.jpg","http://47.104.16.215:8088/cardimgs/cardtypeimgs/bdebb4f5bf7f4c58853a43a24740c00c.jpg","http://47.104.16.215:8088/cardimgs/cardtypeimgs/e61c07bb7426473daa4c5c71f304e6a7.jpg"]
         * CARDTYPE : 至尊会籍卡
         * CARDTYPE_ID : 390181853778149376
         */

        private String CARDTYPENAME;
        private String CARDTYPE;
        private String CARDTYPE_ID;
        private List<String> CARDIMGS;

        public String getCARDTYPENAME() {
            return CARDTYPENAME;
        }

        public void setCARDTYPENAME(String CARDTYPENAME) {
            this.CARDTYPENAME = CARDTYPENAME;
        }

        public String getCARDTYPE() {
            return CARDTYPE;
        }

        public void setCARDTYPE(String CARDTYPE) {
            this.CARDTYPE = CARDTYPE;
        }

        public String getCARDTYPE_ID() {
            return CARDTYPE_ID;
        }

        public void setCARDTYPE_ID(String CARDTYPE_ID) {
            this.CARDTYPE_ID = CARDTYPE_ID;
        }

        public List<String> getCARDIMGS() {
            return CARDIMGS;
        }

        public void setCARDIMGS(List<String> CARDIMGS) {
            this.CARDIMGS = CARDIMGS;
        }
    }
}
