package com.example.weatherapi.contact;

import com.example.weatherapi.model.WeatherModel;
import com.example.weatherapi.view.WeatherActivity;

public interface WeatherContactPresenter {

    void setView(WeatherActivity view, WeatherModel model);
    void getLocation();
}
