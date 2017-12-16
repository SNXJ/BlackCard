package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/12/13.
 * 能量值接口
 */

public class MyPowerModel {

    /**
     * result : 01
     * pd : [{"ENERGY_ID":"390461120202145792","SHOPSCORE":0,"compList":[{"SCORE":36,"ENERGY_ID":"390461120202145792","NAME":"购物分值","SCORECOMPONENT_ID":"390469970280054784"}],"INTRODUCE":"购物分是购买金额的总和分值。每一笔订单、每日、每月、每一类商品、每一个店铺，可获得的最高可得分都不同，购买更多种类的、高信誉商家的商品可以得到更多分","NAME":"购物分"},{"ENERGY_ID":"390461193342418944","compList":[{"SCORE":30,"ENERGY_ID":"390461193342418944","NAME":"发起分值","SCORECOMPONENT_ID":"390502208426213376"},{"SCORE":20,"ENERGY_ID":"390461193342418944","NAME":"参与分值","SCORECOMPONENT_ID":"390502260674658304"}],"INTRODUCE":"活动分是发起活动和参与活动的总和分值。每一笔订单、每日、每月、每一类商品、每一个店铺，可获得的最高可得分都不同，购买更多种类的、高信誉商家的商品可以得到更多分","ACTIVITYSCORE":0,"NAME":"活动分"},{"ENERGY_ID":"390461255179042816","INTERACTSCORE":0,"compList":[{"SCORE":15,"ENERGY_ID":"390461255179042816","NAME":"分享分值","SCORECOMPONENT_ID":"390502456661901312"},{"SCORE":15,"ENERGY_ID":"390461255179042816","NAME":"任务分值","SCORECOMPONENT_ID":"390502505043197952"},{"SCORE":10,"ENERGY_ID":"390461255179042816","NAME":"签到分值","SCORECOMPONENT_ID":"390502554074611712"},{"SCORE":5,"ENERGY_ID":"390461255179042816","NAME":"点赞分值","SCORECOMPONENT_ID":"390502602728538112"},{"SCORE":60,"ENERGY_ID":"390461255179042816","NAME":"打赏分值","SCORECOMPONENT_ID":"390502656273022976"}],"INTRODUCE":"活动分是发起活动和参与活动的总和分值。每一笔订单、每日、每月、每一类商品、每一个店铺，可获得的最高可得分都不同，购买更多种类的、高信誉商家的商品可以得到更多分","NAME":"互动分"},{"ENERGY_ID":"390461320148811776","compList":[{"SCORE":100,"ENERGY_ID":"390461320148811776","NAME":"实名认证","SCORECOMPONENT_ID":"390502938906198016"},{"SCORE":100,"ENERGY_ID":"390461320148811776","NAME":"QQ绑定","SCORECOMPONENT_ID":"390502986280861696"},{"SCORE":100,"ENERGY_ID":"390461320148811776","NAME":"微信绑定","SCORECOMPONENT_ID":"390503033454198784"},{"SCORE":100,"ENERGY_ID":"390461320148811776","NAME":"微博绑定","SCORECOMPONENT_ID":"390503078962397184"},{"SCORE":1000,"ENERGY_ID":"390461320148811776","NAME":"支付宝绑定","SCORECOMPONENT_ID":"390503120972546048"}],"INTRODUCE":"活动分是发起活动和参与活动的总和分值。每一笔订单、每日、每月、每一类商品、每一个店铺，可获得的最高可得分都不同，购买更多种类的、高信誉商家的商品可以得到更多分","NAME":"基础分","BASISSCORE":0},{"ENERGY_ID":"390461533718577152","compList":[{"SCORE":200,"ENERGY_ID":"390461533718577152","NAME":"慈善贡献","SCORECOMPONENT_ID":"390503194263814144"},{"SCORE":100,"ENERGY_ID":"390461533718577152","NAME":"互帮互助","SCORECOMPONENT_ID":"390503238173982720"},{"SCORE":100,"ENERGY_ID":"390461533718577152","NAME":"参谋智者","SCORECOMPONENT_ID":"390503284416184320"}],"INTRODUCE":"活动分是发起活动和参与活动的总和分值。每一笔订单、每日、每月、每一类商品、每一个店铺，可获得的最高可得分都不同，购买更多种类的、高信誉商家的商品可以得到更多分","HONOURSCORE":0,"NAME":"荣耀分"}]
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
         * ENERGY_ID : 390461120202145792
         * SHOPSCORE : 0
         * compList : [{"SCORE":36,"ENERGY_ID":"390461120202145792","NAME":"购物分值","SCORECOMPONENT_ID":"390469970280054784"}]
         * INTRODUCE : 购物分是购买金额的总和分值。每一笔订单、每日、每月、每一类商品、每一个店铺，可获得的最高可得分都不同，购买更多种类的、高信誉商家的商品可以得到更多分
         * NAME : 购物分
         * ACTIVITYSCORE : 0
         * INTERACTSCORE : 0
         * BASISSCORE : 0
         * HONOURSCORE : 0
         */

        private String ENERGY_ID;
        private int SCORE;
        private String INTRODUCE;
        private String NAME;
        private int ACTIVITYSCORE;
        private int INTERACTSCORE;
        private int BASISSCORE;
        private int HONOURSCORE;
        private List<CompListBean> compList;

        public String getENERGY_ID() {
            return ENERGY_ID;
        }

        public void setENERGY_ID(String ENERGY_ID) {
            this.ENERGY_ID = ENERGY_ID;
        }

        public int getSCORE() {
            return SCORE;
        }

        public void setSCORE(int SHOPSCORE) {
            this.SCORE = SCORE;
        }

        public String getINTRODUCE() {
            return INTRODUCE;
        }

        public void setINTRODUCE(String INTRODUCE) {
            this.INTRODUCE = INTRODUCE;
        }

        public String getNAME() {
            return NAME;
        }

        public void setNAME(String NAME) {
            this.NAME = NAME;
        }

        public int getACTIVITYSCORE() {
            return ACTIVITYSCORE;
        }

        public void setACTIVITYSCORE(int ACTIVITYSCORE) {
            this.ACTIVITYSCORE = ACTIVITYSCORE;
        }

        public int getINTERACTSCORE() {
            return INTERACTSCORE;
        }

        public void setINTERACTSCORE(int INTERACTSCORE) {
            this.INTERACTSCORE = INTERACTSCORE;
        }

        public int getBASISSCORE() {
            return BASISSCORE;
        }

        public void setBASISSCORE(int BASISSCORE) {
            this.BASISSCORE = BASISSCORE;
        }

        public int getHONOURSCORE() {
            return HONOURSCORE;
        }

        public void setHONOURSCORE(int HONOURSCORE) {
            this.HONOURSCORE = HONOURSCORE;
        }

        public List<CompListBean> getCompList() {
            return compList;
        }

        public void setCompList(List<CompListBean> compList) {
            this.compList = compList;
        }

        public static class CompListBean {
            /**
             * SCORE : 36
             * ENERGY_ID : 390461120202145792
             * NAME : 购物分值
             * SCORECOMPONENT_ID : 390469970280054784
             */

            private int SCORE;
            private String ENERGY_ID;
            private String NAME;
            private String SCORECOMPONENT_ID;

            public int getSCORE() {
                return SCORE;
            }

            public void setSCORE(int SCORE) {
                this.SCORE = SCORE;
            }

            public String getENERGY_ID() {
                return ENERGY_ID;
            }

            public void setENERGY_ID(String ENERGY_ID) {
                this.ENERGY_ID = ENERGY_ID;
            }

            public String getNAME() {
                return NAME;
            }

            public void setNAME(String NAME) {
                this.NAME = NAME;
            }

            public String getSCORECOMPONENT_ID() {
                return SCORECOMPONENT_ID;
            }

            public void setSCORECOMPONENT_ID(String SCORECOMPONENT_ID) {
                this.SCORECOMPONENT_ID = SCORECOMPONENT_ID;
            }
        }
    }
}
