package com.zsh.blackcard.listener;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.zsh.blackcard.untils.LogUtils;

/**
 * Name: MyLocationListener
 * Author: SNXJ
 * Date: 2017-12-02
 * Description:描述：
 */
public class MyLocationListener extends BDAbstractLocationListener {
    @Override
    public void onReceiveLocation(BDLocation location) {

        String addr = location.getAddrStr();    //获取详细地址信息
        String country = location.getCountry();    //获取国家
        String province = location.getProvince();    //获取省份
        String city = location.getCity();    //获取城市
        String district = location.getDistrict();    //获取区县
        String street = location.getStreet();    //获取街道信息
        LogUtils.i("+++22+", country + "++++++++++++++++++++" + city + "++++++++++++++" + street);
    }
}
