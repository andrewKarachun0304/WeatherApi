package com.example.weatherapi.model;

import android.content.Context;

import com.example.weatherapi.MyLocation;

public class WeatherModel {

    private Context weatherContext;
    private MyLocation location;

    public void setWeatherContext(Context weatherContext) {
        this.weatherContext = weatherContext;
    }
}
