package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/12/7.
 * 美食，酒吧，KTV，酒店品牌和筛选条件请求
 */

public class FoodHotelBarKTVDialogModel {

    /**
     * result : 01
     * pd : [{"NAME":"全聚德"},{"NAME":"海底捞"},{"NAME":"眉州小吃"},{"NAME":"呷哺呷哺"},{"NAME":"肯德基"},{"NAME":"必胜客"},{"NAME":"烧烤烤串"},{"NAME":"菲罗牛排"}]
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
         * NAME : 全聚德
         */

        private String NAME;

        public String getNAME() {
            return NAME;
        }

        public void setNAME(String NAME) {
            this.NAME = NAME;
        }
    }
}
