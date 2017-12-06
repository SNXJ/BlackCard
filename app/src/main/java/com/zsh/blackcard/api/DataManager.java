package com.zsh.blackcard.api;

import android.content.Context;

import com.zsh.blackcard.R;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.untils.LogUtils;
import com.zsh.blackcard.untils.Md5Untils;
import com.zsh.blackcard.untils.UIUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * 网络请求
 */

public class DataManager {
    //   public static String BASE_URL = "http://192.168.1.108:8080/ZSHINTER/";
    public static String BASE_URL = "http://192.168.1.134:8081/ZSHINTER/";//振华
    //    public static String BASE_URL = "http://47.104.16.215:8080/ZSHINTER/";//阿里云
//    public static String APP_CHANNEL = "SUN_TEST";
    public static String APP_CHANNEL = "DEV_TEST";
    public static String FH = ",fh,";
    private static Context context;
    private static DataManager instance;
    private CompositeSubscription compositeSubscription = new CompositeSubscription();

    public static DataManager getInstance(Context context) {
        if (instance == null) {
            instance = new DataManager(context);
        }
        return instance;
    }

    private DataManager(Context mContext) {
        this.context = mContext;
    }


    public static String getMd5Str(String fn) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.CHINA);
        return Md5Untils.md5(fn + sdf.format(new Date()) + FH);
    }

    public static String getMd5PassWord(String passWord) {
        return Md5Untils.md5(passWord);
    }

    /**
     * 请求
     *
     * @param obs
     * @param listener
     * @param <T>
     */
    public <T> void RequestHttp(Observable<T> obs, final ResultListener<T> listener) {
        compositeSubscription.add((obs
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<T>() {
                    @Override
                    public void onCompleted() {
                        if (null != listener) {
                            listener.onCompleted();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.i("++++++", "++++++++++e++++++++++++" + e.toString());
                        UIUtils.showToast(context.getResources().getString(R.string.generic_server_down));
                    }

                    @Override
                    public void onNext(T t) {
                        if (null != listener && null != t) {
                            listener.responseSuccess(t);
                        }
                    }
                })));
    }

    /**
     * 初始化builder
     *
     * @return
     */
    public static MultipartBody.Builder initMultBuilder() {
        MultipartBody.Builder builder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM);//表单类型
        return builder;
    }

    /**
     * builde设置参数
     *
     * @param builder
     * @param imgPath
     * @param imgKey
     * @return
     */
    public static MultipartBody.Builder getMultBuilder(MultipartBody.Builder builder, String imgPath, String imgKey) {
        File file = new File(imgPath);//filePath 图片地址
        RequestBody imageBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        builder.addFormDataPart(imgKey, file.getName(), imageBody);
        return builder;
    }

    /**
     * Part
     *
     * @param builder
     * @return
     */
    public static MultipartBody.Part getMultiPart(MultipartBody.Builder builder) {
        MultipartBody.Part part = builder.build().part(0);
        return part;
    }

    /**
     * PartList
     *
     * @param builder
     * @return
     */
    public static List<MultipartBody.Part> getMultiPartList(MultipartBody.Builder builder) {
        List<MultipartBody.Part> parts = builder.build().parts();
        return parts;
    }

//       public Observable<ResultModel> upLoadListIMG(String md5, String userId, List<String> pathList) {
//        MultipartBody.Builder builder = new MultipartBody.Builder()
//                .setType(MultipartBody.FORM);//表单类型
//        //多张图片
//        for (int i = 0; i < pathList.size(); i++) {
//            File file = new File(pathList.get(i));//filePath 图片地址
//            RequestBody imageBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//            builder.addFormDataPart("showfile", file.getName(), imageBody);//"showfile 后台接收图片流的参数名（每张应该不同）
//        }
//        List<MultipartBody.Part> parts = builder.build().parts();
//           return retrofitService.uploadListIMG(md5, userId, parts);
//      }

}
