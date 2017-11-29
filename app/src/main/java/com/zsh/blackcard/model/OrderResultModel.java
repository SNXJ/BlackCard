package com.zsh.blackcard.model;

/**
 * Name: OrderResultModel
 * Author: SNXJ
 * Date: 2017-11-27
 * Description:生成订单返回结果
 */
public class OrderResultModel {
    /**
     * result : 01
     * ORDERNUMBER : 171128091610088477d27c
     */

    private String result;
    private String ORDERNUMBER;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getORDERNUMBER() {
        return ORDERNUMBER;
    }

    public void setORDERNUMBER(String ORDERNUMBER) {
        this.ORDERNUMBER = ORDERNUMBER;
    }
}
