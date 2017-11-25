package com.zsh.blackcard.api;

import android.content.Context;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kkkkk on 2017/11/20.
 * 网络请求工具类。
 */

public class RetrofitUtils {
    private Context mContext;
    OkHttpClient.Builder builder = new OkHttpClient.Builder();

    GsonConverterFactory factory = GsonConverterFactory.create(new GsonBuilder().create());
    private static RetrofitUtils instance = null;
    private Retrofit mRetrofit = null;

    public static RetrofitUtils getInstance(Context context) {
        if (instance == null) {
            instance = new RetrofitUtils(context);
        }
        return instance;
    }

    private RetrofitUtils(Context mContext) {
        this.mContext = mContext;
        init();
    }

    private void init() {
        resetApp();
    }


    private void resetApp() {
        builder.addInterceptor(new LoggingInterceptor());
        OkHttpClient okHttpClient = builder.build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(DataManager.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(factory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public RetrofitService getService() {

        return mRetrofit.create(RetrofitService.class);
    }
}
