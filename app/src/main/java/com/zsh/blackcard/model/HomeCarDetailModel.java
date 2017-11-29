package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/29.
 * 豪车详情实体类
 */

public class HomeCarDetailModel {

    /**
     * result : 01
     * pd : [{"LUXCARDET_ID":"384757198275739648","PUPINTROTITLE":"标题1","LUXCARSHOP_ID":"383994744717443072","LUXCARDETINTRO":"豪车1","PUPINTROCONTENT":"内容1","PDOWNINTROTITLE":"注意1","LUXCARDETIMGS":"http://47.104.16.215:8088/highsortimgs/luxcarshopimgs/luxcardetimgs/ffb2af91e96243ec8d984fb7c99b9b82.png,http://47.104.16.215:8088/highsortimgs/luxcarshopimgs/luxcardetimgs/e3898872c3fb48dfbf703630df2e45e1.png,http://47.104.16.215:8088/highsortimgs/luxcarshopimgs/luxcardetimgs/96691e2d3f0b40fb83cfcb5f4b4f5207.png","PDOWNINTROCONTENT":"内容1"}]
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
         * LUXCARDET_ID : 384757198275739648
         * PUPINTROTITLE : 标题1
         * LUXCARSHOP_ID : 383994744717443072
         * LUXCARDETINTRO : 豪车1
         * PUPINTROCONTENT : 内容1
         * PDOWNINTROTITLE : 注意1
         * LUXCARDETIMGS : http://47.104.16.215:8088/highsortimgs/luxcarshopimgs/luxcardetimgs/ffb2af91e96243ec8d984fb7c99b9b82.png,http://47.104.16.215:8088/highsortimgs/luxcarshopimgs/luxcardetimgs/e3898872c3fb48dfbf703630df2e45e1.png,http://47.104.16.215:8088/highsortimgs/luxcarshopimgs/luxcardetimgs/96691e2d3f0b40fb83cfcb5f4b4f5207.png
         * PDOWNINTROCONTENT : 内容1
         */

        private String LUXCARDET_ID;
        private String PUPINTROTITLE;
        private String LUXCARSHOP_ID;
        private String LUXCARDETINTRO;
        private String PUPINTROCONTENT;
        private String PDOWNINTROTITLE;
        private List<String> LUXCARDETIMGS;

        public List<String> getLUXCARDETIMGS() {
            return LUXCARDETIMGS;
        }

        public void setLUXCARDETIMGS(List<String> LUXCARDETIMGS) {
            this.LUXCARDETIMGS = LUXCARDETIMGS;
        }

        private String PDOWNINTROCONTENT;

        public String getLUXCARDET_ID() {
            return LUXCARDET_ID;
        }

        public void setLUXCARDET_ID(String LUXCARDET_ID) {
            this.LUXCARDET_ID = LUXCARDET_ID;
        }

        public String getPUPINTROTITLE() {
            return PUPINTROTITLE;
        }

        public void setPUPINTROTITLE(String PUPINTROTITLE) {
            this.PUPINTROTITLE = PUPINTROTITLE;
        }

        public String getLUXCARSHOP_ID() {
            return LUXCARSHOP_ID;
        }

        public void setLUXCARSHOP_ID(String LUXCARSHOP_ID) {
            this.LUXCARSHOP_ID = LUXCARSHOP_ID;
        }

        public String getLUXCARDETINTRO() {
            return LUXCARDETINTRO;
        }

        public void setLUXCARDETINTRO(String LUXCARDETINTRO) {
            this.LUXCARDETINTRO = LUXCARDETINTRO;
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
    }
}
