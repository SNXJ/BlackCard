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
     * pd : [{"PORTRAIT":"http://47.104.16.215:8088/userportrait/469ea21902db4d77a21814b8778b50b8.jpeg","COMMENTNICKNAME":"死亡如风，长伴吾生","COMMENT_ID":"388331931869118464","REPLYHONOURUSER_ID":" ","COMCONTENT":"我去前面探探路","HONOURUSER_ID":"388279486010884096","REPLYNICKNAME":"死亡如风，长伴吾生","COMMENTTIME":"2017-12-07 02:12:27"},{"PORTRAIT":"http://47.104.16.215:8088/highsortimgs/luxcarshopimgs/d934b2801ca9418da971d6db25eea3e2.png","COMMENTNICKNAME":"长枪依在","COMMENT_ID":"388332181467955200","REPLYHONOURUSER_ID":" ","COMCONTENT":"先是寒芒一点，随后枪出如龙","HONOURUSER_ID":"388279486010884097","REPLYNICKNAME":"死亡如风，长伴吾生","COMMENTTIME":"2017-12-07 02:13:26"},{"PORTRAIT":"http://47.104.16.215:8088/userportrait/469ea21902db4d77a21814b8778b50b8.jpeg","COMMENTNICKNAME":"火男","COMMENT_ID":"388332190821253120","REPLYHONOURUSER_ID":" ","COMCONTENT":"胜利女神在微笑","HONOURUSER_ID":"388279486010884098","REPLYNICKNAME":"死亡如风，长伴吾生","COMMENTTIME":"2017-12-07 02:13:29"},{"PORTRAIT":"http://47.104.16.215:8088/highsortimgs/luxcarshopimgs/209951ade4614989b39f57adadfe9dd6.png","COMMENTNICKNAME":"想要再来一发吗","COMMENT_ID":"388332194206056448","REPLYHONOURUSER_ID":" ","COMCONTENT":"我用双手成就你的梦想","HONOURUSER_ID":"388279486010884099","REPLYNICKNAME":"死亡如风，长伴吾生","COMMENTTIME":"2017-12-07 02:13:29"},{"PORTRAIT":"http://47.104.16.215:8088/userportrait/8c954ce889814968be8c804a7fdecc50.jpg","COMMENTNICKNAME":"asd","COMMENT_ID":"388738362036453376","REPLYHONOURUSER_ID":" ","COMCONTENT":"我虽浪迹天涯，却未迷失本心","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","REPLYNICKNAME":"死亡如风，长伴吾生","COMMENTTIME":"2017-12-08 05:07:27"},{"PORTRAIT":"http://47.104.16.215:8088/userportrait/469ea21902db4d77a21814b8778b50b8.jpeg","COMMENTNICKNAME":"死亡如风，长伴吾生","COMMENT_ID":"389022232170463232","REPLYHONOURUSER_ID":"388279486010884097","COMCONTENT":"吾之初心，永世不忘","HONOURUSER_ID":"388331931869118464","REPLYNICKNAME":"长枪依在","COMMENTTIME":"2017-12-09 11:55"},{"PORTRAIT":"http://47.104.16.215:8088/userportrait/469ea21902db4d77a21814b8778b50b8.jpeg","COMMENTNICKNAME":"死亡如风，长伴吾生","COMMENT_ID":"389054333364207616","REPLYHONOURUSER_ID":"388279486010884098","COMCONTENT":"随风而行","HONOURUSER_ID":"388331931869118464","REPLYNICKNAME":"火男","COMMENTTIME":"2017-12-09 14:03"},{"PORTRAIT":"http://47.104.16.215:8088/userportrait/469ea21902db4d77a21814b8778b50b8.jpeg","COMMENTNICKNAME":"死亡如风，长伴吾生","COMMENT_ID":"389054340439998464","REPLYHONOURUSER_ID":"388279486010884099","COMCONTENT":"荣耀存于心，而非留于形","HONOURUSER_ID":"388331931869118464","REPLYNICKNAME":"想要再来一发吗","COMMENTTIME":"2017-12-09 14:05"},{"PORTRAIT":"http://47.104.16.215:8088/userportrait/469ea21902db4d77a21814b8778b50b8.jpeg","COMMENTNICKNAME":"死亡如风，长伴吾生","COMMENT_ID":"389800622959886347","REPLYHONOURUSER_ID":"388279486010884097","COMCONTENT":"吾之初心，永世不忘","HONOURUSER_ID":"388332181467955200","REPLYNICKNAME":"长枪依在","COMMENTTIME":"2017-12-09 11:55"},{"PORTRAIT":"http://47.104.16.215:8088/userportrait/469ea21902db4d77a21814b8778b50b8.jpeg","COMMENTNICKNAME":"死亡如风，长伴吾生","COMMENT_ID":"389800622959886348","REPLYHONOURUSER_ID":"388279486010884098","COMCONTENT":"随风而行","HONOURUSER_ID":"388332181467955200","REPLYNICKNAME":"火男","COMMENTTIME":"2017-12-09 14:03"},{"PORTRAIT":"http://47.104.16.215:8088/userportrait/469ea21902db4d77a21814b8778b50b8.jpeg","COMMENTNICKNAME":"死亡如风，长伴吾生","COMMENT_ID":"389800622959886349","REPLYHONOURUSER_ID":"388279486010884099","COMCONTENT":"荣耀存于心，而非留于形","HONOURUSER_ID":"388332181467955200","REPLYNICKNAME":"想要再来一发吗","COMMENTTIME":"2017-12-09 14:05"}]
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
         * PORTRAIT : http://47.104.16.215:8088/userportrait/469ea21902db4d77a21814b8778b50b8.jpeg
         * COMMENTNICKNAME : 死亡如风，长伴吾生
         * COMMENT_ID : 388331931869118464
         * REPLYHONOURUSER_ID :
         * COMCONTENT : 我去前面探探路
         * HONOURUSER_ID : 388279486010884096
         * REPLYNICKNAME : 死亡如风，长伴吾生
         * COMMENTTIME : 2017-12-07 02:12:27
         */

        private String PORTRAIT;
        private String COMMENTNICKNAME;
        private String COMMENT_ID;
        private String REPLYHONOURUSER_ID;
        private String COMCONTENT;
        private String HONOURUSER_ID;
        private String REPLYNICKNAME;
        private String COMMENTTIME;

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
