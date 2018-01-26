package com.zsh.blackcard.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by ZCY on 2018/1/26.
 * 尊购首页列表实体类
 */

public class ZgHomeListModel {

    /**
     * result : 01
     * pd : [{"BRAND_ID":"a8824559f11742d6acf0b07604a55337","BRANDORDER":4,"SHOWIMG":"http://image.rongyaohk.com/brandimgs/e853dda3b0f044ed83da79821afd0456.png","BRANDBANE":"美酒专区"},{"BRAND_ID":"a34d1f14a4b7481e8284ad4ba97a496b","BRANDORDER":5,"SHOWIMG":"http://image.rongyaohk.com/brandimgs/7b9571b5bc96491d8de05f3daafc76a5.png","BRANDBANE":"包袋专区"},{"BRAND_ID":"1b4ed4c57ef04933b97e8def48fc423a","BRANDORDER":6,"SHOWIMG":"http://image.rongyaohk.com/brandimgs/174da455a93844d6a610d4769f8e5d9f.png","BRANDBANE":"手表专区"},{"BRAND_ID":"876c483370ab49adbec66938b265c90f","BRANDORDER":7,"SHOWIMG":"http://image.rongyaohk.com/brandimgs/167c736bd13641de8fa7331cd38d7825.png","BRANDBANE":"服饰专区"},{"BRAND_ID":"80e677b9cc4a40cf92fc427dd753f3da","BRANDORDER":8,"SHOWIMG":"http://image.rongyaohk.com/brandimgs/2a5e4a464a83479a8dc6e4967c8dd39a.png","BRANDBANE":"男鞋女鞋"},{"BRAND_ID":"2df2c7e628b14341be1e2932cb377c82","BRANDORDER":9,"SHOWIMG":"http://image.rongyaohk.com/brandimgs/86fce3d7bfb443e9a46492c1795f5b40.png","BRANDBANE":"首饰专区"},{"BRAND_ID":"5693216988d5457e8c3fb06fb057665b","BRANDORDER":10,"SHOWIMG":"http://image.rongyaohk.com/brandimgs/d245aa30751c4d738f23bdffd05275fe.png","BRANDBANE":"配饰装饰"},{"BRAND_ID":"3b067bd936ea4578a6eabec6b2e80a50","BRANDORDER":11,"BRANDBANE":"美妆专区"},{"BRAND_ID":"69f2077efb1d46d2aac7954d145286cc","BRANDORDER":12,"SHOWIMG":"http://image.rongyaohk.com/brandimgs/4b578221479b4cdc9e3bf033b75ff01c.png","BRANDBANE":"户外专区"},{"BRAND_ID":"382834784809779200","BRANDORDER":13,"SHOWIMG":"http://image.rongyaohk.com/brandimgs/706a7c3b372c4acea48161ae6cf80c7b.png","BRANDBANE":"家电数码"},{"BRAND_ID":"195f038a5e984ef18ea53d142586cc66","BRANDORDER":14,"BRANDBANE":"品牌杂志"},{"BRAND_ID":"7e1707e3d7af4aaea580c19ddc1adfef","BRANDORDER":15,"SHOWIMG":"http://image.rongyaohk.com/brandimgs/277d3cdb83534d9bbe0e95313c746189.png","BRANDBANE":"母婴童装"},{"BRAND_ID":"c387f598e5c64a1ea275a7ca3e77518c","BRANDORDER":17,"SHOWIMG":"http://image.rongyaohk.com/brandimgs/770aa7a143c24a809395d303dd4f3a9b.png","BRANDBANE":"豪车世界"}]
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
         * BRAND_ID : a8824559f11742d6acf0b07604a55337
         * BRANDORDER : 4
         * SHOWIMG : http://image.rongyaohk.com/brandimgs/e853dda3b0f044ed83da79821afd0456.png
         * BRANDBANE : 美酒专区
         */

        private String BRAND_ID;
        private int BRANDORDER;
        private String SHOWIMG;
        private String BRANDBANE;

        public String getBRAND_ID() {
            return BRAND_ID;
        }

        public void setBRAND_ID(String BRAND_ID) {
            this.BRAND_ID = BRAND_ID;
        }

        public int getBRANDORDER() {
            return BRANDORDER;
        }

        public void setBRANDORDER(int BRANDORDER) {
            this.BRANDORDER = BRANDORDER;
        }

        public String getSHOWIMG() {
            return SHOWIMG;
        }

        public void setSHOWIMG(String SHOWIMG) {
            this.SHOWIMG = SHOWIMG;
        }

        public String getBRANDBANE() {
            return BRANDBANE;
        }

        public void setBRANDBANE(String BRANDBANE) {
            this.BRANDBANE = BRANDBANE;
        }

        public static final int LEFT = 1;
        public static final int RIGHT = 2;

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
