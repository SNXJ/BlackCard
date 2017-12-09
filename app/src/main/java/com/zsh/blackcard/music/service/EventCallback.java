package com.zsh.blackcard.music.service;


public interface EventCallback<T> {
    void onEvent(T t);
}
