package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/29.
 * 游艇详情实体类
 */

public class HomeYachtDetailModel {


    /**
     * result : 01
     * pd : [{"YACHTDET_ID":"384758221144850432","YACHTSHOP_ID":"383995743632883712","PUPINTROTITLE":"标题1","YACHTDETIMGS":"http://47.104.16.215:8088/highsortimgs/yachtshopimgs/yachtdetimgs/e9764fbfe63a4d91a26176b56640d630.png,http://47.104.16.215:8088/highsortimgs/yachtshopimgs/yachtdetimgs/ae9911d3c1184de3a926edc9cc0961cd.png,http://47.104.16.215:8088/highsortimgs/yachtshopimgs/yachtdetimgs/0682a240f99749a38cddb0964d453cb9.png","PUPINTROCONTENT":"内容1","PDOWNINTROTITLE":"注意1","YACHTDETINTRO":"游艇1","PDOWNINTROCONTENT":"内容1"}]
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
         * YACHTDET_ID : 384758221144850432
         * YACHTSHOP_ID : 383995743632883712
         * PUPINTROTITLE : 标题1
         * YACHTDETIMGS : http://47.104.16.215:8088/highsortimgs/yachtshopimgs/yachtdetimgs/e9764fbfe63a4d91a26176b56640d630.png,http://47.104.16.215:8088/highsortimgs/yachtshopimgs/yachtdetimgs/ae9911d3c1184de3a926edc9cc0961cd.png,http://47.104.16.215:8088/highsortimgs/yachtshopimgs/yachtdetimgs/0682a240f99749a38cddb0964d453cb9.png
         * PUPINTROCONTENT : 内容1
         * PDOWNINTROTITLE : 注意1
         * YACHTDETINTRO : 游艇1
         * PDOWNINTROCONTENT : 内容1
         */

        private String YACHTDET_ID;
        private String YACHTSHOP_ID;
        private String PUPINTROTITLE;
        private List<String> YACHTDETIMGS;
        private String PUPINTROCONTENT;

        public List<String> getYACHTDETIMGS() {
            return YACHTDETIMGS;
        }

        public void setYACHTDETIMGS(List<String> YACHTDETIMGS) {
            this.YACHTDETIMGS = YACHTDETIMGS;
        }

        private String PDOWNINTROTITLE;
        private String YACHTDETINTRO;
        private String PDOWNINTROCONTENT;

        public String getYACHTDET_ID() {
            return YACHTDET_ID;
        }

        public void setYACHTDET_ID(String YACHTDET_ID) {
            this.YACHTDET_ID = YACHTDET_ID;
        }

        public String getYACHTSHOP_ID() {
            return YACHTSHOP_ID;
        }

        public void setYACHTSHOP_ID(String YACHTSHOP_ID) {
            this.YACHTSHOP_ID = YACHTSHOP_ID;
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

        public String getYACHTDETINTRO() {
            return YACHTDETINTRO;
        }

        public void setYACHTDETINTRO(String YACHTDETINTRO) {
            this.YACHTDETINTRO = YACHTDETINTRO;
        }

        public String getPDOWNINTROCONTENT() {
            return PDOWNINTROCONTENT;
        }

        public void setPDOWNINTROCONTENT(String PDOWNINTROCONTENT) {
            this.PDOWNINTROCONTENT = PDOWNINTROCONTENT;
        }
    }
}
