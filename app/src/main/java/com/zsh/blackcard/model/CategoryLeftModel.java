package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/25.
 * 商品分类左边列表
 */

public class CategoryLeftModel {

    /**
     * result : 01
     * pd : [{"BRAND_ID":"0e6184d78b374cfd8e97f9da5e34a835","BRANDORDER":1,"BRANDBANE":"品牌推荐"},{"BRAND_ID":"175fb2fb785b4fdba9d9b9022d0575c4","BRANDORDER":2,"BRANDBANE":"名品名物"},{"BRAND_ID":"fc0c4cb21de64f83a0ae146958d42cfe","BRANDORDER":3,"BRANDBANE":"艺术画作"},{"BRAND_ID":"a8824559f11742d6acf0b07604a55337","BRANDORDER":4,"BRANDBANE":"美食美酒"},{"BRAND_ID":"a34d1f14a4b7481e8284ad4ba97a496b","BRANDORDER":5,"BRANDBANE":"轻奢包袋"},{"BRAND_ID":"1b4ed4c57ef04933b97e8def48fc423a","BRANDORDER":6,"BRANDBANE":"奢华手表"},{"BRAND_ID":"876c483370ab49adbec66938b265c90f","BRANDORDER":7,"BRANDBANE":"服装服饰"},{"BRAND_ID":"80e677b9cc4a40cf92fc427dd753f3da","BRANDORDER":8,"BRANDBANE":"男鞋女鞋"},{"BRAND_ID":"2df2c7e628b14341be1e2932cb377c82","BRANDORDER":9,"BRANDBANE":"珠宝首饰"},{"BRAND_ID":"5693216988d5457e8c3fb06fb057665b","BRANDORDER":10,"BRANDBANE":"配饰装饰"},{"BRAND_ID":"3b067bd936ea4578a6eabec6b2e80a50","BRANDORDER":11,"BRANDBANE":"美甲美妆"},{"BRAND_ID":"69f2077efb1d46d2aac7954d145286cc","BRANDORDER":12,"BRANDBANE":"运动户外"},{"BRAND_ID":"382834784809779200","BRANDORDER":13,"BRANDBANE":"家电数码"},{"BRAND_ID":"195f038a5e984ef18ea53d142586cc66","BRANDORDER":14,"BRANDBANE":"品牌杂志"},{"BRAND_ID":"7e1707e3d7af4aaea580c19ddc1adfef","BRANDORDER":15,"BRANDBANE":"母婴童装"},{"BRAND_ID":"668b21fc68a44080899cfd840107af22","BRANDORDER":16,"BRANDBANE":"飞机豪艇"},{"BRAND_ID":"c387f598e5c64a1ea275a7ca3e77518c","BRANDORDER":17,"BRANDBANE":"豪车世界"}]
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
         * BRAND_ID : 0e6184d78b374cfd8e97f9da5e34a835
         * BRANDORDER : 1
         * BRANDBANE : 品牌推荐
         */

        private String BRAND_ID;
        private int BRANDORDER;
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

        public String getBRANDBANE() {
            return BRANDBANE;
        }

        public void setBRANDBANE(String BRANDBANE) {
            this.BRANDBANE = BRANDBANE;
        }
    }
}
