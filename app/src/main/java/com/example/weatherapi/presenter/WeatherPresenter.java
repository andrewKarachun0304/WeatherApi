package com.example.weatherapi.presenter;

import android.content.Context;

import com.example.weatherapi.model.WeatherModel;
import com.example.weatherapi.view.WeatherActivity;

public class WeatherPresenter {

    private WeatherActivity view;
    private WeatherModel model;

    public void setView(WeatherActivity view) {
        this.view = view;
    }
}
