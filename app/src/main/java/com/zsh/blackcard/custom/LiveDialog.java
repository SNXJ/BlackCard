package com.zsh.blackcard.custom;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;

import com.zsh.blackcard.R;

/**
 * Name: LiveDialog
 * Author: Shing
 * Date: 2018/1/24 上午9:38
 * Description: 直播的弹窗
 */

public class LiveDialog extends PublicDialog {
    /**
     * 直播  美颜页面
     *
     * @param mContext
     */

    public static void liveBeautyDialog(final Activity mContext) {
        View view = LayoutInflater.from(mContext).inflate(
                R.layout.live_more_dialog_layout, null);
        final Dialog dialog = showDialogView(view, mContext);
    }

    /**
     * 直播  更多设置页面
     *
     * @param mContext
     */

    public static void liveMoreDialog(final Activity mContext) {
        View view = LayoutInflater.from(mContext).inflate(
                R.layout.live_more_dialog_layout, null);
        final Dialog dialog = showDialogView(view, mContext);
    }

    /**
     * 开启直播美颜设置
     *
     * @param mContext
     */

    public static void liveOpenBeautyDialog(final Activity mContext) {
        View view = LayoutInflater.from(mContext).inflate(
                R.layout.live_open_beauty_dialog_layout, null);
        final Dialog dialog = showDialogView(view, mContext);
    }
}
