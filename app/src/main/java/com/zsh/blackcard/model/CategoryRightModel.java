package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/25.
 * 商品分类右边列表
 */

public class CategoryRightModel {

    /**
     * result : 01
     * pd : [{"BRAND_ID":"0e6184d78b374cfd8e97f9da5e34a835","BRANDNAME":"卡地亚","ICONIMGS":"http://47.104.16.215:8088/productimgs/brandiconimgs/a9611f14b49d499193126117b4a77315.png","BRANDICON_ID":"383388690547736576"},{"BRAND_ID":"0e6184d78b374cfd8e97f9da5e34a835","BRANDNAME":"宝玑","ICONIMGS":"http://47.104.16.215:8088/productimgs/brandiconimgs/88ec475b047443a4a78f268d8ba0017e.png","BRANDICON_ID":"383389237329788928"},{"BRAND_ID":"0e6184d78b374cfd8e97f9da5e34a835","BRANDNAME":"范思哲","ICONIMGS":"http://47.104.16.215:8088/productimgs/brandiconimgs/cf10319ed81a472ca9112f1a550c73a8.png","BRANDICON_ID":"383389518478180352"},{"BRAND_ID":"0e6184d78b374cfd8e97f9da5e34a835","BRANDNAME":"Marc Jacobs","ICONIMGS":"http://47.104.16.215:8088/productimgs/brandiconimgs/6dc436f403124921b885930d0d8cb700.png","BRANDICON_ID":"383389684346126336"},{"BRAND_ID":"0e6184d78b374cfd8e97f9da5e34a835","BRANDNAME":"赛琳时装","ICONIMGS":"http://47.104.16.215:8088/productimgs/brandiconimgs/e236e9c9c8e0414dae6ffa25c3cd5e88.png","BRANDICON_ID":"383389885379117056"},{"BRAND_ID":"0e6184d78b374cfd8e97f9da5e34a835","BRANDNAME":"阿玛尼","ICONIMGS":"http://47.104.16.215:8088/productimgs/brandiconimgs/60c693bde46c4ddb90e988a896fe9d85.png","BRANDICON_ID":"383389941339521024"},{"BRAND_ID":"0e6184d78b374cfd8e97f9da5e34a835","BRANDNAME":"MiuMiu","ICONIMGS":"http://47.104.16.215:8088/productimgs/brandiconimgs/8ff248f52f25412ea1790c549e8a7d8f.png","BRANDICON_ID":"383390013385080832"},{"BRAND_ID":"0e6184d78b374cfd8e97f9da5e34a835","BRANDNAME":"普拉达","ICONIMGS":"http://47.104.16.215:8088/productimgs/brandiconimgs/15338689c07a4ea3a89648bf4480cc12.png","BRANDICON_ID":"383390068275937280"},{"BRAND_ID":"0e6184d78b374cfd8e97f9da5e34a835","BRANDNAME":"芬迪","ICONIMGS":"http://47.104.16.215:8088/productimgs/brandiconimgs/b7dcc9e48c414eb389ceb4e8e0d0d701.png","BRANDICON_ID":"383390114983706624"},{"BRAND_ID":"0e6184d78b374cfd8e97f9da5e34a835","BRANDNAME":"迪奥","ICONIMGS":"http://47.104.16.215:8088/productimgs/brandiconimgs/7fa2f23732cd4610b8d05ec7b19f12f3.png","BRANDICON_ID":"383390169580961792"},{"BRAND_ID":"0e6184d78b374cfd8e97f9da5e34a835","BRANDNAME":"托德斯","ICONIMGS":"http://47.104.16.215:8088/productimgs/brandiconimgs/c84e012d0bca473e908567697bac746c.png","BRANDICON_ID":"383390224438263808"},{"BRAND_ID":"0e6184d78b374cfd8e97f9da5e34a835","BRANDNAME":"欧米伽","ICONIMGS":"http://47.104.16.215:8088/productimgs/brandiconimgs/cd7421ecfbdc4baea968e599b83c6948.png","BRANDICON_ID":"383390272324632576"},{"BRAND_ID":"0e6184d78b374cfd8e97f9da5e34a835","BRANDNAME":"路易威登","ICONIMGS":"http://47.104.16.215:8088/productimgs/brandiconimgs/593093ce33a042b2aceb4bfe6e19e9a3.png","BRANDICON_ID":"383390340930863104"},{"BRAND_ID":"0e6184d78b374cfd8e97f9da5e34a835","BRANDNAME":"香奈儿","ICONIMGS":"http://47.104.16.215:8088/productimgs/brandiconimgs/cd79e397e740477cab46ef87f2eae42b.png","BRANDICON_ID":"383391098665435136"},{"BRAND_ID":"0e6184d78b374cfd8e97f9da5e34a835","BRANDNAME":"施华洛世奇水晶","ICONIMGS":"http://47.104.16.215:8088/productimgs/brandiconimgs/879ca1e48f9349ef822c82723edcc38b.png","BRANDICON_ID":"383391502157479936"},{"BRAND_ID":"0e6184d78b374cfd8e97f9da5e34a835","BRANDNAME":"劳力士","ICONIMGS":"http://47.104.16.215:8088/productimgs/brandiconimgs/f2e6411afe1c4b75968c5fe209b50c65.png","BRANDICON_ID":"383391571384467456"},{"BRAND_ID":"0e6184d78b374cfd8e97f9da5e34a835","BRANDNAME":"天梭腕表","ICONIMGS":"http://47.104.16.215:8088/productimgs/brandiconimgs/345211d0ea5d4f2198931caee8ad5e26.png","BRANDICON_ID":"383391618746548224"},{"BRAND_ID":"0e6184d78b374cfd8e97f9da5e34a835","BRANDNAME":"古驰","ICONIMGS":"http://47.104.16.215:8088/productimgs/brandiconimgs/ef52a04792cd4b05a74f3aa54654949d.png","BRANDICON_ID":"383391662413447168"},{"BRAND_ID":"0e6184d78b374cfd8e97f9da5e34a835","BRANDNAME":"瑞士梅花腕表","ICONIMGS":"http://47.104.16.215:8088/productimgs/brandiconimgs/0111b084ebfc4e238b4fe25c88830b08.png","BRANDICON_ID":"383391783746273280"},{"BRAND_ID":"0e6184d78b374cfd8e97f9da5e34a835","BRANDNAME":"瑞士百年灵","ICONIMGS":"http://47.104.16.215:8088/productimgs/brandiconimgs/4ca41eeeac914c59b112c24498510c9b.png","BRANDICON_ID":"383391843301195776"},{"BRAND_ID":"0e6184d78b374cfd8e97f9da5e34a835","BRANDNAME":"西铁城腕表","ICONIMGS":"http://47.104.16.215:8088/productimgs/brandiconimgs/e4e0e40b160d4f89b0bb849dda0599c9.png","BRANDICON_ID":"383391896187174912"}]
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
         * BRANDNAME : 卡地亚
         * ICONIMGS : http://47.104.16.215:8088/productimgs/brandiconimgs/a9611f14b49d499193126117b4a77315.png
         * BRANDICON_ID : 383388690547736576
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
    }
}
