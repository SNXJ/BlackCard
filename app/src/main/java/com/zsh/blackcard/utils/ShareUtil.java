package com.zsh.blackcard.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMEmoji;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.media.UMusic;
import com.zsh.blackcard.R;

/**
 * @author SXJ
 * @date 2016-9-18 上午10:13:13
 * @description Umeng分享
 */
public class ShareUtil {
    private static String shareTitle;
    private static String descContent;
    private static String lineLink;
    //private static UMShareListener umShareListener;
    private static Context context;

    private static String WX_ID = "wx967daebe835fbeac";
    private static String WX_KEY = "5bb696d9ccd75a38c8a0bfe0675559b3";
    private static String QQ_ID = "100424468";
    private static String QQ_KEY = "c7394704798a158208a74ab60104f0ba";
    private static String SINA_ID = "3921700954";
    private static String SINA_KEY = "04b48b094faeb16683c32669824ebdad";
    private static String SINA_URL = "http://sns.whalecloud.com";

    public static void initShare(Context thisContext) {
        context = thisContext;

    }

    /**
     * 初始化各个平台Key以及um初始化(Application中调用)
     */
    public static void initSharePlatformKey(Context context) {
        Config.DEBUG = true;
        PlatformConfig.setWeixin(WX_ID, WX_KEY);
        PlatformConfig.setQQZone(QQ_ID, QQ_KEY);
        PlatformConfig.setSinaWeibo(SINA_ID, SINA_KEY, SINA_URL);
        UMShareAPI.get(context);


    }

    /**
     * UM分享activity的onActivityResult调用
     *
     * @param requestCode
     * @param resultCode
     * @param data        注意onActivityResult不可在fragment中实现，如果在fragment中调用登录或分享，需要在fragment依赖的Activity中实现
     */
    public static void onUmActivityResult(int requestCode, int resultCode,
                                          Intent data) {
        UMShareAPI.get(context).onActivityResult(requestCode, resultCode, data);

    }
//    内存泄露处理方法
//   @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        UMShareAPI.get(this).release();
//    }

////	***********************以上两个方法必须调用  方可调用以下分享*******************************


    /**
     * 申请权限
     */
    private static void requestPermissions(final Context mcontext) {
        String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE, Manifest.permission.READ_LOGS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP, Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.GET_ACCOUNTS, Manifest.permission.WRITE_APN_SETTINGS};

        MPermissionUtils.requestPermissionsResult((Activity) mcontext, 1, mPermissionList
                , new MPermissionUtils.OnPermissionListener() {
                    @Override
                    public void onPermissionGranted() {
                        //TODO
                    }

                    @Override
                    public void onPermissionDenied() {
                        MPermissionUtils.showTipsDialog(mcontext);
                    }
                });

    }

    /**
     * 默认面板
     */
    public static void deauShare() {
        new ShareAction((Activity) context)
                .withText("hello")
                .setDisplayList(SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE, SHARE_MEDIA.SINA, SHARE_MEDIA.MORE)
                .setCallback(umShareListener)
                .open();
    }


    /**
     * QQ不支持纯文本
     */
    private void shareText() {
        new ShareAction((Activity) context)
                .setPlatform(SHARE_MEDIA.QQ)//传入平台
                .withText("hello")//分享内容
                .setCallback(umShareListener)//回调监听器
                .share();

    }


    private void shareImg() {
        UMImage image = new UMImage((Activity) context, "imageurl");//网络图片
        //        UMImage image = new UMImage((Activity) context, file);//本地文件
        //        UMImage image = new UMImage((Activity) context, R.drawable.xxx);//资源文件
        //        UMImage image = new UMImage((Activity) context, bitmap);//bitmap文件
        //        UMImage image = new UMImage((Activity) context.this, byte[]);//字节流

        image.compressStyle = UMImage.CompressStyle.QUALITY;//质量压缩，适合长图的分享
        new ShareAction((Activity) context).withText("hello").withMedia(image).share();
    }

    /**
     * 只有微信好友支持表情
     */
    private void shareGif() {
        UMEmoji emoji = new UMEmoji(context,"http://img5.imgtn.bdimg.com/it/u=2749190246,3857616763&fm=21&gp=0.jpg");
        emoji.setThumb(new UMImage(context, R.drawable.arrow_down));
        new ShareAction((Activity)context)
                .withMedia(emoji)
                .share();
    }

    private void shareUrl(String url) {
        UMWeb web = new UMWeb(url);
        web.setTitle("This is music title");//标题
//        web.setThumb(thumb);  //缩略图
        web.setDescription("my description");//描述

        new ShareAction((Activity) context)
                .withMedia(web)
                .share();
    }


    private void shareVideo(String videourl) {
        UMVideo video = new UMVideo(videourl);
        video.setTitle("This is music title");//视频的标题
        //video.setThumb("http://www.umeng.com/images/pic/social/chart_1.png");//视频的缩略图
        video.setDescription("my description");//视频的描述
        new ShareAction((Activity) context).withText("hello").withMedia(video).share();

    }

    private void shareMusic(String url) {
        UMusic music = new UMusic(url);//音乐的播放链接
        music.setTitle("This is music title");//音乐的标题
//        music.setThumb("http://www.umeng.com/images/pic/social/chart_1.png");//音乐的缩略图
        music.setDescription("my description");//音乐的描述
        music.setmTargetUrl(url);//音乐的跳转链接
        new ShareAction((Activity)context)
                .withMedia(music)
                .share();

    }


    private static UMShareListener umShareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(context, "成功了", Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(context, "失败" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(context, "取消了", Toast.LENGTH_LONG).show();

        }
    };

}
