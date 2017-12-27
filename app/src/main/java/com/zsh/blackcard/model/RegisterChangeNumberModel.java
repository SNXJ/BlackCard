package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/12/15.
 * 注册界面自选号码实体类
 */

public class RegisterChangeNumberModel {

    /**
     * result : 01
     * pd : [{"CARDPRICE":46,"CARDNUM":"14442446","CARDNUM_ID":"390913482385522688"},{"CARDPRICE":12,"CARDNUM":"14659723","CARDNUM_ID":"390913632839401472"},{"CARDPRICE":50,"CARDNUM":"13242853","CARDNUM_ID":"390913764209197056"},{"CARDPRICE":99,"CARDNUM":"12332112","CARDNUM_ID":"390913996535889920"},{"CARDPRICE":45,"CARDNUM":"16542465","CARDNUM_ID":"390913413234032640"},{"CARDPRICE":46,"CARDNUM":"17893564","CARDNUM_ID":"390913698169880576"},{"CARDPRICE":60,"CARDNUM":"13684982","CARDNUM_ID":"390913855137513472"},{"CARDPRICE":44,"CARDNUM":"19872987","CARDNUM_ID":"390913360687792128"}]
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
         * CARDPRICE : 46
         * CARDNUM : 14442446
         * CARDNUM_ID : 390913482385522688
         */

        private double CARDPRICE;
        private String CARDNUM;
        private String CARDNUM_ID;

        public double getCARDPRICE() {
            return CARDPRICE;
        }

        public void setCARDPRICE(double CARDPRICE) {
            this.CARDPRICE = CARDPRICE;
        }

        public String getCARDNUM() {
            return CARDNUM;
        }

        public void setCARDNUM(String CARDNUM) {
            this.CARDNUM = CARDNUM;
        }

        public String getCARDNUM_ID() {
            return CARDNUM_ID;
        }

        public void setCARDNUM_ID(String CARDNUM_ID) {
            this.CARDNUM_ID = CARDNUM_ID;
        }
    }
}
