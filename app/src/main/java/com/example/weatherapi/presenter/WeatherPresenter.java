package com.example.weatherapi.presenter;

import android.location.Location;
import android.util.Log;

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
    private WeatherModel model;

    public void setView(WeatherActivity view) {
        this.view = view;
        model = new WeatherModel();
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
                            .flatMap(location -> Single.just(location.getKey()))
                            .flatMap(new Function<String, Single<Weather>>() {
                                @Override
                                public Single<Weather> apply(String s) throws Exception {
                                    return model.getWeather(s);
                                }
                            })
                            .subscribe(weather -> view.initRecyclerView(weather));
    }
}