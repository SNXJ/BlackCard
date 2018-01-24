package com.zsh.blackcard.model;

/**
 * Name: LivePushModel
 * Author: Shing
 * Date: 2018/1/19 下午4:06
 * Description: ..
 */

public class LivePushModel {


    /**
     * result : 01
     * pd : {"PUSHADDRESS":"rtmp://video-center.alivecdn.com/ZSHApp/game1000001403883022?vhost=live.rongyaohk.com&auth_key=1516593807-0-0-1d0ee2c0b24a6ddcd993814962fa0779"}
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
         * PUSHADDRESS : rtmp://video-center.alivecdn.com/ZSHApp/game1000001403883022?vhost=live.rongyaohk.com&auth_key=1516593807-0-0-1d0ee2c0b24a6ddcd993814962fa0779
         */

        private String PUSHADDRESS;

        public String getPUSHADDRESS() {
            return PUSHADDRESS;
        }

        public void setPUSHADDRESS(String PUSHADDRESS) {
            this.PUSHADDRESS = PUSHADDRESS;
        }
    }
}
