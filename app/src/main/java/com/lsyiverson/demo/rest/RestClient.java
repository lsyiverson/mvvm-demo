package com.lsyiverson.demo.rest;

import com.lsyiverson.demo.rest.service.JuheService;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

public class RestClient {

    public static JuheService getJuheService() {
        return new Retrofit.Builder()
                .baseUrl(JuheService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build().create(JuheService.class);
    }
}
