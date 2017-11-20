package com.zsh.blackcard.service;

import com.zsh.blackcard.model.UserModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by kkkkk on 2017/11/20.
 */

public interface RetrofitService {

    @GET("book/search")
    Observable<UserModel> getSearchBook(@Query("q") String name,
                                        @Query("tag") String tag);
}
