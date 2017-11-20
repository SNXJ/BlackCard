package com.zsh.blackcard.api;

import android.content.Context;

import com.zsh.blackcard.R;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.untils.LogUtils;
import com.zsh.blackcard.untils.Md5Untils;
import com.zsh.blackcard.untils.UIUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * 网络请求
 */

public class DataManager {
    //http://192.168.1.108:8080/MVNFHM/apphomein/getrecommendlist?COMMEND
    public static String BASE_URL = "http://192.168.1.108:8080/ZSHINTER/";
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
        // sdf.format(new Date());
        return Md5Untils.md5(fn + sdf.format(new Date()) + FH);
    }

    public static String getMd5PassWord(String passWord){
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
                            LogUtils.i("++++++", "++++++++++onCompleted++++++++++++");
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

}
