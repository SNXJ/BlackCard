package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/22.
 * 首页title滚动新闻实体类
 */

public class HomeTitleNewsModel {

    /**
     * result : 01
     * pd : [{"NEWS_ID":"382889968336371625","NEWSTITLE":"德玛西亚2"},{"NEWS_ID":"382889968336371635","NEWSTITLE":"德玛西亚1"},{"NEWS_ID":"382889968336371645","NEWSTITLE":"德玛西亚"}]
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
         * NEWS_ID : 382889968336371625
         * NEWSTITLE : 德玛西亚2
         */

        private String NEWS_ID;
        private String NEWSTITLE;

        public String getNEWS_ID() {
            return NEWS_ID;
        }

        public void setNEWS_ID(String NEWS_ID) {
            this.NEWS_ID = NEWS_ID;
        }

        public String getNEWSTITLE() {
            return NEWSTITLE;
        }

        public void setNEWSTITLE(String NEWSTITLE) {
            this.NEWSTITLE = NEWSTITLE;
        }
    }
}
