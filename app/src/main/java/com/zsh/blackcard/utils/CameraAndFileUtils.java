package com.zsh.blackcard.utils;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;

/**
 * Created by kkkkk on 2017/12/9.
 * 拍照和相册工具类
 */

public class CameraAndFileUtils {

    //打开相机上传图片，并且拍照后裁剪
    public static void upHeadImage(final Activity mContext, final Fragment f) {
        PictureSelector.create(f)
                .openCamera(PictureMimeType.ofImage())
                .enableCrop(true)
                .selectionMode(PictureConfig.SINGLE)
                .forResult(PhotoUtils.GET_IMAGE_BY_CAMERA);
    }

    //打开相册，单选图片，适用于上传头像，可裁剪
    public static void upFileImage(final Activity mContext, final Fragment f){
        PictureSelector.create(f)
                .openGallery(PictureMimeType.ofImage())
                .enableCrop(true)
                .selectionMode(PictureConfig.SINGLE)
                .forResult(PhotoUtils.GET_IMAGE_FROM_PHONE);
    }
}
