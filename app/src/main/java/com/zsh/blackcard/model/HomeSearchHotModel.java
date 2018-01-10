package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by ZCY on 2018/1/10.
 * 首页搜索热门搜索和推荐实体类
 */

public class HomeSearchHotModel {

    /**
     * result : 01
     * pd : [{"NAME":"酒店"},{"NAME":"美食"},{"NAME":"旅游"},{"NAME":"聚会"},{"NAME":"KTV"},{"NAME":"酒吧"},{"NAME":"品鉴"},{"NAME":"豪车"},{"NAME":"游艇"}]
     * showimgs : [{"SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sortbarimgs/sortbarshowimgs/d339ffbdaa404d5baf16a30b06f6ca16.png","PRICE":11,"SEARCH_ID":"385374599321223168","TYPE":"1003","NAME":"The Tiki Bungalow(顺义店)"},{"SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sortbarimgs/sortbarshowimgs/99fd5e8f94304938a374668652f781c3.png","PRICE":111,"SEARCH_ID":"385367746201780224","TYPE":"1003","NAME":"Janes and Hooch(双井店)"},{"SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sortfoodimgs/sortfoodshowimgs/e77331c8e8244b77a2068945c1023e8c.png","PRICE":20,"SEARCH_ID":"399892190437834752","TYPE":"1001","NAME":"港门粉"},{"SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sortfoodimgs/sortfoodshowimgs/dea8d0d2a6da4647bd425c023eda3b64.png","PRICE":284,"SEARCH_ID":"399890581393768448","TYPE":"1001","NAME":"小海豚海鲜餐厅"},{"SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sorthotelimgs/sorthotelshowimgs/40448f2e3a024d06bd869240927fe9ec.png","PRICE":344,"SEARCH_ID":"399887447267213312","TYPE":"1002","NAME":"梅诺卡度假酒店"},{"SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sorthotelimgs/sorthotelshowimgs/38ef1785007b46ea833b4f9603d31e28.png","PRICE":123,"SEARCH_ID":"385472115253444608","TYPE":"1002","NAME":"锦江之星(国贸店)"},{"SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sortktvimgs/sortktvshowimgs/c49e19f154c84ea38513667711e11ee8.png","PRICE":147,"SEARCH_ID":"2674579cf39f4bff8697801196f2e629","TYPE":"1004","NAME":"麦乐迪KTV(双井店)"},{"SHOWIMAGES":"http://47.104.16.215:8088/sortimgs/sortktvimgs/sortktvshowimgs/059c228217c144f0880910e6ce012f27.png","PRICE":1999,"SEARCH_ID":"387198218410131456","TYPE":"1004","NAME":"铭赫东方喜福汇夜总会"},{"SHOWIMAGES":"http://47.104.16.215:8088/highsortimgs/luxcarshopimgs/87ade343cca74d979230fe3fdeb6429a.png","PRICE":8888,"SEARCH_ID":"387609371183415296","TYPE":"1007","NAME":"宝马跑车一族租赁"},{"SHOWIMAGES":"http://47.104.16.215:8088/highsortimgs/luxcarshopimgs/d5c034a681834506b999ae62245d8b4f.png","PRICE":5888,"SEARCH_ID":"387608635162755072","TYPE":"1007","NAME":"椰林风汽车租赁"},{"SHOWIMAGES":"http://47.104.16.215:8088/highsortimgs/yachtshopimgs/99aa9ebaf9524acaa99dbc371fceee23.png","PRICE":5888,"SEARCH_ID":"387617474415165440","TYPE":"1006","NAME":"三亚鸿洲国际游艇会"},{"SHOWIMAGES":"http://47.104.16.215:8088/highsortimgs/yachtshopimgs/701e4c1f0a4e4f5a88e42ffb53e0b1ad.png","PRICE":4888,"SEARCH_ID":"387617939211157504","TYPE":"1006","NAME":"凤凰之星号游艇俱乐部"}]
     */

    private String result;
    private List<PdBean> pd;
    private List<ShowimgsBean> showimgs;

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

    public List<ShowimgsBean> getShowimgs() {
        return showimgs;
    }

    public void setShowimgs(List<ShowimgsBean> showimgs) {
        this.showimgs = showimgs;
    }

    public static class PdBean {
        /**
         * NAME : 酒店
         */

        private String NAME;

        public String getNAME() {
            return NAME;
        }

        public void setNAME(String NAME) {
            this.NAME = NAME;
        }
    }

    public static class ShowimgsBean {
        /**
         * SHOWIMAGES : http://47.104.16.215:8088/sortimgs/sortbarimgs/sortbarshowimgs/d339ffbdaa404d5baf16a30b06f6ca16.png
         * PRICE : 11.0
         * SEARCH_ID : 385374599321223168
         * TYPE : 1003
         * NAME : The Tiki Bungalow(顺义店)
         */

        private String SHOWIMAGES;
        private double PRICE;
        private String SEARCH_ID;
        private String TYPE;
        private String NAME;

        public String getSHOWIMAGES() {
            return SHOWIMAGES;
        }

        public void setSHOWIMAGES(String SHOWIMAGES) {
            this.SHOWIMAGES = SHOWIMAGES;
        }

        public double getPRICE() {
            return PRICE;
        }

        public void setPRICE(double PRICE) {
            this.PRICE = PRICE;
        }

        public String getSEARCH_ID() {
            return SEARCH_ID;
        }

        public void setSEARCH_ID(String SEARCH_ID) {
            this.SEARCH_ID = SEARCH_ID;
        }

        public String getTYPE() {
            return TYPE;
        }

        public void setTYPE(String TYPE) {
            this.TYPE = TYPE;
        }

        public String getNAME() {
            return NAME;
        }

        public void setNAME(String NAME) {
            this.NAME = NAME;
        }
    }
}
