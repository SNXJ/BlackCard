package com.zsh.blackcard.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;

import com.zsh.blackcard.model.ChannelModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Activity工具类
 */
public class ActivityUtils {

    public static List<Activity> list = new ArrayList<>();

    /**
     * 添加Activity管理栈
     *
     * @param activity
     */
    public static void addActivity(Activity activity) {
        list.add(activity);
    }

    /**
     * 移除Activity管理栈
     *
     * @param activity
     */
    public static void removeActivity(Activity activity) {
        list.remove(activity);
    }

    /**
     * 清空所有Activity
     */
    public static void finishActivity() {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).finish();
        }
        list.clear();
    }

    /**
     * 启动一个Activity并关闭当前Activity
     *
     * @param activity 当前Activity
     * @param cls      要启动的Activity
     */
    public static void startActivityAndFinish(Activity activity, Class<?> cls) {
        Intent intent = new Intent(activity, cls);
        activity.startActivity(intent);
        activity.finish();
    }

    /**
     * 启动Activity
     *
     * @param activity 当前Activity
     * @param cls      要启动的Activity Class
     */
    public static void startActivity(Activity activity, Class<?> cls) {
        Intent intent = new Intent(activity, cls);
        activity.startActivity(intent);
    }

    /**
     * 启动Activity并传int数据 key:"data"
     *
     * @param activity 当前Activity
     * @param cls      要启动的Activity Class
     * @param data     int型数据
     */
    public static void startActivityForIntData(Activity activity, Class<?> cls,
                                               int data) {
        Intent intent = new Intent(activity, cls);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("data", data);
        activity.startActivity(intent);
    }

    /**
     * 启动Activity并传String数据 key:"data"
     *
     * @param activity 当前Activity
     * @param cls      要启动的Activity Class
     * @param data     String型数据
     */
    public static void startActivityForData(Activity activity, Class<?> cls,
                                            String data) {
        Intent intent = new Intent(activity, cls);
        intent.putExtra("data", data);
        activity.startActivity(intent);
    }

    /**
     * 传递集合
     *
     * @param activity
     * @param cls
     */
    public static void startActivityForDataList(Activity activity, Class<?> cls,
                                                List<ChannelModel> data) {
        Intent intent = new Intent(activity, cls);

        intent.putExtra("listData", (Serializable) data);

        activity.startActivity(intent);
    }

    /**
     * 传递集合
     *
     * @param activity
     * @param cls
     * @param data
     * @param title
     * @param search
     * @param searchId
     */
    public static void startActivityForDataList(Activity activity, Class<?> cls,
                                                String data, String title, List<String> search, List<String> searchId) {
        Intent intent = new Intent(activity, cls);
        intent.putExtra("data", data);
        intent.putExtra("title", title);
        intent.putExtra("listOne", (Serializable) search);
        intent.putExtra("listTwo", (Serializable) searchId);
        activity.startActivity(intent);
    }

    /**
     * 传递两个集合加一个标识
     *
     * @param activity
     * @param cls
     * @param data
     * @param titleId
     */
    public static void startActivityForDataLists(Activity activity, Class<?> cls,
                                                 String data, List<ChannelModel> titleId) {
        Intent intent = new Intent(activity, cls);
        intent.putExtra("data", data);
        intent.putExtra("listOne", (Serializable) titleId);

        activity.startActivity(intent);
    }

    /**
     * 启动Activity并传String数据 key:"data"
     *
     * @param activity 当前Activity
     * @param cls      要启动的Activity Class
     * @param data     String型数据
     * @param title    activity标题 String型数据
     */
    public static void startActivityForData(Activity activity, Class<?> cls,
                                            String data, String title) {
        Intent intent = new Intent(activity, cls);
        intent.putExtra("data", data);
        intent.putExtra("title", title);
        activity.startActivity(intent);
    }

    public static void startActivityForData(Activity activity, Class<?> cls,
                                            String data, String title, String type) {
        Intent intent = new Intent(activity, cls);
        intent.putExtra("data", data);
        intent.putExtra("title", title);
        intent.putExtra("type", type);
        activity.startActivity(intent);
    }

    /**
     * 启动Activity传String数据并接收返回结果 key:"data"
     *
     * @param activity 当前Activity
     * @param cls      要启动的Activity Class
     * @param data     String型数据
     * @param flag     int标记
     */
    public static void startActivityForResult(Activity activity, Class<?> cls,
                                              String data, int flag) {
        Intent intent = new Intent(activity, cls);
        intent.putExtra("data", data);
        intent.setFlags(flag);
        activity.startActivityForResult(intent, flag);
    }

    /**
     * 启动Activity并传序列化对象数据 key:"Serializable"
     *
     * @param activity 当前Activity
     * @param cls      要启动的Activity Class
     * @param data     String型数据
     */
    public static void startActivityForSerializable(Activity activity,
                                                    Class<?> cls, Serializable data) {
        Intent mIntent = new Intent(activity, cls);
        Bundle mBundle = new Bundle();
        mBundle.putSerializable("Serializable", data);
        mIntent.putExtras(mBundle);
        activity.startActivity(mIntent);
    }

    /**
     * 启动Activity并传String对象数据
     *
     * @param activity 当前Activity
     * @param name     key
     * @param cls      要启动的Activity Class
     * @param data     String数据
     */
    public static void startActivityForStringData(Context activity,
                                                  String name, Class<?> cls, String data) {
        Intent intent = new Intent(activity, cls);
        intent.putExtra(name, data);
        activity.startActivity(intent);
    }

    /**
     * 启动网络设置
     *
     * @param activity 当前Activity
     */
    public static void startSetNetActivity(Activity activity) {
        Intent intent = new Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS);
        activity.startActivity(intent);
    }

    /**
     * 启动系统设置
     *
     * @param activity 当前Activity
     */
    public static void startSetActivity(Activity activity) {
        Intent intent = new Intent(Settings.ACTION_SETTINGS);
        activity.startActivity(intent);
    }

    /**
     * 商家入驻专用跳转
     *
     * @param activity
     * @param cls
     * @param name
     * @param province
     * @param city
     * @param county
     * @param address_detail
     * @param phone
     * @param typeId
     */
    public static void startActivityShopInto(Activity activity, Class<?> cls, String name, String province, String city, String county, String address_detail, String phone, String typeId) {
        Intent intent = new Intent(activity, cls);
        intent.putExtra("name", name);
        intent.putExtra("province", province);
        intent.putExtra("city", city);
        intent.putExtra("county", county);
        intent.putExtra("address_detail", address_detail);
        intent.putExtra("phone", phone);
        intent.putExtra("typeId", typeId);
        activity.startActivity(intent);
    }
}
