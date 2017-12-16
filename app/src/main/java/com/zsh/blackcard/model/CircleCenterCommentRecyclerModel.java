package com.zsh.blackcard.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by kkkkk on 2017/12/8.
 * 圈子中心评论列表实体类
 */


public class CircleCenterCommentRecyclerModel {

    /**
     * result : 01
     * pd : [{"dotAgreeCount":0,"lossAgreeCount":0,"PORTRAIT":"http://47.104.16.215:8088/userportrait/a15672e6001040bea600bd4a7f753949.JPEG","COMMENTNICKNAME":"asd","CIRCLE_ID":"390202130243256320","COMMENT_ID":"390459647061917696","REPLYHONOURUSER_ID":"","COMCONTENT":"GGG","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","REPLYNICKNAME":"死亡如风，长伴吾生","COMMENTTIME":"2017-12-13 11:07"},{"dotAgreeCount":0,"lossAgreeCount":0,"PORTRAIT":"http://47.104.16.215:8088/userportrait/a15672e6001040bea600bd4a7f753949.JPEG","COMMENTNICKNAME":"asd","CIRCLE_ID":"390202130243256320","COMMENT_ID":"390455101120053248","REPLYHONOURUSER_ID":"","COMCONTENT":"zhenhuaa","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","REPLYNICKNAME":"死亡如风，长伴吾生","COMMENTTIME":"2017-12-13 10:49"},{"dotAgreeCount":0,"lossAgreeCount":0,"PORTRAIT":"http://47.104.16.215:8088/userportrait/a15672e6001040bea600bd4a7f753949.JPEG","COMMENTNICKNAME":"asd","CIRCLE_ID":"390202130243256320","COMMENT_ID":"390454759447855104","REPLYHONOURUSER_ID":"","COMCONTENT":"ninin","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","REPLYNICKNAME":"死亡如风，长伴吾生","COMMENTTIME":"2017-12-13 10:47"},{"dotAgreeCount":1,"lossAgreeCount":0,"PORTRAIT":"http://47.104.16.215:8088/userportrait/a15672e6001040bea600bd4a7f753949.JPEG","COMMENTNICKNAME":"asd","CIRCLE_ID":"390202130243256320","COMMENT_ID":"390453473839153152","REPLYHONOURUSER_ID":"","COMCONTENT":"zzhh","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","REPLYNICKNAME":"死亡如风，长伴吾生","COMMENTTIME":"2017-12-13 10:42"},{"dotAgreeCount":0,"lossAgreeCount":0,"PORTRAIT":"http://47.104.16.215:8088/userportrait/a15672e6001040bea600bd4a7f753949.JPEG","COMMENTNICKNAME":"asd","CIRCLE_ID":"390202130243256320","COMMENT_ID":"390453506626027520","REPLYHONOURUSER_ID":"","COMCONTENT":"www","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","REPLYNICKNAME":"死亡如风，长伴吾生","COMMENTTIME":"2017-12-13 10:42"},{"dotAgreeCount":0,"lossAgreeCount":0,"PORTRAIT":"http://47.104.16.215:8088/userportrait/a15672e6001040bea600bd4a7f753949.JPEG","COMMENTNICKNAME":"asd","CIRCLE_ID":"390202130243256320","COMMENT_ID":"390450816823066624","REPLYHONOURUSER_ID":"","COMCONTENT":"fgbfgb","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","REPLYNICKNAME":"死亡如风，长伴吾生","COMMENTTIME":"2017-12-13 10:32"},{"dotAgreeCount":0,"lossAgreeCount":0,"PORTRAIT":"http://47.104.16.215:8088/userportrait/a15672e6001040bea600bd4a7f753949.JPEG","COMMENTNICKNAME":"asd","CIRCLE_ID":"390202130243256320","COMMENT_ID":"390450759793115136","REPLYHONOURUSER_ID":"","COMCONTENT":"sadsd","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","REPLYNICKNAME":"死亡如风，长伴吾生","COMMENTTIME":"2017-12-13 10:31"},{"dotAgreeCount":0,"lossAgreeCount":0,"PORTRAIT":"http://47.104.16.215:8088/userportrait/a15672e6001040bea600bd4a7f753949.JPEG","COMMENTNICKNAME":"asd","CIRCLE_ID":"390202130243256320","COMMENT_ID":"390450743716347904","REPLYHONOURUSER_ID":"","COMCONTENT":"asdasd123","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","REPLYNICKNAME":"死亡如风，长伴吾生","COMMENTTIME":"2017-12-13 10:31"}]
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

    public static class PdBean implements MultiItemEntity{
        /**
         * dotAgreeCount : 0
         * lossAgreeCount : 0
         * PORTRAIT : http://47.104.16.215:8088/userportrait/a15672e6001040bea600bd4a7f753949.JPEG
         * COMMENTNICKNAME : asd
         * CIRCLE_ID : 390202130243256320
         * COMMENT_ID : 390459647061917696
         * REPLYHONOURUSER_ID :
         * COMCONTENT : GGG
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         * REPLYNICKNAME : 死亡如风，长伴吾生
         * COMMENTTIME : 2017-12-13 11:07
         */

        private int dotAgreeCount;
        private int lossAgreeCount;
        private String PORTRAIT;
        private String COMMENTNICKNAME;
        private String CIRCLE_ID;
        private String COMMENT_ID;
        private String REPLYHONOURUSER_ID;
        private String COMCONTENT;
        private String HONOURUSER_ID;
        private String REPLYNICKNAME;
        private String COMMENTTIME;

        public int getDotAgreeCount() {
            return dotAgreeCount;
        }

        public void setDotAgreeCount(int dotAgreeCount) {
            this.dotAgreeCount = dotAgreeCount;
        }

        public int getLossAgreeCount() {
            return lossAgreeCount;
        }

        public void setLossAgreeCount(int lossAgreeCount) {
            this.lossAgreeCount = lossAgreeCount;
        }

        public String getPORTRAIT() {
            return PORTRAIT;
        }

        public void setPORTRAIT(String PORTRAIT) {
            this.PORTRAIT = PORTRAIT;
        }

        public String getCOMMENTNICKNAME() {
            return COMMENTNICKNAME;
        }

        public void setCOMMENTNICKNAME(String COMMENTNICKNAME) {
            this.COMMENTNICKNAME = COMMENTNICKNAME;
        }

        public String getCIRCLE_ID() {
            return CIRCLE_ID;
        }

        public void setCIRCLE_ID(String CIRCLE_ID) {
            this.CIRCLE_ID = CIRCLE_ID;
        }

        public String getCOMMENT_ID() {
            return COMMENT_ID;
        }

        public void setCOMMENT_ID(String COMMENT_ID) {
            this.COMMENT_ID = COMMENT_ID;
        }

        public String getREPLYHONOURUSER_ID() {
            return REPLYHONOURUSER_ID;
        }

        public void setREPLYHONOURUSER_ID(String REPLYHONOURUSER_ID) {
            this.REPLYHONOURUSER_ID = REPLYHONOURUSER_ID;
        }

        public String getCOMCONTENT() {
            return COMCONTENT;
        }

        public void setCOMCONTENT(String COMCONTENT) {
            this.COMCONTENT = COMCONTENT;
        }

        public String getHONOURUSER_ID() {
            return HONOURUSER_ID;
        }

        public void setHONOURUSER_ID(String HONOURUSER_ID) {
            this.HONOURUSER_ID = HONOURUSER_ID;
        }

        public String getREPLYNICKNAME() {
            return REPLYNICKNAME;
        }

        public void setREPLYNICKNAME(String REPLYNICKNAME) {
            this.REPLYNICKNAME = REPLYNICKNAME;
        }

        public String getCOMMENTTIME() {
            return COMMENTTIME;
        }

        public void setCOMMENTTIME(String COMMENTTIME) {
            this.COMMENTTIME = COMMENTTIME;
        }

        private int itemType;

        public static final int COMMENT = 1;
        public static final int REPLY = 2;

        public void setItemType(int itemType) {
            this.itemType = itemType;
        }

        @Override
        public int getItemType() {
            return itemType;
        }
    }
}
