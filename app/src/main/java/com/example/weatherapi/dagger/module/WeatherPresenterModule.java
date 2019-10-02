package com.example.weatherapi.dagger.module;

import com.example.weatherapi.presenter.WeatherPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class WeatherPresenterModule {

    @Provides
    WeatherPresenter providesWeatherPresenter(){
        return new WeatherPresenter();
    }
}
