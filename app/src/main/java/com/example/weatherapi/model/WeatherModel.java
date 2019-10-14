package com.example.weatherapi.model;

import android.content.Context;
import android.location.Location;

import com.example.weatherapi.JSONPlaceHolderApi;
import com.example.weatherapi.contact.WeatherContactModel;

import com.example.weatherapi.dagger.component.DaggerRetrofitComponent;
import com.example.weatherapi.dagger.component.DaggerRxLocationComponent;
import com.example.weatherapi.dagger.component.RetrofitComponent;
import com.example.weatherapi.dagger.component.RxLocationComponent;
import com.example.weatherapi.dagger.module.ContextModule;
import com.example.weatherapi.pojo.location.LocationCord;
import com.example.weatherapi.pojo.weather.Weather;
import com.google.android.gms.location.LocationRequest;
import com.patloew.rxlocation.RxLocation;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;


public class WeatherModel implements WeatherContactModel {

    private Context weatherContext;
    private static final String API = "4GCKKDbYPlWgpPZWbzSywGWBvOzGtjEA";
    private static final String LANGUAGE = "ru-ru";
    private JSONPlaceHolderApi holderApi;

    public void initRetrofit(){
        RetrofitComponent retrofitComponent = DaggerRetrofitComponent.create();
        Retrofit retrofit = retrofitComponent.getRetrofit();

        holderApi = retrofit.create(JSONPlaceHolderApi.class);
    }

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

        return rxLocation.location().updates(locationRequest);
    }

    public Single<LocationCord> getCityKey(String q){
       return holderApi.getCityKeyWithApi(API, q, LANGUAGE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Weather> getWeather(String cityKey){
        return holderApi.getWeatherWithApi(cityKey, API, LANGUAGE, true, true)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
