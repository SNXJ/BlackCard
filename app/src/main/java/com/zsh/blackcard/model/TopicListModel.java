package com.zsh.blackcard.model;

import java.util.List;

/**
 * Name: TopicListModel
 * Author: Shing
 * Date: 17/12/29 上午10:58
 * Description: ..
 */

public class TopicListModel {



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
         * SHOWIMG : http://47.104.16.215:8088/topicimgs/9282d656ccaa41e5995c1eb2ce27395c.png
         * DESCRIPTION : 刚骗了我加入丐帮能致富，又想骗我去乌克兰....
         * TITLE : 乌克兰美女愁嫁
         * TOPIC_ID : 395976880584392704
         */

        private String SHOWIMG;
        private String DESCRIPTION;
        private String TITLE;
        private String TOPIC_ID;

        public String getSHOWIMG() {
            return SHOWIMG;
        }

        public void setSHOWIMG(String SHOWIMG) {
            this.SHOWIMG = SHOWIMG;
        }

        public String getDESCRIPTION() {
            return DESCRIPTION;
        }

        public void setDESCRIPTION(String DESCRIPTION) {
            this.DESCRIPTION = DESCRIPTION;
        }

        public String getTITLE() {
            return TITLE;
        }

        public void setTITLE(String TITLE) {
            this.TITLE = TITLE;
        }

        public String getTOPIC_ID() {
            return TOPIC_ID;
        }

        public void setTOPIC_ID(String TOPIC_ID) {
            this.TOPIC_ID = TOPIC_ID;
        }
    }
}
