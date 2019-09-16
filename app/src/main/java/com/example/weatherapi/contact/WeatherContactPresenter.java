package com.example.weatherapi.contact;

import com.example.weatherapi.view.WeatherActivity;

public interface WeatherContactPresenter {

    void setView(WeatherActivity view);
    void getLocation();
}
