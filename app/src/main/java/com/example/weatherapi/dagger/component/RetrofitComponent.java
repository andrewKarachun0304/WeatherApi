package com.example.weatherapi.dagger.component;

import com.example.weatherapi.dagger.module.RetrofitModule;

import dagger.Component;
import retrofit2.Retrofit;

@Component(modules = RetrofitModule.class)
public interface RetrofitComponent {
    Retrofit getRetrofit();
}
