package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/12/15.
 * 能量值曲线图实体类
 */

public class MyPowerImageModel {

    /**
     * result : 01
     * pd : [{"ENERGYVALUE":25,"months":"11","years":"201711","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","STATISTICS_ID":"391228510242340864"},{"ENERGYVALUE":500,"months":"10","years":"201710","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","STATISTICS_ID":"391241017094832190"},{"ENERGYVALUE":450,"months":"09","years":"201709","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","STATISTICS_ID":"391241017094832189"},{"ENERGYVALUE":300,"months":"08","years":"201708","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","STATISTICS_ID":"391241017094832188"},{"ENERGYVALUE":250,"months":"07","years":"201707","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","STATISTICS_ID":"391241017094832187"},{"ENERGYVALUE":100,"months":"06","years":"201706","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","STATISTICS_ID":"391241017094832186"},{"ENERGYVALUE":50,"months":"05","years":"201705","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","STATISTICS_ID":"391241017094832185"},{"ENERGYVALUE":150,"months":"04","years":"201704","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","STATISTICS_ID":"391241017094832184"},{"ENERGYVALUE":350,"months":"03","years":"201703","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","STATISTICS_ID":"391241017094832183"},{"ENERGYVALUE":400,"months":"02","years":"201702","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","STATISTICS_ID":"391241017094832182"},{"ENERGYVALUE":440,"months":"01","years":"201701","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","STATISTICS_ID":"391241017094832181"},{"ENERGYVALUE":300,"months":"12","years":"201612","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c","STATISTICS_ID":"391241017094832180"}]
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
         * ENERGYVALUE : 25
         * months : 11
         * years : 201711
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         * STATISTICS_ID : 391228510242340864
         */

        private int ENERGYVALUE;
        private String months;
        private String years;
        private String HONOURUSER_ID;
        private String STATISTICS_ID;

        public int getENERGYVALUE() {
            return ENERGYVALUE;
        }

        public void setENERGYVALUE(int ENERGYVALUE) {
            this.ENERGYVALUE = ENERGYVALUE;
        }

        public String getMonths() {
            return months;
        }

        public void setMonths(String months) {
            this.months = months;
        }

        public String getYears() {
            return years;
        }

        public void setYears(String years) {
            this.years = years;
        }

        public String getHONOURUSER_ID() {
            return HONOURUSER_ID;
        }

        public void setHONOURUSER_ID(String HONOURUSER_ID) {
            this.HONOURUSER_ID = HONOURUSER_ID;
        }

        public String getSTATISTICS_ID() {
            return STATISTICS_ID;
        }

        public void setSTATISTICS_ID(String STATISTICS_ID) {
            this.STATISTICS_ID = STATISTICS_ID;
        }
    }
}
