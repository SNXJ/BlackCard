package com.zsh.blackcard.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/27.
 * 首页荣耀服务实体类
 */

public class HomeGloryServerModel {

    /**
     * result : 01
     * pd : [{"SERVER_ID":"383279313174134784","SERVICEIMGS":"http://47.104.16.215:8088/serverimgs/855275ee34a4417197f042359a56d4b4.png","SERVICETITLE":"标题1","SERVICETYPE":"艺海品鉴 "},{"SERVER_ID":"383279420103720960","SERVICEIMGS":"http://47.104.16.215:8088/serverimgs/9c7eed06992f4f8f8ef0c3732c5ad176.png","SERVICETITLE":"标题2","SERVICETYPE":"金鹿救援"},{"SERVER_ID":"383279506741264384","SERVICEIMGS":"http://47.104.16.215:8088/serverimgs/76446894aa0d4fe6b7886abe025b50a5.png","SERVICETITLE":"标题3","SERVICETYPE":"九富投资顾问"},{"SERVER_ID":"383279609413632000","SERVICEIMGS":"http://47.104.16.215:8088/serverimgs/33c1e583214a416db3ad041f86d8ae5d.png","SERVICETITLE":"标题4","SERVICETYPE":"KK私人管家"}]
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

    public static class PdBean implements MultiItemEntity {
        /**
         * SERVER_ID : 383279313174134784
         * SERVICEIMGS : http://47.104.16.215:8088/serverimgs/855275ee34a4417197f042359a56d4b4.png
         * SERVICETITLE : 标题1
         * SERVICETYPE : 艺海品鉴
         */

        public static final int LEFT = 1;
        public static final int CENTER = 2;
        public static final int RIGHT = 3;
        private int itemType;

        public void setItemType(int itemType){
            this.itemType = itemType;
        }

        private String SERVER_ID;
        private String SERVICEIMGS;
        private String SERVICETITLE;
        private String SERVICETYPE;

        public String getSERVER_ID() {
            return SERVER_ID;
        }

        public void setSERVER_ID(String SERVER_ID) {
            this.SERVER_ID = SERVER_ID;
        }

        public String getSERVICEIMGS() {
            return SERVICEIMGS;
        }

        public void setSERVICEIMGS(String SERVICEIMGS) {
            this.SERVICEIMGS = SERVICEIMGS;
        }

        public String getSERVICETITLE() {
            return SERVICETITLE;
        }

        public void setSERVICETITLE(String SERVICETITLE) {
            this.SERVICETITLE = SERVICETITLE;
        }

        public String getSERVICETYPE() {
            return SERVICETYPE;
        }

        public void setSERVICETYPE(String SERVICETYPE) {
            this.SERVICETYPE = SERVICETYPE;
        }

        @Override
        public int getItemType() {
            return itemType;
        }
    }
}
