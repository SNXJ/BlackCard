package com.zsh.blackcard.model;

import java.io.Serializable;
import java.util.List;

/**
 * Name: FoodDetailsListModel
 * Author: SNXJ
 * Date: 2017-11-29
 * Description:描述：
 */
public class FoodDetailsMoreListModel {

    /**
     * result : 01
     * pd : [{"HOTELDETROOMNUM":"22","HOTELDETNAME":"豪华双人间","HOTELDETPERNUM":"2","HOTELDETROOMSIZE":"85","HOTELDETIMGS":"http://47.104.16.215:8088/\nsortimgs/sorthotelimgs/hoteldetimgs/3a49133c3b0e494d85d9729f1ed312ab.jpg,http://47.104.16.215:8088/\nsortimgs/sorthotelimgs/hoteldetimgs/7a2e6ea78d974de5886ac3f2a750593f.png","SORTHOTEL_ID":"53443f6feed94a1bbce17a65e63dae28","HOTELDETBATHROOM":"1","HOTELDETAIL_ID":"53b4f3c1dfa84ee697469ce762c400c5","HOTELDETBREAKFAST":1,"HOTELDETBEDTYPE":"单人床1.35*2  2张","HOTELDETPRICE":222},{"HOTELDETROOMNUM":"11","HOTELDETNAME":"豪华单人间","HOTELDETPERNUM":"1","HOTELDETROOMSIZE":"60","HOTELDETIMGS":"http://47.104.16.215:8088/\nsortimgs/sorthotelimgs/hoteldetimgs/7ed2b4aeb1794fa08ebd4cceef20ccbb.jpg","SORTHOTEL_ID":"53443f6feed94a1bbce17a65e63dae28","HOTELDETBATHROOM":"1","HOTELDETAIL_ID":"eb13492baadf4766a7d48fb8193a13a6","HOTELDETBREAKFAST":1,"HOTELDETBEDTYPE":"大床 60㎡ 1.8m 1张","HOTELDETPRICE":111}]
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

    public static class PdBean implements Serializable {
        /**
         * HOTELDETROOMNUM : 22
         * HOTELDETNAME : 豪华双人间
         * HOTELDETPERNUM : 2
         * HOTELDETROOMSIZE : 85
         * HOTELDETIMGS : http://47.104.16.215:8088/
         * sortimgs/sorthotelimgs/hoteldetimgs/3a49133c3b0e494d85d9729f1ed312ab.jpg,http://47.104.16.215:8088/
         * sortimgs/sorthotelimgs/hoteldetimgs/7a2e6ea78d974de5886ac3f2a750593f.png
         * SORTHOTEL_ID : 53443f6feed94a1bbce17a65e63dae28
         * HOTELDETBATHROOM : 1
         * HOTELDETAIL_ID : 53b4f3c1dfa84ee697469ce762c400c5
         * HOTELDETBREAKFAST : 1
         * HOTELDETBEDTYPE : 单人床1.35*2  2张
         * HOTELDETPRICE : 222
         */

        private String HOTELDETROOMNUM;
        private String HOTELDETNAME;
        private String HOTELDETPERNUM;
        private String HOTELDETROOMSIZE;
        private String HOTELDETIMGS;
        private String SORTHOTEL_ID;
        private String HOTELDETBATHROOM;
        private String HOTELDETAIL_ID;
        private int HOTELDETBREAKFAST;
        private String HOTELDETBEDTYPE;
        private int HOTELDETPRICE;

        private String myDES;

        public String getMyDES() {
            return myDES;
        }

        public void setMyDES(String myDES) {
            this.myDES = myDES;
        }

        public String getHOTELDETROOMNUM() {
            return HOTELDETROOMNUM;
        }

        public void setHOTELDETROOMNUM(String HOTELDETROOMNUM) {
            this.HOTELDETROOMNUM = HOTELDETROOMNUM;
        }

        public String getHOTELDETNAME() {
            return HOTELDETNAME;
        }

        public void setHOTELDETNAME(String HOTELDETNAME) {
            this.HOTELDETNAME = HOTELDETNAME;
        }

        public String getHOTELDETPERNUM() {
            return HOTELDETPERNUM;
        }

        public void setHOTELDETPERNUM(String HOTELDETPERNUM) {
            this.HOTELDETPERNUM = HOTELDETPERNUM;
        }

        public String getHOTELDETROOMSIZE() {
            return HOTELDETROOMSIZE;
        }

        public void setHOTELDETROOMSIZE(String HOTELDETROOMSIZE) {
            this.HOTELDETROOMSIZE = HOTELDETROOMSIZE;
        }

        public String getHOTELDETIMGS() {
            return HOTELDETIMGS;
        }

        public void setHOTELDETIMGS(String HOTELDETIMGS) {
            this.HOTELDETIMGS = HOTELDETIMGS;
        }

        public String getSORTHOTEL_ID() {
            return SORTHOTEL_ID;
        }

        public void setSORTHOTEL_ID(String SORTHOTEL_ID) {
            this.SORTHOTEL_ID = SORTHOTEL_ID;
        }

        public String getHOTELDETBATHROOM() {
            return HOTELDETBATHROOM;
        }

        public void setHOTELDETBATHROOM(String HOTELDETBATHROOM) {
            this.HOTELDETBATHROOM = HOTELDETBATHROOM;
        }

        public String getHOTELDETAIL_ID() {
            return HOTELDETAIL_ID;
        }

        public void setHOTELDETAIL_ID(String HOTELDETAIL_ID) {
            this.HOTELDETAIL_ID = HOTELDETAIL_ID;
        }

        public int getHOTELDETBREAKFAST() {
            return HOTELDETBREAKFAST;
        }

        public void setHOTELDETBREAKFAST(int HOTELDETBREAKFAST) {
            this.HOTELDETBREAKFAST = HOTELDETBREAKFAST;
        }

        public String getHOTELDETBEDTYPE() {
            return HOTELDETBEDTYPE;
        }

        public void setHOTELDETBEDTYPE(String HOTELDETBEDTYPE) {
            this.HOTELDETBEDTYPE = HOTELDETBEDTYPE;
        }

        public int getHOTELDETPRICE() {
            return HOTELDETPRICE;
        }

        public void setHOTELDETPRICE(int HOTELDETPRICE) {
            this.HOTELDETPRICE = HOTELDETPRICE;
        }
    }
}
