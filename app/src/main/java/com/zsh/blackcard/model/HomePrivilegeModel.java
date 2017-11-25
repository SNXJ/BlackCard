package com.zsh.blackcard.model;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/24.
 * 首页中所有特权列表
 */

public class HomePrivilegeModel {

    /**
     * result : 01
     * pd : [{"PRIVILEGENAME":"美食","PRIVILEGE_ID":"383387957278539776","PRIVILEGEIMGS":"http://47.104.16.215:8088/homeimgs/privilegeimgs/3392f0c6294641eab7188fd4114da4ce.png"},{"PRIVILEGENAME":"酒店","PRIVILEGE_ID":"383557677113933824","PRIVILEGEIMGS":"http://47.104.16.215:8088/homeimgs/privilegeimgs/e54080e4a26c4652a7186433f77a7780.png"},{"PRIVILEGENAME":"火车票","PRIVILEGE_ID":"383557751072096256","PRIVILEGEIMGS":"http://47.104.16.215:8088/homeimgs/privilegeimgs/7f7c234f45ce4512a63f35d4e853d8bf.png"},{"PRIVILEGENAME":"飞机票","PRIVILEGE_ID":"383557820093562880","PRIVILEGEIMGS":"http://47.104.16.215:8088/homeimgs/privilegeimgs/268a292ba92f46cc9e358cb03b0f1da9.png"},{"PRIVILEGENAME":"马术","PRIVILEGE_ID":"383557868474859520","PRIVILEGEIMGS":"http://47.104.16.215:8088/homeimgs/privilegeimgs/ef10a23cb46448b998a5a1d70e8c4d59.png"},{"PRIVILEGENAME":"游艇","PRIVILEGE_ID":"383557942164586496","PRIVILEGEIMGS":"http://47.104.16.215:8088/homeimgs/privilegeimgs/cf4e58e36cf9417b97e20640c8b21723.png"},{"PRIVILEGENAME":"豪车","PRIVILEGE_ID":"383557992391376896","PRIVILEGEIMGS":"http://47.104.16.215:8088/homeimgs/privilegeimgs/f20749ae7ca04865a47f97a7684a8a04.png"},{"PRIVILEGENAME":"飞机","PRIVILEGE_ID":"383558270297571328","PRIVILEGEIMGS":"http://47.104.16.215:8088/homeimgs/privilegeimgs/9502f7021de5484ab0826ba348476574.png"},{"PRIVILEGENAME":"高尔夫汇","PRIVILEGE_ID":"383558332801089536","PRIVILEGEIMGS":"http://47.104.16.215:8088/homeimgs/privilegeimgs/df93969935df4f6a8437fc0226de49bc.png"},{"PRIVILEGENAME":"私人订制","PRIVILEGE_ID":"383558377935994880","PRIVILEGEIMGS":"http://47.104.16.215:8088/homeimgs/privilegeimgs/36544eb0a0974475b0e633531558a956.png"},{"PRIVILEGENAME":"品牌杂志","PRIVILEGE_ID":"383558448089923584","PRIVILEGEIMGS":"http://47.104.16.215:8088/homeimgs/privilegeimgs/c6bcd8d0007a4833886f0ea319971e03.png"},{"PRIVILEGENAME":"健康养生","PRIVILEGE_ID":"383558527584567296","PRIVILEGEIMGS":"http://47.104.16.215:8088/homeimgs/privilegeimgs/c04d758c1d7a42c484356c02f7ecf58f.png"},{"PRIVILEGENAME":"高端品鉴","PRIVILEGE_ID":"383558605036584960","PRIVILEGEIMGS":"http://47.104.16.215:8088/homeimgs/privilegeimgs/9a18954d0644435fa4b69fe04bb40740.png"},{"PRIVILEGENAME":"定制理财","PRIVILEGE_ID":"383558664083996672","PRIVILEGEIMGS":"http://47.104.16.215:8088/homeimgs/privilegeimgs/c0c9a35ed6994431a75e917ecb6abc14.png"}]
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
         * PRIVILEGENAME : 美食
         * PRIVILEGE_ID : 383387957278539776
         * PRIVILEGEIMGS : http://47.104.16.215:8088/homeimgs/privilegeimgs/3392f0c6294641eab7188fd4114da4ce.png
         */

        private String PRIVILEGENAME;
        private String PRIVILEGE_ID;
        private String PRIVILEGEIMGS;

        public String getPRIVILEGENAME() {
            return PRIVILEGENAME;
        }

        public void setPRIVILEGENAME(String PRIVILEGENAME) {
            this.PRIVILEGENAME = PRIVILEGENAME;
        }

        public String getPRIVILEGE_ID() {
            return PRIVILEGE_ID;
        }

        public void setPRIVILEGE_ID(String PRIVILEGE_ID) {
            this.PRIVILEGE_ID = PRIVILEGE_ID;
        }

        public String getPRIVILEGEIMGS() {
            return PRIVILEGEIMGS;
        }

        public void setPRIVILEGEIMGS(String PRIVILEGEIMGS) {
            this.PRIVILEGEIMGS = PRIVILEGEIMGS;
        }
    }
}
