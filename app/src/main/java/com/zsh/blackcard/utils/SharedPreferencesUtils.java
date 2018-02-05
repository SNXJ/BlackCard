package com.zsh.blackcard.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.zsh.blackcard.BaseApplication;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


/**
 * @author sxj
 * @ClassName: SharedPreferencesUtils
 */
public class SharedPreferencesUtils {
    public static final String CONFIG = "config";
    private static SharedPreferences sharedPreferences;

    //private static SharedPreferences ;
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
            SharedPreferencesUtils.clearObjectData(
                    BaseApplication.getApplication(), sp);
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

    /**
     * 保存user
     *
     * @param context
     * @param user
     */
//    public static void putUser(Context context, User user) {
//        Gson gson = new Gson();
//        String value = gson.toJson(user);
//        if (sharedPreferences == null) {
//            sharedPreferences = context.getSharedPreferences(CONFIG,
//                    Context.MODE_PRIVATE);
//        }
//        sharedPreferences.edit().putString("user", value).commit();
//    }

    /**
     * 获取user
     *
     * @param context
     * @return
     */
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

    /**
     * 获得sp实例
     *
     * @param context
     * @param config
     * @return
     */
    public static SharedPreferences getInstance(Context context, String config) {
        return context.getSharedPreferences(config,
                Context.MODE_PRIVATE);
    }


    /**
     * 保存List
     *
     * @param tag
     * @param datalist
     */
    public static <T> void saveDataList(Context context, String tag, List<T> datalist) {
        if (null == datalist || datalist.size() <= 0)
            return;
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(CONFIG,
                    Context.MODE_PRIVATE);
        }
        Gson gson = new Gson();
        //转换成json数据，再保存
        String strJson = gson.toJson(datalist);

        sharedPreferences.edit().putString(tag, strJson).commit();


    }

    /**
     * 获取List
     *
     * @param tag
     * @return
     */
    public static <T> List<T> getDataList(Context context, String tag, Class clazz) {
        List<T> datalist = new ArrayList<T>();
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(CONFIG,
                    Context.MODE_PRIVATE);
        }
        String strJson = sharedPreferences.getString(tag, null);

        if (null == strJson) {
            return datalist;
        }
        return jsonToArrayList(strJson, clazz);

    }

    public static <T> ArrayList<T> jsonToArrayList(String json, Class<T> clazz) {
        Type type = new TypeToken<ArrayList<JsonObject>>() {
        }.getType();
        ArrayList<JsonObject> jsonObjects = new Gson().fromJson(json, type);

        ArrayList<T> arrayList = new ArrayList<>();
        for (JsonObject jsonObject : jsonObjects) {
            arrayList.add(new Gson().fromJson(jsonObject, clazz));
        }
        return arrayList;
    }
}
