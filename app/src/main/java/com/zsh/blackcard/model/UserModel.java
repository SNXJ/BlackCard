package com.zsh.blackcard.model;

/**
 * @Author snxj .
 * @Date 2017/11/6
 * @Describe *
 */

public class UserModel {
    private boolean rtState;
    private String rtMsg;
   // private User rtData;

    public boolean isRtState() {
        return rtState;
    }

    public void setRtState(boolean rtState) {
        this.rtState = rtState;
    }

    public String getRtMsg() {
        return rtMsg;
    }

    public void setRtMsg(String rtMsg) {
        this.rtMsg = rtMsg;
    }

  //  public User getRtData() {
//        return rtData;
//    }
//
//    public void setRtData(User rtData) {
//        this.rtData = rtData;
//    }
}
