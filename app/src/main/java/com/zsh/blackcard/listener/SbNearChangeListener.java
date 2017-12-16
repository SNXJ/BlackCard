package com.zsh.blackcard.listener;

import android.app.Dialog;

import com.zsh.blackcard.model.SbNearChangeModel;

/**
 * Created by kkkkk on 2017/12/12.
 * 尚播附近筛选主播Dialog回调接口
 */

public interface SbNearChangeListener {
    void onClick(SbNearChangeModel sbNearChangeModel, Dialog dialog);
}
