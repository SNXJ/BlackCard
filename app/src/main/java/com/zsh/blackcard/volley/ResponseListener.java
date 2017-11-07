package com.zsh.blackcard.volley;

/**
 * @author Sheng XiaoJie .
 * @Date 2016/12/2
 * @describe *
 */
public interface ResponseListener<T> {
    void responSuccess(T obj);
    // void resonError(VolleyError error);
}
