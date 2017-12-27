package com.zsh.blackcard.custom;

import android.app.Activity;
import android.app.Dialog;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.zsh.blackcard.R;
import com.zsh.blackcard.utils.CameraAndFileUtils;

/**
 * Name: ChooseImageDialog
 * Author: SNXJ
 * Date: 2017-12-02
 * Description:描述：
 */
public class ChooseImageDialog {


    public static void chooseImage(final Activity mContext, final Fragment f) {
        View view = LayoutInflater.from(mContext).inflate(
                R.layout.dialog_choose_image, null);
        TextView tv_cancle = (TextView) view.findViewById(R.id.tv_cancel);
        TextView tv_camera = (TextView) view.findViewById(R.id.tv_camera);
        TextView tv_file = (TextView) view.findViewById(R.id.tv_file);
        final Dialog dialog = PublicDialog.showDialogView(view, mContext);
        tv_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        tv_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //打开相机，拍照后裁剪
                CameraAndFileUtils.upHeadImage(mContext,f);
                dialog.dismiss();
            }
        });
        tv_file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //打开相册，此处为单选图片
                CameraAndFileUtils.upFileImage(mContext,f);
                dialog.dismiss();
            }
        });
    }

}
