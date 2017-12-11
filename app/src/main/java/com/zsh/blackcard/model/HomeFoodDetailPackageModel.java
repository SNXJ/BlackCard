package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/12/4.
 * 首页美食列表详情的 套餐列表实体类
 */

public class HomeFoodDetailPackageModel {

    /**
     * result : 01
     * pd : [{"FOODDETAIL_ID":"387192633518194688","FOODDETPRICE":199,"SORTFOOD_ID":"382585520535896064","FOODDETREMARK":"周一至周日 免预约","FOODDETNAME":"双人套餐","FOODDETIMGS":"http://47.104.16.215:8088/sortimgs/sortfoodimgs/fooddetimgs/91dc7af657a24131bd9db435bb7dc2e1.png"},{"FOODDETAIL_ID":"387192778943102976","FOODDETPRICE":369,"SORTFOOD_ID":"382585520535896064","FOODDETREMARK":"周一至周日 免预约","FOODDETNAME":"四人套餐","FOODDETIMGS":"http://47.104.16.215:8088/sortimgs/sortfoodimgs/fooddetimgs/ce8b90ff196f46e98aa47bc2038d7253.png"}]
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
         * FOODDETAIL_ID : 387192633518194688
         * FOODDETPRICE : 199
         * SORTFOOD_ID : 382585520535896064
         * FOODDETREMARK : 周一至周日 免预约
         * FOODDETNAME : 双人套餐
         * FOODDETIMGS : http://47.104.16.215:8088/sortimgs/sortfoodimgs/fooddetimgs/91dc7af657a24131bd9db435bb7dc2e1.png
         */

        private String FOODDETAIL_ID;
        private int FOODDETPRICE;
        private String SORTFOOD_ID;
        private String FOODDETREMARK;
        private String FOODDETNAME;
        private String FOODDETIMGS;

        public String getFOODDETAIL_ID() {
            return FOODDETAIL_ID;
        }

        public void setFOODDETAIL_ID(String FOODDETAIL_ID) {
            this.FOODDETAIL_ID = FOODDETAIL_ID;
        }

        public int getFOODDETPRICE() {
            return FOODDETPRICE;
        }

        public void setFOODDETPRICE(int FOODDETPRICE) {
            this.FOODDETPRICE = FOODDETPRICE;
        }

        public String getSORTFOOD_ID() {
            return SORTFOOD_ID;
        }

        public void setSORTFOOD_ID(String SORTFOOD_ID) {
            this.SORTFOOD_ID = SORTFOOD_ID;
        }

        public String getFOODDETREMARK() {
            return FOODDETREMARK;
        }

        public void setFOODDETREMARK(String FOODDETREMARK) {
            this.FOODDETREMARK = FOODDETREMARK;
        }

        public String getFOODDETNAME() {
            return FOODDETNAME;
        }

        public void setFOODDETNAME(String FOODDETNAME) {
            this.FOODDETNAME = FOODDETNAME;
        }

        public String getFOODDETIMGS() {
            return FOODDETIMGS;
        }

        public void setFOODDETIMGS(String FOODDETIMGS) {
            this.FOODDETIMGS = FOODDETIMGS;
        }
    }
}
