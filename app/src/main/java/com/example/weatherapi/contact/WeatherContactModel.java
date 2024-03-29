package com.example.weatherapi.contact;

import android.content.Context;
import android.location.Location;

import com.example.weatherapi.pojo.location.LocationCord;
import com.example.weatherapi.pojo.weather.Weather;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface WeatherContactModel {
    void setWeatherContext(Context weatherContext);
    boolean isOnline();
    Observable<Location> location();
    Single<LocationCord> getCityKey(String q);
    Single<Weather> getWeather(String s);
}
