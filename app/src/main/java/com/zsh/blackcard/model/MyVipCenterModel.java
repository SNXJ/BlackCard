package com.zsh.blackcard.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by kkkkk on 2017/12/18.
 * 我的界面，会员中心实体类
 */

public class MyVipCenterModel {

    /**
     * result : 01
     * memberInfo : {"PORTRAIT":"http://47.104.16.215:8088/userportrait/a15672e6001040bea600bd4a7f753949.JPEG","MEMBER_ID":"391266491061764096","NAME":"普通会员"}
     * list : [{"ENERGYVALUE":550,"WELFARE_ID":"391291656495693824","WELFARENAME":"升级礼包"},{"ENERGYVALUE":600,"WELFARE_ID":"391295382782476288","WELFARENAME":"黑咖币返利"},{"ENERGYVALUE":700,"WELFARE_ID":"391295451741028352","WELFARENAME":"管家服务"},{"ENERGYVALUE":800,"WELFARE_ID":"391295743928827904","WELFARENAME":"生日礼包"}]
     */

    private String result;
    private MemberInfoBean memberInfo;
    private List<ListBean> list;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public MemberInfoBean getMemberInfo() {
        return memberInfo;
    }

    public void setMemberInfo(MemberInfoBean memberInfo) {
        this.memberInfo = memberInfo;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class MemberInfoBean {
        /**
         * PORTRAIT : http://47.104.16.215:8088/userportrait/a15672e6001040bea600bd4a7f753949.JPEG
         * MEMBER_ID : 391266491061764096
         * NAME : 普通会员
         */

        private String PORTRAIT;
        private String MEMBER_ID;
        private String NAME;

        public String getPORTRAIT() {
            return PORTRAIT;
        }

        public void setPORTRAIT(String PORTRAIT) {
            this.PORTRAIT = PORTRAIT;
        }

        public String getMEMBER_ID() {
            return MEMBER_ID;
        }

        public void setMEMBER_ID(String MEMBER_ID) {
            this.MEMBER_ID = MEMBER_ID;
        }

        public String getNAME() {
            return NAME;
        }

        public void setNAME(String NAME) {
            this.NAME = NAME;
        }
    }

    public static class ListBean implements MultiItemEntity {
        /**
         * ENERGYVALUE : 550
         * WELFARE_ID : 391291656495693824
         * WELFARENAME : 升级礼包
         */

        private int ENERGYVALUE;
        private String WELFARE_ID;
        private String WELFARENAME;

        public int getENERGYVALUE() {
            return ENERGYVALUE;
        }

        public void setENERGYVALUE(int ENERGYVALUE) {
            this.ENERGYVALUE = ENERGYVALUE;
        }

        public String getWELFARE_ID() {
            return WELFARE_ID;
        }

        public void setWELFARE_ID(String WELFARE_ID) {
            this.WELFARE_ID = WELFARE_ID;
        }

        public String getWELFARENAME() {
            return WELFARENAME;
        }

        public void setWELFARENAME(String WELFARENAME) {
            this.WELFARENAME = WELFARENAME;
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
