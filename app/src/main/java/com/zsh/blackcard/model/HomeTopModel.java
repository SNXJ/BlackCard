package com.zsh.blackcard.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/21.
 * 此类为首页实体类
 */

public class HomeTopModel {

    /**
     * result : 01
     * pd : [{"IMAGES":"http://47.104.16.215:8088/\nsortimgs/sorthotelimgs/hoteldetimgs/7ed2b4aeb1794fa08ebd4cceef20ccbb.jpg","SEQUENCE":1,"RECOMMEND_ID":"b610b1d557de48af84560734395f3fe6","SHOPNAME":"必胜客"},{"IMAGES":"http://47.104.16.215:8088/\nsortimgs/sorthotelimgs/hoteldetimgs/7ed2b4aeb1794fa08ebd4cceef20ccbb.jpg","SEQUENCE":2,"RECOMMEND_ID":"9ba3c44bbf534c46aa056e144a47e2e0","SHOPNAME":"麦当劳"},{"IMAGES":"http://47.104.16.215:8088/\nsortimgs/sorthotelimgs/hoteldetimgs/7ed2b4aeb1794fa08ebd4cceef20ccbb.jpg","SEQUENCE":3,"RECOMMEND_ID":"b48c442818bc4621a920b69167688bd3","SHOPNAME":"肯德基"}]
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

        public static final int LEFT = 1;
        public static final int CENTER = 2;
        public static final int RIGHT = 3;

        private int itemType;

        public void setItemType(int itemType) {
            this.itemType = itemType;
        }

        @Override
        public int getItemType() {
            return itemType;
        }

        /**
         * IMAGES : http://47.104.16.215:8088/
         * sortimgs/sorthotelimgs/hoteldetimgs/7ed2b4aeb1794fa08ebd4cceef20ccbb.jpg
         * SEQUENCE : 1
         * RECOMMEND_ID : b610b1d557de48af84560734395f3fe6
         * SHOPNAME : 必胜客
         */
        private String SHOPTYPE;

        public String getSHOPTYPE() {
            return SHOPTYPE;
        }

        public void setSHOPTYPE(String SHOPTYPE) {
            this.SHOPTYPE = SHOPTYPE;
        }

        public String getSORT_ID() {
            return SORT_ID;
        }

        public void setSORT_ID(String SORT_ID) {
            this.SORT_ID = SORT_ID;
        }

        private String SORT_ID;
        private String IMAGES;
        private int SEQUENCE;
        private String RECOMMEND_ID;
        private String SHOPNAME;

        public String getIMAGES() {
            return IMAGES;
        }

        public void setIMAGES(String IMAGES) {
            this.IMAGES = IMAGES;
        }

        public int getSEQUENCE() {
            return SEQUENCE;
        }

        public void setSEQUENCE(int SEQUENCE) {
            this.SEQUENCE = SEQUENCE;
        }

        public String getRECOMMEND_ID() {
            return RECOMMEND_ID;
        }

        public void setRECOMMEND_ID(String RECOMMEND_ID) {
            this.RECOMMEND_ID = RECOMMEND_ID;
        }

        public String getSHOPNAME() {
            return SHOPNAME;
        }

        public void setSHOPNAME(String SHOPNAME) {
            this.SHOPNAME = SHOPNAME;
        }
    }
}
