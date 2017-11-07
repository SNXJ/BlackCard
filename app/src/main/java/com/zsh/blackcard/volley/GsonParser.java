package com.zsh.blackcard.volley;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * @author Sheng XiaoJie .
 * @Date 2016/12/2
 * @describe *
 */
public class GsonParser<T> {
    public T gsonString(String resStr, Class<T> clz) {
        JSONObject json = null;
        try {
            json = new JSONObject(resStr);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (json == null) {
            return null;
        }
        String result = json.toString();
        Gson gson = new Gson();
        return gson.fromJson(result, clz);
    }

    public T gsonJson(JSONObject jsobj, Class<T> clz) {
        Gson gson = new Gson();
        return gson.fromJson(jsobj.toString(), clz);
    }

    public List<T> gsonJsonArray(JSONArray jsobj, Class<T> clz) {
        Gson gson = new Gson();
        List<T> retList = gson.fromJson(jsobj.toString(),
                new TypeToken<List<T>>() {
                }.getType());
        return retList;
    }

}
