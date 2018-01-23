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
     * pd : [{"SHOWIMG":"http://47.104.16.215:8088/magazineimgs/7515cb9ba6d24191b2f5ac60fbced045.png","MAGAZINETYPE":"1","MAGAZINE_ID":"398896682013556736"},{"SHOWIMG":"http://47.104.16.215:8088/magazineimgs/7b87346fffdb4a788b9275576f553fe0.png","MAGAZINETYPE":"2","MAGAZINE_ID":"398899978195435520"},{"SHOWIMG":"http://47.104.16.215:8088/magazineimgs/06d2beaf75f74aa0951c055fed14bca3.png","MAGAZINETYPE":"3","MAGAZINE_ID":"398900270395817984"},{"SHOWIMG":"http://47.104.16.215:8088/magazineimgs/55b11f56310a48e68bb988cde2e006d0.png","MAGAZINETYPE":"3","MAGAZINE_ID":"398907579100561408"},{"SHOWIMG":"http://47.104.16.215:8088/magazineimgs/81164fee225a4183b129884586dbc6cd.png","MAGAZINETYPE":"3","MAGAZINE_ID":"398907654493175808"}]
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
         * SHOWIMG : http://47.104.16.215:8088/magazineimgs/7515cb9ba6d24191b2f5ac60fbced045.png
         * MAGAZINETYPE : 1
         * MAGAZINE_ID : 398896682013556736
         */

        private String SHOWIMG;
        private String MAGAZINETYPE;
        private String MAGAZINE_ID;

        public String getSHOWIMG() {
            return SHOWIMG;
        }

        public void setSHOWIMG(String SHOWIMG) {
            this.SHOWIMG = SHOWIMG;
        }

        public String getMAGAZINETYPE() {
            return MAGAZINETYPE;
        }

        public void setMAGAZINETYPE(String MAGAZINETYPE) {
            this.MAGAZINETYPE = MAGAZINETYPE;
        }

        public String getMAGAZINE_ID() {
            return MAGAZINE_ID;
        }

        public void setMAGAZINE_ID(String MAGAZINE_ID) {
            this.MAGAZINE_ID = MAGAZINE_ID;
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


