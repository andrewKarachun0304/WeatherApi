package com.example.weatherapi.contact;

import android.content.Context;
import android.location.Location;

import com.example.weatherapi.pojo.location.LocationCord;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface WeatherContactModel {
    void setWeatherContext(Context weatherContext);
    Observable<Location> location();
    Single<LocationCord> getCityKey(String q);
}
