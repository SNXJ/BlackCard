package com.zsh.blackcard.untils;

import android.content.Context;

import java.util.Map;

public class ParamsMapUtils extends BaseParamsMapUtil {
    /**
     * 获取所有单子列表
     *
     * @param context
     * @param page    页码 默认每页十条数据
     * @return
     */
    public static Map<String, String> getBillList(Context context, String page) {
        Map<String, String> paramsMap = getParamsMap(context);
        paramsMap.put("page", page);
        return paramsMap;

    }

    public static Map<String, String> getBrand(Context context) {
        return getParamsMap(context);
    }
}
