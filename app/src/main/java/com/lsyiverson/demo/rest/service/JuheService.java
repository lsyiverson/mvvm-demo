package com.lsyiverson.demo.rest.service;

import com.lsyiverson.demo.rest.model.juhe.MobileResponse;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

public interface JuheService {
    String BASE_URL = "http://apis.juhe.cn/";

    @GET("mobile/get")
    Observable<MobileResponse> getMobileAttribute(@Query("phone") String phone, @Query("key") String key);
}
