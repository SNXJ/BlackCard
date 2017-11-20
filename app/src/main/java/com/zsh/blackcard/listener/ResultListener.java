package com.zsh.blackcard.listener;

/**
 * Name: SelectDataListener
 * Author: SNXJ
 * Date: 2017-11-14
 * Description:描述：
 */
public interface ResultListener<T> {
    void responSuccess(T obj);

    void onCompleted();
}
