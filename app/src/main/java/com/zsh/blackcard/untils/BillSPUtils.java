package com.zsh.blackcard.untils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.zsh.blackcard.BaseApplication;


/**
 * @author ZHANG
 * @ClassName: SharedPreferencesUtils
 */
public class BillSPUtils {
    public static final String CONFIG = BillSPConstants.SP_MAME;
    private static SharedPreferences sharedPreferences;

    /*
     * 保存 object 类型的json数据
     */
    public static void saveObjectData(Context context, String key, Object obj) {
        Gson gson = new Gson();
        String value = gson.toJson(obj);
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(CONFIG,
                    Context.MODE_PRIVATE);
        }
        sharedPreferences.edit().putString(key, value).commit();
    }

    /*
     * 清除 object 类型的json数据
     */
    public static void clearObjectData(Context context, String key) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(CONFIG,
                    Context.MODE_PRIVATE);
        }
        sharedPreferences.edit().putString(key, null).commit();
    }

    /**
     * 根据sp的key清空对应key的数据
     *
     * @param context
     * @param key     需要清空的key
     */
    public static void removeByName(Context context, String key) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
        }
        sharedPreferences.edit().remove(key).commit();
    }

    /**
     * 根据sp的key清空sp的所有数据
     *
     * @param context
     * @param key
     */
    public static void clearAllSP(Context context, String key) {
        context.getSharedPreferences(key, Context.MODE_PRIVATE).edit().clear()
                .commit();
    }

    /*
     * 清除 object 类型的json数据
     */
    public static void clearObjectData(String[] result) {
        for (String sp : result) {
            BillSPUtils.clearObjectData(BaseApplication.getApplication(), sp);
        }
    }

    /*
     * 获取 object 类型的json数据
     */
    public static Object getObjectData(Context context, String key, Class<?> cls) {
        Gson gson = new Gson();
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(CONFIG,
                    Context.MODE_PRIVATE);
        }
        String value = sharedPreferences.getString(key, "");
        if (TextUtils.isEmpty(value)) {
            return null;
        }
        return gson.fromJson(value, cls);
    }

    /*
     * 获取 ListObject类型的json数据
     */
    public static Object getListObjectData(Context context, String key,
                                           Class<?> cls) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(CONFIG,
                    Context.MODE_PRIVATE);
        }
        String value = sharedPreferences.getString(key, "");
        if (TextUtils.isEmpty(value)) {
            return null;
        }
        return JSON.parseArray(value, cls);
    }

    /*
     * 保存 String 类型的数据
     */
    public static void putStringData(Context context, String key, String value) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(CONFIG,
                    Context.MODE_PRIVATE);
        }
        sharedPreferences.edit().putString(key, value).commit();
    }

    /*
     * 获取 String 类型的数据
     */
    public static String getStringData(Context context, String key,
                                       String defValue) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(CONFIG,
                    Context.MODE_PRIVATE);
        }
        return sharedPreferences.getString(key, defValue);
    }

    /*
     * 保存 int 类型的数据
     */
    public static void putIntData(Context context, String key, int value) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(CONFIG,
                    Context.MODE_PRIVATE);
        }
        sharedPreferences.edit().putInt(key, value).commit();
    }

    /*
     * 获取 int 类型的数据
     */
    public static int getIntData(Context context, String key, int defValue) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(CONFIG,
                    Context.MODE_PRIVATE);
        }
        return sharedPreferences.getInt(key, defValue);
    }

    /*
     * 保存 boolean 类型的数据
     */
    public static void putBooleanData(Context context, String key, boolean value) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(CONFIG,
                    Context.MODE_PRIVATE);
        }
        sharedPreferences.edit().putBoolean(key, value).commit();
    }

    /*
     * 获取 boolean 类型的数据
     */
    public static boolean getBooleanData(Context context, String key,
                                         boolean defValue) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(CONFIG,
                    Context.MODE_PRIVATE);
        }
        return sharedPreferences.getBoolean(key, defValue);
    }

    /*
     * 保存 float 类型的数据
     */
    public static void putFloatData(Context context, String key, float value) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(CONFIG,
                    Context.MODE_PRIVATE);
        }
        sharedPreferences.edit().putFloat(key, value).commit();
    }

    /*
     * 获取 float 类型的数据
     */
    public static float getFloatData(Context context, String key, float defValue) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(CONFIG,
                    Context.MODE_PRIVATE);
        }
        return sharedPreferences.getFloat(key, defValue);
    }

//    /**
//     * 保存user
//     *
//     * @param context
//     * @param user
//     */
//    public static void putUser(Context context, User user) {
//        Gson gson = new Gson();
//        String value = gson.toJson(user);
//        if (sharedPreferences == null) {
//            sharedPreferences = context.getSharedPreferences(CONFIG,
//                    Context.MODE_PRIVATE);
//        }
//        sharedPreferences.edit().putString("user", value).commit();
//    }
//
//    /**
//     * 获取user
//     *
//     * @param context
//     * @return
//     */
//    public static User getUser(Context context) {
//        Gson gson = new Gson();
//        if (sharedPreferences == null) {
//            sharedPreferences = context.getSharedPreferences(CONFIG,
//                    Context.MODE_PRIVATE);
//        }
//        String value = sharedPreferences.getString("user", "");
//        if (TextUtils.isEmpty(value)) {
//            return null;
//        }
//        return gson.fromJson(value, User.class);
//    }

}
