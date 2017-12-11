package com.zsh.blackcard.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by kkkkk on 2017/12/8.
 * 我的界面，圈子中心实体类
 */

public class MyCircleModel {

    /**
     * result : 01
     * pd : [{"dotAgreeCount":1,"SHOWIMAGES":"http://47.104.16.215:8088/highsortimgs/luxcarshopimgs/baae579c7f8646fa9758266d4ce4cb1a.png","PUBLISHTIME":"2017-12-06 02:23:12","CIRCLE_ID":"387972249954549760","CONTENT":"我的发布1","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","commentCount":4},{"dotAgreeCount":0,"SHOWIMAGES":"http://47.104.16.215:8088/highsortimgs/luxcarshopimgs/baae579c7f8646fa9758266d4ce4cb1a.png","PUBLISHTIME":"2017-12-06 02:24:14","CIRCLE_ID":"387972509233840128","CONTENT":"我的豪车店","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","commentCount":0},{"dotAgreeCount":0,"SHOWIMAGES":"http://47.104.16.215:8088/circleimgs/37fb4e3ed2cc4dc1a5038b3f69d663cb.jpg","PUBLISHTIME":"2017-12-08 01:43:14","CIRCLE_ID":"388686969472811008","CONTENT":"振华大宝贝儿","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","commentCount":0},{"dotAgreeCount":0,"SHOWIMAGES":"http://47.104.16.215:8088/circleimgs/e6d3f834816b4693950f897324d372fa.jpg,http://47.104.16.215:8088/circleimgs/1f2f29cba9d047f3a9758a92539de7af.jpg,http://47.104.16.215:8088/circleimgs/ba232f352a4b482fb9897e712baa9f72.jpg","PUBLISHTIME":"2017-12-08 10:31:34","CIRCLE_ID":"388638734242807808","CONTENT":"振华大宝贝儿","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","commentCount":0},{"dotAgreeCount":0,"SHOWIMAGES":"http://47.104.16.215:8088/circleimgs/6975e3b2d67f4b41a80cc7ef55319b9f.jpg,http://47.104.16.215:8088/circleimgs/0e004eae1f96452b8a7aa2108311cac6.jpg","PUBLISHTIME":"2017-12-08 10:41:10","CIRCLE_ID":"388641148853288960","CONTENT":"振华大宝贝儿","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","commentCount":0},{"dotAgreeCount":0,"PUBLISHTIME":"2017-12-08 12:05:02","CIRCLE_ID":"388662254872035328","CONTENT":"振华大宝贝儿","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","commentCount":0},{"dotAgreeCount":0,"SHOWIMAGES":"http://47.104.16.215:8088/circleimgs/35eb17e91175494a855ef0ffe3ac1cfa.jpg,http://47.104.16.215:8088/circleimgs/897d9c1c4b9f4f37b8907e0e69abb5da.jpg,http://47.104.16.215:8088/circleimgs/64abbc028f96431397f3fb53cfc73886.jpg","PUBLISHTIME":"2017-12-08 12:06:44","CIRCLE_ID":"388662681109790720","CONTENT":"振华大宝贝儿","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","commentCount":0},{"dotAgreeCount":0,"SHOWIMAGES":"http://47.104.16.215:8088/circleimgs/6d7ca035b7234264b1b3949d80748eb4.jpg,http://47.104.16.215:8088/circleimgs/624b2d7b134345c6aa83b3f3488e0125.jpg,http://47.104.16.215:8088/circleimgs/34f86f8524264cdd9d99cb2af36f84be.jpg","PUBLISHTIME":"2017-12-08 12:07:03","CIRCLE_ID":"388662762147938304","CONTENT":"振华大宝贝儿","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","commentCount":0}]
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
         * dotAgreeCount : 1
         * SHOWIMAGES : http://47.104.16.215:8088/highsortimgs/luxcarshopimgs/baae579c7f8646fa9758266d4ce4cb1a.png
         * PUBLISHTIME : 2017-12-06 02:23:12
         * CIRCLE_ID : 387972249954549760
         * CONTENT : 我的发布1
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         * commentCount : 4
         */

        private int dotAgreeCount;
        private String SHOWIMAGES;
        private String PUBLISHTIME;
        private String CIRCLE_ID;
        private String CONTENT;
        private String HONOURUSER_ID;
        private int commentCount;

        public int getDotAgreeCount() {
            return dotAgreeCount;
        }

        public void setDotAgreeCount(int dotAgreeCount) {
            this.dotAgreeCount = dotAgreeCount;
        }

        public String getSHOWIMAGES() {
            return SHOWIMAGES;
        }

        public void setSHOWIMAGES(String SHOWIMAGES) {
            this.SHOWIMAGES = SHOWIMAGES;
        }

        public String getPUBLISHTIME() {
            return PUBLISHTIME;
        }

        public void setPUBLISHTIME(String PUBLISHTIME) {
            this.PUBLISHTIME = PUBLISHTIME;
        }

        public String getCIRCLE_ID() {
            return CIRCLE_ID;
        }

        public void setCIRCLE_ID(String CIRCLE_ID) {
            this.CIRCLE_ID = CIRCLE_ID;
        }

        public String getCONTENT() {
            return CONTENT;
        }

        public void setCONTENT(String CONTENT) {
            this.CONTENT = CONTENT;
        }

        public String getHONOURUSER_ID() {
            return HONOURUSER_ID;
        }

        public void setHONOURUSER_ID(String HONOURUSER_ID) {
            this.HONOURUSER_ID = HONOURUSER_ID;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public static final int YES = 1;
        public static final int NO = 2;

        private int itemType;

        public void setItemType(int itemType) {
            this.itemType = itemType;
        }

        @Override
        public int getItemType() {
            return itemType;
        }
    }
}

