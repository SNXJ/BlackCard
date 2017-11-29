package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/29.
 * 高尔夫汇详情页面
 */

public class HomeGolfDetailModel {

    /**
     * result : 01
     * pd : [{"GOLFDETINTRO":"高尔夫介绍1","GOLFDETIMGS":["http://47.104.16.215:8088/highsortimgs/golfshopimgs/golfdetimgs/525cc6ee9e3e41558c9faa15626294a0.png","http://47.104.16.215:8088/highsortimgs/golfshopimgs/golfdetimgs/55b46d8740d240b7b3dd0aeda5eb1850.png","http://47.104.16.215:8088/highsortimgs/golfshopimgs/golfdetimgs/efa2f87138224f4996b991999af2454b.png"],"PUPINTROTITLE":"标题1","GOLFSHOP_ID":"383990831532474368","PUPINTROCONTENT":"内容1","PDOWNINTROTITLE":"注意1","GOLFDET_ID":"384756880884367360","PDOWNINTROCONTENT":"内容1"}]
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
         * GOLFDETINTRO : 高尔夫介绍1
         * GOLFDETIMGS : ["http://47.104.16.215:8088/highsortimgs/golfshopimgs/golfdetimgs/525cc6ee9e3e41558c9faa15626294a0.png","http://47.104.16.215:8088/highsortimgs/golfshopimgs/golfdetimgs/55b46d8740d240b7b3dd0aeda5eb1850.png","http://47.104.16.215:8088/highsortimgs/golfshopimgs/golfdetimgs/efa2f87138224f4996b991999af2454b.png"]
         * PUPINTROTITLE : 标题1
         * GOLFSHOP_ID : 383990831532474368
         * PUPINTROCONTENT : 内容1
         * PDOWNINTROTITLE : 注意1
         * GOLFDET_ID : 384756880884367360
         * PDOWNINTROCONTENT : 内容1
         */

        private String GOLFDETINTRO;
        private String PUPINTROTITLE;
        private String GOLFSHOP_ID;
        private String PUPINTROCONTENT;
        private String PDOWNINTROTITLE;
        private String GOLFDET_ID;
        private String PDOWNINTROCONTENT;
        private List<String> GOLFDETIMGS;

        public String getGOLFDETINTRO() {
            return GOLFDETINTRO;
        }

        public void setGOLFDETINTRO(String GOLFDETINTRO) {
            this.GOLFDETINTRO = GOLFDETINTRO;
        }

        public String getPUPINTROTITLE() {
            return PUPINTROTITLE;
        }

        public void setPUPINTROTITLE(String PUPINTROTITLE) {
            this.PUPINTROTITLE = PUPINTROTITLE;
        }

        public String getGOLFSHOP_ID() {
            return GOLFSHOP_ID;
        }

        public void setGOLFSHOP_ID(String GOLFSHOP_ID) {
            this.GOLFSHOP_ID = GOLFSHOP_ID;
        }

        public String getPUPINTROCONTENT() {
            return PUPINTROCONTENT;
        }

        public void setPUPINTROCONTENT(String PUPINTROCONTENT) {
            this.PUPINTROCONTENT = PUPINTROCONTENT;
        }

        public String getPDOWNINTROTITLE() {
            return PDOWNINTROTITLE;
        }

        public void setPDOWNINTROTITLE(String PDOWNINTROTITLE) {
            this.PDOWNINTROTITLE = PDOWNINTROTITLE;
        }

        public String getGOLFDET_ID() {
            return GOLFDET_ID;
        }

        public void setGOLFDET_ID(String GOLFDET_ID) {
            this.GOLFDET_ID = GOLFDET_ID;
        }

        public String getPDOWNINTROCONTENT() {
            return PDOWNINTROCONTENT;
        }

        public void setPDOWNINTROCONTENT(String PDOWNINTROCONTENT) {
            this.PDOWNINTROCONTENT = PDOWNINTROCONTENT;
        }

        public List<String> getGOLFDETIMGS() {
            return GOLFDETIMGS;
        }

        public void setGOLFDETIMGS(List<String> GOLFDETIMGS) {
            this.GOLFDETIMGS = GOLFDETIMGS;
        }
    }
}
