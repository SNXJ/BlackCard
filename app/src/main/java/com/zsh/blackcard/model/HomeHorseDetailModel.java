package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/29.
 * 马术详情实体类
 */

public class HomeHorseDetailModel {

    /**
     * result : 01
     * pd : [{"HORSEDET_ID":"384755205515771904","PUPINTROTITLE":"标题1","HORSESHOP_ID":"383990553504645120","PUPINTROCONTENT":"内容1","HORSEDETINTRO":"马术1","PDOWNINTROTITLE":"注意1","HORSEDETIMGS":"http://47.104.16.215:8088/highsortimgs/horseshopimgs/horsedetimgs/0b3f8ae785154a1a8b757c7ac3ed3e2b.png,http://47.104.16.215:8088/highsortimgs/horseshopimgs/horsedetimgs/bcad5657dd2948db873171dabd514d6b.png,http://47.104.16.215:8088/highsortimgs/horseshopimgs/horsedetimgs/31cea77ccf634ca781c40310d86caaf7.png","PDOWNINTROCONTENT":"内容1"}]
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
         * HORSEDET_ID : 384755205515771904
         * PUPINTROTITLE : 标题1
         * HORSESHOP_ID : 383990553504645120
         * PUPINTROCONTENT : 内容1
         * HORSEDETINTRO : 马术1
         * PDOWNINTROTITLE : 注意1
         * HORSEDETIMGS : http://47.104.16.215:8088/highsortimgs/horseshopimgs/horsedetimgs/0b3f8ae785154a1a8b757c7ac3ed3e2b.png,http://47.104.16.215:8088/highsortimgs/horseshopimgs/horsedetimgs/bcad5657dd2948db873171dabd514d6b.png,http://47.104.16.215:8088/highsortimgs/horseshopimgs/horsedetimgs/31cea77ccf634ca781c40310d86caaf7.png
         * PDOWNINTROCONTENT : 内容1
         */

        private String HORSEDET_ID;
        private String PUPINTROTITLE;
        private String HORSESHOP_ID;
        private String PUPINTROCONTENT;
        private String HORSEDETINTRO;
        private String PDOWNINTROTITLE;
        private List<String> HORSEDETIMGS;

        public List<String> getHORSEDETIMGS() {
            return HORSEDETIMGS;
        }

        public void setHORSEDETIMGS(List<String> HORSEDETIMGS) {
            this.HORSEDETIMGS = HORSEDETIMGS;
        }

        private String PDOWNINTROCONTENT;

        public String getHORSEDET_ID() {
            return HORSEDET_ID;
        }

        public void setHORSEDET_ID(String HORSEDET_ID) {
            this.HORSEDET_ID = HORSEDET_ID;
        }

        public String getPUPINTROTITLE() {
            return PUPINTROTITLE;
        }

        public void setPUPINTROTITLE(String PUPINTROTITLE) {
            this.PUPINTROTITLE = PUPINTROTITLE;
        }

        public String getHORSESHOP_ID() {
            return HORSESHOP_ID;
        }

        public void setHORSESHOP_ID(String HORSESHOP_ID) {
            this.HORSESHOP_ID = HORSESHOP_ID;
        }

        public String getPUPINTROCONTENT() {
            return PUPINTROCONTENT;
        }

        public void setPUPINTROCONTENT(String PUPINTROCONTENT) {
            this.PUPINTROCONTENT = PUPINTROCONTENT;
        }

        public String getHORSEDETINTRO() {
            return HORSEDETINTRO;
        }

        public void setHORSEDETINTRO(String HORSEDETINTRO) {
            this.HORSEDETINTRO = HORSEDETINTRO;
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
    }
}
