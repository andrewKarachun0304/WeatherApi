package com.example.weatherapi.presenter;

import android.location.Location;

import com.example.weatherapi.contact.WeatherContactModel;
import com.example.weatherapi.contact.WeatherContactPresenter;
import com.example.weatherapi.model.WeatherModel;
import com.example.weatherapi.pojo.location.LocationCord;
import com.example.weatherapi.pojo.weather.Weather;
import com.example.weatherapi.view.WeatherActivity;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;

public class WeatherPresenter implements WeatherContactPresenter {

    private WeatherActivity view;
    private WeatherContactModel model;

    public void setView(WeatherActivity view, WeatherModel model) {
        this.view = view;
        this.model = model;
        model.setWeatherContext(view.getApplicationContext());
    }

    public void getLocation(){
        Observable<Location> locationObservable = model.location();
        locationObservable
                .flatMap(location -> Observable.just(location.getLatitude() + ", " + location.getLongitude()))
                .subscribe(s -> getWeather(s));
    }

    public void getWeather(String q){
        Single<LocationCord> locationSingle = model.getCityKey(q);
                    locationSingle
                            .flatMap(location ->{
                                view.initTextView(location.getLocalizedName() + ", " + location.getCountry().getLocalizedName());
                                return Single.just(location.getKey());
                            })
                            .flatMap((Function<String, Single<Weather>>) s -> model.getWeather(s))
                            .subscribe(weather -> view.initRecyclerView(weather));
    }
}