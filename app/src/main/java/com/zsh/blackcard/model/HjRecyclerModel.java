package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/22.
 * 汇聚页面列表实体类
 */

public class HjRecyclerModel {

    /**
     * result : 01
     * pd : [{"CONVERGEIMG":"http://47.104.16.215:8088/convergeimgs/8d854f4bed28479d91f7c7941014350a.png","IMGCNCHAR":"吃喝玩乐","IMGENCHAR":"Entertainment","CONVERGE_ID":"382889968336371712"},{"CONVERGEIMG":"http://47.104.16.215:8088/convergeimgs/ef51c038fbc84ef6b6e1fc081322169d.png","IMGCNCHAR":"高端品鉴","IMGENCHAR":"Entertainment","CONVERGE_ID":"382890302907613184"},{"CONVERGEIMG":"http://47.104.16.215:8088/convergeimgs/af54315b6de5434fa70e2a8d3aecfbbd.png","IMGCNCHAR":"荣耀活动","IMGENCHAR":"Glory activities","CONVERGE_ID":"382890394876116992"},{"CONVERGEIMG":"http://47.104.16.215:8088/convergeimgs/4c26b16b58694c34b595e6e1ceef9def.png","IMGCNCHAR":"金钻活动","IMGENCHAR":"Diamond activities","CONVERGE_ID":"382890583389110272"}]
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
         * CONVERGEIMG : http://47.104.16.215:8088/convergeimgs/8d854f4bed28479d91f7c7941014350a.png
         * IMGCNCHAR : 吃喝玩乐
         * IMGENCHAR : Entertainment
         * CONVERGE_ID : 382889968336371712
         */

        private String CONVERGEIMG;
        private String IMGCNCHAR;
        private String IMGENCHAR;
        private String CONVERGE_ID;

        public String getCONVERGEIMG() {
            return CONVERGEIMG;
        }

        public void setCONVERGEIMG(String CONVERGEIMG) {
            this.CONVERGEIMG = CONVERGEIMG;
        }

        public String getIMGCNCHAR() {
            return IMGCNCHAR;
        }

        public void setIMGCNCHAR(String IMGCNCHAR) {
            this.IMGCNCHAR = IMGCNCHAR;
        }

        public String getIMGENCHAR() {
            return IMGENCHAR;
        }

        public void setIMGENCHAR(String IMGENCHAR) {
            this.IMGENCHAR = IMGENCHAR;
        }

        public String getCONVERGE_ID() {
            return CONVERGE_ID;
        }

        public void setCONVERGE_ID(String CONVERGE_ID) {
            this.CONVERGE_ID = CONVERGE_ID;
        }
    }
}
