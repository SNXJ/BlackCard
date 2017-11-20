package com.zsh.blackcard.manager;

import android.content.Context;

import com.zsh.blackcard.R;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.LoginModel;
import com.zsh.blackcard.service.RetrofitService;
import com.zsh.blackcard.untils.LogUtils;
import com.zsh.blackcard.untils.RetrofitUtils;
import com.zsh.blackcard.untils.UIUtils;

import java.util.Map;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by kkkkk on 2017/11/20.
 * 所有的网络请求都写在此处，调用
 */

public class DataManager {
    public static String BASE_URL = "http://192.168.1.108:8080/MVNFHM/";
    private static RetrofitService retrofitService;
    private static Context context;
    private static DataManager instance;
    private CompositeSubscription compositeSubscription = new CompositeSubscription();

    public static DataManager getInstance(Context context) {
        retrofitService = RetrofitUtils.getInstance(context).getService();
        if (instance == null) {
            instance = new DataManager(context);
        }
        return instance;
    }

    private DataManager(Context mContext) {
        this.context = mContext;
    }

    //例如。getSearchBook是在RetrofitService接口中声明的接口类型，参数类型。
    //1.先在RetrofitService中声明接口方法。
    //2.在本类写出该方法。在外部调用
    public static Observable<LoginModel> getSearchBook(final Map<String, String> map) {
        return retrofitService.getSearchBook(map);
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
                        if (null != listener) {
                            listener.responSuccess(t);
                        }
                    }
                })));

    }

}
