package com.zsh.blackcard.model;

/**
 * Name: LiveRoomDialogModel
 * Author: Shing
 * Date: 2018/2/2 下午6:01
 * Description: ..
 */

public class LiveRoomDialogModel {

    /**
     * result : 01
     * pd : {"PORTRAIT":"http://image.rongyaohk.com/userportrait/e3e8b2119dfa4a1c85abfa7e3eef7a98.jpg","isfriend":1,"focus":2,"dynamic":0,"HONOURUSER_ID":"388279486010884100","fans":0}
     */

    private String result;
    private PdBean pd;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public PdBean getPd() {
        return pd;
    }

    public void setPd(PdBean pd) {
        this.pd = pd;
    }

    public static class PdBean {
        /**
         * PORTRAIT : http://image.rongyaohk.com/userportrait/e3e8b2119dfa4a1c85abfa7e3eef7a98.jpg
         * isfriend : 1 关注
         * focus : 2
         * dynamic : 0
         * HONOURUSER_ID : 388279486010884100
         * fans : 0
         */

        private String PORTRAIT;
        private String isfriend;
        private String focus;
        private String dynamic;
        private String HONOURUSER_ID;
        private String fans;

        public String getPORTRAIT() {
            return PORTRAIT;
        }

        public void setPORTRAIT(String PORTRAIT) {
            this.PORTRAIT = PORTRAIT;
        }

        public String getIsfriend() {
            return isfriend;
        }

        public void setIsfriend(String isfriend) {
            this.isfriend = isfriend;
        }

        public String getFocus() {
            return focus;
        }

        public void setFocus(String focus) {
            this.focus = focus;
        }

        public String getDynamic() {
            return dynamic;
        }

        public void setDynamic(String dynamic) {
            this.dynamic = dynamic;
        }

        public String getHONOURUSER_ID() {
            return HONOURUSER_ID;
        }

        public void setHONOURUSER_ID(String HONOURUSER_ID) {
            this.HONOURUSER_ID = HONOURUSER_ID;
        }

        public String getFans() {
            return fans;
        }

        public void setFans(String fans) {
            this.fans = fans;
        }
    }
}
