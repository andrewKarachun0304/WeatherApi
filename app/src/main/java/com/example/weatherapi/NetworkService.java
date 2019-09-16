package com.example.weatherapi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static final String URL = "http://dataservice.accuweather.com";
    public static NetworkService networkService;
    private Retrofit retrofit;

    public static NetworkService getInstance(){
        if (networkService == null)
            networkService = new NetworkService();
        return networkService;
    }

    private NetworkService(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .addInterceptor(interceptor);

        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client.build())
                .build();
    }

    public JSONPlaceHolderApi getJsonApi(){
        return retrofit.create(JSONPlaceHolderApi.class);
    }
}
