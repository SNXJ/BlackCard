package com.zsh.blackcard.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/21.
 * 荣耀杂志实体类
 */

public class HomeGloryMagazineModel {
    /**
     * result : 01
     * pd : [{"BRAND_ID":"195f038a5e984ef18ea53d142586cc66","BRANDNAME":"Lines Review","ICONIMGS":"http://47.104.16.215:8088/productimgs/brandiconimgs/ad3a4ee07eea413abe85b7dec9295d87.png","BRANDICON_ID":"385374723871080448"},{"BRAND_ID":"195f038a5e984ef18ea53d142586cc66","BRANDNAME":"名汇FAMOUS","ICONIMGS":"http://47.104.16.215:8088/productimgs/brandiconimgs/406c49ee33a64988b0043d905e4a7567.png","BRANDICON_ID":"385374479468986368"},{"BRAND_ID":"195f038a5e984ef18ea53d142586cc66","BRANDNAME":"The New Criterion","ICONIMGS":"http://47.104.16.215:8088/productimgs/brandiconimgs/c9e7eea787714ea48f58fd1613439d88.png","BRANDICON_ID":"386097751957438464"},{"BRAND_ID":"195f038a5e984ef18ea53d142586cc66","BRANDNAME":"FHM男人帮","ICONIMGS":"http://47.104.16.215:8088/productimgs/brandiconimgs/2bbd1ae65f6a46af939900882f0fb801.png","BRANDICON_ID":"386097854562697216"},{"BRAND_ID":"195f038a5e984ef18ea53d142586cc66","BRANDNAME":"Cosmopolitan","ICONIMGS":"http://47.104.16.215:8088/productimgs/brandiconimgs/e0e9a77b63d44a0ea7e26d330b633380.png","BRANDICON_ID":"385374622742216704"}]
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
         * BRAND_ID : 195f038a5e984ef18ea53d142586cc66
         * BRANDNAME : Lines Review
         * ICONIMGS : http://47.104.16.215:8088/productimgs/brandiconimgs/ad3a4ee07eea413abe85b7dec9295d87.png
         * BRANDICON_ID : 385374723871080448
         */

        private String BRAND_ID;
        private String BRANDNAME;
        private String ICONIMGS;
        private String BRANDICON_ID;

        public String getBRAND_ID() {
            return BRAND_ID;
        }

        public void setBRAND_ID(String BRAND_ID) {
            this.BRAND_ID = BRAND_ID;
        }

        public String getBRANDNAME() {
            return BRANDNAME;
        }

        public void setBRANDNAME(String BRANDNAME) {
            this.BRANDNAME = BRANDNAME;
        }

        public String getICONIMGS() {
            return ICONIMGS;
        }

        public void setICONIMGS(String ICONIMGS) {
            this.ICONIMGS = ICONIMGS;
        }

        public String getBRANDICON_ID() {
            return BRANDICON_ID;
        }

        public void setBRANDICON_ID(String BRANDICON_ID) {
            this.BRANDICON_ID = BRANDICON_ID;
        }

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
    }
}
