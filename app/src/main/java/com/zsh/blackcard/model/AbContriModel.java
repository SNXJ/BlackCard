package com.zsh.blackcard.model;

import java.util.List;

/**
 * Name: AbContriModel
 * Author: Shing
 * Date: 2018/2/6 下午7:58
 * Description: ..
 */

public class AbContriModel {


    /**
     * result : 01
     * pd : [{"NICKNAME":"White55开","SCORE":600,"PORTRAIT":"http://image.rongyaohk.com/userportrait/3d0a82c5b88d4249aaee0d2a770b25e1.jpg","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"},{"NICKNAME":"周二珂","SCORE":500,"PORTRAIT":"http://image.rongyaohk.com/userportrait/e3e8b2119dfa4a1c85abfa7e3eef7a98.jpg","HONOURUSER_ID":"388279486010884100"},{"NICKNAME":"菜鸡维","SCORE":300,"PORTRAIT":"http://image.rongyaohk.com/personalimgs/perdetailimgs/02472ee0ffa148fe851470f41b1d05f7.png","HONOURUSER_ID":"392272912112943104"}]
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
         * NICKNAME : White55开
         * PKPARA : 600.0
         * PORTRAIT : http://image.rongyaohk.com/userportrait/3d0a82c5b88d4249aaee0d2a770b25e1.jpg
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         */

        private String NICKNAME;
        private String PKPARA;
        private String PORTRAIT;
        private String HONOURUSER_ID;

        public String getNICKNAME() {
            return NICKNAME;
        }

        public void setNICKNAME(String NICKNAME) {
            this.NICKNAME = NICKNAME;
        }

        public String getSCORE() {
            return PKPARA;
        }

        public void setSCORE(String SCORE) {
            this.PKPARA = SCORE;
        }

        public String getPORTRAIT() {
            return PORTRAIT;
        }

        public void setPORTRAIT(String PORTRAIT) {
            this.PORTRAIT = PORTRAIT;
        }

        public String getHONOURUSER_ID() {
            return HONOURUSER_ID;
        }

        public void setHONOURUSER_ID(String HONOURUSER_ID) {
            this.HONOURUSER_ID = HONOURUSER_ID;
        }
    }
}
