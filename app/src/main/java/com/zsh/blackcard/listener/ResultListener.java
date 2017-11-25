package com.zsh.blackcard.listener;

/**
 * Name: SelectDateListener
 * Author: SNXJ
 * Date: 2017-11-14
 * Description:描述：
 */
public interface ResultListener<T> {
    void responseSuccess(T obj);

    void onCompleted();
}
