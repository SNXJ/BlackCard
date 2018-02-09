package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/12/8.
 * 我的界面，圈子中心实体类
 */

public class MyCircleModel {


    /**
     * result : 01
     * pd : [{"AGREECOUNT":1,"COMMENTCOUNT":2,"SHOWIMAGES":["http://image.rongyaohk.com/circleimgs/10a18d323f8b4f3a8b45c015caa1e081.png"],"NICKNAME":"White55开","STATUS":"1","PUBLISHTIME":"2018-02-01 14:25","PORTRAIT":"http://image.rongyaohk.com/userportrait/3d0a82c5b88d4249aaee0d2a770b25e1.jpg","CIRCLE_ID":"408628858519027712","CONTENT":"A站融资失败，作为当局者，我该怎么办？","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"},{"AGREECOUNT":0,"COMMENTCOUNT":0,"SHOWIMAGES":["http://image.rongyaohk.com/highsortimgs/luxcarshopimgs/baae579c7f8646fa9758266d4ce4cb1a.png"],"NICKNAME":"White55开","STATUS":"0","PUBLISHTIME":"2018-01-29 02:24","PORTRAIT":"http://image.rongyaohk.com/userportrait/3d0a82c5b88d4249aaee0d2a770b25e1.jpg","CIRCLE_ID":"387972509233840128","CONTENT":"我的豪车店","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"},{"AGREECOUNT":0,"COMMENTCOUNT":0,"SHOWIMAGES":["http://image.rongyaohk.com/circleimgs/58ddc6c9dd7a496b97744c09fc35f80a.MOV"],"NICKNAME":"White55开","STATUS":"0","PUBLISHTIME":"2018-01-15 10:32","PORTRAIT":"http://image.rongyaohk.com/userportrait/3d0a82c5b88d4249aaee0d2a770b25e1.jpg","CIRCLE_ID":"402409601128988672","CONTENT":"聪明","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"},{"AGREECOUNT":0,"COMMENTCOUNT":0,"SHOWIMAGES":["http://image.rongyaohk.com/circleimgs/c45c6fd7633a4ce88d7cf2db09504c56.MOV"],"NICKNAME":"White55开","STATUS":"0","PUBLISHTIME":"2018-01-15 10:29","PORTRAIT":"http://image.rongyaohk.com/userportrait/3d0a82c5b88d4249aaee0d2a770b25e1.jpg","CIRCLE_ID":"402408959446614016","CONTENT":"con","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"},{"AGREECOUNT":0,"COMMENTCOUNT":0,"SHOWIMAGES":["http://image.rongyaohk.com/circleimgs/5c0fd23b7c5540c1b8265d2181c4c0ab.jpg"],"NICKNAME":"White55开","STATUS":"0","PUBLISHTIME":"2017-12-12 14:34","PORTRAIT":"http://image.rongyaohk.com/userportrait/3d0a82c5b88d4249aaee0d2a770b25e1.jpg","CIRCLE_ID":"390149359645229056","CONTENT":"要过年啦！","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"},{"AGREECOUNT":0,"COMMENTCOUNT":0,"SHOWIMAGES":["http://image.rongyaohk.com/circleimgs/91fa415aaaf246239856391e5d792523.JPG","http://image.rongyaohk.com/circleimgs/185351af6d1247c5ae6552d54a162caf.JPG"],"NICKNAME":"White55开","STATUS":"0","PUBLISHTIME":"2017-12-08 19:53","PORTRAIT":"http://image.rongyaohk.com/userportrait/3d0a82c5b88d4249aaee0d2a770b25e1.jpg","CIRCLE_ID":"388780070325452800","CONTENT":"The ","HONOURUSER_ID":"d6a3779de8204dfd9359403f54f7d27c"}]
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
         * AGREECOUNT : 1
         * COMMENTCOUNT : 2
         * SHOWIMAGES : ["http://image.rongyaohk.com/circleimgs/10a18d323f8b4f3a8b45c015caa1e081.png"]
         * NICKNAME : White55开
         * STATUS : 1
         * PUBLISHTIME : 2018-02-01 14:25
         * PORTRAIT : http://image.rongyaohk.com/userportrait/3d0a82c5b88d4249aaee0d2a770b25e1.jpg
         * CIRCLE_ID : 408628858519027712
         * CONTENT : A站融资失败，作为当局者，我该怎么办？
         * HONOURUSER_ID : d6a3779de8204dfd9359403f54f7d27c
         */

        private String AGREECOUNT;
        private String COMMENTCOUNT;
        private String NICKNAME;
        private String STATUS;
        private String PUBLISHTIME;
        private String PORTRAIT;
        private String CIRCLE_ID;
        private String CONTENT;
        private String HONOURUSER_ID;
        private List<String> SHOWIMAGES;

        public String getAGREECOUNT() {
            return AGREECOUNT;
        }

        public void setAGREECOUNT(String AGREECOUNT) {
            this.AGREECOUNT = AGREECOUNT;
        }

        public String getCOMMENTCOUNT() {
            return COMMENTCOUNT;
        }

        public void setCOMMENTCOUNT(String COMMENTCOUNT) {
            this.COMMENTCOUNT = COMMENTCOUNT;
        }

        public String getNICKNAME() {
            return NICKNAME;
        }

        public void setNICKNAME(String NICKNAME) {
            this.NICKNAME = NICKNAME;
        }

        public String getSTATUS() {
            return STATUS;
        }

        public void setSTATUS(String STATUS) {
            this.STATUS = STATUS;
        }

        public String getPUBLISHTIME() {
            return PUBLISHTIME;
        }

        public void setPUBLISHTIME(String PUBLISHTIME) {
            this.PUBLISHTIME = PUBLISHTIME;
        }

        public String getPORTRAIT() {
            return PORTRAIT;
        }

        public void setPORTRAIT(String PORTRAIT) {
            this.PORTRAIT = PORTRAIT;
        }

        public String getCIRCLE_ID() {
            return CIRCLE_ID;
        }

        public void setCIRCLE_ID(String CIRCLE_ID) {
            this.CIRCLE_ID = CIRCLE_ID;
        }

        public String getCONTENT() {
            return CONTENT;
        }

        public void setCONTENT(String CONTENT) {
            this.CONTENT = CONTENT;
        }

        public String getHONOURUSER_ID() {
            return HONOURUSER_ID;
        }

        public void setHONOURUSER_ID(String HONOURUSER_ID) {
            this.HONOURUSER_ID = HONOURUSER_ID;
        }

        public List<String> getSHOWIMAGES() {
            return SHOWIMAGES;
        }

        public void setSHOWIMAGES(List<String> SHOWIMAGES) {
            this.SHOWIMAGES = SHOWIMAGES;
        }
    }
}

