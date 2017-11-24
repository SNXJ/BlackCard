package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/24.
 * 私人定制详情实体类
 */

public class ZgPersonalTailorDetailModel {

    /**
     * result : 01
     * pd : {"DOWNINTROCONTENT":"荣耀黑卡理型师是服装设计学院专业出身的学院派，同时也是身经百战的实践派，具有多年男装设计和造型搭配经验，为众多的比赛于节目提供搭配咨询建议。基于多年行业时尚经验和对您的了解，为您量身打造穿衣搭配方案，让您轻松享受好品味。","PERSONAL_ID":"26ce9cfadff44e9fa46aa7cab98a677c","PERSONALDET_ID":"a6a819ab93b745a9b6f4575bc82d9798","UPINTROTITLE":"您只要腾出时间享受生活","UPINTROCONTENT":"把款式、尺码、价位...交给专业理型师和大数据，您就可以轻松享受最合适您的服饰和世界级的品味。","DOWNINTROTITLE":"拥有专属于您的私人买手+形象顾问","PERSONALDETIMGS":["http://47.104.16.215:8088/personalimgs/perdetailimgs/f12e08c9ba5d4ac7be16d20e49e14691.png","http://47.104.16.215:8088/personalimgs/perdetailimgs/85985f5bb8cb41cbb237895dc5008468.png","http://47.104.16.215:8088/personalimgs/perdetailimgs/b035a16185cc410f87d11dcb7610fa8b.png"],"PERSONALDETINTRO":"荣耀黑卡私人订制让男人轻松享受好品味，专业理型师1对1终身服务，精品推荐，按季为您推荐精品服饰，每年4次，每次6件，让您轻松享受好品味。"}
     */

    private String result;
    private PdBean pd;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public PdBean getPd() {
        return pd;
    }

    public void setPd(PdBean pd) {
        this.pd = pd;
    }

    public static class PdBean {
        /**
         * DOWNINTROCONTENT : 荣耀黑卡理型师是服装设计学院专业出身的学院派，同时也是身经百战的实践派，具有多年男装设计和造型搭配经验，为众多的比赛于节目提供搭配咨询建议。基于多年行业时尚经验和对您的了解，为您量身打造穿衣搭配方案，让您轻松享受好品味。
         * PERSONAL_ID : 26ce9cfadff44e9fa46aa7cab98a677c
         * PERSONALDET_ID : a6a819ab93b745a9b6f4575bc82d9798
         * UPINTROTITLE : 您只要腾出时间享受生活
         * UPINTROCONTENT : 把款式、尺码、价位...交给专业理型师和大数据，您就可以轻松享受最合适您的服饰和世界级的品味。
         * DOWNINTROTITLE : 拥有专属于您的私人买手+形象顾问
         * PERSONALDETIMGS : ["http://47.104.16.215:8088/personalimgs/perdetailimgs/f12e08c9ba5d4ac7be16d20e49e14691.png","http://47.104.16.215:8088/personalimgs/perdetailimgs/85985f5bb8cb41cbb237895dc5008468.png","http://47.104.16.215:8088/personalimgs/perdetailimgs/b035a16185cc410f87d11dcb7610fa8b.png"]
         * PERSONALDETINTRO : 荣耀黑卡私人订制让男人轻松享受好品味，专业理型师1对1终身服务，精品推荐，按季为您推荐精品服饰，每年4次，每次6件，让您轻松享受好品味。
         */

        private String DOWNINTROCONTENT;
        private String PERSONAL_ID;
        private String PERSONALDET_ID;
        private String UPINTROTITLE;
        private String UPINTROCONTENT;
        private String DOWNINTROTITLE;
        private String PERSONALDETINTRO;
        private List<String> PERSONALDETIMGS;

        public String getDOWNINTROCONTENT() {
            return DOWNINTROCONTENT;
        }

        public void setDOWNINTROCONTENT(String DOWNINTROCONTENT) {
            this.DOWNINTROCONTENT = DOWNINTROCONTENT;
        }

        public String getPERSONAL_ID() {
            return PERSONAL_ID;
        }

        public void setPERSONAL_ID(String PERSONAL_ID) {
            this.PERSONAL_ID = PERSONAL_ID;
        }

        public String getPERSONALDET_ID() {
            return PERSONALDET_ID;
        }

        public void setPERSONALDET_ID(String PERSONALDET_ID) {
            this.PERSONALDET_ID = PERSONALDET_ID;
        }

        public String getUPINTROTITLE() {
            return UPINTROTITLE;
        }

        public void setUPINTROTITLE(String UPINTROTITLE) {
            this.UPINTROTITLE = UPINTROTITLE;
        }

        public String getUPINTROCONTENT() {
            return UPINTROCONTENT;
        }

        public void setUPINTROCONTENT(String UPINTROCONTENT) {
            this.UPINTROCONTENT = UPINTROCONTENT;
        }

        public String getDOWNINTROTITLE() {
            return DOWNINTROTITLE;
        }

        public void setDOWNINTROTITLE(String DOWNINTROTITLE) {
            this.DOWNINTROTITLE = DOWNINTROTITLE;
        }

        public String getPERSONALDETINTRO() {
            return PERSONALDETINTRO;
        }

        public void setPERSONALDETINTRO(String PERSONALDETINTRO) {
            this.PERSONALDETINTRO = PERSONALDETINTRO;
        }

        public List<String> getPERSONALDETIMGS() {
            return PERSONALDETIMGS;
        }

        public void setPERSONALDETIMGS(List<String> PERSONALDETIMGS) {
            this.PERSONALDETIMGS = PERSONALDETIMGS;
        }
    }
}
