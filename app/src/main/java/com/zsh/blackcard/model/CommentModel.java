package com.zsh.blackcard.model;

import java.util.List;

/**
 * Name: CommentModel
 * Author: SNXJ
 * Date: 2017-11-23
 * Description:描述：评论
 */
public class CommentModel {
    /**
     * result : 01
     * pd : [{"NICKNAME":"小杰嘤嘤嘤","EVALUATECONTENT":"皮卡丘","PORTRAIT":"http://47.104.16.215:8088/productimgs/productshowimgs/c8a97a262b8640f2aae2305507332405.png","EVALUATEDATE":"2017-11-22"},{"NICKNAME":"小杰嘤嘤嘤","EVALUATECONTENT":"给你寄您是","PORTRAIT":"http://47.104.16.215:8088/productimgs/productshowimgs/c8a97a262b8640f2aae2305507332405.png","EVALUATEDATE":"2017-11-23"},{"NICKNAME":"小杰嘤嘤嘤","EVALUATECONTENT":"我评价的","PORTRAIT":"http://47.104.16.215:8088/productimgs/productshowimgs/c8a97a262b8640f2aae2305507332405.png","EVALUATEDATE":"2017-11-24"}]
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
         * NICKNAME : 小杰嘤嘤嘤
         * EVALUATECONTENT : 皮卡丘
         * PORTRAIT : http://47.104.16.215:8088/productimgs/productshowimgs/c8a97a262b8640f2aae2305507332405.png
         * EVALUATEDATE : 2017-11-22
         */

        private String NICKNAME;
        private String EVALUATECONTENT;
        private String PORTRAIT;
        private String EVALUATEDATE;

        public String getNICKNAME() {
            return NICKNAME;
        }

        public void setNICKNAME(String NICKNAME) {
            this.NICKNAME = NICKNAME;
        }

        public String getEVALUATECONTENT() {
            return EVALUATECONTENT;
        }

        public void setEVALUATECONTENT(String EVALUATECONTENT) {
            this.EVALUATECONTENT = EVALUATECONTENT;
        }

        public String getPORTRAIT() {
            return PORTRAIT;
        }

        public void setPORTRAIT(String PORTRAIT) {
            this.PORTRAIT = PORTRAIT;
        }

        public String getEVALUATEDATE() {
            return EVALUATEDATE;
        }

        public void setEVALUATEDATE(String EVALUATEDATE) {
            this.EVALUATEDATE = EVALUATEDATE;
        }
    }
}
