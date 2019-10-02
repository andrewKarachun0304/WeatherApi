package com.example.weatherapi.dagger.component;

import com.example.weatherapi.dagger.module.WeatherModelModule;
import com.example.weatherapi.dagger.module.WeatherPresenterModule;
import com.example.weatherapi.model.WeatherModel;
import com.example.weatherapi.presenter.WeatherPresenter;

import dagger.Component;

@Component(modules = {WeatherPresenterModule.class, WeatherModelModule.class})
public interface WeatherComponent {
    WeatherModel getWeatherModel();
    WeatherPresenter getWeatherPresenter();
}
