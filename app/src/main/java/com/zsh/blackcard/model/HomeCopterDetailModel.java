package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/29.
 * 飞机详情实体类
 */

public class HomeCopterDetailModel {

    /**
     * result : 01
     * pd : [{"PLANESHOP_ID":"383995103208800256","PLANEDETINTRO":"飞机1","PUPINTROTITLE":"标题1","PLANEDETIMGS":["http://47.104.16.215:8088/highsortimgs/planeshopimgs/planedetimgs/d4ddb37119bf45379fea7b064313a89e.png","http://47.104.16.215:8088/highsortimgs/planeshopimgs/planedetimgs/70196be9490447798051cfc60ff2f6fd.png","http://47.104.16.215:8088/highsortimgs/planeshopimgs/planedetimgs/e1fe901e7bc8430cace9f29121923a9d.png"],"PUPINTROCONTENT":"内容1","PDOWNINTROTITLE":"注意1","PDOWNINTROCONTENT":"内容1","PLANEDET_ID":"384757894362431488"}]
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
         * PLANESHOP_ID : 383995103208800256
         * PLANEDETINTRO : 飞机1
         * PUPINTROTITLE : 标题1
         * PLANEDETIMGS : ["http://47.104.16.215:8088/highsortimgs/planeshopimgs/planedetimgs/d4ddb37119bf45379fea7b064313a89e.png","http://47.104.16.215:8088/highsortimgs/planeshopimgs/planedetimgs/70196be9490447798051cfc60ff2f6fd.png","http://47.104.16.215:8088/highsortimgs/planeshopimgs/planedetimgs/e1fe901e7bc8430cace9f29121923a9d.png"]
         * PUPINTROCONTENT : 内容1
         * PDOWNINTROTITLE : 注意1
         * PDOWNINTROCONTENT : 内容1
         * PLANEDET_ID : 384757894362431488
         */

        private String PLANESHOP_ID;
        private String PLANEDETINTRO;
        private String PUPINTROTITLE;
        private String PUPINTROCONTENT;
        private String PDOWNINTROTITLE;
        private String PDOWNINTROCONTENT;
        private String PLANEDET_ID;
        private List<String> PLANEDETIMGS;

        public String getPLANESHOP_ID() {
            return PLANESHOP_ID;
        }

        public void setPLANESHOP_ID(String PLANESHOP_ID) {
            this.PLANESHOP_ID = PLANESHOP_ID;
        }

        public String getPLANEDETINTRO() {
            return PLANEDETINTRO;
        }

        public void setPLANEDETINTRO(String PLANEDETINTRO) {
            this.PLANEDETINTRO = PLANEDETINTRO;
        }

        public String getPUPINTROTITLE() {
            return PUPINTROTITLE;
        }

        public void setPUPINTROTITLE(String PUPINTROTITLE) {
            this.PUPINTROTITLE = PUPINTROTITLE;
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

        public String getPDOWNINTROCONTENT() {
            return PDOWNINTROCONTENT;
        }

        public void setPDOWNINTROCONTENT(String PDOWNINTROCONTENT) {
            this.PDOWNINTROCONTENT = PDOWNINTROCONTENT;
        }

        public String getPLANEDET_ID() {
            return PLANEDET_ID;
        }

        public void setPLANEDET_ID(String PLANEDET_ID) {
            this.PLANEDET_ID = PLANEDET_ID;
        }

        public List<String> getPLANEDETIMGS() {
            return PLANEDETIMGS;
        }

        public void setPLANEDETIMGS(List<String> PLANEDETIMGS) {
            this.PLANEDETIMGS = PLANEDETIMGS;
        }
    }
}
