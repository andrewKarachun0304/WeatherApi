package com.example.weatherapi.dagger.module;

import com.example.weatherapi.JSONPlaceHolderApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {

    @Provides
    public Retrofit providesRetrofit(OkHttpClient client, GsonConverterFactory gsonConverterFactory, RxJava2CallAdapterFactory adapterFactory){
        return new Retrofit.Builder()
                .baseUrl("http://dataservice.accuweather.com")
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(adapterFactory)
                .client(client)
                .build();

    }

    @Provides
    public OkHttpClient providesClient(HttpLoggingInterceptor interceptor){
        return new OkHttpClient()
                .newBuilder()
                .addInterceptor(interceptor)
                .build();
    }

    @Provides
    public HttpLoggingInterceptor providesInterceptor(){
        return new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    public GsonConverterFactory gsonConverterFactory(){
        return GsonConverterFactory.create();
    }

    @Provides
    public RxJava2CallAdapterFactory adapterFactory(){
        return RxJava2CallAdapterFactory.create();
    }
}
