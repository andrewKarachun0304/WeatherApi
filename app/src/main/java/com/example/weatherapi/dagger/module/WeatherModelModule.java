package com.example.weatherapi.dagger.module;

import com.example.weatherapi.model.WeatherModel;

import dagger.Module;
import dagger.Provides;

@Module
public class WeatherModelModule {

    @Provides
    WeatherModel providesWeatherModule(){
        return new WeatherModel();
    }
}
