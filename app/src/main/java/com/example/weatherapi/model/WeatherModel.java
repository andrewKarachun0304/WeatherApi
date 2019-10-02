package com.example.weatherapi.model;

import android.content.Context;
import android.location.Location;

import com.example.weatherapi.NetworkService;
import com.example.weatherapi.contact.WeatherContactModel;

import com.example.weatherapi.dagger.component.DaggerRxLocationComponent;
import com.example.weatherapi.dagger.component.RxLocationComponent;
import com.example.weatherapi.dagger.module.ContextModule;
import com.example.weatherapi.dagger.module.RxLocationModules;
import com.example.weatherapi.pojo.location.LocationCord;
import com.example.weatherapi.pojo.weather.Weather;
import com.google.android.gms.location.LocationRequest;
import com.patloew.rxlocation.RxLocation;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class WeatherModel implements WeatherContactModel {

    private Context weatherContext;
    private static final String API = "MLMlNg7nnJrzxuCv4fAP8e2eD98ECtCE";
    private static final String LANGUAGE = "ru-ru";

    public void setWeatherContext(Context weatherContext) {
        this.weatherContext = weatherContext;
    }

    public Observable<Location> location(){
        RxLocationComponent component = DaggerRxLocationComponent
                .builder()
                .contextModule(new ContextModule(weatherContext))
                .build();

        RxLocation rxLocation = component.getLocation();

        LocationRequest locationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
//                .setInterval(20000);

        return rxLocation.location().updates(locationRequest);
    }

    public Single<LocationCord> getCityKey(String q){
       return NetworkService.getInstance().getJsonApi().getCityKeyWithApi(API, q, LANGUAGE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Weather> getWeather(String cityKey){
        return NetworkService.getInstance().getJsonApi().getWeatherWithApi(cityKey, API, LANGUAGE, true, true)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
