package com.zsh.blackcard.model;

import java.util.List;

/**
 * Name: LivePushListModel
 * Author: Shing
 * Date: 2018/1/22 下午3:34
 * Description: ..
 */

public class LivePushListModel {


    /**
     * result : 01
     * pd : {"PUSHONLINE":{"RequestId":"F17A62B1-CFED-4E35-BF79-59F6F923BECB","OnlineInfo":{"LiveStreamOnlineInfo":[{"PublishUrl":"rtmp://live.rongyaohk.com/ZSHApp/game1000001511705059?auth_key=1516610370-0-0-e465ca381937c4491c41603fee1f9c22","PublishTime":"2018-01-22T07:38:58Z","UserNumber":"0.0"}]}}}
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
         * PUSHONLINE : {"RequestId":"F17A62B1-CFED-4E35-BF79-59F6F923BECB","OnlineInfo":{"LiveStreamOnlineInfo":[{"PublishUrl":"rtmp://live.rongyaohk.com/ZSHApp/game1000001511705059?auth_key=1516610370-0-0-e465ca381937c4491c41603fee1f9c22","PublishTime":"2018-01-22T07:38:58Z","UserNumber":"0.0"}]}}
         */

        private PUSHONLINEBean PUSHONLINE;

        public PUSHONLINEBean getPUSHONLINE() {
            return PUSHONLINE;
        }

        public void setPUSHONLINE(PUSHONLINEBean PUSHONLINE) {
            this.PUSHONLINE = PUSHONLINE;
        }

        public static class PUSHONLINEBean {
            /**
             * RequestId : F17A62B1-CFED-4E35-BF79-59F6F923BECB
             * OnlineInfo : {"LiveStreamOnlineInfo":[{"PublishUrl":"rtmp://live.rongyaohk.com/ZSHApp/game1000001511705059?auth_key=1516610370-0-0-e465ca381937c4491c41603fee1f9c22","PublishTime":"2018-01-22T07:38:58Z","UserNumber":"0.0"}]}
             */

            private String RequestId;
            private OnlineInfoBean OnlineInfo;

            public String getRequestId() {
                return RequestId;
            }

            public void setRequestId(String RequestId) {
                this.RequestId = RequestId;
            }

            public OnlineInfoBean getOnlineInfo() {
                return OnlineInfo;
            }

            public void setOnlineInfo(OnlineInfoBean OnlineInfo) {
                this.OnlineInfo = OnlineInfo;
            }

            public static class OnlineInfoBean {
                private List<LiveStreamOnlineInfoBean> LiveStreamOnlineInfo;

                public List<LiveStreamOnlineInfoBean> getLiveStreamOnlineInfo() {
                    return LiveStreamOnlineInfo;
                }

                public void setLiveStreamOnlineInfo(List<LiveStreamOnlineInfoBean> LiveStreamOnlineInfo) {
                    this.LiveStreamOnlineInfo = LiveStreamOnlineInfo;
                }

                public static class LiveStreamOnlineInfoBean {
                    /**
                     * PublishUrl : rtmp://live.rongyaohk.com/ZSHApp/game1000001511705059?auth_key=1516610370-0-0-e465ca381937c4491c41603fee1f9c22
                     * PublishTime : 2018-01-22T07:38:58Z
                     * UserNumber : 0.0
                     */

                    private String PublishUrl;
                    private String PublishTime;
                    private String UserNumber;

                    public String getPublishUrl() {
                        return PublishUrl;
                    }

                    public void setPublishUrl(String PublishUrl) {
                        this.PublishUrl = PublishUrl;
                    }

                    public String getPublishTime() {
                        return PublishTime;
                    }

                    public void setPublishTime(String PublishTime) {
                        this.PublishTime = PublishTime;
                    }

                    public String getUserNumber() {
                        return UserNumber;
                    }

                    public void setUserNumber(String UserNumber) {
                        this.UserNumber = UserNumber;
                    }
                }
            }
        }
    }
}
