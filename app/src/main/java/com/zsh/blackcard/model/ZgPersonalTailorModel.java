package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/24.
 * 尊购侧滑界面私人定制实体类
 */

public class ZgPersonalTailorModel {

    /**
     * result : 01
     * pd : [{"IMGENCHAR":"GIEVES&HAWKES","PERSONAL_ID":"26ce9cfadff44e9fa46aa7cab98a677c","PERSONALTYPE":"服饰","PERSONALIMGS":"http://47.104.16.215:8088/personalimgs/personalimg/ddbed16daf194e1aa39b924ef4793b19.png","IMGSCNCHAR":"英国皇家绅士品牌"},{"IMGENCHAR":"ANDREW","PERSONAL_ID":"349c13ab06df4072837a7c659bd2d4a4","PERSONALTYPE":"婚纱摄影","PERSONALIMGS":"http://47.104.16.215:8088/personalimgs/personalimg/ce64ad9d685143368af88ddc39b9f8a8.png","IMGSCNCHAR":"记录您的美好回忆"},{"IMGENCHAR":"TRAVELID","PERSONAL_ID":"42c5563440874918a832292c21b586bb","PERSONALTYPE":"旅游","PERSONALIMGS":"http://47.104.16.215:8088/personalimgs/personalimg/dd90a3c999ca488fb7c05fc139217c11.png","IMGSCNCHAR":"定制您的专属旅程"},{"IMGENCHAR":"CITIZEN","PERSONAL_ID":"4ef3f6aac85c4c8da1d01e72ffd8cad5","PERSONALTYPE":"手表","PERSONALIMGS":"http://47.104.16.215:8088/personalimgs/personalimg/93be38a38a2242138fe1db7dc43aeb9d.png","IMGSCNCHAR":"记录时间节点的仪式"},{"IMGENCHAR":"LABORON","PERSONAL_ID":"5f411af59665434cbf7c9cbcfa4f1f5b","PERSONALTYPE":"轻奢首饰","PERSONALIMGS":"http://47.104.16.215:8088/personalimgs/personalimg/6486d26b52da4957b1d41da5a3078904.png","IMGSCNCHAR":"情感定制 轻奢首饰"},{"IMGENCHAR":"璞素","PERSONAL_ID":"63029a2bb7e145c493cb5d88fa79ac73","PERSONALTYPE":"家具","PERSONALIMGS":"\r\n\r\nhttp://47.104.16.215:8088/personalimgs/personalimg/c3487fbfc09c40c483d4031eb357658d.png","IMGSCNCHAR":"风雅生活 璞素之美"},{"IMGENCHAR":"CICI","PERSONAL_ID":"d26bfc880b6e4bb68beda8235a676713","PERSONALTYPE":"东方文化","PERSONALIMGS":"http://47.104.16.215:8088/personalimgs/personalimg/f7b7d30494784857bd39c500c5eff754.png","IMGSCNCHAR":"新东方美学"}]
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
         * IMGENCHAR : GIEVES&HAWKES
         * PERSONAL_ID : 26ce9cfadff44e9fa46aa7cab98a677c
         * PERSONALTYPE : 服饰
         * PERSONALIMGS : http://47.104.16.215:8088/personalimgs/personalimg/ddbed16daf194e1aa39b924ef4793b19.png
         * IMGSCNCHAR : 英国皇家绅士品牌
         */

        private String IMGENCHAR;
        private String PERSONAL_ID;
        private String PERSONALTYPE;
        private String PERSONALIMGS;
        private String IMGSCNCHAR;

        public String getIMGENCHAR() {
            return IMGENCHAR;
        }

        public void setIMGENCHAR(String IMGENCHAR) {
            this.IMGENCHAR = IMGENCHAR;
        }

        public String getPERSONAL_ID() {
            return PERSONAL_ID;
        }

        public void setPERSONAL_ID(String PERSONAL_ID) {
            this.PERSONAL_ID = PERSONAL_ID;
        }

        public String getPERSONALTYPE() {
            return PERSONALTYPE;
        }

        public void setPERSONALTYPE(String PERSONALTYPE) {
            this.PERSONALTYPE = PERSONALTYPE;
        }

        public String getPERSONALIMGS() {
            return PERSONALIMGS;
        }

        public void setPERSONALIMGS(String PERSONALIMGS) {
            this.PERSONALIMGS = PERSONALIMGS;
        }

        public String getIMGSCNCHAR() {
            return IMGSCNCHAR;
        }

        public void setIMGSCNCHAR(String IMGSCNCHAR) {
            this.IMGSCNCHAR = IMGSCNCHAR;
        }
    }
}
