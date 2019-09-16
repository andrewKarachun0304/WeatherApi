package com.example.weatherapi.contact;

import android.content.Context;

import com.example.weatherapi.pojo.location.Location;

import io.reactivex.Single;

public interface WeatherContactModel {
    void setWeatherContext(Context weatherContext);
    void location();
    Single<Location> getCityKey();
}
