package com.zsh.blackcard.model;

import java.util.List;

/**
 * 荣耀杂志详情实体类
 * Created by ZCY on 2018/1/6.
 */

public class HomeGloryMagazineDetailModel {

    /**
     * result : 01
     * magazine : {"SHOWIMG":"http://47.104.16.215:8088/magazineimgs/7515cb9ba6d24191b2f5ac60fbced045.png","MAGAZINETYPE":"1","MAGAZINE_ID":"398896682013556736","BACKGROUNDIMG":"http://47.104.16.215:8088/magazineimgs/94c89cb7f22f4b91a4cac94eecfda3d5.png","TITLE":"《时尚芭莎》：精辟的流行趋势报道","INTRODUCE":"《时尚芭莎》是一本服务于中国精英女性阶层的时尚杂志，传播来自时装、美和女性力量。她不仅提供新的时尚资讯；精辟的流行趋势报道；受关注的任务专访和女性话题"}
     * list : [{"SHOWIMG":"http://47.104.16.215:8088/magazineimgs/7515cb9ba6d24191b2f5ac60fbced045.png","MAGAZINE_ID":"398896682013556736"},{"SHOWIMG":"http://47.104.16.215:8088/magazineimgs/e8986f45daec4e5181369d4687bef4ca.png","MAGAZINE_ID":"398908272767139840"},{"SHOWIMG":"http://47.104.16.215:8088/magazineimgs/3f7274ba37c64633a045f22dd426f0cb.png","MAGAZINE_ID":"398908327200817152"},{"SHOWIMG":"http://47.104.16.215:8088/magazineimgs/95693aa40b254c5daf409e48f981bece.png","MAGAZINE_ID":"398908167578189824"}]
     */

    private String result;
    private MagazineBean magazine;
    private List<ListBean> list;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public MagazineBean getMagazine() {
        return magazine;
    }

    public void setMagazine(MagazineBean magazine) {
        this.magazine = magazine;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class MagazineBean {
        /**
         * SHOWIMG : http://47.104.16.215:8088/magazineimgs/7515cb9ba6d24191b2f5ac60fbced045.png
         * MAGAZINETYPE : 1
         * MAGAZINE_ID : 398896682013556736
         * BACKGROUNDIMG : http://47.104.16.215:8088/magazineimgs/94c89cb7f22f4b91a4cac94eecfda3d5.png
         * TITLE : 《时尚芭莎》：精辟的流行趋势报道
         * INTRODUCE : 《时尚芭莎》是一本服务于中国精英女性阶层的时尚杂志，传播来自时装、美和女性力量。她不仅提供新的时尚资讯；精辟的流行趋势报道；受关注的任务专访和女性话题
         */

        private String SHOWIMG;
        private String MAGAZINETYPE;
        private String MAGAZINE_ID;
        private String BACKGROUNDIMG;
        private String TITLE;
        private String INTRODUCE;

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

        public String getBACKGROUNDIMG() {
            return BACKGROUNDIMG;
        }

        public void setBACKGROUNDIMG(String BACKGROUNDIMG) {
            this.BACKGROUNDIMG = BACKGROUNDIMG;
        }

        public String getTITLE() {
            return TITLE;
        }

        public void setTITLE(String TITLE) {
            this.TITLE = TITLE;
        }

        public String getINTRODUCE() {
            return INTRODUCE;
        }

        public void setINTRODUCE(String INTRODUCE) {
            this.INTRODUCE = INTRODUCE;
        }
    }

    public static class ListBean {
        /**
         * SHOWIMG : http://47.104.16.215:8088/magazineimgs/7515cb9ba6d24191b2f5ac60fbced045.png
         * MAGAZINE_ID : 398896682013556736
         */

        private String SHOWIMG;
        private String MAGAZINE_ID;

        public String getSHOWIMG() {
            return SHOWIMG;
        }

        public void setSHOWIMG(String SHOWIMG) {
            this.SHOWIMG = SHOWIMG;
        }

        public String getMAGAZINE_ID() {
            return MAGAZINE_ID;
        }

        public void setMAGAZINE_ID(String MAGAZINE_ID) {
            this.MAGAZINE_ID = MAGAZINE_ID;
        }
    }
}
